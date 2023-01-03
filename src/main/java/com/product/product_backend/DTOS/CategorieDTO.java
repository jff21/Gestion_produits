package com.product.product_backend.DTOS;

import com.product.product_backend.Entities.Catproperties;
import com.product.product_backend.Entities.Product;
import lombok.Data;

import javax.persistence.OneToMany;
import java.util.Date;
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
