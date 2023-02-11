package com.product.product_backend.Repositories;

import com.product.product_backend.DTOS.ResultprocatDTO;
import com.product.product_backend.Models.Cat_properties;
import com.product.product_backend.Models.Category;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieRepo extends JpaRepository<Category,Long> {
    @Query(value = "SELECT * FROM category WHERE cid =:cid",nativeQuery = true)
    Category findByCid(String cid);


//    @Query("SELECT new com.product.product_backend.DTOS.ResultprocatDTO" +
//            "(c.cid,c.key,c.createDate,c.lastUpdate,c.name,cp.range,cp.mark,cp.color) " +
//            "FROM Category c join c.cat_properties cp " +
//            "where c.cat_id = :cat_id")
//    List<ResultprocatDTO> getDetails(long cat_id);

}
