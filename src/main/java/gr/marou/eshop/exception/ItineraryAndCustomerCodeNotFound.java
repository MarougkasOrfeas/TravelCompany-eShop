package main.java.gr.marou.eshop.exception;

import java.io.Serial;

/**
 Exception thrown when itinerary code or customer code are not found.
 */
public class ItineraryAndCustomerCodeNotFound extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;
    ItineraryAndCustomerCodeNotFound(String message){
        super(message);
    }
}
