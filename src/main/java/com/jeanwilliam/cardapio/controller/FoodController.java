package com.jeanwilliam.cardapio.controller;

import com.jeanwilliam.cardapio.dto.FoodRequestDTO;
import com.jeanwilliam.cardapio.dto.FoodResponseDTO;
import com.jeanwilliam.cardapio.entity.Food;
import com.jeanwilliam.cardapio.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
@RequiredArgsConstructor
public class FoodController {
    private final FoodRepository foodRepository;

    @CrossOrigin(origins = "https://cardapio-git-main-jeanwiiliams-projects.vercel.app/", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<String> create(@RequestBody FoodRequestDTO foodDTO){
        Food food = new Food(foodDTO);
        foodRepository.save(food);
        return ResponseEntity.ok("Food created successfully");
    }

    @CrossOrigin(origins = "https://cardapio-git-main-jeanwiiliams-projects.vercel.app/", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        return foodRepository.findAll()
                .stream()
                .map(food -> new FoodResponseDTO(food))
                .toList();
    }
}
