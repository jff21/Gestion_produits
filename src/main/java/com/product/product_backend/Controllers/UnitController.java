package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.UnitDTO;
import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Models.Unit;
import com.product.product_backend.Services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/unit")
@RestController
@AllArgsConstructor
public class UnitController {

    private final UnitService unitService;

    @PostMapping("/create")
    public ResponseEntity<Unit> createunit(@RequestBody UnitDTO unitDTO){
        return new ResponseEntity<>(unitService.createunit(unitDTO), HttpStatus.OK);
    }
}
