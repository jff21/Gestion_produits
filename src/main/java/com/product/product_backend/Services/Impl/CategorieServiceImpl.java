package com.product.product_backend.Services.Impl;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Repositories.CatPropertieRepo;
import com.product.product_backend.Repositories.CategorieRepo;
import com.product.product_backend.Services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepo categorieRepo;
    private final CatPropertieRepo catPropertieRepo;

    @Override
    public Category createCat(CategorieDTO categorieDTO) {
        Category categorie= new Category();
        categorie.setName(categorieDTO.getName());
        categorie.setCid(categorieDTO.getCid());
        //categorie.setKey(categorieDTO.getKey());
        categorie= categorieRepo.save(categorie);
        categorieRepo.save(categorie);
        return categorie;

    }

    @Override
    public Category Update(CategorieDTO categorieDTO) {
        Category categorie= new Category();
        categorie.setCat_id(categorieDTO.getCat_id());
       // categorie.setKey(categorieDTO.getKey());
        categorie.setCid(categorieDTO.getCid());
        categorie.setName(categorieDTO.getName());
        categorieRepo.save(categorie);
        return categorie;
    }

    public Optional<Category> getCat(Long id) {
        return categorieRepo.findById(id);
    }

    @Override
    public List<Category> AllCat() {
        return categorieRepo.findAll();
    }

    @Override
    public void delete(Long cat_id) {
     categorieRepo.deleteById(cat_id);
    }
}
