package ru.job4j.poly;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по скоростным трассам");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName()
                + " останавливается на автобусных остановках");
    }
}
