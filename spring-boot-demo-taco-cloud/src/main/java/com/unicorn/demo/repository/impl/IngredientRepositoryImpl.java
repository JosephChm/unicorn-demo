package com.unicorn.demo.repository.impl;

import com.unicorn.demo.domain.entity.Ingredient;
import com.unicorn.demo.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public IngredientRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id,name,type from ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findById(String id) {
        return jdbcTemplate.queryForObject("select id,name,type from ingredient where id=?", this::mapRowToIngredient,id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update("insert into ingredient(id,name,type) values (?,?,?)", ingredient.getId(), ingredient.getName(), ingredient.getType().toString());
        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int RowNum) throws SQLException {
        return new Ingredient(resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }

}
