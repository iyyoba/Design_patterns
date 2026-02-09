
package weather;

public class WindowDisplay implements WeatherObserver {

    @Override
    public void update(double temperature) {
        System.out.printf("🪟 Window Display: %.2f°C%n", temperature);
    }
}
