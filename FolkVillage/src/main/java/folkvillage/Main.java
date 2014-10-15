package folkvillage;
import folkvillageui.FolkVillageUI;
import folkvillageui.Testui;
import folkvillageui.FolkVillageTestUI;

/**
 *
 * @author sanho
 */
public class Main {
    
    public static void main(String[] args){
        
        // Set the Nimbus look and feel 
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FolkVillageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Village village = new Village();
                FolkVillageTestUI ui = new FolkVillageTestUI(village);
            }
        });
           
    }
    

}
