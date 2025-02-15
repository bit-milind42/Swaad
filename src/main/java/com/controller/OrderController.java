package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milind.model.CartItem;
import com.milind.model.Order;
import com.milind.model.User;
import com.request.AddCartItemRequest;
import com.request.OrderRequest;
import com.service.OrderService;
import com.service.UserService;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
        @RequestHeader("Authorization") String jwt) throws Exception {
            User user=userService.findUserByJwtToken(jwt);
            Order order=orderService.createOrder(req, null);
            return new ResponseEntity<>(order, HttpStatus.OK);
    }


    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
        @RequestHeader("Authorization") String jwt) throws Exception {
            User user=userService.findUserByJwtToken(jwt);
            List<Order> orders=orderService.getUsersOrder(user.getId());
            return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}
