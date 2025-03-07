package checkedexception;
import java.io.*;

public class checkedexception {
    public static void main(String[] args) {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            while((line = reader.readLine()) != null ){
            System.out.println(line);
        }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        }
    }

