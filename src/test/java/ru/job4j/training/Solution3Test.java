/*
package ru.job4j.tinkoff;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution3Spec {
    private Solution3.Solution sut = new Solution3().new Solution();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSolution(int[] office1, int expected) {
        int result = sut.getBestSum(office1);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> provideTestData() {

        return Stream.of(
                Arguments.of(new int[]{1, 2}, 1),
                Arguments.of(new int[]{2, 2, 2}, 2),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3)
        );
    }
}*/
