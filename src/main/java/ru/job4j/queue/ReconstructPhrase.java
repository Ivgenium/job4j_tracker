package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Iterator<Character> iterator = evenElements.iterator();
        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                rsl.append(iterator.next());
            } else {
                iterator.next();
            }
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        int count = descendingElements.size();
        for (int i = 0; i < count; i++) {
            rsl.append(descendingElements.pollLast());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
