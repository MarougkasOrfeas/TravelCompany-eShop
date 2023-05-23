package main.java.gr.marou.eshop.service.impl;

import main.java.gr.marou.eshop.domain.Customer;
import main.java.gr.marou.eshop.repository.CustomerRepository;
import main.java.gr.marou.eshop.service.CustomerService;

/**
 * Implementation of the CustomerService interface.
 * Provides methods for managing customers.
 */
public class CustomerServiceImpl extends ServiceImpl<Customer> implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository = customerRepository;
    }

    /**
     * Updates the email of a customer.
     * @param customerId the ID of the customer
     * @param newEmail the new email to set
     * @return true if the email was updated successfully, false otherwise
     */
    @Override
    public boolean updateCustomerEmail(long customerId, String newEmail) {
        return customerRepository.updateCustomerEmail(customerId, newEmail);
    }

    /**
     * Updates the name of a customer.
     * @param customerId the ID of the customer
     * @param newName the new name to set
     * @return true if the name was updated successfully, false otherwise
     */
    @Override
    public boolean updateCustomerName(long customerId, String newName) {
        return customerRepository.updateCustomerName(customerId,newName);
    }

    /**
     * Updates the address of a customer.
     * @param customerId the ID of the customer
     * @param newAddress the new address to set
     * @return true if the address was updated successfully, false otherwise
     */
    @Override
    public boolean updateCustomerAddress(long customerId, String newAddress) {
        return customerRepository.updateCustomerAddress(customerId, newAddress);
    }
}
