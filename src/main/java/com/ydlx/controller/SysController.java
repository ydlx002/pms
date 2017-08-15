package com.ydlx.controller;

import com.ydlx.domain.dto.SysDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.SysVO;
import com.ydlx.domain.vo.request.sys.AddSysRequest;
import com.ydlx.domain.vo.request.sys.QuerySysRequest;
import com.ydlx.domain.vo.request.sys.UpdateSysRequest;
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
@RequestMapping(value="/sys")
public class SysController {
    private static final String userId="1";
    private static final String fullName="admin";
    private static final String loginAccount="admin";
    //private static final String sysId ="1";

    @Autowired
    private SysService sysService;

    @PostMapping(value="/getSysDict")
    public ResultVO getSysDict(){
        return sysService.getListDict();
    }

    /**
     * 分页获取系统接入列表
     * @param request
     * @return
     */
    @PostMapping(value = "/getListByPage")
    public PageResultVO<SysVO> getListByPage(QuerySysRequest request){
        SysDTO sysDTO = new SysDTO();
        sysDTO.setEnable(request.getEnable());
        sysDTO.setSysCode(request.getSysCode());
        sysDTO.setSysName(request.getSysName());
        sysDTO.setOperatorId(userId);
        return sysService.getListByPage(request.getPage(),request.getRows(),sysDTO);
    }

    /***
     * 添加接入系统
     * @param request
     * @return
     */
    @PostMapping(value = "/add")
    public  ResultVO add(AddSysRequest request){
        SysDTO sysDTO = new SysDTO();
        sysDTO.setSysName(request.getSysName());
        sysDTO.setOperatorId(userId);
        sysDTO.setSysCode(request.getSysCode());
        sysDTO.setEnable(1);
        sysDTO.setSysDesc(request.getSysDesc());
        return sysService.addSys(sysDTO);
    }

    /***
     * 更新接入系统信息
     * @param request
     * @return
     */
    @PostMapping(value = "/{sysId}/update")
    public  ResultVO update(@PathVariable("sysId") String sysId, UpdateSysRequest request){
        SysDTO sysDTO = new SysDTO();
        sysDTO.setSysName(request.getSysName());
        sysDTO.setOperatorId(userId);
        sysDTO.setSysCode(request.getSysCode());
        sysDTO.setEnable(1);
        sysDTO.setSysDesc(request.getSysDesc());
        sysDTO.setSysId(sysId);
        return sysService.updateSys(sysDTO);
    }

    /**
     * 删除接入系统
     * @param sysId 指定系统ID
     * @return
     */
    @PostMapping(value = "/{sysId}/delete")
    public  ResultVO delete(@PathVariable("sysId") String sysId){
        return sysService.deleteSys(sysId);
    }

}
