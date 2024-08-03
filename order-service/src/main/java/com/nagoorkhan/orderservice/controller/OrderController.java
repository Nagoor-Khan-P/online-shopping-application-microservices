package com.nagoorkhan.orderservice.controller;

import com.nagoorkhan.orderservice.mapper.OrderRequestMapper;
import com.nagoorkhan.orderservice.mapper.OrderResponseMapper;
import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.model.request.OrderRequestVO;
import com.nagoorkhan.orderservice.model.response.OrderResponseVO;
import com.nagoorkhan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRequestMapper orderRequestMapper;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseVO> placeOrder(@RequestBody OrderRequestVO orderRequestVO) {
        OrderVO orderVO = orderRequestMapper.orderRequestVOToOrderVO(orderRequestVO);
        return ResponseEntity.ok(orderResponseMapper.orderVOToOrderResponseVO(orderService.createOrder(orderVO)));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseVO> fetchOrder(@PathVariable("orderId") Long orderId) {
        return ResponseEntity.ok(orderResponseMapper.orderVOToOrderResponseVO(orderService.fetchOrder(orderId)));
    }
}
