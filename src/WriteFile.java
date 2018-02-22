import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


    public class WriteFile {
        public static void main(String[] args) {
            try {
                String content = "We are going to create this app with all its flyable aircrafts.";
                File file = new File("C:/Users/DMA-Tech/Desktop/inputFile.txt");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                bw.close();

                System.out.println("Finished creating the file.");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}