
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
        
        //create menu buttons
        JButton endturn     = new JButton("End turn");
        JButton gotovillage = new JButton("Go to village");
        JButton gotoevent   = new JButton("Go to event");
        JButton quit        = new JButton("Ragequit");
        
        //labels
        JLabel villageHeader    = new JLabel("Village");
        JLabel eventHeader      = new JLabel("Event");
        
        //text fields
        JTextArea eventText    = new JTextArea("Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext!\n Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!Evenntext! Evenntext! Evenntext!");
        
        //start the grid
        
        //left to right
        GroupLayout.SequentialGroup leftToRight = this.layout.createSequentialGroup();
        GroupLayout.ParallelGroup menuColumn = this.layout.createParallelGroup();
            menuColumn.addComponent(gotovillage);
            menuColumn.addComponent(gotoevent);
            menuColumn.addComponent(endturn);
            menuColumn.addComponent(quit);
        GroupLayout.ParallelGroup villageColumn = this.layout.createParallelGroup();
            villageColumn.addComponent(eventHeader);
            villageColumn.addComponent(eventText, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE);
        
        leftToRight.addGroup(menuColumn);
        leftToRight.addGroup(villageColumn);
        
        //top to bottom
        GroupLayout.SequentialGroup topToBottom = this.layout.createSequentialGroup();
        GroupLayout.ParallelGroup headerRow = this.layout.createParallelGroup();
            headerRow.addComponent(gotovillage);
            headerRow.addComponent(eventHeader);
        topToBottom.addGroup(headerRow);
        topToBottom.addComponent(gotoevent);
        topToBottom.addComponent(endturn);
        topToBottom.addComponent(quit);
        topToBottom.addComponent(eventText, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE);
            

        
        this.layout.setHorizontalGroup(leftToRight);
        this.layout.setVerticalGroup(topToBottom);
        this.mainFrame.add(this.panel);
        this.mainFrame.pack();
        this.mainFrame.setVisible(true); 
       
    }
    
}
