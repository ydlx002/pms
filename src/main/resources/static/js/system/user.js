/**
 * Created by ydlx on 2017/6/1.
 */
var tableReload,toEdit,toDel;
$(document).ready(function(){
    var sysId=$("#sysId").val();
    $.jgrid.defaults.styleUI="Bootstrap";
    $("#table_list_2").jqGrid({
        url: $path_base+'user/'+sysId+'/getListByPage',
        mtype: 'POST',
        datatype : 'json',
        postData: {},
        height:450,
        autowidth:true,
        shrinkToFit:true,
        rowNum:20,
        rowList:[10,20,30],
        colNames:["用户ID","账号","昵称","姓名","电子邮箱","手机号码","备注","状态","创建时间","操作员","操作"],
        colModel:[
            {name:"userId",index:"userId",editable:true,sorttype:"int",hidden:true},
            {name:"loginAccount",index:"loginAccount",editable:false,align:"left"},
            {name:"nickName",index:"nickName",editable:false,align:"left"},
            {name:"fullName",index:"fullName",editable:false,align:"left"},
            {name:"email",index:"email",editable:false,align:"left"},
            {name:"mobile",index:"mobile",editable:false,align:"left"},
            {name:"remark",index:"remark",editable:false,align:"left"},
            {name:"state",index:"state",editable:false,align:"left"},
            {name:"createTime",index:"createTime",editable:false,align:"left",sorttype:"date",formatter : function(cellvalue, options, rowObject) {return $.hd_jqGrid.dateTimeFormatter(cellvalue); } },
           // {name:"updateTime",index:"updateTime",editable:false,align:"left",sorttype:"date",formatter : function(cellvalue, options, rowObject) {return $.hd_jqGrid.dateTimeFormatter(cellvalue); }},
            {name:"operator",index:"operator",editable:false,align:"left"},
            {name:"act",index:"act",editable:false,sortable:false}
        ],
        pager:"#pager_list_2",
        viewrecords:true,
        caption:"用户列表",
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
                var cl = ids[i], state = $(this).jqGrid('getCell',cl,7);
                $(this).jqGrid('setRowData',ids[i],{state:getState(state)});
                var btn = new Array();
                btn.push("<a style='margin-right: 5px;display: inline-block' onclick='toEdit("+cl+");'><i class='fa fa-edit'></i> 编辑 </a>");
                btn.push("<a style='margin-right: 5px;display: inline-block' onclick='toDel("+cl+")'><i class='fa fa-times'></i> 删除 </a>");
                jQuery(this).jqGrid('setRowData',ids[i],{act:btn.join("")});
            }
        }
    });
    $("#table_list_2").setSelection(4,true);
    $("#table_list_2").jqGrid("navGrid","#pager_list_2",{edit:true,add:true,del:true,search:true},{height:200,reloadAfterSubmit:true});
    $(window).bind("resize",function(){
        var width=$(".jqGrid_wrapper").width();
        $("#table_list_2").setGridWidth(width)
    });

    //
    // /**获取系统字典*/
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
     * 用户信息管理--查询
     */
    $("#btn_search").click(function(){
        var postData = new Object();
        postData.sysId = $("#sysId").val();
        postData.fullName = $("#fullName").val();
        postData.nickName = $("#nickName").val();
        postData.loginAccount = $("#account").val();
        postData.mobile = $("#mobile").val();
        postData.email = $("#email").val();
        tableReload(postData);
    });

    /**
     * 添加用户信息--提交
     */
    $("#btn_add").click(function(){
        var postData = new Object(), sysId=$("#sysId").val();
        postData.fullName = $("#addFullName").val();
        postData.nickName = $("#addNickName").val();
        postData.loginAccount = $("#addAccount").val();
        postData.mobile = $("#addMobile").val();
        postData.email = $("#addEmail").val();
        postData.password = $("#addPassword").val();
        postData.remark = $("#addRemark").val();
        /**提交用户添加*/
        $.ajax({
            type: 'POST',
            url: $path_base + 'user/'+sysId+'/add',
            data: postData,
            type:'post',
            dataType:'json',
            success: function (data) {
                if(data.resultCode=='0000'){
                    swal({title:"太帅了",text:"用户添加成功",type:"success"},function () {
                        $("#add_modal").modal('hide');
                        tableReload();
                    });
                }else{
                    swal({title:"人品不好",text: data.resultDesc,type:"error"});
                }
            },
            error: function () {
                swal({title:"人品不好",text:"系统错误",type:"error"});
            }
        });
    });

    /**
     * 更新用户信息--提交
     */
    $("#btn_edit").click(function(){
        var postData = new Object(), sysId=$("#sysId").val(), userId=$('#editUserId').val();
        postData.fullName = $("#editFullName").val();
        postData.nickName = $("#editNickName").val();
        postData.mobile = $("#editMobile").val();
        postData.email = $("#editEmail").val();
        postData.remark = $("#editRemark").val();
        /**提交用户添加*/
        $.ajax({
            type: 'POST',
            url: $path_base + 'user/'+sysId+'/'+userId+'/update',
            data: postData,
            type:'post',
            dataType:'json',
            success: function (data) {
                if(data.resultCode=='0000'){
                    swal({title:"太帅了",text:"用户更新成功",type:"success"},function () {
                        $("#edit_modal").modal('hide');
                        tableReload();
                    });
                }else{
                    swal({title:"人品不好",text: data.resultDesc,type:"error"});
                }
            },
            error: function () {
                swal({title:"人品不好",text:"系统错误",type:"error"});
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
            url: $path_base + 'user/'+sysId+'/getListByPage',
            contentType: 'application/x-www-form-urlencoded; charset=utf-8',
            mtype: 'POST',
            datatype : 'json',
            postData: postData,
            gridComplete: function(){
                var ids = $(this).getDataIDs();
                for(var i=0;i<ids.length;i++){
                    var cl = ids[i], state = $(this).jqGrid('getCell',cl,7);
                    $(this).jqGrid('setRowData',ids[i],{state:getState(state)});
                    var btn = new Array();
                    btn.push("<a style='margin-right: 5px;display: inline-block'  onclick='toEdit("+cl+");'><i class='fa fa-edit'></i> 编辑 </a>");
                    btn.push("<a style='margin-right: 5px;display: inline-block' onclick='toDel("+cl+")'><i class='fa fa-times'></i> 删除 </a>");
                    jQuery(this).jqGrid('setRowData',ids[i],{act:btn.join("")});
                }
            }
        }).trigger('reloadGrid');
    }

    /***
     * 编辑用户信息--填充用户信息
     */
    toEdit = function (id) {
        $("#editUserId").val($("#table_list_2").jqGrid('getCell',id,0));
        $("#editAccount").val($("#table_list_2").jqGrid('getCell',id,1));
        $("#editNickName").val($("#table_list_2").jqGrid('getCell',id,2));
        $("#editFullName").val($("#table_list_2").jqGrid('getCell',id,3));
        $("#editEmail").val($("#table_list_2").jqGrid('getCell',id,4));
        $("#editMobile").val($("#table_list_2").jqGrid('getCell',id,5));
        $("#editRemark").val($("#table_list_2").jqGrid('getCell',id,6));
        $("#edit_modal").modal('show');
    }

    /***
     * 移除用户信息
     */
    toDel = function (id) {
        var userId = $("#table_list_2").jqGrid('getCell',id,0);
        var account = $("#table_list_2").jqGrid('getCell',id,1);
        var sysId = $("#sysId").val();
        swal({
                title:"您确定要移除账号：" + account,
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
                        url: $path_base + 'user/'+sysId+'/'+userId+'/delete',
                        type:'post',
                        dataType:'json',
                        success: function (data) {
                            if(data.resultCode=='0000'){
                                swal({title:"太帅了",text:"用户移除成功",type:"success"},function () {
                                    tableReload();
                                });
                            }else{
                                swal({title:"人品不好",text: data.resultDesc,type:"error"});
                            }
                        },
                        error: function () {
                            swal({title:"人品不好",text:"系统错误",type:"error"});
                        }
                    });
                }else{
                    swal("已取消","您取消了移除操作！","error")
                }
            });
    }

    /**
     * 重置查询条件
     */
    $("#btn_reset").click(function () {
        $("#account").val('');
        $('#fullName').val('');
        $('#nickName').val('');
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

