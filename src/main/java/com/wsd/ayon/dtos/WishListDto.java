package com.wsd.ayon.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WishListDto {
    private Integer id;
    private String productName;
    private String customerName;
    private Double quantity;
}
