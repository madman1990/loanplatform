package com.imobpay.base.kaptch;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Configuration
public class MyKaptcha {
    @Bean
    public DefaultKaptcha getKaptchaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties     properties     = new Properties();

        // 是否设置边框
        properties.setProperty("kaptcha.border", "no");

        // 设置字体的颜色
        properties.setProperty("kaptcha.textproducer.font.color", "red");

        // 设置验证码的宽度
        properties.setProperty("kaptcha.image.width", "135");

        // 设置验证码的高度
        properties.setProperty("kaptcha.textproducer.char.string", "ACDEFHKPRSTWX345679");
        properties.setProperty("kaptcha.image.height", "40");
        properties.setProperty("kaptcha.textproducer.font.size", "28");
        properties.setProperty("kaptcha.noise.color", "black");
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        properties.setProperty("kaptcha.textproducer.font.names", "Arial");

        Config config = new Config(properties);

        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
