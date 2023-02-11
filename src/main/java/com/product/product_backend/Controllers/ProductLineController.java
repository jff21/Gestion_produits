package com.product.product_backend.Controllers;


import com.product.product_backend.DTOS.ProductLineDTO;
import com.product.product_backend.Models.Productline;
import com.product.product_backend.Services.ProductUnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/prodline")
@RestController
@AllArgsConstructor
public class ProductLineController {

    private final ProductUnitService productUnitService;


    @PostMapping("/create")
        public ResponseEntity<Productline> create(@RequestBody ProductLineDTO productLineDTO){
        return new ResponseEntity<>(productUnitService.addLine(productLineDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Productline> Update(@RequestBody ProductLineDTO productLineDTO){
        return new ResponseEntity<>(productUnitService.Update(productLineDTO), HttpStatus.OK);
    }

    @GetMapping("/prodline/{id}")
    public Optional<Productline> getLine(@PathVariable Long line_id){
        return productUnitService.getLine(line_id);
    }

    @GetMapping("/All")
    public List<Productline> AllLine(){
        return productUnitService.AllLine();
    }

    @DeleteMapping("/del/{id}")
    public void delete(@PathVariable Long Line_id){
        productUnitService.delete(Line_id);
    }
}
