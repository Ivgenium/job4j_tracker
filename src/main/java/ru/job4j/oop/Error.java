package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
        message = "Неизвестная ошибка";
    }

    public void printInfo() {
        System.out.println("Активная: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error emptyError = new Error();
        emptyError.printInfo();
        Error error1 = new Error(true, 1, "Недостаточно параметров");
        error1.printInfo();
        Error error2 = new Error(false, 0, "Лимит времени ожидания превышен");
        error2.printInfo();
        Error error3 = new Error(true, 1, "Поле объекта не обнаружено");
        error3.printInfo();
    }
}
