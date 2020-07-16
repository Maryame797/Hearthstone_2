package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static administer.Administer.*;
import static logs.Log.addToBody;
import static panels.Collections.setCollections;

public class MainMenu  extends JPanel{
    public MainMenu(){
        setLayout(null);
        mainMenuLabel();
        setCollectionsButton();
        setStatusButton();
        setShopButton();
        setPlayButton();
        setExitButton();
        setBackground(this,"src"+File.separator+"panels"+File.separator+"images"+File.separator+"main menu.jpg");
    }
    private void setCollectionsButton(){
        JButton btnNewButton = new JButton();
        btnNewButton.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button.jpg"));
        btnNewButton.setText("Collections");
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton.setForeground(new Color(72, 209, 204));
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanelOnFrame(new Collections(),getFrame());
                addToBody("Click_Button","Collections_Button",getUser());
            }
        });
        btnNewButton.setBounds(39, 177, 160, 74);
        add(btnNewButton);
    }

    private void setStatusButton(){
        JButton btnNewButton_1 = new JButton("Status");
        btnNewButton_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button.jpg"));
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton_1.setForeground(new Color(72, 209, 204));
        btnNewButton_1.setBounds(360, 177, 160, 74);
        add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanelOnFrame(new StatusPanel(),getFrame());
                addToBody("Click_Button","Status_Button",getUser());
            }
        });
    }

    private void setShopButton(){
        JButton btnNewButton_2 = new JButton("shop");
        btnNewButton_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button.jpg"));
        btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2.setContentAreaFilled(false);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setForeground(new Color(72, 209, 204));
        btnNewButton_2.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton_2.setBounds(39, 366, 160, 74);
        add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setCollections(false);
                setPanelOnFrame(new ShopPanel(),getFrame());
                addToBody("Click_Button","Shop_Button",getUser());

            }
        });
    }

    private void setPlayButton(){
        JButton btnNewButton_3 = new JButton("Play");
        btnNewButton_3.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button.jpg"));
        btnNewButton_3.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_3.setContentAreaFilled(false);
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.setBorderPainted(false);
        btnNewButton_3.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton_3.setForeground(new Color(72, 209, 204));
        btnNewButton_3.setBounds(360, 366, 160, 74);
        add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               setPanelOnFrame( new ChooseDeck(),getFrame());
               addToBody("Click_Button","Play_Button",getUser());
            }
        });
    }

    private void setExitButton(){
        JButton btnNewButton_4 = new JButton("Exit");
        btnNewButton_4.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button.jpg"));
        btnNewButton_4.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_4.setContentAreaFilled(false);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setBorderPainted(false);
        btnNewButton_4.setForeground(new Color(72, 209, 204));
        btnNewButton_4.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton_4.setBounds(20, 670, 160, 74);
        add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanelOnFrame(new StartPanel(),getFrame());
                addToBody("exit","",getUser());
            }
        });

    }

    private void mainMenuLabel(){
        JLabel lblNewLabel = new JLabel("Main Menu");
        lblNewLabel.setFont(new Font("American Typewriter", Font.BOLD, 30));
        lblNewLabel.setForeground(new Color(72, 209, 204));
        lblNewLabel.setBounds(190, 45, 224, 54);
        add(lblNewLabel);
    }

    public static void setBackground(JPanel panel, String path){
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(path));
        lblNewLabel_1.setBounds(0, 0, 1100, 800);
        panel.add(lblNewLabel_1);
    }
}
