package com.imobpay.base.mapper.monitor;

import com.imobpay.base.model.monitor.ApplicationMonitor;

import java.util.List;

/**
 * <pre>
 * 【类型】: ApplicationMonitorMapper .</br>
 * 【时间】：2018/1/4 14:18 .</br>
 * 【作者】：@author 张翔宇 .</br>
 * </pre>
 */
public interface ApplicationMonitorMapper {
    /**
     * 【方法名】: 查询接口监控的集合.<br/>
     * 【注意】: (这里描述这个方法的注意事项 – 可选).<br/>
     * 【作者】: @author 张翔宇 .<br/>
     * 【时间】： 2018-01-04  14:48 .<br/>;
     * 【参数】： .<br/>
     *  @param application 接口名字.<br/>
     *  @return java.util.List<com.imobpay.base.model.monitor.ApplicationMonitor><p>
     * 修改记录.<br/>
     * 修改人: 张翔宇 修改描述：创建新新件 .<br/>
     * .<p/>
     */
    public List<ApplicationMonitor> selectList(ApplicationMonitor applicationMonitor);

    /**
     * 【方法名】: selectMenuCount.<br/>
     * 【作者】: @author 张翔宇 .<br/>
     * 【时间】： 2018-01-05  14:15 .<br/>;
     * 【参数】： .<br/>
     * @param applicationMonitor .<br/>
     * @return int<p>
     * 修改记录.<br/>
     * 修改人: 张翔宇 修改描述：创建新新件 .<br/>
     * .<p/>
     */
    int selectMenuCount(ApplicationMonitor applicationMonitor);
}
