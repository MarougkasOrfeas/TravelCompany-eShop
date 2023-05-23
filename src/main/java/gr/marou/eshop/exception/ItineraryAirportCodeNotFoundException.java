package main.java.gr.marou.eshop.exception;

import java.io.Serial;

/**
 Exception thrown when the airport code for an itinerary is not found.
 */
public class ItineraryAirportCodeNotFoundException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;
    public ItineraryAirportCodeNotFoundException(String message){
        super(message);
    }
}
