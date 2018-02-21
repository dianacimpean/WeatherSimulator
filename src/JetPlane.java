
public class JetPlane extends Aircraft implements Flyable{

    private WeatherTower weatherTower() {
        return null;
    }

    public JetPlane(String name, Coordinates coordinates) {

        super(name, coordinates);
    }

    public void updateConditions() {
    }

    public void registerTower(WeatherTower WeatherTower) {
        System.out.println("Jet Plane registered to weather tower.");
    }
}
