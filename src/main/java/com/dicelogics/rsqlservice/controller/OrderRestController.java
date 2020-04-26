package com.dicelogics.rsqlservice.controller;

import com.dicelogics.rsqlservice.model.Order;
import com.dicelogics.rsqlservice.repository.OrderFilterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRestController {

    private final OrderFilterRepo orderFilterService;

    @Autowired
    public OrderRestController(OrderFilterRepo orderFilterService) {
        this.orderFilterService = orderFilterService;
    }

    @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Order> getOrders(@RequestParam("query") String rQuery) {
        return orderFilterService.findByQuery(rQuery);
    }
}
