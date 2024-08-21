package ru.gubern.managers;

import java.io.File;

public class Manager {
    public static LocalSystem getDefault(){
        return new LocalSystem();
    }
    public static LocalHistory getDefaultHistory(){
        return new LocalHistory();
    }
    public static SortingManager getDefaultSortingManager(){
        return new SortingManager();
    }
    public static FileBackendSystem getDefault(File saveFileStudents, File saveFileTeachers,
                                               File saveFileSubjects, File saveFileStudentsHistory,
                                               File saveFileTeachersHistory, File saveFileSubjectsHistory) {
        return new FileBackendSystem(saveFileStudents, saveFileTeachers, saveFileSubjects,
                saveFileStudentsHistory, saveFileTeachersHistory, saveFileSubjectsHistory);
    }
}
