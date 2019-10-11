/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

/**
 *
 * @author NONA
 */
public abstract class person {
    private String name;
    private String mobile_num;
    private String user_name;
    private String password;
    
    person(String name,String mobile_num,String user_name,String password)
    {
    this.name = name;
    this.mobile_num = mobile_num;
    this.user_name = user_name;
    this.password = password;
    }

    public person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile_num() {
        return mobile_num;
    }

    public void setMobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public abstract boolean login(String user, String pass);   
    public void logout(){}   
    public abstract void viewmainmenu(); 
}
