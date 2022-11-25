package com.credicoop.utn.controllers;

import com.credicoop.utn.dto.OrderDTO;
import com.credicoop.utn.entities.Order;
import com.credicoop.utn.mappers.OrderMapper;
import com.credicoop.utn.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/order/")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService, OrderMapper orderMapper){

        this.orderService = orderService;
        this.orderMapper = orderMapper;

    }


    @PostMapping(value = "add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody OrderDTO orderDTO){

        orderDTO.setOrderDate(LocalDate.now());

        Order order = orderMapper.convertToEntity(orderDTO);
        orderService.addOrder(order);

    }

    @DeleteMapping(value =  "delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrder(@PathVariable("id") Long id){

        orderService.deleteOrder(id);

    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrder(@PathVariable("id") Long id){

        Order order = orderService.getOrder(id);
        return orderMapper.convertToDto(order);

    }

    @GetMapping(value = "all")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getAllOrder(){

        List<Order> orderList = orderService.getAllOrder();
        return orderMapper.ListConvertToDto(orderList);
    }

}
