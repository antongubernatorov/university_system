package ru.gubern.managers;

public class LocalSystemManagerTest extends LocalSystemTest<LocalSystem>{
    @Override
    public LocalSystem createLocalSystem() {
        return new LocalSystem();
    }
}
