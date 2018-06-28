package com.imobpay.base.controller;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imobpay.base.model.system.SysUser;

@Controller
public class ThymeleafContronller {
    @RequestMapping("/exampleThymeLeaf")
    public String exampleThymeLeaf(Model map) {
        List<String> list = new ArrayList<String>();

        map.addAttribute("list", list);
        map.addAttribute("logo", "this is logo");
        map.addAttribute("even", "true");
        map.addAttribute("execMode", "dev");
        map.addAttribute("count", "6");
        map.addAttribute("text", "haha");
        map.addAttribute("name", "Hello Word");
        map.addAttribute("utext", "这是测试<br></br>text的");

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY年MM月dd日");
        String           dateString = dateFormat.format(new Date());
        String           format     = dateFormat.format(new Date());

        System.out.println("当前时间是：" + dateString);
        map.addAttribute("currDate", dateString);
        map.addAttribute("today", Calendar.getInstance());

        SysUser user = new SysUser();

        user.setLoginName("madman");
        user.setPassword("madman");
        map.addAttribute("user", user);
        map.addAttribute("url", "http://www.sina.com");

        return "thymeLeaf";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
