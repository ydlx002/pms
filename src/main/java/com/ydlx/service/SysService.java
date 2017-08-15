package com.ydlx.service;

import com.ydlx.domain.dto.SysDTO;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.SysVO;

/**
 * Created by ydlx on 2017/8/12.
 */
public interface SysService {

    /**
     * 获取系统字典值
     * @return
     */
    ResultVO getListDict();


    /**
     * 分页获取系统详细信息
     * @param currentPage 当前页码
     * @param pageSize 每页行数
     * @param dto 系统查询条件
     * @return
     */
    PageResultVO<SysVO> getListByPage(int currentPage, int pageSize, SysDTO dto);


    /**
     * 新增接入系统信息
     * @param dto 系统信息
     * @return
     */
    ResultVO addSys(SysDTO dto);


    /**
     * 删除接入系统
     * @param sysId
     * @return
     */
    ResultVO deleteSys(String sysId);


    /**
     * 更新系统信息
     * @param dto
     * @return
     */
    ResultVO updateSys(SysDTO dto);
}
