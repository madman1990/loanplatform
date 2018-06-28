package com.imobpay.base.commons.base;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.apache.shiro.SecurityUtils;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.imobpay.base.commons.result.Result;
import com.imobpay.base.commons.shiro.ShiroUser;
import com.imobpay.base.commons.utils.StringEscapeEditor;
import com.imobpay.base.commons.utils.excel.BeanUtils;
import com.imobpay.base.constant.GlobalConstant;

/**
 * <pre>
 *  Project Name: .</br>
 *  File: BaseController.java .</br>
 *  Package Name:com.imobpay.base.commons.base .</br>
 *  Date             Changes .</br>
 *  @author madman     Create  .</br>
 *  Description: .</br>
 *  Copyright 2014-2015 YINGXIANG FINANCE Services Co.,Ltd. All rights reserved..</br>
 *  <pre>
 */
public abstract class BaseController {

    /**
     * 【方法名】 : init. <br/>
     * 【作者】: Ferry Chen .<br/>
     * 【时间】： 2017年5月23日 上午10:22:05 .<br/>
     * 【参数】： .<br/>
     *
     * @param binder .<br/>
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {

        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class,
                                    new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));

        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }

    /**
     * ajax失败
     *
     * @param msg 失败的消息
     * @return {Object}
     */
    public Object renderError(String msg) {
        Result result = new Result();

        result.setMsg(msg);

        ModelAndView view = new ModelAndView();

        view.addObject(BeanUtils.toMap(result));

        return result;
    }

    /**
     * ajax成功
     *
     * @return {Object}
     */
    public Object renderSuccess() {
        Result result = new Result();

        result.setSuccess(true);

        return result;
    }

    /**
     * ajax成功
     *
     * @param obj 成功时的对象
     * @return {Object}
     */
    public Object renderSuccess(Object obj) {
        Result result = new Result();

        result.setMsg(GlobalConstant.EXECU_SUCCESS);
        result.setSuccess(true);
        result.setObj(obj);

        return result;
    }

    /**
     * ajax成功
     *
     * @param msg 消息
     * @return {Object}
     */
    public Object renderSuccess(String msg) {
        Result result = new Result();

        result.setSuccess(true);
        result.setMsg(msg);

        return result;
    }

    /**
     * 获取当前登录用户名
     *
     * @return {String}
     */
    public String getLoginName() {
        return this.getShiroUser().getLoginName();
    }

    /**
     * 获取当前登录用户对象
     *
     * @return {ShiroUser}
     */
    public ShiroUser getShiroUser() {
        return (ShiroUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前真实用户名
     *
     * @return {String}
     */
    public String getStaffName() {
        return this.getShiroUser().getName();
    }

    /**
     * 获取当前登录用户id
     *
     * @return {Long}
     */
    public String getUserId() {
        return this.getShiroUser().getId();
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
