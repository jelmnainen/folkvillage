/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folkvillageui;
import java.util.ArrayList;
import folkvillage.Village;

/**
 *
 * @author sanho
 */
public class FolkvillageUI extends javax.swing.JFrame {
    
    private Village village;
    /**
     * Creates new form main
     */
    public FolkvillageUI(Village village) {
        this.village = village;
        initComponents();
        this.tick();        
    }

    private FolkvillageUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainwindow = new javax.swing.JPanel();
        villageLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        populationAmount = new javax.swing.JLabel();
        endTurn = new javax.swing.JButton();
        goToOther = new javax.swing.JButton();
        turnClock = new javax.swing.JLabel();
        systemExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        villageLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        villageLabel.setText("Village");

        jLabel1.setText("Population:");

        populationAmount.setText("amount");

        javax.swing.GroupLayout mainwindowLayout = new javax.swing.GroupLayout(mainwindow);
        mainwindow.setLayout(mainwindowLayout);
        mainwindowLayout.setHorizontalGroup(
            mainwindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainwindowLayout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(villageLabel)
                .addGap(200, 200, 200))
            .addGroup(mainwindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(populationAmount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainwindowLayout.setVerticalGroup(
            mainwindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainwindowLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(villageLabel)
                .addGap(18, 18, 18)
                .addGroup(mainwindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(populationAmount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        endTurn.setText("End Turn");
        endTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endTurnActionPerformed(evt);
            }
        });

        goToOther.setText("Switch View (not implemented)");
        goToOther.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToOtherActionPerformed(evt);
            }
        });

        turnClock.setText("Turn: 0");

        systemExit.setText("Exit");
        systemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(systemExit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endTurn)
                    .addComponent(goToOther)
                    .addComponent(turnClock))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainwindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {endTurn, goToOther, systemExit});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(turnClock)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToOther, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endTurn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(systemExit)
                .addGap(11, 11, 11))
            .addComponent(mainwindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToOtherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToOtherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_goToOtherActionPerformed

    private void systemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_systemExitActionPerformed

    private void endTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endTurnActionPerformed
        this.tick();
    }//GEN-LAST:event_endTurnActionPerformed
     
    /**
     * Tick is called after every endturn event. It calls Village's tick(),
     * which distributes the tick to all member's tick functions.
     * 
     * After tick, UI updates itself to reflect the new situation
     */
    private void tick(){
        
        this.village.tick();
        this.updateVillageScreen();
        
    }
    
    private void updateVillageScreen(){ 
        //villagers
        this.populationAmount.setText( this.village.getPopulation().getPopulationAmountAsString() );
//        this.populationAmount.setText(this.village.getPopulationAmountAsString()); 
        //constructed buildings
        this.updateConstructedBuildings();
    }
    
    private void
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FolkvillageUI().setVisible(true);
            }
        });
        
        
          
    }


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endTurn;
    private javax.swing.JButton goToOther;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainwindow;
    private javax.swing.JLabel populationAmount;
    private javax.swing.JButton systemExit;
    private javax.swing.JLabel turnClock;
    private javax.swing.JLabel villageLabel;
    // End of variables declaration//GEN-END:variables
}
