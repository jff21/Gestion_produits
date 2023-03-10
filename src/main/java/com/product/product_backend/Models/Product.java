package com.product.product_backend.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pro_id ;
    private String description;
    private String designation;
    private float currentQuantity;
    private String mark;
    private boolean perishable;
    private int state;
    private float minimumThreshold;
    private int unitPrice;
    private String reference;
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private Byte[] qrCode;
    @ManyToOne
    private Category categorie;
    @ManyToOne
    private Level level;
    @ManyToOne
    private Unit unit;
    @ManyToOne
    private Productline productline;
    @ManyToOne
    private Iventory iventory;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "prod_media", joinColumns = {@JoinColumn(name = "prod_id")},
            inverseJoinColumns = {@JoinColumn(name = "media_id")})
    private Set<Media>  media;
//
//    @OneToOne
//    private QrCode qrCode;

}
