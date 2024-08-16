package ru.gubern.managers;

public class Manager {
    public static LocalSystem getDefault(){
        return new LocalSystem();
    }
    public static LocalHistory getDefaultHistory(){
        return new LocalHistory();
    }
}
