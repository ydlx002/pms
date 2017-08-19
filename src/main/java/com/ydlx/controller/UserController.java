package com.ydlx.controller;

import com.ydlx.domain.dto.UserDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.UserVO;
import com.ydlx.domain.vo.request.user.AddUserRequest;
import com.ydlx.domain.vo.request.user.QueryUserRequest;
import com.ydlx.domain.vo.request.user.UpdateUserRequest;
import com.ydlx.service.SysService;
import com.ydlx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/8/12.
 */
@RestController
@RequestMapping(value="/user/{sysId}")
public class UserController {

    private static final String userId="1";
    private static final String fullName="admin";
    private static final String loginAccount="admin";
    //private static final String sysId ="1";

    @Autowired
    private UserService userService;

    @Autowired
    private SysService sysService;


    /***
     * 分页获取用户列表
     * @param sysId
     * @param request
     * @return
     */
    @PostMapping(value = "/getListByPage")
    public PageResultVO<UserVO> getListByPage(@PathVariable("sysId") String sysId, QueryUserRequest request){
        UserDTO userDTO = new UserDTO();
        userDTO.setFullName(request.getFullName());
        userDTO.setLoginAccount(request.getLoginAccount());
        userDTO.setNickName(request.getNickName());
        userDTO.setOperatorId(userId);
        userDTO.setSysId(sysId);
        return userService.getUserList(1,10,userDTO);
    }

    /***
     * 添加新用户
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public  ResultVO add(@PathVariable("sysId") String sysId, AddUserRequest request){
        UserDTO userDTO = new UserDTO();
        userDTO.setFullName(request.getFullName());
        userDTO.setOperatorId(userId);
        userDTO.setLoginAccount(request.getLoginAccount());
        userDTO.setNickName(request.getNickName());
        userDTO.setRemark(request.getRemark());
        userDTO.setMobile(request.getMobile());
        userDTO.setEmail(request.getEmail());
        userDTO.setSysId(sysId);
        return userService.addUser(userDTO,"1",request.getPassword());
    }

    /***
     * 更新用户
     * @param request
     * @return
     */
    @PostMapping(value = "/{userId}/update")
    public  ResultVO update(@PathVariable("sysId") String sysId,@PathVariable("userId") String userId, UpdateUserRequest request){
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(request.getEmail());
        userDTO.setFullName(request.getFullName());
        userDTO.setOperatorId(userId);
        userDTO.setRemark(request.getRemark());
        userDTO.setNickName(request.getNickName());
        userDTO.setMobile(request.getMobile());
        userDTO.setUserId(userId);
        userDTO.setSysId(sysId);
        return userService.updateUser(userDTO);
    }

    /**
     * 将用户从系统中移除
     * @param sysId 指定系统ID
     * @param userId 指定用户ID
     * @return
     */
    @PostMapping(value = "/{userId}/delete")
    public  ResultVO delete(@PathVariable("sysId") String sysId,@PathVariable("userId") String userId){
        return userService.removeUser(userId,sysId);
    }

}
