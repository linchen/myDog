package com.mydog.core.services;

import com.mydog.core.events.Orders.AllOrdersEvent;
import com.mydog.core.events.Orders.CreateOrderEvent;
import com.mydog.core.events.Orders.DeleteOrderEvent;
import com.mydog.core.events.Orders.OrderCreatedEvent;
import com.mydog.core.events.Orders.OrderDeletedEvent;
import com.mydog.core.events.Orders.OrderDetailsEvent;
import com.mydog.core.events.Orders.OrderStatusEvent;
import com.mydog.core.events.Orders.OrderUpdatedEvent;
import com.mydog.core.events.Orders.RequestAllOrdersEvent;
import com.mydog.core.events.Orders.RequestOrderDetailsEvent;
import com.mydog.core.events.Orders.RequestOrderStatusEvent;
import com.mydog.core.events.Orders.SetOrderPaymentEvent;

//TODOCUMENT THis is an event driven service.
// Used to interact with the core domain.
//All methods are guaranteed to return something, null will never be returned.
public interface OrderService {

  public AllOrdersEvent requestAllOrders(RequestAllOrdersEvent requestAllCurrentOrdersEvent);

  public OrderDetailsEvent requestOrderDetails(RequestOrderDetailsEvent requestOrderDetailsEvent);

  public OrderStatusEvent requestOrderStatus(RequestOrderStatusEvent requestOrderStatusEvent);

  public OrderCreatedEvent createOrder(CreateOrderEvent event);

  public OrderUpdatedEvent setOrderPayment(SetOrderPaymentEvent setOrderPaymentEvent);

  public OrderDeletedEvent deleteOrder(DeleteOrderEvent deleteOrderEvent);
}
