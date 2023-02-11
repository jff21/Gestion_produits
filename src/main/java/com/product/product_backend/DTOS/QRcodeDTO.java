package com.product.product_backend.DTOS;

import com.product.product_backend.Models.Product;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class QRcodeDTO {

    private long code;
    private Byte[] code_url;
    private Long product;
}
