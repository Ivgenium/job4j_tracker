package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета.
 */
public class Account {
    /**
     * Реквизиты (номер) счета.
     */
    private String requisite;
    /**
     * Баланс конкретного счета.
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Получить реквизиты банковского счета.
     * @return реквизиты банковского счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Записать реквизиты у банковского счета.
     * @param requisite реквизиты для записи
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Получить сумму баланса, доступного на банковском счету.
     * @return сумма баланса
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Записать сумму баланса в банковском счету.
     * @param balance сумма для записи
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
