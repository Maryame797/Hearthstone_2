package decks;

import cards.Card;
import characters.Hero;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Comparable<Deck>{
  private String name;
   private Hero hero;
   private ArrayList<Card> cardsInDeck;
   private int manaAverage;
   private int wins =0;
   private int playes = 0;
   private int rate;
   private int[] cardPlayes;


   public Deck(){
       cardsInDeck = new ArrayList<>();
       if (playes==0)
           rate=0;
       else
           rate=wins/playes;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public ArrayList<Card> getCardsInDeck() {
        return cardsInDeck;
    }

    public int getManaAverage() {
        return manaAverage;
    }

    public void setManaAverage(){
       int average = 0;
       for (int i = 0 ; i < cardsInDeck.size() ; i++)
           average+=cardsInDeck.get(i).getManaCost();
       manaAverage = average/cardsInDeck.size();
    }

    public int[] getCardPlayed() {
        return cardPlayes;
    }

    public void setCardPlayed(int[] cardPlayed) {
        this.cardPlayes = cardPlayed;
    }

    public int getWins() {
        return wins;
    }

    public int getPlayes() {
        return playes;
    }

    public ImageIcon getTopCard() throws IndexOutOfBoundsException {
        cardPlayes = new int[cardsInDeck.size()];
        for (int i = 0; i < cardsInDeck.size(); i++) {
            cardPlayes[i] = 0;
        }
        for (int i = 0; i < cardsInDeck.size(); i++) {
            cardsInDeck.get(i).setPlayes(cardPlayes[i]);
        }
        Collections.sort(cardsInDeck);
        ImageIcon imageIcon;
        if (cardsInDeck.size() != 0) {
            imageIcon = new ImageIcon("src"+File.separator+"panels"+File.separator+"cardimages"+File.separator + cardsInDeck.get(cardsInDeck.size() - 1).getName() + ".png");
        }else imageIcon=null;
        return imageIcon;
    }

    @Override
    public int compareTo(Deck o) {

           if (this.rate  > o.rate)
               return 1;
           else if (this.rate < o.rate)
               return -1;
           else if (this.wins > o.wins)
               return 1;
           else if (this.wins < o.wins)
               return -1;
           else if (this.playes > o.playes)
               return 1;
           else if (this.playes < o.playes)
               return -1;
           else if (this.manaAverage > o.manaAverage)
               return 1;
           else if (this.manaAverage < o.manaAverage)
               return -1;
           else
               return 0;
    }

    public int getRate() {
        return rate;
    }
}
