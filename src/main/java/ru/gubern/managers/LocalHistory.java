package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
public class LocalHistory implements LocalHistoryInterface{
    private final Deque<Student> studentsHistory = new ArrayDeque<>(10);
    private final Deque<Teacher> teacherHistory = new ArrayDeque<>(10);
    private final Deque<Subject> subjectHistory = new ArrayDeque<>(10);
    @Override
    public void addStudent(Student student) {
        studentsHistory.addFirst(student);
    }

    @Override
    public Deque<Student> getStudentHistory() {
        return studentsHistory;
    }
    @Override
    public void clearStudentHistory() {
        studentsHistory.clear();
    }

    @Override
    public void removeStudent() {
        studentsHistory.pop();
    }

    @Override
    public void addSubject(Subject subject) {
        subjectHistory.addFirst(subject);
    }

    @Override
    public Deque<Subject> getSubjectHistory() {
        return subjectHistory;
    }

    @Override
    public void clearSubjectHistory() {
        subjectHistory.clear();
    }

    @Override
    public void removeSubject() {
        subjectHistory.pop();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        teacherHistory.addFirst(teacher);
    }

    @Override
    public Deque<Teacher> getTeacherHistory() {
        return teacherHistory;
    }
    @Override
    public void clearTeacherHistory() {
        teacherHistory.clear();
    }

    @Override
    public void removeTeacher() {
        teacherHistory.pop();
    }
}
