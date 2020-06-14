package br.com.codenation;

import br.com.codenation.BillingProcessor;
import br.com.codenation.Order;
import br.com.codenation.paymentmethods.PaymentMethod;
import org.junit.Assert;
import org.junit.Test;

public class BillingProcessorTest {

    private BillingProcessor billingProcessor = new BillingProcessor();

    @Test
    public void testCashPayment(){
        Assert.assertNotNull(PaymentMethod.CASH.getPaymentStrategy());
        Assert.assertEquals(Double.valueOf(90.0), this.billingProcessor.calculate(new Order(100.0, PaymentMethod.CASH)));
    }

    @Test
    public void testCreditCardPayment(){
        Assert.assertNotNull(PaymentMethod.CREDIT_CARD.getPaymentStrategy());
        Assert.assertEquals(Double.valueOf(98.0), this.billingProcessor.calculate(new Order(100.0, PaymentMethod.CREDIT_CARD)));
    }

    @Test
    public void testDebitCardPayment(){
        Assert.assertNotNull(PaymentMethod.DEBIT_CARD.getPaymentStrategy());
        Assert.assertEquals(Double.valueOf(95.0), this.billingProcessor.calculate(new Order(100.0, PaymentMethod.DEBIT_CARD)));
    }

    @Test
    public void testTransferPayment(){
        Assert.assertNotNull(PaymentMethod.TRANSFER.getPaymentStrategy());
        Assert.assertEquals(Double.valueOf(92.0), this.billingProcessor.calculate(new Order(100.0, PaymentMethod.TRANSFER)));
    }
}
