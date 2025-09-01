package com.yash.cafeconnect.dao;
import com.yash.cafeconnect.entity.OrderHistory;
import java.util.List;

/**
 * The OrderHistoryDao interface defines the standard operations to be performed on OrderHistory entity.
 */
public interface OrderHistoryDao {
    // Saves a new OrderHistory
    void saveOrderHistory(OrderHistory orderHistory);

    /**
     * Retrieves OrderHistory based on orderId.
     * @param orderId
     * @return OrderHistory object
     */
    OrderHistory getOrderHistory(int orderId);

    // Update OrderHistory (matched by Id)
    void updateOrderHistory(OrderHistory orderHistory);

    // Delete OrderHistory by Id
    void deleteOrderHistory(int orderId);

    List<OrderHistory> getOrderHistories();
}

