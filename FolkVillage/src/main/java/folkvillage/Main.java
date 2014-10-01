package folkvillage;
import folkvillageui.FolkvillageUI;

/**
 *
 * @author sanho
 */
public class Main {
    
    public static void main(String[] args){
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(FolkvillageUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Village village = new Village();
                FolkvillageUI ui = new FolkvillageUI(village);
                ui.setVisible(true);
            }
        });
        
        
    }
    
}
