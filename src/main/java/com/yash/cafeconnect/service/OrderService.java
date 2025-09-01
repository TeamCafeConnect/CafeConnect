package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.Order;
import java.util.List;

/**
 * Service interface for Order entity.
 */
public interface OrderService {
    // Add a new Order
    void addOrder(Order order);
    // Get Order by Id
    Order getOrderById(int orderId);
    // Update Order details
    void updateOrder(Order order);
    // Remove Order by Id
    void removeOrder(int orderId);
    // Get list of all Orders
    List<Order> getOrders();
}
