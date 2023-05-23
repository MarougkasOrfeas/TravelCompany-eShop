package main.java.gr.marou.eshop.service.impl;

import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.repository.OrderedTicketRepository;
import main.java.gr.marou.eshop.service.OrderedTicketService;

/**
 * Implementation of the OrderedTicketService interface.
 * Extends the ServiceImpl class and provides specific functionality related to ordered tickets.
 * param <OrderedTicket> the type of ordered tickets managed by this service
 */
public class OrderedTicketServiceImpl extends ServiceImpl<OrderedTicket> implements OrderedTicketService {

    private final OrderedTicketRepository orderedTicketRepository;

    public OrderedTicketServiceImpl(OrderedTicketRepository orderedTicketRepository){
        super(orderedTicketRepository);
        this.orderedTicketRepository = orderedTicketRepository;
    }

    /**
     * Updates the payment method of an ordered ticket.
     * @param orderTicketsId   the ID of the ordered ticket to update
     * @param paymentMethods   the new payment method
     * @return true if the ordered ticket is successfully updated, false otherwise
     */
    @Override
    public boolean updateOrderedTicket(long orderTicketsId, PaymentMethods paymentMethods) {
        return orderedTicketRepository.updateOrderedTicket(orderTicketsId,paymentMethods);
    }
}
