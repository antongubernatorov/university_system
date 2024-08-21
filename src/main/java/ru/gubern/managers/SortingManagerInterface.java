package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.util.Comparator;
import java.util.List;

public interface SortingManagerInterface {
    //students
    List<Student> sortStudentsByFirstName(List<Student> students);
    List<Student> sortStudentsByLastName(List<Student> students);
    List<Student> sortStudentsByAge(List<Student> students);
    List<Student> sortStudentsByGroup(List<Student> students);
    List<Student> sortStudentsByEnrollmentDate(List<Student> students);

    //teachers
    List<Teacher> sortTeachersByFirstName(List<Teacher> teachers);
    List<Teacher> sortTeachersByLastName(List<Teacher> teachers);
    List<Teacher> sortTeachersByAge(List<Teacher> teachers);
    List<Teacher> sortTeachersByRetirementDate(List<Teacher> teachers);

    //subjects
    List<Subject> sortSubjectsByName(List<Subject> subjects);
    List<Subject> sortSubjectsByCredits(List<Subject> subjects);
    List<Subject> sortSubjectsByCourseDuration(List<Subject> subjects);
}
