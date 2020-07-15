package graphicutill;

import cards.Card;

import javax.swing.*;
import java.awt.*;

import static administer.Constants.NORMAL_CARD_HEIGHT;
import static administer.Constants.NORMAL_CARD_WIDTH;
import static panels.Collections.cardPath;

public class CardView extends JPanel {
    private ClickListener clickListener;
    private Card card;
    private int x;
    private int y;
    private int width;
    private int height;
    private JLabel hp;
    private JLabel attack;
    private JLabel mana;

    public CardView(Card card, int x, int y, int width, int height, ClickListener clickListener) {
        this.clickListener = clickListener;
        this.card = card;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x,y,width,height);
        setVisible(true);
        mana = new JLabel(String.valueOf(card.getManaCost()));
        mana.setForeground(Color.WHITE);
        mana.setFont(new Font("American Typewriter", Font.PLAIN, 25));
        mana.setBounds(25, 25, 28, 30);
        add(mana);
        if (!card.getType().equals("spell")){
            hp = new JLabel(String.valueOf(card.getHP()));
            hp.setFont(new Font("American Typewriter", Font.PLAIN, 25));
            hp.setBounds(166, 233, 28, 30);
            add(hp);
            attack = new JLabel(String.valueOf(card.getAttack()));
            attack.setFont(new Font("American Typewriter", Font.PLAIN, 25));
            attack.setBounds(25, 236, 22, 30);
            add(attack);
        }
        mana.setBounds(50, 50 , 10, 10);
        add(mana);

//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseReleased(MouseEvent e) {
//                // do something
//                clickListener.onClick();
//            }
//        });

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon(cardPath(card)));
        lblNewLabel.setBounds(0, 0, NORMAL_CARD_WIDTH, NORMAL_CARD_HEIGHT);
        add(lblNewLabel);


    }


    public ClickListener getClickListener() {
        return clickListener;
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
