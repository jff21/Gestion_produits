package com.product.product_backend.Services.Impl;

import com.product.product_backend.DTOS.InventoryDTO;
import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Repositories.InventoryRepository;
import com.product.product_backend.Services.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;


    @Override
    public Iventory create(InventoryDTO inventoryDTO) {
        Iventory inv = new Iventory();
        inv.setNumber(inventoryDTO.getNumber());
        inv.setValidation(inventoryDTO.getValidation());
        return inventoryRepository.save(inv);
    }

    @Override
    public Iventory update(InventoryDTO inventoryDTO) {
        Iventory inv = new Iventory();
        inv.setId(inventoryDTO.getId());
        inv.setNumber(inventoryDTO.getNumber());
        inv.setValidation(inventoryDTO.getValidation());
        return inventoryRepository.save(inv);
    }

    @Override
    public Optional<Iventory> getinv(Long  id) {
        return inventoryRepository.findById(id);
    }

    @Override
    public List<Iventory> Allinv() {
        return inventoryRepository.findAll();
    }

    @Override
    public void deleteinv(Long  id) {
        inventoryRepository.deleteById(id);
    }
}
