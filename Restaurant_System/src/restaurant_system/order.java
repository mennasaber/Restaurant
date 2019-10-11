/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NONA
 */
public class order {

    private String id;
    private int id_customer;
    private double total;
    private float balance;
    private int dilvery_boy_id;
    private float delivery_charge;
    private Time time;
    private ArrayList listofitems;

    public order() {
    }

    public order(String id, int id_customer, float total, float balance, int dilvery_boy_id, float delivery_charge, Time time, List listofitems) {
        this.id = id;
        this.id_customer = id_customer;
        this.total = total;
        this.balance = balance;
        this.dilvery_boy_id = dilvery_boy_id;
        this.delivery_charge = delivery_charge;
        this.time = time;
        // this.listofitems = listofitems;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getDilvery_boy_id() {
        return dilvery_boy_id;
    }

    public void setDilvery_boy_id(int dilvery_boy_id) {
        this.dilvery_boy_id = dilvery_boy_id;
    }

    public float getDelivery_charge() {
        return delivery_charge;
    }

    public void setDelivery_charge(float delivery_charge) {
        this.delivery_charge = delivery_charge;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public ArrayList getListofitems() {
        return listofitems;
    }

    public void setListofitems(ArrayList listofitems) {
        this.listofitems = listofitems;
    }

    public float calculate_total_each_item(int quantity, int id) {
        float total = 0;
        try {
            set_con.setconnection();
            PreparedStatement statment2;
            String query = "SELECT * FROM `item` where item_id =" + id;
            statment2 = set_con.con.prepareStatement(query);
            ResultSet result1 = statment2.executeQuery();
            //if result1.next() doesn't write -> there is a problem , total =0 
            while (result1.next()) {
                total = result1.getInt("price") * quantity;
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public boolean check_first_order(int user_id) {
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("Select count(*) from order_ where cus_id= " + user_id);
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                return result.getLong(1) == 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void calculate_total(String id_order, int user_id) {
        try {
            total = 0;
            set_con.setconnection();
            PreparedStatement statment1;
            statment1 = set_con.con.prepareStatement("SELECT * FROM `order_item` where order_id ='" + Integer.valueOf(id_order) + "'");
            ResultSet result = statment1.executeQuery();
            while (result.next()) {
                total += calculate_total_each_item(result.getInt("quantity"), result.getInt("item_id"));
            }
            if (check_first_order(user_id)) {
                total = total - (total * 0.3);
            } else if (total > 1000) {
                total = total - (total * 0.2);
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean add_item_to_cart(String order_id, int item_id) {
        try {
            if (check_quantity(item_id)) {
                set_con.setconnection();
                if (!check_existing(order_id, item_id)) {
                    PreparedStatement statment1 = set_con.con.prepareStatement("INSERT INTO `order_item`(`order_id`, `item_id`, `quantity`) "
                            + "VALUES (?,?,1)");
                    statment1.setInt(1, Integer.valueOf(order_id));
                    statment1.setInt(2, item_id);
                    statment1.execute();
                } else if (check_existing(order_id, item_id)) {
                    PreparedStatement statment2 = set_con.con.prepareStatement("UPDATE `order_item` SET `quantity`= quantity+1 WHERE order_id = '" + Integer.valueOf(order_id) + "'and item_id = '" + item_id + "'");
                    statment2.execute();
                }
                set_con.con.close();
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean check_quantity(int item_id) {
        boolean check = false;
        try {
            set_con.setconnection();
            PreparedStatement statment
                    = set_con.con.prepareStatement("select quantity from item where item_id ="
                            + item_id);
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                if (result.getInt("quantity") != 0) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public boolean check_existing(String order_id, int item_id) {
        boolean check = false;
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select * from order_item");
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                if (result.getString("order_id").equals(order_id) && result.getInt("item_id") == item_id) {
                    check = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
        return check;
    }

    public void update_each_item(int item_id, int quantity) {
        try {
           
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("UPDATE `item` SET `quantity`= quantity+" + quantity + " WHERE item_id=" + item_id);
            statment.executeUpdate();
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update_quantity_after_delete(int order_id) {
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select * from order_item where order_id=" + order_id);
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                update_each_item(result.getInt("item_id"), result.getInt("quantity"));
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete_item_from_order(int order_id, int item_id, int quantity) {
        try {

            update_each_item(item_id, quantity);
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("DELETE FROM `order_item` WHERE order_id= ? and item_id=?");
            statment.setInt(1, order_id);
            statment.setInt(2, item_id);
            statment.executeUpdate();
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Order_Cart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
