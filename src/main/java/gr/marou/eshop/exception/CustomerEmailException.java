package main.java.gr.marou.eshop.exception;

import java.io.Serial;

/**
 Exception thrown when there is an issue with the customer email.
 */
public class CustomerEmailException extends Exception{
    @Serial
    private static final long serialVersionUID = 1L;

    public CustomerEmailException(String message){
        super(message);
    }
}
