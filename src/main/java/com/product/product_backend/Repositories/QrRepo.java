package com.product.product_backend.Repositories;

import com.product.product_backend.Entities.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrRepo extends JpaRepository<QrCode,Long> {
}
