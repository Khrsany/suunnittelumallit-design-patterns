import java.util.Calendar;

// Adapteri: ulospäin tämä näyttää NewDateInterface-rajapinnalta,
// mutta sisällä se käyttää valmista Calendar-luokkaa
public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public CalendarToNewDateAdapter() {
        // Otetaan käyttöön nykyinen päivä aluksi
        this.calendar = Calendar.getInstance();
    }

    @Override
    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    @Override
    public void setMonth(int month) {
        // Calendarissa kuukaudet parempi olis 1-12
        calendar.set(Calendar.MONTH, month - 1);
    }

    @Override
    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        // Muutetaan takaisin normaaliin muotoon 1-12
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        // Calendar osaa itse hoitaa kuukauden/vuoden vaihdot oikein
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}