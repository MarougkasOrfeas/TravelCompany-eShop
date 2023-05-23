package main.java.gr.marou.eshop.controller;

import main.java.gr.marou.eshop.domain.Order;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.service.EshopService;

/**
 * Controller class for the e-shop functionality.
 */
public class EshopController {
    private final EshopService eshopService;

    public EshopController(EshopService eshopService) {
        this.eshopService = eshopService;
    }

    /**
     * Displays the list of customers.
     */
    public void displayCustomers() {
        String customers = eshopService.displayCustomers();
        System.out.println("\n" + customers);
    }

    /**
     * Displays the list of itineraries.
     */
    public void displayItineraries() {
        String itineraries = eshopService.displayItineraries();
        System.out.println(itineraries);
    }

    /**
     * Displays the list of ordered tickets.
     */
    public void displayOrderedTickets() {
        String orderedTickets = eshopService.displayOrderedTickets();
        System.out.println(orderedTickets);
    }

    /**
     * Creates an order for a customer with the specified details.
     * @param customerId    the ID of the customer placing the order.
     * @param flightId      the ID of the selected flight for the order.
     * @param ticketQuantity the quantity of tickets to be ordered.
     * @param paymentMethod the payment method for the order.
     */
    public void createOrder(long customerId,long flightId, int ticketQuantity, PaymentMethods paymentMethod) {
        Order order = eshopService.createOrder(customerId,flightId, ticketQuantity, paymentMethod);
        if (order == null) {
            System.out.println("Customer not found.");
        } else {
            System.out.println("Order created successfully.");
            System.out.println("==========================================");
            showOrder(order);
        }
    }

    /**
     * Displays the details of an order.
     * @param order the order to be displayed.
     */
    private void showOrder(Order order){
        System.out.println("Order Tracking Number: " + order.getOrderTrackingNumber());
        System.out.println("Customer: " + order.getCustomerDto().getName());
        System.out.println("Flight: " + order.getItinerary().getAirline());
        System.out.println("Date Ordered: " + order.getLocalDateTime());
        System.out.println("Departure: " + order.getItinerary().getDepartureCode());
        System.out.println("Destination: " + order.getItinerary().getDestinationCode());
        System.out.println("Quantity: " + order.getQuantity());
        System.out.println("Price: " + order.getPrice());
        System.out.println("Payment Method: " + order.getPaymentMethod() + "\n\n");
    }

    /**
     * Displays the orders for a specific customer.
     * @param customerId the ID of the customer.
     */
    public void displayOrders(long customerId) {
        StringBuilder orders = eshopService.displayOrders(customerId);
        if (orders.isEmpty()) {
            System.out.println("Customer not found or has no orders.");
        } else {
            System.out.println(orders);
        }
    }
}
