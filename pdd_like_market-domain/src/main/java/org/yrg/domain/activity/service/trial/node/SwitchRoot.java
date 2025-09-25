package org.yrg.domain.activity.service.trial.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yrg.domain.activity.model.entity.MarketProductEntity;
import org.yrg.domain.activity.model.entity.TrialBalanceEntity;
import org.yrg.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import org.yrg.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.yrg.types.design.framework.tree.StrategyHandler;

@Slf4j
@Service
public class SwitchRoot extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {
    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }
}
