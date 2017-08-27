package com.ydlx.controller;

import com.ydlx.domain.dto.PrivilegeDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.PrivilegeVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.request.pri.AddPriRequest;
import com.ydlx.domain.vo.request.pri.QueryPriRequest;
import com.ydlx.domain.vo.request.pri.UpdatePriRequest;
import com.ydlx.service.PrivilegeService;
import com.ydlx.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/8/12.
 */
@RestController
@RequestMapping(value="/pri/{sysId}")
public class PrivilegeController {

    private static final String userId="1";
    private static final String fullName="admin";
    private static final String loginAccount="admin";
    //private static final String sysId ="1";

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private SysService sysService;


    /***
     * 分页获取权限列表
     * @param sysId
     * @param request
     * @return
     */
    @PostMapping(value = "/getListByPage")
    public PageResultVO<PrivilegeVO> getListByPage(@PathVariable("sysId") String sysId, QueryPriRequest request){
        PrivilegeDTO privilegeDTO = new PrivilegeDTO();
        privilegeDTO.setSysId(sysId);
        privilegeDTO.setPriCode(request.getPriCode());
        privilegeDTO.setPriName(request.getPriName());
        privilegeDTO.setOperatorId(userId);
        return privilegeService.getPrivilegeList(1,10,privilegeDTO);
    }

    /**
     * 获取指定系统中的权限列表
     * @param sysId
     * @return
     */
    @PostMapping(value = "/getPriDict")
    public ResultVO getPriDict(@PathVariable("sysId") String sysId){
        return privilegeService.getPrivilegeList(new PrivilegeDTO(sysId));
    }

    /***
     * 添加权限信息
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public  ResultVO add(@PathVariable("sysId") String sysId, AddPriRequest request){
        PrivilegeDTO privilegeDTO = new PrivilegeDTO();
        privilegeDTO.setSysId(sysId);
        privilegeDTO.setPriCode(request.getPriCode());
        privilegeDTO.setPriName(request.getPriName());
        privilegeDTO.setPriDesc(request.getPriDesc());
        privilegeDTO.setOperatorId(userId);
        return privilegeService.addPrivilege(privilegeDTO);
    }

    /***
     * 更新权限
     * @param request
     * @return
     */
    @PostMapping(value = "/{priId}/update")
    public  ResultVO update(@PathVariable("priId") String priId, UpdatePriRequest request){
        PrivilegeDTO privilegeDTO = new PrivilegeDTO();
        privilegeDTO.setPriId(priId);
        privilegeDTO.setPriId(request.getPriId());
        privilegeDTO.setPriName(request.getPriName());
        privilegeDTO.setPriDesc(request.getPriDesc());
        privilegeDTO.setOperatorId(userId);
        return privilegeService.updatePrivilege(privilegeDTO);
    }

    /**
     * 删除权限
     * @param priId 指定ID
     * @return
     */
    @PostMapping(value = "/{priId}/delete")
    public  ResultVO delete(@PathVariable("priId") String priId){
        return privilegeService.deletePrivilege(priId);
    }

}
