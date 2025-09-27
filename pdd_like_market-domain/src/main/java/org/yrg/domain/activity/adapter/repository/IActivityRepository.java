package org.yrg.domain.activity.adapter.repository;

import org.yrg.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import org.yrg.domain.activity.model.valobj.SkuVO;

/**
 * @author Yao Renguang
 * @date 2025/9/27
 * @description
 */
public interface IActivityRepository {

    GroupBuyActivityDiscountVO queryGroupBuyActivityDiscountVO(String source, String channel);

    SkuVO querySkuByGoodsId(String goodsId);

}
