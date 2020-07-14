
package characters;

import cards.Card;

import java.io.File;
import java.util.ArrayList;

public class Mage extends Hero {

    public Mage (){
        setName("Mage");
        setHP(30);
    }
    public final static ArrayList<Card> mageCards(){
        ArrayList <Card> a = new ArrayList<>();
        a.add(Card.toCard("src"+File.separator+ "cards" +File.separator+"json"+File.separator+"Vaporize.json"));
        a.add(Card.toCard("src"+ File.separator+ "cards" + File.separator+"json"+ File.separator+"Polymorph.json"));
        return a;
    }



}
