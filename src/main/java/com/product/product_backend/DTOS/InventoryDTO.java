package com.product.product_backend.DTOS;

import lombok.Data;

import java.util.Date;

@Data
public class InventoryDTO {

    private Long  id;
    private Date date ;
    private float number;
    private Boolean validation;
}
