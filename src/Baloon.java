import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("This is a new Baloon. It's name is: " + name +
                " and coordinates are: " + coordinates.getHeight() + " " + coordinates.getLatitude() + " " + coordinates.getLongitude());
    }
    public void updateConditions() {
    }
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String message = "Tower Says: Baloon #" + this.getName() + "(" + this.getId() + "): registered to weather tower";
        try(PrintWriter out = new PrintWriter(new FileOutputStream("outputFile.txt", true))){
            out.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Jet Plane registered to weather tower.");
    }
}
