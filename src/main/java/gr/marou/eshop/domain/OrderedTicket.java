package main.java.gr.marou.eshop.domain;

import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.utility.ExceptionHandlingMethods;
import lombok.*;

import java.math.BigDecimal;

/**
 Represents an ordered ticket in the e-shop system.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderedTicket implements Entity{

    private long id;
    private Customer customer;
    private Itinerary itinerary;
    private PaymentMethods paymentMethod;
    private BigDecimal paymentAmount;

    /**
     Retrieves the ID of the ordered ticket.
     @return the ID of the ordered ticket
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     Checks if the ordered ticket is valid.
     @return true if the ordered ticket is valid, false otherwise
     */
    @Override
    public boolean isValid() {
        return !ExceptionHandlingMethods.nonExistingItineraryOrCustomer(customer.getId(), itinerary.getId());
    }
}
