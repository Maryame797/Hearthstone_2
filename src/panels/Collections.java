package panels;

import cards.Card;
import logs.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static administer.Administer.*;
import static cards.Card.getAllCards;
import static cards.Card.getNeutralCards;
import static characters.Hunter.hunterCards;
import static characters.Mage.mageCards;
import static characters.Priest.priestCards;
import static characters.Rogue.rogueCards;
import static characters.Warlock.warlockCards;
import static logs.Log.addToBody;
import static panels.CardsPanel.setButtonIcon;
import static panels.DecksPanel.setCreateDeck;
import static panels.DecksPanel.setEditDeck;
import static panels.ShopPanel.*;
import static shop.shop.canBuy;

public class Collections extends JPanel{
    private static boolean collections ;
    private ButtonGroup buttonGroup;
    private ArrayList<Card> mana;
    private ArrayList<Card> search;
   // private static String[]

    public Collections(){
        Log.addToBody("go to","collections",getUser());
        mana = new ArrayList<>();
        search = new ArrayList<>();
        setSell(false); setBuy(false); collections = true; setEditDeck(false); setCreateDeck(false);
        buttonGroup = new ButtonGroup();
         new JPanel();
         setLayout(null);

         setWarlockButton();

         setMagebutton();

         setRogueButton();

         setHunterButton();

         setPriestButton();

         setNeutralButton();

         setAllCardsButton();

         setManaFilter();

         setSearchBar();

         setBackButton(this);

         setExitButton(this);

         setRadioButtons();

         setDecksPanel();

        //cards panel
        JPanel panel = new CardsPanel();
        panel.setBounds(10,120,870,580);
        add(panel);

        MainMenu.setBackground(this,"src"+File.separator+"panels"+File.separator+"images"+File.separator+"background.jpg");

    }

    public static boolean isCollections() {
        return collections;
    }

    public static void setCollections(boolean collections) {
        Collections.collections = collections;
    }

    public static String cardPath(Card card){
        if (isCollections()) {
            if (getUser().getCurrentCards().contains(card))
                return "src" + File.separator + "panels" + File.separator + "cardimages" + File.separator + card.getName() + ".png";
            else
                return "src" + File.separator + "panels" + File.separator + "cardimages" + File.separator + card.getName() + "2.png";
        }else return "src" + File.separator + "panels" + File.separator + "cardimages" + File.separator + card.getName() + ".png";
    }

