package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item left, Item right) {
        return right.compareTo(left);
    }
}
