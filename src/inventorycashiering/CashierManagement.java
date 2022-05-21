/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventorycashiering;


import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CashierManagement extends javax.swing.JFrame {

    /**
     * Creates new form CashierManagement
     */
    public CashierManagement() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
        
        displayproducts();
    }

    public void displayproducts() {
        DefaultTableModel producttable = (DefaultTableModel) tableproductdisplay.getModel();
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();

                ResultSet datas = stmt.executeQuery("SELECT * FROM `inventory`");
                while (datas.next()) {
                    count = 1;
                    producttable.addRow(new Object[]{datas.getString("ProductName"), datas.getString("BuyingPrice"), datas.getString("SellingPrice"), datas.getString("quantity"), datas.getString("UnitOfMeasure"), datas.getString("description")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JButton();
        cashierTransactionBtn = new javax.swing.JButton();
        ManageUsersBtn = new javax.swing.JButton();
        staffTransactionBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableproductdisplay = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        cashiersoldbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        productquantityfield = new javax.swing.JTextField();
        productpricefield = new javax.swing.JTextField();
        productscombobox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        productquantityfield1 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        logOutBtn4 = new javax.swing.JButton();
        CTcashierTrans = new javax.swing.JButton();
        CTmanageUsersBtn = new javax.swing.JButton();
        CTstaffTransactionBtn4 = new javax.swing.JButton();
        usersHomeBtn2 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        logOutBtn3 = new javax.swing.JButton();
        STcashiersTransbtn = new javax.swing.JButton();
        STmanageUserbtn = new javax.swing.JButton();
        STstaffTransactionBtn3 = new javax.swing.JButton();
        usersHomeBtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\1styrGroupB\\Downloads\\back6.PNG")); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 520, 500));

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Cashier Management System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel8.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 740));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 153, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn.setText("Log Out");
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
        });
        jPanel9.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 170, -1));

        cashierTransactionBtn.setText("Home");
        cashierTransactionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierTransactionBtnMouseClicked(evt);
            }
        });
        jPanel9.add(cashierTransactionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, -1));

        ManageUsersBtn.setText("Sell Products");
        ManageUsersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageUsersBtnMouseClicked(evt);
            }
        });
        jPanel9.add(ManageUsersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 170, -1));

        staffTransactionBtn.setText("Your Transaction");
        staffTransactionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffTransactionBtnMouseClicked(evt);
            }
        });
        jPanel9.add(staffTransactionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 520, 430, 180));

        tableproductdisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Price", "Selling Price", "Quantity", "UoM", "Description"
            }
        ));
        tableproductdisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableproductdisplayMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableproductdisplay);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 840, 210));

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 850, 740));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel4);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(102, 0, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Available Products");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 380, 50));

        jPanel11.setBackground(new java.awt.Color(0, 204, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cashiersoldbtn.setText("Sell");
        cashiersoldbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashiersoldbtnMouseClicked(evt);
            }
        });
        jPanel11.add(cashiersoldbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, -1, -1));

        jLabel6.setText("Product Price:");
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        jLabel7.setText("Total:");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jLabel8.setText("Quantity:");
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, -1, -1));

        productquantityfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productquantityfieldKeyReleased(evt);
            }
        });
        jPanel11.add(productquantityfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 260, 30));
        jPanel11.add(productpricefield, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 260, 30));

        productscombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a Product..." }));
        jPanel11.add(productscombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 260, 30));

        jLabel9.setText("Product Name:");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        productquantityfield1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productquantityfield1KeyReleased(evt);
            }
        });
        jPanel11.add(productquantityfield1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 260, 30));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1360, 180));

        jTabbedPane1.addTab("", jPanel6);

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 153, 153));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn4.setText("Log Out");
        logOutBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtn4MouseClicked(evt);
            }
        });
        jPanel20.add(logOutBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 170, -1));

        CTcashierTrans.setText("Cashier's Transaction");
        CTcashierTrans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTcashierTransMouseClicked(evt);
            }
        });
        jPanel20.add(CTcashierTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 170, -1));

        CTmanageUsersBtn.setText("Manage Users");
        CTmanageUsersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTmanageUsersBtnMouseClicked(evt);
            }
        });
        jPanel20.add(CTmanageUsersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, -1));

        CTstaffTransactionBtn4.setText("Staff's Transaction");
        CTstaffTransactionBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CTstaffTransactionBtn4MouseClicked(evt);
            }
        });
        jPanel20.add(CTstaffTransactionBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

        usersHomeBtn2.setText("Home");
        usersHomeBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersHomeBtn2MouseClicked(evt);
            }
        });
        jPanel20.add(usersHomeBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 420, 170));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("", jPanel14);

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setBackground(new java.awt.Color(255, 153, 153));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn3.setText("Log Out");
        logOutBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtn3MouseClicked(evt);
            }
        });
        jPanel19.add(logOutBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 170, -1));

        STcashiersTransbtn.setText("Cashier's Transaction");
        STcashiersTransbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STcashiersTransbtnMouseClicked(evt);
            }
        });
        jPanel19.add(STcashiersTransbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 170, -1));

        STmanageUserbtn.setText("Manage Users");
        STmanageUserbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STmanageUserbtnMouseClicked(evt);
            }
        });
        jPanel19.add(STmanageUserbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, -1));

        STstaffTransactionBtn3.setText("Staff's Transaction");
        STstaffTransactionBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STstaffTransactionBtn3MouseClicked(evt);
            }
        });
        jPanel19.add(STstaffTransactionBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

        usersHomeBtn1.setText("Home");
        usersHomeBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersHomeBtn1MouseClicked(evt);
            }
        });
        jPanel19.add(usersHomeBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jPanel15.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 420, 170));

        jTabbedPane1.addTab("", jPanel15);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 770));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtnMouseClicked

    private void cashierTransactionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierTransactionBtnMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_cashierTransactionBtnMouseClicked

    private void ManageUsersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageUsersBtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_ManageUsersBtnMouseClicked

    private void staffTransactionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTransactionBtnMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_staffTransactionBtnMouseClicked

    private void logOutBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn4MouseClicked
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtn4MouseClicked

    private void CTcashierTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTcashierTransMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_CTcashierTransMouseClicked

    private void CTmanageUsersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTmanageUsersBtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_CTmanageUsersBtnMouseClicked

    private void CTstaffTransactionBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTstaffTransactionBtn4MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_CTstaffTransactionBtn4MouseClicked

    private void usersHomeBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersHomeBtn2MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_usersHomeBtn2MouseClicked

    private void logOutBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn3MouseClicked
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutBtn3MouseClicked

    private void STcashiersTransbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STcashiersTransbtnMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_STcashiersTransbtnMouseClicked

    private void STmanageUserbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STmanageUserbtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_STmanageUserbtnMouseClicked

    private void STstaffTransactionBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STstaffTransactionBtn3MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_STstaffTransactionBtn3MouseClicked

    private void usersHomeBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersHomeBtn1MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_usersHomeBtn1MouseClicked

    private void cashiersoldbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashiersoldbtnMouseClicked

    }//GEN-LAST:event_cashiersoldbtnMouseClicked

    private void productquantityfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productquantityfieldKeyReleased
        if ("Choose a Product...".equals(this.productscombobox.getSelectedItem()) || this.productquantityfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Choose a product...", "Alert", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Invalid Quantity!", "Alert", JOptionPane.ERROR_MESSAGE);
            this.productpricefield.setText("");

        } else if ("Osmocote Bloom Booster Controlle".equals(this.productscombobox.getSelectedItem()) || "1".equals(this.productquantityfield.getText()) || "2".equals(this.productquantityfield.getText()) || "3".equals(this.productquantityfield.getText()) || "4".equals(this.productquantityfield.getText()) || "5".equals(this.productquantityfield.getText())) {
            int price = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_management_system", "root", "")) {
                    Statement stmt = con.createStatement();

                    ResultSet datas = stmt.executeQuery("SELECT * FROM `products` WHERE `quantity` = '20'");
                    if (datas.next()) {
                        price = datas.getInt("productPrice");
                    }
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            this.productpricefield.setText(Integer.toString(price * Integer.parseInt(this.productquantityfield.getText())));
        } else if ("Vermicast Organic Fertilizer".equals(this.productscombobox.getSelectedItem()) || "1".equals(this.productquantityfield.getText()) || "2".equals(this.productquantityfield.getText()) || "3".equals(this.productquantityfield.getText()) || "4".equals(this.productquantityfield.getText()) || "5".equals(this.productquantityfield.getText())) {
            int price = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_management_system", "root", "")) {
                    Statement stmt = con.createStatement();

                    ResultSet datas = stmt.executeQuery("SELECT * FROM `products` WHERE `quantity` = '25'");
                    if (datas.next()) {
                        price = datas.getInt("productPrice");
                    }
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            this.productpricefield.setText(Integer.toString(price * Integer.parseInt(this.productquantityfield.getText())));

        } else if ((this.productscombobox.getSelectedItem() == "Dragon Humus Fertilizer") || ("1".equals(this.productquantityfield.getText())) || ("2".equals(this.productquantityfield.getText())) || "3".equals(this.productquantityfield.getText()) || "4".equals(this.productquantityfield.getText()) || "5".equals(this.productquantityfield.getText())) {

        } else if ((this.productscombobox.getSelectedItem() == "Dragon Humus Fertilizer") || ("1".equals(this.productquantityfield.getText())) || ("2".equals(this.productquantityfield.getText())) || "3".equals(this.productquantityfield.getText()) || "4".equals(this.productquantityfield.getText()) || "5".equals(this.productquantityfield.getText())) {

            int price = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_management_system", "root", "")) {
                    Statement stmt = con.createStatement();

                    ResultSet datas = stmt.executeQuery("SELECT * FROM `products` WHERE `quantity` = '30'");
                    if (datas.next()) {
                        price = datas.getInt("productPrice");
                    }
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            this.productpricefield.setText(Integer.toString(price * Integer.parseInt(this.productquantityfield.getText())));
        } else if ("Yara Mila Unik Fertilizer".equals(this.productscombobox.getSelectedItem()) || "1".equals(this.productquantityfield.getText()) || "2".equals(this.productquantityfield.getText()) || "3".equals(this.productquantityfield.getText()) || "4".equals(this.productquantityfield.getText()) || "5".equals(this.productquantityfield.getText())) {
            int price = 0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_management_system", "root", "")) {
                    Statement stmt = con.createStatement();

                    ResultSet datas = stmt.executeQuery("SELECT * FROM `products` WHERE `quantity` = '10'");
                    if (datas.next()) {
                        price = datas.getInt("productPrice");
                    }
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            this.productpricefield.setText(Integer.toString(price * Integer.parseInt(this.productquantityfield.getText())));
        }
    }//GEN-LAST:event_productquantityfieldKeyReleased

    private void productquantityfield1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productquantityfield1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_productquantityfield1KeyReleased

    private void tableproductdisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableproductdisplayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableproductdisplayMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CashierManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CTcashierTrans;
    private javax.swing.JButton CTmanageUsersBtn;
    private javax.swing.JButton CTstaffTransactionBtn4;
    private javax.swing.JButton ManageUsersBtn;
    private javax.swing.JButton STcashiersTransbtn;
    private javax.swing.JButton STmanageUserbtn;
    private javax.swing.JButton STstaffTransactionBtn3;
    private javax.swing.JButton cashierTransactionBtn;
    private javax.swing.JButton cashiersoldbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton logOutBtn3;
    private javax.swing.JButton logOutBtn4;
    private javax.swing.JTextField productpricefield;
    private javax.swing.JTextField productquantityfield;
    private javax.swing.JTextField productquantityfield1;
    private javax.swing.JComboBox<String> productscombobox;
    private javax.swing.JButton staffTransactionBtn;
    private javax.swing.JTable tableproductdisplay;
    private javax.swing.JButton usersHomeBtn1;
    private javax.swing.JButton usersHomeBtn2;
    // End of variables declaration//GEN-END:variables
}
