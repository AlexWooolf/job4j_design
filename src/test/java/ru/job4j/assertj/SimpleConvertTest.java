package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        var list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        var set = simpleConvert.toSet("first", "first", "three", "four", "five");
        assertThat(set).hasSize(4)
                .contains("three")
                .doesNotContain("zero", "second");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        var map = simpleConvert.toMap("first", "second", "first", "four");
        assertThat(map).hasSize(3)
                .containsKey("first")
                .containsValue(0);
    }
}