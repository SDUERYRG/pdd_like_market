package org.yrg.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import org.yrg.infrastructure.dao.po.Sku;

/**
 * @author Yao Renguang
 * @date 2025/9/27
 * @description
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
