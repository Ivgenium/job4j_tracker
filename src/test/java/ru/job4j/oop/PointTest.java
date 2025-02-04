package ru.job4j.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void when00to20then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when55to55then0() {
        Point a = new Point(5, 5);
        Point b = new Point(5, 5);
        double expected = 0;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when11to12then1() {
        Point a = new Point(1, 1);
        Point b = new Point(1, 2);
        double expected = 1;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void whenMinus11toMinus22then1point41() {
        Point a = new Point(-1, 1);
        Point b = new Point(-2, 2);
        double expected = 1.41;
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when111to222then1point73() {
        Point a = new Point(1, 1, 1);
        Point b = new Point(2, 2, 2);
        double expected = 1.73;
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}