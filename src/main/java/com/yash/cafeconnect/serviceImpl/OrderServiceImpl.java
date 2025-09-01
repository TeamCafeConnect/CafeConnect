package com.yash.cafeconnect.serviceImpl;

import com.yash.cafeconnect.entity.Order;
import com.yash.cafeconnect.dao.OrderDao;
import com.yash.cafeconnect.daoImpl.OrderDaoImpl;
import com.yash.cafeconnect.service.OrderService;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    // Add Order
    public void addOrder(Order order) {
        if(orderDao.getOrder(order.getOrderId()) != null){
            throw new IllegalStateException("Order with this Id already exists");
        }
        //orderDao.saveOrder(order);

    }
    public Order getOrderById(int orderId) {
        return orderDao.getOrder(orderId);
    }
    public void updateOrder(Order order) {
        if(orderDao.getOrder(order.getOrderId()) == null){
            throw new IllegalStateException("Order with this Id does not exist");
        }
        orderDao.updateOrder(order);
    }
    public void removeOrder(int orderId) {
        if(orderDao.getOrder(orderId) == null){
            throw new IllegalStateException("Order with this Id does not exist");
        }
        orderDao.deleteOrder(orderId);
    }
    public List<Order> getOrders() {
        return orderDao.getOrders();
    }
}
