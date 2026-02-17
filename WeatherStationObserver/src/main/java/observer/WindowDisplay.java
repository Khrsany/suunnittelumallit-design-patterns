package observer;

public class WindowDisplay implements Observer {
    private WeatherStation station;

    public WindowDisplay(WeatherStation station) {
        this.station = station;
        station.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println(" Window display updated -> " + station.getTemperature() + " °C");
    }
}