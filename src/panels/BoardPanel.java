package panels;

import cards.Card;
import characters.Hero;
import logs.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static administer.Administer.*;
import static administer.Constants.*;
import static logs.Log.addToGameLog;
import static panels.EventsPanel.setEvent;

public class BoardPanel extends JPanel {
    private JLabel heroHealth;
    private JLabel rivalHeroHealth;
    private Hero myHero;
    private static JLabel[] manaIcon;
    private static JLabel mana;
    private static JLabel bigCard;
    private int turnNumber;
    private static int manaHave;
    private CardsInHandPanel[] cards;
    private int usedCards = 0;
    private static ArrayList<CardsInHandPanel> cardsInHand;
    private JLabel cardsLeft;
    private static String passive;
    private ArrayList<Card> cardsInDeck;
    public BoardPanel(){
        addToGameLog(getUser(),"start");
        Log.addToBody("start","game",getUser());
        cardsInHand = new ArrayList<>();
        cardsInDeck = new ArrayList<>(getUser().getGameDeck().getCardsInDeck());
        if (passive == null)
            passive ="";
        if (passive.equals("Mana Jump")) {
            manaHave = 2;
            turnNumber = 2;
        }
        else {
            manaHave = 1;
            turnNumber = 1;
        }
        cards = new CardsInHandPanel[MAX_DECK_SIZE];
        for (int i = 0 ; i < MAX_DECK_SIZE ; i++){
            cards[i] = new CardsInHandPanel();
            add(cards[i]);
        }
        myHero = getUser().getGameDeck().getHero();
        bigCard = new JLabel();
        add(bigCard);
        setLayout(null);
        add(new EventsPanel());
        setEndButton();
        setHeroImage(myHero);
        setHeroHealth();
        setManaIcon();
        setNextCard(3);
        setCardsLeft();
        setHeroPower();
        MainMenu.setBackground(this,"src"+File.separator+"panels"+File.separator+"images"+File.separator+"board background.jpeg");

    }

    private void setEndButton(){
        JButton btnNewButton = new JButton("END TURN");
        btnNewButton.setFont(new Font("Al Tarikh", Font.BOLD, 13));
        btnNewButton.setBounds(918, 351, 134, 40);
        btnNewButton.setContentAreaFilled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorderPainted(false);
        add(btnNewButton);
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnNewButton.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnNewButton.setForeground(Color.BLACK);
            }
        });
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0 ; i < cardsInHand.size() ;i++){
                    cardsInHand.get(i).setBounds(CARD_X[i],CARD_Y,SMALL_CARD_WIDTH,SMALL_CARD_HEIGHT);
                }
                setEvent("End Turn");
                if (passive.equals("Twice Draw"))
                    setNextCard(2);
                else setNextCard(1);

                turnNumber++;
                setManaInHand(turnNumber);
                cardsLeft.setText(MAX_DECK_SIZE-usedCards + " cards left!");

            }
        });

    }

    private void setHeroImage(Hero hero){
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+""+hero.getName()+".png"));
        lblNewLabel_5.setBounds(501, 523, 115, 172);
        add(lblNewLabel_5);

        //rival hero
        JLabel lblNewLabel_5_1 = new JLabel("");
        lblNewLabel_5_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"Warlock.png"));
        lblNewLabel_5_1.setBounds(501, 66, 115, 166);
        add(lblNewLabel_5_1);
    }

    private void setHeroHealth(){
        heroHealth = new JLabel(String.valueOf(myHero.getHP()));
        heroHealth.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        heroHealth.setForeground(new Color(255, 255, 255));
        heroHealth.setBounds(620, 661, 27, 35);
        add(heroHealth);

        JLabel lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"health icon.png"));
        lblNewLabel_1.setBounds(610, 635, 61, 75);
        add(lblNewLabel_1);

        rivalHeroHealth = new JLabel("35");
        rivalHeroHealth.setForeground(new Color(255, 255, 255));
        rivalHeroHealth.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        rivalHeroHealth.setBounds(620, 218, 27, 16);
        add(rivalHeroHealth);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"health icon.png"));
        lblNewLabel_2.setBounds(610, 181, 61, 75);
        add(lblNewLabel_2);

    }

    private void setManaIcon(){
        mana = new JLabel(manaHave+"/10");
        mana.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        mana.setForeground(new Color(255, 255, 255));
        mana.setBounds(749, 733, 61, 16);
        add(mana);
        manaIcon= new JLabel[10];
        for (int i = 0 ; i<10;i++){
            manaIcon[i] = new JLabel();
            manaIcon[i].setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"mana_crystal.png"));
            manaIcon[i].setBounds(805+(21*i), 727, 35, 30);
            add(manaIcon[i]);
            manaIcon[i].setVisible(false);
        }
        manaIcon[0].setVisible(true);
    }

    public static void setManaInHand(int m){
        if (m<=10) {
            manaHave = m;
        }
        else manaHave = 10;
        for (int i = 0 ; i < 10; i++)
            manaIcon[i].setVisible(false);
        for (int i = 0 ; i < manaHave ; i++)
            manaIcon[i].setVisible(true);
            mana.setText(manaHave +"/10");
    }

    public static JLabel getBigCard() {
        return bigCard;
    }

    public static int getManaHave() {
        return manaHave;
    }

    public void setNextCard(int number){
       Random random = new Random();
       int a = usedCards;
        for (int i = a; i < number+a ; i++){
            if (usedCards<MAX_DECK_SIZE) {
                int n = random.nextInt(MAX_DECK_SIZE - usedCards);
                cards[i].setCardInHand(cardsInDeck.get(n));
                cardsInDeck.remove(cardsInDeck.get(n));
                usedCards++;
                if (cardsInHand.size() < 12) {
                    cards[i].setBounds(CARD_X[cardsInHand.size()], CARD_Y, SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);
                    cardsInHand.add(cards[i]);
                }else
                    cards[i].setVisible(false);
            }else
                setPanelOnFrame(new GameOver(),getFrame());



        }

   }

   private void setCardsLeft(){
       cardsLeft = new JLabel("12 cards left!");
       cardsLeft.setForeground(new Color(135, 206, 250));
       cardsLeft.setFont(new Font("American Typewriter", Font.PLAIN, 19));
       cardsLeft.setBounds(743, 747, 215, 42);
       add(cardsLeft);

   }

    public static ArrayList<CardsInHandPanel> getCardsInHand() {
        return cardsInHand;
    }

    private void setHeroPower(){
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+myHero.getName()+" heropower.png"));
        lblNewLabel.setBounds(654, 565, 92, 84);
        add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"images"+File.separator+"Warlock heropower.png"));
        lblNewLabel_2.setBounds(654, 118, 92, 84);
        add(lblNewLabel_2);


    }

    public static String getPassive() {
        return passive;
    }

    public static void setPassive(String passive) {
        BoardPanel.passive = passive;
    }
}
