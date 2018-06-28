package com.imobpay.base.service.impl;

import com.imobpay.base.commons.result.PageInfo;
import com.imobpay.base.mapper.monitor.ApplicationMonitorMapper;
import com.imobpay.base.model.monitor.ApplicationMonitor;
import com.imobpay.base.service.InterfaceMonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * 【类型】: InterfaceMonitorServiceImpl .</br>
 * 【作用】: ${TODO} ADD FUNCTION. &.</br>
 * 【时间】：2018/1/3 17:02 .</br>
 * 【作者】：${张翔宇} .</br>
 * </pre>
 */
@Service
public class InterfaceMonitorServiceImpl implements InterfaceMonitorService{
    /** 接口信息查询mapper */
    @Resource
    ApplicationMonitorMapper applicationMonitorMapper;

    @Override
    public PageInfo queryMessage(ApplicationMonitor applicationMonitor) {
        PageInfo pageInfo = new PageInfo();
        int      total    = applicationMonitorMapper.selectMenuCount(applicationMonitor);

        if (total < 1) {
            return pageInfo;
        }

        pageInfo.setTotal(total);
        pageInfo.setRows(applicationMonitorMapper.selectList(applicationMonitor));

        return pageInfo;
    }
}
