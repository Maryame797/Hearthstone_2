package characters;

import cards.Card;

import java.io.File;
import java.util.ArrayList;

public class Rogue extends Hero {
    public Rogue(){
        setName("Rogue");
        setHP(30);


    }

    public final static ArrayList<Card> rogueCards(){
        ArrayList <Card> a = new ArrayList<>();
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Supercollider.json"));
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Friendly Smith.json"));
        return a;
    }



}
