package com.imobpay.base.service.system.impl;

/**
 * 包名: package com.imobpay.service.system.impl; <br/>
 * 添加时间: 2017年5月19日 下午1:50:03 <br/>
 */
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobpay.base.commons.result.PageInfo;
import com.imobpay.base.mapper.sys.SysMenuMapper;
import com.imobpay.base.mapper.sys.SysRoleMapper;
import com.imobpay.base.model.system.SysRole;
import com.imobpay.base.service.system.SysRoleService;

/**
 * 类名: SysRoleServiceImpl <br/>
 * 作用： 角色<br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月19日 下午1:50:03 <br/>
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    /**  */
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**  */
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int deleteRole(SysRole sysRole) {
        sysMenuMapper.deleteRoleMenu(sysRole.getRoleId());

        return sysRoleMapper.deleteRole(sysRole);
    }

    @Override
    public int insertRole(SysRole sysRole) {
        return sysRoleMapper.insertRole(sysRole);
    }

    @Override
    public PageInfo selectRoleList(SysRole sysRole) {
        PageInfo pageInfo  = new PageInfo();
        int      pageCount = sysRoleMapper.selectRoleListCount(sysRole);

        if (pageCount < 1) {
            return pageInfo;
        }

        pageInfo.setTotal(pageCount);
        pageInfo.setRows(sysRoleMapper.selectRoleList(sysRole));

        return pageInfo;
    }

    @Override
    public int selectRoleListCount(SysRole sysRole) {
        return sysRoleMapper.selectRoleListCount(sysRole);
    }

    @Override
    public List<SysRole> selectRolesByUserId(String userId) {
        return sysRoleMapper.selectRolesByUserId(userId);
    }

    @Override
    public List<SysRole> selectSysRoleList() {
        return sysRoleMapper.selectSysRoleList();
    }

    @Override
    public Map<String, Object> selectUserExistByRoleId(String roleId) {
        return sysRoleMapper.selectUserExistByRoleId(roleId);
    }

    @Override
    public int updateRole(SysRole sysRole) {
        return sysRoleMapper.updateRole(sysRole);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
