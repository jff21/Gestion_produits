package com.product.product_backend.Repositories;

import com.product.product_backend.Models.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepo extends JpaRepository<Level,Long> {
}
