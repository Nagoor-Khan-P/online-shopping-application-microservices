package com.nagoorkhan.orderservice.repository;

import com.nagoorkhan.orderservice.model.business.OrderVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface OrderRepository extends JpaRepository<OrderVO, Long> {
}
