
public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower() {
        return null;
    }

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
    }

    public void registerTower(WeatherTower WeatherTower) {
        System.out.println("Helicopter registered to weather tower.");
    }
}