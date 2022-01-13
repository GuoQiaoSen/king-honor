package com.gqs.kinghonor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gqs.kinghonor.mapper.HeroMapper;
import com.gqs.kinghonor.mapper.HeroRestrainMapper;
import com.gqs.kinghonor.model.db.HeroDB;
import com.gqs.kinghonor.model.db.HeroRestrainDB;
import com.gqs.kinghonor.model.request.RestrainAddRequest;
import com.gqs.kinghonor.service.HeroRestrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 英雄克制关系表 服务实现类
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HeroRestrainServiceImpl implements HeroRestrainService {

    private final HeroMapper heroMapper;
    private final HeroRestrainMapper heroRestrainMapper;

    @Override
    public void addRestrain(RestrainAddRequest request) {
        // 强势英雄
        HeroDB heroDB1 = heroMapper.selectOne(new QueryWrapper<HeroDB>()
                .eq("hero_name", request.getAdd_restrain_1()));
        // 弱势英雄
        HeroDB heroDB2 = heroMapper.selectOne(new QueryWrapper<HeroDB>()
                .eq("hero_name", request.getAdd_restrain_2()));

        HeroRestrainDB heroRestrainDB = new HeroRestrainDB();
        heroRestrainDB.setHeroId(heroDB2.getId());
        heroRestrainDB.setRestrainId(heroDB1.getId());
        heroRestrainDB.setReason(request.getReason());
        heroRestrainDB.setCreateId(0L);
        heroRestrainDB.setCreateTime(LocalDateTime.now());
        heroRestrainMapper.insert(heroRestrainDB);
    }
}
