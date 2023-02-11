package com.product.product_backend.Repositories;

import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Models.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Iventory,Long> {

}
