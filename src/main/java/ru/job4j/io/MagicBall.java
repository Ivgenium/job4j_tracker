package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        input.nextLine();
        String prediction;
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0:
                prediction = "Да";
                break;
            case 1:
                prediction = "Нет";
                break;
            default:
                prediction = "Может быть";
        }
        System.out.println(prediction);
    }
}
