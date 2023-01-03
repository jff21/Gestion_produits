package com.product.product_backend.Repositories;

import com.product.product_backend.Entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepo extends JpaRepository<Unit,Long> {
}
