package ru.gubern.utility;

import java.time.Period;

public class PeriodToDays {
    public static int castPeriodToDays(Period period) {
        if(period == null) {
            return 0;
        }
        return (period.getYears() * 12 + period.getMonths() * 30 + period.getDays());
    }
}
