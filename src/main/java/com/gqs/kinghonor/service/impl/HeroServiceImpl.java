package com.gqs.kinghonor.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gqs.kinghonor.mapper.HeroMapper;
import com.gqs.kinghonor.mapper.HeroRestrainMapper;
import com.gqs.kinghonor.model.db.HeroDB;
import com.gqs.kinghonor.model.db.HeroRestrainDB;
import com.gqs.kinghonor.model.request.HeroAddRequest;
import com.gqs.kinghonor.service.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 英雄表 服务实现类
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HeroServiceImpl extends ServiceImpl<HeroMapper, HeroDB> implements HeroService {

    private final HeroMapper heroMapper;
    private final HeroRestrainMapper heroRestrainMapper;

    @Override
    public List<HeroDB> listAll() {
        List<HeroDB> dbList = this.heroMapper.selectList(null);
        return dbList;
    }

    /**
     * 查询克制某个英雄的英雄列表
     *
     * @param heroName
     * @return
     */
    @Override
    public String listRestrain(String heroName) {
        HeroDB heroDB = heroMapper.selectOne(new QueryWrapper<HeroDB>()
                .like("hero_name", heroName));
        if (heroDB == null) {
            return "";
        }

        List<HeroRestrainDB> heroRestrainDBList = heroRestrainMapper.selectList(new QueryWrapper<HeroRestrainDB>()
                .eq("hero_id", heroDB.getId()));

        List<Long> restrainIdList = heroRestrainDBList.stream().map(HeroRestrainDB::getRestrainId).collect(Collectors.toList());

        List<HeroDB> list = heroMapper.selectList(new QueryWrapper<HeroDB>()
                .in("id", restrainIdList));
        return list.stream().map(HeroDB::getHeroName).collect(Collectors.joining("，"));
    }

    @Override
    public void addHero(HeroAddRequest request) {
        HeroDB db = new HeroDB();
        db.setHeroName(request.getHeroName());
        heroMapper.insert(db);
    }

}
