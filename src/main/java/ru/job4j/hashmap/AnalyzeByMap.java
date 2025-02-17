package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        int sum = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return (double) sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            rsl.add(new Label(pupil.name(), (double) sum / count));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new  LinkedHashMap();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> rls = new ArrayList<>();
        for (Map.Entry<String, Integer> element : temp.entrySet()) {
            rls.add(new Label(element.getKey(), (double) element.getValue() / pupils.size()));
        }
        return rls;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rls = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            rls.add(new Label(pupil.name(), sum));
        }
        rls.sort(Comparator.naturalOrder());
        return rls.get(rls.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new  LinkedHashMap();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        List<Label> rls = new ArrayList<>();
        for (Map.Entry<String, Integer> element : temp.entrySet()) {
            rls.add(new Label(element.getKey(), (double) element.getValue()));
        }
        rls.sort(Comparator.naturalOrder());
        return rls.get(rls.size() - 1);
    }
}
