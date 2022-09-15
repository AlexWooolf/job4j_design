package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .doesNotContainOnlyWhitespaces();
    }

    @Test
    void getNumbersOfVerticalsIsMinus1() {
        Box box = new Box(0, 0);
        int n = box.getNumberOfVertices();
        assertThat(n).isEqualTo(-1)
                .isNegative();
    }

    @Test
    void getNumbersOfVerticalsIs4() {
        Box box = new Box(4, 4);
        int n = box.getNumberOfVertices();
        assertThat(n).isEqualTo(4)
                .isGreaterThan(1);
    }

    @Test
    void isThisSphereExists() {
        Box box = new Box(0, 10);
        boolean n = box.isExist();
        assertThat(n).isTrue()
                .isNotNull();
    }

    @Test
    void isThisBoxExists() {
        Box box = new Box(8, 6);
        boolean n = box.isExist();
        assertThat(n).isTrue()
                .isNotNull();
    }

    @Test
    void isThisBoxHaveArea() {
        Box box = new Box(8, 6);
        double n = box.getArea();
        assertThat(n).isPositive()
                .isNotNull();
    }

    @Test
    void isAnotherBoxDoNotHaveArea() {
        Box box = new Box(0, 0);
        double n = box.getArea();
        assertThat(n).isLessThan(1)
                .isZero();
    }
}