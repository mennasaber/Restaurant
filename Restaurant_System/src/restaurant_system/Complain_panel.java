package restaurant_system;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import restaurant_system.Complain_manager;
import restaurant_system.Offers_Panel;
import restaurant_system.set_con;

/**
 *
 * @author pc
 */
public class Complain_panel extends javax.swing.JPanel {

     FlowLayout Grid=new FlowLayout(FlowLayout.LEFT);

     GridBagConstraints gs = new GridBagConstraints();
    public Complain_panel()  {
        
        initComponents();
        jPanel2.setLayout(Grid);
        load_complains();
     
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(935, 491));
        setMinimumSize(new java.awt.Dimension(935, 491));
        setPreferredSize(new java.awt.Dimension(935, 491));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 1, true));
        jPanel2.setMaximumSize(new java.awt.Dimension(435, 402));
        jPanel2.setMinimumSize(new java.awt.Dimension(435, 402));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(435, 402));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 370, -1));

        jLabel1.setBackground(new java.awt.Color(244, 108, 108));
        jLabel1.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COMplains");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, -1, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    private void load_complains() {
         try {
             set_con.setconnection();
             String q="select * from order_ where complain_message IS NOT NULL";
             PreparedStatement statment = set_con.con.prepareStatement(q);
             ResultSet result = statment.executeQuery();
             
             while(result.next())
             {
               Complain_manager c_m=new Complain_manager(result.getInt("order_id"), result.getString("complain_message"));
               jPanel2.add(c_m, gs);
               c_m.setVisible(true);
             }
             set_con.con.close();
         } catch (SQLException ex) {
             Logger.getLogger(Complain_panel.class.getName()).log(Level.SEVERE, null, ex);
         }
          
             
    
            
    }


}
