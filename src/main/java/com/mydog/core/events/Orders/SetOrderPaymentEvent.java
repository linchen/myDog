package com.mydog.core.events.Orders;

import com.mydog.core.events.UpdateEvent;

import java.util.UUID;

public class SetOrderPaymentEvent extends UpdateEvent {

  private UUID key;
  private PaymentDetails paymentDetails;

  public SetOrderPaymentEvent(UUID key, PaymentDetails paymentDetails) {
    this.key = key;
    this.paymentDetails = paymentDetails;
  }

  public UUID getKey() {
    return key;
  }

  public PaymentDetails getPaymentDetails() {
    return paymentDetails;
  }
}
