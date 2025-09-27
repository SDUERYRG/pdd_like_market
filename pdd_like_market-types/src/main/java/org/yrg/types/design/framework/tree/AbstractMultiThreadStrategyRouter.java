package org.yrg.types.design.framework.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Yao Renguang
 * @date 2025/9/27
 * @description 异步加载数据
 */
public abstract class AbstractMultiThreadStrategyRouter<T, D, R> implements StrategyMapper<T, D, R>, StrategyHandler<T, D, R> {

    @Setter
    @Getter
    protected StrategyHandler<T, D, R> defaultStrategyHandler = StrategyHandler.DEFAULT;

    public R router(T requestParameter, D dynamicContext) throws Exception {
        StrategyHandler<T, D, R> strategyHandler = get(requestParameter, dynamicContext);
        if(null != strategyHandler) return strategyHandler.apply(requestParameter, dynamicContext);
        return defaultStrategyHandler.apply(requestParameter, dynamicContext);
    }

    @Override
    public R apply(T requestParameter, D dynamicContext) throws Exception {
        multiThead(requestParameter,dynamicContext);
        return doApply(requestParameter,dynamicContext);
    }

    protected abstract void multiThead(T requestParameter, D dynamicContext)throws Exception;

    protected abstract R doApply(T requestParameter, D dynamicContext)throws Exception;
}
