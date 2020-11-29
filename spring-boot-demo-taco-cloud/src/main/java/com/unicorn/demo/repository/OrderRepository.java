package com.unicorn.demo.repository;

import com.unicorn.demo.domain.entity.Order;

public interface OrderRepository {

    Order save(Order order);

}
