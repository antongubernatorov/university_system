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
    public void updateTeacher(Teacher teacher) {
        teachers.put(teacher.getId(), teacher);
    }

    @Override
    public void updateSubject(Subject subject) {
        subjects.put(subject.getId(), subject);
    }

    @Override
    public void updateStudent(Student student) {
        students.put(student.getId(), student);
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
            System.out.println("Данного преподавателя нет в системе");
            return null;
        }
    }

    @Override
    public Student getStudentById(int id) {
        if(students.containsKey(id)){
            history.addStudent(students.get(id));
            return students.get(id);
        } else {
            System.out.println("Данного студента нет в системе");
            return null;
        }
    }

    @Override
    public Subject getSubjectById(int id) {
        if(subjects.containsKey(id)){
            history.addSubject(subjects.get(id));
            return subjects.get(id);
        } else {
            System.out.println("Данного предмета нет в системе");
            return null;
        }
    }

    @Override
    public List<Teacher> getAllTeachers() {
        for (Teacher teacher : teachers.values()){
            history.addTeacher(teacher);
        }
        return new ArrayList<>(teachers.values());
    }

    @Override
    public List<Subject> getAllSubjects() {
        for (Subject subject: subjects.values()){
            history.addSubject(subject);
        }
        return new ArrayList<>(subjects.values());
    }

    @Override
    public List<Student> getAllStudents() {
        for (Student student: students.values()){
            history.addStudent(student);
        }
        return new ArrayList<>(students.values());
    }

    @Override
    public List<Integer> getStudentIdsBySubject(int subjectId) {
        return subjects.get(subjectId).getStudents();
    }

    @Override
    public List<Integer> getTeacherIdsBySubject(int subjectId) {
        return subjects.get(subjectId).getTeachers();
    }

    @Override
    public List<Integer> getSubjectIdsByStudent(int studentId) {
        return students.get(studentId).getSubjects();
    }

    @Override
    public List<Integer> getSubjectIdsByTeacher(int teacherId) {
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
        if(teachers.isEmpty()){
            System.out.println("Список преподавателей пуст");
        } else {
            teachers.clear();
        }
    }

    @Override
    public void deleteAllSubjects() {
        if(subjects.isEmpty()){
            System.out.println("Список предметов пуст");
        } else {
            subjects.clear();
        }
    }

    @Override
    public void deleteAllStudents() {
        if(students.isEmpty()){
            System.out.println("Список студентов пуст");
        } else {
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

}
