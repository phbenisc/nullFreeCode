package com.karakun.philip.demo.nullFreeCode.example;

import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SquirrelTests {

    @Test
    void createSimpleSquirrel() {
        Squirrel squirrel = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .build();

        assertNotNull(squirrel);
    }

    @Test
    void createFoodCentricSquirrel() {
        Squirrel iLoveNuts = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .addPreferredFood(Food.NUTS)
                .build();

        assertEquals(Food.NUTS, iLoveNuts.preferredFood().iterator().next());

        Squirrel iEatItAll = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .addAllPreferredFood(EnumSet.allOf(Food.class))
                .build();

        assertEquals(3, iEatItAll.preferredFood().size());

        ImmutableSquirrel iEatApples = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .addPreferredFood(Food.APPLES)
                .build();

        assertNotNull(iEatApples);

        ImmutableSquirrel iEatKebab = iEatApples.withPreferredFood(Food.KEBAB);
        assertNotNull(iEatKebab);

        Squirrel squirrel = iEatKebab;
        ImmutableSquirrel kebabAndApples = ImmutableSquirrel.builder()
                .from(squirrel)
                .addPreferredFood(Food.APPLES)
                .build();
    }

    @Test
    void createFamilySquirrel() {

        ImmutableSquirrel father = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .build();

        ImmutableSquirrel squirrel = ImmutableSquirrel.builder()
                .gender(Gender.MALE)
                .father(father)
                .mother(ImmutableSquirrel.builder()
                        .gender(Gender.FEMALE)
                        .build()
                )
                .build();

        squirrel = squirrel.withFather(father.withPreferredFood(Food.KEBAB));

        assertNotNull(squirrel);
    }


}
