package com.product.product_backend.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.product_backend.DTOS.ProductLineDTO;
import com.product.product_backend.Models.Productline;
import com.product.product_backend.Repositories.ProductLineRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProductLineServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductLineServiceImplTest {
    @MockBean
    private ProductLineRepo productLineRepo;

    @Autowired
    private ProductLineServiceImpl productLineServiceImpl;

    /**
     * Method under test: {@link ProductLineServiceImpl#addLine(ProductLineDTO)}
     */
    @Test
    void testAddLine() {
        Productline productline = new Productline();
        productline.setLine_id(1L);
        productline.setNumber(10);
        productline.setQuantity(10.0f);
        productline.setSupplier("Supplier");
        when(this.productLineRepo.save((Productline) any())).thenReturn(productline);

        ProductLineDTO productLineDTO = new ProductLineDTO();
        productLineDTO.setLine_id(1L);
        productLineDTO.setNumber(10);
        productLineDTO.setQuantity(1);
        productLineDTO.setSupplier("Supplier");
        Productline actualAddLineResult = this.productLineServiceImpl.addLine(productLineDTO);
        assertEquals("Supplier", actualAddLineResult.getSupplier());
        assertEquals(1.0f, actualAddLineResult.getQuantity());
        assertEquals(10, actualAddLineResult.getNumber());
        verify(this.productLineRepo).save((Productline) any());
    }
}

