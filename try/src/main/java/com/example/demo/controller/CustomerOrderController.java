package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CustomerOrder;
import com.example.demo.service.CustomerOrderService;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return customerOrderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody CustomerOrder order) {
        CustomerOrder savedOrder = customerOrderService.saveOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}