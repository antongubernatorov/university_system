package ru.gubern;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<Subject> subjects;
    private LocalDateTime retirementDate;
    private LocalDateTime dismissalDate = null;

    public Teacher(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjects = new ArrayList<>();
    }

    public Teacher(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjects = new ArrayList<>();
        this.retirementDate = LocalDateTime.now();
    }

    public LocalDateTime getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(LocalDateTime retirementDate) {
        this.retirementDate = retirementDate;
    }

    public LocalDateTime getDismissalDate() {
        return dismissalDate;
    }

    public void setDismissalDate(LocalDateTime dismissalDate) {
        this.dismissalDate = dismissalDate;
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

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "ru.gubern.Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", subjects=" + subjects +
                ", retirementDate=" + retirementDate +
                ", dismissalDate=" + dismissalDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
