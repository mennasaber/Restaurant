/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant_system;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author NONA
 */
public class Home extends javax.swing.JPanel {

    FlowLayout Grid = new FlowLayout(FlowLayout.LEFT);
    GridLayout grid2 = new GridLayout(0, 1, 0, 0);
    GridLayout grid3 = new GridLayout(0, 5, 0, 0);
    GridLayout grid = new GridLayout(0, 5, 3, 3);
    static order ord;
    item_ itm;
    Bill_11 b;
    customer user;
    main_menu menu;
    boolean combo_visiable = false;

    public Home() {
        initComponents();
        jTabbedPane1.setPreferredSize(new Dimension(592, 452));
        jTabbedPane1.setMinimumSize(new Dimension(592, 452));
        jTabbedPane1.setMaximumSize(new Dimension(592, 452));
        menu = new main_menu();
        //  jTabbedPane1.setPreferredSize(new Dimension(592, 452));
        jPanel14.setVisible(false);
        jScrollPane1.setVisible(false);
        jPanel1.setVisible(false);
        jButton1.setVisible(false);
        jButton4.setVisible(false);
        jButton5.setVisible(false);
        jComboBox1.setVisible(false);
        jLabel11.setVisible(false);
        combo_visiable = true;
        load_items_to_manager();
        // JOptionPane.showMessageDialog(jComboBox1, "xcx");
    }

    /**
     * *
     * Creates new form Home
     *
     * @param user
     */
    public Home(customer user) {
        ord = new order();
        initComponents();
        jTabbedPane1.setPreferredSize(new Dimension(592, 452));
        jTabbedPane1.setMinimumSize(new Dimension(592, 452));
        jTabbedPane1.setMaximumSize(new Dimension(592, 452));
        this.user = user;
        ord.setId_customer(this.user.getId());
        boy = new dilvery_boy1();
        // jScrollPane1.createVerticalScrollBar();
        //jScrollPane1.setHorizontalScrollBar(null);
        set_layout();
        menu = new main_menu();
        //  set_layout();
        generate_id_order();
        jLabel11.setText("Cold Drink");
        //JScrollPane sp = new JScrollPane(jPanel15);
        load_items();
        load_item_in_combo();
        default_values_total();
    }

    private void set_panelfirst(JPanel panel, String name_c, int index) {
        panel.setLayout(grid);
        jTabbedPane1.setTitleAt(index, name_c);

    }

    private void set_panelsecond(JPanel panel, String name_c, int index) {
        panel.setLayout(grid3);
        jTabbedPane1.setTitleAt(index, name_c);

    }

    private void set_scroll(JPanel panel, String name) {
        JScrollPane sp2 = new JScrollPane(panel);
        sp2.setName(name);
        jTabbedPane1.add(sp2);
    }

