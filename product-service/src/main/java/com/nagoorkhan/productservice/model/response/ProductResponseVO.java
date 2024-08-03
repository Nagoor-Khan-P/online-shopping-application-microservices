package com.nagoorkhan.productservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponseVO {
    @Id
    private String pid;
    private String productName;
    private BigDecimal price;
    private String description;
}
