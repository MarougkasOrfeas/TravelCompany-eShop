package main.java.gr.marou.eshop.domain;

import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import main.java.gr.marou.eshop.utility.ExceptionHandlingMethods;
import lombok.*;

/**
 * Represents a customer entity in the e-shop system.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer implements Entity{

    private long id;
    private String name;
    private String email;
    private String address;
    private String nationality;
    private CustomerCategory customerCategory;

    /**
     * Retrieves the ID of the customer.
     * @return the ID of the customer
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * Checks if the customer is valid.
     * @return true if the customer is valid, false otherwise
     */
    @Override
    public boolean isValid() {
        return ExceptionHandlingMethods.isValidEmail(this.email);
    }
}
