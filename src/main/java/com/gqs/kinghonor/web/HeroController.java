package com.gqs.kinghonor.web;

import com.gqs.kinghonor.model.request.HeroAddRequest;
import com.gqs.kinghonor.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 英雄表 前端控制器
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@Controller
@RequestMapping("/hero")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HeroController {

    private final HeroService heroService;

    /**
     * 添加英雄
     *
     * @return
     */
    @PostMapping("/addHero")
    public String addHero(@RequestBody HeroAddRequest request) {
        heroService.addHero(request);
        return "hero";
    }

    /**
     * 查询英雄的克制英雄
     *
     * @param heroName
     * @return
     */
    @PostMapping("/getRestrain")
    @ResponseBody
    public String getRestrain(@RequestParam("hero_name") String heroName) {
        return heroService.listRestrain(heroName);
    }

    @RequestMapping("/listHero")
    public String listHero() {
        return "hero_list";
    }
}
