package com.product.product_backend.Repositories;

import com.product.product_backend.Entities.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long>, ProductRepoCustum {

    List<Product> findAll(Specification<Product> specification);
}
