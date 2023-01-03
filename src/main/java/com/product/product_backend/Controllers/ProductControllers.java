package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.DTOS.SearchContext;
import com.product.product_backend.Entities.Media;
import com.product.product_backend.Entities.Product;
import com.product.product_backend.Repositories.MediaRepository;
import com.product.product_backend.Services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Slf4j
@RestController
@RequestMapping("/product")
public class ProductControllers {
    private final ProductService productService;
    private final MediaRepository mediaRepository;

    public ProductControllers(ProductService productService, MediaRepository mediaRepository) {
        this.productService = productService;
        this.mediaRepository = mediaRepository;
    }

    @PostMapping(value={"/create"},consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Product createProd(@RequestPart ProductDTO productDTO,@RequestPart MultipartFile[] file) {
        log.info("creating product..........");
        return productService.createProd(productDTO,file);
        }


   @PostMapping("/update")
    public ResponseEntity<Product> UpdateProd(@RequestBody ProductDTO productDTO){
        log.info("updating product..........");
        return new ResponseEntity<>(productService.Update(productDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getPro/{prod_id}")
    public Optional<Product>getProd(@PathVariable(name = "prod_id") Long prod_id){
        return productService.getProd(prod_id);
    }

    @GetMapping("/Allprod")
    public List<Product> Allprod(){
        log.info("getting all prod.....");
        return productService.Allproduct();
    }

    @PostMapping("/delete/{prod_id}")
    public void deleteProd(@PathVariable(name = "prod_id") Long prod_id){
        productService.deleteprod(prod_id);
    }

    @GetMapping("/count")
    public Long countProd(){
        return productService.countProBycat();
    }


   @GetMapping("/search")
   public ResponseEntity<List<Product>> newSearch(@RequestParam(value = "mark",required = false) String mark, @RequestParam(value = "designation",required = false) String designation,
                                                  @RequestParam(value = "reference",required = false) String reference){
        return new ResponseEntity<>(productService.Search(mark, designation, reference),HttpStatus.OK);
   }
}
