package ru.job4j.tinkoff;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution6Test {

    @ParameterizedTest
    @MethodSource("provideTestData")
    public void testSolution(TreeMap<Integer, List<Solution6.Segment>> map, int expected) {
        int result = Solution6.getMaxChain(map);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> provideTestData() {
new Solution6.Segment(2, 6);
new Solution6.Segment(5, 6);
new Solution6.Segment(2, 5);
new Solution6.Segment(2, 2);
new Solution6.Segment(6, 8);
new Solution6.Segment(2, 2);
new Solution6.Segment(0, 2);
        return Stream.of(
                Arguments.of(new TreeMap<>(Map.of(
                        2,  List.of(new Solution6.Segment(2, 6), new Solution6.Segment(2, 5),
                                new Solution6.Segment(2, 2), new Solution6.Segment(2, 2)),
                        5, List.of(new Solution6.Segment(5, 6)),
                        6, List.of(new Solution6.Segment(6, 8)),
                        0, List.of(new Solution6.Segment(0, 2))
                )), 6)
        );
    }
}