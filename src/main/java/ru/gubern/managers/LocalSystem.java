package ru.gubern.managers;

import ru.gubern.Student;
import ru.gubern.Subject;
import ru.gubern.Teacher;

import java.util.HashMap;

public class LocalSystem implements LocalSystemInterface {
    public static final HashMap<Integer, Teacher> teachers = new HashMap<>();
    public static final HashMap<Integer, Student> students = new HashMap<>();
    public static final HashMap<Integer, Subject> subjects = new HashMap<>();
    public static int idTeacherGenerator = -1;
    public static int idStudentGenerator = -1;
    public static int idSubjectGenerator = -1;

    @Override
    public void createTeacher(Teacher teacher) {
        int id = generateNewTeacherId();
        teacher.setId(id);
        teachers.put(id, teacher);
    }

    @Override
    public void createStudent(Student student) {
        int id = generateNewStudentId();
        student.setId(id);
        students.put(id, student);
    }

    @Override
    public void createSubject(Subject subject) {
        int id = generateNewSubjectId();
        subject.setId(id);
        subjects.put(id, subject);
    }

    @Override
    public void updateTeacher(Teacher teacher) {

    }

    @Override
    public void updateSubject(Subject subject) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void deleteTeacher(int id) {

    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void deleteSubject(int id) {

    }

    private int generateNewTeacherId(){
        return ++idTeacherGenerator;
    }

    private int generateNewStudentId(){
        return ++idStudentGenerator;
    }

    private int generateNewSubjectId(){
        return ++idSubjectGenerator;
    }
}
