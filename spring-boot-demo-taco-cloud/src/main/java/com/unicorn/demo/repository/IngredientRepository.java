package com.unicorn.demo.repository;

import com.unicorn.demo.domain.entity.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

}
