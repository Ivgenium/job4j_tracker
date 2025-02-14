package ru.job4j.queue;

import java.util.Queue;

public class AppleStore {
    private final Queue<Customer> queue;

    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        Customer temp = new Customer("", 0);
        for (int i = 0; i < count; i++) {
            temp = queue.poll();
        }
        return temp.name();
    }

    public String getFirstUpsetCustomer() {
        Customer temp = new Customer("", 0);
        for (int i = 0; i <= count; i++) {
            temp = queue.poll();
        }
        return temp.name();
    }
}
