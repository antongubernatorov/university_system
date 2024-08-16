package ru.gubern.managers;


import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.util.Deque;
import java.util.List;

public interface LocalSystemInterface {
    //CRUD operations
    void createTeacher(Teacher teacher);
    void createStudent(Student student);
    void createSubject(Subject subject);
    void updateTeacher(Teacher teacher);
    void updateSubject(Subject subject);
    void updateStudent(Student student);
    void deleteTeacherById(int id);
    void deleteStudentById(int id);
    void deleteSubjectById(int id);
    Teacher getTeacherById(int id);
    Student getStudentById(int id);
    Subject getSubjectById(int id);
    List<Teacher> getAllTeachers();
    List<Subject> getAllSubjects();
    List<Student> getAllStudents();
    List<Integer> getStudentIdsBySubject(int subjectId);
    List<Integer> getTeacherIdsBySubject(int subjectId);
    List<Integer> getSubjectIdsByStudent(int studentId);
    List<Integer> getSubjectIdsByTeacher(int teacherId);
    Deque<Student> getStudentHistory();
    Deque<Teacher> getTeacherHistory();
    Deque<Subject> getSubjectHistory();
    void deleteAllTeachers();
    void deleteAllSubjects();
    void deleteAllStudents();
    // ADD FUNCTIONS
    void addSubjectToStudentById(int studentId, int subjectId);
    void addSubjectToTeacherById(int studentId, int subjectId);

}
