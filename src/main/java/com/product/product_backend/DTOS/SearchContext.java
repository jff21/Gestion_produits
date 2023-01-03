package com.product.product_backend.DTOS;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SearchContext implements Serializable {

    private String key;
    private String mark;
    private String designation;
    private String reference;
    }
