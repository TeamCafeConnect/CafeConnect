package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.OrderHistory;
import java.util.List;

/**
 * Service interface for OrderHistory entity.
 */
public interface OrderHistoryService {
    // Add a new OrderHistory
    void addOrderHistory(OrderHistory orderHistory);
    // Get OrderHistory by OrderId
    OrderHistory getOrderHistoryById(int orderId);
    // Update OrderHistory details
    void updateOrderHistory(OrderHistory orderHistory);
    // Remove OrderHistory by OrderId
    void removeOrderHistory(int orderId);
    // Get list of all OrderHistories
    List<OrderHistory> getOrderHistories();
}
