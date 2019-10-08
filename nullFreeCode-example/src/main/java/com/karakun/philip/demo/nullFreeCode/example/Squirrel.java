package com.karakun.philip.demo.nullFreeCode.example;

import com.google.common.base.Preconditions;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.Set;

@Value.Immutable
public interface Squirrel {

    @Value.Default
    default Gender getGender() {
        return Gender.UNKNOWN;
    }

    Optional<Squirrel> getMother();

    Optional<Squirrel> getFather();

    Set<Food> preferredFood();

    @Value.Check
    default void checkFatherMale() {
        getFather().ifPresent(squirrel -> Preconditions.checkState(squirrel.getGender() == Gender.MALE, "Father must be male"));
    }

    @Value.Check
    default void checkMotherMale() {
        getMother().ifPresent(squirrel -> Preconditions.checkState(squirrel.getGender() == Gender.FEMALE, "Mother must be female"));
    }
}
