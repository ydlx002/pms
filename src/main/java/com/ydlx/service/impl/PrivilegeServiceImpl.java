package com.ydlx.service.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.PrivilegeMapper;
import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.PrivilegeDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.PrivilegeVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.service.PrivilegeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ydlx on 2017/8/14.
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService{
    private static final Logger logger = LoggerFactory.getLogger(PrivilegeServiceImpl.class);

    @Resource
    private PrivilegeMapper privilegeMapper;


    @Override
    public PageResultVO<PrivilegeVO> getPrivilegeList(int currentPage, int pageSize, PrivilegeDTO dto) {
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        CondictionDTO condictionDTO = new CondictionDTO().setStart(start).setPageSize(pageSize).setDto(dto);
        condictionDTO.setSysId(dto.getSysId());
        List<PrivilegeDTO> privilegeDTOs = privilegeMapper.getListByPage(condictionDTO);
        List<PrivilegeVO> list = new ArrayList<PrivilegeVO>();
        for(PrivilegeDTO privilegeDTO : privilegeDTOs){
            PrivilegeVO vo = new PrivilegeVO();
            BeanUtils.copyProperties(privilegeDTO, vo);
            list.add(vo);
        }
        int count = privilegeMapper.getTotalCount(condictionDTO);
        return new PageResultVO(list, currentPage, pageSize, count);
    }

    @Override
    public ResultVO addPrivilege(PrivilegeDTO dto) {
        dto.setPriId(UUID.randomUUID().toString().replace("-","").trim());
        if(privilegeMapper.insert(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }else{
            return new ResultVO(ResultType.FAIL);
        }
    }

    @Override
    public ResultVO deletePrivilege(String priId) {
        //校验权限是否在应用中，否则不允许删除
//        if(privilegeMapper.delete(priId)){
//            return new ResultVO(ResultType.SUCCESS);
//        }else{
//            return new ResultVO(ResultType.FAIL);
//        }
        return new ResultVO(ResultType.SUCCESS);
    }

    @Override
    public ResultVO updatePrivilege(PrivilegeDTO dto) {
        if(privilegeMapper.update(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }else{
            return new ResultVO(ResultType.FAIL);
        }
    }
}
