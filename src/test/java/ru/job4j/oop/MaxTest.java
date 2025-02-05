package ru.job4j.oop;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax3To1Then3() {
        int left = 3;
        int right = 1;
        int result = Max.max(left, right);
        int expected = 3;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax5To5Then5() {
        int left = 5;
        int right = 5;
        int result = Max.max(left, right);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax5To2To3Then5() {
        int first = 5;
        int second = 2;
        int third = 3;
        int result = Max.max(first, second, third);
        int expected = 5;
        Assert.assertEquals(result, expected);
    }

    @Test
    public void whenMax1To7To4To8Then8() {
        int first = 1;
        int second = 7;
        int third = 4;
        int fourth = 8;
        int result = Max.max(first, second, third, fourth);
        int expected = 8;
        Assert.assertEquals(result, expected);
    }
}