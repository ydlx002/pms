package com.ydlx.service.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.SysUserMapper;
import com.ydlx.dao.UserMapper;
import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.SysUserDTO;
import com.ydlx.domain.dto.UserDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.UserVO;
import com.ydlx.service.UserService;
import com.ydlx.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by ydlx on 2017/8/12.
 */
@Service
public class UserServiceImpl implements UserService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private SysUserMapper sysUserMapper;


    @Override
    public PageResultVO<UserVO> getUserList(int currentPage, int pageSize, UserDTO dto) {
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        CondictionDTO condictionDTO = new CondictionDTO().setStart(start).setPageSize(pageSize).setDto(dto);
        condictionDTO.setSysId(dto.getSysId());
        List<UserDTO> userDTOs = userMapper.getListByPage(condictionDTO);
        List<UserVO> list = new ArrayList<UserVO>();
        for(UserDTO userDTO : userDTOs){
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(userDTO, vo);
            list.add(vo);
        }
        int count = userMapper.getTotalCount(condictionDTO);
        return new PageResultVO(list, currentPage, pageSize, count);
    }

    @Override
    public ResultVO addUser(UserDTO dto, String userTypeId, String password) {
        //1. 查询账号是否已经注册
        if(userMapper.getList(new UserDTO().setLoginAccount(dto.getLoginAccount())).size() > 0){
            return new ResultVO(ResultType.ACCOUNTEXISTS);
        }
        //2. 校验账号下手机号是否已经存在
        if(!StringUtils.isEmpty(dto.getMobile()) && userMapper.getList(new UserDTO().setMobile(dto.getMobile())).size() > 0){
            return new ResultVO(ResultType.MOBILEXISTS);
        }
        //3. 校验账号下邮箱是否已经存在
        if(!StringUtils.isEmpty(dto.getMobile()) && userMapper.getList(new UserDTO().setMobile(dto.getEmail())).size() > 0){
            return new ResultVO(ResultType.EMAILEXISTS);
        }
        //4. 账号和用户信息入库
        String userId = UUID.randomUUID().toString().replace("-","").trim();
        dto.setUserId(userId);
        SysUserDTO sysUserDTO = new SysUserDTO();
        sysUserDTO.setSysId(StringUtils.isEmpty(dto.getSysId())?"1":dto.getSysId());
        sysUserDTO.setUserId(userId);
        sysUserDTO.setPassword(MD5Util.passwordEncoder(password));
        sysUserDTO.setState(1);
        sysUserDTO.setUpdateTime(new Date());
        sysUserDTO.setCreateTime(new Date());
        sysUserDTO.setOperatorId(dto.getOperatorId());
        if(userMapper.insertUser(dto) && sysUserMapper.insertSysUser(sysUserDTO)){
            return new ResultVO(ResultType.SUCCESS);
        }else{
            return new ResultVO(ResultType.FAIL);
        }
    }

    @Override
    public ResultVO deleteUser(String userId) {
        List<SysUserDTO> list = sysUserMapper.getList(new SysUserDTO().setUserId(userId).setState(1));
        if(list.size() > 0){
            return new ResultVO(ResultType.EFFECTIVEACCOUNT);
        }
        if(userMapper.deleteUser(userId)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO removeUser(String userId, String sysId) {
        if(sysUserMapper.delete(sysId,userId)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO updateUser(UserDTO dto) {
        if(userMapper.updateUser(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

}
