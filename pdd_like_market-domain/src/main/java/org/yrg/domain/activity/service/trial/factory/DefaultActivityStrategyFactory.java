package org.yrg.domain.activity.service.trial.factory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.yrg.domain.activity.model.entity.MarketProductEntity;
import org.yrg.domain.activity.model.entity.TrialBalanceEntity;
import org.yrg.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import org.yrg.domain.activity.model.valobj.SkuVO;
import org.yrg.domain.activity.service.trial.node.RootNode;
import org.yrg.types.design.framework.tree.StrategyHandler;

import java.math.BigDecimal;

@Service
public class DefaultActivityStrategyFactory {


    private final RootNode rootNode;
    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {

        private GroupBuyActivityDiscountVO groupBuyActivityDiscountVO;
        private SkuVO skuVO;
    }

}