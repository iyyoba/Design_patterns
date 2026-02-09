package weather;

public class WeatherSimulation {

    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();

        WeatherObserver phone = new PhoneDisplay("Alice");
        WeatherObserver window = new WindowDisplay();
        WeatherObserver logger = new LoggerDisplay();

        station.registerObserver(phone);
        station.registerObserver(window);
        station.registerObserver(logger);

        station.start();

        Thread.sleep(15000);

        System.out.println("\n--- Removing Window Display ---\n");
        station.removeObserver(window);

        Thread.sleep(15000);

        System.out.println("\n--- Ending Simulation ---\n");
        station.interrupt();
    }
}
