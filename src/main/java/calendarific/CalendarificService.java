package calendarific;

import calendarific.dto.DateInfoDto;
import calendarific.dto.DateInfoTimeDto;
import calendarific.dto.HolidaysDto;
import calendarific.model.Holiday;
import io.reactivex.Observable;
import util.observables.ObservableUtils;
import util.requests.HttpRequest;

import java.util.stream.Stream;

public class CalendarificService {

    private final CalendarificWebApi api;

    public CalendarificService(CalendarificWebApi api) {
        this.api = api;
    }

    public CalendarificService() {
        this(new CalendarificWebApi(new HttpRequest()));
    }

    public Observable<Holiday> getHolidays(String country, String year) {
        Stream<String> stream = Stream.of(country);
        return Observable.fromIterable(stream::iterator)
                .map((c -> api.getCalendar(c, year)))
                .concatMap(ObservableUtils::toObservable)
                .concatMap(Observable::fromArray)
                .map(this::createHoliday);
    }

    private Holiday createHoliday(HolidaysDto holidaysDto) {
        String name = holidaysDto.getName();
        String description = holidaysDto.getDescription();
        String locations = holidaysDto.getLocations();
        String states = holidaysDto.getStates();
        String[] type = holidaysDto.getType();
        DateInfoDto dateDto = holidaysDto.getDate();
        String iso = dateDto.getIso();
        DateInfoTimeDto datetime = dateDto.getDatetime();
        String year = datetime.getYear();
        String month = datetime.getMonth();
        String day = datetime.getDay();
        return new Holiday(
                name,
                description,
                iso,
                year,
                month,
                day,
                type,
                locations,
                states
        );
    }


}
