package com.product.product_backend.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String nom;
    private String tye;
    @Column(length = 50000000)
    private byte[] img;


    public Media(String nom, String tye, byte[] img) {
        this.nom = nom;
        this.tye = tye;
        this.img = img;
    }

}
