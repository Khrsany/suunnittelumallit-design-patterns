package observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Runnable {

    private List<Observer> observers = new ArrayList<>();
    private double temperature;

    private final double MIN_TEMP = -20;
    private final double MAX_TEMP = 40;

    public WeatherStation() {
        temperature = MIN_TEMP + Math.random() * (MAX_TEMP - MIN_TEMP);
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update();
        }
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int sleepTime = 1000 + (int)(Math.random() * 4000);
                Thread.sleep(sleepTime);

                double change = Math.random() < 0.5 ? -1 : 1;
                double newTemp = temperature + change;

                if (newTemp < MIN_TEMP) newTemp = MIN_TEMP;
                if (newTemp > MAX_TEMP) newTemp = MAX_TEMP;

                setTemperature(newTemp);

            } catch (InterruptedException e) {
                break;
            }
        }
    }
}