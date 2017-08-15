/**
 * Created by ydlx on 2017/6/4.
 */
$(document).ready(function(){
    $.ajax({
        type: 'POST',
        url: $path_base + 'menu/getMenu',
        success: function (data) {
            $('#nestable2').append(createMenu(new Array(),data).join('')).nestable();
        },
        error: function () {
            console.log("错误");
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
            obj.push("<ol class=\"dd-list\">");
            obj.push("<li class=\"dd-item\" data-id=\"" + menuList[i].id + "\">");
            obj.push("<div class=\"dd-handle\">");
            obj.push("<span class=\"pull-right\"> <a href=\"#\"><i class=\"fa fa-edit\"></i></a><a href=\"#\"><i class=\"fa fa-trash\"></i></a></span>");
            obj.push("<span class=\"label label-info\"><i class=\""+menuList[i].icon+"\"></i></span>" + menuList[i].name + "</div>");
            if (menuList[i].leaf == 0) {
                createMenu(obj, menuList[i].childMenuList);
            }
            obj.push("</div></li></ol>");
        }
        return obj;
    };

});