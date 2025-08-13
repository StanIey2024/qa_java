package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    @Mock
    Feline feline;

    @Test
    @DisplayName("getSound() должен возвращать 'Мяу'")
    public void getSoundShouldReturnMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    @DisplayName("getFood() должен вызывать feline.eatMeat() и возвращать результат")
    public void getFoodShouldCallPredatorEatMeat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные"));
        Cat cat = new Cat(feline);
        assertEquals(List.of("Животные"), cat.getFood());
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
