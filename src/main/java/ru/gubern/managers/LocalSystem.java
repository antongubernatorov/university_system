package ru.gubern.managers;

import ru.gubern.entities.Student;
import ru.gubern.entities.Subject;
import ru.gubern.entities.Teacher;

import java.util.*;

public class LocalSystem implements LocalSystemInterface {
    public static final HashMap<Integer, Teacher> teachers = new HashMap<>();
    public static final HashMap<Integer, Student> students = new HashMap<>();
    public static final HashMap<Integer, Subject> subjects = new HashMap<>();
    public static int idTeacherGenerator = -1;
    public static int idStudentGenerator = -1;
    public static int idSubjectGenerator = -1;
    public static final LocalHistory history = Manager.getDefaultHistory();
    public static final SortingManager sortingManager = Manager.getDefaultSortingManager();

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
    public void updateTeacher(int teacherId, Teacher teacher) {
        teachers.put(teacherId, teacher);
    }

    @Override
    public void updateSubject(int subjectId, Subject subject) {
        subjects.put(subjectId, subject);
    }

    @Override
    public void updateStudent(int studentId, Student student) {
        students.put(studentId, student);
    }

    @Override
    public void deleteTeacherById(int id) {
        if(teachers.containsKey(id)){
            teachers.remove(id);
        } else {
            System.out.println("Данного преподавателя нет в системе");
        }
    }

    @Override
    public void deleteStudentById(int id) {
        if(students.containsKey(id)){
            students.remove(id);
        } else {
            System.out.println("Данного студента нет в системе");
        }
    }

    @Override
    public void deleteSubjectById(int id) {
        if(subjects.containsKey(id)){
            subjects.remove(id);
        } else {
            System.out.println("Данного предмета нет в системе");
        }
    }

    @Override
    public Teacher getTeacherById(int id) {
        if(teachers.containsKey(id)){
            history.addTeacher(teachers.get(id));
            return teachers.get(id);
        } else {
            throw new NullPointerException("Данного преподавателя нет в системе");
        }
    }

    @Override
    public Student getStudentById(int id) {
        if(students.containsKey(id)){
            history.addStudent(students.get(id));
            return students.get(id);
        } else {
            throw new NullPointerException("Данного студента нет в системе");
        }
    }

