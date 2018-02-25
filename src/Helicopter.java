import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("This is a new Helicopter. It's name is: " + name +
                " and coordinates are: " + coordinates.getHeight() + " " + coordinates.getLatitude() + " " + coordinates.getLongitude());
    }

    public void updateConditions() {
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String message = "Tower Says: Helicopter #" + this.getName() + "(" + this.getId() + "): registered to weather tower";
        try(PrintWriter out = new PrintWriter(new FileOutputStream("outputFile.txt", true))){
            out.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Jet Plane registered to weather tower.");
    }
}