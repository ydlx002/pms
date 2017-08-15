package com.ydlx.dao;

import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理dao层
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface UserMapper {

        /**
         * 获取账户信息
         * @param userDTO
         * @return
         */
        List<UserDTO> getList(UserDTO userDTO);

        /**
         * 分页获取用户列表
         * @param dto
         * @return
         */
        List<UserDTO> getListByPage(CondictionDTO dto);

        /**
         *  获取用户总数
         * @param dto
         * @return
         */
        int getTotalCount(CondictionDTO dto);


        /**
         * 写入用户信息
         * @param userDTO
         * @return
         */
        boolean insertUser(UserDTO userDTO);


        /***
         * 更新用户信息
         * @param userDTO
         * @return
         */
        boolean updateUser(UserDTO userDTO);

        /***
         * 删除用户信息
         * @param userId
         * @return
         */
        boolean deleteUser(@Param("userId") String userId);

}
