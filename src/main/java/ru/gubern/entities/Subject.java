package ru.gubern.entities;

import java.time.Period;
import java.util.ArrayList;

import static ru.gubern.utility.IdsToString.subjectsIdsToString;

public class Subject {
    private int id;
    private String name;
    private int credits;
    private ArrayList<Integer> teachersIds;
    private ArrayList<Integer> studentsIds;
    private Period courseDuration;

    public Subject(String name, int credits, Period courseDuration) {
        this.name = name;
        this.credits = credits;
        this.teachersIds = new ArrayList<>();
        this.studentsIds = new ArrayList<>();
        this.courseDuration = courseDuration;
    }

    public Subject(int id, String name, int credits, Period courseDuration) {
        this.id = id;
        this.name = name;
        this.credits = credits;
        this.teachersIds = new ArrayList<>();
        this.studentsIds = new ArrayList<>();
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

    public ArrayList<Integer> getTeachers() {
        return teachersIds;
    }

    public void setTeachers(ArrayList<Integer> teachers) {
        this.teachersIds = teachers;
    }

    public ArrayList<Integer> getStudents() {
        return studentsIds;
    }

    public void setStudents(ArrayList<Integer> students) {
        this.studentsIds = students;
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
    public void addStudent(Integer studentId) {
        studentsIds.add(studentId);
    }
    public void addTeacher(Integer teacherId) {
        teachersIds.add(teacherId);
    }

    @Override
    public String toString() {
        return id +
                "," + name +
                "," + credits +
                "," + subjectsIdsToString(teachersIds) +
                "," + subjectsIdsToString(studentsIds) +
                "," + courseDuration;
    }
}
