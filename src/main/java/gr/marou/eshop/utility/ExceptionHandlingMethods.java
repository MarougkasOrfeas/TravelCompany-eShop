package main.java.gr.marou.eshop.utility;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 Utility class containing exception handling methods.
 */
public class ExceptionHandlingMethods {

    /**
     Checks if an email is valid.
     @param email the email to be validated
     @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email){
        String regexExpression = "^(.+)@travelcompany.com$";
        Pattern pattern = Pattern.compile(regexExpression);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     Checks if an itinerary or customer with the specified IDs exist.
     @param itineraryId the ID of the itinerary
     @param customerId the ID of the customer
     @return true if the itinerary or customer does not exist, false otherwise
     */
    public static boolean nonExistingItineraryOrCustomer(long itineraryId, long customerId){
        List<String> itineraries = new LoadData().getItineraries();
        List<String> customers = new LoadData().getCustomers();

        for(String i : itineraries){
            String[] itineraryParts = i.split(",");
            long id = Long.parseLong(itineraryParts[0]);
            if(id == itineraryId){
                return false;
            }
        }

        for(String c : customers){
            String[] customerParts = c.split(",");
            long id = Long.parseLong(customerParts[0]);
            if(id == customerId){
                return false;
            }
        }

        return true;
    }

    /**
     Checks if a departure airport code exists.
     @param departureAirportCode the departure airport code to be checked
     @return true if the departure airport code does not exist, false otherwise
     */
    public static boolean  nonExistingDepartureAirportCode(String departureAirportCode){
        final String VALID_AIRPORT_CODE = "ATH";
        return !departureAirportCode.equals(VALID_AIRPORT_CODE);
    }

    /**
     Checks if a destination airport code exists.
     @param destinationAirportCode the destination airport code to be checked
     @return true if the destination airport code does not exist, false otherwise
     */
    public static boolean  nonExistingDestinationAirportCode(String destinationAirportCode){
        List<String> availableDestinations = Arrays.asList("PAR", "LON", "AMS", "PAR", "DUB", "FRA", "MEX", "DUB");
        return !availableDestinations.contains(destinationAirportCode);
    }
}
