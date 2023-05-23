package main.java.gr.marou.eshop.repository;

import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;


/**
 Repository interface for managing ordered tickets.
 Extends the generic Repository interface for ordered ticket-specific operations.
 */
public interface OrderedTicketRepository extends Repository<OrderedTicket> {

    boolean updateOrderedTicket(long orderTicketsId, PaymentMethods paymentMethods);
}
