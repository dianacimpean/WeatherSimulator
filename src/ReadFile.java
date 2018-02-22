import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("C:/Users/DMA-Tech/Desktop/inputFile.txt"));

            System.out.println("Reading the file using readLine() method:");
            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        finally
        {
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