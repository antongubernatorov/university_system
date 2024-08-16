package ru.gubern.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private int group;
    private ArrayList<Integer> subjectsId;
    private LocalDateTime enrollmentDate;
    private LocalDateTime graduationDate = null;

    public Student(String firstName, String lastName, int age, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.subjectsId = new ArrayList<>();
        this.enrollmentDate = LocalDateTime.now();
    }

    public Student(int id, String firstName, String lastName, int age, int group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
        this.subjectsId = new ArrayList<>();
        this.enrollmentDate = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDateTime enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public LocalDateTime getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDateTime graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public ArrayList<Integer> getSubjects() {
        return subjectsId;
    }

    public void setSubjects(ArrayList<Integer> subjects) {
        this.subjectsId = subjects;
    }

    public void addSubject(int subjectId) {
        subjectsId.add(subjectId);
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", group=" + group +
                ", subjects=" + subjectsId +
                ", enrollmentDate=" + enrollmentDate +
                ", graduationDate=" + graduationDate +
                '}';
    }
}
