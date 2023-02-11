package com.product.product_backend;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Repositories.CategorieRepo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductBackendApplicationTests {
	private final CategorieRepo categorieRepo;

	ProductBackendApplicationTests(CategorieRepo categorieRepo) {
		this.categorieRepo = categorieRepo;
	}
//
//	@Test
//	void contextLoads() {
//	}

}
