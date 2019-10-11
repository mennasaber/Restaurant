/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import com.toedter.calendar.JDateChooser;
import java.awt.GridBagConstraints;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Maryam
 */
public class manager extends person {

    manager(String name, String mobile_num, String user_name, String password) {
        super(name, mobile_num, user_name, password);
    }

    public manager() {

    }

    @Override
    public void viewmainmenu() {
    }

    public void addGeneralPromotion(JDateChooser endDate, JTextField disscount) throws ParseException {
        String query = "insert into promotion2 (discount,expiration_date,release_date )" + "values(?,?,?)";
        PreparedStatement statment;
        try {
            set_con.setconnection();
            Calendar cal = Calendar.getInstance();
            java.util.Date edate = endDate.getDate();
            java.sql.Date endSqlDate;
            endSqlDate = new java.sql.Date(edate.getTime());
            statment = set_con.con.prepareStatement(query);
            statment.setFloat(1, Float.parseFloat(disscount.getText()));//disscount
            statment.setDate(2, endSqlDate);//end date
            statment.setDate(3, new java.sql.Date(cal.getTimeInMillis()));//start date
            statment.execute();
            set_con.con.close();
            JOptionPane.showMessageDialog(null, "offer added successfully for all items ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }

    public void additem(JTextField text1, JTextField text2, JTextField text3, JTextField text4, JTextField text5) throws ClassNotFoundException, SQLException {
        ArrayList<String> category = getCategories();
        String query = "insert into item (name,price,photo,category_name,quantity,original_quantity)" + "values(?,?,?,?,?,?)";
        PreparedStatement statment;
        try {
            set_con.setconnection();
            boolean categoryExist = false;
            statment = set_con.con.prepareStatement(query);
            statment.setString(1, text1.getText());//name
            statment.setFloat(2, Float.parseFloat(text2.getText()));//price
            statment.setString(3, text3.getText());//photo
            categoryExist = category.contains(text4.getText());
            if (categoryExist) {
                JOptionPane.showMessageDialog(null, "Category is already existed please add another one ");
            } else {
                statment.setString(4, text4.getText());//category
            }
            statment.setInt(5, Integer.parseInt(text5.getText()));//quantity
             statment.setInt(6, Integer.parseInt(text5.getText()));//quantity
            statment.execute();
            JOptionPane.showMessageDialog(null, "Item has been added successfully");
            set_con.con.close();

        } catch (SQLException ex) {
            // JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    public void additem(JTextField text1, JTextField text2, JTextField text3, JComboBox comboBox, JTextField text5) {

        String query = "insert into item (name,price,photo,category_name,quantity,original_quantity)" + "values(?,?,?,?,?,?)";
        PreparedStatement statment;
        try {
            set_con.setconnection();
            statment = set_con.con.prepareStatement(query);
            statment.setString(1, text1.getText());//name
            statment.setFloat(2, Float.parseFloat(text2.getText()));//price
            statment.setString(3, text3.getText());//photo
            statment.setString(4, comboBox.getSelectedItem().toString());//category
            statment.setInt(5, Integer.parseInt(text5.getText()));//quantity
            statment.setInt(6, Integer.parseInt(text5.getText()));//quantity
            statment.execute();
            set_con.con.close();
            JOptionPane.showMessageDialog(null, "Item has been added successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    public void deleteitem(JLabel id) {
        try {
            set_con.setconnection();
            PreparedStatement deleteStatment = set_con.con.prepareStatement("delete from item where item_id =" + Integer.parseInt(id.getText()));
            deleteStatment.execute();
            set_con.con.close();
            JOptionPane.showMessageDialog(null, "Item deleted successfully");

        } catch (SQLException ex) {
            Logger.getLogger(Inven_item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewInvenoryItem(JLayeredPane layeredPane, JPanel p1, JPanel p2) {
        try {
            ArrayList<item_> itemList = null;
            itemList = getAllInvItems();
            layeredPane.setVisible(true);
            p1.setVisible(true);
            p2.setVisible(true);
            GridBagConstraints gs = new GridBagConstraints();
            for (item_ item : itemList) {

                Inven_item i = new Inven_item(item.getId(), item.getName(), item.getQuantity(),item.getOriginal_quantity(), item.getPhoto(), item.getPrice(), item.getavaragerate(),item.getDiscount(), item.getMessage(), item.getCategory_name(), item.isCheckedStatus());
                p2.add(i, gs);
                i.setVisible(true);
                // JOptionPane.showMessageDialog(null, "csc");
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Inventory1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<item_> getAllInvItems() throws ClassNotFoundException, SQLException {
        set_con.setconnection();
        PreparedStatement statment = set_con.con.prepareStatement("select * from item");
        ResultSet result = statment.executeQuery();
        ArrayList<item_> itemList = new ArrayList<>();
        while (result.next()) {
            PreparedStatement st = set_con.con.prepareStatement("SELECT AVG(rate) from rates where itemid =" + result.getInt("item_id"));
            ResultSet res = st.executeQuery();
            while (res.next()) {
                item_ i = new item_(result.getInt("item_id"),
                        result.getString("name"),
                        result.getInt("quantity"),
                        result.getInt("original_quantity"),
                        result.getString("photo"),
                        result.getFloat("price"),
                        res.getFloat("AVG(rate)"),
                        result.getFloat("discount"),                      
                        result.getString("offer_message"),
                        result.getString("category_name"),
                        result.getBoolean("checked")
                );
                // JOptionPane.showMessageDialog(null, result.getBoolean("checked"));
                itemList.add(i);
            }
        }
        set_con.con.close();
        return itemList;
    }

    public void update_checked_status(item_ i, JCheckBox box) throws SQLException {
        if (box.isSelected()) {
            set_con.setconnection();
            String update = "update`item` SET `checked`=? WHERE `item_id`=? ";
            PreparedStatement p = set_con.con.prepareStatement(update);
            p.setBoolean(1, true);
            p.setInt(2, i.getId());
            p.executeUpdate();
            set_con.con.close();
        } else {
            set_con.setconnection();
            String update = "update`item` SET `checked`=? WHERE `item_id`=? ";
            PreparedStatement p = set_con.con.prepareStatement(update);
            p.setBoolean(1, false);
            p.setInt(2, i.getId());
            p.executeUpdate();
            set_con.con.close();
        }
    }

    public ArrayList<String> getCategories() throws ClassNotFoundException, SQLException {
        set_con.setconnection();
        PreparedStatement statment = set_con.con.prepareStatement("select * from item");
        ArrayList<String> category = new ArrayList<>();
        ResultSet result = statment.executeQuery();
        while (result.next()) {

            category.add(result.getString("category_name"));
        }
        Set<String> category_set = new LinkedHashSet<>(category);
        category.clear();
        category.addAll(category_set);
        set_con.con.close();
        return category;
    }

    public void updateCategories(JComboBox combo) {
        ArrayList<String> category = new ArrayList<>();
        try {
            category = getCategories();
            combo.removeAllItems();
            for (String item : category) {
                combo.addItem(item);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addoffer(JTextField text1, JDateChooser chooser, JTextField text3, int id) throws SQLException {
        String query = "insert into promotion (disscount,end_date,message_offer ,itemId)" + "values(?,?,?,?)";
        int item_id = id;
        PreparedStatement statment;
        try {
            set_con.setconnection();
            java.util.Date date = chooser.getDate();
            java.sql.Date sqlDate;
            sqlDate = new java.sql.Date(date.getTime());
            statment = set_con.con.prepareStatement(query);
            statment.setFloat(1, Float.parseFloat(text1.getText()));//disscount
            statment.setDate(2, sqlDate);//date
            statment.setString(3, text3.getText());//message
            statment.setInt(4, item_id);
            statment.execute();
            set_con.con.close();
            JOptionPane.showMessageDialog(null, "offer added successfully");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }

    }

    public int get_Last_Entered_Item_Id() throws SQLException {
        set_con.setconnection();
        PreparedStatement statment = set_con.con.prepareStatement("select MAX(item_id) as lastId from item");
        ArrayList<String> itemId;
        itemId = new ArrayList<>();
        ResultSet result = statment.executeQuery();
        while (result.next()) {
            itemId.add(String.valueOf(result.getInt("lastId")));
        }
        set_con.con.close();

        int id = Integer.valueOf(itemId.get(0));
        return id;
    }

    public ArrayList<String> get_items(String category) throws SQLException {

        ArrayList<String> itemList = new ArrayList<>();
        set_con.setconnection();
        PreparedStatement statment1;
        statment1 = set_con.con.prepareStatement("select name from item where category_name='" + category + "'");
        ResultSet result = statment1.executeQuery();
        while (result.next()) {
            itemList.add(result.getString("name"));
        }
        set_con.con.close();
        return itemList;
    }

    public void updateItems_inCombo(JComboBox combo, String category) {
        ArrayList<String> items = new ArrayList<>();
        try {
            items = get_items(category);
            combo.removeAllItems();
            for (String i : items) {
                combo.addItem(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(manager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int get_Item_Id(String name) throws SQLException {
        set_con.setconnection();
        PreparedStatement statment = set_con.con.prepareStatement("select item_id from item where name='" + name + "'");
        ArrayList<String> itemId;
        itemId = new ArrayList<>();
        ResultSet result = statment.executeQuery();
        while (result.next()) {
            itemId.add(String.valueOf(result.getInt("item_id")));
        }
        set_con.con.close();

        int id = Integer.valueOf(itemId.get(0));
        return id;
    }

    public void set_item_toBe_edited(JLabel itemId, JComboBox c, JTextField t1, JTextField t2, JTextField t3, JTextField t4) throws SQLException {
        int id = Integer.valueOf(itemId.toString());
        set_con.setconnection();
        PreparedStatement statment1;
        statment1 = set_con.con.prepareStatement("select * from item where item_id='" + id + "'");
        ResultSet result = statment1.executeQuery();
        while (result.next()) {
            t1.setText(result.getString("name"));
            t2.setText(result.getString("price"));
            t2.setText(result.getString("quantity"));
            t2.setText(result.getString("photo"));
            c.setSelectedItem(result.getString("category_name"));
        }
        set_con.con.close();

    }

    public void adddeliveryboy() {
    }

    public void canceloffer() {
    }

    @Override
    public boolean login(String user, String pass) {
        if ("Omar Mohammed".equals(user) && "1122".equals(pass)) {
            setUser_name("Omar Mohammed");
            setPassword(pass);
            setUser_name(user);
            setMobile_num("01155393933");
            return true;
        } else {
            return false;
        }
    }

}
