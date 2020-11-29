package com.unicorn.demo.repository.impl;

import com.unicorn.demo.domain.entity.Ingredient;
import com.unicorn.demo.domain.entity.Taco;
import com.unicorn.demo.repository.TacoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

@Repository
public class TacoRepositoryImpl implements TacoRepository {

    private JdbcTemplate jdbc;

    public TacoRepositoryImpl(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);
        }

        return taco;
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(LocalDate.now());

        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
                "insert into Taco (name, created_at) values (?, ?)",
                Types.VARCHAR, Types.TIMESTAMP
        );

        // specific method
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        LocalDateTime.now(Clock.systemUTC()))
        );

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(psc, keyHolder);

        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    private void saveIngredientToTaco(
            Ingredient ingredient, long tacoId) {
        jdbc.update(
                "insert into taco_ingredients (taco, ingredient) " +
                        "values (?, ?)",
                tacoId, ingredient.getId());
    }

}
