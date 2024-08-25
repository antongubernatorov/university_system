package ru.gubern.managers;

import org.junit.jupiter.api.*;
import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.time.Period;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.gubern.managers.LocalSystem.*;
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
            assertThat(teachers.size()).isEqualTo(2);
        }
        @Test
        void deleteAllTeachers() {
            localSystem.deleteAllTeachers();
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
        //TODO 22/08/2024 20:27
        @Test
        void updateStudent() {
            localSystem.deleteAllStudents();
            localSystem.createStudent(student);
            Student studentNew = new Student("Anton", "Gubern", 21,1);
            int oldStudentId = student.getId();
            localSystem.updateStudent(oldStudentId, studentNew);
            assertThat(students.get(oldStudentId)).isEqualTo(studentNew);
        }

        @Test
        void deleteStudentById() {
            localSystem.deleteAllStudents();
            localSystem.createStudent(student);
            localSystem.deleteStudentById(student.getId());
            assertThat(students.size()).isEqualTo(0);
        }

        @Test
        void getStudentById() {
            localSystem.deleteAllStudents();
            localSystem.createStudent(student);
            var studentById = localSystem.getStudentById(student.getId());
            assertThat(studentById).isEqualTo(student);
        }

        @Test
        void getAllStudents() {
            localSystem.deleteAllStudents();
            localSystem.createStudent(student);
            localSystem.createStudent(student2);
            assertThat(students.size()).isEqualTo(2);
        }

        @Test
        void deleteAllStudents() {
            localSystem.deleteAllStudents();
            localSystem.createStudent(student);
            localSystem.createStudent(student2);
            localSystem.deleteAllStudents();
            assertThat(students.size()).isEqualTo(0);
        }
    }

    @Tag("Subject")
    @Nested
    class subjectTest{
        @Test
        void createSubject() {
            localSystem.deleteAllSubjects();
            localSystem.createSubject(subject);
            var subjectById = localSystem.getSubjectById(subject.getId());
            assertThat(subject).isEqualTo(subjectById);
        }

        @Test
        void updateSubject() {
            localSystem.deleteAllSubjects();
            localSystem.createSubject(subject);
            Subject subjectNew = new Subject("Linear", 30, Period.of(0,12,0));
            int oldSubjectId = subject.getId();
            localSystem.updateSubject(oldSubjectId, subjectNew);
            assertThat(subjects.get(oldSubjectId)).isEqualTo(subjectNew);
        }
        @Test
        void deleteSubjectById() {
            localSystem.deleteAllSubjects();
            localSystem.createSubject(subject);
            localSystem.deleteSubjectById(subject.getId());
            assertThat(subjects.size()).isEqualTo(0);
        }

        @Test
        void getSubjectById() {
            localSystem.deleteAllSubjects();
            localSystem.createSubject(subject);
            var subjectById = localSystem.getSubjectById(subject.getId());
            assertThat(subjectById).isEqualTo(subject);
        }
        @Test
        void getAllSubjects() {
            localSystem.deleteAllSubjects();
            localSystem.createSubject(subject);
            localSystem.createSubject(subject2);
            assertThat(subjects.size()).isEqualTo(2);
        }
        @Test
        void deleteAllSubjects() {
                localSystem.deleteAllSubjects();
                localSystem.createSubject(subject);
                localSystem.createSubject(subject2);
                localSystem.deleteAllSubjects();
                assertThat(subjects.size()).isEqualTo(0);
            }
        }

    @Tag("History")
    @Nested
    class HistoryTest {
        @Test
        void getStudentHistory() {
            history.clearStudentHistory();
            localSystem.createStudent(student);
            localSystem.createStudent(student2);
            localSystem.getStudentById(student.getId());
            localSystem.getStudentById(student2.getId());
            var studentHistory = localSystem.getStudentHistory();
            assertThat(studentHistory.size()).isEqualTo(2);
        }

        @Test
        void getTeacherHistory() {
            history.clearTeacherHistory();
            localSystem.createTeacher(teacher);
            localSystem.createTeacher(teacher2);
            localSystem.getTeacherById(teacher.getId());
            localSystem.getTeacherById(teacher2.getId());
            var teacherHistory = localSystem.getTeacherHistory();
            assertThat(teacherHistory.size()).isEqualTo(2);
        }

        @Test
        void getSubjectHistory() {
            history.clearSubjectHistory();
            localSystem.createSubject(subject);
            localSystem.createSubject(subject2);
            localSystem.getSubjectById(subject.getId());
            localSystem.getSubjectById(subject2.getId());
            var subjectHistory = localSystem.getSubjectHistory();
            assertThat(subjectHistory.size()).isEqualTo(2);
        }
    }
}
