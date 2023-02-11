package com.product.product_backend.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.product_backend.DTOS.ProductDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Models.Level;
import com.product.product_backend.Models.Product;
import com.product.product_backend.Models.Productline;
import com.product.product_backend.Models.Unit;
import com.product.product_backend.Repositories.CategorieRepo;
import com.product.product_backend.Repositories.InventoryRepository;
import com.product.product_backend.Repositories.LevelRepo;
import com.product.product_backend.Repositories.ProductLineRepo;
import com.product.product_backend.Repositories.ProductRepo;
import com.product.product_backend.Repositories.UnitRepo;

import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private CategorieRepo categorieRepo;

    @MockBean
    private InventoryRepository inventoryRepository;

    @MockBean
    private LevelRepo levelRepo;

    @MockBean
    private ProductLineRepo productLineRepo;

    @MockBean
    private ProductRepo productRepo;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @MockBean
    private UnitRepo unitRepo;

    /**
     * Method under test: {@link ProductServiceImpl#createProd(ProductDTO, MultipartFile[])}
     */
    @Test
    void testCreateProd() throws UnsupportedEncodingException {
        Unit unit = new Unit();
        unit.setName("Name");
        unit.setSymbol("Symbol");
        unit.setUn_id(1L);
        Optional<Unit> ofResult = Optional.of(unit);
        when(this.unitRepo.findById((Long) any())).thenReturn(ofResult);

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

        Unit unit1 = new Unit();
        unit1.setName("Name");
        unit1.setSymbol("Symbol");
        unit1.setUn_id(1L);

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
        product.setUnit(unit1);
        product.setUnitPrice(1);
        when(this.productRepo.save((Product) any())).thenReturn(product);

        Productline productline1 = new Productline();
        productline1.setLine_id(1L);
        productline1.setNumber(10);
        productline1.setQuantity(10.0f);
        productline1.setSupplier("Supplier");
        Optional<Productline> ofResult1 = Optional.of(productline1);
        when(this.productLineRepo.findById((Long) any())).thenReturn(ofResult1);

        Level level1 = new Level();
        level1.setDescription("The characteristics of someone or something");
        level1.setLevel(1);
        level1.setLvl_id(1L);
        Optional<Level> ofResult2 = Optional.of(level1);
        when(this.levelRepo.findById((Long) any())).thenReturn(ofResult2);

        Iventory iventory1 = new Iventory();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory1.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        iventory1.setId(123L);
        iventory1.setNumber(10.0f);
        iventory1.setValidation(true);
        Optional<Iventory> ofResult3 = Optional.of(iventory1);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult3);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");
        Optional<Category> ofResult4 = Optional.of(category1);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult4);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategorie(1L);
        productDTO.setCurrentQuantity(10.0f);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDesignation("Designation");
        productDTO.setIventory(1L);
        productDTO.setLevel(1L);
        productDTO.setMark("Mark");
        productDTO.setMedia(1L);
        productDTO.setMinimumThreshold(10.0f);
        productDTO.setPerishable(true);
        productDTO.setPro_id(1L);
        productDTO.setProductline(1L);
        productDTO.setQrCode("Qr Code");
        productDTO.setReference("Reference");
        productDTO.setState(1);
        productDTO.setUnit(1L);
        productDTO.setUnitPrice(1);
        assertSame(product, this.productServiceImpl.createProd(productDTO,
                new MultipartFile[]{new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"))}));
        verify(this.unitRepo).findById((Long) any());
        verify(this.productRepo).save((Product) any());
        verify(this.productLineRepo).findById((Long) any());
        verify(this.levelRepo).findById((Long) any());
        verify(this.inventoryRepository).findById((Long) any());
        verify(this.categorieRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#createProd(ProductDTO, MultipartFile[])}
     */
    @Test
    void testCreateProd2() throws UnsupportedEncodingException {
        Unit unit = new Unit();
        unit.setName("Name");
        unit.setSymbol("Symbol");
        unit.setUn_id(1L);
        Optional<Unit> ofResult = Optional.of(unit);
        when(this.unitRepo.findById((Long) any())).thenReturn(ofResult);
        when(this.productRepo.save((Product) any())).thenThrow(new EntityNotFoundException("An error occurred"));

        Productline productline = new Productline();
        productline.setLine_id(1L);
        productline.setNumber(10);
        productline.setQuantity(10.0f);
        productline.setSupplier("Supplier");
        Optional<Productline> ofResult1 = Optional.of(productline);
        when(this.productLineRepo.findById((Long) any())).thenReturn(ofResult1);

        Level level = new Level();
        level.setDescription("The characteristics of someone or something");
        level.setLevel(1);
        level.setLvl_id(1L);
        Optional<Level> ofResult2 = Optional.of(level);
        when(this.levelRepo.findById((Long) any())).thenReturn(ofResult2);

        Iventory iventory = new Iventory();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        iventory.setId(123L);
        iventory.setNumber(10.0f);
        iventory.setValidation(true);
        Optional<Iventory> ofResult3 = Optional.of(iventory);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult3);

        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");
        Optional<Category> ofResult4 = Optional.of(category);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult4);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategorie(1L);
        productDTO.setCurrentQuantity(10.0f);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDesignation("Designation");
        productDTO.setIventory(1L);
        productDTO.setLevel(1L);
        productDTO.setMark("Mark");
        productDTO.setMedia(1L);
        productDTO.setMinimumThreshold(10.0f);
        productDTO.setPerishable(true);
        productDTO.setPro_id(1L);
        productDTO.setProductline(1L);
        productDTO.setQrCode("Qr Code");
        productDTO.setReference("Reference");
        productDTO.setState(1);
        productDTO.setUnit(1L);
        productDTO.setUnitPrice(1);
        assertNull(this.productServiceImpl.createProd(productDTO,
                new MultipartFile[]{new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"))}));
        verify(this.unitRepo).findById((Long) any());
        verify(this.productRepo).save((Product) any());
        verify(this.productLineRepo).findById((Long) any());
        verify(this.levelRepo).findById((Long) any());
        verify(this.inventoryRepository).findById((Long) any());
        verify(this.categorieRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#createProd(ProductDTO, MultipartFile[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateProd3() throws UnsupportedEncodingException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.persistence.EntityNotFoundException
        //       at java.util.Optional.orElseThrow(Optional.java:403)
        //       at com.product.product_backend.Services.Impl.ProductServiceImpl.createProd(ProductServiceImpl.java:44)
        //   In order to prevent createProd(ProductDTO, MultipartFile[])
        //   from throwing EntityNotFoundException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   createProd(ProductDTO, MultipartFile[]).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.unitRepo.findById((Long) any())).thenReturn(Optional.empty());

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
        when(this.productRepo.save((Product) any())).thenReturn(product);

        Productline productline1 = new Productline();
        productline1.setLine_id(1L);
        productline1.setNumber(10);
        productline1.setQuantity(10.0f);
        productline1.setSupplier("Supplier");
        Optional<Productline> ofResult = Optional.of(productline1);
        when(this.productLineRepo.findById((Long) any())).thenReturn(ofResult);

        Level level1 = new Level();
        level1.setDescription("The characteristics of someone or something");
        level1.setLevel(1);
        level1.setLvl_id(1L);
        Optional<Level> ofResult1 = Optional.of(level1);
        when(this.levelRepo.findById((Long) any())).thenReturn(ofResult1);

        Iventory iventory1 = new Iventory();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory1.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        iventory1.setId(123L);
        iventory1.setNumber(10.0f);
        iventory1.setValidation(true);
        Optional<Iventory> ofResult2 = Optional.of(iventory1);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult2);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");
        Optional<Category> ofResult3 = Optional.of(category1);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult3);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategorie(1L);
        productDTO.setCurrentQuantity(10.0f);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDesignation("Designation");
        productDTO.setIventory(1L);
        productDTO.setLevel(1L);
        productDTO.setMark("Mark");
        productDTO.setMedia(1L);
        productDTO.setMinimumThreshold(10.0f);
        productDTO.setPerishable(true);
        productDTO.setPro_id(1L);
        productDTO.setProductline(1L);
        productDTO.setQrCode("Qr Code");
        productDTO.setReference("Reference");
        productDTO.setState(1);
        productDTO.setUnit(1L);
        productDTO.setUnitPrice(1);
        this.productServiceImpl.createProd(productDTO,
                new MultipartFile[]{new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"))});
    }

    /**
     * Method under test: {@link ProductServiceImpl#uploadimg(MultipartFile[])}
     */
    @Test
    void testUploadimg() throws IOException {
        assertEquals(1,
                this.productServiceImpl
                        .uploadimg(new MultipartFile[]{new MockMultipartFile("Name", "AAAAAAAA".getBytes("UTF-8"))})
                        .size());
    }

    /**
     * Method under test: {@link ProductServiceImpl#uploadimg(MultipartFile[])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUploadimg2() throws IOException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.web.multipart.MultipartFile.getOriginalFilename()" because "file" is null
        //       at com.product.product_backend.Services.Impl.ProductServiceImpl.uploadimg(ProductServiceImpl.java:64)
        //   In order to prevent uploadimg(MultipartFile[])
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   uploadimg(MultipartFile[]).
        //   See https://diff.blue/R013 to resolve this issue.

        this.productServiceImpl.uploadimg(new MultipartFile[]{null});
    }

    /**
     * Method under test: {@link ProductServiceImpl#uploadimg(MultipartFile[])}
     */
    @Test
    void testUploadimg3() throws IOException {
        MockMultipartFile mockMultipartFile = mock(MockMultipartFile.class);
        when(mockMultipartFile.getBytes()).thenReturn("AAAAAAAA".getBytes("UTF-8"));
        when(mockMultipartFile.getContentType()).thenReturn("text/plain");
        when(mockMultipartFile.getOriginalFilename()).thenReturn("foo.txt");
        assertEquals(1, this.productServiceImpl.uploadimg(new MultipartFile[]{mockMultipartFile}).size());
        verify(mockMultipartFile).getBytes();
        verify(mockMultipartFile).getContentType();
        verify(mockMultipartFile).getOriginalFilename();
    }

    /**
     * Method under test: {@link ProductServiceImpl#Update(ProductDTO)}
     */
    @Test
    void testUpdate() {
        Unit unit = new Unit();
        unit.setName("Name");
        unit.setSymbol("Symbol");
        unit.setUn_id(1L);
        Optional<Unit> ofResult = Optional.of(unit);
        when(this.unitRepo.findById((Long) any())).thenReturn(ofResult);

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

        Unit unit1 = new Unit();
        unit1.setName("Name");
        unit1.setSymbol("Symbol");
        unit1.setUn_id(1L);

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
        product.setUnit(unit1);
        product.setUnitPrice(1);
        when(this.productRepo.save((Product) any())).thenReturn(product);

        Level level1 = new Level();
        level1.setDescription("The characteristics of someone or something");
        level1.setLevel(1);
        level1.setLvl_id(1L);
        Optional<Level> ofResult1 = Optional.of(level1);
        when(this.levelRepo.findById((Long) any())).thenReturn(ofResult1);

        Iventory iventory1 = new Iventory();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory1.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        iventory1.setId(123L);
        iventory1.setNumber(10.0f);
        iventory1.setValidation(true);
        Optional<Iventory> ofResult2 = Optional.of(iventory1);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult2);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");
        Optional<Category> ofResult3 = Optional.of(category1);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult3);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategorie(1L);
        productDTO.setCurrentQuantity(10.0f);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDesignation("Designation");
        productDTO.setIventory(1L);
        productDTO.setLevel(1L);
        productDTO.setMark("Mark");
        productDTO.setMedia(1L);
        productDTO.setMinimumThreshold(10.0f);
        productDTO.setPerishable(true);
        productDTO.setPro_id(1L);
        productDTO.setProductline(1L);
        productDTO.setQrCode("Qr Code");
        productDTO.setReference("Reference");
        productDTO.setState(1);
        productDTO.setUnit(1L);
        productDTO.setUnitPrice(1);
        Product actualUpdateResult = this.productServiceImpl.Update(productDTO);
        assertEquals(category, actualUpdateResult.getCategorie());
        assertFalse(actualUpdateResult.isPerishable());
        assertEquals(10.0f, actualUpdateResult.getCurrentQuantity());
        assertEquals("Designation", actualUpdateResult.getDesignation());
        assertEquals(1, actualUpdateResult.getUnitPrice());
        assertEquals(10.0f, actualUpdateResult.getMinimumThreshold());
        assertEquals(iventory, actualUpdateResult.getIventory());
        assertEquals(1L, actualUpdateResult.getPro_id());
        assertEquals("The characteristics of someone or something", actualUpdateResult.getDescription());
        assertEquals(level, actualUpdateResult.getLevel());
        assertEquals("Reference", actualUpdateResult.getReference());
        assertEquals("Mark", actualUpdateResult.getMark());
        assertEquals(1, actualUpdateResult.getState());
        assertEquals(unit1, actualUpdateResult.getUnit());
        verify(this.unitRepo).findById((Long) any());
        verify(this.productRepo).save((Product) any());
        verify(this.levelRepo).findById((Long) any());
        verify(this.inventoryRepository).findById((Long) any());
        verify(this.categorieRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#Update(ProductDTO)}
     */
    @Test
    void testUpdate2() {
        Unit unit = new Unit();
        unit.setName("Name");
        unit.setSymbol("Symbol");
        unit.setUn_id(1L);
        Optional<Unit> ofResult = Optional.of(unit);
        when(this.unitRepo.findById((Long) any())).thenReturn(ofResult);
        when(this.productRepo.save((Product) any())).thenThrow(new EntityNotFoundException("An error occurred"));

        Level level = new Level();
        level.setDescription("The characteristics of someone or something");
        level.setLevel(1);
        level.setLvl_id(1L);
        Optional<Level> ofResult1 = Optional.of(level);
        when(this.levelRepo.findById((Long) any())).thenReturn(ofResult1);

        Iventory iventory = new Iventory();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        iventory.setId(123L);
        iventory.setNumber(10.0f);
        iventory.setValidation(true);
        Optional<Iventory> ofResult2 = Optional.of(iventory);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult2);

        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");
        Optional<Category> ofResult3 = Optional.of(category);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult3);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategorie(1L);
        productDTO.setCurrentQuantity(10.0f);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDesignation("Designation");
        productDTO.setIventory(1L);
        productDTO.setLevel(1L);
        productDTO.setMark("Mark");
        productDTO.setMedia(1L);
        productDTO.setMinimumThreshold(10.0f);
        productDTO.setPerishable(true);
        productDTO.setPro_id(1L);
        productDTO.setProductline(1L);
        productDTO.setQrCode("Qr Code");
        productDTO.setReference("Reference");
        productDTO.setState(1);
        productDTO.setUnit(1L);
        productDTO.setUnitPrice(1);
        assertThrows(EntityNotFoundException.class, () -> this.productServiceImpl.Update(productDTO));
        verify(this.unitRepo).findById((Long) any());
        verify(this.productRepo).save((Product) any());
        verify(this.levelRepo).findById((Long) any());
        verify(this.inventoryRepository).findById((Long) any());
        verify(this.categorieRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#Update(ProductDTO)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "java.util.Optional.orElseThrow(java.util.function.Supplier)" because the return value of "com.product.product_backend.Repositories.UnitRepo.findById(Object)" is null
        //       at com.product.product_backend.Services.Impl.ProductServiceImpl.Update(ProductServiceImpl.java:89)
        //   In order to prevent Update(ProductDTO)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   Update(ProductDTO).
        //   See https://diff.blue/R013 to resolve this issue.

        when(this.unitRepo.findById((Long) any())).thenReturn(null);

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
        when(this.productRepo.save((Product) any())).thenReturn(product);

        Level level1 = new Level();
        level1.setDescription("The characteristics of someone or something");
        level1.setLevel(1);
        level1.setLvl_id(1L);
        Optional<Level> ofResult = Optional.of(level1);
        when(this.levelRepo.findById((Long) any())).thenReturn(ofResult);

        Iventory iventory1 = new Iventory();
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory1.setDate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        iventory1.setId(123L);
        iventory1.setNumber(10.0f);
        iventory1.setValidation(true);
        Optional<Iventory> ofResult1 = Optional.of(iventory1);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult1);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");
        Optional<Category> ofResult2 = Optional.of(category1);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult2);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setCategorie(1L);
        productDTO.setCurrentQuantity(10.0f);
        productDTO.setDescription("The characteristics of someone or something");
        productDTO.setDesignation("Designation");
        productDTO.setIventory(1L);
        productDTO.setLevel(1L);
        productDTO.setMark("Mark");
        productDTO.setMedia(1L);
        productDTO.setMinimumThreshold(10.0f);
        productDTO.setPerishable(true);
        productDTO.setPro_id(1L);
        productDTO.setProductline(1L);
        productDTO.setQrCode("Qr Code");
        productDTO.setReference("Reference");
        productDTO.setState(1);
        productDTO.setUnit(1L);
        productDTO.setUnitPrice(1);
        this.productServiceImpl.Update(productDTO);
    }

    /**
     * Method under test: {@link ProductServiceImpl#getProd(Long)}
     */
    @Test
    void testGetProd() {
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
        Optional<Product> ofResult = Optional.of(product);
        when(this.productRepo.findById((Long) any())).thenReturn(ofResult);
        Optional<Product> actualProd = this.productServiceImpl.getProd(1L);
        assertSame(ofResult, actualProd);
        assertTrue(actualProd.isPresent());
        verify(this.productRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#Allproduct()}
     */
    @Test
    void testAllproduct() {
        ArrayList<Product> productList = new ArrayList<>();
        when(this.productRepo.findAll()).thenReturn(productList);
        List<Product> actualAllproductResult = this.productServiceImpl.Allproduct();
        assertSame(productList, actualAllproductResult);
        assertTrue(actualAllproductResult.isEmpty());
        verify(this.productRepo).findAll();
    }

    /**
     * Method under test: {@link ProductServiceImpl#Allproduct()}
     */
    @Test
    void testAllproduct2() {
        when(this.productRepo.findAll()).thenThrow(new EntityNotFoundException("An error occurred"));
        assertThrows(EntityNotFoundException.class, () -> this.productServiceImpl.Allproduct());
        verify(this.productRepo).findAll();
    }

    /**
     * Method under test: {@link ProductServiceImpl#deleteprod(Long)}
     */
    @Test
    void testDeleteprod() {
        doNothing().when(this.productRepo).deleteById((Long) any());
        this.productServiceImpl.deleteprod(1L);
        verify(this.productRepo).deleteById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#deleteprod(Long)}
     */
    @Test
    void testDeleteprod2() {
        doThrow(new EntityNotFoundException("An error occurred")).when(this.productRepo).deleteById((Long) any());
        assertThrows(EntityNotFoundException.class, () -> this.productServiceImpl.deleteprod(1L));
        verify(this.productRepo).deleteById((Long) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#countProBycat()}
     */
    @Test
    void testCountProBycat() {
        when(this.productRepo.count()).thenReturn(3L);
        assertEquals(3L, this.productServiceImpl.countProBycat().longValue());
        verify(this.productRepo).count();
    }

    /**
     * Method under test: {@link ProductServiceImpl#countProBycat()}
     */
    @Test
    void testCountProBycat2() {
        when(this.productRepo.count()).thenThrow(new EntityNotFoundException("An error occurred"));
        assertThrows(EntityNotFoundException.class, () -> this.productServiceImpl.countProBycat());
        verify(this.productRepo).count();
    }

    /**
     * Method under test: {@link ProductServiceImpl#Search(String, String, String)}
     */
    @Test
    void testSearch() {
        ArrayList<Product> productList = new ArrayList<>();
        when(this.productRepo.Search((String) any(), (String) any(), (String) any())).thenReturn(productList);
        List<Product> actualSearchResult = this.productServiceImpl.Search("Mark", "Designation", "Reference");
        assertSame(productList, actualSearchResult);
        assertTrue(actualSearchResult.isEmpty());
        verify(this.productRepo).Search((String) any(), (String) any(), (String) any());
    }

    /**
     * Method under test: {@link ProductServiceImpl#Search(String, String, String)}
     */
    @Test
    void testSearch2() {
        when(this.productRepo.Search((String) any(), (String) any(), (String) any()))
                .thenThrow(new EntityNotFoundException("An error occurred"));
        assertThrows(EntityNotFoundException.class,
                () -> this.productServiceImpl.Search("Mark", "Designation", "Reference"));
        verify(this.productRepo).Search((String) any(), (String) any(), (String) any());
    }
}

