package com.nagoorkhan.orderservice.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class InventoryResponseVO {
    private Long id;
    private String skuCode;
    private Long quantity;
    @Schema(description = "True if quantity is > 0, False if it is 0")
    private Boolean isInStock;
}
