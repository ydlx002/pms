package com.ydlx.domain.vo.request.menu;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/8/19.
 */
public class UpdateMenuRequest implements Serializable{

    /**菜单ID*/
    private String id;

    /**父级菜单ID*/
    private String parentId;

    /**菜单名称*/
    private String menuName;

    /**图标*/
    private String icon;

    /**url*/
    private String url;

    /**打开方式*/
    private String target;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
