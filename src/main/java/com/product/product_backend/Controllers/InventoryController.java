package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.InventoryDTO;
import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Repositories.InventoryRepository;
import com.product.product_backend.Services.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryController {

    private final InventoryRepository inventoryRepository;
    private final InventoryService inventoryService;

    @PostMapping("/create")
    public ResponseEntity<Iventory> createinv(@RequestBody InventoryDTO inventoryDTO){
        return new ResponseEntity<>(inventoryService.create(inventoryDTO), HttpStatus.OK);
    }

    @PutMapping ("/create")
    public ResponseEntity<Iventory> updateinv(@RequestBody InventoryDTO inventoryDTO){
        return new ResponseEntity<>(inventoryService.update(inventoryDTO), HttpStatus.OK);
    }

    @GetMapping("/inv/{id}")
    public Optional<Iventory> getinv(@PathVariable Long  id){
        return inventoryService.getinv(id);
    }

    @GetMapping("/All")
    public List<Iventory> Allinv(){
        return inventoryService.Allinv();
    }

    @DeleteMapping("/{id}")
    public void deleteinv(@PathVariable Long  id){
        inventoryService.deleteinv(id);
    }
}
