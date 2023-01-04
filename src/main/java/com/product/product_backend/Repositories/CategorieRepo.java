package com.product.product_backend.Repositories;

import com.product.product_backend.Models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}
