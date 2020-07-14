package player;

import cards.Card;
import characters.Hero;
import decks.Deck;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private String userName;
    private String password;
    private Hero currentHero;
    private ArrayList<Hero> openHeroes;
    private int gems;
    private ArrayList <Card> currentCards;
    private String userID;
    private ArrayList<Deck> userDecks;
    private Deck currentDeck;
    private ArrayList<Deck> topDecks;
    private Deck gameDeck;
    public Player() {
        userDecks = new ArrayList<>();
        currentCards=new ArrayList<>();
        openHeroes=new ArrayList<>();
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserID() {
        return userID;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Hero getCurrentHero() {
        return currentHero;
    }
    public void setCurrentHero(Hero currentHero) {
        this.currentHero = currentHero;
    }
    public ArrayList<Hero> getOpenHeroes() {
        return openHeroes;
    }
    public void setOpenHeroes(ArrayList<Hero> openHeroes) {
        this.openHeroes = openHeroes;
    }
    public int getGems() {
        return gems;
    }
    public void setGems(int gems) {
        this.gems = gems;
    }
    public ArrayList<Card> getCurrentCards() {
        return currentCards;
    }
    public void setCurrentCards(ArrayList<Card> currentCards) {
        this.currentCards = currentCards;
    }
    public ArrayList<Deck> getUserDecks() {
        return userDecks;
    }
    public Deck getCurrentDeck() {
        return currentDeck;
    }
    public void setCurrentDeck(Deck currentDeck) {
        this.currentDeck = currentDeck;
    }
    public Deck getGameDeck() {
        return gameDeck;
    }
    public void setGameDeck(Deck gameDeck) {
        this.gameDeck = gameDeck;
    }

    public ArrayList<Deck> getTopDecks() {
        ArrayList<Deck> top = new ArrayList<>();
        Collections.sort(userDecks);
        if (userDecks.size()>10){
            for (int i= userDecks.size()-1 ; i>=userDecks.size()-10;i--){
                top.add(userDecks.get(i));
            }
        }
        else{
            for (int i = userDecks.size()-1;i>=0;i-- )
                top.add(userDecks.get(i));
        }
        return top;
    }

}