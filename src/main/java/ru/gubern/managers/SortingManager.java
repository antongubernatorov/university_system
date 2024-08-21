package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;
import ru.gubern.utility.PeriodToDays;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingManager implements SortingManagerInterface{
    //Comparators for students
    Comparator<Student> studentFirstNameComparator = Comparator.comparing(Student::getFirstName);
    Comparator<Student> studentLastNameComparator = Comparator.comparing(Student::getFirstName);
    Comparator<Student> studentAgeComparator = Comparator.comparingInt(Student::getAge);

    Comparator<Student> studentGroupComparator = Comparator.comparingInt(Student::getGroup);
    Comparator<Student> studentEnrollmentDateComparator = Comparator.comparing(Student::getEnrollmentDate);

    @Override
    public List<Student> sortStudentsByFirstName(List<Student> students) {
        return students.stream().sorted(studentFirstNameComparator).collect(Collectors.toList());
    }

    @Override
    public List<Student> sortStudentsByLastName(List<Student> students) {
        return students.stream().sorted(studentLastNameComparator).collect(Collectors.toList());
    }

    @Override
    public List<Student> sortStudentsByAge(List<Student> students) {
        return students.stream().sorted(studentAgeComparator).collect(Collectors.toList());
    }

    @Override
    public List<Student> sortStudentsByGroup(List<Student> students) {
        return students.stream().sorted(studentGroupComparator).collect(Collectors.toList());
    }

    @Override
    public List<Student> sortStudentsByEnrollmentDate(List<Student> students) {
        return students.stream().sorted(studentEnrollmentDateComparator).collect(Collectors.toList());
    }

    //Comparators for teachers
    Comparator<Teacher> teacherFirstNameComparator = Comparator.comparing(Teacher::getFirstName);
    Comparator<Teacher> teacherLastNameComparator = Comparator.comparing(Teacher::getLastName);
    Comparator<Teacher> teacherAgeComparator = Comparator.comparingInt(Teacher::getAge);
    Comparator<Teacher> teacherRetirementComparator = Comparator.comparing(Teacher::getRetirementDate);
    @Override
    public List<Teacher> sortTeachersByFirstName(List<Teacher> teachers) {
        return teachers.stream().sorted(teacherFirstNameComparator).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> sortTeachersByLastName(List<Teacher> teachers) {
        return teachers.stream().sorted(teacherLastNameComparator).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> sortTeachersByAge(List<Teacher> teachers) {
        return teachers.stream().sorted(teacherAgeComparator).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> sortTeachersByRetirementDate(List<Teacher> teachers) {
        return teachers.stream().sorted(teacherRetirementComparator).collect(Collectors.toList());
    }

    //Comparators for subjects
    Comparator<Subject> subjectNameComparator = Comparator.comparing(Subject::getName);
    Comparator<Subject> subjectCreditsComparator = Comparator.comparing(Subject::getCredits);
    Comparator<Subject> subjectDurationComparator = Comparator.comparingInt(o -> PeriodToDays.castPeriodToDays(o.getCourseDuration()));
    @Override
    public List<Subject> sortSubjectsByName(List<Subject> subjects) {
        return subjects.stream().sorted(subjectNameComparator).collect(Collectors.toList());
    }
    @Override
    public List<Subject> sortSubjectsByCredits(List<Subject> subjects) {
        return subjects.stream().sorted(subjectCreditsComparator).collect(Collectors.toList());
    }
    @Override
    public List<Subject> sortSubjectsByCourseDuration(List<Subject> subjects) {
        return subjects.stream().sorted(subjectDurationComparator).collect(Collectors.toList());
    }
}
