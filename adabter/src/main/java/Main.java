public class Main {
    public static void main(String[] args) {

        // Client käyttää vain rajapintaa, ei suoraan Calendaria
        NewDateInterface date = new CalendarToNewDateAdapter();

        // Asetetaan alkuperäinen päivämäärä
        date.setDay(8);
        date.setMonth(4);
        date.setYear(2026);

        System.out.println("Alkuperäinen päivämäärä:");
        System.out.println(date.getDay() + "." + date.getMonth() + "." + date.getYear());

        // Siirretään päivää eteenpäin
        date.advanceDays(25);

        System.out.println("Päivämäärä 25 päivän jälkeen:");
        System.out.println(date.getDay() + "." + date.getMonth() + "." + date.getYear());

        // Testataan vielä toinen siirto
        date.advanceDays(10);

        System.out.println("Päivämäärä vielä 10 päivän jälkeen:");
        System.out.println(date.getDay() + "." + date.getMonth() + "." + date.getYear());
    }
}