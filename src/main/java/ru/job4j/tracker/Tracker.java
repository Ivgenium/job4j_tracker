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
        return Arrays.copyOf(items, size);
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
        return Arrays.copyOf(itemsWithoutNull, resultingSize);
    }
    public boolean replace (int id, Item item) {
        boolean succeeded = false;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                item.setId(id);
                items[i] = item;
                succeeded = true;
            }
        }
        return succeeded;
    }
    public boolean delete(int id) {
        boolean succeeded = false;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                items[i] = null;
                compressItems();
                succeeded = true;
            }
        }
        return succeeded;
    }
    public void compressItems() {
        int i;
        for (int index = 0; index < items.length; index++) {
            Item cell = items[index];
            if (cell == null) {
                i = 1;
                while (items[index] == null && index + i < items.length) {
                    items[index] = items[index + i];
                    items[index + i] = null;
                    i++;
                }
            }
        }
        size--;
    }
}