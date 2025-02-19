package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка.
 */
public class User {
    /**
     * Номер паспорта пользователя.
     */
    private String passport;
    /**
     * ФИО пользователя.
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Получить номер паспорта пользователя.
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Записать номер паспорта у пользователя банка.
     * @param passport номер паспорта для записи
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Получить ФИО пользователя.
     * @return ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Записать ФИО пользователя.
     * @param username ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
