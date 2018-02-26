import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    String message;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("This is a new Helicopter. It's name is: " + name +
                " and coordinates are: " + coordinates.getHeight() + " " + coordinates.getLatitude() + " " + coordinates.getLongitude());
    }

    public void updateConditions() {

//        SUN - Longitude increases with 10, Height increases with 2
//        RAIN - Longitude increases with 5
//        FOG - Longitude increases with 1
//        SNOW - Height decreases with 12

        weatherTower = new WeatherTower();
        String newWeather = weatherTower.getWeather(coordinates); // this is the currentWeather algorythm

        switch (newWeather) {

            case WeatherType.SUN:
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                message = "Helicopter# " + this.getName() + "(" + this.getId() + "): " + "This is hot.";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.RAIN:
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                message = "Helicopter#" + this.getName() + "(" + this.getId() + "): " + "It's raining. Better watch out for lightings.";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;


            case WeatherType.FOG:
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                message = "Helicopter#" + this.getName() + "(" + this.getId() + "): " + "We can't fly on this fog!";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.SNOW:
                coordinates.setHeight(coordinates.getHeight() - 12);
                message = "Helicopter#" + this.getName() + "(" + this.getId() + "): " + "My rotor is going to freeze!";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

        }
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