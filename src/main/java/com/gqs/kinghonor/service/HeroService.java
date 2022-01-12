package com.gqs.kinghonor.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gqs.kinghonor.model.db.HeroDB;

import java.util.List;

/**
 * <p>
 * 英雄表 服务类
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
public interface HeroService extends IService<HeroDB> {

    List<HeroDB> listAll();

    /**
     * 查询克制某个英雄的英雄列表
     *
     * @param heroName
     * @return
     */
    String listRestrain(String heroName);
}
