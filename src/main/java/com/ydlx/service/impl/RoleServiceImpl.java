package com.ydlx.service.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.RoleMapper;
import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.RoleDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.RoleVO;
import com.ydlx.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ydlx on 2017/9/9.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageResultVO<RoleVO> getRoleList(int currentPage, int pageSize, RoleDTO dto) {
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        CondictionDTO condictionDTO = new CondictionDTO().setStart(start).setPageSize(pageSize).setDto(dto);
        condictionDTO.setSysId(dto.getSysId());
        List<RoleDTO> roleDTOs = roleMapper.getListByPage(condictionDTO);
        List<RoleVO> list = new ArrayList<RoleVO>();
        for(RoleDTO roleDTO : roleDTOs){
            RoleVO vo = new RoleVO();
            BeanUtils.copyProperties(roleDTO, vo);
            list.add(vo);
        }
        int count = roleMapper.getTotalCount(condictionDTO);
        return new PageResultVO(list, currentPage, pageSize, count);
    }

    @Override
    public ResultVO getRoleList(RoleDTO dto) {
        List<RoleDTO> roleDTOs = roleMapper.getList(dto);
        List<RoleVO> roleVOs = new ArrayList<RoleVO>();
        for(RoleDTO roleDTO : roleDTOs){
            RoleVO roleVO = new RoleVO();
            BeanUtils.copyProperties(roleDTO, roleVO);
            roleVOs.add(roleVO);
        }
        ResultVO resultVO = new ResultVO(ResultType.SUCCESS);
        resultVO.setData(roleVOs);
        return resultVO;
    }

    @Override
    public ResultVO addRole(RoleDTO dto) {
        dto.setRoleId(UUID.randomUUID().toString().replace("-","").trim());
        if(roleMapper.insert(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }else{
            return new ResultVO(ResultType.FAIL);
        }
    }

    @Override
    public ResultVO deleteRole(String roleId) {
        if(roleMapper.delete(roleId)){
            return new ResultVO(ResultType.SUCCESS);
        }else{
            return new ResultVO(ResultType.FAIL);
        }
    }

    @Override
    public ResultVO updateRole(RoleDTO dto) {
        if(roleMapper.update(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }else{
            return new ResultVO(ResultType.FAIL);
        }
    }
}
