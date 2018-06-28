package com.imobpay.base.controller;

import java.awt.image.BufferedImage;

import java.io.IOException;

import java.util.Date;

import javax.annotation.Resource;

import javax.imageio.ImageIO;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * 获取验证码的controller
 *
 * @author madman
 *
 */
@Controller
@RequestMapping("/kaptcha")
public class KaptchaContoller {
    @Resource
    DefaultKaptcha defaultKaptcha;

    @RequestMapping("/getKaptcha")
    public void getKaptcha(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            resp.setHeader("Cache-Control", "no-store, no-cache");
            resp.setContentType("image/jpeg");

            String createText = defaultKaptcha.createText();

            req.getSession().setAttribute("vrifyCode", createText);

            BufferedImage       challenge = defaultKaptcha.createImage(createText);
            ServletOutputStream out       = resp.getOutputStream();

            ImageIO.write(challenge, "jpg", out);
            req.getSession().setAttribute(defaultKaptcha.getConfig().getSessionKey(), createText);
            req.getSession().setAttribute(defaultKaptcha.getConfig().getSessionDate(), new Date());
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);

            return;
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
