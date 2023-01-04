package com.product.product_backend.Controllers;

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
    public ResponseEntity<Level> addLevel(){
        return new ResponseEntity<>(levelService.createLevel(), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Level> update(){
        return new ResponseEntity<>(levelService.updateLevel(), HttpStatus.CREATED);
    }

    @GetMapping("/getLvl")
    public Optional<Level> getLevel(@PathVariable(name = "lvl_id") Long lvl_id){
        return levelService.getLevel(lvl_id);
    }

    @GetMapping("/AllLevel")
    public List<Level> AllLevel(){
        return levelService.AllLevels();
    }

    @DeleteMapping("")
    public void deleteLevel(Long lvl_id){
        levelService.deleteLevel(lvl_id);
    }
}
