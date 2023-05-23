package main.java.gr.marou.eshop.utility;

import lombok.Getter;
import lombok.Setter;
import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.domain.Itinerary;
import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Utility class for loading data from CSV files and mapping them to domain objects.
 */
@Getter
@Setter
public class LoadData {

    // File paths for CSV files
    private final String CUSTOMERS_PATH = "csv/customers.csv";
    private final String ITINERARIES_PATH = "csv/itineraries.csv";
    private final String ORDERED_TICKETS_PATH = "csv/orderedTickets.csv";

    // Lists to store the data from CSV files
    private final List<String> customers ;
    private final List<String> itineraries ;
    private final List<String> orderedTickets ;

    // Lists to store the mapped domain objects
    private List<Customer> customerList;
    private List<Itinerary> itineraryList;
    private List<OrderedTicket> orderedTicketList;

    public LoadData(){
        customers = new ArrayList<>();
        itineraries = new ArrayList<>();
        orderedTickets = new ArrayList<>();

        customerList = new ArrayList<>();
        itineraryList = new ArrayList<>();
        orderedTicketList = new ArrayList<>();

        // Load data from CSV files
        loadDataFromCSV(customers, CUSTOMERS_PATH);
        loadDataFromCSV(itineraries, ITINERARIES_PATH);
        loadDataFromCSV(orderedTickets, ORDERED_TICKETS_PATH);

        // Map the data to domain objects
        loadCustomers();
        loadItineraries();
        loadOrderedTickets();
    }

    /**
     * Loads data from a CSV file into a list.
     * @param dataList The list to populate with the data from the CSV file.
     * @param filename The filename of the CSV file.
     */
    public void loadDataFromCSV(List<String> dataList,String filename) {
        try  (InputStream inputStream = LoadData.class.getResourceAsStream(filename);
              Scanner scanner =  new Scanner(Objects.requireNonNull(inputStream))){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                dataList.add(line);
            }
            if (!dataList.isEmpty()) {
                System.out.println("Data loaded successfully from the CSV file: " + filename);
            } else {
                System.out.println("No data found in the CSV file: " + filename);
            }
        } catch (Exception e) {
            System.out.println("Failed to read login customers from the CSV file" + e.getMessage());
        }
        
    }

    /**
     * Maps the data in the customers list to a list of Customer objects.
     */
    private void loadCustomers() {
        for (String line : customers) {
            String[] fields = line.split(",");
            Customer customer = mapToCustomer(fields);
            customerList.add(customer);
        }
    }

    /**
     * Maps the data in the itineraries list to a list of Itinerary objects.
     */
    private void loadItineraries() {
        for (String line : itineraries) {
            String[] fields = line.split(",");
            Itinerary itinerary = mapToItinerary(fields);
            itineraryList.add(itinerary);
        }
    }

    /**
     * Maps the data in the orderedTickets list to a list of OrderedTicket objects.
     */
    private void loadOrderedTickets() {
        for (String line : orderedTickets) {
            String[] fields = line.split(",");
            OrderedTicket orderedTicket = mapToOrderedTicket(fields);
            orderedTicketList.add(orderedTicket);
        }
    }

    /**
     * Maps an array of fields to a Customer object.
     * @param fields The array of fields representing a Customer.
     * @return The Customer object.
     */
    private Customer mapToCustomer(String[] fields) {
        return Customer.builder()
                .id(Long.parseLong(fields[0]))
                .name(fields[1])
                .email(fields[2])
                .address(fields[3])
                .nationality(fields[4])
                .customerCategory(CustomerCategory.valueOf(fields[5]))
                .build();
    }

    /**
     * Maps an array of fields to an Itinerary object.
     * @param fields The array of fields representing an Itinerary.
     * @return The Itinerary object.
     */
    private Itinerary mapToItinerary(String[] fields) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Itinerary.builder()
                .id(Long.parseLong(fields[0]))
                .departureCode(fields[1])
                .destinationCode(fields[2])
                .departureDate(LocalDateTime.parse(fields[3],formatter))
                .airline(fields[4])
                .price(new BigDecimal(fields[5]))
                .build();
    }

    /**
     * Maps an array of fields to an OrderedTicket object.
     * @param fields The array of fields representing an OrderedTicket.
     * @return The OrderedTicket object.
     */
    private OrderedTicket mapToOrderedTicket(String[] fields) {
        long customerId = Long.parseLong(fields[1]);
        long itineraryId = Long.parseLong(fields[2]);

        // Find the corresponding Customer object from the customerList
        Customer customer = customerList.stream()
                .filter(c -> c.getId() == customerId)
                .findFirst()
                .orElse(null);

        // Find the corresponding Itinerary object from the itineraryList
        Itinerary itinerary = itineraryList.stream()
                .filter(i -> i.getId() == itineraryId)
                .findFirst()
                .orElse(null);

        if (customer != null && itinerary != null) {
            return OrderedTicket.builder()
                    .id(Long.parseLong(fields[0]))
                    .customer(customer)
                    .itinerary(itinerary)
                    .paymentMethod(PaymentMethods.valueOf(fields[3]))
                    .paymentAmount(new BigDecimal(fields[4]))
                    .build();
        }
        return null;
    }
}
