package com.product.product_backend.Services;

import com.product.product_backend.DTOS.ProductLineDTO;
import com.product.product_backend.Models.Productline;

import java.util.List;
import java.util.Optional;

public interface ProductUnitService {

    Productline addLine(ProductLineDTO productLineDTO);
    Productline Update(ProductLineDTO productLineDTO);
    List<Productline> AllLine();
    Optional<Productline>getLine(Long line_id);
    void delete (Long line_id);

}
