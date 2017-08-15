/**
 * Created by ydlx on 2017/6/1.
 */
var tableReload,toEdit,toDel;
$(document).ready(function(){
    var sysId=$("#sysId").val();
    $.jgrid.defaults.styleUI="Bootstrap";
    $("#table_list_2").jqGrid({
        url: $path_base+'pri/'+sysId+'/getListByPage',
        mtype: 'POST',
        datatype : 'json',
        postData: {},
        height:450,
        autowidth:true,
        shrinkToFit:true,
        rowNum:20,
        rowList:[10,20,30],
        colNames:["权限ID","权限编码","权限名称","权限描述","创建时间","更新时间","操作员","操作"],
        colModel:[
            {name:"priId",sysId:"priId",editable:true,sorttype:"int",hidden:true},
            {name:"priCode",index:"priCode",editable:false,align:"left"},
            {name:"priName",index:"priName",editable:false,align:"left"},
            {name:"priDesc",index:"priDesc",editable:false,align:"left"},
            {name:"createTime",index:"createTime",editable:false,align:"left",sorttype:"date",formatter : function(cellvalue, options, rowObject) {return $.hd_jqGrid.dateTimeFormatter(cellvalue); } },
            {name:"updateTime",index:"updateTime",editable:false,align:"left",sorttype:"date",formatter : function(cellvalue, options, rowObject) {return $.hd_jqGrid.dateTimeFormatter(cellvalue); }},
            {name:"operator",index:"operator",editable:false,align:"left"},
            {name:"act",index:"act",editable:false,sortable:false}
        ],
        pager:"#pager_list_2",
        viewrecords:true,
        caption:"权限列表",
        add:true,
        edit:true,
        addtext:"Add",
        edittext:"Edit",
        hidegrid:false,
        jsonReader : {
            id: "id",
            root: 'content',
            page: 'number',
            total: 'totalPages',
            records: 'totalElements',
            repeatitems: false
        },
        gridComplete: function(){
            var ids = $(this).getDataIDs();
            for(var i=0;i<ids.length;i++){
                var cl = ids[i], enable = $(this).jqGrid('getCell',cl,4);
                $(this).jqGrid('setRowData',ids[i],{enable:getState(enable)});
                var btn = new Array();
                btn.push("<a style='margin-right: 5px;display: inline-block' onclick='toEdit("+cl+");'><i class='fa fa-edit'></i> 编辑 </a>");
                btn.push("<a style='margin-right: 5px;display: inline-block' onclick='toDel("+cl+")'><i class='fa fa-times'></i> 删除 </a>");
                jQuery(this).jqGrid('setRowData',ids[i],{act:btn.join("")});
            }
        }
    });
    $("#table_list_2").jqGrid("navGrid","#pager_list_2",{edit:true,add:true,del:true,search:true},{height:200,reloadAfterSubmit:true});
    $(window).bind("resize",function(){
        var width=$(".jqGrid_wrapper").width();
        $("#table_list_2").setGridWidth(width)
    });

    //
    // /**获取权限字典*/
    // $.ajax({
    //     type: 'POST',
    //     url: $path_base + 'sys/getSysDict',
    //     success: function (data) {
    //         $.each(data.data,function (k,item) {
    //             $("#sysId").append("<option value='"+item.sysId+"'>"+item.sysName+"</option>");
    //         });
    //
    //     },
    //     error: function () {
    //         console.log("错误");
    //     }
    // });

    /**
     * 权限信息管理--查询
     */
    $("#btn_search").click(function(){
        var postData = new Object();
        postData.sysName = $("#priName").val();
        postData.sysCode = $("#priCode").val();
        tableReload(postData);
    });

    /**
     * 添加权限信息--提交
     */
    $("#btn_add").click(function(){
        var postData = new Object(), sysId=$("#sysId").val();
        postData.priCode = $("#addPriCode").val();
        postData.priName = $("#addPriName").val();
        postData.priDesc = $("#addPriDesc").val();
        /**提交权限添加*/
        $.ajax({
            type: 'POST',
            url: $path_base + 'pri/'+sysId+'/add',
            data: postData,
            type:'post',
            dataType:'json',
            success: function (data) {
                if(data.resultCode=='0000'){
                    swal({title:"太帅了",text:"权限信息添加成功",type:"success"},function () {
                        $("#add_modal").modal('hide');
                        tableReload();
                    });
                }else{
                    swal({title:"人品不好",text: data.resultDesc,type:"error"});
                }
            },
            error: function () {
                swal({title:"人品不好",text:"权限错误",type:"error"});
            }
        });
    });

    /**
     * 更新权限信息--提交
     */
    $("#btn_edit").click(function(){
        var postData = new Object(), editPriId=$("#editPriId").val();
        postData.priCode = $("#editPriCode").val();
        postData.priName = $("#editPriName").val();
        postData.priDesc = $("#editPriDesc").val();
        /**提交权限添加*/
        $.ajax({
            type: 'POST',
            url: $path_base + 'pri/'+sysId+'/'+editPriId+'/update',
            data: postData,
            type:'post',
            dataType:'json',
            success: function (data) {
                if(data.resultCode=='0000'){
                    swal({title:"太帅了",text:"更新权限信息成功",type:"success"},function () {
                        $("#edit_modal").modal('hide');
                        tableReload();
                    });
                }else{
                    swal({title:"人品不好",text: data.resultDesc,type:"error"});
                }
            },
            error: function () {
                swal({title:"人品不好",text:"权限错误",type:"error"});
            }
        });
    });
    /***
     * 获取状态值
     */
    var getState = function(state){
        if(state==1) return "正常";
        else return "禁用";
    }

    /**
     * 重新加载表格数据
     * @param postData 查询参数
     */
    tableReload = function(postData){
        $("#table_list_2").clearGridData();
        $("#table_list_2").jqGrid('setGridParam', {
            url: $path_base + 'pri/'+sysId+'/getListByPage',
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            mtype: 'POST',
            datatype : 'json',
            postData: postData,
            gridComplete: function(){
                var ids = $(this).getDataIDs();
                for(var i=0;i<ids.length;i++){
                    var cl = ids[i];
                    var btn = new Array();
                    btn.push("<a style='margin-right: 5px;display: inline-block'  onclick='toEdit("+cl+");'><i class='fa fa-edit'></i> 编辑 </a>");
                    btn.push("<a style='margin-right: 5px;display: inline-block' onclick='toDel("+cl+")'><i class='fa fa-times'></i> 删除 </a>");
                    jQuery(this).jqGrid('setRowData',ids[i],{act:btn.join("")});
                }
            }
        }).trigger('reloadGrid');
    }

    /***
     * 编辑权限信息--填充权限信息
     */
    toEdit = function (id) {
        $("#editPriId").val($("#table_list_2").jqGrid('getCell',id,0));
        $("#editPriCode").val($("#table_list_2").jqGrid('getCell',id,1));
        $("#editPriName").val($("#table_list_2").jqGrid('getCell',id,2));
        $("#editPriDesc").val($("#table_list_2").jqGrid('getCell',id,3));
        $("#edit_modal").modal('show');
    }

    /***
     * 移除信息
     */
    toDel = function (id) {
        var delPriId= $("#table_list_2").jqGrid('getCell',id,0);
        var priName = $("#table_list_2").jqGrid('getCell',id,2);
        swal({
                title:"您确定要移除权限：" + priName,
                text:"删除后将无法恢复，请谨慎操作！",
                type:"warning",
                showCancelButton:true,
                confirmButtonColor:"#DD6B55",
                confirmButtonText:"是的，我要删除！",
                cancelButtonText:"让我再考虑一下…",
                closeOnConfirm:false,
                closeOnCancel:false
            },
            function(isConfirm){
                if(isConfirm){
                    $.ajax({
                        type: 'POST',
                        url: $path_base + 'pri/'+sysId+'/'+delPriId+'/delete',
                        type:'post',
                        dataType:'json',
                        success: function (data) {
                            if(data.resultCode=='0000'){
                                swal({title:"太帅了",text:"权限删除成功",type:"success"},function () {
                                    tableReload();
                                });
                            }else{
                                swal({title:"人品不好",text: data.resultDesc,type:"error"});
                            }
                        },
                        error: function () {
                            swal({title:"人品不好",text:"权限错误",type:"error"});
                        }
                    });
                }else{
                    swal("已取消","您取消了删除操作！","error")
                }
            });
    }

    /**
     * 重置查询条件
     */
    $("#btn_reset").click(function () {
        $("#priCode").val('');
        $('#priName').val('');
    });

    /**
     * 清空数据
     */
    $("#to_add").click(function () {
        $("#add_modal input[type='text']").each(function(){
            $(this).val('');
        });
    });

});

