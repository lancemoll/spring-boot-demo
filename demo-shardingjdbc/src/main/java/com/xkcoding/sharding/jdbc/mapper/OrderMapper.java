package com.xkcoding.sharding.jdbc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xkcoding.sharding.jdbc.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 订单表 Mapper
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-03-26 13:38
 */
@Component
public interface OrderMapper extends BaseMapper<Order> {

    int insertBatch(@Param("list") List<Order> list);
}
