package panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static administer.Administer.getUser;
import static administer.Administer.saveInFile;
import static logs.Log.addToBody;
import static panels.CardsPanel.*;
import static panels.Collections.setButtonDivisible;

public class DecksPanel extends JPanel {
    private JPanel panel;
    private JScrollPane scrollPane;
    private static JButton[] deckButton;
    private static JButton newDeck;
    private static int deckNumber = getUser().getUserDecks().size()-1;
    private static boolean createDeck;
    private static boolean editDeck;
    private static boolean editHero;
    private  JButton btnEditHero;
    private  JButton btnDelete;

    public DecksPanel(){
        panel= new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(150,786));
        setDeckButton(panel);
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(170,570));
        add(scrollPane);
        setSize(154,600);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBackground(new Color(205, 133, 63));
        setBackground(new Color(205, 133, 63));
        setBorder(new LineBorder(new Color(205, 133, 63)));
        panel.setBorder(new LineBorder(new Color(205, 133, 63)));
        scrollPane.setBorder(new LineBorder(new Color(205, 133, 63)));
        for (int i = 0; i < getUser().getUserDecks().size(); i++){
            getDeckButton()[i].setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator +getUser().getUserDecks().get(i).getHero().getName()+ " deck.jpg"));
            getDeckButton()[i].setText(getUser().getUserDecks().get(i).getName());
        }
        setCreateButton();
        setEditDeckButton();
        setDeleteButton();
        setEditHeroButton();
    }

    public static int getdeckNumber() {
        return deckNumber;
    }

    public static void setDeckButton(JPanel panel){
        deckButton = new JButton[15];
        for (int i = 0 ; i < 15 ; i++){
            deckButton[i] =new JButton();
            deckButton[i].setBounds(0,146+(43*i),150,41);
            deckButton[i].setForeground(Color.WHITE);
            deckButton[i].setContentAreaFilled(false);
            deckButton[i].setFocusPainted(false);
            deckButton[i].setBorderPainted(false);
            deckButton[i].setHorizontalTextPosition(SwingConstants.CENTER);
            int finalI = i;
            try {
                deckButton[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addToBody("Click_Button",deckButton[finalI].getName()+"_Button",getUser());
                        getUser().setCurrentDeck(getUser().getUserDecks().get(finalI));
                        if (finalI < getUser().getUserDecks().size())
                            setButtonIcon(getUser().getUserDecks().get(finalI).getCardsInDeck());

                    }
                });
            }catch (IndexOutOfBoundsException e ){

            }
            deckButton[i].setFont(new Font("American Typewriter", Font.BOLD, 16));
            panel.add(deckButton[i]);
        }
    }

    public static JButton[] getDeckButton() {
        return deckButton;
    }

    public static JButton getNewDeck() {
        return newDeck;
    }

    public static boolean isCreateDeck() {
        return createDeck;
    }

    public static void setCreateDeck(boolean createDeck) {
        DecksPanel.createDeck = createDeck;
    }

    public static boolean isEditDeck() {
        return editDeck;
    }

    public static void setEditDeck(boolean editDeck) {
        DecksPanel.editDeck = editDeck;
    }

    public void setCreateButton(){

        newDeck = new JButton("New Deck");
        newDeck.setHorizontalTextPosition(SwingConstants.CENTER);
        newDeck.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        newDeck.setFont(new Font("American Typewriter", Font.PLAIN, 16));
        newDeck.setForeground(new Color(0, 0, 139));
        newDeck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBody("Click_Button","New Deck_Button",getUser());
                if (createDeck){
                    setButtonDivisible(getAddCard());
                    setButtonDivisible(getRemoveCard());
                    createDeck=false;
                    newDeck.setText("New Deck");
                    setAddDivisible();
                }else {
                    deckNumber++;
                    if (deckNumber <= 14)
                        new NewDeck();
                    else
                        JOptionPane.showMessageDialog(null,"You have 15 decks and you can't create new deck!");

                }
            }
        });
        newDeck.setContentAreaFilled(false);
        newDeck.setFocusPainted(false);
        newDeck.setBorderPainted(false);
        newDeck.setBounds(0, 0, 155, 36);
        panel.add(newDeck);

    }

    public void setEditDeckButton(){
        JButton btnEditDeck = new JButton("Edit Deck");
        btnEditDeck.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        btnEditDeck.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEditDeck.setFont(new Font("American Typewriter", Font.PLAIN, 16));
        btnEditDeck.setForeground(new Color(0, 0, 139));
        btnEditDeck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                addToBody("edit","deck: "+getUser().getCurrentDeck().getName(),getUser());
                if (btnEditDeck.getText().equals("Finish")) {
                    editDeck = false;
                    btnEditDeck.setText("Edit deck");
                    setButtonIcon(getUser().getCurrentDeck().getCardsInDeck());
                    btnEditHero.setVisible(false);
                     btnDelete.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null,"Choose the deck you want to edit!");
                    btnEditDeck.setText("Finish");
                    editDeck = true;
                    btnEditHero.setVisible(true);
                    btnDelete.setVisible(true);
                }
            }
        });
        btnEditDeck.setFocusPainted(false);
        btnEditDeck.setContentAreaFilled(false);
        btnEditDeck.setBorderPainted(false);
        btnEditDeck.setBounds(0, 37, 155, 36);
        panel.add(btnEditDeck);
    }

    public void setDeleteButton(){
        btnDelete = new JButton("Delete");
        btnDelete.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        btnDelete.setHorizontalTextPosition(SwingConstants.CENTER);
        btnDelete.setFont(new Font("American Typewriter", Font.PLAIN, 16));
        btnDelete.setForeground(new Color(0, 0, 139));
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBody("delete","deck: "+getUser().getCurrentDeck().getName(),getUser());
                getUser().getUserDecks().remove(getUser().getCurrentDeck());
                getUser().setCurrentDeck(null);
                saveInFile();
                setDeckIcon();
            }
        });
        btnDelete.setFocusPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setBorderPainted(false);
        btnDelete.setBounds(0, 74, 155, 36);
        btnDelete.setVisible(false);
        panel.add(btnDelete);
    }

    public void setEditHeroButton(){
        btnEditHero = new JButton("Change Hero");
        btnEditHero.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"button icon.png"));
        btnEditHero.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEditHero.setFont(new Font("American Typewriter", Font.PLAIN, 16));
        btnEditHero.setForeground(new Color(0, 0, 139));
        btnEditHero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBody("Click_Button","Change Hero_Button",getUser());
                editHero = true;
                new NewDeck();
                saveInFile();

            }
        });
        btnEditHero.setFocusPainted(false);
        btnEditHero.setContentAreaFilled(false);
        btnEditHero.setBorderPainted(false);
        btnEditHero.setBounds(0, 110, 155, 36);
        btnEditHero.setVisible(false);
        panel.add(btnEditHero);
    }

    public static boolean isEditHero() {
        return editHero;
    }

    public static void setEditHero(boolean editHero) {
        DecksPanel.editHero = editHero;
    }

    public static void setDeckIcon(){
        for (int i = 0 ; i < 15 ; i++){
            deckButton[i].setIcon(null);
            deckButton[i].setText(null);
        }
        for (int i = 0 ; i < getUser().getUserDecks().size() ; i++){
            deckButton[i].setText(getUser().getUserDecks().get(i).getName());
            deckButton[i].setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+getUser().getUserDecks().get(i).getHero().getName()+" deck.jpg"));
        }
    }
}
