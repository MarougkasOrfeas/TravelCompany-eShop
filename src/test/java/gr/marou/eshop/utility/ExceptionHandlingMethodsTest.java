package test.java.gr.marou.eshop.utility;

import main.java.gr.marou.eshop.utility.ExceptionHandlingMethods;
import org.junit.jupiter.api.*;

/**
 * Unit tests for the ExceptionHandlingMethods class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ExceptionHandlingMethodsTest {

    @Test
    @DisplayName("Test Valid Email")
    @Order(0)
    public void testIsValidEmail_ValidEmail() {
        // Arrange
        String email = "john@travelcompany.com";
        // Act
        boolean isValid = ExceptionHandlingMethods.isValidEmail(email);
        // Assert
        Assertions.assertTrue(isValid, "Email should be valid");
    }

    @Test
    @DisplayName("Test Invalid Email")
    @Order(1)
    public void testIsValidEmail_InvalidEmail() {
        // Arrange
        String email = "john@example.com";
        // Act
        boolean isValid = ExceptionHandlingMethods.isValidEmail(email);
        // Assert
        Assertions.assertFalse(isValid, "Email should be invalid");
    }

    @Test
    @DisplayName("Test Non-Existing Itinerary or Customer")
    @Order(2)
    public void testNonExistingItineraryOrCustomer() {
        // Arrange
        String itineraryInput = "109,ATH,PAR,2022-02-22 13:35:00,Skylines,300";
        String[] itineraryParts = itineraryInput.split(",");
        long itineraryId = Long.parseLong(itineraryParts[0].trim());

        String customerInput = "109,Maria Iordanou,miordanou@mail.com,Athens,Greek,INDIVIDUAL";
        String[] customerParts = customerInput.split(",");
        long customerId = Long.parseLong(customerParts[0].trim());
        // Act
        boolean exists = ExceptionHandlingMethods.nonExistingItineraryOrCustomer(itineraryId, customerId);
        // Assert
        Assertions.assertTrue(exists, "Itinerary or Customer should not exist");
    }

    @Test
    @DisplayName("Test Existing Itinerary")
    @Order(3)
    public void testExistingItineraryOrCustomer() {
        // Arrange
        String itineraryInput = "1,ATH,PAR,2022-02-22 13:35:00,Skylines,300";
        String[] itineraryParts = itineraryInput.split(",");
        long itineraryId = Long.parseLong(itineraryParts[0].trim());

        String customerInput = "1,Maria Iordanou,miordanou@mail.com,Athens,Greek,INDIVIDUAL";
        String[] customerParts = customerInput.split(",");
        long customerId =Long.parseLong(customerParts[0].trim());

        // Act
        boolean exists = ExceptionHandlingMethods.nonExistingItineraryOrCustomer(itineraryId, customerId);
        // Assert
        Assertions.assertFalse(exists, "Itinerary or Customer should exist");
    }

    @Test
    @DisplayName("Test Non-Existing Departure Airport Code")
    @Order(4)
    public void testNonExistingDepartureAirportCode() {
        // Arrange
        String departureAirportCode = "JFK";
        // Act
        boolean exists = ExceptionHandlingMethods.nonExistingDepartureAirportCode(departureAirportCode);
        // Assert
        Assertions.assertTrue(exists, "Departure airport code should not exist");
    }

    @Test
    @DisplayName("Test Existing Departure Airport Code")
    @Order(5)
    public void testExistingDepartureAirportCode() {
        // Arrange
        String departureAirportCode = "ATH";
        // Act
        boolean exists = ExceptionHandlingMethods.nonExistingDepartureAirportCode(departureAirportCode);
        // Assert
        Assertions.assertFalse(exists, "Departure airport code should exist");
    }

    @Test
    @DisplayName("Test Non-Existing Destination Airport Code")
    @Order(6)
    public void testNonExistingDestinationAirportCode() {
        // Arrange
        String destinationAirportCode = "JFK";
        // Act
        boolean exists = ExceptionHandlingMethods.nonExistingDestinationAirportCode(destinationAirportCode);
        // Assert
        Assertions.assertTrue(exists, "Destination airport code should not exist");
    }

    @Test
    @DisplayName("Test Existing Destination Airport Code")
    @Order(7)
    public void testNonExistingDestinationAirportCode_ExistingCode() {
        // Arrange
        String destinationAirportCode = "LON";
        // Act
        boolean exists = ExceptionHandlingMethods.nonExistingDestinationAirportCode(destinationAirportCode);
        // Assert
        Assertions.assertFalse(exists, "Destination airport code should exist");
    }
}
