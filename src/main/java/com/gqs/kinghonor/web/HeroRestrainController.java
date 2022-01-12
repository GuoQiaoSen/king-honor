package com.gqs.kinghonor.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 英雄克制关系表 前端控制器
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@Controller
@RequestMapping("/test")
public class HeroRestrainController {

    private static final String datePattern = "yyyy-MM-dd E HH:mm:ss";

    @RequestMapping("/hello")
    public String methodOne(HttpServletRequest request) {
        request.setAttribute("time", new SimpleDateFormat(datePattern).format(new Date()));
        return "test";
    }
}


