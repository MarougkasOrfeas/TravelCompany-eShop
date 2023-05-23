package main.java.gr.marou.eshop.service;

import main.java.gr.marou.eshop.domain.Order;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;

/**
 Service interface for managing the e-shop functionality.
 */
public interface EshopService {

    String displayCustomers();
    String displayItineraries();
    String displayOrderedTickets();
    Order createOrder(long customerId, long flightId, int ticketQuantity, PaymentMethods paymentMethod);
    StringBuilder displayOrders(long customerId);

}
