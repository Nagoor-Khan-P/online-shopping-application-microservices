package com.nagoorkhan.productservice.model.business;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document("product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductVO {
    @Id
    private String pid;
    private String productName;
    private BigDecimal price;
    private String description;

    public ProductVO(String productName, BigDecimal price, String description) {
        this.productName = productName;
        this.price = price;
        this.description = description;
    }
}
