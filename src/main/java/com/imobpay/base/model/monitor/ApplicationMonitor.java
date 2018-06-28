package com.imobpay.base.model.monitor;

import com.imobpay.base.model.BaseModel;

/**
 * <pre>
 * 【类型】: ApplicationMonitor .</br>
 * 【时间】：2018/1/4 14:18 .</br>
 * 【作者】：@author 张翔宇} .</br>
 * </pre>
 */
public class ApplicationMonitor extends BaseModel {
    /** id */
    private String id;
    /** 机构号 */
    private String branchId;
    /** 接口名称 */
    private String application;
    /** 请求时间 */
    private String reqTime;
    /** 返回时间 */
    private String respTime;
    /** 响应时长* */
    private String tradeLongTime;
    /** 客户编号 */
    private String customerId;
    /** 返回码 */
    private String respCode;
    /** 返回描述 */
    private String respDesc;
    /** 进程编号 */
    private String logKey;
    /** 隶属服务 */
    private String frmSys;
    /** 请求时间范围开始 */
    private String startTime;
    /** 请求时间范围结束 */
    private String endTime;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getReqTime() {
        return reqTime;
    }

    public void setReqTime(String reqTime) {
        this.reqTime = reqTime;
    }

    public String getRespTime() {
        return respTime;
    }

    public void setRespTime(String respTime) {
        this.respTime = respTime;
    }

    public String getTradeLongTime() {
        return tradeLongTime;
    }

    public void setTradeLongTime(String tradeLongTime) {
        this.tradeLongTime = tradeLongTime;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getLogKey() {
        return logKey;
    }

    public void setLogKey(String logKey) {
        this.logKey = logKey;
    }

    public String getFrmSys() {
        return frmSys;
    }

    public void setFrmSys(String frmSys) {
        this.frmSys = frmSys;
    }
}
