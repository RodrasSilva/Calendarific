package calendarific.dto;

public class DateInfoDto {

    private final String iso;
    private final DateInfoTimeDto datetime;

    public DateInfoDto(String iso, DateInfoTimeDto datetime) {
        this.iso = iso;
        this.datetime = datetime;
    }

    public String getIso() {
        return iso;
    }

    public DateInfoTimeDto getDatetime() {
        return datetime;
    }
}
