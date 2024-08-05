package com.nagoorkhan.orderservice.service;

import com.nagoorkhan.orderservice.exceptionhandler.OrderExceptionHandler;
import com.nagoorkhan.orderservice.model.business.OrderLineItemsVO;
import com.nagoorkhan.orderservice.model.business.OrderVO;
import com.nagoorkhan.orderservice.model.response.InventoryResponseVO;
import com.nagoorkhan.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Arrays;
import java.util.List;
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
        List<String> skuCodes = orderVO.getOrderLineItemVOS().stream().map(OrderLineItemsVO::getSkuCode).toList();
        InventoryResponseVO[] inventoryResponseVOS =
                webClient.get().uri("http://localhost:8082/api/inventory",
                                uriBuilder -> uriBuilder.queryParam("skuCodes", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponseVO[].class)
                        .onErrorResume(WebClientResponseException.class, ex -> {
                            throw new OrderExceptionHandler(ex.getResponseBodyAsString(), 500);
                        })
                .block();
        boolean allProductsInStock = Arrays.stream(Objects.requireNonNull(inventoryResponseVOS)).allMatch(InventoryResponseVO::getIsInStock);
        if(allProductsInStock) {
            return orderRepository.save(orderVO);
        } else {
            throw new OrderExceptionHandler("Products are not in stock", 500);
        }

    }

    public OrderVO fetchOrder(Long orderId) {
        log.debug("In fetch order");
        return orderRepository.findById(orderId).orElse(null);
    }
}
