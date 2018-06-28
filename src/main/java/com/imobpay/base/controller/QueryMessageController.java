package com.imobpay.base.controller;

import com.imobpay.base.commons.result.PageInfo;
import com.imobpay.base.model.monitor.ApplicationMonitor;
import com.imobpay.base.service.InterfaceMonitorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * <pre>
 * 【类型】: QueryMessageController .</br>
 * 【时间】：2018/1/2 16:59 .</br>
 * 【作者】：@author {张翔宇} .</br>
 * </pre>
 */
@Controller
@RequestMapping("/message")
public class QueryMessageController {
    /** 接口信息监控service层 **/
    @Resource
    InterfaceMonitorService interfaceMonitorService;

    @RequestMapping("/queryMessage.json")
    @ResponseBody
    public PageInfo queryMessageList(Model medel,ApplicationMonitor applicationMonitor) {
        return interfaceMonitorService.queryMessage(applicationMonitor);
    }

    @RequestMapping("/queryMessage")
    public String queryMessage() {
        return "monitor/queryMessage";
    }
}
