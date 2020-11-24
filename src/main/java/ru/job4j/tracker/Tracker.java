package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int resultingSize = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                itemsWithoutNull[resultingSize] = item;
                resultingSize++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, resultingSize);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithoutNull = new Item[size];
        int resultingSize = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (Objects.equals(item.getName(), key)) {
                itemsWithoutNull[resultingSize] = item;
                resultingSize++;
            }
        }
        if (resultingSize == 0) {
            return null;
        }
        else {
            return Arrays.copyOf(itemsWithoutNull, resultingSize);
        }
    }
}