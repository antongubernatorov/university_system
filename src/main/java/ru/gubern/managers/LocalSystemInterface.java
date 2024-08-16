package ru.gubern.managers;


import ru.gubern.Student;
import ru.gubern.Subject;
import ru.gubern.Teacher;

public interface LocalSystemInterface {
    void createTeacher(Teacher teacher);
    void createStudent(Student student);
    void createSubject(Subject subject);
    void updateTeacher(Teacher teacher);
    void updateSubject(Subject subject);
    void updateStudent(Student student);
    void deleteTeacher(int id);
    void deleteStudent(int id);
    void deleteSubject(int id);
}
