package calendarific;

import calendarific.model.Holiday;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import org.junit.Assert;
import org.junit.Test;

public class HolidaysTests {

    @Test
    public void getHolidaysForPortugalIn2019() {
        CalendarificService service = new CalendarificService();
        Observable<Holiday> portugal = service.getHolidays("Portugal", "2019");
        Assert.assertEquals("New Year's Day", portugal.blockingFirst().getName());
    }

    @Test
    public void printAllHolidaysForPortugalIn2019() {
        CalendarificService service = new CalendarificService();
        Observable<Holiday> portugal = service.getHolidays("Portugal", "2019");
        portugal.forEach(System.out::println);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            // nothing
        }
    }
}
