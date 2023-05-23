package main.java.gr.marou.eshop.service;

import main.java.gr.marou.eshop.domain.Itinerary;

import java.math.BigDecimal;


/**
 Service interface for managing itinerary operations.
 */
public interface ItineraryService extends Service<Itinerary>{
    boolean updateItinerary(long itineraryId, BigDecimal newPrice);
}
