package main.java.gr.marou.eshop.service;

import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;

/**
 Service interface for managing ordered ticket operations.
 */
public interface OrderedTicketService extends Service<OrderedTicket>{
    boolean updateOrderedTicket(long orderTicketsId, PaymentMethods paymentMethods);
}
