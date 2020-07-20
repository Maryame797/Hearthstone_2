package panels;

import cards.Card;
import graphicutill.CardView;
import graphicutill.ClickListener;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static administer.Administer.*;
import static administer.Constants.NORMAL_CARD_HEIGHT;
import static administer.Constants.NORMAL_CARD_WIDTH;
import static panels.Collections.goToShop;
import static panels.DecksPanel.isCreateDeck;
import static panels.DecksPanel.isEditDeck;
import static panels.ShopPanel.*;
import static shop.shop.*;

public class CardsPanel extends JPanel {
    private static JPanel panel;
    private JScrollPane scrollPane;
    private static JLabel[] cardPrice;
    private static JButton[] addCard;
    private static JButton[] removeCard;
    private static String[] cardName;
    private static int[] x = new int[37];
    private static int[] y = new int[37];
    private static ArrayList<CardView> cardViews;

    public CardsPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(820, 2935));
        setLocation();
        setCardPrice();
        setAddCard();
        setRemoveCard();
        scrollPane = new JScrollPane(panel);
        scrollPane.setPreferredSize(new Dimension(860, 570));
        add(scrollPane);
        setSize(870, 600);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBackground(new Color(205, 133, 63));
        setBackground(new Color(205, 133, 63));
        setBorder(new LineBorder(new Color(205, 133, 63)));
        panel.setBorder(new LineBorder(new Color(205, 133, 63)));
        scrollPane.setBorder(new LineBorder(new Color(205, 133, 63)));
        cardViews = new ArrayList<>();
    }

    public static void buy(int i) {
        if (isBuy()) {
            buyCard(getUser(), cardViews.get(i).getCard());
            setButtonIcon(canBuy(getUser()));
            getGemsLabel().setText("Your gems: " + getUser().getGems());
        }
    }

    public static void sell(int i) {
        if (isSell()) {
            sellCard(getUser(), i);
            setButtonIcon(canSell(getUser()));
            getGemsLabel().setText("Your gems: " + getUser().getGems());
        }
    }

    private void setLocation() {
        cardName = new String[37];
        int i;
        int t = 0;
        for (int z = 0; z < 4; z++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                x[i] = 6 + (204 * z);
                y[i] = 6 + (292 * j);
                i += 4;
            }
            t++;
        }
        x[36] = 6;
        y[36] = 2634;
    }

    private void setCardPrice() {
        cardPrice = new JLabel[37];

        int i = 0;
        int t = 0;
        for (int z = 0; z < 4; z++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                cardPrice[i] = new JLabel();
                cardPrice[i].setBounds(76 + (204 * z), 282 + (292 * j), 80, 16);
                cardPrice[i].setFont(new Font("American Typewriter", Font.PLAIN, 15));
                cardPrice[i].setForeground(new Color(135, 206, 250));
                i += 4;
            }
            t++;
        }
        cardPrice[36] = new JLabel();
        cardPrice[36].setBounds(76, 2914, 80, 16);
        cardPrice[36].setFont(new Font("American Typewriter", Font.PLAIN, 15));
        cardPrice[36].setForeground(new Color(135, 206, 250));
    }

    private void setAddCard() {
        addCard = new JButton[37];
        int i;
        int t = 0;
        for (int z = 0; z < 4; z++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                addCard[i] = new JButton("Add");
                addCard[i].setBounds(8 + (204 * z), 285 + (292 * j), 103, 29);
                addCard[i].setFont(new Font("American Typewriter", Font.BOLD, 15));
                addCard[i].setForeground(new Color(135, 206, 250));
                int finalI = i;
                addCard[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(cardViews.get(finalI).getCard().getAttack());
                        if (getUser().getCurrentDeck().getCardsInDeck().size() > 15)
                            JOptionPane.showMessageDialog(null, "Your deck is full!");
                        else
                            addInDeck(cardViews.get(finalI).getCard());
                    }
                });
                addCard[i].setContentAreaFilled(false);
                addCard[i].setFocusPainted(false);
                addCard[i].setBorderPainted(false);
                i += 4;
            }
            t++;
        }
        addCard[36] = new JButton("Add");
        addCard[36].setBounds(8, 2914, 103, 29);
        addCard[36].setFont(new Font("American Typewriter", Font.BOLD, 15));
        addCard[36].setForeground(new Color(135, 206, 250));
        addCard[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addInDeck(cardViews.get(36).getCard());
            }
        });
        addCard[36].setContentAreaFilled(false);
        addCard[36].setFocusPainted(false);
        addCard[36].setBorderPainted(false);
    }

    private void setRemoveCard() {
        removeCard = new JButton[37];
        int i;
        int t = 0;
        for (int z = 0; z < 4; z++) {
            i = t;
            for (int j = 0; j < 9; j++) {
                removeCard[i] = new JButton("Remove");
                removeCard[i].setBounds(100 + (204 * z), 285 + (292 * j), 103, 29);
                removeCard[i].setFont(new Font("American Typewriter", Font.BOLD, 15));
                removeCard[i].setForeground(new Color(135, 206, 250));
                int finalI = i;
                removeCard[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
                        removeFromDeck(cardName[finalI]);
                    }
                });
                removeCard[i].setContentAreaFilled(false);
                removeCard[i].setFocusPainted(false);
                removeCard[i].setBorderPainted(false);
                i += 4;
            }
            t++;
        }
        removeCard[36] = new JButton("Remove");
        removeCard[36].setBounds(100, 2914, 103, 29);
        removeCard[36].setFont(new Font("American Typewriter", Font.BOLD, 15));
        removeCard[36].setForeground(new Color(135, 206, 250));
        removeCard[36].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) throws IndexOutOfBoundsException {
                removeFromDeck(cardName[36]);
            }
        });
        removeCard[36].setContentAreaFilled(false);
        removeCard[36].setFocusPainted(false);
        removeCard[36].setBorderPainted(false);
    }

    public static JButton[] getAddCard() {
        return addCard;
    }

    public static JButton[] getRemoveCard() {
        return removeCard;
    }

    public static void setAddDivisible() {
        for (int i = 0; i < addCard.length; i++) {
            addCard[i].setVisible(false);
            removeCard[i].setVisible(false);
        }
    }

    public static void setButtonIcon(ArrayList<Card> cards) {
        cardViews.clear();
        panel.removeAll();
        panel.updateUI();
        for (int i = 0; i < cards.size(); i++) {
            int finalI = i;
            cardViews.add(new CardView(cards.get(i), x[i], y[i], NORMAL_CARD_WIDTH, NORMAL_CARD_HEIGHT, new ClickListener() {
                @Override
                public void onClick() {
                    buy(finalI);
                    sell(finalI);
                    goToShop(cards.get(finalI));
                }
            }));
            panel.add(cardViews.get(i));
            cardName[i] = cards.get(i).getName();
            if (isCreateDeck() || isEditDeck()) {
                panel.add(addCard[i]);
                panel.add(removeCard[i]);
            }
            if (isBuy() || isSell()) {
                panel.add(cardPrice[i]);
                cardPrice[i].setText("price: " + cardViews.get(i).getCard().getPrice());
            }
        }
        panel.revalidate();
    }
}
