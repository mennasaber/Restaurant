/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NONA
 */
public class recommendation extends javax.swing.JPanel {

    FlowLayout Grid = new FlowLayout(FlowLayout.CENTER);

    /**
     * Creates new form recommendation
     */
    public recommendation() {
        initComponents();
        jPanel1.setLayout(Grid);
        load_items();
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
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(935, 491));
        setMinimumSize(new java.awt.Dimension(935, 491));
        setPreferredSize(new java.awt.Dimension(935, 491));
        setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));
        jPanel1.setOpaque(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        add(jPanel1);
        jPanel1.setBounds(340, 160, 260, 230);

        jLabel1.setBackground(new java.awt.Color(244, 108, 108));
        jLabel1.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recommendation");
        add(jLabel1);
        jLabel1.setBounds(260, 50, 430, 43);
        jLabel1.getAccessibleContext().setAccessibleName("Recommendation");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void load_items() {
        try {
            jPanel1.removeAll();
            jPanel1.revalidate();
            jPanel1.repaint();
            int i = 0;
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select item_id,SUM(quantity) from order_item group by item_id order by SUM(quantity) DESC");
            ResultSet result = statment.executeQuery();
            while (result.next() && i < 4) {
                load_(result.getInt("item_id"));
                i++;
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(recommendation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load_(int item_id) {
        try {
            GridBagConstraints gs = new GridBagConstraints();
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select * from item where item_id = " + item_id);
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                Item i = new Item(result.getString("name"), result.getFloat("price"));
                jPanel1.add(i, gs);
                i.setVisible(true);
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(recommendation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
