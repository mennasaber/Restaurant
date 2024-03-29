/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static restaurant_system.Home_Customer.user;
import restaurant_system.Inventory1;
import restaurant_system.sign_in_up;

/**
 *
 * @author NONA
 */
public class Home_Manager extends javax.swing.JFrame {

    GridBagLayout Grid = new GridBagLayout();

    /**
     * Creates new form Home_Manager
     */
    public Home_Manager() throws SQLException {
        initComponents();
        load_inventory();
    }

    private void load_inventory() {
        try {
            main.removeAll();
            main.revalidate();
            main.repaint();
            System.out.print("bjnm");
            Inventory1 i = new Inventory1();

            main.setLayout(Grid);
            jLabel12.setText("Omar Mohammed");
            GridBagConstraints gs = new GridBagConstraints();
            gs.gridy = 100;
            main.add(i, gs);
            i.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Home_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(990, 620));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 0, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_strike_32px.png"))); // NOI18N
        jLabel10.setToolTipText("View Complaine");
        jLabel10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/inventory (2).png"))); // NOI18N
        jLabel11.setToolTipText("IView Inventory");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel11MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_home_page_32px.png"))); // NOI18N
        jLabel13.setToolTipText("Main Menu");
        jLabel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 40));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_exit_32px.png"))); // NOI18N
        jLabel14.setToolTipText("Log Out");
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel14MouseReleased(evt);
            }
        });
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/feedback_32px.png"))); // NOI18N
        jLabel3.setToolTipText("FeedBack");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 560));

        jPanel6.setBackground(new java.awt.Color(204, 0, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(204, 0, 0));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("User Name");
        jLabel12.setToolTipText("User Name");
        jLabel12.setOpaque(true);
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 160, 30));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 980, 30));

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel7.add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 490));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 950, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1021, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        load_inventory();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseReleased
        // TODO add your handling code here:      
    }//GEN-LAST:event_jLabel11MouseReleased
    private void load_home() {
        main.removeAll();
        main.revalidate();
        main.repaint();
        Home h = new Home();
        main.setLayout(Grid);
        GridBagConstraints gs = new GridBagConstraints();
        main.add(h, gs);
        h.setVisible(true);
    }

    private void load_feedback() {
        main.removeAll();
        main.revalidate();
        main.repaint();
        feed_panel f_p = new feed_panel();
        main.setLayout(Grid);
        GridBagConstraints gs = new GridBagConstraints();
        main.add(f_p, gs);
        f_p.setVisible(true);
    }
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        load_home();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        sign_in_up s = new sign_in_up();
        s.pack();
        s.setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel14MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        load_feedback();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        load_complain();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home_Manager().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Home_Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void load_complain() {
        main.removeAll();
        main.revalidate();
        main.repaint();
        Complain_panel c_p = new Complain_panel();
        main.setLayout(Grid);
        GridBagConstraints gs = new GridBagConstraints();
        main.add(c_p, gs);
        c_p.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables

}
