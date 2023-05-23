package main.java.gr.marou.eshop;

import main.java.gr.marou.eshop.controller.EshopController;
import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.domain.Itinerary;
import main.java.gr.marou.eshop.domain.Order;
import main.java.gr.marou.eshop.domain.OrderedTicket;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.repository.CustomerRepository;
import main.java.gr.marou.eshop.repository.ItineraryRepository;
import main.java.gr.marou.eshop.repository.OrderRepository;
import main.java.gr.marou.eshop.repository.OrderedTicketRepository;
import main.java.gr.marou.eshop.repository.impl.CustomerRepositoryImpl;
import main.java.gr.marou.eshop.repository.impl.ItineraryRepositoryImpl;
import main.java.gr.marou.eshop.repository.impl.OrderRepositoryImpl;
import main.java.gr.marou.eshop.repository.impl.OrderedTicketRepositoryImpl;
import main.java.gr.marou.eshop.service.*;

import main.java.gr.marou.eshop.service.impl.*;
import main.java.gr.marou.eshop.utility.LoadData;

import java.util.ArrayList;
import java.util.List;

/**
 The main class for the e-shop application.
 */
public class EshopApp {

    public static void main(String[] args) {

        LoadData loadData = new LoadData();

        // Load customers, itineraries, and ordered tickets from CSV files
        List<Customer> customers = loadData.getCustomerList();
        List<Itinerary> itineraries = loadData.getItineraryList();
        List<OrderedTicket> orderedTickets = loadData.getOrderedTicketList();

        // Create an empty list to store orders
        List<Order> orders = new ArrayList<>();

        // Create repositories
        CustomerRepository customerRepository = new CustomerRepositoryImpl(customers);
        ItineraryRepository itineraryRepository = new ItineraryRepositoryImpl(itineraries);
        OrderedTicketRepository orderedTicketRepository = new OrderedTicketRepositoryImpl(orderedTickets);
        OrderRepository orderRepository = new OrderRepositoryImpl(orders);

        // Create services
        CustomerService customerService = new CustomerServiceImpl(customerRepository);
        ItineraryService itineraryService = new ItineraryServiceImpl(itineraryRepository);
        OrderedTicketService orderedTicketService = new OrderedTicketServiceImpl(orderedTicketRepository);
        OrderService orderService = new OrderServiceImpl(orderRepository);

        // Create the e-shop service
        EshopService eshopService = new EshopServiceImpl(customerService,itineraryService,orderedTicketService,orderService);

        // Create the e-shop controller
        EshopController eshopController = new EshopController(eshopService);

        // Perform operations using the controller
        eshopController.displayCustomers();
        eshopController.displayItineraries();
        eshopController.displayOrderedTickets();

        // Create an order for a customer
        long customerId = 2;
        long flightId = 3;
        int ticketQuantity = 2;
        PaymentMethods paymentMethod = PaymentMethods.CASH;
        eshopController.createOrder(customerId,flightId, ticketQuantity, paymentMethod);

        // Create an order for a second customer
        long customerId2 = 1;
        long flightId2 = 4;
        int ticketQuantity2 = 1;
        PaymentMethods paymentMethod2 = PaymentMethods.CREDIT_CARD;
        eshopController.createOrder(customerId2,flightId2, ticketQuantity2, paymentMethod2);

        // Display orders for a customer
        eshopController.displayOrders(customerId);
        eshopController.displayOrders(customerId2);
    }
}