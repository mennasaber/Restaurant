/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author pc
 */
public class Bills_container extends javax.swing.JPanel {
int cus_id;
bill b=new bill();
ArrayList<Bill_card> a=new ArrayList<Bill_card>();
    /**
     * Creates new form Bills_container
     */
    public Bills_container(int cus_id) {
       
        initComponents();
         GridBagConstraints gs4 = new GridBagConstraints();
         this.cus_id=cus_id;
         BoxLayout boxlayout = new BoxLayout(jPanel2, BoxLayout.Y_AXIS);
          //GridLayout grid = new GridLayout(0, 1, 0, 0);
         jPanel2.setLayout(boxlayout);
        a= b.load_bills();
         for(int i=0 ; i<a.size();i++){
             System.out.print("cxczxc");
              jPanel2.add(a.get(i));
               a.get(i).setVisible(true);
         }
         JScrollPane p = new JScrollPane(jPanel2);
        
    }
//     public void load_bills() {
//        try {
//            GridBagConstraints gs4 = new GridBagConstraints();
//            set_con.setconnection();
//            PreparedStatement statment2;
//            String query = "SELECT * FROM `bill`where customer_id='"+cus_id+"'" ;
//            statment2 = set_con.con.prepareStatement(query);
//            ResultSet result1 = statment2.executeQuery();
//            while (result1.next()) {
//                // order_in_bill o =new order_in_bill(result1.getString("name"), quantity, result1.getInt("price"),total);
//                Bill_card bill=new Bill_card(result1.getInt("order_id"),result1.getString("bill_date"),result1.getFloat("total"));
//                jPanel2.add(bill);
//                bill.setVisible(true);
//           // panel15.add(o);
//           // o.setVisible(true);
//            }
//            set_con.con.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(935, 491));
        jPanel1.setMinimumSize(new java.awt.Dimension(935, 491));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));
        jPanel2.setMaximumSize(new java.awt.Dimension(276, 399));
        jPanel2.setMinimumSize(new java.awt.Dimension(276, 399));
        jPanel2.setPreferredSize(new java.awt.Dimension(276, 399));
        jPanel2.setRequestFocusEnabled(false);

        jLabel1.setBackground(new java.awt.Color(244, 108, 108));
        jLabel1.setFont(new java.awt.Font("Castellar", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Previous Bills");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(339, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(317, 317, 317))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 992, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
