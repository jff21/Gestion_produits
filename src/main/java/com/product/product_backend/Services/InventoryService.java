package com.product.product_backend.Services;

import com.product.product_backend.DTOS.InventoryDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Models.Iventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {

    Iventory create(InventoryDTO inventoryDTO);
    Iventory update(InventoryDTO inventoryDTO);
    Optional<Iventory> getinv(Long  id);
    List<Iventory> Allinv();
    void deleteinv(Long  id);
}
