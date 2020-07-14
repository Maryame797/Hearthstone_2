package panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

import static administer.Administer.*;
import static administer.Constants.INFO_PASSIVES;
import static logs.Log.addToBody;
import static panels.BoardPanel.setPassive;
import static panels.Collections.setExitButton;
import static panels.ShopPanel.setBackButton;
public class ChooseDeck extends JPanel {
    JButton[] decks;
    public ChooseDeck() {
        setLayout(null);
        setDeckButton();
        setExitButton(this);
        setBackButton(this);
        setInfoPassive();

        JLabel lblNewLabel = new JLabel("Choose Info Passive:");
        lblNewLabel.setForeground(new Color(135, 206, 250));
        lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        lblNewLabel.setBounds(165, 26, 304, 16);
        add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Choose the deck you want to play with:");
        lblNewLabel_1.setForeground(new Color(135, 206, 250));
        lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        lblNewLabel_1.setBounds(600, 26, 754, 16);
        add(lblNewLabel_1);
        MainMenu.setBackground(this, "src"+File.separator+"panels"+File.separator+"images"+File.separator+"background.jpg");

    }

    private void setDeckButton() {
        decks = new JButton[getUser().getUserDecks().size()];
        for (int i = 0; i < getUser().getUserDecks().size(); i++) {
            decks[i] = new JButton();
            decks[i].setBounds(673, 70 + (48 * i), 150, 41);
            decks[i].setForeground(Color.WHITE);
            decks[i].setContentAreaFilled(false);
            decks[i].setFocusPainted(false);
            decks[i].setBorderPainted(false);
            decks[i].setHorizontalTextPosition(SwingConstants.CENTER);
            decks[i].setText(getUser().getUserDecks().get(i).getName());
            decks[i].setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator + getUser().getUserDecks().get(i).getHero().getName() + " deck.jpg"));
            int finalI = i;
            try {
                int finalI1 = i;
                decks[i].addActionListener(new ActionListener()  {
                    public void actionPerformed(ActionEvent e) {
                        if (getUser().getUserDecks().get(finalI1).getCardsInDeck().size()==15) {
                            addToBody("choose game deck:",decks[finalI1].getName(),getUser());
                            getUser().setGameDeck(getUser().getUserDecks().get(finalI1));
                            setPanelOnFrame(new BoardPanel(), getFrame());
                        }else
                            JOptionPane.showMessageDialog(null,"Your deck should have 15 cards to start the game!");
                    }
                });
            } catch (IndexOutOfBoundsException e) {

            }
            decks[i].setFont(new Font("American Typewriter", Font.BOLD, 16));
            add(decks[i]);

        }

    }

    private void setInfoPassive(){


        int [] a = new int[3];
        Random random = new Random();
        for(int j=0; j<3; j++) {
            boolean f;
            do {
                a[j] = random.nextInt(4);
                f = false;
                for(int i=j-1; i>=0; i--) {
                    if(a[i]==a[j]) {
                        f = true;
                        break;
                    }
                }
            } while (f);
        }


        JButton btnNewButton = new JButton(INFO_PASSIVES[a[0]]);
        btnNewButton.setBounds(186, 70, 153, 60);
        btnNewButton.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setForeground(new Color(53, 68, 209));
        btnNewButton.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPassive(btnNewButton.getText());
                addToBody("info_passive",INFO_PASSIVES[a[0]],getUser());
            }
        });
        add(btnNewButton);

        JButton btnNewButton_1 = new JButton(INFO_PASSIVES[a[1]]);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBounds(186, 188, 153, 60);
        btnNewButton_1.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton_1.setForeground(new Color(53, 68, 209));
        btnNewButton_1.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPassive(btnNewButton_1.getText());
                addToBody("info_passive",INFO_PASSIVES[a[1]],getUser());
            }
        });

        JButton btnNewButton_2 = new JButton(INFO_PASSIVES[a[2]]);
        btnNewButton_2.setContentAreaFilled(false);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setHorizontalTextPosition(SwingConstants.CENTER);
        btnNewButton_2.setFont(new Font("American Typewriter", Font.PLAIN, 22));
        btnNewButton_2.setBounds(186, 306, 153, 60);
        btnNewButton_2.setForeground(new Color(53, 68, 209));
        btnNewButton_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPassive(btnNewButton_2.getText());
                addToBody("info_passive",INFO_PASSIVES[a[2]],getUser());
            }
        });
        add(btnNewButton_2);


    }
}
