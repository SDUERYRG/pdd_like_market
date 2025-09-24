package org.yrg.test.infrastructure.dao;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yrg.infrastructure.dao.IGroupBuyDiscountDao;
import org.yrg.infrastructure.dao.po.GroupBuyDiscount;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupBuyDiscountTest {
    @Resource
    private IGroupBuyDiscountDao groupBuyDiscountDao;

    @Test
    public void test(){
        List<GroupBuyDiscount> groupBuyDiscounts = groupBuyDiscountDao.queryGroupBuyDiscountList();
        log.info("测试结果：{}", JSON.toJSONString(groupBuyDiscounts));
    }
}
