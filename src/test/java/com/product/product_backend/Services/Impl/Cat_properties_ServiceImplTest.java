package com.product.product_backend.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.product_backend.Assembler.CategoryDtoAssembler;
import com.product.product_backend.DTOS.CatPropertiesDTO;
import com.product.product_backend.Models.Cat_properties;
import com.product.product_backend.Models.Category;
import com.product.product_backend.Repositories.CatPropertieRepo;
import com.product.product_backend.Repositories.CategorieRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {Cat_properties_ServiceImpl.class})
@ExtendWith(SpringExtension.class)
class Cat_properties_ServiceImplTest {
    @MockBean
    private CatPropertieRepo catPropertieRepo;

    @Autowired
    private Cat_properties_ServiceImpl cat_properties_ServiceImpl;

    @MockBean
    private CategorieRepo categorieRepo;

    @MockBean
    private CategoryDtoAssembler categoryDtoAssembler;

    /**
     * Method under test: {@link Cat_properties_ServiceImpl#createProp(CatPropertiesDTO)}
     */
    @Test
    void testCreateProp() {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");
        when(this.categorieRepo.findByCid((String) any())).thenReturn(category);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");

        Cat_properties cat_properties = new Cat_properties();
        cat_properties.setCategory(category1);
        cat_properties.setColor("Color");
        cat_properties.setKey("Key");
        cat_properties.setMark("Mark");
        cat_properties.setName("Name");
        cat_properties.setProp_id(1);
        cat_properties.setRange("Range");
        when(this.catPropertieRepo.save((Cat_properties) any())).thenReturn(cat_properties);

        Category category2 = new Category();
        category2.setCat_id(1L);
        category2.setCat_properties(new ArrayList<>());
        category2.setCid("Cid");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category2.setCreateDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category2.setLastUpdate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        category2.setName("Name");

        CatPropertiesDTO catPropertiesDTO = new CatPropertiesDTO();
        catPropertiesDTO.setCategory(category2);
        catPropertiesDTO.setColor("Color");
        catPropertiesDTO.setKey("Key");
        catPropertiesDTO.setMark("Mark");
        catPropertiesDTO.setName("Name");
        catPropertiesDTO.setRange("Range");
        Cat_properties actualCreatePropResult = this.cat_properties_ServiceImpl.createProp(catPropertiesDTO);
        assertEquals(category2, actualCreatePropResult.getCategory());
        assertEquals("Range", actualCreatePropResult.getRange());
        assertEquals("Color", actualCreatePropResult.getColor());
        assertEquals("Mark", actualCreatePropResult.getMark());
        assertEquals("Name", actualCreatePropResult.getName());
        assertEquals("Key", actualCreatePropResult.getKey());
        verify(this.categorieRepo).findByCid((String) any());
        verify(this.catPropertieRepo).save((Cat_properties) any());
    }

    /**
     * Method under test: {@link Cat_properties_ServiceImpl#findAllPropertiesByCatId(String)}
     */
    @Test
    void testFindAllPropertiesByCatId() {
        when(this.catPropertieRepo.findByCategoryCid((String) any())).thenReturn(new ArrayList<>());
        assertTrue(this.cat_properties_ServiceImpl.findAllPropertiesByCatId("Cid").isEmpty());
        verify(this.catPropertieRepo).findByCategoryCid((String) any());
    }

    /**
     * Method under test: {@link Cat_properties_ServiceImpl#findAllPropertiesByCatId(String)}
     */
    @Test
    void testFindAllPropertiesByCatId2() {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");

        CatPropertiesDTO catPropertiesDTO = new CatPropertiesDTO();
        catPropertiesDTO.setCategory(category);
        catPropertiesDTO.setColor("Color");
        catPropertiesDTO.setKey("Key");
        catPropertiesDTO.setMark("Mark");
        catPropertiesDTO.setName("Name");
        catPropertiesDTO.setRange("Range");
        when(this.categoryDtoAssembler.buildPropertyDto((Cat_properties) any())).thenReturn(catPropertiesDTO);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");

        Cat_properties cat_properties = new Cat_properties();
        cat_properties.setCategory(category1);
        cat_properties.setColor("Color");
        cat_properties.setKey("Key");
        cat_properties.setMark("Mark");
        cat_properties.setName("Name");
        cat_properties.setProp_id(1);
        cat_properties.setRange("Range");

        ArrayList<Cat_properties> cat_propertiesList = new ArrayList<>();
        cat_propertiesList.add(cat_properties);
        when(this.catPropertieRepo.findByCategoryCid((String) any())).thenReturn(cat_propertiesList);
        assertEquals(1, this.cat_properties_ServiceImpl.findAllPropertiesByCatId("Cid").size());
        verify(this.categoryDtoAssembler).buildPropertyDto((Cat_properties) any());
        verify(this.catPropertieRepo).findByCategoryCid((String) any());
    }

    /**
     * Method under test: {@link Cat_properties_ServiceImpl#findAllPropertiesByCatId(String)}
     */
    @Test
    void testFindAllPropertiesByCatId3() {
        Category category = new Category();
        category.setCat_id(1L);
        category.setCat_properties(new ArrayList<>());
        category.setCid("Cid");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setCreateDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category.setLastUpdate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        category.setName("Name");

        CatPropertiesDTO catPropertiesDTO = new CatPropertiesDTO();
        catPropertiesDTO.setCategory(category);
        catPropertiesDTO.setColor("Color");
        catPropertiesDTO.setKey("Key");
        catPropertiesDTO.setMark("Mark");
        catPropertiesDTO.setName("Name");
        catPropertiesDTO.setRange("Range");
        when(this.categoryDtoAssembler.buildPropertyDto((Cat_properties) any())).thenReturn(catPropertiesDTO);

        Category category1 = new Category();
        category1.setCat_id(1L);
        category1.setCat_properties(new ArrayList<>());
        category1.setCid("Cid");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setCreateDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category1.setLastUpdate(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        category1.setName("Name");

        Cat_properties cat_properties = new Cat_properties();
        cat_properties.setCategory(category1);
        cat_properties.setColor("Color");
        cat_properties.setKey("Key");
        cat_properties.setMark("Mark");
        cat_properties.setName("Name");
        cat_properties.setProp_id(1);
        cat_properties.setRange("Range");

        Category category2 = new Category();
        category2.setCat_id(1L);
        category2.setCat_properties(new ArrayList<>());
        category2.setCid("Cid");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category2.setCreateDate(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        category2.setLastUpdate(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        category2.setName("Name");

        Cat_properties cat_properties1 = new Cat_properties();
        cat_properties1.setCategory(category2);
        cat_properties1.setColor("Color");
        cat_properties1.setKey("Key");
        cat_properties1.setMark("Mark");
        cat_properties1.setName("Name");
        cat_properties1.setProp_id(1);
        cat_properties1.setRange("Range");

        ArrayList<Cat_properties> cat_propertiesList = new ArrayList<>();
        cat_propertiesList.add(cat_properties1);
        cat_propertiesList.add(cat_properties);
        when(this.catPropertieRepo.findByCategoryCid((String) any())).thenReturn(cat_propertiesList);
        assertEquals(2, this.cat_properties_ServiceImpl.findAllPropertiesByCatId("Cid").size());
        verify(this.categoryDtoAssembler, atLeast(1)).buildPropertyDto((Cat_properties) any());
        verify(this.catPropertieRepo).findByCategoryCid((String) any());
    }
}

