package ru.gubern;

import ru.gubern.Teacher;

import java.time.Period;
import java.util.ArrayList;

public class Subject {
    private int id;
    private String name;
    private int credits;
    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;
    private Period courseDuration;

    public Subject(String name, int credits) {
        this.name = name;
        this.credits = credits;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Subject(int id, String name, int credits, Period courseDuration) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
        this.courseDuration = courseDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Period getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(Period courseDuration) {
        this.courseDuration = courseDuration;
    }
}
