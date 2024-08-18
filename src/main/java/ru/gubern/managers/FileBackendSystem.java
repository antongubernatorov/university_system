package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;
import java.io.*;
import java.nio.file.Files;
import java.time.Period;
import java.util.Deque;

public class FileBackendSystem extends LocalSystem{
    private File saveFileStudents = new File("src/main/java/ru/gubern/files", "SaveStudents.csv");
    private File saveFileTeachers = new File("src/main/java/ru/gubern/files", "SaveTeachers.csv");
    private File saveFileSubjects = new File("src/main/java/ru/gubern/files", "SaveSubjects.csv");
    private File saveFileStudentsHistory = new File("src/main/java/ru/gubern/files", "SaveHistoryStudents.csv");
    private File saveFileTeachersHistory = new File("src/main/java/ru/gubern/files", "SaveHistoryTeachers.csv");
    private File saveFileSubjectsHistory = new File("src/main/java/ru/gubern/files", "SaveHistorySubjects.csv");

    public FileBackendSystem(File saveFileStudents, File saveFileTeachers, File saveFileSubjects, File saveFileStudentsHistory, File saveFileTeachersHistory, File saveFileSubjectsHistory) {
        this.saveFileStudents = saveFileStudents;
        this.saveFileTeachers = saveFileTeachers;
        this.saveFileSubjects = saveFileSubjects;
        this.saveFileStudentsHistory = saveFileStudentsHistory;
        this.saveFileTeachersHistory = saveFileTeachersHistory;
        this.saveFileSubjectsHistory = saveFileSubjectsHistory;
    }

    public File getSaveFileStudentsHistory() {
        return saveFileStudentsHistory;
    }

    public File getSaveFileTeachersHistory() {
        return saveFileTeachersHistory;
    }

    public File getSaveFileSubjectsHistory() {
        return saveFileSubjectsHistory;
    }

    public FileBackendSystem() {
    }

    public File getSaveFileStudents() {
        return saveFileStudents;
    }

    public File getSaveFileTeachers() {
        return saveFileTeachers;
    }

    public File getSaveFileSubjects() {
        return saveFileSubjects;
    }

    //save in file
    public void save() throws IOException {
        saveStudents();
        saveTeachers();
        saveSubjects();
        saveHistoryStudents();
        saveHistoryTeachers();
        saveHistorySubjects();
    }

    private void saveStudents(){
        try {
            if (!Files.exists(saveFileStudents.toPath())){
                Files.createFile(saveFileStudents.toPath());
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл Students");
            throw new RuntimeException(e);
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(saveFileStudents))){
            wr.write("id,firstName,lastName,age,group,subjectsId,enrollmentDate,graduationDate\n");
            for(Student student : students.values()){
                var string = student.toString();
                wr.write(string + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void saveTeachers(){
        try {
            if (!Files.exists(saveFileTeachers.toPath())){
                Files.createFile(saveFileTeachers.toPath());
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл Teachers");
            throw new RuntimeException(e);
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(saveFileTeachers))){
            wr.write("id,firstName,lastName,age,subjectsId,retirementDate,dismissalDate\n");
            for(Teacher teacher : teachers.values()){
                var string = teacher.toString();
                wr.write(string + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void saveSubjects(){
        try {
            if (!Files.exists(saveFileSubjects.toPath())){
                Files.createFile(saveFileSubjects.toPath());
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл Subjects");
            throw new RuntimeException(e);
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(saveFileSubjects))){
            wr.write("id,name,credits,teachersIds,studentsIds,courseDuration\n");
            for(Subject subject : subjects.values()){
                var string = subject.toString();
                wr.write(string + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void saveHistoryStudents() throws IOException {
        try {
            if (!Files.exists(saveFileStudentsHistory.toPath())){
                Files.createFile(saveFileStudentsHistory.toPath());
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл HistoryStudents");
            throw new RuntimeException(e);
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(saveFileStudentsHistory))){
            var studentHistory = history.getStudentHistory();
            wr.write("id,firstName,lastName,age,group,subjectsId,enrollmentDate,graduationDate\n");
            for(Student student : studentHistory){
                wr.write(student.toString() + "\n");
            }
        }
    }
    private void saveHistoryTeachers() throws IOException {
        try {
            if (!Files.exists(saveFileTeachersHistory.toPath())){
                Files.createFile(saveFileTeachersHistory.toPath());
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл HistoryTeachers");
            throw new RuntimeException(e);
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(saveFileTeachersHistory))){
            var teacherHistory = history.getTeacherHistory();
            wr.write("id,firstName,lastName,age,subjectsId,retirementDate,dismissalDate\n");
            for(Teacher teacher : teacherHistory){
                wr.write(teacher.toString() + "\n");
            }
        }
    }
    private void saveHistorySubjects() throws IOException {
        try {
            if (!Files.exists(saveFileSubjectsHistory.toPath())){
                Files.createFile(saveFileSubjectsHistory.toPath());
            }
        } catch (IOException e) {
            System.out.println("Не удалось создать файл HistorySubjects");
            throw new RuntimeException(e);
        }
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(saveFileSubjectsHistory))){
            var subjectHistory = history.getSubjectHistory();
            wr.write("id,name,credits,teachersIds,studentsIds,courseDuration\n");
            for(Subject subject : subjectHistory){
                wr.write(subject.toString() + "\n");
            }
        }
    }

    //load from file
    //history load to HistoryFile
    //history load from HistoryFile

    public static void main(String[] args) throws IOException {
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

        //history
        System.out.println("_____________________________________");
        System.out.println(localSystem.getStudentHistory());
        System.out.println(localSystem.getTeacherHistory());
        System.out.println(localSystem.getSubjectHistory());

        //backend manager
        FileBackendSystem fileBackendSystem = new FileBackendSystem();
        fileBackendSystem.save();
    }
}
