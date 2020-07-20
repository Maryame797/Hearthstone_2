package graphicutill;

import cards.Card;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

    public CardView(Card card, int x, int y, int width, int height, ClickListener clickListener) {
        this.clickListener = clickListener;
        this.card = card;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        setBounds(x, y, width, height);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
        setLayout(null);
        JLabel mana = new JLabel(String.valueOf(card.getManaCost()));
        mana.setForeground(Color.WHITE);
        mana.setFont(new Font("American Typewriter", Font.PLAIN, 25));
        mana.setBounds(25, 20, 28, 30);
        add(mana);
        if (!card.getType().equals("Spell")) {
            JLabel hp = new JLabel(String.valueOf(card.getHP()));
            hp.setForeground(Color.WHITE);
            hp.setFont(new Font("American Typewriter", Font.PLAIN, 25));
            hp.setBounds(166, 233, 28, 30);
            add(hp);
            JLabel attack = new JLabel(String.valueOf(card.getAttack()));
            attack.setForeground(Color.WHITE);
            attack.setFont(new Font("American Typewriter", Font.PLAIN, 25));
            attack.setBounds(25, 236, 22, 30);
            add(attack);
        }

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // do something
                clickListener.onClick();
            }
        });

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setIcon(new ImageIcon(cardPath(card)));
        lblNewLabel.setBounds(0, 0, NORMAL_CARD_WIDTH, NORMAL_CARD_HEIGHT);
        add(lblNewLabel);


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
    @Override
    public int getY() {
        return y;
    }
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
