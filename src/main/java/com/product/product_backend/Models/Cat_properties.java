package com.product.product_backend.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat_properties {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prop_id ;
    private String key;
    private String range;
    private String name;
    private String mark;
    private String color;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category",referencedColumnName = "cid")
    @JsonBackReference
    public Category category;
}
