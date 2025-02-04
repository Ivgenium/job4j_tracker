package ru.job4j.oop;

public class Ball {

    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Колобок съеден");
        } else {
            System.out.println("Колобок сбежал");
        }
    }

    public void roll() {
        System.out.println("Колобок покатился");
    }

    public void song() {
        System.out.println("Колобок поёт");
    }
}
