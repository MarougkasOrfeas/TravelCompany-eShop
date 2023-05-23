package main.java.gr.marou.eshop.utility;

import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import java.math.BigDecimal;

/**
 Utility class for calculating payment amounts based on customer category and payment method.
 */
public class PaymentCalculator {

    private BigDecimal discountCategoryPrice = BigDecimal.ZERO;
    private BigDecimal discountCreditCardPrice = BigDecimal.ZERO;

/**
 Calculates the payment amount based on the base price, customer category, payment method, and ticket quantity.
 @param basePrice The base price of the tickets.
 @param category The customer category.
 @param paymentMethods The payment method.
 @param ticketQuantity The quantity of tickets.
 @return The calculated payment amount.
 */
 public  BigDecimal calculatePaymentAmount(BigDecimal basePrice, CustomerCategory category, PaymentMethods paymentMethods, int ticketQuantity){
        if (category.equals(CustomerCategory.BUSINESS)) {
            discountCategoryPrice = basePrice.multiply(new BigDecimal("0.1"));
        } else if (category.equals(CustomerCategory.INDIVIDUAL)) {
            discountCategoryPrice = basePrice.multiply(new BigDecimal("0.2"));
        }
        if (paymentMethods.equals(PaymentMethods.CREDIT_CARD)) {
            discountCreditCardPrice = basePrice.multiply(new BigDecimal("0.1"));
        }

        BigDecimal totalDiscount = discountCategoryPrice.add(discountCreditCardPrice);
        BigDecimal totalPrice = basePrice.subtract(totalDiscount);
        return totalPrice.multiply(BigDecimal.valueOf(ticketQuantity));
    }
}
