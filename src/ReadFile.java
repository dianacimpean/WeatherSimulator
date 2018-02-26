import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static void main(String[] args) {
        BufferedReader br = null;
        List<String[]> lines = new ArrayList<>();
        WeatherTower weatherTower = new WeatherTower();
        ArrayList<Flyable> flyables = new ArrayList<Flyable>();
        Factory factory = new Factory() {};
        WriteFile writeFile = new WriteFile();

        try{
            br = new BufferedReader(new FileReader("C:/Users/DMA-Tech/Desktop/inputFile.txt"));
            System.out.println("Reading the file using readLine() method:");

            int runNumber = Integer.parseInt(br.readLine());
            System.out.println("Firstline is : " + runNumber);

            String contentLine = null;
            while ((contentLine = br.readLine()) != null) {
                if (!contentLine.isEmpty()) {
                    String[] splited = contentLine.split(" ");
                        lines.add(splited);
                        System.out.println(splited);
                }
            }

            for (int i = 1; i < lines.size(); i++) {
                flyables.add(factory.newAircraft(lines.get(i)[0], lines.get(i)[1], Integer.parseInt(lines.get(i)[2]), Integer.parseInt(lines.get(i)[3]), Integer.parseInt(lines.get(i)[4])));
            }

            for (int x = 0; x < flyables.size(); x++) {
                flyables.get(x).registerTower(weatherTower);
            }

            for (int y = 1; y <= runNumber; y++){
                weatherTower.changeWeather();
            }
        }

        catch (IOException ioe) {
            System.out.println("There was a problem: " + ioe);
            ioe.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException ioe)
            {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }
}