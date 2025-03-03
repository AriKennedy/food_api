package com.example.faveFood.faveFood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface FoodRepositry extends JpaRepository<Food, Long> {

    @Query("SELECT F FROM Food F WHERE F.name = ?1")
    Optional<Food> findByName(String name);
}
