package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTestParams {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 7})
    @DisplayName("getKittens(int) должен возвращать переданное значение")
    public void getKittensWithParamShouldReturnSameValue(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
