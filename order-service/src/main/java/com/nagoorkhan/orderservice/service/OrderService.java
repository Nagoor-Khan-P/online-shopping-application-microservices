package com.nagoorkhan.orderservice.service;

import com.nagoorkhan.orderservice.exceptionhandler.OrderExceptionHandler;
import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.model.response.InventoryResponseVO;
import com.nagoorkhan.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public OrderVO createOrder(OrderVO orderVO) {
        log.debug("In create order");
        InventoryResponseVO[] inventoryResponseVOS = webClient.get().uri("http://localhost:8082/api/inventory")
                .retrieve()
                .bodyToMono(InventoryResponseVO[].class)
                .block();
        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponseVOS)).allMatch(InventoryResponseVO::getIsInStock);
        if(allProductsInStock) {
            return orderRepository.save(orderVO);
        } else {
            throw new OrderExceptionHandler("Products are not in stock");
        }

    }

    public OrderVO fetchOrder(Long orderId) {
        log.debug("In fetch order");
        return orderRepository.findById(orderId).orElse(null);
    }
}
