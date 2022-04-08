import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Reader {
    public Queue<String> read(String name) {
        Queue<String> res = new LinkedList<>();
        try {
            File myObj = new File(name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] lines = data.split(" ");
                res.addAll(Arrays.asList(lines));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }
}

