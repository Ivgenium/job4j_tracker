package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> filterByAddress = person -> person.getAddress().contains(key);
        Predicate<Person> filterByName = person -> person.getName().contains(key);
        Predicate<Person> filterBySurname = person -> person.getSurname().contains(key);
        Predicate<Person> filterByPhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = filterByAddress.or(filterByName).or(filterBySurname).or(filterByPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
