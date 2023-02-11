package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.DTOS.ResultprocatDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Repositories.CategorieRepo;
import com.product.product_backend.Services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategorieController {
    private final CategorieService categorieService;

    private final CategorieRepo categorieRepo;

    @PostMapping("/create")
    public ResponseEntity<Category> createCat(@RequestBody CategorieDTO categorieDTO){
        return new ResponseEntity<>(categorieService.createCat(categorieDTO), HttpStatus.CREATED);
    }

    @GetMapping("/cat/{id}")
    public Optional<Category> getCat(@PathVariable Long id){
        return categorieService.getCat(id);
    }

    @GetMapping("/all")
    public List<Category> getCat(){
        return categorieService.AllCat();
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCat(@RequestBody CategorieDTO categorieDTO){
        return new ResponseEntity<>(categorieService.Update(categorieDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long cat_id){
        categorieService.delete(cat_id);
    }

//    @GetMapping("/getdetails/{cat_id}")
//    public List<ResultprocatDTO> getDetails(@PathVariable Long cat_id){
//      return   categorieRepo.getDetails(cat_id);
//    }
}
