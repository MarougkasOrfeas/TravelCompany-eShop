package main.java.gr.marou.eshop.repository;

import main.java.gr.marou.eshop.domain.Customer;

/**
 Repository interface for managing customers.
 Extends the generic Repository interface for customer-specific operations.
 */
public interface CustomerRepository extends Repository<Customer>{
    boolean updateCustomerEmail(long customerId, String newEmail);
    boolean updateCustomerName(long customerId, String newName);
    boolean updateCustomerAddress(long customerId, String newAddress);
}
