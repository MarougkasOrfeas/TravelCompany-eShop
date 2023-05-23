package main.java.gr.marou.eshop.repository.impl;

import main.java.gr.marou.eshop.domain.Order;
import main.java.gr.marou.eshop.repository.OrderRepository;
import java.util.List;


/**
 Implementation of the OrderRepository interface.
 Provides operations to manage Order entities.
 */
public class OrderRepositoryImpl extends RepositoryImpl<Order> implements OrderRepository {
    public OrderRepositoryImpl(List<Order> list) {
        super(list);
    }
}
