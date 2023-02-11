package com.product.product_backend.Services;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Category;

import java.util.List;
import java.util.Optional;

public interface CategorieService {

    Category createCat(CategorieDTO categorieDTO);
    Category Update(CategorieDTO categorieDTO);
    Optional<Category> getCat(Long id);
    List<Category> AllCat();
    void delete(Long cat_id);


}
