package panels;

import logs.Log;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static administer.Administer.getUser;
import static logs.Log.addToGameLog;
import static panels.Collections.setExitButton;
import static panels.ShopPanel.setBackButton;

public class GameOver extends JPanel {
    public GameOver() {
        addToGameLog(getUser(),"end");
        Log.addToBody("end","game",getUser());
        setLayout(null);

        setBackButton(this);
        setExitButton(this);


        JLabel lblNewLabel_1 = new JLabel("Your deck is empty!");
        lblNewLabel_1.setForeground(new Color(135, 206, 250));
        lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 30));
        lblNewLabel_1.setBounds(417, 282, 313, 46);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"game over.jpg"));
        lblNewLabel_2.setBounds(0, 0, 1100, 800);
        add(lblNewLabel_2);
    }
}
