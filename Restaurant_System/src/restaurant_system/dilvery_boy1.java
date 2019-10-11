/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NONA
 */
public class dilvery_boy1 {
    
     public String get_boy_id() {
        String id = "0";
        try {
            while (Integer.valueOf(id) == 0) {
                set_con.setconnection();
                PreparedStatement state;
                state = set_con.con.prepareStatement("select * from delivery_boy where num_of_orders <2");
                ResultSet result = state.executeQuery();
                while (result.next()) {
                    id = result.getString("delivery_id");
                    break;
                }
                if (Integer.valueOf(id) == 0) {
                    
                    state = set_con.con.prepareStatement("update delivery_boy set num_of_orders = 0 where num_of_orders = 2 ");
                    state.execute();
                    
                }
                
                set_con.con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    //this function increment the number of orbers of the boy using id from above function

    public void increment_boy_orders(String a) {
        try {
            set_con.setconnection();
            PreparedStatement state;
            state = set_con.con.prepareStatement("UPDATE `delivery_boy` SET `num_of_orders` = num_of_orders+1 WHERE `delivery_id`=" + Integer.valueOf(a));
            state.executeUpdate();
            set_con.con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

