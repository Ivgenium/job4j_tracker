package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] allItems = tracker.findAll();
                for (Item element: allItems) {
                    System.out.println(element.getId() + " " + element.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Enter item's id ====");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("=== Enter string to edit name's id====");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Item was successfully edited!");
                } else {
                    System.out.println("Failed to edit item!");
                }
            } else if (select == 3) {
                System.out.println("=== Enter item's id ====");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item was successfully deleted!");
                } else {
                    System.out.println("Failed to delete item!");
                }
            } else if (select == 4) {
                System.out.println("=== Enter item's id ====");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("No item with this id was found!");
                }
                else {
                    System.out.println(item.getName());
                }
            } else if (select == 5) {
                System.out.println("=== Enter item's name ====");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item.length == 0) {
                    System.out.println("No item with this name was found!");
                }
                else {
                    for (Item element: item) {
                        System.out.println(element.getId() + " " + element.getName());
                    }
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }
    private void showMenu() {
        System.out.println("\nMenu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
