package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTests {

    @Mock
    Feline feline;

    @Test
    @DisplayName("Самец льва должен иметь гриву")
    public void maleLionShouldHaveMane() throws Exception {

        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    @DisplayName("Самка льва не должна иметь гриву")
    public void femaleLionShouldNotHaveMane() throws Exception {

        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    @DisplayName("Неверный пол льва должен вызывать исключение")
    public void invalidSexShouldThrowException() {

        Exception ex = assertThrows(Exception.class, () -> new Lion("Другой", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", ex.getMessage());
    }

    @Test
    @DisplayName("getKittens() возвращает корректное количество котят")
    public void getKittensReturnsCorrectNumber() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самка", feline);
        int kittensCount = lion.getKittens();

        assertEquals(5, kittensCount, "Количество котят должно совпадать с возвращаемым Feline");
    }

    @Test
    @DisplayName("getFood() возвращает список хищной еды")
    public void getFoodReturnsPredatorFoodList() throws Exception {
        List<String> predatorFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(predatorFood);

        Lion lion = new Lion("Самка", feline);
        List<String> foodList = lion.getFood();

        assertEquals(predatorFood, foodList, "Список еды должен соответствовать ожидаемому");
    }
}
