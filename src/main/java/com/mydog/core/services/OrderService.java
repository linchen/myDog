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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface OrderService {

    OrderCreatedEvent createOrder(CreateOrderEvent createOrderEvent);

     AllOrdersEvent requestAllOrders(RequestAllOrdersEvent requestAllCurrentOrdersEvent);

    OrderDetailsEvent requestOrderDetails(RequestOrderDetailsEvent requestOrderDetailsEvent);

    OrderUpdatedEvent setOrderPayment(SetOrderPaymentEvent setOrderPaymentEvent);

    OrderDeletedEvent deleteOrder(DeleteOrderEvent deleteOrderEvent);

    OrderStatusEvent requestOrderStatus(RequestOrderStatusEvent requestOrderDetailsEvent);

}
