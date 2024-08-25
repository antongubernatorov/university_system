package ru.gubern.managers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.io.File;
import java.io.IOException;
import java.time.Period;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static ru.gubern.managers.LocalSystem.students;
import static ru.gubern.managers.Manager.getDefault;

class FileBackendSystemTest extends LocalSystemTest<FileBackendSystem>{

    Teacher teacher;
    Teacher teacher2;
    Student student;
    Student student2;
    Subject subject;
    Subject subject2;
    private FileBackendSystem backendSystem;
    private File historyStudent = new File("src/main/java/ru/gubern/files/SaveHistoryStudents.csv");
    private File historySubjects = new File("src/main/java/ru/gubern/files/SaveHistorySubjects.csv");
    private File historyTeachers = new File("src/main/java/ru/gubern/files/SaveHistoryTeachers.csv");
    private File saveStudents = new File("src/main/java/ru/gubern/files/SaveStudents.csv");
    private File saveTeachers = new File("src/main/java/ru/gubern/files/SaveTeachers.csv");
    private File saveSubjects = new File("src/main/java/ru/gubern/files/SaveSubjects.csv");

    @BeforeEach
    void prepare(){
        backendSystem = getDefault(saveStudents, saveTeachers, saveSubjects, historyStudent,historySubjects, historyTeachers);
        teacher = new Teacher("Anton", "Gubern", 20);
        teacher2 = new Teacher("Alex", "Volk", 50);
        student = new Student("Anton", "Gubern",19, 1);
        student2 = new Student("Pik", "Tanford",25, 2);
        subject = new Subject("Linear", 25, Period.of(0,3,0));
        subject2 = new Subject("Math", 28, Period.of(0,6,0));
    }

    @Override
    public FileBackendSystem createLocalSystem() {
        return new FileBackendSystem();
    }
    ///TODO 25/08/2024 09:27
    @Test
    void getSaveFileStudentsHistory() throws IOException {
        backendSystem.deleteAllStudents();
        backendSystem.createStudent(student);
        backendSystem.createStudent(student2);
        backendSystem.saveStudents();
    }

    @Test
    void getSaveFileTeachersHistory() {
    }

    @Test
    void getSaveFileSubjectsHistory() {
    }

    @Test
    void getSaveFileStudents() {
    }

    @Test
    void getSaveFileTeachers() {
    }

    @Test
    void getSaveFileSubjects() {
    }
}