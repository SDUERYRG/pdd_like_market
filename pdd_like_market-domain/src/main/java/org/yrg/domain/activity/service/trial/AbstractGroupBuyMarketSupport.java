package org.yrg.domain.activity.service.trial;


import org.yrg.domain.activity.adapter.repository.IActivityRepository;
import org.yrg.domain.activity.model.entity.MarketProductEntity;
import org.yrg.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.yrg.types.design.framework.tree.AbstractMultiThreadStrategyRouter;

import javax.annotation.Resource;


public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, Object, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<org.yrg.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, org.yrg.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeOut=5000;

    @Resource
    protected IActivityRepository repository;
    @Override
    protected void multiThead(org.yrg.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {

    }
}
