package com.gqs.kinghonor.service;

import com.gqs.kinghonor.model.request.RestrainAddRequest;

/**
 * <p>
 * 英雄克制关系表 服务类
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
public interface HeroRestrainService {

    /**
     * 添加克制关系
     *
     * @param request
     */
    void addRestrain(RestrainAddRequest request);
}
