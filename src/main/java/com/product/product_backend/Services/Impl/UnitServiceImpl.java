package com.product.product_backend.Services.Impl;

import com.product.product_backend.DTOS.UnitDTO;
import com.product.product_backend.Models.Unit;
import com.product.product_backend.Repositories.UnitRepo;
import com.product.product_backend.Services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepo unitRepo;

    @Override
    public Unit createunit(UnitDTO unitDTO) {
        Unit un = new Unit();
        un.setName(unitDTO.getName());
        un.setSymbol(unitDTO.getSymbol());
        return unitRepo.save(un);
    }
}
