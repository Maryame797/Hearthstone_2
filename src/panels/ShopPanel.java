package panels;

import logs.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static administer.Administer.*;
import static panels.CardsPanel.setButtonIcon;
import static panels.Collections.*;
import static shop.shop.canBuy;
import static shop.shop.canSell;

public class ShopPanel extends JPanel{
    private static boolean buy = false , sell = false;
    private static JLabel gems;
    private static JLabel lblNewLabel_2_1;
    private static JLabel lblNewLabel_2;

    public ShopPanel() {
        Log.addToBody("go to","shop",getUser());
        setLayout(null);
        setLabels();
        setBuyButton();
        setSellButton();
        setExitButton(this);
        setBackButton(this);

        JPanel panel = new CardsPanel();
        panel.setBounds(110,120,870,580);
        add(panel);

        MainMenu.setBackground(this,"src"+File.separator+"panels"+File.separator+"images"+File.separator+"background.jpg");
    }

    public static boolean isBuy() {
        return buy;
    }

    public static boolean isSell() {
        return sell;
    }

    public static void setBuy(boolean buy) {
        ShopPanel.buy = buy;
    }

    public static void setSell(boolean sell) {
        ShopPanel.sell = sell;
    }

    public static JLabel getGemsLabel() {
        return gems;
    }

    private void setLabels(){
        JLabel lblNewLabel = new JLabel("shop");
        lblNewLabel.setForeground(new Color(135, 206, 250));
        lblNewLabel.setFont(new Font("American Typewriter", Font.BOLD, 30));
        lblNewLabel.setBounds(500, 23, 77, 30);
        add(lblNewLabel);

        lblNewLabel_2 = new JLabel("Press the card to buy it!");
        lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 19));
        lblNewLabel_2.setForeground(new Color(255, 0, 0));
        lblNewLabel_2.setBounds(439, 83, 268, 20);
        add(lblNewLabel_2);
        lblNewLabel_2.setVisible(false);

        lblNewLabel_2_1 = new JLabel("Press the card to sell it!");
        lblNewLabel_2_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_2_1.setFont(new Font("American Typewriter", Font.PLAIN, 19));
        lblNewLabel_2_1.setBounds(439, 83, 268, 20);
        add(lblNewLabel_2_1);
        lblNewLabel_2_1.setVisible(false);

        gems = new JLabel("Your gems: " + getUser().getGems());
        gems.setFont(new Font("American Typewriter", Font.PLAIN, 20));
        gems.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"gem.png"));
        gems.setForeground(new Color(135, 206, 250));
        gems.setBounds(450, 693, 250, 100);
        add(gems);


    }
    public static void cardsToBuy(){
        buy = true; sell = false; setCollections(false);
        lblNewLabel_2_1.setVisible(false);
        lblNewLabel_2.setVisible(true);
        setButtonIcon(canBuy(getUser()));
    }

    private void setBuyButton(){

        JButton btnNewButton = new JButton("Buy card");
        btnNewButton.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"buy.png"));
        btnNewButton.setForeground(new Color(135, 206, 250));
        btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 20));
        btnNewButton.setBounds(6, 23, 254, 93);
        add(btnNewButton);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Log.addToBody("Click_Button","Buy_Button",getUser());
                cardsToBuy();
            }
        });
    }

    private void setSellButton(){
        JButton btnNewButton_1 = new JButton("Sell card");
        btnNewButton_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"sell.png"));
        btnNewButton_1.setForeground(new Color(135, 206, 250));
        btnNewButton_1.setFont(new Font("American Typewriter", Font.PLAIN, 20));
        btnNewButton_1.setBounds(854, 39, 240, 60);
        add(btnNewButton_1);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Log.addToBody("Click_Button","Sell_Button",getUser());
                sell= true; buy = false;
                lblNewLabel_2_1.setVisible(true);
                lblNewLabel_2.setVisible(false);
                setButtonIcon(canSell(getUser()));

            }
        });


    }

    public static void setBackButton(JPanel panel){
        JButton btnNewButton_1_2 = new JButton("Back");
        btnNewButton_1_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"back.png"));
        btnNewButton_1_2.setForeground(new Color(135, 206, 250));
        btnNewButton_1_2.setFont(new Font("American Typewriter", Font.PLAIN, 25));
        btnNewButton_1_2.setFocusPainted(false);
        btnNewButton_1_2.setContentAreaFilled(false);
        btnNewButton_1_2.setBorderPainted(false);
        btnNewButton_1_2.setBounds(16, 712, 185, 60);
        panel.add(btnNewButton_1_2);
        btnNewButton_1_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanelOnFrame(new MainMenu(),getFrame());

            }
        });

    }
}
