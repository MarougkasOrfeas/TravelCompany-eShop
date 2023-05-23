package main.java.gr.marou.eshop.repository.impl;

import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.repository.CustomerRepository;

import java.util.List;


/**
 Implementation of the CustomerRepository interface.
 Provides operations to manage Customer entities.
 */
public class CustomerRepositoryImpl extends RepositoryImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(List<Customer> list) {
        super(list);
    }

    /**
     Updates the email of a customer with the specified ID.
     @param customerId the ID of the customer
     @param newEmail the new email address
     @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateCustomerEmail(long customerId, String newEmail) {
        Customer customer = read(customerId);
        if (customer == null) return false;

        for (Customer curCustomer : read()) {
            if (curCustomer.getEmail() != null && curCustomer.getEmail().equals(newEmail)) {
                return false;
            }
        }
        customer.setEmail(newEmail);
        return true;
    }

    /**
     Updates the name of a customer with the specified ID.
     @param customerId the ID of the customer
     @param newName the new name
     @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateCustomerName(long customerId, String newName) {
        Customer customer = read(customerId);
        if (customer == null) return false;

        for (Customer curCustomer : read()) {
            if (curCustomer.getName() != null && curCustomer.getEmail().equals(newName)) {
                return false;
            }
        }
        customer.setEmail(newName);
        return true;
    }

    /**
     Updates the address of a customer with the specified ID.
     @param customerId the ID of the customer
     @param newAddress the new address
     @return true if the update was successful, false otherwise
     */
    @Override
    public boolean updateCustomerAddress(long customerId, String newAddress) {
        Customer customer = read(customerId);
        if (customer == null) return false;

        for (Customer curCustomer : read()) {
            if (curCustomer.getAddress() != null && curCustomer.getEmail().equals(newAddress)) {
                return false;
            }
        }

        customer.setEmail(newAddress);
        return true;
    }
}
