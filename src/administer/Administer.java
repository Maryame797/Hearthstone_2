package administer;
import cards.Card;
import characters.Warlock;
import panels.MainMenu;
import panels.StartPanel;
import player.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import static administer.Constants.FRAME_HEIGHT;
import static administer.Constants.FRAME_WIDTH;
import static cards.Card.getAllCards;
import static logs.Log.addToBody;
import static logs.Log.setHeader;
import static panels.StartPanel.*;
public class Administer {
    private static JPanel panel;
    private static JFrame frame;
    private static Player user;

    public Administer() {
        panel = new StartPanel();
        this.frame = new JFrame();
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.getContentPane().add(panel);
        panel = null;
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        for (int i = 0; i < getAllCards().size(); i++)
            convertColor(getAllCards().get(i));
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setPanelOnFrame(JPanel panel, JFrame frame) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }

    public static void register(String name, String password) {
        getLblNewLabel_8().setVisible(false);
        File file = new File("src" + File.separator + "player" + File.separator + "json" + File.separator + name + ".json");
        if (file.exists())
            getLblNewLabel_7().setVisible(true);
        else {
            getLblNewLabel_7().setVisible(false);

            if (password.equals("")) getLblNewLabel_9().setVisible(true);
            else {
                getLblNewLabel_9().setVisible(false);

                user = new Player();
                String pass = Long.toString(password.hashCode());
                getCreateTime(user);
                user.setUserName(name);
                user.setPassword(pass);
                setHeader(user);
                firstCards(user);
                user.getOpenHeroes().add(new Warlock());
                user.setCurrentHero(new Warlock());
                user.setGems(50);
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String in = gson.toJson(user);
                try {
                    FileWriter writer = new FileWriter("src" + File.separator + "player" + File.separator + "json" + File.separator + "" + name + ".json");
                    writer.write(in);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                setPanelOnFrame(new MainMenu(), getFrame());
            }
        }
    }

    public static void logIn(String name, String password) {
        getLblNewLabel_7().setVisible(false);
        String pass = Long.toString(password.hashCode());
        Gson gson = new Gson();
        user = null;
        File file = new File("src" + File.separator + "player" + File.separator + "json" + File.separator + name + ".json");
        if (file.exists()) {
            try {
                FileReader reader = new FileReader("src" + File.separator + "player" + File.separator + "json" + File.separator + name + ".json");
                user = gson.fromJson(reader, Player.class);
                if (user.getPassword().equals(pass)
                        && user.getUserName().equals(name)) {
                    addToBody("log_in", user.getUserName(), user);
                    setPanelOnFrame(new MainMenu(), getFrame());
                } else {
                    getLblNewLabel_8().setVisible(true);
                }
                reader.close();

            } catch (FileNotFoundException e) {
                //  e.printStackTrace();
            } catch (IOException e) {
                addToBody("exception", "IOException", user);
                e.printStackTrace();
            } catch (NullPointerException e) {
                addToBody("exception", "NUllPointerException", user);
                //  e.printStackTrace();
            }
        } else getLblNewLabel_8().setVisible(true);
    }

    public static Player getUser() {
        return user;
    }

    public void convertColor(Card card) {
        BufferedImage src = null;
        try {
            src = ImageIO.read(new File("src" + File.separator + "panels" + File.separator + "cardimages" + File.separator + "" + card.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        ColorConvertOp op =
                new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        BufferedImage dest = op.filter(src, null);
        try {
            ImageIO.write(dest, "PNG", new File("src" + File.separator + "panels" + File.separator + "cardimages" + File.separator + "" + card.getName() + "2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveInFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("src" + File.separator + "player" + File.separator + "json" + File.separator + user.getUserName() + ".json");
            writer.write(gson.toJson(user));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            addToBody("exeption", "IOExeption", user);
        }
    }

    public static ImageIcon resizeImage(Card card, int width, int height) {
        ImageIcon image = null;
        image = new ImageIcon("src" + File.separator + "panels" + File.separator + "cardimages" + File.separator + "" + card.getName() + ".png");
        Image scaleImage = image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(scaleImage);
        return imageIcon;
    }

    public static ArrayList<Card> canBeInDeck(Player user) {
        ArrayList<Card> canBeInDeck = new ArrayList<>();
        for (int j = 0; j <= 1; j++) {
            for (int i = 0; i < user.getCurrentCards().size(); i++) {
                if (user.getCurrentCards().get(i).getHeroClass().equals("Neutral") || user.getCurrentCards().get(i).getHeroClass().equals(user.getCurrentDeck().getHero().getName()))
                    canBeInDeck.add(user.getCurrentCards().get(i));
            }
        }
        if (user.getCurrentDeck().getCardsInDeck().size() != 0)
            for (int i = 0; i < user.getCurrentDeck().getCardsInDeck().size(); i++) {
                canBeInDeck.remove(user.getCurrentDeck().getCardsInDeck().get(i));
            }
        return canBeInDeck;
    }

    public static void addInDeck(Player user, String cardName) {
        if (user.getCurrentDeck().getCardsInDeck().size() == 15) {
            JOptionPane.showMessageDialog(null, "Sorry! Your deck is full.");
        } else {
            boolean flag = false;
            for (int i = 0; i < canBeInDeck(user).size(); i++) {
                if (cardName.equals(canBeInDeck(user).get(i).getName())) {
                    addToBody("add to " + user.getCurrentDeck().getName(), "card: " + canBeInDeck(user).get(i).getName() + " :" + user.getCurrentHero().getName(), user);
                    user.getCurrentDeck().getCardsInDeck().add(canBeInDeck(user).get(i));
                    JOptionPane.showMessageDialog(null, "Successfully added!");
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                JOptionPane.showMessageDialog(null, "You can't add this card to your deck.");
                addToBody("invalid_command", "collections", user);
            }
            saveInFile();
        }
    }

    public static void removeFromDeck(Player user, String cardName) {
        boolean flag = false;
        for (int i = 0; i < user.getCurrentDeck().getCardsInDeck().size(); i++) {
            if (user.getCurrentDeck().getCardsInDeck().get(i).getName().equals(cardName)) {
                JOptionPane.showMessageDialog(null, "Successfully removed!");
                addToBody("remove from " + user.getCurrentDeck().getName(), "card:" + user.getCurrentDeck().getCardsInDeck().get(i).getName() + " :" + user.getCurrentHero().getName(), user);
                user.getCurrentDeck().getCardsInDeck().remove(i);
                flag = true;
                break;
            }
        }
        if (flag == false) {
            addToBody("invalid_command", "collections", user);
        }
        saveInFile();
    }

    public static void firstCards(Player user) {
        ArrayList<Card> firstCards = new ArrayList<>();
        firstCards.add(getAllCards().get(2));
        firstCards.add(getAllCards().get(3));
        firstCards.add(getAllCards().get(6));
        firstCards.add(getAllCards().get(9));
        firstCards.add(getAllCards().get(18));
        firstCards.add(getAllCards().get(8));
        firstCards.add(getAllCards().get(16));
        firstCards.add(getAllCards().get(14));
        firstCards.add(getAllCards().get(19));
        firstCards.add(getAllCards().get(15));
        user.setCurrentCards(firstCards);
    }

    public static void getCreateTime(Player user) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String a = dtf.format(now).substring(2, 4) + dtf.format(now).substring(5, 7) + dtf.format(now).substring(8, 10) + dtf.format(now).substring(11, 13) + dtf.format(now).substring(14, 16) + dtf.format(now).substring(17);
        user.setUserID(a);
    }
}
