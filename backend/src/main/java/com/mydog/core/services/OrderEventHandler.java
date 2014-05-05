package com.mydog.core.services;

import com.mydog.core.domain.Order;
import com.mydog.core.domain.OrderStatus;
import com.mydog.core.events.Orders.AllOrdersEvent;
import com.mydog.core.events.Orders.CreateOrderEvent;
import com.mydog.core.events.Orders.DeleteOrderEvent;
import com.mydog.core.events.Orders.OrderCreatedEvent;
import com.mydog.core.events.Orders.OrderDeletedEvent;
import com.mydog.core.events.Orders.OrderDetails;
import com.mydog.core.events.Orders.OrderDetailsEvent;
import com.mydog.core.events.Orders.OrderStatusEvent;
import com.mydog.core.events.Orders.OrderUpdatedEvent;
import com.mydog.core.events.Orders.RequestAllOrdersEvent;
import com.mydog.core.events.Orders.RequestOrderDetailsEvent;
import com.mydog.core.events.Orders.RequestOrderStatusEvent;
import com.mydog.core.events.Orders.SetOrderPaymentEvent;
import com.mydog.core.repository.OrdersRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderEventHandler implements OrderService {

  private final OrdersRepository ordersRepository;

  public OrderEventHandler(final OrdersRepository ordersRepository) {
    this.ordersRepository = ordersRepository;
  }

  @Override
  public OrderCreatedEvent createOrder(CreateOrderEvent createOrderEvent) {
      OrderDetails details = createOrderEvent.getDetails();
      details.setDateTimeOfSubmission(new Date());
      Order order = Order.fromOrderDetails(details);

    order.addStatus(new OrderStatus(new Date(), "Order Created"));

    order = ordersRepository.save(order);

    return new OrderCreatedEvent(order.getKey(), order.toOrderDetails());
  }

  @Override
  public AllOrdersEvent requestAllOrders(RequestAllOrdersEvent requestAllCurrentOrdersEvent) {
    List<OrderDetails> generatedDetails = new ArrayList<>();
    for (Order order : ordersRepository.findAll()) {
      generatedDetails.add(order.toOrderDetails());
    }
    return new AllOrdersEvent(generatedDetails);
  }

  @Override
  public OrderDetailsEvent requestOrderDetails(RequestOrderDetailsEvent requestOrderDetailsEvent) {

    Order order = ordersRepository.findById(requestOrderDetailsEvent.getKey());

    if (order == null) {
      return OrderDetailsEvent.notFound(requestOrderDetailsEvent.getKey());
    }

    return new OrderDetailsEvent(
            requestOrderDetailsEvent.getKey(),
            order.toOrderDetails());
  }

  @Override
  public OrderUpdatedEvent setOrderPayment(SetOrderPaymentEvent setOrderPaymentEvent) {
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public OrderDeletedEvent deleteOrder(DeleteOrderEvent deleteOrderEvent) {

    Order order = ordersRepository.findById(deleteOrderEvent.getKey());

    if (order == null) {
      return OrderDeletedEvent.notFound(deleteOrderEvent.getKey());
    }

    OrderDetails details = order.toOrderDetails();

    //TODOCUMENT This contains some specific domain logic, not exposed to the outside world, and not part of the
    //persistence rules.

    if (!order.canBeDeleted()) {
      return OrderDeletedEvent.deletionForbidden(deleteOrderEvent.getKey(), details);
    }

    ordersRepository.delete(deleteOrderEvent.getKey());
    return new OrderDeletedEvent(deleteOrderEvent.getKey(), details);
  }

  @Override
  public OrderStatusEvent requestOrderStatus(RequestOrderStatusEvent requestOrderDetailsEvent) {
    Order order = ordersRepository.findById(requestOrderDetailsEvent.getKey());

    if (order == null) {
      return OrderStatusEvent.notFound(requestOrderDetailsEvent.getKey());
    }

    return new OrderStatusEvent(requestOrderDetailsEvent.getKey(), order.getStatus().toStatusDetails());
  }
}
