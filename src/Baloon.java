
public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower() {
        return null;
    }

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
    }

    public void registerTower(WeatherTower WeatherTower) {
    }
}
