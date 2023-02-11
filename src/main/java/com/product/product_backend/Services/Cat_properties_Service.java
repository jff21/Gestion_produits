package com.product.product_backend.Services;

import com.product.product_backend.DTOS.CatPropertiesDTO;
import com.product.product_backend.Models.Cat_properties;

import java.util.List;

public interface Cat_properties_Service {

    Cat_properties createProp(CatPropertiesDTO catPropertiesDTO);
    List<CatPropertiesDTO> findAllPropertiesByCatId (String catKey);
}
