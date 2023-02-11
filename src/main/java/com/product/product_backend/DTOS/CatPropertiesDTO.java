package com.product.product_backend.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.product.product_backend.Models.Category;
import lombok.Data;

import java.io.Serializable;

@Data
public class CatPropertiesDTO  {
    private String range;
    private String key;
    private String name;
    private String mark;
    private String color;
 @JsonProperty(required = true)
    public Category category;
}
