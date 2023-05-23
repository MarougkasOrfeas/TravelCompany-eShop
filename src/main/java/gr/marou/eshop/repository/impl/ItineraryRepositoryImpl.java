package main.java.gr.marou.eshop.repository.impl;

import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.domain.Itinerary;
import main.java.gr.marou.eshop.repository.ItineraryRepository;

import java.math.BigDecimal;
import java.util.List;

/**
 Implementation of the ItineraryRepository interface.
 Provides operations to manage Itinerary entities.
 */
public class ItineraryRepositoryImpl extends RepositoryImpl<Itinerary> implements ItineraryRepository {
    public ItineraryRepositoryImpl(List<Itinerary> list) {
        super(list);
    }

    /**
     * Updates the price of an itinerary with the specified itinerary ID.
     * @param itineraryId the ID of the itinerary to update
     * @param newPrice the new price for the itinerary
     * @return true if the itinerary was updated successfully, false otherwise
     */
    @Override
    public boolean updateItinerary(long itineraryId, BigDecimal newPrice) {
        Itinerary itinerary = read(itineraryId);
        if(itinerary == null) return false;
        for (Itinerary curItinerary : read()) {
            if (curItinerary.getPrice().equals(newPrice)) {
                return false;
            }
        }
        itinerary.setPrice(newPrice);
        return true;
    }
}
