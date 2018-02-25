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

        try{
            br = new BufferedReader(new FileReader("C:/Users/DMA-Tech/Desktop/inputFile.txt"));
            System.out.println("Reading the file using readLine() method:");
//            String contentLine = br.readLine();
            String contentLine = null;
            while ((contentLine = br.readLine()) != null) {
                if (!contentLine.isEmpty()) {
                    String[] splited = contentLine.split(" ");
//                    for (String part : splited) {
                        lines.add(splited);
                        System.out.println(splited);
//                    }
                }
//                System.out.println(contentLine);
//                contentLine = br.readLine();
            }

            for (int i = 1; i<lines.size(); i++) {
                flyables.add(factory.newAircraft(lines.get(i)[0], lines.get(i)[1], Integer.parseInt(lines.get(i)[2]), Integer.parseInt(lines.get(i)[3]), Integer.parseInt(lines.get(i)[4])));
            }

            for (int i = 0; i<flyables.size(); i++) {
                flyables.get(i).registerTower(weatherTower);
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