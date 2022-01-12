package com.gqs.kinghonor.web;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 英雄表 前端控制器
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@RestController
@RequestMapping("/hero")
public class HeroController {

    @RequestMapping("/listHero")
    public String listHero(){

        return "hero_list";
    }
}
