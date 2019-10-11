/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.List;
import java.util.ArrayList;
/**
 *
 * @author NONA
 */
public class category {
    private String name;
    public ArrayList<item_> listofitems;

    public category() {
        listofitems = new ArrayList<item_>();
    }
    category(String name) {
        this.name = name;
        loaditems();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void loaditems() {
    }

    public String getName() {
        return name;
    }
}
