package com.ydlx.domain.vo;

import java.util.*;

/**
 * Created by ydlx on 2017/8/20.
 */
public class MenuVO extends BaseVO{

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

    /**菜单级数*/
    private int level;

    /**排序*/
    private int orderBy;

    /**url*/
    private String url;

    /**打开方式*/
    private String target;

    /**子菜单*/
    private List<MenuVO> childrenMenu = new ArrayList<MenuVO>();

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

    public void setLeaf(int leaf) {
        this.leaf = leaf;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
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

    public List<MenuVO> getChildrenMenu() {
        return childrenMenu;
    }

    public void setChildrenMenu(List<MenuVO> childrenMenu) {
        this.childrenMenu = childrenMenu;
    }

    /**
     *
     * <Description> 孩子节点排序<br>
     *
     */
    public void sortChildren() {
        Collections.sort(childrenMenu, new Comparator<MenuVO>() {
            @Override
            public int compare(MenuVO menu1, MenuVO menu2) {
                int result = 0;

                Integer ordby1 = menu1.getOrderBy();
                Integer ordby2 = menu2.getOrderBy();
                if (null != ordby1 && null != ordby2) {
                    result = (ordby1 < ordby2 ? -1 : (ordby1 == ordby2 ? 0 : 1));
                }
                return result;
            }
        });
        // 对每个节点的下一层节点进行排序
        for (Iterator<MenuVO> it = childrenMenu.iterator(); it.hasNext();) {
            it.next().sortChildren();
        }
    }
}
