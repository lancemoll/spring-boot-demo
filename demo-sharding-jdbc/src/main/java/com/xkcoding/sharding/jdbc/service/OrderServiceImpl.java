package com.xkcoding.sharding.jdbc.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xkcoding.sharding.jdbc.mapper.OrderMapper;
import com.xkcoding.sharding.jdbc.model.Order;
import org.springframework.stereotype.Service;

/**
 * <p>
 * <a href="OrderServiceImpl.java"><i>View Source</i></a>
 *
 * @author Elin.zhou
 * Date: 2023/3/15 11:34
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
