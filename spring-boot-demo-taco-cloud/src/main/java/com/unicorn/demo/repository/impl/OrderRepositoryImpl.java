package com.unicorn.demo.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicorn.demo.domain.entity.Order;
import com.unicorn.demo.domain.entity.Taco;
import com.unicorn.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private SimpleJdbcInsert orderInsert;
    private SimpleJdbcInsert orderTacoInsert;
    private ObjectMapper objectMapper;

    @Autowired
    public OrderRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.orderInsert=new SimpleJdbcInsert(jdbcTemplate).withTableName("taco_order").usingGeneratedKeyColumns("id");
        this.orderTacoInsert=new SimpleJdbcInsert(jdbcTemplate).withTableName("taco_order_tacos");
        this.objectMapper=new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(LocalDate.now());
        long orderId = saveOrderDetails(order);
        order.setId(orderId);
        List<Taco> tacos = order.getTacos();
        for (Taco taco : tacos) {
            saveTacoToOrder(taco, orderId);
        }

        return order;
    }

    private long saveOrderDetails(Order order) {
        @SuppressWarnings("unchecked")
        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());

        return orderInsert.executeAndReturnKey(values).longValue();
    }

    private void saveTacoToOrder(Taco taco, long orderId) {
        Map<String, Object> values = new HashMap<>();
        values.put("taco_order", orderId);
        values.put("taco", taco.getId());
        orderTacoInsert.execute(values);
    }

}
