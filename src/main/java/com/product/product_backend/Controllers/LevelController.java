package com.product.product_backend.Controllers;

import com.product.product_backend.DTOS.LevelDTO;
import com.product.product_backend.Models.Level;
import com.product.product_backend.Services.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("level")
@AllArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @PostMapping("/add")
    public ResponseEntity<Level> addLevel(@RequestBody LevelDTO levelDTO){
        return new ResponseEntity<>(levelService.createLevel(levelDTO), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Level> update(LevelDTO levelDTO){
        return new ResponseEntity<>(levelService.updateLevel(levelDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getLvl")
    public Optional<Level> getLevel(@PathVariable(name = "lvl_id") Long lvl_id){
        return levelService.getLevel(lvl_id);
    }

    @GetMapping("/AllLevel")
    public List<Level> AllLevel(){
        return levelService.AllLevels();
    }

    @DeleteMapping("/del/{id}")
    public void deleteLevel(@PathVariable  Long lvl_id){
        levelService.deleteLevel(lvl_id);
    }
}
