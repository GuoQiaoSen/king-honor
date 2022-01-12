package com.gqs.kinghonor.web;

import com.gqs.kinghonor.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoqiaosen
 * @date 2021/12/30 14:42
 */
@RestController
@RequestMapping("/restrain")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RestrainController {

    private final HeroService heroService;

    @PostMapping("/getRestrain")
    public String getRestrain(@RequestParam("hero_name") String heroName) {
        return heroService.listRestrain(heroName);
    }
}
