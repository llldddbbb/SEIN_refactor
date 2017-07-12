package com.sein.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * Created by ldb on 2017/4/2.
 * 国际化 配置文件
 */
@Configuration
public class InternationalizationConfig {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        //设置默认区域，中国
        slr.setDefaultLocale(Locale.CHINA);
        return slr;
    }
}
