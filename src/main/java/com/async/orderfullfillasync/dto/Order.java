package com.async.orderfullfillasync.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private int productId;
    private String name;
    private String productType;
    private int qty;
    private double price;
    private String trackingId;
}
