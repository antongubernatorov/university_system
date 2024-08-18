package ru.gubern.utility;

import java.util.ArrayList;

public class IdsToString {
    public static String subjectsIdsToString(ArrayList<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer el : list){
            stringBuilder.append(el).append(";");
        }
        return stringBuilder.toString();
    }
}
