package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }


    @Test
    public void findTwoItemsByName() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test2");
        Item item4 = new Item("test3");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] result = {item2, item3};
        assertThat(result, is(tracker.findByName("test2")));
    }
    @Test
    public void findNoItemsByName() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test2");
        Item item4 = new Item("test3");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(new Item[0], is(tracker.findByName("test4")));
    }
    @Test
    public void findAllFourItems() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test2");
        Item item4 = new Item("test3");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] result = {item1, item2, item3, item4};
        assertThat(result, is(tracker.findAll()));
    }
    @Test
    public void replaceItems() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item item22 = new Item("test22");
        tracker.replace(2, item22);
        Item item33 = new Item("test33");
        tracker.replace(3, item33);
        Item[] result = {item1, item22, item33, item4};
        assertThat(result, is(tracker.findAll()));
    }
    @Test
    public void replaceNoItems() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item item22 = new Item("test22");
        tracker.replace(5, item22);
        Item item33 = new Item("test33");
        tracker.replace(6, item33);
        Item[] result = {item1, item2, item3, item4};
        assertThat(result, is(tracker.findAll()));
    }
    @Test
    public void deleteItems() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(2);
        tracker.delete(4);
        Item[] result = {item1, item3};
        assertThat(result, is(tracker.findAll()));
    }
    @Test
    public void deleteNoItems() {
        Item item1 = new Item("test1");
        Item item2 = new Item("test2");
        Item item3 = new Item("test3");
        Item item4 = new Item("test4");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(5);
        tracker.delete(6);
        Item[] result = {item1, item2, item3, item4};
        assertThat(result, is(tracker.findAll()));
    }
}