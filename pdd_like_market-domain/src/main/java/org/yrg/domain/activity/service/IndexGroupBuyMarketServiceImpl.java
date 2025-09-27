package org.yrg.domain.activity.service;

import org.springframework.stereotype.Service;
import org.yrg.domain.activity.model.entity.MarketProductEntity;
import org.yrg.domain.activity.model.entity.TrialBalanceEntity;
import org.yrg.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.yrg.types.design.framework.tree.StrategyHandler;

import javax.annotation.Resource;

@Service
public class IndexGroupBuyMarketServiceImpl implements IIndexGroupBuyMarketService{

    @Resource
    private DefaultActivityStrategyFactory defaultActivityStrategyFactory;

    /*
     * @description 首页营销试算
     */
    @Override
    public TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception {

        //返回一个RootNode类型
        StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler = defaultActivityStrategyFactory.strategyHandler();

        strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());

        return strategyHandler.apply(marketProductEntity, new DefaultActivityStrategyFactory.DynamicContext());
    }
}
