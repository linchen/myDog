package com.mydog.core.repository;

import com.mydog.core.domain.Order;

import java.util.List;
import java.util.UUID;

//TODO, make this event based again, with persistence integration events.
public interface OrdersRepository {

  Order save(Order order);

  void delete(UUID key);

  Order findById(UUID key);

  List<Order> findAll();
}
