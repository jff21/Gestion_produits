package com.product.product_backend.Repositories;

import com.product.product_backend.Entities.Catproperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatPropertieRepo extends JpaRepository<Catproperties,Long> {

    @Query(value = "SELECT * FROM catproperties WHERE cat_id=:id" ,nativeQuery = true)
    List<Catproperties> findAllByCategorie(Long id);
}
