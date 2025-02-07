package ru.job4j.poly;

public class Bus implements Transport {
    private static final double PRICE = 50.76;
    private int passengers;
    private int fuel;

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int number) {
        this.passengers = number;
    }

    @Override
    public double refuel(int number) {
        this.fuel = number;
        return PRICE * number;
    }
}
