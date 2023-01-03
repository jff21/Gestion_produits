package com.product.product_backend.DTOS;

import lombok.Data;

import java.util.Date;

@Data
public class ProductLineDTO {
    private long line_id;
   // private Date deliveryDate;
    private int number;
    private float quantity;
    private String supplier;
}
