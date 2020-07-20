package shop;

import cards.Card;
import player.Player;

import java.util.ArrayList;

import static administer.Administer.saveInFile;
import static cards.Card.getAllCards;
import static logs.Log.addToBody;

public class shop {
    public ArrayList<Card> storeCards;

    public ArrayList<Card> getStoreCards() {
        return storeCards;
    }

    public void setStoreCards(ArrayList<Card> storeCards) {
        this.storeCards = storeCards;
    }

    public shop(ArrayList<Card> storeCards) {
        this.storeCards = storeCards;
    }


    public static ArrayList<Card> canSell(Player user) {
        boolean flag;
        ArrayList<Card> canSell = new ArrayList<>();
        for (int i = 0; i < user.getCurrentCards().size(); i++) {
            flag = false;
            for (int j = 0 ; j < user.getUserDecks().size(); j++) {
                if (user.getUserDecks().get(j).getCardsInDeck().contains(user.getCurrentCards().get(i))) {
                    flag = true;
                    break;
                }
            }
            if (flag==false) {
                canSell.add(user.getCurrentCards().get(i));
            }
        }
        return canSell;
    }

    public static ArrayList<Card> canBuy( Player user) throws NullPointerException {
        ArrayList<Card> canBuy = new ArrayList(getAllCards());
        for (int i = 0; i < user.getCurrentCards().size(); i++) {
                canBuy.remove(user.getCurrentCards().get(i));
        }
        return canBuy;
    }

    public static void buyCard(Player user, Card card) throws IndexOutOfBoundsException {
        addToBody("buy","card: "+card.getName(),user);
            if (user.getGems()>=card.getPrice() ){
                user.setGems(user.getGems()-card.getPrice());
               user.getCurrentCards().add(card);
               saveInFile();
            }
        }

    public static void sellCard(Player user, int i)throws IndexOutOfBoundsException{
        addToBody("sell","card: "+canSell(user).get(i).getName(),user);
                user.setGems(user.getGems() + canSell(user).get(i).getPrice());
                user.getCurrentCards().remove(canSell(user).get(i));
                saveInFile();
            }

    }
