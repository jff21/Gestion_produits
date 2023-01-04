package com.product.product_backend.Services.Impl;

import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.Models.*;
import com.product.product_backend.Repositories.*;
import com.product.product_backend.Services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategorieRepo categorieRepo;
    private final UnitRepo unitRepo;
    private final LevelRepo levelRepo;
    private final ProductLineRepo productLineRepo;

    @Override
    public Product createProd(ProductDTO productDTO,MultipartFile[] file) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setDesignation(productDTO.getDesignation());
        product.setCurrentQuantity(productDTO.getCurrentQuantity());
        product.setMinimumThreshold(productDTO.getMinimumThreshold());
        product.setPerishable(false);
        product.setState(productDTO.getState());
        product.setMark(productDTO.getMark());
        product.setReference(productDTO.getReference());
        product.setUnitPrice(productDTO.getUnitPrice());
        Productline productline=productLineRepo.findById(productDTO.getProductline()).orElseThrow(EntityNotFoundException::new);
        product.setProductline(productline);
        Categorie categorie=categorieRepo.findById(productDTO.getCategorie()).orElseThrow(EntityNotFoundException::new);
        product.setCategorie(categorie);
        Unit unit = unitRepo.findById(productDTO.getUnit()).orElseThrow(EntityNotFoundException::new);
        product.setUnit(unit);
        Level level = levelRepo.findById(productDTO.getLevel()).orElseThrow(EntityNotFoundException::new);
        product.setLevel(level);
        try{
            Set<Media> img= uploadimg(file);
            product.setMedia(img);
           return productRepo.save(product);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<Media> uploadimg(MultipartFile[] multipartFiles) throws IOException {
        Set<Media> img = new HashSet<>();
        for(MultipartFile file: multipartFiles){
            Media imga = new Media(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            img.add(imga);
        }
        return img;
    }
    @Override
    public Product Update(ProductDTO productDTO) {
        Product product=new Product();
        product.setPro_id(productDTO.getPro_id());
        product.setDescription(productDTO.getDescription());
        product.setDesignation(productDTO.getDesignation());
        product.setCurrentQuantity(productDTO.getCurrentQuantity());
        product.setMinimumThreshold(productDTO.getMinimumThreshold());
        product.setPerishable(false);
        product.setState(productDTO.getState());
        product.setMark(productDTO.getMark());
        product.setReference(productDTO.getReference());
        product.setUnitPrice(productDTO.getUnitPrice());
        if(productDTO.getCategorie() !=null){
            product.setCategorie(categorieRepo.findById(productDTO.getCategorie()).orElseThrow(EntityNotFoundException::new));
        }
        if(productDTO.getUnit()!=null){
            product.setUnit(unitRepo.findById(productDTO.getUnit()).orElseThrow(EntityNotFoundException::new));
        }
        if(productDTO.getLevel()!=null){
            product.setLevel(levelRepo.findById(productDTO.getLevel()).orElseThrow(EntityNotFoundException::new));
        }
        productRepo.save(product);
        return product;
    }

    @Override
    public Optional<Product> getProd(Long pro_id) {
        return productRepo.findById(pro_id);
    }

    @Override
    public List<Product> Allproduct() {
        return productRepo.findAll();
    }

    @Override
    public void deleteprod(Long pro_id) {
       productRepo.deleteById(pro_id);
    }

    @Override
    public Long countProBycat() {
        return productRepo.count();
    }

//    @Override
//    public List<Product> SearchBySearchContext(SearchContext searchContext, Root<Product> productRoot) {
//        return productRepo.SearchBySearchcontext(searchContext);
//    }

    @Override
    public List<Product> Search(String mark, String designation, String reference) {
        return productRepo.Search(mark, designation, reference);
    }


}
