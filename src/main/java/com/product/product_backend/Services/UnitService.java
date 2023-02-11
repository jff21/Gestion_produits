package com.product.product_backend.Services;

import com.product.product_backend.DTOS.UnitDTO;
import com.product.product_backend.Models.Unit;

public interface UnitService {

    Unit createunit(UnitDTO unitDTO);
}
