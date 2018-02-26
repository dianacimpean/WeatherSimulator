import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    String message;
    private Boolean unregistered = false;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("This is a new JetPlane. It's name is: " + name +
                " and coordinates are: " + coordinates.getHeight() + " " + coordinates.getLatitude() + " " + coordinates.getLongitude());
    }

    public void updateConditions() {

        weatherTower = new WeatherTower();
        String newWeather = weatherTower.getWeather(coordinates); // this is the currentWeather algorythm

        switch (newWeather) {

            case WeatherType.SUN:
                coordinates.setLatitude(coordinates.getLatitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                message = "JetPlane# " + this.getName() + "(" + this.getId() + "): " + "It is sooo sunny.";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.RAIN:
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                message = "JetPlane#" + this.getName() + "(" + this.getId() + "): " + "It's raining. Better watch out for lightings.";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.FOG:
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                message = "JetPlane#" + this.getName() + "(" + this.getId() + "): " + "Where does this fog come from?";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;

            case WeatherType.SNOW:
                coordinates.setHeight(coordinates.getHeight() - 7);
                message = "JetPlane#" + this.getName() + "(" + this.getId() + "): " + "OMG! Winter is coming!";
                System.out.println("message");
                try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
                    pw.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }

        if (coordinates.getHeight() > 100){
            coordinates.setHeight(100);
        }
        if (coordinates.getHeight() < 0) {
            coordinates.setHeight(0);
        }
        if (coordinates.getHeight() == 0) {
            weatherTower.unregister(this);
            unregistered = true;
            String message = "JetPlane#" + this.getName() + "(" + this.getId() + "): has been unrergistered";
        }
        if (unregistered.equals(true) && coordinates.getHeight()>0) {
            registerTower(weatherTower);
        }
    }

        public void registerTower (WeatherTower weatherTower){
        weatherTower.register(this);
            String message = "Tower Says: JetPlane #" + this.getName() + "(" + this.getId() + "): registered to weather tower";
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File("outputFile.txt"), true))){
            pw.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            System.out.println("Jet Plane registered to weather tower.");
        }
}

