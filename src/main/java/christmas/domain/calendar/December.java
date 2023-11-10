package christmas.domain.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class December {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int CHRISTMAS_DATE = 25;

    private final int date;
    private final LocalDate localDate;
    private final DayOfWeek dayOfWeek;

    public December(int date) {
        this.date = date;
        this.localDate = LocalDate.of(YEAR, MONTH, date);
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    public boolean isSpecialDay() {
        return (dayOfWeek.equals(DayOfWeek.SUNDAY)) || (localDate.getDayOfMonth() == CHRISTMAS_DATE);
    }

    public boolean isWeekday() {
        return dayOfWeek.equals(DayOfWeek.SUNDAY) || dayOfWeek.equals(DayOfWeek.MONDAY)
                || dayOfWeek.equals(DayOfWeek.TUESDAY) || dayOfWeek.equals(DayOfWeek.WEDNESDAY)
                || dayOfWeek.equals(DayOfWeek.THURSDAY);
    }

    public boolean isWeekend() {
        return dayOfWeek.equals(DayOfWeek.FRIDAY) || dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    public boolean isChristmasPeriod() {
        return localDate.getDayOfMonth() < 26;
    }

}
