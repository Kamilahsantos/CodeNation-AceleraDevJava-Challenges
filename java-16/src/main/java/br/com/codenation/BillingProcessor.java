package br.com.codenation;

public class BillingProcessor {


  public Double calculate(Order order) {

    return order.getPriceStrategy();
  }
}
