package com.product.product_backend.Repositories;

import com.product.product_backend.Models.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<Media,Long> {

    Optional<Media> findById(Media media);
}
