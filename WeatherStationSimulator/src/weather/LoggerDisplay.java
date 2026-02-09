package weather;

public class LoggerDisplay implements WeatherObserver {

    @Override
    public void update(double temperature) {
        System.out.printf("📝 Logger: Temperature changed to %.2f°C%n",
                temperature);
    }
}
