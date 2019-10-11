package restaurant_system;

import java.awt.GridBagConstraints;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import restaurant_system.set_con;

public class Special_Offer {

    private ArrayList<Item_Offer> item_list;

    public Special_Offer() {
        item_list = new ArrayList<Item_Offer>();
    }

    public ArrayList<Item_Offer> getItem_list() {
        return item_list;
    }

    public void setItem_list(ArrayList<Item_Offer> item_list) {
        this.item_list = item_list;
    }

    public ArrayList<Item_Offer> load_offers() {

        try {

            set_con.setconnection();
            String q = "select * from promotion ";
            PreparedStatement statment = set_con.con.prepareStatement(q);
            ResultSet result = statment.executeQuery();

            while (result.next()) {
                Item_Offer item_offer = new Item_Offer(result.getInt("promo_id"), result.getInt("itemid"), 
                        result.getFloat("disscount"), result.getString("message_offer"),  result.getDate("end_date"));

                item_list.add(item_offer);

            }
            set_con.con.close();
            

        } catch (SQLException ex) {
            Logger.getLogger(Offers_Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
      return item_list;
    }

}
