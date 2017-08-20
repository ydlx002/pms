package com.ydlx.domain.dto;

/**
 * Created by ydlx on 2017/5/1.
 */
public class MenuDTO extends BaseDTO{

    /**菜单ID*/
    private String id;

    /**父级菜单ID*/
    private String parentId;

    /**系统ID*/
    private String sysId;

    /**菜单名称*/
    private String name;

    /**是否为叶子*/
    private int leaf;

    /**图标*/
    private String icon;

    /**访问路径*/
    private String path;

    /**菜单级数*/
    private int level;

    /**排序*/
    private int orderBy;

    /**url*/
    private String url;

    /**打开方式*/
    private String target;

    public String getId() {
        return id;
    }

    public MenuDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public MenuDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaf() {
        return leaf;
    }

    public MenuDTO setLeaf(int leaf) {
        this.leaf = leaf;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLevel() {
        return level;
    }

    public MenuDTO setLevel(int level) {
        this.level = level;
        return this;
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

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }
}
