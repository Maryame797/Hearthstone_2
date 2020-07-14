package panels;

import javax.swing.*;
import java.awt.*;

import static administer.Administer.getUser;
import static administer.Constants.MAX_EVENT_NUMBER;
import static logs.Log.addToGameLog;

public class EventsPanel extends JPanel {
    private  static JLabel[] events;
    private static int eventNumber;
    public EventsPanel(){
        eventNumber = 0;
        setBackground(new Color(238, 232, 170,150));
        setBounds(0, 0, 170, 800);
        setLayout(null);
        setEventLabel(this);
        JLabel lblNewLabel_1 = new JLabel("Events:");
        lblNewLabel_1.setFont(new Font("American Typewriter", Font.PLAIN, 16));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(6, 6, 61, 16);
        add(lblNewLabel_1);

    }

    public static void setEventLabel(JPanel panel){
        events = new JLabel[MAX_EVENT_NUMBER];
        for (int i = 0 ; i < events.length ; i++){
            events[i]=new JLabel();
            events[i].setForeground(new Color(255, 255, 255));
            events[i].setFont(new Font("American Typewriter", Font.PLAIN, 13));
            events[i].setBounds(6, 34+(18*i), 164, 16);
            panel.add(events[i]);
        }

    }

    public static void setEvent(String event){
        addToGameLog(getUser(),event);
        if (eventNumber<MAX_EVENT_NUMBER) {
            events[eventNumber].setText(event);
            eventNumber++;
        }else{
            for (int i = 0 ; i < MAX_EVENT_NUMBER-1 ; i++)
                events[i].setText(events[i+1].getText());
            events[MAX_EVENT_NUMBER-1].setText(event);

        }
    }
}
