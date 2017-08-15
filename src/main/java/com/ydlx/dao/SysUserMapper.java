package com.ydlx.dao;

import com.ydlx.domain.dto.SysUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统与用户关系dao
 * Created by ydlx on 2017/7/28.
 */
@Mapper
public interface SysUserMapper {

    /**
     * 写入用户系统关系
     * @param dto
     * @return
     */
    boolean insertSysUser(SysUserDTO dto);


    /**
     * 查询用户系统关系列表
     * @param dto
     * @return
     */
    List<SysUserDTO> getList(SysUserDTO dto);


    /**
     * 删除用户系统关系
     * @param sysId 指定系统
     * @param userId 指定用户
     * @return
     */
    boolean delete(@Param("sysId") String sysId, @Param("userId") String userId);
}
