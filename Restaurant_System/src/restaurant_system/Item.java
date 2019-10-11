/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import com.mysql.cj.protocol.Resultset;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author NONA
 */
public class Item extends javax.swing.JPanel {

    item_ i;
    int id_user;
    String id_order;
    int rate;
    customer cus;

    public Item() {

    }

    public Item(String name, float price) {
        initComponents();
        label3.setText(name);
        label2.setText(String.valueOf(price));
        set_visible(false);
        //JOptionPane.showMessageDialog(null, "hnnn");
    }

    /**
     * Creates new form Item
     */
    public Item(int id, String name, int quantity, String photo, float price, float rate, float discount, String message, String category_name, int id_user, String id_order) {
        try {
            initComponents();
            set_visible(true);
            i = new item_(id, name, quantity, photo, price, rate, discount, message, category_name);
            load_data();
            this.id_user = id_user;
            this.id_order = id_order;
            cus = Home_Customer.user;
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Item(int id, String name, int quantity, String photo, float price, float discount, String message, String category_name) {
        initComponents();
        i = new item_(id, name, quantity, photo, price, discount, message, category_name);
        set_visible(false);
        load_data_manager();
    }

    /**
     * *
     * Load data of item in his place
     */
    private void load_data() throws SQLException {
        label3.setText(i.getName());
        label2.setText(String.valueOf(i.getPrice()));
        if (i.getRate() <= 1) {
            jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
            jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
            jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
            jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        } else if (i.getRate() <= 2) {
            jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
            jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
            jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        } else if (i.getRate() <= 3) {
            jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
            jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        } else if (i.getRate() <= 4) {
            jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));

        } else if (i.getRate() <= 5) {
            jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
            jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\New folder\\new new new-20190505T234641Z-001\\new new new\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));

        }
    }

    void set_visible(boolean b) {
        jLabel4.setVisible(b);
        jLabel7.setVisible(b);
        jLabel8.setVisible(b);
        jLabel11.setVisible(b);
        jLabel9.setVisible(b);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label7 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        label7.setBackground(new java.awt.Color(244, 108, 108));
        label7.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        label7.setForeground(new java.awt.Color(255, 255, 255));
        label7.setText("   Add To Cart");
        label7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label7MousePressed(evt);
            }
        });
        label7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                label7KeyPressed(evt);
            }
        });

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_Food_100px.png"))); // NOI18N

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setBackground(new java.awt.Color(51, 51, 51));
        label2.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        label2.setForeground(new java.awt.Color(255, 255, 255));
        label2.setText("               Price");

        label3.setAlignment(java.awt.Label.CENTER);
        label3.setBackground(new java.awt.Color(51, 51, 51));
        label3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        label3.setForeground(new java.awt.Color(255, 255, 255));
        label3.setText("                     Name");

        jLabel4.setBackground(new java.awt.Color(102, 102, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_star_16px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_star_16px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_star_16px.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_star_16px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_star_16px.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(0, 0, 0)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void label7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label7MousePressed

    private void label7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_label7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_label7KeyPressed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.rate = 1;
        jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));

        cus.Rate(rate, i.getId(), cus.getId());
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.rate = 2;
        jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));

        cus.Rate(rate, i.getId(), cus.getId());
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.rate = 3;
        jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));
        jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));

        cus.Rate(rate, i.getId(), cus.getId());
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.rate = 4;
        jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_16px.png"));

        cus.Rate(rate, i.getId(), cus.getId());
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.rate = 5;
        jLabel4.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel8.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel7.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel11.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        jLabel9.setIcon(new ImageIcon("C:\\Users\\dell\\OneDrive\\Desktop\\Restaurant_System(all_tasks)-20190502T113903Z-001\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\icons8_star_half_empty_16px.png"));
        cus.Rate(rate, i.getId(), cus.getId());
    }//GEN-LAST:event_jLabel9MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label7;
    // End of variables declaration//GEN-END:variables

    private void load_data_manager() {
        label3.setText(i.getName());
        label2.setText(String.valueOf(i.getPrice()));
    }

}
