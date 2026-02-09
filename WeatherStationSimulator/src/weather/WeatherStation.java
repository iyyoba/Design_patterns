package weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation extends Thread {

    private final List<WeatherObserver> observers = new ArrayList<>();
    private final Random random = new Random();

    private double temperature;

    private static final double MIN_TEMP = -20.0;
    private static final double MAX_TEMP = 40.0;

    public WeatherStation() {
        temperature = MIN_TEMP + (MAX_TEMP - MIN_TEMP) * random.nextDouble();
        System.out.printf("WeatherStation initialized at %.2f°C%n", temperature);
    }

    public synchronized void registerObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public synchronized void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private synchronized void notifyObservers() {
        for (WeatherObserver observer : observers) {
            observer.update(temperature);
        }
    }

    private synchronized void updateTemperature() {
        int delta = random.nextBoolean() ? 1 : -1;
        temperature += delta;

        if (temperature < MIN_TEMP) {
            temperature = MIN_TEMP;
        } else if (temperature > MAX_TEMP) {
            temperature = MAX_TEMP;
        }

        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            try {
                int sleepTime = 1000 + random.nextInt(4000);
                Thread.sleep(sleepTime);
                updateTemperature();
            } catch (InterruptedException e) {
                System.out.println("WeatherStation stopped.");
                break;
            }
        }
    }
}
