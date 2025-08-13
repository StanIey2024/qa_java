package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

public class LionTestParams {

    @Mock
    Feline feline;

    @ParameterizedTest
    @DisplayName("Проверка, что наличие гривы зависит от пола льва")
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void TestDoesHaveMane(String sex, boolean expected) throws Exception {
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }

}
