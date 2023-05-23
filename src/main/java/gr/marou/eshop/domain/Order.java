package main.java.gr.marou.eshop.domain;

import lombok.*;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.dto.CustomerDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents an order placed by a customer.
 */
@Data
public class Order implements Entity {

    private String orderTrackingNumber;
    private CustomerDto customerDto;
    private LocalDateTime localDateTime;
    private Itinerary itinerary;
    private int quantity;
    private BigDecimal price;
    private PaymentMethods paymentMethod;

    /**
     * Retrieves the ID of the order.
     * @return the ID of the order
     */
    @Override
    public long getId() {
        return Long.parseLong(orderTrackingNumber);
    }

    /**
     * Checks if the order is valid.
     * @return true if the order is valid, false otherwise
     */
    @Override
    public boolean isValid() {
        return orderTrackingNumber != null
                && customerDto != null
                && localDateTime != null
                && itinerary != null
                && quantity > 0
                && price != null
                && paymentMethod != null;
    }

}
