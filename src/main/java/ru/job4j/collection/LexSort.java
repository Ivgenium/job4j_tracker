package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftInt = Integer.parseInt(left.split("\\.")[0]);
        int rightInt = Integer.parseInt(right.split("\\.")[0]);
        int rsl = Integer.compare(leftInt, rightInt);
        return rsl;
    }
}
