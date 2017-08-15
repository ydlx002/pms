package com.ydlx.dao;

import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.SysDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统dao
 * Created by ydlx on 2017/7/28.
 */
@Mapper
public interface SysMapper {

    /**
     * 写入系统信息
     * @param dto
     * @return
     */
    boolean insert(SysDTO dto);


    /**
     * 查询系统列表
     * @param dto
     * @return
     */
    List<SysDTO> getList(SysDTO dto);

    /**
     * 分页获取系统列表
     * @param dto
     * @return
     */
    List<SysDTO> getListByPage(CondictionDTO dto);

    /**
     *  获取系统总数
     * @param dto
     * @return
     */
    int getTotalCount(CondictionDTO dto);


    /**
     * 删除用户系统关系
     * @param sysId 指定系统
     * @return
     */
    boolean delete(@Param("sysId") String sysId);

    /**
     * 更新系统信息
     * @param dto
     * @return
     */
    boolean update(SysDTO dto);
}
