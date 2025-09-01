package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Order;

import java.util.List;

public interface OrderDao {
    void saveOrder(Order order);
    Order getOrderById(int orderId);
    void updateOrder(Order order);
    void deleteOrder(int orderId);

    List<Order> getAllOrders();
}
