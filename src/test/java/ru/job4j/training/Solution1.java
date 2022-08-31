package ru.job4j.training;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1Spec {
    private Solution1.Solution sut = new Solution1().new Solution();

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSolution(int[] office1, int[] office2, int expected) {
        int result = sut.getBiggestSquare(office1, office2);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> provideTestData() {

        return Stream.of(
                Arguments.of(new int[]{6, 6, 8, 8}, new int[]{1, 8, 4, 9}, 49)
        );
    }
}
