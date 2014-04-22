package com.mydog.core.domain;

import com.mydog.core.events.orders.OrderDetails;
import org.springframework.beans.BeanUtils;

import java.util.*;

public class Order {

  private final Date dateTimeOfSubmission;
  private Map<String, Integer> orderItems;
  private final UUID key;
  private Customer customer;

  private OrderStatus status;
  private List<OrderStatus> statusHistory;


    @Override
    public String toString() {
        return "Order: " + "[id="+ key + ", Date=" + dateTimeOfSubmission.toString() + "]";
    }

    public Order(final Date dateTimeOfSubmission) {
    this.key = UUID.randomUUID();
    this.dateTimeOfSubmission = dateTimeOfSubmission;
    statusHistory = new ArrayList<OrderStatus>();
  }

  public void addStatus(OrderStatus newStatus) {
    statusHistory.add(newStatus);
    status = newStatus;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public Date getDateTimeOfSubmission() {
    return dateTimeOfSubmission;
  }

  public UUID getKey() {
    return key;
  }

  public void setOrderItems(Map<String, Integer> orderItems) {
    if (orderItems == null) {
      this.orderItems = Collections.emptyMap();
    } else {
      this.orderItems = Collections.unmodifiableMap(orderItems);
    }
  }

  public Map<String, Integer> getOrderItems() {
    return orderItems;
  }

  public boolean canBeDeleted() {
    return true;
  }

  public OrderDetails toOrderDetails() {
    OrderDetails details = new OrderDetails();

    BeanUtils.copyProperties(this, details);

    return details;
  }

  public static Order fromOrderDetails(OrderDetails orderDetails) {
    Order order = new Order(orderDetails.getDateTimeOfSubmission());

    BeanUtils.copyProperties(orderDetails, order);

    return order;
  }
}
