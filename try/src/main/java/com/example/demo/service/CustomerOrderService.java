package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CustomerOrder;
import com.example.demo.repository.CustomerOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class CustomerOrderService {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerOrderService.class);


    public List<CustomerOrder> getAllOrders() {
        return customerOrderRepository.findAll();
    }

    public CustomerOrder saveOrder(CustomerOrder order) {
        logger.info("Received order for product: " + order.getProductName());
        return customerOrderRepository.save(order);
    }
}