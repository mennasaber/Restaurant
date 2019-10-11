/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;
import java.awt.GridBagConstraints;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Item_Offer {
        private String message;
    private int item_id;
   
    private float disscount;
    private Date end_date;

   
    private int promo_id;
    Item_Offer(int promo_id, int item_id, float disscount, String message_offer,  Date end_date) {
        this.disscount=disscount;
        this.item_id=item_id;
        this.message=message_offer;
        
        this.promo_id=promo_id;
        this.end_date=end_date;
        
    }
 public int getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(int promo_id) {
        this.promo_id = promo_id;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    

    public float getDisscount() {
        return disscount;
    }

    public void setDisscount(float disscount) {
        this.disscount = disscount;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date start_date) {
        this.end_date = start_date;
    }
   
}
