package com.credicoop.utn.services;

import com.credicoop.utn.constants.Constants;
import com.credicoop.utn.entities.Order;
import com.credicoop.utn.exceptions.order.OrderNotFoundException;
import com.credicoop.utn.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){

        this.orderRepository = orderRepository;

    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {

        if (!orderRepository.existsById(id)) {

            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND + id);

        }

        orderRepository.deleteById(id);

    }


    public Order getOrder(Long id) {

        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {

            throw new OrderNotFoundException(Constants.ORDER_NOT_FOUND + id);

        }

        return order.get();

    }


    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }


}
