package org.yrg.domain.activity.service.trial.node;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yrg.domain.activity.model.entity.MarketProductEntity;
import org.yrg.domain.activity.model.entity.TrialBalanceEntity;
import org.yrg.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import org.yrg.domain.activity.model.valobj.SkuVO;
import org.yrg.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import org.yrg.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.yrg.domain.activity.service.trial.thread.QueryGroupBuyActivityDiscountVOThreadTask;
import org.yrg.domain.activity.service.trial.thread.QuerySkuVOFromDBThreadTask;
import org.yrg.types.design.framework.tree.StrategyHandler;

import javax.annotation.Resource;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class MarketNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Resource
    private  EndNode endNode;

    @Override
    protected void multiThead(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        QueryGroupBuyActivityDiscountVOThreadTask queryGroupBuyActivityDiscountVOThreadTask=new QueryGroupBuyActivityDiscountVOThreadTask(requestParameter.getSource(), requestParameter.getChannel(),repository);
        FutureTask<GroupBuyActivityDiscountVO> groupBuyActivityDiscountVOFutureTask = new FutureTask<>(queryGroupBuyActivityDiscountVOThreadTask);
        threadPoolExecutor.execute(groupBuyActivityDiscountVOFutureTask);

        QuerySkuVOFromDBThreadTask querySkuVOFromDBThreadTask=new QuerySkuVOFromDBThreadTask(requestParameter.getGoodsId(), repository);
        FutureTask<SkuVO> skuVOFutureTask = new FutureTask<>(querySkuVOFromDBThreadTask);
        threadPoolExecutor.execute(skuVOFutureTask);

        dynamicContext.setGroupBuyActivityDiscountVO(groupBuyActivityDiscountVOFutureTask.get(timeOut, TimeUnit.MINUTES));
        dynamicContext.setSkuVO(skuVOFutureTask.get(timeOut, TimeUnit.MINUTES));
    }

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return endNode;
    }
}
