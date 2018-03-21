/**
 * Created by ydlx on 2017/6/4.
 */
var toAdd;
$(document).ready(function(){
    var sysId=$("#sysId").val();
    $.ajax({
        type: 'POST',
        url: $path_base + 'menu/'+sysId+'/getMenuTree',
        success: function (data) {
            if('0000'==data.resultCode){
                $('#nestable2').append(createMenu(new Array(),data.data).join('')).nestable();
            }else{
                swal({title:"人品不好",text: data.resultDesc,type:"error"});
            }
        },
        error: function () {
            swal({title:"人品不好",text: "系统错误",type:"error"});
        }
    });

    $("#nestable-menu").on("click",function(e){
        var target=$(e.target),action=target.data("action");
        if(action==="expand-all"){
            $(".dd").nestable("expandAll")
        }
        if(action==="collapse-all"){
            $(".dd").nestable("collapseAll")
        }
    })

    var createMenu = function(obj, menuList){
        for(var i=0,size=menuList.length;i<size;i++) {
            var id=menuList[i].id;
            var name=menuList[i].name;
            obj.push("<ol class=\"dd-list\">");
            obj.push("<li class=\"dd-item\" data-id=\"" + menuList[i].id + "\">");
            obj.push("<div class=\"dd-handle\">");
            obj.push("<span class=\"pull-right\">");
            obj.push("<button type='button' data-toggle='modal'  class='btn btn-white btn-sm' onclick='addMenu(\""+id+"\",\""+name+"\")';>新增子菜单</button>");
            obj.push("<button type='button' data-toggle='modal'  class='btn btn-white btn-sm'>编辑菜单</button>");
            obj.push("<button type='button' data-toggle='modal'  class='btn btn-white btn-sm'>权限设置</button>");
            obj.push("<button type='button' data-toggle='modal'  class='btn btn-white btn-sm'>删除菜单</button>");
            obj.push("</span>");
            obj.push("<span class=\"label label-info\"><i class=\""+menuList[i].icon+"\"></i></span>" + menuList[i].name + "</div>");
            if (menuList[i].leaf == 0) {
                createMenu(obj, menuList[i].childrenMenu);
            }
            obj.push("</div></li></ol>");
        }
        return obj;
    };

    $(".select_box").click(function(event){
        event.stopPropagation();
        $(this).find(".option").toggle();
        $(this).parent().siblings().find(".option").hide();
    });
    /*赋值给文本框*/
    $(".option a").click(function(){
        $(".select_txt").empty();
        $(this).parent().siblings(".select_txt").append($(this).clone(true));
    });

    $(document).click(function(event){
        var eo=$(event.target);
        if($(".select_box").is(":visible")&&eo.attr("class")!="option"&&!eo.parent(".option").length){
            $('.option').hide();
        }
        //新增菜单标识
        if(menuAddFlag==1&&eo.parent(".dd-item").length){
            $('#parentMenu').val(eo.text());
            $('#parentMenuId').val(eo.parent().attr('data-id'));
        }
    });

    /**新增子菜单弹出框*/
    addMenu= function (id,name) {
        $("#addParentMenu").val(name);
        $("#addParentMenuId").val(id);
        //加载权限下拉框
        $.ajax({
            type: 'POST',
            url: $path_base + 'pri/'+sysId+'/getPriDict',
            success: function (data) {
                $('#addPriId').empty();
                if('0000'==data.resultCode){
                    $.each(data.data, function (k,v) {
                        $('#addPriId').append("<option value='"+v.priId+"'>"+v.priName+"</option>");
                    });
                }else{
                    swal({title:"人品不好",text: data.resultDesc,type:"error"});
                }
            },
            error: function () {
                swal({title:"人品不好",text: "系统错误",type:"error"});
            }
        });

        $("#addModal").modal('show');
    }

});
