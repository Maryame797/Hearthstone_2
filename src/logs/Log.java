package logs;

import player.Player;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    public static void addToBody(String event, String description, Player user) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            FileWriter writer = new FileWriter("src"+File.separator+"logs"+File.separator+"logs"+File.separator + user.getUserName() + "-" + user.getUserID() + ".log", true);
            writer.append("\n" + event + " " + dtf.format(now) + " " + description);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setHeader(Player user) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            FileWriter writer = new FileWriter("src"+File.separator+"logs"+File.separator+"logs"+File.separator+ user.getUserName() + "-" + user.getUserID() + ".log", true);
            writer.write("USER: " + user.getUserName());
            // writer.newLine();
            writer.append("\nCREATED_AT: " + dtf.format(now));
            writer.append("\nPASSWORD: " + user.getPassword());
            writer.append("\n ");
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void addToGameLog(Player user,String event){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        try {
            FileWriter writer = new FileWriter("src"+File.separator+"logs"+File.separator+"gamelogs"+File.separator + user.getUserName() + "-" + user.getUserID() + ".log", true);
            writer.append("\n" + event + " " + dtf.format(now));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }



