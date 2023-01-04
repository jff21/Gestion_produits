package com.product.product_backend.Services.Impl;

import com.product.product_backend.Models.Level;
import com.product.product_backend.Repositories.LevelRepo;
import com.product.product_backend.Services.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepo levelRepo;

    @Override
    public Level createLevel() {
        Level level = new Level();
        level.setDescription(level.getDescription());
        level.setLevel(level.getLevel());
        levelRepo.save(level);
        return level;
    }

    @Override
    public Level updateLevel() {
        Level level = new Level();
        level.setLvl_id(level.getLvl_id());
        level.setDescription(level.getDescription());
        level.setLevel(level.getLevel());
        levelRepo.save(level);
        return level;
    }

    @Override
    public Optional<Level> getLevel(Long lvl_id) {
        return levelRepo.findById(lvl_id);
    }

    @Override
    public List<Level> AllLevels() {
        return levelRepo.findAll();
    }

    @Override
    public void deleteLevel(Long lvl_id) {
       levelRepo.deleteById(lvl_id);
    }
}
