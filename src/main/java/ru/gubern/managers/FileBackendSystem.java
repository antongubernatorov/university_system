package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;
import ru.gubern.exceptions.ManagerLoadException;
import ru.gubern.utility.IdsFromString;
import ru.gubern.utility.LocalDateParser;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Deque;
import java.util.List;

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

    @Override
    public void createTeacher(Teacher teacher) {
        super.createTeacher(teacher);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createStudent(Student student) {
        super.createStudent(student);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createSubject(Subject subject) {
        super.createSubject(subject);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTeacher(int teacherId, Teacher teacher) {
        super.updateTeacher(teacherId, teacher);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateSubject(int subjectId, Subject subject) {
        super.updateSubject(subjectId, subject);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStudent(int studentId, Student student) {
        super.updateStudent(studentId, student);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTeacherById(int id) {
        super.deleteTeacherById(id);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteStudentById(int id) {
        super.deleteStudentById(id);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteSubjectById(int id) {
        super.deleteSubjectById(id);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getTeacherById(id);
    }

    @Override
    public Student getStudentById(int id) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getStudentById(id);
    }

    @Override
    public Subject getSubjectById(int id) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getSubjectById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getAllTeachers();
    }

    @Override
    public List<Subject> getAllSubjects() {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getAllSubjects();
    }

    @Override
    public List<Student> getAllStudents() {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getAllStudents();
    }

    @Override
    public List<Integer> getStudentIdsBySubject(int subjectId) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getStudentIdsBySubject(subjectId);
    }

    @Override
    public List<Integer> getTeacherIdsBySubject(int subjectId) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getTeacherIdsBySubject(subjectId);
    }

    @Override
    public List<Integer> getSubjectIdsByStudent(int studentId) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getSubjectIdsByStudent(studentId);
    }

    @Override
    public List<Integer> getSubjectIdsByTeacher(int teacherId) {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getSubjectIdsByTeacher(teacherId);
    }

    @Override
    public Deque<Student> getStudentHistory() {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getStudentHistory();
    }

    @Override
    public Deque<Teacher> getTeacherHistory() {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getTeacherHistory();
    }

    @Override
    public Deque<Subject> getSubjectHistory() {
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.getSubjectHistory();
    }

    @Override
    public void deleteAllTeachers() {
        super.deleteAllTeachers();
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAllSubjects() {
        super.deleteAllSubjects();
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAllStudents() {
        super.deleteAllStudents();
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSubjectToStudentById(int studentId, int subjectId) {
        super.addSubjectToStudentById(studentId, subjectId);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addSubjectToTeacherById(int teacherId, int subjectId) {
        super.addSubjectToTeacherById(teacherId, subjectId);
        try {
            save();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveStudents(){
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
            System.out.println("История студентов - "  + studentHistory);
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
    public void load() {
        try {
            loadStudents();
            loadSubjects();
            loadTeachers();
            loadStudentHistory();
            loadTeacherHistory();
            loadSubjectHistory();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadStudents() throws IOException {
        try (var reader = new BufferedReader(new FileReader(saveFileStudents))) {
            reader.readLine();
            String string;
            while ((string = reader.readLine()) != null){
                String[] entryArray = string.split(",");
                Student student = new Student(Integer.parseInt(entryArray[0]), entryArray[1],
                        entryArray[2], Integer.parseInt(entryArray[3]), Integer.parseInt(entryArray[4]),
                        IdsFromString.GetIdsFromString(entryArray[5]), LocalDateTime.parse(entryArray[6]),
                        LocalDateParser.parseLocalDate(entryArray[7]));
                students.put(Integer.parseInt(entryArray[0]), student);
            }
        } catch (ManagerLoadException e) {
            throw new ManagerLoadException(e.getMessage());
        }
    }

    private void loadTeachers() throws IOException {
        try (var reader = new BufferedReader(new FileReader(saveFileTeachers))) {
            reader.readLine();
            String string;
            while ((string = reader.readLine()) != null){
                String[] entryArray = string.split(",");
                Teacher teacher = new Teacher(Integer.parseInt(entryArray[0]), entryArray[1],
                        entryArray[2], Integer.parseInt(entryArray[3]),
                        IdsFromString.GetIdsFromString(entryArray[4]), LocalDateTime.parse(entryArray[5]),
                        LocalDateParser.parseLocalDate(entryArray[6]));
                teachers.put(Integer.parseInt(entryArray[0]), teacher);
            }
        } catch (ManagerLoadException e) {
            throw new ManagerLoadException(e.getMessage());
        }
    }

    private void loadSubjects() throws IOException {
        try (var reader = new BufferedReader(new FileReader(saveFileSubjects))) {
            reader.readLine();
            String string;
            while ((string = reader.readLine()) != null){
                String[] entryArray = string.split(",");
                Subject subject = new Subject(Integer.parseInt(entryArray[0]), entryArray[1], Integer.parseInt(entryArray[2]),
                        IdsFromString.GetIdsFromString(entryArray[3]), IdsFromString.GetIdsFromString(entryArray[4]),
                        Period.parse(entryArray[5]));
                subjects.put(Integer.parseInt(entryArray[0]), subject);
            }
        } catch (ManagerLoadException e) {
            throw new ManagerLoadException(e.getMessage());
        }
    }

    private void loadStudentHistory() throws IOException {
        try (var reader = new BufferedReader(new FileReader(saveFileStudentsHistory))) {
            reader.readLine();
            String string;
            while ((string = reader.readLine()) != null){
                String[] entryArray = string.split(",");
                Student student = new Student(Integer.parseInt(entryArray[0]), entryArray[1],
                        entryArray[2], Integer.parseInt(entryArray[3]), Integer.parseInt(entryArray[4]),
                        IdsFromString.GetIdsFromString(entryArray[5]), LocalDateTime.parse(entryArray[6]),
                        LocalDateParser.parseLocalDate(entryArray[7]));
                history.addStudent(student);
            }
        } catch (ManagerLoadException e) {
            throw new ManagerLoadException(e.getMessage());
        }
    }
    private void loadTeacherHistory() throws IOException {
        try (var reader = new BufferedReader(new FileReader(saveFileTeachersHistory))) {
            reader.readLine();
            String string;
            while ((string = reader.readLine()) != null){
                String[] entryArray = string.split(",");
                Teacher teacher = new Teacher(Integer.parseInt(entryArray[0]), entryArray[1],
                        entryArray[2], Integer.parseInt(entryArray[3]),
                        IdsFromString.GetIdsFromString(entryArray[4]), LocalDateTime.parse(entryArray[5]),
                        LocalDateParser.parseLocalDate(entryArray[6]));
                history.addTeacher(teacher);
            }
        } catch (ManagerLoadException e) {
            throw new ManagerLoadException(e.getMessage());
        }
    }

    private void loadSubjectHistory() throws IOException {
        try (var reader = new BufferedReader(new FileReader(saveFileSubjectsHistory))) {
            reader.readLine();
            String string;
            while ((string = reader.readLine()) != null){
                String[] entryArray = string.split(",");
                Subject subject = new Subject(Integer.parseInt(entryArray[0]), entryArray[1], Integer.parseInt(entryArray[2]),
                        IdsFromString.GetIdsFromString(entryArray[3]), IdsFromString.GetIdsFromString(entryArray[4]),
                        Period.parse(entryArray[5]));
                history.addSubject(subject);
            }
        } catch (ManagerLoadException e) {
            throw new ManagerLoadException(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        //backend manager
        FileBackendSystem fileBackendSystem = new FileBackendSystem();

        fileBackendSystem.load();
        System.out.println(students);
        System.out.println("_____________________________________");
        System.out.println(teachers);
        System.out.println("_____________________________________");
        System.out.println(subjects);
        System.out.println("_____________________________________");
        System.out.println(history.getStudentHistory());
        System.out.println("_____________________________________");
        System.out.println(history.getTeacherHistory());
        System.out.println("_____________________________________");
        System.out.println(history.getSubjectHistory());
        System.out.println("_____________________________________");
        var studentsSorted = fileBackendSystem.sortStudentsByAge();
        System.out.println(studentsSorted);
    }
}
