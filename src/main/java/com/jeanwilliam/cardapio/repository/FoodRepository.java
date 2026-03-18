package com.jeanwilliam.cardapio.repository;

import com.jeanwilliam.cardapio.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
