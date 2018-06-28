package com.imobpay.base.service.system.impl;

/**
 * 包名: package com.imobpay.service.system.impl; <br/>
 * 添加时间: 2017年5月22日 上午11:31:13 <br/>
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.imobpay.base.commons.result.PageInfo;
import com.imobpay.base.mapper.sys.SysMenuMapper;
import com.imobpay.base.model.system.SysMenu;
import com.imobpay.base.service.system.SysMenuService;

/**
 * 类名: SysMenuServiceImpl <br/>
 * 作用： 菜单 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月22日 上午11:31:13 <br/>
 */
@Primary
@Service
public class SysMenuServiceImpl implements SysMenuService {

    /**  */
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public int checkUsedMenu(String menuCode) {
        return sysMenuMapper.checkUsedMenu(menuCode);
    }

    @Override
    public int insertMenu(SysMenu sysMenu) {
        return sysMenuMapper.insertMenu(sysMenu);
    }

    @Override
    public List<SysMenu> selectMenuByRoleId(String roleId) {
        return sysMenuMapper.selectMenuByRoleId(roleId);
    }

    @Override
    public List<SysMenu> selectMenuByUserId(String userId) {
        return sysMenuMapper.selectMenuByUserId(userId);
    }

    @Override
    public int selectMenuCount(SysMenu sysMenu) {
        return sysMenuMapper.selectMenuCount(sysMenu);
    }

    @Override
    public PageInfo selectMenuList(SysMenu sysMenu) {
        PageInfo pageInfo = new PageInfo();
        int      total    = sysMenuMapper.selectMenuCount(sysMenu);

        if (total < 1) {
            return pageInfo;
        }

        pageInfo.setTotal(total);
        pageInfo.setRows(sysMenuMapper.selectMenuList(sysMenu));

        return pageInfo;
    }

    @Override
    public List<SysMenu> selectRoleMenu(String roleId) {
        return sysMenuMapper.selectRoleMenu(roleId);
    }

    @Override
    public List<SysMenu> selectUpMenu() {
        return sysMenuMapper.selectUpMenu();
    }

    @Override
    public int updateMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateMenu(sysMenu);
    }

    @Override
    public int updateRoleMenu(String roleId, List<SysMenu> list) {
        sysMenuMapper.deleteRoleMenu(roleId);
        sysMenuMapper.insertRoleMenu(list);

        return 0;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
