import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;
    String message;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        System.out.println("This is a new JetPlane. It's name is: " + name +
                " and coordinates are: " + coordinates.getHeight() + " " + coordinates.getLatitude() + " " + coordinates.getLongitude());
    }

    public void updateConditions() {
        weatherTower = new WeatherTower();
        String newWeather = weatherTower.getWeather(coordinates); // this is the currentWeather algorythm

        switch (newWeather) {
            case WeatherType.FOG:
                coordinates.setHeight(coordinates.getHeight() - 3);
                message = "Baloon #" + this.getName() + "(" + this.getId() + "): get us lower, we are flying through pea soup";
                System.out.println(message);
                try (PrintWriter out = new PrintWriter(new FileOutputStream("outputFile.txt", true))) {
                    out.println(message);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
//        if(coordinates.getHeight()<0) {
//            coordinates.setHeight(0);
//        }
//        if(coordinates.getHeight()>100) {
//            coordinates.setHeight(100);
//        }
//        if (coordinates.getHeight()==0) {
//            weatherTower.unregister(this);
//            String text ="Tower Says: Baloon #" + this.getName() + "(" + this.getId() + "): has been unrergistered";
//            try(PrintWriter out = new PrintWriter(new FileOutputStream("outputFile.txt", true))){
//                out.println(text);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

//        if(unregistered.equals(true) && coordinates.getHeight()>0) {
//            registerTower(weatherTower);
//        }
    }

        public void registerTower (WeatherTower weatherTower){
        weatherTower.register(this);
            String message = "Tower Says: JetPlane #" + this.getName() + "(" + this.getId() + "): registered to weather tower";
        try(PrintWriter out = new PrintWriter(new FileOutputStream("outputFile.txt", true))){
            out.println(message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            System.out.println("Jet Plane registered to weather tower.");
        }
}

