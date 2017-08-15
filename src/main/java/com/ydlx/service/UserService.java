package com.ydlx.service;

import com.ydlx.domain.dto.UserDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.UserVO;

/**
 * 用户管理服务接口层
 * 1. 账号/用户的增删改查，保证事务一致性
 * Created by ydlx on 2017/5/3.
 */
public interface UserService{

//    /**
//     * 根据用户登录账号获取用户信息
//     * @param loginAccount 用户登录帐号
//     * @return
//     */
//    UserInfo getUserByLoginAccount(String loginAccount);


    /**
     * 分页获取用户详细信息
     * @param currentPage 当前页码
     * @param pageSize 每页行数
     * @param dto 用户查询条件
     * @return
     */
    PageResultVO<UserVO> getUserList(int currentPage, int pageSize, UserDTO dto);


    /**
     * 新增用户
     * @param dto 用户信息
     * @param userTypeId 用户类型
     * @param password 密码
     * @return
     */
    ResultVO addUser(UserDTO dto, String userTypeId, String password);


    /**
     * 删除用户
     * @param userId
     * @return
     */
    ResultVO deleteUser(String userId);

    /***
     * 将用户从系统中移除，而非删除
     * @param userId
     * @param sysId
     * @return
     */
    ResultVO removeUser(String userId, String sysId);

    /**
     * 更新用户信息
     * @param dto
     * @return
     */
    ResultVO updateUser(UserDTO dto);


}
