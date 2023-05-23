package main.java.gr.marou.eshop.service.impl;

import main.java.gr.marou.eshop.domain.Itinerary;
import main.java.gr.marou.eshop.repository.ItineraryRepository;
import main.java.gr.marou.eshop.service.ItineraryService;

import java.math.BigDecimal;

/**
 * Implementation of the ItineraryService interface.
 * Extends the ServiceImpl class and provides specific functionality related to itineraries.
 * param <Itinerary> the type of itineraries managed by this service
 */
public class ItineraryServiceImpl extends ServiceImpl<Itinerary> implements ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public ItineraryServiceImpl(ItineraryRepository itineraryRepository){
        super(itineraryRepository);
        this.itineraryRepository = itineraryRepository;
    }

    /**
     * Updates the price of an itinerary.
     * @param itineraryId   the ID of the itinerary to update
     * @param newPrice      the new price
     * @return true if the itinerary is successfully updated, false otherwise
     */
    @Override
    public boolean updateItinerary(long itineraryId, BigDecimal newPrice) {
        return itineraryRepository.updateItinerary(itineraryId, newPrice);
    }
}
