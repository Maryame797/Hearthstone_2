package panels;

import cards.Card;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;

import static administer.Administer.resizeImage;
import static administer.Constants.*;
import static panels.BoardPanel.*;
import static panels.EventsPanel.setEvent;

public class CardsInHandPanel extends JPanel {
    private Card cardInHand;
    private BoardPanel boardPanel;
    private JLabel background;
    private boolean draggable;



   public CardsInHandPanel() {
       cardInHand = new Card();
       setLayout(null);
       setSize(SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);
       setOpaque(false);
       setBorder(BorderFactory.createEmptyBorder());
       final boolean[] cardOnBoard = {false};
       final int[] dragged = {0};
       addMouseMotionListener(new MouseMotionListener() {
           @Override
           public void mouseDragged(MouseEvent e) {
               if (cardInHand.getManaCost() <= getManaHave()) {
                   if (dragged[0] == 0) {
                       getBigCard().setIcon(null);
                       draggable = true;
                       int X = e.getX() + getX();
                       int Y = e.getY() + getY();
                       setBounds(X, Y, SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);
                   }
               }
           }



           @Override
           public void mouseMoved(MouseEvent e) {

           }

       });

       addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent e) {
               if (!cardOnBoard[0]) {
                   getBigCard().setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"cardimages"+File.separator+ cardInHand.getName() + ".png"));
                   getBigCard().setBounds(e.getX() + getX(), e.getY() + getY() - NORMAL_CARD_HEIGHT, NORMAL_CARD_WIDTH, NORMAL_CARD_HEIGHT);
               }
           }

           @Override
           public void mouseExited(MouseEvent e) {
               getBigCard().setIcon(null);
           }

           @Override
           public void mouseReleased(MouseEvent e) {
               if (draggable){
                  remove();
                   dragged[0]++;
               setEvent(cardInHand.getName()+" played");
               if (getPassive().equals("Off cards"))
                   setManaInHand(getManaHave()-cardInHand.getManaCost()+1);
               else
               setManaInHand(getManaHave()-cardInHand.getManaCost());
               if (cardInHand.getType().equals("Spell")) {
                   setVisible(false);
                   getBigCard().setIcon(null);
                   cardOnBoard[0] = true;
               }
               draggable = false;
               }
           }


       });
   }


    public Card getCardInHand() {
        return cardInHand;
    }

    public void setCardInHand(Card cardInHand) {
        this.cardInHand = cardInHand;
        setBackground();
    }
    public void setBackground(){
       background = new JLabel();
       background.setIcon(resizeImage(cardInHand,SMALL_CARD_WIDTH,SMALL_CARD_HEIGHT));
       background.setBounds(0,0,SMALL_CARD_WIDTH,SMALL_CARD_HEIGHT);
       add(background);

    }
    public JLabel getBigPic(){
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("src"+File.separator+"panels"+File.separator+"cardimages"+File.separator+cardInHand.getName()+".png"));
        label.setVisible(false);
        return label;
    }

    public BoardPanel getBoardPanel() {
        return boardPanel;
    }

    public void setBoardPanel(BoardPanel boardPanel) {
        this.boardPanel = boardPanel;
    }

    private void remove(){
        getCardsInHand().remove(this);
    }
}
