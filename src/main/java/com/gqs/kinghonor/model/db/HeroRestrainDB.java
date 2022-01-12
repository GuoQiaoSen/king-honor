package com.gqs.kinghonor.model.db;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 英雄克制关系表
 * </p>
 *
 * @author mybatis-plus generator
 * @since 2021-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("g_hero_restrain")
public class HeroRestrainDB extends Model<HeroRestrainDB> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 英雄id
     */
    private Long heroId;

    /**
     * 克制英雄id
     */
    private Long restrainId;

    /**
     * 克制理由
     */
    private String reason;

    private Long createId;

    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
