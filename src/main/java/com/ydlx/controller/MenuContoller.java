package com.ydlx.controller;

import com.ydlx.domain.dto.MenuDTO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.request.menu.AddMenuRequest;
import com.ydlx.domain.vo.request.menu.UpdateMenuRequest;
import com.ydlx.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/8/19.
 */
@RestController
@RequestMapping(value="/menu/{sysId}")
public class MenuContoller {

    @Autowired
    private MenuService menuService;

    /**
     * 新增菜单项
     * @param request
     * @return
     */
    @PostMapping(value="/getMenuTree")
    public ResultVO getMenuTree(@PathVariable("sysId")String sysId){
        MenuDTO dto = new MenuDTO();
        return menuService.getMenuTree(sysId);
    }

    /**
     * 新增菜单项
     * @param request
     * @return
     */
    @PostMapping(value="/add")
    public ResultVO addMenu(@PathVariable("sysId")String sysId, AddMenuRequest request){
        MenuDTO dto = new MenuDTO();
        dto.setName(request.getMenuName());
        dto.setParentId(request.getParentId());
        dto.setSysId(sysId);
        dto.setTarget(request.getTarget());
        dto.setIcon(request.getIcon());
        dto.setUrl(request.getUrl());
        return menuService.addMenu(dto);
    }

    /**
     * 新增菜单项
     * @param request
     * @return
     */
    @PostMapping(value="/update")
    public ResultVO updateMenu(@PathVariable("sysId")String sysId, UpdateMenuRequest request){
        MenuDTO dto = new MenuDTO();
        dto.setId(request.getId());
        dto.setName(request.getMenuName());
        dto.setParentId(request.getParentId());
        dto.setSysId(sysId);
        dto.setTarget(request.getTarget());
        dto.setIcon(request.getIcon());
        dto.setUrl(request.getUrl());
        return menuService.updateMenu(dto);
    }
}
