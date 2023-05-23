package main.java.gr.marou.eshop.service.impl;

import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.domain.Itinerary;
import main.java.gr.marou.eshop.domain.Order;
import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.dto.CustomerDto;
import main.java.gr.marou.eshop.service.*;
import main.java.gr.marou.eshop.utility.PaymentCalculator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the EshopService interface.
 * Provides functionality for managing customers, itineraries, ordered tickets, and orders.
 */
public class EshopServiceImpl implements EshopService {

    private final CustomerService customerService;
    private final ItineraryService itineraryService;
    private final OrderedTicketService orderedTicketService;
    private final OrderService orderService;

    public EshopServiceImpl(CustomerService customerService, ItineraryService itineraryService, OrderedTicketService orderedTicketService, OrderService orderService){
        this.customerService = customerService;
        this.itineraryService = itineraryService;
        this.orderedTicketService = orderedTicketService;
        this.orderService = orderService;
    }

    /**
     * Displays information about all customers.
     * @return a string representation of all customers
     */
    @Override
    public String displayCustomers() {
        StringBuilder sb = new StringBuilder();
        for(Customer c : customerService.read()){
            sb.append(c).append("\n");
        }
        return sb.toString();
    }

    /**
     * Displays information about all itineraries.
     * @return a string representation of all itineraries
     */
    @Override
    public String displayItineraries() {
        StringBuilder sb = new StringBuilder();
        for(Itinerary i : itineraryService.read()){
            sb.append(i).append("\n");
        }
        return sb.toString();
    }

    /**
     * Displays information about all ordered tickets.
     * @return a string representation of all ordered tickets
     */
    @Override
    public String displayOrderedTickets() {
        StringBuilder sb = new StringBuilder();
        for(OrderedTicket o : orderedTicketService.read()){
            sb.append(o).append("\n");
        }
        return sb.toString();
    }

    /**
     * Creates a new order with the specified parameters.
     * @param customerId    the ID of the customer placing the order
     * @param flightId      the ID of the flight itinerary
     * @param ticketQuantity the quantity of tickets to order
     * @param paymentMethod the payment method for the order
     * @return the created order, or {@code null} if the customer or itinerary is not found
     */
    @Override
    public Order createOrder(long customerId, long flightId, int ticketQuantity, PaymentMethods paymentMethod) {

        Order order = new Order();
        order.setOrderTrackingNumber(generateOrderTrackingNumber());

        Customer customer = customerService.read(customerId);
        if (customer == null) return null;

        CustomerDto customerDto = convertToCustomerDto(customer);
        order.setCustomerDto(customerDto);
        order.setLocalDateTime(LocalDateTime.now());

        // Set all customer fields in the allFieldCustomer object
        Customer allFieldCustomer = convertToCustomer(customerDto);
        allFieldCustomer.setEmail(customer.getEmail());
        allFieldCustomer.setAddress(customer.getAddress());
        allFieldCustomer.setNationality(customer.getNationality());
        allFieldCustomer.setCustomerCategory(customer.getCustomerCategory());

        // Set the quantity for the order (replace 0 with the actual quantity)
        order.setQuantity(ticketQuantity);

        // Set the itinerary for the order
        Itinerary itinerary = itineraryService.read(flightId); // Replace this with the logic to choose the appropriate itinerary
        order.setItinerary(itinerary);

        order.setPaymentMethod(paymentMethod);

        // Calculate the payment amount
        BigDecimal paymentAmount = calculatePaymentAmount(order);
        order.setPrice(paymentAmount);

        // Add the order to the order service/repository
        orderService.add(order);
        return order;
    }

    /**
     * Displays the orders for a given customer.
     * @param customerId the ID of the customer
     * @return a StringBuilder containing the order information
     */
    @Override
    public StringBuilder displayOrders(long customerId) {
        StringBuilder sb= new StringBuilder();
        Customer customer = customerService.read(customerId);
        if (customer == null) {
            return sb.append("Customer not found with ID: ").append(customerId);
        }

        sb.append("Orders for Customer ").append(customer.getName()).append("\n");
        for (Order order: orderService.read()){
            if (order.getCustomerDto().getId() == customerId) {
                sb.append(order).append("\n");
            }
        }
        return sb;
    }

    /**
     * Calculates the payment amount for an order.
     * @param order the order for which to calculate the payment amount
     * @return the calculated payment amount as a BigDecimal
     */
    private BigDecimal calculatePaymentAmount(Order order) {
        int ticketQuantity = order.getQuantity();
        long flightId = order.getItinerary().getId();
        Itinerary flight = itineraryService.read(flightId);

        if (flight == null) {
            return BigDecimal.ZERO;
        }
        BigDecimal price = flight.getPrice();
        PaymentMethods paymentMethod = order.getPaymentMethod();
        CustomerCategory category = order.getCustomerDto().getCustomerCategory();

        PaymentCalculator paymentCalculator = new PaymentCalculator();
        return paymentCalculator.calculatePaymentAmount(price, category, paymentMethod, ticketQuantity);
    }

    /**
     * Converts a Customer object to a CustomerDto object.
     * @param customer the customer to convert
     * @return the converted CustomerDto object
     */
    private CustomerDto convertToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setCustomerCategory(customer.getCustomerCategory());
        // Set other fields as needed

        return customerDto;
    }

    /**
     * Converts a CustomerDto object to a Customer object.
     * @param customerDto the customer DTO to convert
     * @return the converted Customer object
     */
    private Customer convertToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setCustomerCategory(customerDto.getCustomerCategory());
        // Set other fields as needed
        return customer;
    }

    /**
     * Generates a unique order tracking number.
     * @return the generated order tracking number as a String
     */
    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }


}
