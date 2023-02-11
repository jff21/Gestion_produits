package com.product.product_backend.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.product_backend.DTOS.ProductQRDTO;
import com.product.product_backend.DTOS.QRcodeDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Models.Level;
import com.product.product_backend.Models.Product;
import com.product.product_backend.Models.Productline;
import com.product.product_backend.Models.QrCode;
import com.product.product_backend.Models.Unit;
import com.product.product_backend.Repositories.ProductRepo;
import com.product.product_backend.Repositories.QrRepo;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {QrServiceImpl.class})
@ExtendWith(SpringExtension.class)
class QrServiceImplTest {
    @MockBean
    private ProductRepo productRepo;

    @MockBean
    private QrRepo qrRepo;

    @Autowired
    private QrServiceImpl qrServiceImpl;

    /**
     * Method under test: {@link QrServiceImpl#generateQR(ProductQRDTO, int, int)}
     */
    @Test
    void testGenerateQR() {
        ProductQRDTO productQRDTO = new ProductQRDTO();
        productQRDTO.setDescription("The characteristics of someone or something");
        productQRDTO.setUnitPrice(1);
        assertEquals(319, this.qrServiceImpl.generateQR(productQRDTO, 1, 1).length);
    }

    /**
     * Method under test: {@link QrServiceImpl#generateQR(ProductQRDTO, int, int)}
     */
    @Test
    void testGenerateQR2() {
        ProductQRDTO productQRDTO = mock(ProductQRDTO.class);
        doNothing().when(productQRDTO).setDescription((String) any());
        doNothing().when(productQRDTO).setUnitPrice(anyInt());
        productQRDTO.setDescription("PNG");
        productQRDTO.setUnitPrice(1);
        this.qrServiceImpl.generateQR(productQRDTO, 1, 1);
        verify(productQRDTO).setDescription((String) any());
        verify(productQRDTO).setUnitPrice(anyInt());
    }

    /**
     * Method under test: {@link QrServiceImpl#generateQR(ProductQRDTO, int, int)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateQR3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Requested dimensions are too small: -1x1
        //       at com.google.zxing.qrcode.QRCodeWriter.encode(QRCodeWriter.java:63)
        //       at com.google.zxing.qrcode.QRCodeWriter.encode(QRCodeWriter.java:44)
        //       at com.product.product_backend.Services.Impl.QrServiceImpl.generateQR(QrServiceImpl.java:37)
        //   In order to prevent generateQR(ProductQRDTO, int, int)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   generateQR(ProductQRDTO, int, int).
        //   See https://diff.blue/R013 to resolve this issue.

        ProductQRDTO productQRDTO = mock(ProductQRDTO.class);
        doNothing().when(productQRDTO).setDescription((String) any());
        doNothing().when(productQRDTO).setUnitPrice(anyInt());
        productQRDTO.setDescription("The characteristics of someone or something");
        productQRDTO.setUnitPrice(1);
        this.qrServiceImpl.generateQR(productQRDTO, -1, 1);
    }

    /**
     * Method under test: {@link QrServiceImpl#saveQrcode(QRcodeDTO, ProductQRDTO, int, int)}
     */
    @Test
    void testSaveQrcode() throws UnsupportedEncodingException {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");

        Iventory iventory = new Iventory();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory.setDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        iventory.setId(123L);
        iventory.setNumber(10.0f);
        iventory.setValidation(true);

        Level level = new Level();
        level.setDescription("The characteristics of someone or something");
        level.setLevel(1);
        level.setLvl_id(1L);

        Productline productline = new Productline();
        productline.setLine_id(1L);
        productline.setNumber(10);
        productline.setQuantity(10.0f);
        productline.setSupplier("Supplier");

        Unit unit = new Unit();
        unit.setName("Name");
        unit.setSymbol("Symbol");
        unit.setUn_id(1L);

        Product product = new Product();
        product.setCategorie(category);
        product.setCurrentQuantity(10.0f);
        product.setDescription("The characteristics of someone or something");
        product.setDesignation("Designation");
        product.setIventory(iventory);
        product.setLevel(level);
        product.setMark("Mark");
        product.setMedia(new HashSet<>());
        product.setMinimumThreshold(10.0f);
        product.setPerishable(true);
        product.setPro_id(1L);
        product.setProductline(productline);
        product.setQrCode(new Byte[]{'A'});
        product.setReference("Reference");
        product.setState(1);
        product.setUnit(unit);
        product.setUnitPrice(1);

        QrCode qrCode = new QrCode();
        qrCode.setCode(1L);
        qrCode.setCode_url("AAAAAAAA".getBytes("UTF-8"));
        qrCode.setProduct(product);
        when(this.qrRepo.save((QrCode) any())).thenReturn(qrCode);

        QRcodeDTO qRcodeDTO = new QRcodeDTO();
        qRcodeDTO.setCode(1L);
        qRcodeDTO.setCode_url(new Byte[]{'A'});
        qRcodeDTO.setProduct(1L);

        ProductQRDTO productQRDTO = new ProductQRDTO();
        productQRDTO.setDescription("The characteristics of someone or something");
        productQRDTO.setUnitPrice(1);
        assertSame(qrCode, this.qrServiceImpl.saveQrcode(qRcodeDTO, productQRDTO, 1, 1));
        verify(this.qrRepo).save((QrCode) any());
    }
}

