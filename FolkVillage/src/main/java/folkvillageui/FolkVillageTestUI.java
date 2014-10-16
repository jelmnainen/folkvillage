
package folkvillageui;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import folkvillage.Village;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FolkVillageTestUI extends JFrame {
    
    
    private JFrame mainFrame;
    private JPanel panel;
    private GroupLayout layout;
    
    public FolkVillageTestUI(Village village){
        
        this.initUI();
        
    }

    
    private void initUI() {
        
        this.mainFrame = new JFrame("Folkvillage");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        this.layout = new GroupLayout(panel);
        this.layout.setAutoCreateGaps(true);
        this.layout.setAutoCreateContainerGaps(true);
        this.panel.setLayout(this.layout);

        //general
        
        ///labels
        JLabel turnClock        = new JLabel("Turn: 0");
        ///menu buttons
        JButton endTurn     = new JButton("End turn");
        JButton goToVillage = new JButton("Go to village");
        JButton goToEvent   = new JButton("Go to event");
        JButton quit        = new JButton("Ragequit");


        //village
        JLabel villageHeader    = new JLabel("Village");
        JLabel populationCount  = new JLabel("Population: 0");
        
        //events
        JLabel eventHeader      = new JLabel("Event");
        ///text fields
        JTextArea eventText    = new JTextArea("Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext!\n Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!");
        eventText.setColumns(20);
        eventText.setRows(5);
        eventText.setLineWrap(true);
        
        //start the grid
        
        //left to right
        GroupLayout.SequentialGroup leftToRight = this.layout.createSequentialGroup();
        GroupLayout.ParallelGroup menuColumn = this.layout.createParallelGroup();
            menuColumn.addComponent(turnClock);
            menuColumn.addComponent(goToVillage);
            menuColumn.addComponent(goToEvent);
            menuColumn.addComponent(endTurn);
            menuColumn.addComponent(quit);
        GroupLayout.ParallelGroup villageColumn = this.layout.createParallelGroup();
            villageColumn.addComponent(eventHeader);
            villageColumn.addComponent(eventText);
        
        leftToRight.addGroup(menuColumn);
        leftToRight.addGroup(villageColumn);
        
        //top to bottom
        GroupLayout.ParallelGroup headerRow = this.layout.createParallelGroup();
            headerRow.addComponent(turnClock);
            headerRow.addComponent(eventHeader);
        GroupLayout.SequentialGroup menuButtons = this.layout.createSequentialGroup();
            menuButtons.addComponent(goToVillage);
            menuButtons.addComponent(goToEvent);
            menuButtons.addComponent(endTurn);
            menuButtons.addComponent(quit);            
        GroupLayout.ParallelGroup secondRow = this.layout.createParallelGroup();
            secondRow.addGroup(menuButtons);
            secondRow.addComponent(eventText);
        GroupLayout.SequentialGroup topToBottom = this.layout.createSequentialGroup();
            topToBottom.addGroup(headerRow);
            topToBottom.addGroup(secondRow);

        this.layout.setHorizontalGroup(leftToRight);
        this.layout.setVerticalGroup(topToBottom);
        this.mainFrame.add(this.panel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true); 
       
    }
    
}
