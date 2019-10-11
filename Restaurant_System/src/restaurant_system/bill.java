/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author NONA
 */
public class bill extends order {

    String bill_date;
    int cus_id;
    float total = 0;
    double price = 0;
    float newtotal=0;
    int discount=0;
    float discount2=0;
    String name;
    ArrayList<order_in_bill_1> arr=new ArrayList<order_in_bill_1> ();
    ArrayList<String> arr2=new ArrayList<String> ();
    ArrayList<Bill_card> arr3=new ArrayList<Bill_card> ();
    Bill_11 b;
       order_in_bill_1 o ;
       
    public ArrayList<order_in_bill_1> load(int id) {
         
       try {
            set_con.setconnection();
            PreparedStatement statment1;
           
            statment1 = set_con.con.prepareStatement("SELECT * FROM `order_item` where order_id ='"+id+"'");
            ResultSet result = statment1.executeQuery();     
            while (result.next()) {
                 System.out.print(id);
                calculate_total_each_item_bill(result.getInt("item_id"),result.getInt("quantity"));
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
  
       }
     public void calculate_total_each_item_bill(int id,int quantity) {
        float total = 0;
        float off=0;
        int offer=0;
           try {
            set_con.setconnection();
            PreparedStatement statment2;
            String query = "SELECT * FROM `promotion` where itemId =" + id;
            statment2 = set_con.con.prepareStatement(query);
            ResultSet result1 = statment2.executeQuery();
            //if result1.next() doesn't write -> there is a problem , total =0 
            while (result1.next()) {
                offer=result1.getInt("disscount");
                off=(float)result1.getInt("disscount")/100;
                off*=quantity;
               }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
           try {
            
            set_con.setconnection();
            PreparedStatement statment2;
            String query = "SELECT * FROM `item` where item_id =" + id;
            statment2 = set_con.con.prepareStatement(query);
            ResultSet result1 = statment2.executeQuery();
            //if result1.next() doesn't write , there is a problem , total =0 
            while (result1.next()) {
                total = result1.getInt("price") * quantity;
                total-=total*off;
                newtotal+=total;
                 o =new order_in_bill_1(result1.getString("name"), quantity, result1.getInt("price"),total,offer);
                 arr.add(o);
                 }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
     
      
    }
     

    public void transfer_bill_data(ArrayList<String> a) {
        try {

            set_con.setconnection();
            PreparedStatement statment1;
            statment1 = set_con.con.prepareStatement("INSERT INTO `bill`( `order_id`, `bill_date`, `delivery_charges`,"
                    + " `total`, `promotion_id`, `discount_percentage`, `total_after_discount`, `customer_id`) "
                    + "VALUES ('" + Integer.valueOf(Home.ord.getId()) + "','" + bill_date + "','"+a.get(0)+"','" + a.get(1) + "','"+a.get(2)+"','"+a.get(3)+"','"+a.get(4)+"','" + cus_id + "')");
            // statment1.setInt(1, id_user);
            // statment1.execute();
            statment1.executeUpdate();
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<String> get_data(String date){
        bill_date=date;
         try {
            set_con.setconnection();
            PreparedStatement statment1,statement2;
            statment1 = set_con.con.prepareStatement("SELECT * FROM `order_` where order_id =" + Home.ord.getId());
            ResultSet result = statment1.executeQuery();     
            while (result.next()) {
                //to subtract two dates in mysql
                //SELECT DATEDIFF(dateone, datetwo) AS d FROM tablename
                //SELECT id FROM promotion2 where DATEDIFF(expiration_date, '2019-05-05')
                arr2.add(Float.toString(result.getFloat("delivery_charge")));
                arr2.add(Double.toString(newtotal+10));
                // newtotal=result.getFloat("balance");
                
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         boolean shit=false;
         
          try {
            set_con.setconnection();
            PreparedStatement statment;
            statment= set_con.con.prepareStatement("SELECT * FROM promotion2 where DATEDIFF(expiration_date, '"+date+"');");
            ResultSet result2 = statment.executeQuery();
            System.out.println(date);
            while (result2.next()) {
                shit=true;
                 arr2.add(Integer.toString(result2.getInt("id")));
               discount=result2.getInt("discount");
               arr2.add(Integer.toString(discount));
               
              discount2 =(float)discount/100;
               newtotal=newtotal-(newtotal*discount2);
            arr2.add(Float.toString(newtotal));
               break;
            }
            if(!shit){
                arr2.add("0");
                arr2.add("0");
               arr2.add(Float.toString(newtotal));
            }
//           
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
          
          transfer_bill_data(arr2);
        return arr2;
    }
    public ArrayList<Bill_card> load_bills() {
        try {
           
            set_con.setconnection();
            PreparedStatement statment2;
            String query = "SELECT * FROM `bill`where customer_id='"+cus_id+"'" ;
            statment2 = set_con.con.prepareStatement(query);
            ResultSet result1 = statment2.executeQuery();
            while (result1.next()) {
               Bill_card bill=new Bill_card(result1.getInt("order_id"));
                arr3.add(bill);
         }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr3;
        
    }
}
