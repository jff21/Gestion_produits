package com.product.product_backend.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultprocatDTO {

    private String cid;
    private String key;
    private Date createDate;
    private Date lastUpdate;
    private String name;

    private String range;
    private String mark;
    private String color;
}
