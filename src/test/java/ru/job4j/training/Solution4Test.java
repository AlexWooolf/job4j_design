
package ru.job4j.training;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution4Test {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSolution(Map<String, Integer> map, int index, String prefix, int expected) {
        int result = Solution4.getIndex(map, index, prefix);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> provideTestData() {
        Map<String, Integer> map = Map.of("ad", 1,
                "a", 2,
                "abc", 3,
                "aboba", 4,
                "b", 5);
        return Stream.of(
                Arguments.of(map, 3, "a", 4),
                Arguments.of(map, 2, "ab", 4),
                Arguments.of(map, 10, "ab", -1),
                Arguments.of(map, 2, "x", -1),
                Arguments.of(map, 1, "b", 5)
        );
    }
}