    private void setWarlockButton(){
        JButton btnNewButton = new JButton();
        btnNewButton.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"warlock icon.png"));
        btnNewButton.setBounds(123, 19, 117, 81);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(warlockCards());
                addToBody("Click_Button","Warlock Cards_Button",getUser());
            }
        });

        JLabel lblNewLabel = new JLabel("Warlock");
        lblNewLabel.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel.setForeground(new Color(72, 209, 204));
        lblNewLabel.setBounds(134, 95, 87, 16);
        add(lblNewLabel);

    }

    private void setMagebutton(){
        JButton btnNewButton_1 = new JButton();
        btnNewButton_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"mage icon.png"));
        btnNewButton_1.setBounds(243, 19, 117, 81);
        btnNewButton_1.setContentAreaFilled(false);
        btnNewButton_1.setFocusPainted(false);
        btnNewButton_1.setBorderPainted(false);
        add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBody("Click_Button","Mage Cards_Button",getUser());
               setButtonIcon(mageCards());
            }
        });
        JLabel lblNewLabel_1 = new JLabel("Mage");
        lblNewLabel_1.setForeground(new Color(72, 209, 204));
        lblNewLabel_1.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel_1.setBounds(267, 95, 61, 16);
        add(lblNewLabel_1);

    }

    private void setRogueButton(){
        JButton btnNewButton_2 = new JButton();
        btnNewButton_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"rogue icon.png"));
        btnNewButton_2.setBounds(360, 19, 117, 81);
        btnNewButton_2.setContentAreaFilled(false);
        btnNewButton_2.setFocusPainted(false);
        btnNewButton_2.setBorderPainted(false);
        add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(rogueCards());
                addToBody("Click_Button","Rogue Cards_Button",getUser());
            }
        });
        JLabel lblNewLabel_2 = new JLabel("Rogue");
        lblNewLabel_2.setForeground(new Color(72, 209, 204));
        lblNewLabel_2.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel_2.setBounds(387, 95, 61, 16);
        add(lblNewLabel_2);

    }

    private void setHunterButton(){
        JButton btnNewButton_3 = new JButton();
        btnNewButton_3.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"hunter icon.png"));
        btnNewButton_3.setBounds(482, 19, 117, 81);
        btnNewButton_3.setContentAreaFilled(false);
        btnNewButton_3.setFocusPainted(false);
        btnNewButton_3.setBorderPainted(false);
        add(btnNewButton_3);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(hunterCards());
                addToBody("Click_Button","Hunter Cards_Button",getUser());
            }
        });
        JLabel lblNewLabel_3 = new JLabel("Hunter");
        lblNewLabel_3.setForeground(new Color(72, 209, 204));
        lblNewLabel_3.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel_3.setBounds(504, 95, 61, 16);
        add(lblNewLabel_3);

    }

    private void setPriestButton(){
        JButton btnNewButton_4 = new JButton();
        btnNewButton_4.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"priest icon.png"));
        btnNewButton_4.setBounds(600, 19, 117, 81);
        btnNewButton_4.setContentAreaFilled(false);
        btnNewButton_4.setFocusPainted(false);
        btnNewButton_4.setBorderPainted(false);
        add(btnNewButton_4);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(priestCards());
                addToBody("Click_Button","Priest Cards_Button",getUser());
            }
        });
        JLabel lblNewLabel_4 = new JLabel("Priest");
        lblNewLabel_4.setForeground(new Color(72, 209, 204));
        lblNewLabel_4.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel_4.setBounds(628, 95, 61, 16);
        add(lblNewLabel_4);
    }

    private void setNeutralButton(){
        JButton btnNewButton_5 = new JButton("");
        btnNewButton_5.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"neutral icon.png"));
        btnNewButton_5.setBounds(711, 19, 117, 81);
        btnNewButton_5.setContentAreaFilled(false);
        btnNewButton_5.setFocusPainted(false);
        btnNewButton_5.setBorderPainted(false);
        add(btnNewButton_5);
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(getNeutralCards());
                addToBody("Click_Button","Neutral Cards_Button",getUser());
            }
        });
        JLabel lblNewLabel_5 = new JLabel("Neutral");
        lblNewLabel_5.setForeground(new Color(72, 209, 204));
        lblNewLabel_5.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel_5.setBounds(734, 95, 61, 16);
        add(lblNewLabel_5);

    }

    private void setAllCardsButton(){
        JButton btnNewButton_6 = new JButton("");
        btnNewButton_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               setButtonIcon(getAllCards());
                addToBody("Click_Button","All Cards_Button",getUser());
            }
        });
        btnNewButton_6.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"hearthstone-logo.png"));
        btnNewButton_6.setContentAreaFilled(false);
        btnNewButton_6.setFocusPainted(false);
        btnNewButton_6.setBorderPainted(false);
        btnNewButton_6.setBounds(6, 18, 117, 81);
        add(btnNewButton_6);
        JLabel lblNewLabel_6 = new JLabel("All cards");
        lblNewLabel_6.setForeground(new Color(72, 209, 204));
        lblNewLabel_6.setFont(new Font("American Typewriter", Font.BOLD, 15));
        lblNewLabel_6.setBounds(29, 94, 88, 16);
        add(lblNewLabel_6);


    }

    private void setManaFilter(){
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"mana.png"));
        lblNewLabel_7.setBounds(178, 717, 55, 54);
        add(lblNewLabel_7);

        JTextField textField = new JTextField();
        textField.setBounds(221, 731, 55, 26);
        add(textField);
        textField.setColumns(10);

        JButton btnNewButton_7 = new JButton("OK");
        btnNewButton_7.setForeground(new Color(255, 165, 0));
        btnNewButton_7.setFont(new Font("American Typewriter", Font.PLAIN, 13));
        btnNewButton_7.setBounds(276, 731, 43, 29);
        add(btnNewButton_7);
        btnNewButton_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  throws NumberFormatException{
                addToBody("Click_Button","Mana Filter_Button",getUser());
                mana.clear();
                for (int i = 0 ; i < getAllCards().size() ; i++) {
                    if (getAllCards().get(i).getManaCost() == Integer.parseInt(textField.getText())) {
                        mana.add(getAllCards().get(i));
                    }
                }
                setButtonIcon(mana);
            }
        });
        buttonGroup.add(btnNewButton_7);
    }

    private void setSearchBar(){
        JLabel lblNewLabel_8 = new JLabel("");
        lblNewLabel_8.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"search.png"));
        lblNewLabel_8.setBounds(354, 717, 61, 54);
        add(lblNewLabel_8);

        JTextField textField_1 = new JTextField();
        textField_1.setBounds(404, 731, 130, 26);
        add(textField_1);
        textField_1.setColumns(10);

        JButton btnNewButton_8 = new JButton("Search");
        btnNewButton_8.setForeground(new Color(255, 165, 0));
        btnNewButton_8.setFont(new Font("American Typewriter", Font.PLAIN, 13));
        btnNewButton_8.setBounds(535, 732, 79, 29);
        add(btnNewButton_8);
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToBody("Click_Button","Serach_Button",getUser());
                search.clear();
                int j = textField_1.getText().length();
                for (int i = 0; i < getAllCards().size() ; i++){
                    for (int s = 0 ; s < getAllCards().get(i).getName().length() - j+1; s++) {
                        if (getAllCards().get(i).getName().substring(s,s+j).equalsIgnoreCase(textField_1.getText())){
                           search.add(getAllCards().get(i));
                            break;
                        }
                    }
                }
                setButtonIcon(search);
            }
        });
        buttonGroup.add(btnNewButton_8);

    }

    private void setRadioButtons(){
        JRadioButton rdbtnNewRadioButton = new JRadioButton("cards you have");
        rdbtnNewRadioButton.setForeground(new Color(255, 165, 0));
        rdbtnNewRadioButton.setFont(new Font("American Typewriter", Font.PLAIN, 13));
        rdbtnNewRadioButton.setBounds(626, 733, 141, 23);
        add(rdbtnNewRadioButton);
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(getUser().getCurrentCards());
                addToBody("Click_Button","cards you have_Button",getUser());
            }
        });

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("cards you don't have");
        rdbtnNewRadioButton_1.setForeground(new Color(255, 165, 0));
        rdbtnNewRadioButton_1.setFont(new Font("American Typewriter", Font.PLAIN, 13));
        rdbtnNewRadioButton_1.setBounds(766, 733, 177, 23);
        add(rdbtnNewRadioButton_1);
        rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setButtonIcon(canBuy(getUser()));
                addToBody("Click_Button","cards you don't have_Button",getUser());
            }
        });
        buttonGroup.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton_1);

    }

    private void setDecksPanel(){
        JPanel panel1 = new DecksPanel();
        panel1.setBounds(913,120,170,580);
        add(panel1);
        JLabel lblNewLabel_9 = new JLabel("My decks");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setFont(new Font("American Typewriter", Font.PLAIN, 25));
        lblNewLabel_9.setForeground(new Color(135, 206, 250));
        lblNewLabel_9.setBounds(920, 60, 148, 39);
        add(lblNewLabel_9);
    }

    public static void setButtonDivisible(JButton[] buttons){
        for (int i = 0 ; i < buttons.length ; i++)
            buttons[i].setVisible(false);
    }

    public static void goToShop(String cardName){
        for (int i = 0 ; i < canBuy(getUser()).size(); i++){
            if(canBuy(getUser()).get(i).getName().equals(cardName)){
                addToBody("Click_Button","Card_Button",getUser());
                setPanelOnFrame(new ShopPanel(),getFrame());
                cardsToBuy();
            }
        }
    }

    public static void setExitButton(JPanel panel){
        JButton btnNewButton_1_1 = new JButton("Exit");
        btnNewButton_1_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"exit.png"));
        btnNewButton_1_1.setForeground(new Color(135, 206, 250));
        btnNewButton_1_1.setFont(new Font("American Typewriter", Font.PLAIN, 25));
        btnNewButton_1_1.setFocusPainted(false);
        btnNewButton_1_1.setContentAreaFilled(false);
        btnNewButton_1_1.setBorderPainted(false);
        btnNewButton_1_1.setBounds(915, 706, 185, 73);
        panel.add(btnNewButton_1_1);
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanelOnFrame(new StartPanel(),getFrame());
                addToBody("exit","",getUser());
            }
        });
    }
}
