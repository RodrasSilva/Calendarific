package calendarific.model;

import java.util.Arrays;

public class Holiday {
    private final String name;
    private final String description;
    private final String isoDate;
    private final String year;
    private final String month;
    private final String day;
    private final String[] type;
    private final String locations;
    private final String states;

    public Holiday(String name, String description, String isoDate, String year, String month, String day, String[] type, String locations, String states) {
        this.name = name;
        this.description = description;
        this.isoDate = isoDate;
        this.year = year;
        this.month = month;
        this.day = day;
        this.type = type;
        this.locations = locations;
        this.states = states;
    }

    @Override
    public String toString() {
        return "Holiday " + ((name == null) ? " " : "name= " + name) + "\n" +
                ((description == null) ? " " : "\t Description= " + description + "\n") +
                ((isoDate == null) ? " " : "\t Date= " + isoDate + "\n") +
                ((year == null) ? " " : "\t Year= " + year + "\n") +
                ((month == null) ? " " : "\t Month= " + month + "\n") +
                ((day == null) ? " " : "\t Day= " + day + "\n") +
                ((type == null) ? " " : "\t Type= " + Arrays.toString(type) + "\n") +
                ((locations == null) ? " " : "\t Locations= " + locations + "\n") +
                ((states == null) ? " " : "\t States= " + states + "\n") +
                "\n";
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getIsoDate() {
        return isoDate;
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
