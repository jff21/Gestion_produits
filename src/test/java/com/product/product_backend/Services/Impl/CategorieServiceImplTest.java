package com.product.product_backend.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.product_backend.DTOS.CategorieDTO;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Repositories.CatPropertieRepo;
import com.product.product_backend.Repositories.CategorieRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategorieServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategorieServiceImplTest {
    @MockBean
    private CatPropertieRepo catPropertieRepo;

    @MockBean
    private CategorieRepo categorieRepo;

    @Autowired
    private CategorieServiceImpl categorieServiceImpl;

    /**
     * Method under test: {@link CategorieServiceImpl#createCat(CategorieDTO)}
     */
    @Test
    void testCreateCat() {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");
        when(this.categorieRepo.save((Category) any())).thenReturn(category);

        CategorieDTO categorieDTO = new CategorieDTO();
        categorieDTO.setCat_id(1L);
        categorieDTO.setCid("Cid");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        categorieDTO.setCreateDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        categorieDTO.setKey("Key");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        categorieDTO.setLastUpdate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        categorieDTO.setName("Name");
        assertSame(category, this.categorieServiceImpl.createCat(categorieDTO));
        verify(this.categorieRepo, atLeast(1)).save((Category) any());
    }

    /**
     * Method under test: {@link CategorieServiceImpl#Update(CategorieDTO)}
     */
    @Test
    void testUpdate() {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");
        when(this.categorieRepo.save((Category) any())).thenReturn(category);

        CategorieDTO categorieDTO = new CategorieDTO();
        categorieDTO.setCat_id(1L);
        categorieDTO.setCid("Cid");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        categorieDTO.setCreateDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        categorieDTO.setKey("Key");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        categorieDTO.setLastUpdate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        categorieDTO.setName("Name");
        Category actualUpdateResult = this.categorieServiceImpl.Update(categorieDTO);
        assertEquals(1L, actualUpdateResult.getCat_id().longValue());
        assertEquals("Name", actualUpdateResult.getName());
        assertEquals("Cid", actualUpdateResult.getCid());
        verify(this.categorieRepo).save((Category) any());
    }

    /**
     * Method under test: {@link CategorieServiceImpl#getCat(Long)}
     */
    @Test
    void testGetCat() {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");
        Optional<Category> ofResult = Optional.of(category);
        when(this.categorieRepo.findById((Long) any())).thenReturn(ofResult);
        Optional<Category> actualCat = this.categorieServiceImpl.getCat(123L);
        assertSame(ofResult, actualCat);
        assertTrue(actualCat.isPresent());
        verify(this.categorieRepo).findById((Long) any());
    }

    /**
     * Method under test: {@link CategorieServiceImpl#AllCat()}
     */
    @Test
    void testAllCat() {
        ArrayList<Category> categoryList = new ArrayList<>();
        when(this.categorieRepo.findAll()).thenReturn(categoryList);
        List<Category> actualAllCatResult = this.categorieServiceImpl.AllCat();
        assertSame(categoryList, actualAllCatResult);
        assertTrue(actualAllCatResult.isEmpty());
        verify(this.categorieRepo).findAll();
    }

    /**
     * Method under test: {@link CategorieServiceImpl#delete(Long)}
     */
    @Test
    void testDelete() {
        doNothing().when(this.categorieRepo).deleteById((Long) any());
        this.categorieServiceImpl.delete(1L);
        verify(this.categorieRepo).deleteById((Long) any());
    }
}

