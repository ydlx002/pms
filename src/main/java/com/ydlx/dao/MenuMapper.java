package com.ydlx.dao;

import com.ydlx.domain.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface MenuMapper {


        /**
         * 根据菜单Id获取菜单
         * @param id
         * @return
         */
        MenuDTO getById(@Param("id") String id);

        /***
         *  根据菜单条件选择菜单列表
         * @param dto
         * @return
         */
        List<MenuDTO> getList(MenuDTO dto);


        /***
         * 根据ID获取菜单，ID以“，”分隔开
         * @param ids
         * @return
         */
        List<MenuDTO> getListByIds(@Param("sysId") String sysId, @Param("ids") List<String> ids);

        /***
         * 根据角色ID获取菜单，ID以“，”分隔开
         * @param roleIds
         * @return
         */
        List<MenuDTO> getListByRoleId(List<Integer> roleIds);

        /***
         * 新增菜单
         * @param MenuDTO
         * @return
         */
        boolean insert(MenuDTO MenuDTO);

        /***
         * 更新菜单信息
         * @param MenuDTO
         * @return
         */
        boolean update(MenuDTO MenuDTO);

        /***
         * 删除菜单信息
         * @return
         */
        boolean delete(@Param("id") Integer id);
}
