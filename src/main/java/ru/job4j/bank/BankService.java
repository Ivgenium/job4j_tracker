package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Главный сервис банковской системы.
 */
public class BankService {
    /**
     * Содержит структуру зарегистрированных пользователей и список их банковских счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Зарегистрировать пользователя в банковской системе. В методе есть проверка, что пользователя
     * ещё нет в системе.
     * @param user пользователь для регистрации
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удалить пользователя из банковской системы. Поиск пользователя происходит по номеру паспорта.
     * @param passport номер паспорта
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавить счет пользователю в его список счетов. Поиск пользователя происходит по номеру паспорта.
     * Если такого счета ещё нет у пользователя, то он будет создан.
     * @param passport номер паспорт
     * @param account банковский счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Найти по номеру паспорта зарегистрированного пользователя в банковской системе.
     * @param passport номер паспорта
     * @return зарегистрированный пользователь или null
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Найти счет зарегистрированного пользователя по реквизитам в банковской системе:
     * сперва по номеру паспорта, потом в списке счетов этого пользователя по реквизитам.
     * @param passport номер паспорта
     * @param requisite реквизиты банковского счета
     * @return
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = getAccounts(user);
            for (Account element : list) {
                if (element.getRequisite().equals(requisite)) {
                    return element;
                }
            }
        }
        return null;
    }

    /**
     * Перечислить деньги с одного счета на другой счет.
     * Если счет не найден или не хватает денег на счете, с которого переводят,
     * то метод возвращает false.
     * @param sourcePassport номер паспорта, кому принадлежит счет, с которого идет перечисление денег
     * @param sourceRequisite реквизиты счета, с которого необходимо перечислить деньги
     * @param destinationPassport номер паспорта, кому принадлежит счет, на который произойдет перечисление денег
     * @param destinationRequisite реквизиты счета, на который произойдет перечисление денег
     * @param amount сумма транзакции
     * @return результат успешности операции
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceAccount == null || sourceAccount.getBalance() < amount) {
            return false;
        }
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (destinationAccount != null) {
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Получить список банковских счетов зарегистрированного пользователя.
     * @param user зарегистрированный пользователь
     * @return список банковских счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
