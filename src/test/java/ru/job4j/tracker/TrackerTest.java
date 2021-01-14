package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void findTwoItemsByName() {
        Item item1 = new Item();
        item1.setName("test1");
        Item item2 = new Item();
        item2.setName("test2");
        Item item3 = new Item();
        item3.setName("test2");
        Item item4 = new Item();
        item4.setName("test3");
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
        Item item1 = new Item();
        item1.setName("test1");
        Item item2 = new Item();
        item2.setName("test2");
        Item item3 = new Item();
        item3.setName("test2");
        Item item4 = new Item();
        item4.setName("test3");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        assertThat(new Item[0], is(tracker.findByName("test4")));
    }
    @Test
    public void findAllFourItems() {
        Item item1 = new Item();
        item1.setName("test1");
        Item item2 = new Item();
        item2.setName("test2");
        Item item3 = new Item();
        item3.setName("test2");
        Item item4 = new Item();
        item4.setName("test3");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        tracker.add(item4);
        Item[] result = {item1, item2, item3, item4};
        assertThat(result, is(tracker.findAll()));
    }
}