    /**
     * *
     * load items from Database to UI "Main Menu"
     */
    private void load_items() {
        ArrayList<category> listofcategory = menu.load_category();
        GridBagConstraints gs = new GridBagConstraints();
        String name_c = listofcategory.get(0).getName();
        int index = 0;
        JPanel panel = new JPanel();
        jTabbedPane1.add(panel);
        set_panelfirst(panel, name_c, index);
        for (category cate : listofcategory) {
            for (item_ item : cate.listofitems) {

                try {
                    Item i = new Item(item.getId(), item.getName(), item.getQuantity(),
                            item.getPhoto(), item.getPrice(), item.getRate(), item.getDiscount(),
                            item.getMessage(), item.getCategory_name(), user.getId(), ord.getId());
                    if (cate.getName().equals(name_c)) {
                        panel.add(i);
                        i.setVisible(true);
                    } else {
                        set_scroll(panel, jTabbedPane1.getTitleAt(index));
                        panel = new JPanel();
                        name_c = cate.getName();
                        jTabbedPane1.add(panel);
                        index++;
                        set_panelfirst(panel, name_c, index);
                        panel.add(i);
                        i.setVisible(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        panel.setLayout(grid);
        set_scroll(panel, jTabbedPane1.getTitleAt(index));

    }

    private void load_items_to_manager() {

        ArrayList<category> listofcategory = menu.load_category_manager();

        GridBagConstraints gs = new GridBagConstraints();
        String name_c = listofcategory.get(0).getName();
        int index = 0;
        JPanel panel = new JPanel();
        jTabbedPane1.add(panel);
        set_panelsecond(panel, name_c, index);
        for (category cate : listofcategory) {

            for (item_ item : cate.listofitems) {

                Item i = new Item(item.getId(), item.getName(), item.getQuantity(),
                        item.getPhoto(), item.getPrice(), item.getDiscount(),
                        item.getMessage(), item.getCategory_name());
                if (cate.getName().equals(name_c)) {
                    panel.add(i);
                    i.setVisible(true);
                } else {
                    set_scroll(panel, jTabbedPane1.getTitleAt(index));
                    panel = new JPanel();
                    name_c = cate.getName();
                    jTabbedPane1.add(panel);
                    index++;
                    set_panelsecond(panel, name_c, index);
                    panel.add(i);
                    i.setVisible(true);
                }
            }
        }
        panel.setLayout(grid);
        set_scroll(panel, jTabbedPane1.getTitleAt(index));
    }

    /**
     * *
     * select id_order that is Generated in generate_id_order() and put it in UI
     * to use it
     */
    private void load_id_order() {
        try {
            set_con.setconnection();
            PreparedStatement statment2;
            statment2 = set_con.con.prepareStatement("SELECT * FROM `order_`");
            ResultSet result = statment2.executeQuery();
            while (result.next()) {
                ord.setId(result.getString("order_id"));
            }
            set_con.con.close();
            jLabel14.setText(ord.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *
     *
     * generate id for order
     *
     */
    private void generate_id_order() {
        try {
            set_con.setconnection();
            PreparedStatement statment1;
            statment1 = set_con.con.prepareStatement("INSERT INTO `order_`(`order_id`, `complain_message`, `time`, `cus_id`,"
                    + " `delivery_charge`, `delivery_id`, `total`, `balance`) "
                    + "VALUES (NULL,NULL,NULL,?,NULL,NULL,NULL,NULL)");
            statment1.setInt(1, user.getId());
            statment1.execute();
            set_con.con.close();
            //b.billid(ord.getId());
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        load_id_order();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel15 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(930, 491));
        setMinimumSize(new java.awt.Dimension(930, 491));
        setPreferredSize(new java.awt.Dimension(930, 491));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                formAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });
        addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                formVetoableChange(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane1.setMaximumSize(new java.awt.Dimension(592, 452));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(592, 452));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(592, 452));
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jSeparator1.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));
        jSeparator1.setOpaque(true);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("jLabel1");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("jLabel1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Balance");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Add To Cart");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(204, 0, 0));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("  jLabel11");
        jLabel11.setToolTipText("Category Name");
        jLabel11.setOpaque(true);

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        jPanel14.setForeground(new java.awt.Color(51, 51, 51));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Code#");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("jLabel1");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Price");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("QNT");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Item");

        jSeparator5.setBackground(new java.awt.Color(204, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(204, 0, 0));
        jSeparator5.setOpaque(true);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(31, 31, 31)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(42, 42, 42)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13))
                .addGap(326, 326, 326))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0), 2));
        jPanel15.setAutoscrolls(true);
        jPanel15.setOpaque(false);
        jPanel15.setLayout(null);
        jScrollPane1.setViewportView(jPanel15);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Finish");
        jButton1.setMaximumSize(new java.awt.Dimension(77, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(77, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(77, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jButton4.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // data will enter in this object after nermeen finish her task(assign delivery_boy to order)
        if (!"0.0".equals(jLabel9.getText())) {
            ord.calculate_total(ord.getId(), ord.getId_customer());
            update_order_information();
//            calculate_total();
            b = new Bill_11();
            b.setVisible(true);
            generate_id_order();
            default_values_total();
            remove_allcomponent_cart();
        } else {
            JOptionPane.showMessageDialog(null, "You Don't Order Any Thing", "Error", JOptionPane.ERROR_MESSAGE);
            // JOptionPane.ERROR_MESSAGE(null,"You Don't Order Any Thing");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * *
     * Set total = 0.0 and Balance = 0.0 in Start of order and after finish
     * order
     */
    private void default_values_total() {
        jLabel9.setText("0.0");
        jLabel7.setText("0.0");
    }
    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void formAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorMoved

    }//GEN-LAST:event_formAncestorMoved

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved

        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentMoved

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded

        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded

    private void formVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_formVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formVetoableChange

    /**
     * *
     * Get name of category and call function that put his items in combo box
     *
     * @param evt
     */
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        if (!combo_visiable) {
            int i = jTabbedPane1.getSelectedIndex();
            jLabel11.setText(jTabbedPane1.getTitleAt(i));
            load_item_in_combo();
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked
    /**
     * *
     * Select all items of this category and add it combo box
     */
    private void load_item_in_combo() {
        try {
            int i = jTabbedPane1.getSelectedIndex();
            jLabel11.setText(jTabbedPane1.getTitleAt(i));
            set_con.setconnection();
            PreparedStatement statment1;
            statment1 = set_con.con.prepareStatement("select name from item where category_name='" + jLabel11.getText() + "' and checked=1");
            ResultSet result = statment1.executeQuery();
            jComboBox1.removeAllItems();
            while (result.next()) {
                jComboBox1.addItem(result.getString("name"));
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load_cart() {
        try {

            remove_allcomponent_cart();
            set_con.setconnection();
            PreparedStatement statment1 = set_con.con.prepareStatement("select * from order_item where order_id='" + ord.getId() + "'");
            ResultSet result = statment1.executeQuery();
            while (result.next()) {
                load_(result.getInt("quantity"), result.getInt("item_id"));
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *
     * create object form Order_cart and added it in Cart panel
     *
     * @param quantity
     * @param id
     */
    private void load_(int quantity, int id) {
        try {
            double total_item = 0;
            GridBagConstraints gs2 = new GridBagConstraints();
            set_con.setconnection();
            PreparedStatement statment2 = set_con.con.prepareStatement("select * from item where item_id ='" + id + "'");
            ResultSet result2 = statment2.executeQuery();
            while (result2.next()) {
                total_item = result2.getDouble("price") * quantity;
                Order_Cart o_c = new Order_Cart(Integer.valueOf(id), quantity, result2.getDouble("price"), total_item, result2.getString("name"), ord);
                jPanel15.add(o_c, gs2);
                o_c.setVisible(true);
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *
     * this function calculate the total of current items in Cart
     */
    private void load_total_label() {
        try {
            float total = 0;
            set_con.setconnection();
            PreparedStatement statment1;
            statment1 = set_con.con.prepareStatement("SELECT * FROM `order_item` where order_id ='" + Integer.valueOf(ord.getId()) + "'");
            ResultSet result = statment1.executeQuery();
            while (result.next()) {
                total += ord.calculate_total_each_item(result.getInt("quantity"), result.getInt("item_id"));
            }
            jLabel9.setText(String.valueOf(total));
            jLabel7.setText(String.valueOf(total));
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * *
     * finishing order add all information about the order in database this
     * function not complete yet , after nermeen finish her task that assign
     * order to delivery boy update delivery boy id
     *
     * @param total
     */
    dilvery_boy1 boy = new dilvery_boy1();

    private void update_order_information() {
        ord.setDilvery_boy_id(Integer.valueOf(get_boy_id()));
        user.make_order(String.valueOf(ord.getDilvery_boy_id()), ord.getTotal(), ord.getId());
        boy.increment_boy_orders(String.valueOf(ord.getDilvery_boy_id()));
    }

    /**
     * *
     * Update quantity of this item (Decrease it)
     */
    private void update_quantity() {
        try {
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("UPDATE `item` SET `quantity`= quantity-1 WHERE item_id = '" + itm.getId() + "'");
            statment.execute();
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void remove_allcomponent_cart() {
        jPanel15.removeAll();
        jPanel15.revalidate();
        jPanel15.repaint();
    }

    /**
     * *
     * Add item that chosen to Cart
     *
     * @param evt
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        boolean check = ord.add_item_to_cart(ord.getId(), itm.getId());
        if (check) {
            load_cart();
            update_quantity();
            load_total_label();
        } else {
            JOptionPane.showMessageDialog(null, "Unfortunately This Item Not Available Now :(");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane1StateChanged
    /**
     * *
     * load all items of selected category
     */
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        try {

            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("select * from item where category_name='" + jLabel11.getText()
                    + "'and name='" + String.valueOf(jComboBox1.getSelectedItem()) + "'");
            ResultSet result = statment.executeQuery();
            while (result.next()) {
                itm = new item_(result.getInt("item_id"), result.getString("name"), result.getInt("quantity"), result.getString("photo"), result.getFloat("price"), result.getFloat("rate"), result.getFloat("discount"), result.getString("offer_message"), result.getString("category_name"));
            }
            set_con.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            ord.update_quantity_after_delete(Integer.valueOf(ord.getId()));
            set_con.setconnection();
            PreparedStatement statment = set_con.con.prepareStatement("DELETE FROM `order_` WHERE order_id=" + Integer.valueOf(jLabel14.getText()));
            statment.executeUpdate();
            set_con.con.close();
            remove_allcomponent_cart();
            default_values_total();
            generate_id_order();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    private String get_boy_id() {
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

    private void set_layout() {
        jPanel15.setLayout(grid2);
        //        jPanel2.setLayout(Grid);
        // JScrollPane js = new JScrollPane(jPanel4);
        // jPanel4.setLayout(new BoxLayout(jPanel4,BoxLayout.Y_AXIS));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}
