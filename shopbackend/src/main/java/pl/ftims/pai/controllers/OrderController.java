package pl.ftims.pai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ftims.pai.dtos.NewOrderData;
import pl.ftims.pai.entities.Order;
import pl.ftims.pai.services.OrderService;

import java.util.List;

@RestController
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/newOrder")
    public ResponseEntity<Order> newOrder(@RequestBody NewOrderData orderData) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(orderData));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/allOrders")
    public List<Order> listAllOrders() {
        return orderService.getAllOrders();
    }
}
