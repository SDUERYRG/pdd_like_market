package org.yrg.infrastructure.dao.po;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Yao Renguang
 * @description 拼团活动
 * @create 2025/9/24 25:42
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupBuyActivity {

    private Long id; // 自增

    private Long activityId; // 活动ID

    private String activityName; // 活动名称

    private String discountId; // 折扣ID

    private Integer groupType; // 拼团方式（0自动成团、1达成目标拼团）

    private Integer takeLimitCount; // 拼团次数限制

    private Integer target; // 拼团目标

    private Integer validTime; // 拼团时长（分钟）

    private Integer status; // 活动状态（0创建、1生效、2过期、3废弃）

    private Date startTime; // 活动开始时间

    private Date endTime; // 活动结束时间

    private String tagId; // 人群标签规则标识

    private String tagScope; // 人群标签规则范围（多选；1可见限制、2参与限制）

    private Date createTime; // 创建时间

    private Date updateTime; // 更新时间
}
