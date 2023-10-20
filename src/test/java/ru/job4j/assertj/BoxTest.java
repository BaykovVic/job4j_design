package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isEqualToIgnoringCase("cube");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 1);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isEqualToIgnoringCase("tetrahedron");
    }

    @Test
    void whenGetCubeVerticesNumberThan8() {
        Box box = new Box(8, 1);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(8);
    }

    @Test
    void whenGetTetrahedronVerticesNumberThan4() {
        Box box = new Box(4, 1);
        int result = box.getNumberOfVertices();
        assertThat(result).isEqualTo(4);
    }

    @Test
    void whenSphereExistsThanTrue() {
        Box box = new Box(0, 1);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void whenBoxUNKNOWNThanFalse() {
        Box box = new Box(5, 1);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenTetrahedronAndEdge1ThenArea1Point73() {
        Box box = new Box(4, 1);
        double result = box.getArea();
        assertThat(result).isEqualTo(1.73d, withPrecision(0.003))
                .isCloseTo(1.73, withPrecision(0.01d))
                .isCloseTo(1.73d, Percentage.withPercentage(1.0d));
    }

    @Test
    void whenSphereAndEdge1ThenArea12Point57() {
        Box box = new Box(0, 1);
        double result = box.getArea();
        assertThat(result).isEqualTo(12.57d, withPrecision(0.004))
                .isCloseTo(12.57, withPrecision(0.01d))
                .isCloseTo(12.57d, Percentage.withPercentage(1.0d))
                .isGreaterThan(12.56d)
                .isLessThan(12.58d);
    }
}