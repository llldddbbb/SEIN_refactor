package com.sein.controller;

import com.sein.pojo.dto.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by ldb on 2017/4/2.
 */
@Controller
public class InternationalizationController {

    private String lang = "zh";

    @RequestMapping("/changeSessionLanguage")
    public String changeSessionLanguage(HttpServletRequest request, String page) throws Exception {
        if ("zh".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("en", "US"));
            lang = "en";
        } else if ("en".equals(lang)) {
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, new Locale("zh", "CN"));
            lang = "zh";
        }
        return "redirect:/" + page;
    }

    @RequestMapping("/changeMessageInfoLanguage")
    @ResponseBody
    public Result changeMessageInfoLanguage(HttpServletResponse response) throws Exception {
        if ("en".equals(lang)) {
            return Result.isOK();
        } else {
            return Result.isNotOK();
        }
    }
}
