package com.product.product_backend.Services.Impl;

import com.product.product_backend.Assembler.CategoryDtoAssembler;
import com.product.product_backend.DTOS.CatPropertiesDTO;
import com.product.product_backend.Models.Cat_properties;
import com.product.product_backend.Repositories.CatPropertieRepo;
import com.product.product_backend.Repositories.CategorieRepo;
import com.product.product_backend.Services.Cat_properties_Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class Cat_properties_ServiceImpl implements Cat_properties_Service {
    private final CatPropertieRepo catPropertieRepo;
    private final CategorieRepo categorieRepo;
    private final CategoryDtoAssembler categoryDtoAssembler;
    @Override
    public Cat_properties createProp(CatPropertiesDTO catPropertiesDTO) {
        Cat_properties cat_properties = new Cat_properties();
        cat_properties.setName(catPropertiesDTO.getName());
        cat_properties.setKey(catPropertiesDTO.getKey());
        cat_properties.setMark(catPropertiesDTO.getMark());
        cat_properties.setColor(catPropertiesDTO.getColor());
        cat_properties.setRange(catPropertiesDTO.getRange());
        cat_properties.setCategory(categorieRepo.findByCid(catPropertiesDTO.getCategory().getCid()));
        catPropertieRepo.save(cat_properties);
        return cat_properties;
    }

    @Override
    public List<CatPropertiesDTO> findAllPropertiesByCatId(String cid) {
        List<CatPropertiesDTO> properties = new ArrayList<>();
        catPropertieRepo.findByCategoryCid(cid).forEach((cat_properties) -> properties.add(categoryDtoAssembler.buildPropertyDto(cat_properties)));
        return properties;
    }




}
