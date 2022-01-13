package com.gqs.kinghonor.model.request;

import lombok.Data;

/**
 * @author guoqiaosen
 * @date 2022/1/13 10:13
 */
@Data
public class RestrainAddRequest {
    // 强势英雄
    private String add_restrain_1;
    // 弱势英雄
    private String add_restrain_2;
    // 克制理由
    private String reason;
}
