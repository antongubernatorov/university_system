package ru.gubern;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;
import ru.gubern.managers.LocalSystem;
import ru.gubern.managers.Manager;

import java.time.Period;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        final var localSystem = manager.getDefault();
        //creating teacher
        Teacher teacher = new Teacher("Brad", "Lock", 45);
        localSystem.createTeacher(teacher);
        Teacher teacher2 = new Teacher("Alex", "Volk", 63);
        localSystem.createTeacher(teacher2);
        //creating student
        Student student = new Student("Anton", "Gubern", 19, 1);
        localSystem.createStudent(student);
        Student student2 = new Student("Tim", "Vazoski", 19, 1);
        localSystem.createStudent(student2);
        //creating subject
        Period period = Period.ofMonths(3);
        Subject subject = new Subject("Linear algebra", 15, period);
        localSystem.createSubject(subject);
        Subject subject2 = new Subject("Math analyze", 35, period);
        localSystem.createSubject(subject2);

        //add relations
        localSystem.addSubjectToStudentById(student.getId(), subject.getId());
        localSystem.addSubjectToTeacherById(teacher.getId(), subject.getId());
        localSystem.addSubjectToStudentById(student2.getId(), subject2.getId());
        localSystem.addSubjectToStudentById(student2.getId(), subject.getId());
        localSystem.addSubjectToTeacherById(teacher.getId(), subject.getId());
        localSystem.addSubjectToTeacherById(teacher2.getId(), subject.getId());
        localSystem.addSubjectToTeacherById(teacher2.getId(), subject2.getId());

        //check results
        final var allStudents = localSystem.getAllStudents();
        System.out.println(allStudents);
        final var allTeachers = localSystem.getAllTeachers();
        System.out.println(allTeachers);
        final var allSubjects = localSystem.getAllSubjects();
        System.out.println(allSubjects);

        //get by ids
        System.out.println("_____________________________________");
        var studentIdsBySubject = localSystem.getStudentIdsBySubject(subject.getId());
        System.out.println(studentIdsBySubject);
        var teacherIdsBySubject = localSystem.getTeacherIdsBySubject(subject.getId());
        System.out.println(teacherIdsBySubject);
        var subjectIdsByTeacher = localSystem.getSubjectIdsByTeacher(teacher.getId());
        System.out.println(subjectIdsByTeacher);
        var subjectIdsByStudent = localSystem.getSubjectIdsByStudent(student.getId());
        System.out.println(subjectIdsByStudent);
    }
}