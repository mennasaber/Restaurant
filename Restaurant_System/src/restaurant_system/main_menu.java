/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NONA
 */
public class main_menu {

    private ArrayList<category> listofcategory;

    public main_menu() {
        this.listofcategory = new ArrayList<category>();
    }

    public ArrayList<category> getListofcategory() {
        return listofcategory;
    }

    public ArrayList<category> load_category() {
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select * from item where checked = 1 ORDER BY category_name");
            ResultSet result = statment.executeQuery();
            String name = "";
            int i = 0;
            category categ = new category();
            boolean check = result.next();
            while (check) {
                String name_cate = result.getString("category_name");
                if (!name.equals(name_cate) && i != 0) {
                    name = name_cate;
                    listofcategory.add(categ);
                    categ = new category();
                }
                item_ item = new item_(result.getInt("item_id"), result.getString("name"),
                        result.getInt("quantity"), result.getString("photo"),
                        result.getFloat("price"), result.getInt("rate"),
                        result.getFloat("discount"), result.getString("offer_message"),
                        name_cate);
                categ.setName(name_cate);
                categ.listofitems.add(item);
                name = name_cate;
                i++;
                check = result.next();
                if (!check) {
                    listofcategory.add(categ);
                }
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(main_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listofcategory;
    }
    
     public ArrayList<category> load_category_manager() {
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select * from item where checked = 1 ORDER BY category_name");
            ResultSet result = statment.executeQuery();
            String name = "";
            int i = 0;
            category categ = new category();
            boolean check = result.next();
            while (check) {
                String name_cate = result.getString("category_name");
                if (!name.equals(name_cate) && i != 0) {
                    name = name_cate;
                    listofcategory.add(categ);
                    categ = new category();
                }
                item_ item = new item_(result.getInt("item_id"), result.getString("name"),
                        result.getInt("quantity"), result.getString("photo"),
                        result.getFloat("price"),
                        result.getFloat("discount"), result.getString("offer_message"),
                        name_cate);
                categ.setName(name_cate);
                categ.listofitems.add(item);
                name = name_cate;
                i++;
                check = result.next();
                if (!check) {
                    listofcategory.add(categ);
                }
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(main_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listofcategory;
    }

}
