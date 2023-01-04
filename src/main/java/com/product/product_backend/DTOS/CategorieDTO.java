package com.product.product_backend.DTOS;

import com.product.product_backend.Models.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategorieDTO {

    private Long cat_id;
//    private Date creationDate;
//    private Date lastUpdate;
    private String name;
    private List<Product> product;
    private Long  catproperties;

}
