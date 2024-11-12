package com.ibeus.Comanda.Digital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibeus.Comanda.Digital.model.Order;
import com.ibeus.Comanda.Digital.model.Dish;
import com.ibeus.Comanda.Digital.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order create(Order order) {
        double totalPrice = order.getDishes().stream()
                .mapToDouble(Dish::getPrice)
                .sum();
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    public Order update(Long id, Order orderDetails) {
        Order order = findById(id);
        order.setDishes(orderDetails.getDishes());

        double totalPrice = order.getDishes().stream()
                .mapToDouble(Dish::getPrice)
                .sum();
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }

    public void delete(Long id) {
        Order order = findById(id);
        orderRepository.delete(order);
    }
}
