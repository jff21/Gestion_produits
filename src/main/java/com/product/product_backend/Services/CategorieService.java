package com.product.product_backend.Services;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieService {

    Categorie createCat(CategorieDTO categorieDTO);
    Categorie Update(CategorieDTO categorieDTO);
    Optional<Categorie> getCat(Long cat_id);
    List<Categorie> AllCat();
    void delete(Long cat_id);

}
