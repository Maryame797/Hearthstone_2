package panels;

import logs.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static administer.Administer.getUser;
import static panels.Collections.setExitButton;
import static panels.ShopPanel.setBackButton;

public class StatusPanel extends JPanel {
    private JButton[] topDecks;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_14;


    public StatusPanel(){
        Log.addToBody("go to","status",getUser());
        setLayout(null);

        setTopDecks();

        setBackButton(this);

        setExitButton(this);

        setInfoBox();

       MainMenu.setBackground(this,"src"+File.separator+"panels"+File.separator+"images"+File.separator+"background.jpg");
    }

  public void setTopDecks(){
      JLabel lblNewLabel = new JLabel("Top decks");
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setForeground(new Color(135, 206, 250));
      lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 25));
      lblNewLabel.setBounds(107, 81, 150, 37);
      add(lblNewLabel);

      topDecks= new JButton[getUser().getTopDecks().size()];
        for (int i = 0 ; i < getUser().getTopDecks().size() ; i++){
            topDecks[i] = new JButton(getUser().getTopDecks().get(i).getName());
            topDecks[i].setForeground(new Color(255, 255, 255));
            topDecks[i].setFont(new Font("American Typewriter", Font.BOLD, 16));
            topDecks[i].setContentAreaFilled(false);
            topDecks[i].setFocusPainted(false);
            topDecks[i].setBorderPainted(false);
            topDecks[i].setHorizontalTextPosition(SwingConstants.CENTER);
            topDecks[i].setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator + getUser().getTopDecks().get(i).getHero().getName() + " deck.jpg"));
            int finalI = i;
            topDecks[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lblNewLabel_8.setText(getUser().getTopDecks().get(finalI).getName());
                    lblNewLabel_9.setText(String.valueOf(getUser().getTopDecks().get(finalI).getRate()*100));
                    lblNewLabel_10.setText(String.valueOf(getUser().getTopDecks().get(finalI).getWins()));
                    lblNewLabel_11.setText(String.valueOf(getUser().getTopDecks().get(finalI).getPlayes()));
                    lblNewLabel_12.setText(String.valueOf(getUser().getTopDecks().get(finalI).getManaAverage()));
                    lblNewLabel_13.setText(getUser().getTopDecks().get(finalI).getHero().getName());
                    lblNewLabel_14.setIcon(getUser().getTopDecks().get(finalI).getTopCard());
                }
            });
            topDecks[i].setBounds(107, 143+(54*i), 150, 42);
            add(topDecks[i]);
        }
  }

  private void setInfoBox(){
      JLabel lblNewLabel_1 = new JLabel("Name:");
      lblNewLabel_1.setForeground(new Color(135, 206, 250));
      lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_1.setBounds(454, 169, 92, 16);
      add(lblNewLabel_1);

      JLabel lblNewLabel_2 = new JLabel("Wining percentage:");
      lblNewLabel_2.setForeground(new Color(135, 206, 250));
      lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_2.setBounds(454, 223, 200, 20);
      add(lblNewLabel_2);

      JLabel lblNewLabel_3 = new JLabel("Won:");
      lblNewLabel_3.setForeground(new Color(135, 206, 250));
      lblNewLabel_3.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_3.setBounds(454, 277, 162, 16);
      add(lblNewLabel_3);

      JLabel lblNewLabel_4 = new JLabel("Played:");
      lblNewLabel_4.setForeground(new Color(135, 206, 250));
      lblNewLabel_4.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_4.setBounds(454, 325, 162, 22);
      add(lblNewLabel_4);

      JLabel lblNewLabel_5 = new JLabel("Mana average:");
      lblNewLabel_5.setForeground(new Color(135, 206, 250));
      lblNewLabel_5.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_5.setBounds(454, 379, 150, 22);
      add(lblNewLabel_5);

      JLabel lblNewLabel_6 = new JLabel("Hero:");
      lblNewLabel_6.setForeground(new Color(135, 206, 250));
      lblNewLabel_6.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_6.setBounds(454, 439, 150, 16);
      add(lblNewLabel_6);

      JLabel lblNewLabel_7 = new JLabel("Top card:");
      lblNewLabel_7.setForeground(new Color(135, 206, 250));
      lblNewLabel_7.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_7.setBounds(454, 625, 162, 16);
      add(lblNewLabel_7);

      lblNewLabel_8 = new JLabel("");
      lblNewLabel_8.setForeground(new Color(255, 255, 255));
      lblNewLabel_8.setBackground(new Color(255, 255, 255));
      lblNewLabel_8.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_8.setBounds(640, 163, 295, 22);
      add(lblNewLabel_8);

      lblNewLabel_9 = new JLabel("");
      lblNewLabel_9.setForeground(new Color(255, 255, 255));
      lblNewLabel_9.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_9.setBounds(640, 217, 305, 22);
      add(lblNewLabel_9);

      lblNewLabel_10 = new JLabel("");
      lblNewLabel_10.setForeground(new Color(255, 255, 255));
      lblNewLabel_10.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_10.setBounds(640, 271, 295, 22);
      add(lblNewLabel_10);

      lblNewLabel_11 = new JLabel("");
      lblNewLabel_11.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_11.setForeground(new Color(255, 255, 255));
      lblNewLabel_11.setBounds(640, 325, 295, 22);
      add(lblNewLabel_11);

      lblNewLabel_12 = new JLabel("");
      lblNewLabel_12.setForeground(new Color(255, 255, 255));
      lblNewLabel_12.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_12.setBounds(640, 379, 295, 22);
      add(lblNewLabel_12);

      lblNewLabel_13 = new JLabel("");
      lblNewLabel_13.setForeground(new Color(255, 255, 255));
      lblNewLabel_13.setFont(new Font("American Typewriter", Font.PLAIN, 18));
      lblNewLabel_13.setBounds(640, 433, 295, 22);
      add(lblNewLabel_13);

      lblNewLabel_14 = new JLabel("");
      lblNewLabel_14.setBounds(592, 491, 200, 277);
      add(lblNewLabel_14);

  }
}
