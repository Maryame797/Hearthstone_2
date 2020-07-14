package characters;

import cards.Card;

import java.io.File;
import java.util.ArrayList;

public class Priest extends Hero{
    public Priest(){
        setName("Priest");
        setHP(30);
    }
    public final static ArrayList<Card> priestCards(){
        ArrayList <Card> a = new ArrayList<>();
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Sandhoof Waterbearer.json"));
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"High Priest Amet.json"));
        return a;
    }


}
