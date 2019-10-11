/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NONA
 */
public class customer extends person {

    private String address;
    private boolean firstvisit;
    private int id;

    public customer() {
    }

    customer(String name, String mobile_num, String user_name, String password, int id, String address, boolean firstvisit) {
        super(name, mobile_num, user_name, password);
        this.id = id;
        this.address = address;
        this.firstvisit = firstvisit;
    }

    public String getAddress() {
        return address;
    }

    public boolean isFirstvisit() {
        return firstvisit;
    }

    public int getId() {
        return id;
    }

    @Override
    public void viewmainmenu() {
    }

    /**
     * *
     * This Method Calling when Customer Finish his order , Update all
     * information about order
     *
     * @param a is a delivery boy id
     * @param total total of order after discount
     * @param id_order id of order that user make it
     */
    public void make_order(String a, double total, String id_order) {
        try {
            set_con.setconnection();
            PreparedStatement statment2 = set_con.con.prepareStatement("UPDATE `order_` SET `time` = '"
                    + LocalTime.now() + "', `delivery_charge` = 10 ,`delivery_id` = " + Integer.valueOf(a) + ",`total`=" + total + ",`balance` ="
                    + (total + 10) + "WHERE order_id =" + Integer.valueOf(id_order));
            // use executeUpdate when delete or update 
            statment2.executeUpdate();
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirstvisit(boolean firstvisit) {
        this.firstvisit = firstvisit;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*   public boolean login(String user, String pass) {
     try {
     set_con.setconnection();
     PreparedStatement st = set_con.con.prepareStatement("select * from customer where  user_name = '" + user + "' and password = '" + pass + "'");
     ResultSet r = st.executeQuery();
     if (r.next()) {
     this.setId(r.getInt("cus_id"));
     super.setUser_name(r.getString("user_name"));
     super.setMobile_num(r.getString("mobile"));
     this.setAddress(r.getString("address"));
     super.setPassword(r.getString("password"));
     this.setFirstvisit(r.getBoolean("first_time"));
     set_con.con.close();
     return true;
     } else {
     set_con.con.close();
     JOptionPane.showMessageDialog(null, "Incorrect User Name or Password");
     return false;
     }
    
     } catch (SQLException ex) {
     Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
     return false;
    
     }
     }*/
    public void registeration(String user, String mob, String add, String pass) {
        String insert = "insert into customer values (NULL,'" + user + "','" + mob + "','" + add + "','" + pass + "','1')";
        try {
            set_con.runNONQuery(insert);
            // this.login(user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(sign_in_up.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Rate(int rate_num, int itemid, int custid) {
        try {
            set_con.setconnection();
            String s = "select * from rates where itemid = '" + itemid + "' and customerid = '" + custid + "'";
            Statement st = set_con.con.createStatement();
            st.executeQuery(s);
            if (st.getResultSet().next()) {
                //update rate 
                String update = "UPDATE `rates` SET `rate`=" + rate_num + " WHERE customerid= " + custid + " and itemid = " + itemid;
                set_con.runNONQuery(update);
            } else {
                String insert = "insert into rates values ('" + itemid + "','" + custid + "','" + rate_num + "')";
                set_con.runNONQuery(insert);
                System.out.println("OK");
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void update_data(customer cus) {
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("UPDATE `customer` SET"
                    + "`user_name`=?,"
                    + "`mobile`=?,`address`=?,`password`=?"
                    + " WHERE cus_id=" + cus.getId());
            statment.setString(1, cus.getUser_name());
            statment.setString(2, cus.getMobile_num());
            statment.setString(3, cus.getAddress());
            statment.setString(4, cus.getPassword());
            statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean login(String user, String pass) {
        try {
            set_con.setconnection();
            PreparedStatement st = set_con.con.prepareStatement("select * from customer where  user_name = '" + user + "' and password = '" + pass + "'");
            ResultSet r = st.executeQuery();
            if (r.next()) {
                this.setId(r.getInt("cus_id"));
                super.setUser_name(r.getString("user_name"));
                super.setMobile_num(r.getString("mobile"));
                this.setAddress(r.getString("address"));
                super.setPassword(r.getString("password"));
                this.setFirstvisit(r.getBoolean("first_time"));
                set_con.con.close();
                return true;
            } else {
                set_con.con.close();
                JOptionPane.showMessageDialog(null, "Incorrect User Name or Password");
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(customer.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    void Add_feedback(int id, String feed) {
        try {

            set_con.setconnection();
            String q = "select * from order_ where order_id=" + id + " and cus_id=" + Home_Customer.user.getId();

            PreparedStatement statment = set_con.con.prepareStatement(q);
            ResultSet result = statment.executeQuery();
            if (result.next()) {

                //UPDATE order_ SET complain_message="hjhjhjhjhj" where order_id=446
                String n = "UPDATE order_ SET feed_back='" + feed + "' where order_id=" + id;
                PreparedStatement stat = set_con.con.prepareStatement(n);
                stat.executeUpdate();
            } else {
                JOptionPane.showMessageDialog(null,
                        "This Order Do not exict", "Warning", JOptionPane.WARNING_MESSAGE);
            }

            set_con.con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Offers_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
