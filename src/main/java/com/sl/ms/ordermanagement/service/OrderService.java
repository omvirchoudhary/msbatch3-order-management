package com.sl.ms.ordermanagement.service;

import com.sl.ms.ordermanagement.items.Items;
import com.sl.ms.ordermanagement.items.ItemsRepository;
import com.sl.ms.ordermanagement.orders.Orders;
import com.sl.ms.ordermanagement.orders.OrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class.getName());

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Orders> getOrders() {

        return ordersRepository.findAll();
    }

    public Optional<Orders> getById(Long id) {
        return ordersRepository.findById(id);
    }

    public Items saveItems(Items items) {
        return itemsRepository.save(items);
    }

    public void delete(Long id) {
        ordersRepository.deleteById(id);
    }
}