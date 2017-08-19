package com.ydlx.service;

import com.ydlx.domain.dto.MenuDTO;
import com.ydlx.domain.vo.ResultVO;

/**
 * Created by ydlx on 2017/5/3.
 */
public interface MenuService {

    /**
     * 新增菜单项
     * @param dto
     * @return
     */
    ResultVO addMenu(MenuDTO dto);

    /**
     * 更新菜单信息
     * @param dto
     * @return
     */
    ResultVO updateMenu(MenuDTO dto);

    /**
     * 删除菜单信息
     * @param menuId
     * @return
     */
    ResultVO deleteMenu(String menuId);

}
