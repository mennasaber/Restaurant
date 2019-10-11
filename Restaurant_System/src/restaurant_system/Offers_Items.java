/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.FlowLayout;
import java.sql.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Offers_Items extends javax.swing.JPanel {

    /**
     * Creates new form Offers_Items
     */
    private String message;
    private String item_name; 
    private String item_pic;
    private float item_dis;
    private Date item_date;
    public Offers_Items(String m,String n,String p,float disscount , Date end_date) {
       
         initComponents();
        this.message=m;
        this.item_name=n;
        this.item_pic=p;
        this.item_date=end_date;
        this.item_dis=disscount;
     
        load_labels();
    }
String s="";
    private void load_labels() {
      jLabel4.setText(item_name);
      jLabel3.setText(message);
      jLabel6.setText(String.valueOf(item_dis));
      jLabel5.setText(String.valueOf(item_date));
     // jLabel1.setIcon(new ImageIcon("F:\\projects\\OOP\\Restaurant_System(all_tasks_red)\\Restaurant_System(all_tasks)\\Restaurant_System\\src\\restaurant_system\\Chicken_salad.png"));
    //  jLabel1.setLayout(new FlowLayout());
       // JOptionPane.showMessageDialog(null,item_pic );
//jLabel1.setIcon(new ImageIcon(item_pic));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(51, 51, 51));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(451, 101));
        setMinimumSize(new java.awt.Dimension(451, 101));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/restaurant_system/icons8_Food_100px.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 100, 100));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Offer_Message");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 110, 20));

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("  Item_Name");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, 32));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("End_Date");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 120, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Disscount");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 160, 30));
        jLabel6.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    
}
