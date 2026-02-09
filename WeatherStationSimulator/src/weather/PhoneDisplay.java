package weather;

public class PhoneDisplay implements WeatherObserver {

    private final String owner;

    public PhoneDisplay(String owner) {
        this.owner = owner;
    }

    @Override
    public void update(double temperature) {
        System.out.printf("📱 Phone (%s): Temperature = %.2f°C%n",
                owner, temperature);
    }
}

