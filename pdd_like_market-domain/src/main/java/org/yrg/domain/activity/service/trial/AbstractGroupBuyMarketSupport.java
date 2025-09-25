package org.yrg.domain.activity.service.trial;

import org.yrg.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import org.yrg.types.design.framework.tree.AbstractStrategyRouter;

public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, Object, TrialBalanceEntity> extends AbstractStrategyRouter<org.yrg.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, org.yrg.domain.activity.model.entity.TrialBalanceEntity> {

}
