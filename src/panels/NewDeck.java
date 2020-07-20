package panels;

import characters.*;
import decks.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static administer.Administer.getUser;
import static administer.Administer.saveInFile;
import static logs.Log.addToBody;
import static panels.DecksPanel.*;

public class NewDeck extends JFrame {
    private JTextField textField;
    private Deck newDeck;
    JPanel panel;
    public NewDeck() {
        newDeck = new Deck();
        setPanel();
        setOkButton();
        setNamePart();
        setHeroesPart();

        JLabel lblNewLabel_2 = new JLabel("Then choose the cards you want and press finish button\n");
        lblNewLabel_2.setForeground(new Color(128, 0, 0));
        lblNewLabel_2.setFont(new Font("American Typewriter", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(38, 187, 389, 40);
        panel.add(lblNewLabel_2);

        getContentPane().setLayout(null);
        setSize(450,300);
        add(panel);
        setTitle("New deck");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    private void setOkButton(){
        JButton btnNewButton = new JButton("OK");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setForeground(new Color(128, 0, 0));
        btnNewButton.setFont(new Font("American Typewriter", Font.BOLD, 15));
        btnNewButton.setBounds(164, 239, 117, 33);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditHero()){
                    addToBody("change "+getUser().getCurrentDeck().getName()+" name",textField.getText(),getUser());
                    getUser().getCurrentDeck().setName(textField.getText());
                    setEditHero(false);
                    setDeckIcon();
                    dispose();
                }else {
                    getNewDeck().setText("Finish");
                    setCreateDeck(true);
                    String deckName = textField.getText();
                    newDeck.setName(deckName);
                    getUser().getUserDecks().add(newDeck);
                    getUser().setCurrentDeck(newDeck);
                    getDeckButton()[getdeckNumber()].setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+ newDeck.getHero().getName() + " deck.jpg"));
                    getDeckButton()[getdeckNumber()].setText(deckName);
                    dispose();
                    addToBody("create", "deck: " + deckName, getUser());
                    saveInFile();
                }
            }
        });
        panel.add(btnNewButton);

    }

    private void setNamePart(){
        JLabel lblNewLabel = new JLabel("Name:");
        lblNewLabel.setForeground(new Color(128, 0, 0));
        lblNewLabel.setFont(new Font("American Typewriter", Font.PLAIN, 18));
        lblNewLabel.setBounds(38, 52, 87, 23);
        panel.add(lblNewLabel);

        textField = new JTextField();
        textField.setBackground(new Color(255, 255, 224));
        textField.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        textField.setBounds(144, 52, 236, 23);
        panel.add(textField);
        textField.setColumns(10);
    }

    private void setHeroesPart(){
        JLabel lblNewLabel_1 = new JLabel("Hero:");
        lblNewLabel_1.setForeground(new Color(128, 0, 0));
        lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(38, 108, 61, 23);
        panel.add(lblNewLabel_1);


        ButtonGroup heroes = new ButtonGroup();

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Warlock");
        rdbtnNewRadioButton.setForeground(new Color(205, 133, 63));
        rdbtnNewRadioButton.setFont(new Font("American Typewriter", Font.PLAIN, 15));
        rdbtnNewRadioButton.setBounds(144, 108, 93, 23);
        heroes.add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditHero()) {
                    if (canChangeHero("Warlock")) {
                        addToBody("change "+getUser().getCurrentDeck().getName()+" hero","Warlock",getUser());
                        getUser().getCurrentDeck().setHero(new Warlock());
                    }
                }
                else {
                    newDeck.setHero(new Warlock());
                    addToBody("set "+newDeck.getName()+" hero","Warlock",getUser());
                }
            }
        });
        panel.add(rdbtnNewRadioButton);

        JRadioButton rdbtnRogue = new JRadioButton("Rogue");
        rdbtnRogue.setForeground(new Color(205, 133, 63));
        rdbtnRogue.setFont(new Font("American Typewriter", Font.PLAIN, 15));
        rdbtnRogue.setBounds(335, 108, 93, 23);
        heroes.add(rdbtnRogue);
        rdbtnRogue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditHero()) {
                    if (canChangeHero("Rogue")) {
                        getUser().getCurrentDeck().setHero(new Rogue());
                        addToBody("change "+getUser().getCurrentDeck().getName()+" hero","Rogue",getUser());
                    }
                }
                else {
                    newDeck.setHero(new Rogue());
                    addToBody("set "+newDeck.getName()+" hero","Rogue",getUser());
                }
            }
        });
        panel.add(rdbtnRogue);

        JRadioButton rdbtnMage = new JRadioButton("Mage");
        rdbtnMage.setForeground(new Color(205, 133, 63));
        rdbtnMage.setFont(new Font("American Typewriter", Font.PLAIN, 15));
        rdbtnMage.setBounds(249, 108, 93, 23);
        heroes.add(rdbtnMage);
        rdbtnMage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditHero()) {
                    if (canChangeHero("Mage")) {
                        getUser().getCurrentDeck().setHero(new Mage());
                        addToBody("change "+getUser().getCurrentDeck().getName()+" hero","Mage",getUser());
                    }
                }
                else {
                    newDeck.setHero(new Mage());
                    addToBody("set "+newDeck.getName()+" hero","Mage",getUser());
                }
            }
        });
        panel.add(rdbtnMage);

        JRadioButton rdbtnHunter = new JRadioButton("Hunter");
        rdbtnHunter.setForeground(new Color(205, 133, 63));
        rdbtnHunter.setFont(new Font("American Typewriter", Font.PLAIN, 15));
        rdbtnHunter.setBounds(144, 143, 93, 23);
        heroes.add(rdbtnHunter);
        rdbtnHunter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditHero()) {
                    if (canChangeHero("Hunter")) {
                        getUser().getCurrentDeck().setHero(new Hunter());
                        addToBody("change "+getUser().getCurrentDeck().getName()+" hero","Hunter",getUser());
                    }
                }
                else {
                    newDeck.setHero(new Hunter());
                    addToBody("set "+newDeck.getName()+" hero","Hunter",getUser());
                }
            }
        });
        panel.add(rdbtnHunter);

        JRadioButton rdbtnPriest = new JRadioButton("Priest");
        rdbtnPriest.setForeground(new Color(205, 133, 63));
        rdbtnPriest.setFont(new Font("American Typewriter", Font.PLAIN, 15));
        rdbtnPriest.setBounds(249, 143, 93, 23);
        heroes.add(rdbtnPriest);
        rdbtnPriest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isEditHero()) {
                    if (canChangeHero("Priest")) {
                        getUser().getCurrentDeck().setHero(new Priest());
                        addToBody("change "+getUser().getCurrentDeck().getName()+" hero","Priest",getUser());
                    }
                }
                else {
                    newDeck.setHero(new Priest());
                    addToBody("set " + newDeck.getName() + " hero", "Priest", getUser());
                }
            }
        });
        panel.add(rdbtnPriest);

    }

    private void setPanel(){
        panel = new JPanel();
        panel.setBackground(new Color(245, 222, 179));
        panel.setBounds(0, 0, 450, 278);
        getContentPane().add(panel);
        panel.setLayout(null);

    }

    private boolean canChangeHero(String heroName){
            boolean flag = true;
            for (int i = 0; i < getUser().getCurrentDeck().getCardsInDeck().size(); i++) {
                if (!(getUser().getCurrentDeck().getCardsInDeck().get(i).getHeroClass().equals(heroName) || getUser().getCurrentDeck().getCardsInDeck().get(i).getHeroClass().equals("Neutral"))) {
                    JOptionPane.showMessageDialog(null, "You can't change this deck's hero, you should edit cards first!");
                    flag = false;
                    break;
                }
            }
         return flag;
    }
}
