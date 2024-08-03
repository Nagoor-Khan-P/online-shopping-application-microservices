package com.nagoorkhan.productservice.model.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestVO {
    private String productName;
    private BigDecimal price;
    private String description;

}
