package com.product.product_backend.DTOS;

import lombok.Data;

@Data
public class ProductDTO {
    private long pro_id ;
    private String description;
    private String designation;
    private float currentQuantity;
    private String mark;
    private boolean perishable;
    private int state;
    private float minimumThreshold;
    private int unitPrice;
    private String reference;
    private String qrCode;
    private Long categorie;
    private Long level;
    private Long unit;
    private Long productline;
    private Long media;
    private Long iventory;
}
