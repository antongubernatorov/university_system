package ru.gubern.managers;

import org.junit.jupiter.api.*;
import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.gubern.managers.LocalSystem.teachers;
import static ru.gubern.managers.Manager.getDefault;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public abstract class LocalSystemTest<T extends LocalSystem>{
    Teacher teacher;
    Teacher teacher2;
    Student student;
    Student student2;
    Subject subject;
    Subject subject2;
    private LocalSystemInterface localSystem;
    public abstract T createLocalSystem();
    @BeforeEach
    void prepare(){
        localSystem = getDefault();
        teacher = new Teacher("Anton", "Gubern", 20);
        teacher2 = new Teacher("Alex", "Volk", 50);
        student = new Student("Anton", "Gubern",19, 1);
        student2 = new Student("Pik", "Tanford",25, 2);
        subject = new Subject("Linear", 25, Period.of(0,3,0));
        subject2 = new Subject("Math", 28, Period.of(0,6,0));
    }

    @AfterEach
    void clearData(){
        localSystem.deleteAllEntities();
    }

    @Tag("Teacher")
    @Nested
    class TeacherTest{
        @Test
        void createTeacherTest() {
            localSystem.deleteAllTeachers();
            localSystem.createTeacher(teacher);
            var teacherById = localSystem.getTeacherById(teacher.getId());
            assertThat(teacher).isEqualTo(teacherById).describedAs("Teacher and TeacherById should be equal");
        }

        @Test
        void teachersListSizeIfUserAddedTest(){
            localSystem.deleteAllTeachers();
            localSystem.createTeacher(teacher);
            assertThat(teachers).hasSize(1);
        }

        @Test
        void throwNullPointerExceptionIfThereIsNoTeacherByIdTest(){
            localSystem.deleteAllTeachers();
            assertThrows(NullPointerException.class, () -> localSystem.getTeacherById(0));
        }

        @Test
        void updateTeacher() {
            localSystem.deleteAllTeachers();
            localSystem.createTeacher(teacher);
            Teacher teacherNew = new Teacher("Anton", "Gubern", 21);
            int oldTeacherId = teacher.getId();
            localSystem.updateTeacher(oldTeacherId, teacherNew);
            assertThat(teachers.get(oldTeacherId)).isEqualTo(teacherNew);
        }

        @Test
        void deleteTeacherById() {
            localSystem.deleteAllTeachers();
            localSystem.createTeacher(teacher);
            localSystem.deleteTeacherById(teacher.getId());
            assertThat(teachers.size()).isEqualTo(0);
        }

        @Test
        void getTeacherById() {
            localSystem.deleteAllTeachers();
            localSystem.createTeacher(teacher);
            var teacherById = localSystem.getTeacherById(teacher.getId());
            assertThat(teacherById).isEqualTo(teacher);
        }
        @Test
        void getAllTeachers() {
            localSystem.deleteAllTeachers();
            localSystem.createTeacher(teacher);
            localSystem.createTeacher(teacher2);
            localSystem.getAllTeachers();
            assertThat(teachers.size()).isEqualTo(2);
        }
        @Test
        void deleteAllTeachers() {
            localSystem.getAllTeachers();
            localSystem.createTeacher(teacher);
            localSystem.createTeacher(teacher2);
            localSystem.deleteAllTeachers();
            assertThat(teachers.size()).isEqualTo(0);
        }
    }

    @Tag("Student")
    @Nested
    class StudentTest{
        @Test
        void createStudent() {
            localSystem.deleteAllStudents();
            localSystem.createStudent(student);
            var studentById = localSystem.getStudentById(student.getId());
            assertThat(student).isEqualTo(studentById);
        }
        @Test
        void updateStudent() {
            
        }

        @Test
        void deleteStudentById() {
        }

        @Test
        void getStudentById() {
        }
        @Test
        void getAllStudents() {
        }
        @Test
        void getStudentIdsBySubject() {
        }

        @Test
        void deleteAllStudents() {
        }
    }

    @Tag("Subject")
    @Nested
    class subjectTest{
        @Test
        void createSubject() {
        }

        @Test
        void updateSubject() {
        }
        @Test
        void deleteSubjectById() {
        }

        @Test
        void getSubjectById() {
        }
        @Test
        void getAllSubjects() {
        }
        @Test
        void getSubjectIdsByStudent() {
        }
        @Test
        void getSubjectIdsByTeacher() {
        }

        @Test
        void deleteAllSubjects() {
        }

        @Test
        void addSubjectToStudentById() {
        }

        @Test
        void addSubjectToTeacherById() {
        }
    }

    @Tag("History")
    @Nested
    class historyTest{
        @Test
        void getStudentHistory() {
        }

        @Test
        void getTeacherHistory() {
        }

        @Test
        void getSubjectHistory() {
        }
    }
}