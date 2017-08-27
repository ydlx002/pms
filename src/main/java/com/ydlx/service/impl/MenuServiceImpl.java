package com.ydlx.service.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.MenuMapper;
import com.ydlx.dao.SysMapper;
import com.ydlx.domain.dto.MenuDTO;
import com.ydlx.domain.dto.SysDTO;
import com.ydlx.domain.vo.MenuVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.service.MenuService;
import com.ydlx.utils.TreeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ydlx on 2017/8/19.
 */
@Service
public class MenuServiceImpl implements MenuService{
    private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private SysMapper sysMapper;

    @Override
    public ResultVO getMenuTree(String sysId) {
        ResultVO resultVO = new ResultVO(ResultType.SUCCESS);
        List<MenuDTO> menuDTOs = menuMapper.getListByIds(sysId,null);
        List<MenuVO> menuVOs = new ArrayList<MenuVO>();
        for(MenuDTO dto : menuDTOs){
            MenuVO menuVO = new MenuVO();
            BeanUtils.copyProperties(dto, menuVO);
            menuVOs.add(menuVO);
        }
        resultVO.setData(TreeUtil.createTreeMenus(menuVOs));
        return resultVO;
    }

    /**
     * 新增菜单信息
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public ResultVO addMenu(MenuDTO dto) {
        if(sysMapper.getList(new SysDTO(dto.getSysId())).size() ==0 ){
            return new ResultVO(ResultType.EMPTYSYS);
        }
        if(!StringUtils.isEmpty(dto.getParentId())){
            MenuDTO pMenuDTO = menuMapper.getById(dto.getParentId());
            if(null == pMenuDTO){
                return new ResultVO(ResultType.EMPTYPARENTMENU);
            }
            //若父节点为叶子节点则更新为非叶子节点
            if(pMenuDTO.getLeaf()==1){
                menuMapper.update(new MenuDTO().setLeaf(0));
            }
            dto.setLevel(pMenuDTO.getLevel()+1);//子菜单节点级数+1
        }else{
            dto.setLevel(1); //父级节点为空则为一级菜单
        }
        dto.setLeaf(1);//所有新增的菜单均为叶子菜单
        dto.setId(UUID.randomUUID().toString().replace("-","").trim());
        if(menuMapper.insert(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    /**
     * 更新菜单信息
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public ResultVO updateMenu(MenuDTO dto) {
        if(StringUtils.isEmpty(dto.getId())){
            return new ResultVO(ResultType.EMPTYMENUID);
        }
        MenuDTO oldMenu = menuMapper.getById(dto.getParentId());
        if(null == oldMenu){
            return new ResultVO(ResultType.EMPTYMENU);
        }
        // 更换父级菜单
        if(!StringUtils.isEmpty(dto.getParentId()) && !dto.getParentId().equals(oldMenu.getParentId())){
            MenuDTO pNewMenu = menuMapper.getById(dto.getParentId());
            if(null == pNewMenu){
                return new ResultVO(ResultType.EMPTYPARENTMENU);
            }
            // 判断父级菜单下是否还存在其他子菜单，若无则将其更新为叶子节点
            if(menuMapper.getList(new MenuDTO().setParentId(oldMenu.getParentId())).size() == 0 ){
                menuMapper.update(new MenuDTO().setId(oldMenu.getId()).setLeaf(1));
            }
            //校验新父级菜单是否为叶子节点
            MenuDTO menuDTO=menuMapper.getById(dto.getParentId());
            if(null == menuDTO){
                return new ResultVO(ResultType.EMPTYPARENTMENU);
            }
            if(menuDTO.getLeaf()==1){
                menuDTO.setLeaf(0);
                menuMapper.update(new MenuDTO().setId(dto.getParentId()).setLeaf(0));
            }
            dto.setLevel(menuDTO.getLevel()+1);
        }
        dto.setLeaf(0);
        if(menuMapper.update(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    /**
     * 删除菜单信息
     * @param menuId
     * @return
     */
    @Override
    public ResultVO deleteMenu(String menuId) {
        return new ResultVO(ResultType.FAIL);
    }
}
