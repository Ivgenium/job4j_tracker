package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean result = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String element : origin) {
            check.add(element);
        }
        for (String element : text) {
            if (!check.contains(element)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
