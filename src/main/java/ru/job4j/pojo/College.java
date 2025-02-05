package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Гришин Александр Игоревич");
        student.setGroup("106223");
        student.setEntrance(new Date());
        System.out.println(student.getFullName() + " поступил в группу: " + student.getGroup() + " в " + student.getEntrance());
    }
}
