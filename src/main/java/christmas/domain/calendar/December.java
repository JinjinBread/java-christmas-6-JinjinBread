package christmas.domain.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class December {

    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int CHRISTMAS_DATE = 25;

    private static final String INVALID_DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";

    private final int date;
    private final LocalDate localDate;
    private final DayOfWeek dayOfWeek;

    public December(int date) {
        validateDateRange(date);
        this.date = date;
        this.localDate = LocalDate.of(YEAR, MONTH, date);
        this.dayOfWeek = localDate.getDayOfWeek();
    }

    public int getDate() {
        return date;
    }

    public int calculateDateDifference(int date) {
        return this.date - date;
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

    private void validateDateRange(int date) {
        if (date < 1 || date > 31)
            throw new IllegalArgumentException(INVALID_DATE_ERROR_MESSAGE);
    }

}
