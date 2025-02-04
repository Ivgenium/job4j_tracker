package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.roll();
        Hare hare = new Hare();
        System.out.println("Колобок встретил зайца");
        ball.song();
        hare.tryEat(ball);
        ball.roll();
        Wolf wolf = new Wolf();
        System.out.println("Колобок встретил волка");
        ball.song();
        wolf.tryEat(ball);
        ball.roll();
        Fox fox = new Fox();
        System.out.println("Колобок встретил лису");
        ball.song();
        fox.tryEat(ball);
    }
}
