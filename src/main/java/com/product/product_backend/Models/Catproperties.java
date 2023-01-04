package com.product.product_backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catproperties {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prop_id ;
    private String range;
    private String name;
    private String mark;
    private Date lastUpdate;
    private Date creationDate;
    private String color;
}
