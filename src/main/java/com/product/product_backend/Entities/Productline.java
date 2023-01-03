package com.product.product_backend.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Productline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long line_id;
   // private Date deliveryDate;
    private int number;
    private float quantity;
    private String supplier;
}
