package org.yrg.domain.activity.model.valobj;

import lombok.*;

import java.math.BigDecimal;


/**
 * @author Yao Renguang
 * @date 2025/9/27
 * @description
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkuVO {

    private String goodsId;
    private String goodsName;
    private BigDecimal originalPrice;

}
