package main.java.gr.marou.eshop.repository.impl;

import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.repository.OrderedTicketRepository;
import java.util.List;

/**
 Implementation of the OrderedTicketRepository interface.
 Provides operations to manage OrderedTicket entities.
 */
public class OrderedTicketRepositoryImpl extends RepositoryImpl<OrderedTicket> implements OrderedTicketRepository {
    public OrderedTicketRepositoryImpl(List<OrderedTicket> list) {
        super(list);
    }

    /**
     * Updates the payment method of an ordered ticket with the specified order ticket ID.
     * @param orderTicketsId the ID of the ordered ticket to update
     * @param paymentMethods the new payment method for the ordered ticket
     * @return true if the ordered ticket was updated successfully, false otherwise
     */
    @Override
    public boolean updateOrderedTicket(long orderTicketsId, PaymentMethods paymentMethods) {
        OrderedTicket orderedTicket = read(orderTicketsId);
        if(orderedTicket == null) return false;
        for(OrderedTicket curOrderedTicket : read()){
            if(curOrderedTicket.getPaymentMethod().equals(paymentMethods)){
                return false;
            }
        }
        orderedTicket.setPaymentMethod(paymentMethods);
        return true;
    }
}
