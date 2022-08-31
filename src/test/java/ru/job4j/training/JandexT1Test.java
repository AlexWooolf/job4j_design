package ru.job4j.training;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JandexT1Test {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSolution(byte code, byte interactor, byte checker, byte expected) {
        byte result = JandexT1.getResult(code, interactor, checker);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> provideTestData() {

        return Stream.of(
                Arguments.of((byte)0,(byte)0,(byte)0,(byte)0),
                Arguments.of((byte)-1, (byte)0, (byte)1, (byte)3),
                Arguments.of((byte)42, (byte)1, (byte)6, (byte)6)
        );
    }
}