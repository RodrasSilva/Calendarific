package calendarific.dto;

public class HolidaysDto {

    private final String name;
    private final String description;
    private final DateInfoDto date;
    private final String[] type;
    private final String locations;
    private final String states;

    public HolidaysDto(String name, String description, DateInfoDto date, String[] type, String locations, String states) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.type = type;
        this.locations = locations;
        this.states = states;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public DateInfoDto getDate() {
        return date;
    }

    public String[] getType() {
        return type;
    }

    public String getLocations() {
        return locations;
    }

    public String getStates() {
        return states;
    }
}
