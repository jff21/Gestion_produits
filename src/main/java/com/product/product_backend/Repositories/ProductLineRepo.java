package com.product.product_backend.Repositories;

import com.product.product_backend.Models.Productline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLineRepo extends JpaRepository<Productline,Long> {
}
