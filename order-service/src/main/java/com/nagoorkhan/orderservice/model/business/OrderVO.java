package com.nagoorkhan.orderservice.model.business;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String orderNum;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItemsVO> orderLineItemVOS;
}
