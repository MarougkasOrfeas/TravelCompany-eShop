package test.java.gr.marou.eshop.utility;

import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import main.java.gr.marou.eshop.domain.enums.PaymentMethods;
import main.java.gr.marou.eshop.utility.PaymentCalculator;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

/**
 * Unit tests for the PaymentCalculator class.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaymentCalculatorTest {

    private PaymentCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new PaymentCalculator();
    }

    @Test
    @DisplayName("Calculation For Business Category Customer - Credit Card Payment")
    @Order(0)
    public void testCalculatePaymentAmountBusinessCategory() {
        // Arrange
        BigDecimal basePrice = new BigDecimal("100.00");
        CustomerCategory category = CustomerCategory.BUSINESS;
        PaymentMethods paymentMethods1 = PaymentMethods.CREDIT_CARD;
        int ticketQuantity = 5;
        BigDecimal expectedPaymentAmount = new BigDecimal("400.00");
        // Act
        BigDecimal actualPaymentAmount = calculator.calculatePaymentAmount(basePrice, category, paymentMethods1, ticketQuantity);
        // Assert
        String assertionMessage = String.format("Expected payment amount: %s, Actual payment amount: %s", expectedPaymentAmount, actualPaymentAmount);
        Assertions.assertEquals(0,expectedPaymentAmount.compareTo(actualPaymentAmount), assertionMessage);
    }

    @Test
    @DisplayName("Calculation For Business Category Customer - Cash Payment")
    @Order(1)
    public void testCalculatePaymentAmountBusinessCategoryWithCash() {
        // Arrange
        BigDecimal basePrice = new BigDecimal("100.00");
        CustomerCategory category = CustomerCategory.BUSINESS;
        PaymentMethods paymentMethods = PaymentMethods.CASH;
        int ticketQuantity = 5;
        BigDecimal expectedPaymentAmount = new BigDecimal("450.00");

        // Act
        BigDecimal actualPaymentAmount = calculator.calculatePaymentAmount(basePrice, category, paymentMethods, ticketQuantity);

        // Assert
        String assertionMessage = String.format("Expected payment amount: %s, Actual payment amount: %s", expectedPaymentAmount, actualPaymentAmount);
        Assertions.assertEquals(0, expectedPaymentAmount.compareTo(actualPaymentAmount), assertionMessage);
    }

    @Test
    @DisplayName("Calculation For Individual Category Customer - Cash Payment")
    @Order(2)
    public void testCalculatePaymentAmountIndividualCategory() {
        // Arrange
        BigDecimal basePrice = new BigDecimal("50.00");
        CustomerCategory category = CustomerCategory.INDIVIDUAL;
        PaymentMethods paymentMethods = PaymentMethods.CASH;
        int ticketQuantity = 3;
        BigDecimal expectedPaymentAmount = new BigDecimal("120.00");
        // Act
        BigDecimal actualPaymentAmount = calculator.calculatePaymentAmount(basePrice, category, paymentMethods, ticketQuantity);
        // Assert
        String assertionMessage = String.format("Expected payment amount: %s, Actual payment amount: %s", expectedPaymentAmount, actualPaymentAmount);
        Assertions.assertEquals(0,expectedPaymentAmount.compareTo(actualPaymentAmount), assertionMessage);

    }

    @Test
    @DisplayName("Calculation For Individual Category Customer - Credit Card Payment")
    @Order(3)
    public void testCalculatePaymentAmountIndividualCategoryWithCreditCard() {
        // Arrange
        BigDecimal basePrice = new BigDecimal("50.00");
        CustomerCategory category = CustomerCategory.INDIVIDUAL;
        PaymentMethods paymentMethods = PaymentMethods.CREDIT_CARD;
        int ticketQuantity = 4;
        BigDecimal expectedPaymentAmount = new BigDecimal("140.00");

        // Act
        BigDecimal actualPaymentAmount = calculator.calculatePaymentAmount(basePrice, category, paymentMethods, ticketQuantity);

        // Assert
        String assertionMessage = String.format("Expected payment amount: %s, Actual payment amount: %s", expectedPaymentAmount, actualPaymentAmount);
        Assertions.assertEquals(0, expectedPaymentAmount.compareTo(actualPaymentAmount), assertionMessage);
    }

}
