package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SingleTrackerTest {
    @Test
    public void whenSingletonThenItemsAreInTheSameTracker() {
        SingleTracker singleTracker1 = SingleTracker.getInstance();
        Item test1 = new Item();
        test1.setName("test1");
        singleTracker1.add(test1);
        SingleTracker singleTracker2 = SingleTracker.getInstance();
        Item test2 = new Item();
        test2.setName("test2");
        singleTracker2.add(test2);
        List<Item> result = SingleTracker.getInstance().findAll();
        List<Item> expected = Arrays.asList(test1, test2);
        assertThat(result).isEqualTo(expected);
    }
}