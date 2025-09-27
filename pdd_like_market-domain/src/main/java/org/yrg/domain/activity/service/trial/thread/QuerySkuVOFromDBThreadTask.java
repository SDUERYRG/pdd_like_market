package org.yrg.domain.activity.service.trial.thread;

import org.yrg.domain.activity.adapter.repository.IActivityRepository;
import org.yrg.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * @author Yao Renguang
 * @date 2025/9/27
 * @description
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;
    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }
}
