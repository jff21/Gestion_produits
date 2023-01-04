package com.product.product_backend.Services.Impl;

import com.product.product_backend.Entities.Productline;
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
    public Productline addLine() {
        Productline productline = new Productline();
        productline.setNumber(productline.getNumber());
        productline.setQuantity(productline.getQuantity());
        productline.setSupplier(productline.getSupplier());
        productLineRepo.save(productline);
        return productline;
    }

    @Override
    public Productline Update() {
        Productline productline = new Productline();
        productline.setLine_id(productline.getLine_id());
        productline.setNumber(productline.getNumber());
        productline.setQuantity(productline.getQuantity());
        productline.setSupplier(productline.getSupplier());
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
