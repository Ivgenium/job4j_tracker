package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return x / a;
    }

    public int sumAllOperation(int a) {
        return sum(a) + minus(a) + multiply(a) + divide(a);
    }

    public static void main(String[] args) {
        int rsl = sum(10);
        System.out.println(rsl);
        Calculator calculator = new Calculator();
        rsl = calculator.multiply(5);
        System.out.println(rsl);
        rsl = minus(8);
        System.out.println(rsl);
        rsl = calculator.divide(9);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(15);
        System.out.println(rsl);
    }
}
