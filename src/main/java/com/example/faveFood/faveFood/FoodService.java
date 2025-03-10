package com.example.faveFood.faveFood;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    private final FoodRepositry foodRepositry;

    @Autowired
    public FoodService(FoodRepositry foodRepositry) {
        this.foodRepositry = foodRepositry;
    }


    public List<Food> getFaveFood() {
        return foodRepositry.findAll();
    }

    public Optional<Food> getFaveFoodByName(String name) {
        Optional<Food> findFaveFood = foodRepositry.findByName(name);
        if (findFaveFood.isEmpty()) {
            throw new IllegalArgumentException("Name not found");
        }
        return foodRepositry.findByName(findFaveFood.get().getName());
    }

    public void addNewFood(Food food) {
        Optional<Food> foodByName = foodRepositry.findByName(food.getName());
        if (foodByName.isPresent()) {
            throw new IllegalStateException("Food already exists");
        }
        foodRepositry.save(food);
    }

    public void deleteFood(Long foodId) {
        boolean exist = foodRepositry.existsById(foodId);

        if (!exist) {
            throw new IllegalStateException("Food with id: " + foodId + " does not exist");
        }
        foodRepositry.deleteById(foodId);
    }

    @Transactional
    public void updateFood(Long foodId, String foodName) {
        Food food = foodRepositry.findById(foodId).orElseThrow(
                () -> new IllegalStateException("Food with id: " + foodId + " does not exist"));

        if (foodName != null && !foodName.isEmpty()) {
            food.setName(foodName);
        }

        foodRepositry.save(food);
    }
}
