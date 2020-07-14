package characters;

import cards.Card;

import java.io.File;
import java.util.ArrayList;

import static cards.Card.toCard;

public class Warlock extends Hero {
    public Warlock() {
        setName("Warlock");
        setHP(35);
    }

    public final static ArrayList<Card> warlockCards(){
        ArrayList<Card> a = new ArrayList<>();
        a.add(toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Dreadscale.json"));
        a.add(toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Awaken.json"));
        return a;
    }




}