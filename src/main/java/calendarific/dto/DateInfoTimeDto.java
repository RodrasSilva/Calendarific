package calendarific.dto;

public class DateInfoTimeDto {

    private final String year;
    private final String month;
    private final String day;


    public DateInfoTimeDto(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }
}
