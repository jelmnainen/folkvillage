
package folkvillageui;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import folkvillage.Village;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FolkVillageTestUI extends JFrame {
    
    private Village village;
    
    private JFrame mainFrame;
    private JPanel panel;
    private GroupLayout layout;
    
    private JLabel turnClock;
    private JLabel viewHeader;
    
    private GroupLayout.ParallelGroup switchableArea;
    private GroupLayout.ParallelGroup villageColumn;
    
    public FolkVillageTestUI(Village village){
        this.village = village;
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
        this.viewHeader = new JLabel("Event");
        this.turnClock  = new JLabel("Turn: 0");
        
        ///menu buttons
        javax.swing.JButton endTurn     = new javax.swing.JButton("End turn");
        endTurn.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tick();
            }
        });
                
        JButton goToVillage = new JButton("Go to village");
        goToVillage.addActionListener(new java.awt.event.ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                getVillageView();
            }
        });
        
        JButton goToEvent = new JButton("Go to event");
        goToEvent.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getEventView();
            }
        });
        
        JButton quit = new JButton("Ragequit");
        quit.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        //village
        JLabel villageHeader    = new JLabel("Village");
        JLabel populationCount  = new JLabel("Population: 0");
        
        //events
        
        ///text fields
        JTextArea eventText    = new JTextArea("Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext!\n Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!");
        eventText.setColumns(20);
        eventText.setRows(5);
        eventText.setLineWrap(true);
        
        //start the grid
        
        this.switchableArea = this.layout.createParallelGroup();
            //this.switchableArea.addComponent(eventText);

        //left to right
        GroupLayout.SequentialGroup leftToRight = this.layout.createSequentialGroup();
        GroupLayout.ParallelGroup menuColumn = this.layout.createParallelGroup();
            menuColumn.addComponent(turnClock);
            menuColumn.addComponent(goToVillage);
            menuColumn.addComponent(goToEvent);
            menuColumn.addComponent(endTurn);
            menuColumn.addComponent(quit);
        
        this.villageColumn = this.layout.createParallelGroup();
            villageColumn.addComponent(viewHeader);
            //villageColumn.addComponent(eventText);
            villageColumn.addGroup(this.switchableArea);
           // this.switchableArea.addComponent(eventText);
        
        leftToRight.addGroup(menuColumn);
        leftToRight.addGroup(villageColumn);
        
        //top to bottom
        GroupLayout.ParallelGroup headerRow = this.layout.createParallelGroup();
            headerRow.addComponent(turnClock);
            headerRow.addComponent(viewHeader);
        GroupLayout.SequentialGroup menuButtons = this.layout.createSequentialGroup();
            menuButtons.addComponent(goToVillage);
            menuButtons.addComponent(goToEvent);
            menuButtons.addComponent(endTurn);
            menuButtons.addComponent(quit);            
        GroupLayout.ParallelGroup secondRow = this.layout.createParallelGroup();
            secondRow.addGroup(menuButtons);
            secondRow.addGroup(this.switchableArea);
            //this.switchableArea.addComponent(eventText);
            //secondRow.addComponent(eventText);
        GroupLayout.SequentialGroup topToBottom = this.layout.createSequentialGroup();
            topToBottom.addGroup(headerRow);
            topToBottom.addGroup(secondRow);

        this.layout.setHorizontalGroup(leftToRight);
        this.layout.setVerticalGroup(topToBottom);
        this.mainFrame.add(this.panel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true); 
       
    } // end initUI();
    
    /**
     * Tick is called after every endturn event. It calls Village's tick(),
     * which distributes the tick to all member's tick functions.
     * 
     * After tick, UI updates itself to reflect the new situation
     */
    private void tick(){
        
        this.village.tick();
        this.updateUIAfterTick();
        
    }
    
    /**
     * Wraps all UI update functions
     */
    private void updateUIAfterTick(){ 
        //turn counter
        this.turnClock.setText("Turn: " + this.village.getTurnCountAsString());
        
        //villagers
        //this.populationAmount.setText( Integer.toString(this.village.getPopulation().getPopulationAmount()) );

        //this.updateConstructedBuildings();
    }
    
    private void getVillageView(){
        this.viewHeader.setText("Village");
        this.villageColumn.
        
    }
    
    private void getEventView(){
        this.viewHeader.setText("Event");
    }
    
}
