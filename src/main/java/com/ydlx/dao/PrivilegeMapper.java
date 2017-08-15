package com.ydlx.dao;

import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.PrivilegeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理dao层
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface PrivilegeMapper {

        /**
         * 获取权限信息
         * @param dto
         * @return
         */
        List<PrivilegeDTO> getList(PrivilegeDTO dto);

        /**
         * 分页获取用户列表
         * @param dto
         * @return
         */
        List<PrivilegeDTO> getListByPage(CondictionDTO dto);

        /**
         *  获取权限总数
         * @param dto
         * @return
         */
        int getTotalCount(CondictionDTO dto);


        /**
         * 写入权限信息
         * @param dto
         * @return
         */
        boolean insert(PrivilegeDTO dto);


        /***
         * 更新权限信息
         * @param dto
         * @return
         */
        boolean update(PrivilegeDTO dto);

        /***
         * 删除权限信息
         * @param priId
         * @return
         */
        boolean delete(@Param("priId") String priId);

}
