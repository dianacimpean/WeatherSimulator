import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;
    String message;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("This is a new Baloon. It's name is: " + name +
                " and coordinates are: " + coordinates.getHeight() + " " + coordinates.getLatitude() + " " + coordinates.getLongitude());
    }

    public void updateConditions() {

//  SUN - Longitude increases with 2, Height increases with 4
//  RAIN - Height decreases with 5
//  FOG - Height decreases with 3
//  SNOW -Height decreases with 15

        weatherTower = new WeatherTower();
        String newWeather = weatherTower.getWeather(coordinates); // this is the currentWeather algorythm

        switch (newWeather) {

            case WeatherType.SUN:
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                message = "Baloon# " + this.getName() + "(" + this.getId() + "): " + "It is so sunny and hot.";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.RAIN:
                coordinates.setLatitude(coordinates.getLatitude() - 5);
                message = "Baloon#" + this.getName() + "(" + this.getId() + "): " + "Damn you rain! You messed up my baloon.";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.FOG:
                coordinates.setLatitude(coordinates.getLatitude() - 3);
                message = "Baloon#" + this.getName() + "(" + this.getId() + "): " + "Even though it's fog, let's take some pics!";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.SNOW:
                coordinates.setHeight(coordinates.getHeight() - 15);
                message = "Baloon#" + this.getName() + "(" + this.getId() + "): " + " It's snowing. We're gonna crash.\n";
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
        String message = "Tower Says: Baloon #" + this.getName() + "(" + this.getId() + "): registered to weather tower";
        try(PrintWriter out = new PrintWriter(new FileOutputStream("outputFile.txt", true))){
            out.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Jet Plane registered to weather tower.");
    }
}
