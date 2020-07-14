package panels;

import cards.Card;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static administer.Administer.*;
import static administer.Constants.NORMAL_CARD_HEIGHT;
import static administer.Constants.NORMAL_CARD_WIDTH;
import static cards.Card.getAllCards;
import static panels.Collections.cardPath;
import static panels.Collections.goToShop;
import static panels.DecksPanel.isCreateDeck;
import static panels.DecksPanel.isEditDeck;
import static panels.ShopPanel.*;
import static shop.shop.buyCard;
import static shop.shop.sellCard;

public class CardsPanel extends JPanel {
    private JPanel panel;
    private JScrollPane scrollPane;
    private static JButton [] cardButton;
    private static JLabel[] cardPrice;
    private static JButton[] addCard;
    private static JButton[] removeCard;
    private static String[] cardName;

    public CardsPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(820,2935));
        setCardButton();
        setCardPrice();
        setAddCard();
        setRemoveCard();
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(860,570));
        add(scrollPane);
        setSize(870,600);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBackground(new Color(205, 133, 63));
        setBackground(new Color(205, 133, 63));
        setBorder(new LineBorder(new Color(205, 133, 63)));
        panel.setBorder(new LineBorder(new Color(205, 133, 63)));
        scrollPane.setBorder(new LineBorder(new Color(205, 133, 63)));
    }

    public static JButton[] getCardButton() {
        return cardButton;
    }

    public void buy(int i){
        if (isBuy()) {
            buyCard(getUser(), i);
            cardButton[i].setIcon(null);
            getGemsLabel().setText("Your gems: "+ getUser().getGems());
        }
    }

    public void sell (int i ){
        if (isSell()){
            sellCard(getUser(),i);
            cardButton[i].setIcon(null);
            getGemsLabel().setText("Your gems: "+ getUser().getGems());
        }
    }

    private void setCardButton(){
        cardButton = new JButton[37];
        cardName = new String[37];
        int i = 0; int t =0;
        for (int z =0 ; z < 4 ; z ++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                cardButton[i] = new JButton();
                cardButton[i].setBounds(6 + (204 * z), 6 + (292 * j), NORMAL_CARD_WIDTH, NORMAL_CARD_HEIGHT);
                int finalI = i;
                cardButton[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
                        buy(finalI);
                        sell(finalI);
                        goToShop(cardName[finalI]);

                    }
                });
                panel.add(cardButton[i]);
                cardButton[i].setContentAreaFilled(false);
                cardButton[i].setFocusPainted(false);
                cardButton[i].setBorderPainted(false);
                i += 4;
            }
            t++;
        }
        cardButton[36] = new JButton();
        cardButton[36].setBounds(6,2634,NORMAL_CARD_WIDTH,NORMAL_CARD_HEIGHT);
        panel.add(cardButton[36]);
        cardButton[36].setContentAreaFilled(false);
        cardButton[36].setFocusPainted(false);
        cardButton[36].setBorderPainted(false);
        cardButton[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
                buy(36);
                sell(36);
                goToShop(cardName[36]);
            }
        });
    }

    private void setCardPrice(){
        cardPrice = new JLabel[37];

        int i = 0; int t = 0;
        for (int z =0 ; z < 4 ; z ++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                cardPrice[i] = new JLabel("Price: 50");
                cardPrice[i].setBounds(76 + (204 * z), 282 + (292 * j), 80, 16);
                cardPrice[i].setFont(new Font("American Typewriter", Font.PLAIN, 15));
                cardPrice[i].setForeground(new Color(135, 206, 250));
                panel.add(cardPrice[i]);
                cardPrice[i].setVisible(false);
                i += 4;
            }
            t++;
        }
        cardPrice[36] = new JLabel("Price: 50");
        cardPrice[36].setBounds(76,2914,80,16);
        cardPrice[36].setFont(new Font("American Typewriter", Font.PLAIN, 15));
        cardPrice[36].setForeground(new Color(135, 206, 250));
        panel.add(cardPrice[36]);
        cardPrice[36].setVisible(false);


    }

    private void setAddCard(){
        addCard = new JButton[37];
        int i = 0; int t = 0;
        for (int z =0 ; z < 4 ; z ++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                addCard[i] = new JButton("Add");
                addCard[i].setBounds(8 + (204 * z), 280 + (292 * j), 103, 29);
                addCard[i].setFont(new Font("American Typewriter", Font.BOLD, 15));
                addCard[i].setForeground(new Color(135, 206, 250));
                int finalI = i;
                addCard[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (getUser().getCurrentDeck().getCardsInDeck().size()>15)
                            JOptionPane.showMessageDialog(null,"Your deck is full!");
                        else
                        addInDeck(getUser(),cardName[finalI]);
                    }
                });
                panel.add(addCard[i]);
                addCard[i].setContentAreaFilled(false);
                addCard[i].setFocusPainted(false);
                addCard[i].setBorderPainted(false);
                addCard[i].setVisible(false);
                cardPrice[i].setVisible(false);
                i += 4;
            }
            t++;
        }
        addCard[36] = new JButton("Add");
        addCard[36].setBounds(8,2914,103,29);
        addCard[36].setFont(new Font("American Typewriter", Font.BOLD, 15));
        addCard[36].setForeground(new Color(135, 206, 250));
        addCard[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addInDeck(getUser(),cardName[36]);
            }
        });
        addCard[36].setContentAreaFilled(false);
        addCard[36].setFocusPainted(false);
        addCard[36].setBorderPainted(false);
        panel.add(addCard[36]);
        addCard[36].setVisible(false);
    }

    private void setRemoveCard(){
        removeCard = new JButton[37];
        int i = 0; int t = 0;
        for (int z =0 ; z < 4 ; z ++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                removeCard[i] = new JButton("Remove");
                removeCard[i].setBounds(100 + (204 * z), 280 + (292 * j), 103, 29);
                removeCard[i].setFont(new Font("American Typewriter", Font.BOLD, 15));
                removeCard[i].setForeground(new Color(135, 206, 250));
                int finalI = i;
                removeCard[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
                        removeFromDeck(getUser(),cardName[finalI]);
                    }
                });
                panel.add(removeCard[i]);
                removeCard[i].setContentAreaFilled(false);
                removeCard[i].setFocusPainted(false);
                removeCard[i].setBorderPainted(false);
                removeCard[i].setVisible(false);
                i += 4;
            }
            t++;
        }
        removeCard[36] = new JButton("Remove");
        removeCard[36].setBounds(100,2914,103,29);
        removeCard[36].setFont(new Font("American Typewriter", Font.BOLD, 15));
        removeCard[36].setForeground(new Color(135, 206, 250));
        removeCard[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
                removeFromDeck(getUser(),cardName[36]);
            }
        });
        removeCard[36].setContentAreaFilled(false);
        removeCard[36].setFocusPainted(false);
        removeCard[36].setBorderPainted(false);
        panel.add(removeCard[36]);
        removeCard[36].setVisible(false);

    }

    public static JButton[] getAddCard() {
        return addCard;
    }

    public static JButton[] getRemoveCard() {
        return removeCard;
    }

    public static void setAddDivisible(){
        for (int i = 0 ; i < addCard.length ; i++){
            addCard[i].setVisible(false);
            removeCard[i].setVisible(false);
        }
    }

    public static void setButtonIcon(ArrayList<Card> cards){
        for (int i = 0 ; i < getAllCards().size(); i++) {
            cardButton[i].setIcon(null);
            cardName[i]=null;
            addCard[i].setVisible(false);
            removeCard[i].setVisible(false);
        }
        for (int i = 0 ; i < cards.size() ; i++) {
            cardButton[i].setIcon(new ImageIcon(cardPath(cards.get(i))));
            cardName[i] = cards.get(i).getName();
            if (isCreateDeck() || isEditDeck()){
                addCard[i].setVisible(true);
                removeCard[i].setVisible(true);
            }

        }
    }

    public static JLabel[] getCardPrice() {
        return cardPrice;
    }

}
