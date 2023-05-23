package main.java.gr.marou.eshop.service.impl;

import main.java.gr.marou.eshop.domain.Order;
import main.java.gr.marou.eshop.repository.Repository;
import main.java.gr.marou.eshop.service.OrderService;

/**
 * Implementation of the OrderService interface.
 * Extends the ServiceImpl class and provides specific functionality related to orders.
 * param @Order the type of orders managed by this service
 */
public class OrderServiceImpl extends ServiceImpl<Order> implements OrderService {
    public OrderServiceImpl(Repository<Order> repository) {
        super(repository);
    }
}
