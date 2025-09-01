package com.yash.cafeconnect.dao;

import com.yash.cafeconnect.entity.Order;
import java.util.List;

/**
 * The OrderDao interface defines the standard operations to be performed on Order entity.
 */
public interface OrderDao {
    // Saves a new Order
    void saveOrder(Order order);

    /**
     * Retrieves Order based on orderId.
     * @param orderId
     * @return Order object
     */
    Order getOrder(int orderId);

    // Update Order (matched by Id)
    void updateOrder(Order order);

    // Delete Order by Id
    void deleteOrder(int orderId);

    List<Order> getOrders();
}
