package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static administer.Administer.logIn;
import static administer.Administer.register;


public class StartPanel extends JPanel {
   private static JLabel lblNewLabel_8;
   private static JLabel lblNewLabel_7;
   private static JLabel lblNewLabel_9;
   private JTextField textField;
   JPasswordField passwordField;

    public StartPanel() {
        setLayout(null);

        setUsernameBox();

        setExceptions(this);

        setButtons();

        setLabels();

       MainMenu.setBackground(this,"src"+File.separator+"panels"+File.separator+"images"+File.separator+"start.jpg");

    }

    public static JLabel getLblNewLabel_8() {
        return lblNewLabel_8;
    }

    public static JLabel getLblNewLabel_7() {
        return lblNewLabel_7;
    }

    public static JLabel getLblNewLabel_9() {
        return lblNewLabel_9;
    }

    private static void setExceptions(JPanel panel){
        //Errors
        lblNewLabel_7 = new JLabel("This username is taken, enter another username.");
        lblNewLabel_7.setForeground(new Color(255, 0, 0));
        lblNewLabel_7.setFont(new Font("American Typewriter", Font.PLAIN, 17));
        lblNewLabel_7.setBounds(218, 197, 450, 16);
        panel.add(lblNewLabel_7);
        lblNewLabel_7.setVisible(false);

        //Login error
        lblNewLabel_8 = new JLabel("Password or username is invalid, please try again.");
        lblNewLabel_8.setForeground(new Color(255, 0, 0));
        lblNewLabel_8.setFont(new Font("American Typewriter", Font.PLAIN, 17));
        lblNewLabel_8.setBounds(218, 269, 450, 16);
        panel.add(lblNewLabel_8);
        lblNewLabel_8.setVisible(false);

        //null password error
        lblNewLabel_9 = new JLabel("Please enter password");
        lblNewLabel_9.setForeground(new Color(255, 0, 0));
        lblNewLabel_9.setFont(new Font("American Typewriter", Font.PLAIN, 17));
        lblNewLabel_9.setBounds(218, 269, 225, 16);
        panel.add(lblNewLabel_9);
        lblNewLabel_9.setVisible(false);

    }

    private void setButtons(){
        //register
        JButton btnNewButton = new JButton("Register");
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 21));
        btnNewButton.setForeground(new Color(72, 209, 204));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String pass = passwordField.getText();
                register(name,pass);
            }
        });
        btnNewButton.setBounds(118, 629, 160, 70);
        add(btnNewButton);




        //login
        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton_1.setForeground(new Color(72, 209, 204));
        btnNewButton_1.setFont(new Font("American Typewriter", Font.PLAIN, 21));
        btnNewButton_1.setBackground(new Color(192, 192, 192));
        btnNewButton_1.setBounds(295, 629, 160, 70);
        add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String pass = passwordField.getText();
                logIn(name,pass);
            }
        });
    }

    private void setUsernameBox(){
        //username:
        JLabel lblNewLabel_2 = new JLabel("Username:");
        lblNewLabel_2.setFont(new Font("American Typewriter", Font.BOLD, 25));
        lblNewLabel_2.setForeground(new Color(72, 209, 204));
        lblNewLabel_2.setBounds(56, 137, 207, 70);
        add(lblNewLabel_2);
        textField = new JTextField();
        textField.setBackground(new Color(192, 192, 192));
        textField.setBounds(218, 149, 270, 50);
        textField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        add(textField);
        textField.setColumns(10);
        //password:
        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(192, 192, 192));
        passwordField.setBounds(218, 215, 270, 50);
        passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        add(passwordField);
        JLabel lblNewLabel_3 = new JLabel("Password:");
        lblNewLabel_3.setFont(new Font("American Typewriter", Font.BOLD, 25));
        lblNewLabel_3.setForeground(new Color(72, 209, 204));
        lblNewLabel_3.setBounds(56, 223, 181, 21);
        add(lblNewLabel_3);
    }

    private void setLabels(){
        JLabel lblNewLabel_5 = new JLabel("Hearthstone");
        lblNewLabel_5.setForeground(new Color(72, 209, 204));
        lblNewLabel_5.setFont(new Font("American Typewriter", Font.BOLD, 30));
        lblNewLabel_5.setBounds(127, 43, 270, 50);
        add(lblNewLabel_5);

        JLabel lblNewLabel_1 = new JLabel("If you alreday have an account press login button");
        lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 20));
        lblNewLabel_1.setForeground(new Color(255, 248, 220));
        lblNewLabel_1.setBounds(56, 297, 523, 50);
        add(lblNewLabel_1);

        JLabel lblNewLabel_6 = new JLabel("and if you want to create account press register button");
        lblNewLabel_6.setForeground(new Color(255, 248, 220));
        lblNewLabel_6.setFont(new Font("American Typewriter", Font.PLAIN, 20));
        lblNewLabel_6.setBounds(55, 338, 570, 21);
        add(lblNewLabel_6);

    }
}
