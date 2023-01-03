package com.product.product_backend.Repositories;

import com.product.product_backend.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}
