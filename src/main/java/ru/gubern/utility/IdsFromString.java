package ru.gubern.utility;

import java.util.ArrayList;

public class IdsFromString {
    public static ArrayList<Integer> GetIdsFromString(String string) {
        ArrayList<Integer> ids = new ArrayList<>();
        String[] entryArray = string.split(";");
        for (String el : entryArray) {
            ids.add(Integer.parseInt(el));
        }
        return ids;
    }
}
