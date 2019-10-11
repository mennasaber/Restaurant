/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author NONA
 */
public class item_ {

    private int id;
    private int quantity;
    //contain path of photo
    private String photo;
    private String name;
    private float price;
    private float rate;
    private float discount;
    private String message;
    private String category_name;
    private boolean checkedStatus;
    private int original_quantity;

    item_(int id, String name, int quantity, int original_quantity, String photo, float price, float rate, float discount, String message, String category_name, boolean checkedStatus) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.photo = photo;
        this.price = price;
        this.rate = rate;
        this.discount = discount;
        this.message = message;
        this.category_name = category_name;
        this.checkedStatus = checkedStatus;
        this.original_quantity = original_quantity;
    }

    public String getName() {
        return name;
    }
   public float getavaragerate()
   {
   return this.rate;
   }
    item_(int id, String name, int quantity, String photo, float price, float rate, float discount, String message, String category_name) {
        try {
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.photo = photo;
            this.price = price;
            this.discount = discount;
            this.message = message;
            this.category_name = category_name;
            set_con.setconnection();
            PreparedStatement st = set_con.con.prepareStatement("select * from rates where itemid = " + id + "  and customerid = " + Home_Customer.user.getId());
            ResultSet r = st.executeQuery();

            if (r.next()) {
                this.rate = r.getFloat("rate");
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(item_.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    item_(int id, String name, int quantity, String photo, float price, float discount, String message, String category_name) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.photo = photo;
        this.price = price;
        this.discount = discount;
        this.message = message;
        this.category_name = category_name;
    }

    public boolean isCheckedStatus() {
        return checkedStatus;
    }

    public int getOriginal_quantity() {
        return original_quantity;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPhoto() {
        return photo;
    }

    public float getPrice() {
        return price;
    }

    public float getRate() throws SQLException {
        try {
            set_con.setconnection();
            PreparedStatement st = set_con.con.prepareStatement("select * from rates where itemid = " + id + " and customerid = " + Home_Customer.user.getId());
            ResultSet r = st.executeQuery();
            if (r.next()) {

                this.rate = r.getFloat("rate");
                set_con.con.close();
                return this.rate;
            }
        } catch (SQLException ex) {
            Logger.getLogger(item_.class.getName()).log(Level.SEVERE, null, ex);
            set_con.con.close();
        }
        set_con.con.close();
        return 123;
    }

    public float getDiscount() {
        return discount;
    }

    public String getMessage() {
        return message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    void LoadData(JLabel label1, JLabel label2, JLabel label3, JLabel label4, JLabel label5, JLabel label6, JLabel label7, JCheckBox box) {
        label1.setText(getName());
        label2.setText(String.valueOf(getId()));
        label3.setText(String.valueOf(getPrice()));
        label5.setText(String.valueOf(getOriginal_quantity()-getQuantity()));
        label6.setText(String.valueOf(getQuantity()));
        label4.setText(String.valueOf(getavaragerate()));
        box.setSelected(isCheckedStatus());
    }

    public void update_data(item_ i) throws SQLException {
        set_con.setconnection();
        String updateQuery = "UPDATE `item` SET `name`=?,`price`=?,`photo`=?,`category_name`=?,`quantity`=? where item_id=?";
        PreparedStatement p = set_con.con.prepareStatement(updateQuery);
        p.setString(4, i.getCategory_name());
        p.setString(1, i.getName());
        p.setFloat(2, i.getPrice());
        p.setInt(5, i.getQuantity());
        p.setString(3, i.getPhoto());
        p.setInt(6, i.getId());
        p.executeUpdate();
        set_con.con.close();
    }
}
