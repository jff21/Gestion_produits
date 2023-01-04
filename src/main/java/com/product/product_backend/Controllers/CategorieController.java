package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Categorie;
import com.product.product_backend.Services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;

    @PostMapping("/create")
    public ResponseEntity<Categorie> createCat(@RequestBody CategorieDTO categorieDTO){
        return new ResponseEntity<>(categorieService.createCat(categorieDTO), HttpStatus.CREATED);
    }

    @GetMapping("/cat/{cat_id}")
    public Optional<Categorie> getCat(@PathVariable(name = "cat_id") Long cat_id){
        return categorieService.getCat(cat_id);
    }
}
