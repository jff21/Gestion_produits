package com.product.product_backend.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.product.product_backend.DTOS.InventoryDTO;
import com.product.product_backend.Models.Iventory;
import com.product.product_backend.Repositories.InventoryRepository;

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

@ContextConfiguration(classes = {InventoryServiceImpl.class})
@ExtendWith(SpringExtension.class)
class InventoryServiceImplTest {
    @MockBean
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    /**
     * Method under test: {@link InventoryServiceImpl#create(InventoryDTO)}
     */
    @Test
    void testCreate() {
        Iventory iventory = new Iventory();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        iventory.setId(123L);
        iventory.setNumber(10.0f);
        iventory.setValidation(true);
        when(this.inventoryRepository.save((Iventory) any())).thenReturn(iventory);

        InventoryDTO inventoryDTO = new InventoryDTO();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        inventoryDTO.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        inventoryDTO.setId(123L);
        inventoryDTO.setNumber(10.0f);
        inventoryDTO.setValidation(true);
        assertSame(iventory, this.inventoryServiceImpl.create(inventoryDTO));
        verify(this.inventoryRepository).save((Iventory) any());
    }

    /**
     * Method under test: {@link InventoryServiceImpl#update(InventoryDTO)}
     */
    @Test
    void testUpdate() {
        Iventory iventory = new Iventory();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        iventory.setId(123L);
        iventory.setNumber(10.0f);
        iventory.setValidation(true);
        when(this.inventoryRepository.save((Iventory) any())).thenReturn(iventory);

        InventoryDTO inventoryDTO = new InventoryDTO();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        inventoryDTO.setDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        inventoryDTO.setId(123L);
        inventoryDTO.setNumber(10.0f);
        inventoryDTO.setValidation(true);
        assertSame(iventory, this.inventoryServiceImpl.update(inventoryDTO));
        verify(this.inventoryRepository).save((Iventory) any());
    }

    /**
     * Method under test: {@link InventoryServiceImpl#getinv(Long)}
     */
    @Test
    void testGetinv() {
        Iventory iventory = new Iventory();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        iventory.setDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        iventory.setId(123L);
        iventory.setNumber(10.0f);
        iventory.setValidation(true);
        Optional<Iventory> ofResult = Optional.of(iventory);
        when(this.inventoryRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<Iventory> actualGetinvResult = this.inventoryServiceImpl.getinv(123L);
        assertSame(ofResult, actualGetinvResult);
        assertTrue(actualGetinvResult.isPresent());
        verify(this.inventoryRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link InventoryServiceImpl#Allinv()}
     */
    @Test
    void testAllinv() {
        ArrayList<Iventory> iventoryList = new ArrayList<>();
        when(this.inventoryRepository.findAll()).thenReturn(iventoryList);
        List<Iventory> actualAllinvResult = this.inventoryServiceImpl.Allinv();
        assertSame(iventoryList, actualAllinvResult);
        assertTrue(actualAllinvResult.isEmpty());
        verify(this.inventoryRepository).findAll();
    }

    /**
     * Method under test: {@link InventoryServiceImpl#deleteinv(Long)}
     */
    @Test
    void testDeleteinv() {
        doNothing().when(this.inventoryRepository).deleteById((Long) any());
        this.inventoryServiceImpl.deleteinv(123L);
        verify(this.inventoryRepository).deleteById((Long) any());
    }
}

