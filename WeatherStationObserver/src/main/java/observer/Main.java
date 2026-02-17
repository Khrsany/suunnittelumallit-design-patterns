package observer;

public class Main {

    public static void main(String[] args) {

        WeatherStation station = new WeatherStation();

        // useita observeja
        TemperatureDisplay console = new TemperatureDisplay(station);
        PhoneDisplay phone = new PhoneDisplay(station);
        WindowDisplay window = new WindowDisplay(station);

        // käynnistetään weather station omassa threadissa
        Thread t = new Thread(station);
        t.start();
    }
}