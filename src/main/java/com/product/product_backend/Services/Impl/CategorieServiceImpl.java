package com.product.product_backend.Services.Impl;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Categorie;
import com.product.product_backend.Models.Catproperties;
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
    public Categorie createCat(CategorieDTO categorieDTO) {
        Categorie categorie= new Categorie();
        categorie.setName(categorieDTO.getName());
//        categorie.setCreationDate(categorieDTO.getCreationDate());
//        categorie.setLastUpdate(categorieDTO.getLastUpdate());
        List<Catproperties> properties = catPropertieRepo.findAllByCategorie(categorieDTO.getCatproperties());
        categorie.setCatproperties(properties);
        categorieRepo.save(categorie);
        return categorie;
    }

    @Override
    public Categorie Update(CategorieDTO categorieDTO) {
        Categorie categorie= new Categorie();
        categorie.setCat_id(categorieDTO.getCat_id());
        categorie.setName(categorieDTO.getName());
        categorieRepo.save(categorie);
        return categorie;
    }

    @Override
    public Optional<Categorie> getCat(Long cat_id) {
        return categorieRepo.findById(cat_id);
    }

    @Override
    public List<Categorie> AllCat() {
        return categorieRepo.findAll();
    }

    @Override
    public void delete(Long cat_id) {
     categorieRepo.deleteById(cat_id);
    }
}
