package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.CatPropertiesDTO;
import com.product.product_backend.Models.Cat_properties;
import com.product.product_backend.Repositories.CatPropertieRepo;
import com.product.product_backend.Services.Cat_properties_Service;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("prop")
@AllArgsConstructor


public class Cat_properties_Controller {
    private final Cat_properties_Service cat_properties_service;
    private final CatPropertieRepo catPropertieRepo;

    @PostMapping("create")
    public ResponseEntity<Cat_properties> createPro(@RequestBody CatPropertiesDTO catPropertiesDTO){
        return new ResponseEntity<>(cat_properties_service.createProp(catPropertiesDTO), HttpStatus.CREATED);
    }


    @GetMapping(value = "/{cid}/properties")
    public ResponseEntity<List<CatPropertiesDTO>> getPropertyMap(@PathVariable("cid") String cid) {
        return new ResponseEntity<>(cat_properties_service.findAllPropertiesByCatId(cid), HttpStatus.OK);
    }

}
