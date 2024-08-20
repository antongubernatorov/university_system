package ru.gubern.utility;

import java.time.LocalDateTime;

public class LocalDateParser {
    public static LocalDateTime parseLocalDate(String string){
        if(string.equals("null")) {
            return null;
        } else {
            return LocalDateTime.parse(string);
        }
    }
}
