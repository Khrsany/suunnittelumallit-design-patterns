package observer;

public class PhoneDisplay implements Observer {
    private WeatherStation station;

    public PhoneDisplay(WeatherStation station) {
        this.station = station;
        station.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println(" Phone display: temperature is " + station.getTemperature());
    }
}