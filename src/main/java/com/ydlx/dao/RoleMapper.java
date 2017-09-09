package com.ydlx.dao;

import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.RoleDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface RoleMapper {

        /**
         * 获取列表
         * @return
         */
        List<RoleDTO> getList(RoleDTO dto);

        /**
         * 分页获取角色列表
         * @param dto
         * @return
         */
        List<RoleDTO> getListByPage(CondictionDTO dto);

        /**
         *  获取角色总数
         * @param dto
         * @return
         */
        int getTotalCount(CondictionDTO dto);

        /***
         * 根据ID获取角色的信息
         * @param roleId
         * @return
         */
        RoleDTO getById(String roleId);

        /***
         * 新增角色
         * @param dto
         * @return
         */
        boolean insert(RoleDTO dto);

        /***
         * 更新角色信息
         * @param dto
         * @return
         */
        boolean update(RoleDTO dto);

        /***
         * 删除角色信息
         * @return
         */
        boolean delete(@Param("roleId") String roleId);

}
