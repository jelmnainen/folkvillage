
package folkvillageui;

import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import folkvillage.Village;
import java.awt.GridLayout;

public class FolkVillageTestUI extends JFrame {
    
    
    private JFrame mainFrame;
    
    public FolkVillageTestUI(Village village){
        
        this.initUI();
        
    }

    private void initUI() {

        
        setTitle("Tooltip");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        mainFrame = new JFrame("Folkvillage");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        
        
    }
    
}
