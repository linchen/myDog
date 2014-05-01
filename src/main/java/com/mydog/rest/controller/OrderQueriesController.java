package com.mydog.rest.controller;

import com.mydog.core.events.Orders.OrderDetails;
import com.mydog.core.events.Orders.OrderDetailsEvent;
import com.mydog.core.events.Orders.RequestAllOrdersEvent;
import com.mydog.core.events.Orders.RequestOrderDetailsEvent;

import com.mydog.core.services.OrderService;
import com.mydog.rest.domain.Order;
import org.slf4j.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by Lin on 21.04.14.
 */
@Controller
@RequestMapping("/aggregators/orders")
public class OrderQueriesController {

    private static Logger LOG = LoggerFactory.getLogger(OrderQueriesController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        for(OrderDetails details: orderService.requestAllOrders(new RequestAllOrdersEvent()).getOrderDetails()) {
             orders.add(Order.fromOrderDetails(details));
        }
        return orders;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Order> viewOrder(@PathVariable String id) {
        OrderDetailsEvent details = orderService.requestOrderDetails(new RequestOrderDetailsEvent(UUID.fromString(id)));
        if (!details.isEntityFound()) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }

        Order order = Order.fromOrderDetails(details.getOrderDetails());

        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }


}
