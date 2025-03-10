package com.example.faveFood.faveFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/faveFood")
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getFaveFood() {
        return foodService.getFaveFood();
    }

    @GetMapping(path = "{name}")
    public Optional<Food> getFaveFoodByName(@PathVariable String name) {
        return foodService.getFaveFoodByName(name);
    }

    @PostMapping
    public void registerFood(@RequestBody Food food) {
        foodService.addNewFood(food);
    }

    @DeleteMapping(path = "{foodId}")
    public void deleteFood(@PathVariable("foodId") Long foodId) {
        foodService.deleteFood(foodId);
    }

    @PutMapping(path = "{foodId}")
    public void updateFood(@PathVariable("foodId") Long foodId,
                           @RequestParam(required = false) String name) {
        foodService.updateFood(foodId, name);
    }
}
