package main.java.gr.marou.eshop.service;

import main.java.gr.marou.eshop.domain.Customer;


/**
 Service interface for managing Customer entities.
 Extends the Service interface.
 */
public interface CustomerService extends Service<Customer>{

    boolean updateCustomerEmail(long customerId, String newEmail);
    boolean updateCustomerName(long customerId, String newName);
    boolean updateCustomerAddress(long customerId, String newAddress);
}
