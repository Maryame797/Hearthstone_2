package characters;

import cards.Card;

import java.io.File;
import java.util.ArrayList;

public class Hunter extends Hero {
    public Hunter(){
        setName("Hunter");
        setHP(30);

    }

    public final static ArrayList<Card> hunterCards(){
        ArrayList <Card> a = new ArrayList<>();
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Swamp King Dred.json"));
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Deadly Shot.json"));
        return a;
    }


}
