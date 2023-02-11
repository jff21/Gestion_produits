package com.product.product_backend.Repositories;

import com.product.product_backend.Models.Cat_properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatPropertieRepo extends JpaRepository<Cat_properties,Long> {

    @Query(value = "SELECT * FROM catproperties WHERE categorie_cat_id=:id" ,nativeQuery = true)
    List<Cat_properties> findAllByCategorie(Long id);

    @Query(value = "SELECT cp FROM Cat_properties cp WHERE cp.category.cid = :cid")
    List<Cat_properties> findByCategoryCid(@Param("cid") String cid);
}
