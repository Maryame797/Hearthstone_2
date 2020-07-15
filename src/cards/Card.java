package cards;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Card implements Comparable<Card> {
    private String name;
    private int manaCost;
    private String type;
    private String heroClass;
    private String rarity;
    private int price;
    private int playes;
    private int rarityNumber;
    private int HP;
    private int attack;
    private String description;

    public Card() {

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public void setPlayes(int playes) {
        this.playes = playes;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public static Card toCard(String path) {
        Gson gson = new Gson();
        FileReader reader;
        Card card = null;
        try {
            reader = new FileReader(path);
            card = gson.fromJson(reader, Card.class);
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return card;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Card> getAllCards() {
        ArrayList<Card> allCards = new ArrayList<>();
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Arcane Missiles.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Awaken.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Dreadscale.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Fan of Knives.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Friendly Smith.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Inner Fire.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Metamorphosis.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Meteorologist.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Mortal Coil.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Omega Medic.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Polymorph.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Prophet Velen.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Rolling Fireball.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Snap Freeze.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Spirit of the Bat.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Sprint.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Squashling.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Supercollider.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Vaporize.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Water Elemental.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Swamp King Dred.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "High Priest Amet.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Deadly Shot.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Sandhoof Waterbearer.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Book of Specters.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Swarm of Locusts.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Pharaoh's Blessing.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Sathrovarr.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Tomb Warden.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Security Rover.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Curio Collector.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Strength in Numbers.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Learn Draconic.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Hand of A'dal.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Mirage Blade.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Blood Fury.json"));
        allCards.add(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Battle Axe.json"));


        return allCards;
    }

    public static ArrayList<Card> getNeutralCards() {
        ArrayList<Card> gnc = new ArrayList<>(getAllCards());
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Vaporize.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Polymorph.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Sandhoof Waterbearer.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "High Priest Amet.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Swamp King Dred.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Deadly Shot.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Supercollider.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Friendly Smith.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Dreadscale.json"));
        gnc.remove(toCard("src" + File.separator + "cards" + File.separator + "json" + File.separator + "Awaken.json"));
        return gnc;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            if (((Card) obj).name.equals(this.name)) return true;
            else return false;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Card o) {
        if (rarity.equals("common"))
            rarityNumber = 0;
        if (rarity.equals("rare"))
            rarityNumber = 1;
        if (rarity.equals("epic"))
            rarityNumber = 2;
        if (rarity.equals("legendary"))
            rarityNumber = 3;
        if (this.playes > o.playes)
            return 1;
        else if (this.playes < o.playes)
            return -1;
        else if (this.rarityNumber > o.rarityNumber)
            return 1;
        else if (this.rarityNumber < o.rarityNumber)
            return -1;
        else if (this.manaCost > o.manaCost)
            return 1;
        else if (this.manaCost < o.manaCost)
            return -1;
        else if (this.type.equals("Minion") == true && o.type.equals("Minion") == false)
            return 1;
        else if (this.type.equals("Minion") == false && o.type.equals("Minion") == true)
            return -1;
        else
            return 0;

    }
}