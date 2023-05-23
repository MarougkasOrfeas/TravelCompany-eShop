package test.java.gr.marou.eshop.utility;


import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.domain.Itinerary;
import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.utility.LoadData;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Unit tests for the LoadData class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoadDataTest {

    private LoadData loadData;
    private List<Customer> customers;
    private List<Itinerary> itineraries;
    private List<OrderedTicket> orderedTickets;

    @BeforeEach
    public void setUp() {
        loadData = new LoadData();
        customers = loadData.getCustomerList();
        itineraries = loadData.getItineraryList();
        orderedTickets = loadData.getOrderedTicketList();
    }

    @Test
    @DisplayName("Test Loading Customers")
    @Order(0)
    public void testLoadCustomers() {
        // Ensure that itinerary list is not empty
        Assertions.assertNotNull(customers);
        Assertions.assertEquals(9, customers.size());
        //verify customers
        assertCustomer(customers.get(0), 1, "Maria Iordanou", "miordanou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL);
        assertCustomer(customers.get(1), 2, "Dimitriou Dimitrios", "ddimitriou@mail.com", "Athens", "Greek", CustomerCategory.INDIVIDUAL);
        assertCustomer(customers.get(2), 3, "Ioannis Ioannou", "iioannou@mail.com", "Athens", "Greek", CustomerCategory.BUSINESS);
        assertCustomer(customers.get(3),4,"Antonio Molinari","amolinari@mail.com","Milan","Italian", CustomerCategory.INDIVIDUAL);
        assertCustomer(customers.get(4),5,"Frederico Rossi","frossi@mail.com","Milan","Italian", CustomerCategory.INDIVIDUAL);
        assertCustomer(customers.get(5),6,"Mario Conti","mconti@mail.com","Rome","Italian", CustomerCategory.BUSINESS);
        assertCustomer(customers.get(6),7,"Nathan Martin","nmartin@mail.com","Lyon","French", CustomerCategory.BUSINESS);
        assertCustomer(customers.get(7),8,"Enzo Collin","ecollin@mail.com","Lyon","French", CustomerCategory.INDIVIDUAL);
        assertCustomer(customers.get(8),9,"Frederic Michel","fmichel@mail.com","Athens","French", CustomerCategory.INDIVIDUAL);
    }

    @Test
    @DisplayName("Test Loading Itineraries")
    @Order(1)
    public void testLoadItineraries() {
        // Ensure that itinerary list is not empty
        Assertions.assertNotNull(itineraries);
        Assertions.assertEquals(9, itineraries.size());
        // Verify itineraries
        assertItinerary(itineraries.get(0), 1, "ATH", "PAR", LocalDateTime.of(2022, 2, 22, 13, 35), "Skylines", new BigDecimal("300"));
        assertItinerary(itineraries.get(1), 2, "ATH", "LON", LocalDateTime.of(2022, 2, 22, 13, 40), "SkyLines", new BigDecimal("420"));
        assertItinerary(itineraries.get(2), 3, "ATH", "AMS", LocalDateTime.of(2022, 2, 22, 13, 45), "SkyLines", new BigDecimal("280"));
        assertItinerary(itineraries.get(3), 4, "ATH", "PAR", LocalDateTime.of(2022, 2, 22, 14, 20), "SkyLines", new BigDecimal("310"));
        assertItinerary(itineraries.get(4), 5, "ATH", "DUB", LocalDateTime.of(2022, 2, 22, 14, 35), "SkyLines", new BigDecimal("880"));
        assertItinerary(itineraries.get(5), 6, "ATH", "FRA", LocalDateTime.of(2022, 2, 22, 14, 55), "SkyLines", new BigDecimal("380"));
        assertItinerary(itineraries.get(6), 7, "ATH", "FRA", LocalDateTime.of(2022, 2, 22, 15, 35), "SkyLines", new BigDecimal("350"));
        assertItinerary(itineraries.get(7), 8, "ATH", "MEX", LocalDateTime.of(2022, 2, 22, 16, 0), "SkyLines", new BigDecimal("1020"));
        assertItinerary(itineraries.get(8), 9, "ATH", "DUB", LocalDateTime.of(2022, 2, 22, 16, 35), "SkyLines", new BigDecimal("770"));
    }

    @Test
    @DisplayName("Test Loading Ordered Tickets")
    @Order(2)
    public void testLoadOrderedTickets() {
        // Ensure that ordered ticket list is not empty
        Assertions.assertNotNull(orderedTickets);
        Assertions.assertEquals(9, orderedTickets.size());

        // Verify the ordered tickets
        // Verify ordered tickets
        assertOrderedTicket(orderedTickets.get(0), 1, PaymentMethods.CASH, new BigDecimal("462"));
        assertOrderedTicket(orderedTickets.get(1), 2, PaymentMethods.CASH, new BigDecimal("308"));
        assertOrderedTicket(orderedTickets.get(2), 3, PaymentMethods.CREDIT_CARD, new BigDecimal("224"));
        assertOrderedTicket(orderedTickets.get(3), 4, PaymentMethods.CREDIT_CARD, new BigDecimal("341"));
        assertOrderedTicket(orderedTickets.get(4), 5, PaymentMethods.CASH, new BigDecimal("248"));
        assertOrderedTicket(orderedTickets.get(5), 76, PaymentMethods.CREDIT_CARD, new BigDecimal("968"));
        assertOrderedTicket(orderedTickets.get(6), 7, PaymentMethods.CREDIT_CARD, new BigDecimal("968"));
        assertOrderedTicket(orderedTickets.get(7), 8, PaymentMethods.CASH, new BigDecimal("1122"));
        assertOrderedTicket(orderedTickets.get(8), 9, PaymentMethods.CASH, new BigDecimal("308"));
    }

    private void assertCustomer(Customer customer, int expectedId, String expectedName, String expectedEmail,
                                String expectedAddress, String expectedNationality, CustomerCategory expectedCategory) {
        Assertions.assertEquals(expectedId, customer.getId());
        Assertions.assertEquals(expectedName, customer.getName());
        Assertions.assertEquals(expectedEmail, customer.getEmail());
        Assertions.assertEquals(expectedAddress, customer.getAddress());
        Assertions.assertEquals(expectedNationality, customer.getNationality());
        Assertions.assertEquals(expectedCategory, customer.getCustomerCategory());
    }

    private void assertItinerary(Itinerary itinerary, int expectedId, String expectedDepartureCode,
                                 String expectedDestinationCode, LocalDateTime expectedDepartureDate,
                                 String expectedAirline, BigDecimal expectedPrice) {
        Assertions.assertEquals(expectedId, itinerary.getId());
        Assertions.assertEquals(expectedDepartureCode, itinerary.getDepartureCode());
        Assertions.assertEquals(expectedDestinationCode, itinerary.getDestinationCode());
        Assertions.assertEquals(expectedDepartureDate, itinerary.getDepartureDate());
        Assertions.assertEquals(expectedAirline, itinerary.getAirline());
        Assertions.assertEquals(expectedPrice, itinerary.getPrice());
    }

    private void assertOrderedTicket(OrderedTicket orderedTicket, int expectedId, PaymentMethods expectedPaymentMethod, BigDecimal expectedPaymentAmount) {
        Assertions.assertNotNull(orderedTicket);
        Assertions.assertEquals(expectedId, orderedTicket.getId());
        Assertions.assertNotNull(orderedTicket.getCustomer());
        Assertions.assertNotNull(orderedTicket.getItinerary());
        Assertions.assertEquals(expectedPaymentMethod, orderedTicket.getPaymentMethod());
        Assertions.assertEquals(expectedPaymentAmount, orderedTicket.getPaymentAmount());
    }

}
