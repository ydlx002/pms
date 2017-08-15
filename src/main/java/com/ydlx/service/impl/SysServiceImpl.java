package com.ydlx.service.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.SysMapper;
import com.ydlx.dao.SysUserMapper;
import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.SysDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.SysVO;
import com.ydlx.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ydlx on 2017/8/12.
 */
@Service
public class SysServiceImpl implements SysService{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private SysMapper sysMapper;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public ResultVO getListDict() {
        SysDTO sysDTO = new SysDTO();
        sysDTO.setEnable(1);
        List<SysDTO> list = sysMapper.getList(sysDTO);
        List<SysVO> sysVOs = new ArrayList<SysVO>();
        for(SysDTO sys: list){
            SysVO vo = new SysVO();
            BeanUtils.copyProperties(sys,vo);
            sysVOs.add(vo);
        }
        ResultVO resultVO = new ResultVO(ResultType.SUCCESS);
        resultVO.setData(sysVOs);
        return resultVO;
    }

    @Override
    public PageResultVO<SysVO> getListByPage(int currentPage, int pageSize, SysDTO dto) {
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        CondictionDTO condictionDTO = new CondictionDTO().setStart(start).setPageSize(pageSize).setDto(dto);
        List<SysDTO> sysDTOs = sysMapper.getListByPage(condictionDTO);
        List<SysVO> list = new ArrayList<SysVO>();
        for(SysDTO sysDTO : sysDTOs){
            SysVO vo = new SysVO();
            BeanUtils.copyProperties(sysDTO, vo);
            list.add(vo);
        }
        int count = sysMapper.getTotalCount(condictionDTO);
        return new PageResultVO(list, currentPage, pageSize, count);
    }

    @Override
    public ResultVO addSys(SysDTO dto) {
        dto.setSysId(UUID.randomUUID().toString().replace("-","").trim());
        if(sysMapper.insert(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    @Transactional
    public ResultVO deleteSys(String sysId) {
        if(sysMapper.delete(sysId)){
            sysUserMapper.delete(sysId,null);
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO updateSys(SysDTO dto) {
        if(sysMapper.update(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }
}
