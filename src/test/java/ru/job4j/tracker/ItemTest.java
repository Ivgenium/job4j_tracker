package ru.job4j.tracker;

import org.junit.Test;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemTest {
    @Test
    public void usageItemDate () {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item item = new Item("test1");
        LocalDateTime created = item.getCreated();
        String createdFormat = created.format(formatter);
        System.out.println(createdFormat);
    }
}