    @Override
    public Subject getSubjectById(int id) {
        if(subjects.containsKey(id)){
            history.addSubject(subjects.get(id));
            return subjects.get(id);
        } else {
            throw new NullPointerException("Данного предмета нет в системе");
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        if (teachers.isEmpty()){
            throw new NullPointerException("В списке нет учителей");
        }
        for (Teacher teacher : teachers.values()){
            history.addTeacher(teacher);
        }
        return new ArrayList<>(teachers.values());
    }

    @Override
    public List<Subject> getAllSubjects() {
        if (subjects.isEmpty()){
            throw new NullPointerException("В списке нет предметов");
        }
        for (Subject subject: subjects.values()){
            history.addSubject(subject);
        }
        return new ArrayList<>(subjects.values());
    }

    @Override
    public List<Student> getAllStudents() {
        if (students.isEmpty()){
            throw new NullPointerException("В списке нет студентов");
        }
        for (Student student: students.values()){
            history.addStudent(student);
        }
        return new ArrayList<>(students.values());
    }

    @Override
    public List<Integer> getStudentIdsBySubject(int subjectId) {
        if(!subjects.containsKey(subjectId)){
            throw new NullPointerException("Такого предмета нет в списке");
        }
        return subjects.get(subjectId).getStudents();
    }

    @Override
    public List<Integer> getTeacherIdsBySubject(int subjectId) {
        if(!subjects.containsKey(subjectId)){
            throw new NullPointerException("Такого предмета нет в списке");
        }
        return subjects.get(subjectId).getTeachers();
    }

    @Override
    public List<Integer> getSubjectIdsByStudent(int studentId) {
        if(!students.containsKey(studentId)){
            throw new NullPointerException("Такого студента нет в списке");
        }
        return students.get(studentId).getSubjects();
    }

    @Override
    public List<Integer> getSubjectIdsByTeacher(int teacherId) {
        if(!teachers.containsKey(teacherId)){
            throw new NullPointerException("Такого студента нет в списке");
        }
        return teachers.get(teacherId).getSubjects();
    }

    @Override
    public Deque<Student> getStudentHistory() {
        return history.getStudentHistory();
    }

    @Override
    public Deque<Teacher> getTeacherHistory() {
        return history.getTeacherHistory();
    }

    @Override
    public Deque<Subject> getSubjectHistory() {
        return history.getSubjectHistory();
    }

    @Override
    public void deleteAllTeachers() {
        if(!teachers.isEmpty()){
            teachers.clear();
        }
    }

    @Override
    public void deleteAllSubjects() {
        if(!subjects.isEmpty()){
            subjects.clear();
        }
    }

    @Override
    public void deleteAllStudents() {
        if(!students.isEmpty()){
            students.clear();
        }
    }

    @Override
    public void addSubjectToStudentById(int studentId, int subjectId) {
        if(!students.containsKey(studentId) || !subjects.containsKey(subjectId)){
            System.out.println("Данного студента или предмета нет в системе");
        } else {
            var subject = subjects.get(subjectId);
            var student = students.get(studentId);
            if (subject.getStudents().contains(studentId)){
                System.out.println("Данный студент уже подключен к этому курсу");
            } else {
                subject.addStudent(studentId);
                student.addSubject(subjectId);
            }
        }
    }

    @Override
    public void addSubjectToTeacherById(int teacherId, int subjectId) {
        if(!teachers.containsKey(teacherId) || !teachers.containsKey(subjectId)){
            System.out.println("Данного преподавателя или предмета нет в системе");
        } else {
            var subject = subjects.get(subjectId);
            var teacher = teachers.get(teacherId);
            if (subject.getTeachers().contains(teacherId)) {
                System.out.println("Данный преподаватель уже подключен к этому курсу");
            } else {
                subject.addTeacher(teacherId);
                teacher.addSubject(subjectId);
            }
        }
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

    //sort entities
    @Override
    public List<Student> sortStudentsByFirstName() {
        return sortingManager.sortStudentsByFirstName(new ArrayList<>(students.values()));
    }

    @Override
    public List<Student> sortStudentsByLastName() {
        return sortingManager.sortStudentsByLastName(new ArrayList<>(students.values()));
    }

    @Override
    public List<Student> sortStudentsByAge() {
        return sortingManager.sortStudentsByAge(new ArrayList<>(students.values()));
    }

    @Override
    public List<Student> sortStudentsByGroup() {
        return sortingManager.sortStudentsByGroup(new ArrayList<>(students.values()));
    }

    @Override
    public List<Student> sortStudentsByEnrollmentDate() {
        return sortingManager.sortStudentsByEnrollmentDate(new ArrayList<>(students.values()));
    }

    @Override
    public List<Teacher> sortTeachersByFirstName() {
        return sortingManager.sortTeachersByFirstName(new ArrayList<>(teachers.values()));
    }

    @Override
    public List<Teacher> sortTeachersByLastName() {
        return sortingManager.sortTeachersByLastName(new ArrayList<>(teachers.values()));
    }

    @Override
    public List<Teacher> sortTeachersByAge() {
        return sortingManager.sortTeachersByAge(new ArrayList<>(teachers.values()));
    }

    @Override
    public List<Teacher> sortTeachersByRetirementDate() {
        return sortingManager.sortTeachersByRetirementDate(new ArrayList<>(teachers.values()));
    }

    @Override
    public List<Subject> sortSubjectsByName() {
        return sortingManager.sortSubjectsByName(new ArrayList<>(subjects.values()));
    }

    @Override
    public List<Subject> sortSubjectsByCredits() {
        return sortingManager.sortSubjectsByCredits(new ArrayList<>(subjects.values()));
    }

    @Override
    public List<Subject> sortSubjectsByCourseDuration() {
        return sortingManager.sortSubjectsByCourseDuration(new ArrayList<>(subjects.values()));
    }

    @Override
    public void deleteAllEntities() {
        deleteAllStudents();
        deleteAllTeachers();
        deleteAllSubjects();
    }

}
