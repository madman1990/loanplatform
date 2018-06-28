package com.imobpay.base.service;

import com.imobpay.base.commons.result.PageInfo;
import com.imobpay.base.model.monitor.ApplicationMonitor;

import java.util.List;

/**
 * <pre>
 * 【类型】: InterfaceMonitorService .</br>
 * 【作用】: ${TODO} ADD FUNCTION. &.</br>
 * 【时间】：2018/1/3 17:01 .</br>
 * 【作者】：@author 张翔宇 .</br>
 * </pre>
 */
public interface InterfaceMonitorService {
    /**
     * 【方法名】: queryMessage.<br/>
     * 【作者】: @author 张翔宇 .<br/>
     * 【时间】： 2018-01-04  14:43 .<br/>;
     * 【参数】： .<br/>
     *  .<br/>
     * @param applicationMonitor
     * @return java.util.List<com.imobpay.base.model.monitor.ApplicationMonitor><p>
     * 修改记录.<br/>
     * 修改人: 张翔宇 修改描述：创建新新件 .<br/>
     * .<p/>
     */
    PageInfo queryMessage(ApplicationMonitor applicationMonitor);
}
