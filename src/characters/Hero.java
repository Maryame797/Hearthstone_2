package characters;

import cards.Card;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int HP;
    private static ArrayList<Card> classCards=new ArrayList<>();
    private ArrayList<Card> deck=new ArrayList<>();
    private int defence;
    public Hero(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
