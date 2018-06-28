package com.imobpay.base.service.system.impl;

/**
 * 包名: package com.imobpay.service.system.impl; <br/>
 * 添加时间: 2017年5月24日 下午6:19:06 <br/>
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobpay.base.mapper.sys.SysParamMapper;
import com.imobpay.base.model.system.SysParam;
import com.imobpay.base.service.system.SysParamService;

/**
 * 类名: SysParamServiceImpl <br/>
 * 作用： 参数 <br/>
 * 创建者: Ferry Chen. <br/>
 * 添加时间: 2017年5月24日 下午6:19:06 <br/>
 */
@Service
public class SysParamServiceImpl implements SysParamService {

    /**  */
    @Autowired
    private SysParamMapper sysParamMapper;

    @Override
    public List<Map<String, Object>> selectAppList() {
        return sysParamMapper.selectAppList();
    }

    @Override
    public List<Map<String, Object>> selectAwardLevel() {
        return sysParamMapper.selectAwardLevel();
    }

    @Override
    public List<Map<String, Object>> selectBranchList(String appId) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("appId", appId);

        return sysParamMapper.selectBranchList(map);
    }

    @Override
    public List<Map<String, Object>> selectCustLevel() {
        return sysParamMapper.selectCustLevel();
    }

    @Override
    public List<SysParam> selectSysParamByType(String paramType) {
        return sysParamMapper.selectSysParamByType(paramType);
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
