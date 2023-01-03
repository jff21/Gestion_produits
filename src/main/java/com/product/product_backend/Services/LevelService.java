package com.product.product_backend.Services;

import com.product.product_backend.DTOS.LevelDTO;
import com.product.product_backend.Entities.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    Level createLevel();
    Level updateLevel();
    Optional<Level> getLevel(Long lvl_id);
    List<Level> AllLevels();
    void deleteLevel(Long lvl_id);
}
