package com.product.product_backend.Services.Impl;

import com.product.product_backend.DTOS.ProductLineDTO;
import com.product.product_backend.Models.Productline;
import com.product.product_backend.Repositories.ProductLineRepo;
import com.product.product_backend.Services.ProductUnitService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductLineServiceImpl implements ProductUnitService {

    private final ProductLineRepo productLineRepo;

    public ProductLineServiceImpl(ProductLineRepo productLineRepo) {
        this.productLineRepo = productLineRepo;
    }

    @Override
    public Productline addLine(ProductLineDTO productLineDTO) {
        Productline productline = new Productline();
        productline.setNumber(productLineDTO.getNumber());
        productline.setQuantity(productLineDTO.getQuantity());
        productline.setSupplier(productLineDTO.getSupplier());
        productLineRepo.save(productline);
        return productline;
    }

    @Override
    public Productline Update(ProductLineDTO productLineDTO) {
        Productline productline = new Productline();
        productline.setLine_id(productLineDTO.getLine_id());
        productline.setNumber(productLineDTO.getNumber());
        productline.setQuantity(productLineDTO.getQuantity());
        productline.setSupplier(productLineDTO.getSupplier());
        productLineRepo.save(productline);
        return productline;
    }

    @Override
    public List<Productline> AllLine() {
        return productLineRepo.findAll();
    }

    @Override
    public Optional<Productline> getLine(Long line_id) {

        return productLineRepo.findById(line_id);
    }

    @Override
    public void delete(Long line_id) {
      productLineRepo.deleteById(line_id);
    }
}
