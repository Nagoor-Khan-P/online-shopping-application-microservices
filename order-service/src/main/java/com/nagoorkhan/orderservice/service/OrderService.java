package com.nagoorkhan.orderservice.service;

import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderVO createOrder(OrderVO orderVO) {
        log.debug("In create order");
        return orderRepository.save(orderVO);

    }

    public OrderVO fetchOrder(Long orderId) {
        log.debug("In fetch order");
        return orderRepository.findById(orderId).orElse(null);
    }
}
