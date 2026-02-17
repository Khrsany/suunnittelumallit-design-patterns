package observer;

public class TemperatureDisplay implements Observer {
    private WeatherStation weatherStation;

    public TemperatureDisplay(WeatherStation station) {
        this.weatherStation = station;
        station.registerObserver(this);

    }

    @Override
    public void update() {
        System.out.println("Temperature: " + weatherStation.getTemperature());
    }
}
