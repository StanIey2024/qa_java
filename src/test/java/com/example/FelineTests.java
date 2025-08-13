package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTests {

    @Test
    @DisplayName("eatMeat() должен возвращать список хищной еды")
    public void eatMeatShouldReturnPredatorFood() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    @DisplayName("getFamily() должен возвращать 'Кошачьи'")
    public void getFamilyShouldReturnCatsFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    @DisplayName("getKittens() без параметров должен возвращать 1")
    public void getKittensDefaultShouldReturnOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

}
