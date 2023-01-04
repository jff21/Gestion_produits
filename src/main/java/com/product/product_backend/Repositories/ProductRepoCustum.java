package com.product.product_backend.Repositories;

import com.product.product_backend.DTOS.SearchContext;
import com.product.product_backend.Models.Product;

import java.util.List;

public interface ProductRepoCustum {

    List<Product>FindSimilarProd(String mark);
    List<Product>Search(String mark,String designation,String reference);
    List<Product>SearchBySearchcontext(SearchContext searchContext);
}
