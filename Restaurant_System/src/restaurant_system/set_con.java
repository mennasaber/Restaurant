/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static restaurant_system.set_con.con;

/**
 *
 * @author NONA
 */
public class set_con {
      public static Connection con ;
     private static String url="" ;
    private static void setURL(){
    url = "jdbc:mysql://localhost:3306/restaurant?userUnicode=true&characterEncoding=UTF-8";
    }
    public static void setconnection(){     
        try {
            setURL();
            con = DriverManager.getConnection(url,"root","");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }
    public static boolean runNONQuery(String s) throws SQLException{
   try { set_con.setconnection();
    Statement ST = con.createStatement();
    ST.execute(s);
    con.close();
    
    return true;}
   catch (SQLException ex ){
       JOptionPane.showMessageDialog(null,ex.getMessage());
        return false ; 
   }
    }
}
