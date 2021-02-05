package calendarific.dto;

public class ResponseDto {
    private final HolidaysDto[] holidays;

    public ResponseDto(HolidaysDto[] holydays) {
        this.holidays = holydays;
    }

    public HolidaysDto[] getHolydays() {
        return holidays;
    }
}
