package ru.gubern.entities;

import ru.gubern.entities.Subject;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private ArrayList<Integer> subjectsIds;
    private LocalDateTime retirementDate;
    private LocalDateTime dismissalDate = null;

    public Teacher(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjectsIds = new ArrayList<>();
        this.retirementDate = LocalDateTime.now();
    }

    public Teacher(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjectsIds = new ArrayList<>();
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

    public ArrayList<Integer> getSubjects() {
        return subjectsIds;
    }

    public void setSubjects(ArrayList<Integer> subjects) {
        this.subjectsIds = subjects;
    }
    public void addSubject(Integer subjectId) {
        subjectsIds.add(subjectId);
    }
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", subjects=" + subjectsIds +
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
