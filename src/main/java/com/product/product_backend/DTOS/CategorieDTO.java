package com.product.product_backend.DTOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.product.product_backend.Models.Product;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CategorieDTO {

    private Long cat_id;
    private String cid;
    private String key;
    private Date createDate;
    private Date lastUpdate;
    private String name;

}
