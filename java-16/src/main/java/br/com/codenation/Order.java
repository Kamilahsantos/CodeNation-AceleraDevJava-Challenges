package br.com.codenation;

import br.com.codenation.paymentmethods.PaymentMethod;
import br.com.codenation.paymentmethods.PriceStrategy;

public class Order {

  private Double price;
  private PaymentMethod paymentMethod;


  public Order(Double price, PaymentMethod paymentMethod) {
    this.price = price;
    this.paymentMethod = paymentMethod;
  }

  public Double getPrice() {
    return price;
  }

  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public Double getPriceStrategy() {
    return getPaymentMethod().getPaymentStrategy().calculate(price);

  }
}
