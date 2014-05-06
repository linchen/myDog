//package com.mydog.rest.controller;
//
//
//import com.mydog.core.events.Orders.CreateOrderEvent;
//import com.mydog.core.events.Orders.DeleteOrderEvent;
//import com.mydog.core.events.Orders.OrderCreatedEvent;
//import com.mydog.core.events.Orders.OrderDeletedEvent;
//import com.mydog.core.services.OrderService;
//import com.mydog.rest.domain.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.util.UUID;
//
//
//@Controller
//@RequestMapping("/aggregators/orders")
//public class OrderCommandsController {
//
//    @Autowired
//    private OrderService orderService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Order> createOrder(@RequestBody Order order, UriComponentsBuilder builder) {
//        OrderCreatedEvent orderCreated = orderService.createOrder(new CreateOrderEvent(order.toOrderDetails()));
//        Order newOrder = Order.fromOrderDetails(orderCreated.getDetails());
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/aggregators/orders/{id}").buildAndExpand(orderCreated.getNewOrderKey().toString()).toUri());
//
//        return new ResponseEntity<>(newOrder, headers, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
//    public ResponseEntity<Order> cancelOrder(@PathVariable String id) {
//
//        OrderDeletedEvent orderDeleted = orderService.deleteOrder(new DeleteOrderEvent(UUID.fromString(id)));
//
//        if (!orderDeleted.isEntityFound()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        Order order = Order.fromOrderDetails(orderDeleted.getDetails());
//
//        if (orderDeleted.isDeletionCompleted()) {
//            return new ResponseEntity<>(order, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(order, HttpStatus.FORBIDDEN);
//    }
//}
