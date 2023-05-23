package main.java.gr.marou.eshop.repository;

import main.java.gr.marou.eshop.domain.Itinerary;

import java.math.BigDecimal;


/**
 Repository interface for managing itineraries.
 Extends the generic Repository interface for itinerary-specific operations.
 */
public interface ItineraryRepository extends Repository<Itinerary>{
    boolean updateItinerary(long itineraryId, BigDecimal newPrice);
}
