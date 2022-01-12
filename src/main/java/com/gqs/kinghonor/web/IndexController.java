package com.gqs.kinghonor.web;

import com.gqs.kinghonor.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author guoqiaosen
 * @date 2021/12/30 14:42
 */
@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class IndexController {

    private final HeroService heroService;
    private static final String datePattern = "yyyy-MM-dd E HH:mm:ss";

    @RequestMapping("/index")
    public String methodOne(HttpServletRequest request) {
        request.setAttribute("time", new SimpleDateFormat(datePattern).format(new Date()));
        return "hero";
    }
}
