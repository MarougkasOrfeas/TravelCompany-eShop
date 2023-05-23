package main.java.gr.marou.eshop.domain;

import main.java.gr.marou.eshop.utility.ExceptionHandlingMethods;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Represents an itinerary for a flight.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Itinerary implements Entity{

    private long id;
    private String departureCode;
    private String destinationCode;
    private LocalDateTime departureDate;
    private String airline;
    private BigDecimal price;

    /**
     * Retrieves the ID of the itinerary.
     * @return the ID of the itinerary
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * Checks if the itinerary is valid.
     * @return true if the itinerary is valid, false otherwise
     */
    @Override
    public boolean isValid() {
        return ExceptionHandlingMethods.nonExistingDepartureAirportCode(this.departureCode)
                && ExceptionHandlingMethods.nonExistingDestinationAirportCode(this.destinationCode);
    }

}
