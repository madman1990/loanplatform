package com.imobpay.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    /**
     * 首页跳转
     *
     * @return
     */
    @RequestMapping("/test")
    public String index() {
        return "index";
    }

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/madman")
    public String login() {
        return "login";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
