package br.com.codenation.paymentmethods;

public class Transfer implements PriceStrategy{

  private final double TRANSFER_DISCOUNT=  0.92;

  @Override
  public Double calculate(Double price) {
    return price * TRANSFER_DISCOUNT;
  }
}
