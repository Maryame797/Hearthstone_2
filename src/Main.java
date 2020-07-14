import administer.Administer;

import java.io.File;

public class Main {
    public static void main (String args[]) {
        File f = new File ("src"+File.separator+ "player" +File.separator+"json");
        if (!f.exists()){
            f.mkdir();
        }
        File f2 = new File ("src"+File.separator+ "logs" +File.separator+"logs");
        if (!f2.exists()){
            f.mkdir();
        }

        File f3= new File("src"+File.separator+ "logs" +File.separator+"gamelogs");
        if (!f3.exists()) {
            f3.mkdir();
        }
       new Administer();

    }
}
