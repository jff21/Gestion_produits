package com.product.product_backend.Services;

import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.Models.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product createProd(ProductDTO productDTO,MultipartFile[] file);
    Product Update(ProductDTO productDTO);
    Optional<Product> getProd(Long pro_id);
    List<Product>Allproduct();
    void deleteprod(Long pro_id);
    Long countProBycat();
   //List<Product> SearchBySearchContext(SearchContext searchContext);
    List<Product> Search(String mark, String designation, String reference);

}
