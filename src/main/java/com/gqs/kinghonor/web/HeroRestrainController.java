package com.gqs.kinghonor.web;

import com.gqs.kinghonor.model.request.RestrainAddRequest;
import com.gqs.kinghonor.service.HeroRestrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 英雄克制关系表 前端控制器
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@Controller
@RequestMapping("/restrain")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HeroRestrainController {

    private final HeroRestrainService heroRestrainService;

    /**
     * 添加克制关系
     *
     * @param request
     * @return
     */
    @PostMapping("/addRestrain")
    public String addRestrain(@RequestBody RestrainAddRequest request) {
        heroRestrainService.addRestrain(request);
        return "hero";
    }
}


