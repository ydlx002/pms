package com.ydlx.domain.vo.request.menu;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/8/19.
 */
public class AddMenuRequest implements Serializable{

    /**父级菜单节点ID*/
    private String parentId;

    /**系统名称*/
    private String menuName;

    /**url*/
    private String url;

    /**菜单图标*/
    private String icon;

    /**菜单打开方式*/
    private String target;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
