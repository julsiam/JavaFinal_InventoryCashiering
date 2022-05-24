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

    Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst1 = null;
    ResultSet rs = null;

    public CashierManagement() {
        initComponents();
        this.setLocationRelativeTo(null);

        displayproducts();
        comboSql();
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

    private void comboSql() {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
            Class.forName("com.mysql.jdbc.Driver");
            String sql = "SELECT * FROM `inventory` ";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                String productname = rs.getString("ProductName");
                productscombobox.addItem(productname);
            }

        } catch (Exception e) {

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
        cashierSellBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JTextField();
        productscombobox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        productquantityfield = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sellDetailsTables = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        datesoldlabel = new javax.swing.JLabel();
        productnamelabel = new javax.swing.JLabel();
        productquantitylabel = new javax.swing.JLabel();
        producttotallabel = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        logOutBtn1 = new javax.swing.JButton();
        cashierTransactionBtn1 = new javax.swing.JButton();
        ManageUsersBtn1 = new javax.swing.JButton();
        staffTransactionBtn1 = new javax.swing.JButton();
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
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cashierIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cashierNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\1styrGroupB\\Downloads\\back6.PNG")); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 520, 510));

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

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 430, 180));

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

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 390));

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 860, 730));

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

        jPanel10.setBackground(new java.awt.Color(255, 153, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Cashiering");

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

        jPanel6.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 380, 50));

        jPanel11.setBackground(new java.awt.Color(0, 204, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cashierSellBtn.setText("Sell");
        cashierSellBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierSellBtnMouseClicked(evt);
            }
        });
        jPanel11.add(cashierSellBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 110, -1));

        jLabel7.setText("Total:");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, -1, -1));

        jLabel8.setText("Quantity:");
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, -1, -1));
        jPanel11.add(totalAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 260, 30));

        productscombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose a Product..." }));
        jPanel11.add(productscombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 260, 30));

        jLabel9.setText("Product Name:");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        productquantityfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productquantityfieldKeyReleased(evt);
            }
        });
        jPanel11.add(productquantityfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 260, 30));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1360, 140));

        sellDetailsTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TransactionID", "Date", "Product Name", "Quantity", "Total Amount"
            }
        ));
        sellDetailsTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellDetailsTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sellDetailsTables);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 830, 420));

        jPanel12.setBackground(new java.awt.Color(204, 255, 204));

        title.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        title.setText("Jul's Sari-sari Store");

        datesoldlabel.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N

        productnamelabel.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N

        productquantitylabel.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N

        producttotallabel.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N

        title1.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        title1.setText("Canlaon City, Negros Oriental");

        title2.setFont(new java.awt.Font("Monospaced", 3, 16)); // NOI18N
        title2.setText("To God Be the Glory");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 135, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(datesoldlabel, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                            .addComponent(productnamelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(productquantitylabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(producttotallabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(title1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(datesoldlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productnamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productquantitylabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(producttotallabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel6.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 240, 520, 310));

        jPanel13.setBackground(new java.awt.Color(255, 153, 153));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn1.setText("Log Out");
        logOutBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtn1MouseClicked(evt);
            }
        });
        jPanel13.add(logOutBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

        cashierTransactionBtn1.setText("Home");
        cashierTransactionBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierTransactionBtn1MouseClicked(evt);
            }
        });
        jPanel13.add(cashierTransactionBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 170, -1));

        ManageUsersBtn1.setText("Sell Products");
        ManageUsersBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageUsersBtn1MouseClicked(evt);
            }
        });
        jPanel13.add(ManageUsersBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 170, -1));

        staffTransactionBtn1.setText("Your Transaction");
        staffTransactionBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffTransactionBtn1MouseClicked(evt);
            }
        });
        jPanel13.add(staffTransactionBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, -1));

        jPanel6.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 570, 430, 160));

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

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1400, 760));

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Cashier Management System");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, -1, -1));
        jPanel2.add(cashierIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 40, 30));

        jLabel4.setText("Your ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel2.add(cashierNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 20, 190, 30));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
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

    private void cashierSellBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierSellBtnMouseClicked
        DefaultTableModel cashierTableModel = (DefaultTableModel) sellDetailsTables.getModel();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter orderDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

        String newOrderDate = myDateObj.format(orderDate);

        String productname = this.productscombobox.getSelectedItem().toString();
        String amount = this.totalAmountField.getText();
        String quantity = this.productquantityfield.getText();
        String cashierAccountId = cashierIdField.getText();

        if ("Choose a Product...".equals(this.productscombobox.getSelectedItem()) || this.productquantityfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Choose a product...", "Alert", JOptionPane.ERROR_MESSAGE);
            JOptionPane.showMessageDialog(null, "Invalid Quantity!", "Alert", JOptionPane.ERROR_MESSAGE);
            this.totalAmountField.setText("");

        } else {
            this.title.setText("Jul's Sari-sari Store");
            this.datesoldlabel.setText("Date: " + myDateObj.format(orderDate));
            this.productnamelabel.setText("Product Name: " + (String) this.productscombobox.getSelectedItem());
            this.productquantitylabel.setText("Quantity: " + Integer.parseInt(this.productquantityfield.getText()) + " pack/s");
            this.producttotallabel.setText("Total: Php " + Integer.parseInt(this.totalAmountField.getText()) + ".00");

            try {

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CashierManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

                try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                    Statement stmt = con.createStatement();
                    String query1 = "INSERT INTO `CTransactions`(`date`, `productName`, `Quantity`, `totalAmount`, `UserID`) VALUES"
                            + "('" + newOrderDate + "','" + productname + "','" + quantity + "','" + amount + "','" + cashierAccountId + "')";
                    int count;
                    ResultSet data = stmt.executeQuery("SELECT * FROM `inventory`");
                    if (data.next()) {
                        int qnty = Integer.parseInt(data.getString("quantity")) - Integer.parseInt(this.productquantityfield.getText());
                        System.out.println(data.getString("quantity"));
                        System.out.println(qnty);

                        String newQnty = Integer.toString(qnty);
                        String query2 = "UPDATE `inventory` SET `quantity`='" + newQnty + "'";
                        stmt.executeUpdate(query2);

                    }

                    ResultSet newData = stmt.executeQuery("SELECT * FROM `ctransactions`");
                    while (newData.next()) {
                        count = 0;
                        cashierTableModel.removeRow(count);
                        cashierTableModel.addRow(new Object[]{newData.getString("CTransactionId"), newData.getString("Date"), newData.getString("productName"), newData.getString("Quantity"), newData.getString("totalAmount"), newData.getString("userID")});
                    }
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            this.productscombobox.setSelectedIndex(0);
            this.productquantityfield.setText(null);
            this.totalAmountField.setText(null);

        }


    }//GEN-LAST:event_cashierSellBtnMouseClicked

    private void productquantityfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productquantityfieldKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_productquantityfieldKeyReleased

    private void tableproductdisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableproductdisplayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableproductdisplayMouseClicked

    private void logOutBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutBtn1MouseClicked

    private void cashierTransactionBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierTransactionBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cashierTransactionBtn1MouseClicked

    private void ManageUsersBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageUsersBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ManageUsersBtn1MouseClicked

    private void staffTransactionBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTransactionBtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_staffTransactionBtn1MouseClicked

    private void sellDetailsTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellDetailsTablesMouseClicked
//        DefaultTableModel sellingTableModel = (DefaultTableModel) sellDetailsTables.getModel();
//        LocalDateTime myDateObj = LocalDateTime.now();
//        DateTimeFormatter orderDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
//
//        String newOrderDate = myDateObj.format(orderDate);
//
//        String trnsactionId = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 0);
//        String date = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 1);
//        String buyingPrice = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 2);
//        String sellingPrice = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 3);
//        String quantity = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 4);
//        String unitofmeasure = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 5);
//        String description = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 6);
//        String threshold = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 7);
//        String inventoryStatus = (String) sellingTableModel.getValueAt(sellDetailsTables.getSelectedRow(), 8);
//
//        this.productidfield.setText(proid);
//        this.productidfield.setEditable(false);
//        this.newOrderDate.setText(newOrderDate);
//        this.productpricefield.setText(buyingPrice);
//        this.sellingpricefield.setText(sellingPrice);
//        this.quantityfield.setText(quantity);
//        this.uomfield.setText(unitofmeasure);
//        this.productdescriptionfield.setText(description);
//        this.statusField.setText(inventoryStatus);
//        this.thresholdField.setText(threshold);
    }//GEN-LAST:event_sellDetailsTablesMouseClicked

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
    private javax.swing.JButton ManageUsersBtn1;
    private javax.swing.JButton STcashiersTransbtn;
    private javax.swing.JButton STmanageUserbtn;
    private javax.swing.JButton STstaffTransactionBtn3;
    public javax.swing.JTextField cashierIdField;
    public javax.swing.JTextField cashierNameField;
    private javax.swing.JButton cashierSellBtn;
    private javax.swing.JButton cashierTransactionBtn;
    private javax.swing.JButton cashierTransactionBtn1;
    private javax.swing.JLabel datesoldlabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton logOutBtn1;
    private javax.swing.JButton logOutBtn3;
    private javax.swing.JButton logOutBtn4;
    private javax.swing.JLabel productnamelabel;
    private javax.swing.JTextField productquantityfield;
    private javax.swing.JLabel productquantitylabel;
    private javax.swing.JComboBox<String> productscombobox;
    private javax.swing.JLabel producttotallabel;
    private javax.swing.JTable sellDetailsTables;
    private javax.swing.JButton staffTransactionBtn;
    private javax.swing.JButton staffTransactionBtn1;
    private javax.swing.JTable tableproductdisplay;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JTextField totalAmountField;
    private javax.swing.JButton usersHomeBtn1;
    private javax.swing.JButton usersHomeBtn2;
    // End of variables declaration//GEN-END:variables
}
