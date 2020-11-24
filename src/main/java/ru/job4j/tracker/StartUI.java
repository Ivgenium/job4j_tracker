package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item foundItem = tracker.findById(1);
        System.out.println("Found item - " + foundItem.getName());
    }
}
