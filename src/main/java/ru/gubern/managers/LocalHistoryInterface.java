package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.util.Deque;
import java.util.List;


public interface LocalHistoryInterface{

    //StudentHistory
    void addStudent (Student student);
    Deque<Student> getStudentHistory();
    void removeStudent();

    //SubjectHistory
    void addSubject (Subject subject);
    Deque<Subject> getSubjectHistory();
    void removeSubject();

    //TeacherHistory
    void addTeacher (Teacher teacher);
    Deque<Teacher> getTeacherHistory();
    void removeTeacher();


}
