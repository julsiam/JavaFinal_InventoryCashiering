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

//        displayproducts();
        displayTransaction();
        dispProNamePrice();
//        productDetailsCombobox();
//        comboSql();
    }

//    public void displayproducts() {
//        DefaultTableModel producttable = (DefaultTableModel) productPriceTbl.getModel();
//        int count = 0;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
//                Statement stmt = con.createStatement();
//
//                ResultSet datas = stmt.executeQuery("SELECT * FROM `inventory`");
//                while (datas.next()) {
//                    count = 1;
//                    producttable.addRow(new Object[]{datas.getString("ProductName"), datas.getString("BuyingPrice"), "Php " + datas.getString("SellingPrice") + ".00", datas.getString("quantity"), datas.getString("UnitOfMeasure"), datas.getString("description")});
//                }
//            }
//        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    
    public void dispProNamePrice() {
        DefaultTableModel priceproducttable = (DefaultTableModel) productPriceTbl.getModel();
        int count = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();

                ResultSet datas = stmt.executeQuery("SELECT * FROM `inventory`");
                while (datas.next()) {
                    count = 1;
                    priceproducttable.addRow(new Object[]{datas.getString("ProductName"), datas.getString("SellingPrice"), datas.getString("quantity")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//    private void comboSql() {
//        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            String proName = (String) productscombobox.getSelectedItem();
//            String sql = "SELECT `ProductName`FROM `inventory`";
////            String sql = "SELECT * FROM `inventory` ";
//            pst = con.prepareStatement(sql);
//            pst.setString(1, proName);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                String price = rs.getString("SellingPrice");
//                this.priceField.setText(price);
//
//            }
////            float pricee = Float.parseFloat(rs.getString(5));
////            priceField.setText(Float.toString(pricee).trim());
////            if (rs.next()) {
////                String price = rs.getString("SellingPrice");
////                this.priceField.setText(price);
////            }
//
//        } catch (Exception e) {
//
//        }
//
//    }
    public void displayTransaction() {
        DefaultTableModel cashierTransactionModel = (DefaultTableModel) sellDetailsTables.getModel();
        
        String cashierTransact = (String) this.cashierIdField.getText();

        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet transactdata = stmt.executeQuery("SELECT * FROM `ctransactions`WHERE `UserID` = '" + cashierTransact +"'");

//                ResultSet datas = stmt.executeQuery("SELECT a.TransactionDate, a.UserID, b.ProductName, a.TypeOfTransaction, b.Quantity, a.Quantity AS \"Added Quantity\" FROM stransactions a, inventory b WHERE a.STransactionID=b.InventoryID;");
                while (transactdata.next()) {
                    count = 0;
                    cashierTransactionModel.addRow(new Object[]{transactdata.getString("CTransactionID"), transactdata.getString("productName"), transactdata.getString("quantity"), transactdata.getString("totalAmount"), transactdata.getString("UserID"), transactdata.getString("Date")});
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
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JButton();
        cashierTransactionBtn = new javax.swing.JButton();
        sellProBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        cashierSellBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        productquantityfield = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        proNameField = new javax.swing.JTextField();
        resetBtn = new javax.swing.JButton();
        availQuantiField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
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
        sellCashierProBtn = new javax.swing.JPanel();
        logOutBtn1 = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();
        sellCashierBtn = new javax.swing.JButton();
        refreshSellDetailsBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        productPriceTbl = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        cashierNameField = new javax.swing.JTextField();
        cashierIdField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back8.png"))); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 660, 510));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 700, 660));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(153, 0, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn.setText("Log Out");
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
        });
        jPanel9.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 190, 40));

        cashierTransactionBtn.setText("Home");
        cashierTransactionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierTransactionBtnMouseClicked(evt);
            }
        });
        jPanel9.add(cashierTransactionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 190, 40));

        sellProBtn.setText("Sell Products");
        sellProBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellProBtnMouseClicked(evt);
            }
        });
        jPanel9.add(sellProBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 190, 40));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 470, 230));

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 670, 730));

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

        jTabbedPane1.addTab("Home", jPanel4);

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
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 102, 102));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cashierSellBtn.setText("Sell");
        cashierSellBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierSellBtnMouseClicked(evt);
            }
        });
        jPanel11.add(cashierSellBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 110, 30));

        jLabel7.setText("Total PhP:");
        jPanel11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 70, -1));

        jLabel8.setText("Quantity:");
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));
        jPanel11.add(totalAmountField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 230, 30));

        jLabel9.setText("Product Name:");
        jPanel11.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        productquantityfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productquantityfieldActionPerformed(evt);
            }
        });
        productquantityfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productquantityfieldKeyReleased(evt);
            }
        });
        jPanel11.add(productquantityfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 230, 30));

        jLabel10.setText("Price PhP:");
        jPanel11.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 70, -1));
        jPanel11.add(priceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 230, 30));
        jPanel11.add(proNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 230, 30));

        resetBtn.setText("Reset");
        resetBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetBtnMouseClicked(evt);
            }
        });
        jPanel11.add(resetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 150, 110, 30));
        jPanel11.add(availQuantiField, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 80, 30));

        jLabel6.setText("Avail.Quanti.:");
        jPanel11.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 50, 90, -1));

        sellDetailsTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TransactionID", "Product Name", "Quantity", "Total Amount", "UserID", "Date"
            }
        ));
        sellDetailsTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellDetailsTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sellDetailsTables);

        jPanel12.setBackground(new java.awt.Color(255, 102, 102));
        jPanel12.setForeground(new java.awt.Color(153, 0, 0));

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
                .addGap(0, 55, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(title2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        sellCashierProBtn.setBackground(new java.awt.Color(153, 0, 51));
        sellCashierProBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn1.setText("Log Out");
        logOutBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtn1MouseClicked(evt);
            }
        });
        logOutBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutBtn1ActionPerformed(evt);
            }
        });
        sellCashierProBtn.add(logOutBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 180, 30));

        homeBtn.setText("Home");
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }
        });
        sellCashierProBtn.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 30));

        sellCashierBtn.setText("Sell Products");
        sellCashierBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellCashierBtnMouseClicked(evt);
            }
        });
        sellCashierProBtn.add(sellCashierBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 180, 30));

        refreshSellDetailsBtn.setText("View Your Transaction");
        refreshSellDetailsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshSellDetailsBtnMouseClicked(evt);
            }
        });
        refreshSellDetailsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshSellDetailsBtnActionPerformed(evt);
            }
        });

        productPriceTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Price", "Available Quantity"
            }
        ));
        productPriceTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productPriceTblMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(productPriceTbl);

        jPanel16.setBackground(new java.awt.Color(255, 102, 102));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 0));
        jLabel5.setText("Choose a product from the left");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(680, 680, 680)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(refreshSellDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sellCashierProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sellCashierProBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(refreshSellDetailsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sell Product", jPanel6);

        jPanel2.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1400, 740));

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
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 480, -1));

        jPanel17.setBackground(new java.awt.Color(153, 0, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cashierNameField.setFont(new java.awt.Font("Courier New", 3, 14)); // NOI18N
        jPanel17.add(cashierNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 246, 30));

        jPanel2.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, 270, 60));

        cashierIdField.setFont(new java.awt.Font("Courier New", 3, 14)); // NOI18N
        jPanel2.add(cashierIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 40, 30));

        jLabel4.setText("Your ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 23));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 770));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logOutBtnMouseClicked

    private void cashierTransactionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierTransactionBtnMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_cashierTransactionBtnMouseClicked

    private void sellProBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellProBtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_sellProBtnMouseClicked

    private void productPriceTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productPriceTblMouseClicked
        DefaultTableModel priceproducttable = (DefaultTableModel) productPriceTbl.getModel();

        String proName = (String) priceproducttable.getValueAt(productPriceTbl.getSelectedRow(), 0);
        String price = (String) priceproducttable.getValueAt(productPriceTbl.getSelectedRow(), 1);
        String quanti = (String) priceproducttable.getValueAt(productPriceTbl.getSelectedRow(), 2);

        this.proNameField.setText(proName);
        this.proNameField.setEditable(false);
        this.priceField.setText(price);
        this.priceField.setEditable(false);
        this.availQuantiField.setText(quanti);
        this.availQuantiField.setEditable(false);
    }//GEN-LAST:event_productPriceTblMouseClicked

    private void refreshSellDetailsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshSellDetailsBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshSellDetailsBtnActionPerformed

    private void refreshSellDetailsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshSellDetailsBtnMouseClicked
        DefaultTableModel priceproducttable = (DefaultTableModel) productPriceTbl.getModel();
        int priceCount = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();

                ResultSet datas = stmt.executeQuery("SELECT * FROM `inventory`");

                while (priceproducttable.getRowCount() > 0) {
                    priceproducttable.removeRow(0);
                }
                while (datas.next()) {
                    priceCount = 1;
                    priceproducttable.addRow(new Object[]{datas.getString("ProductName"),datas.getString("SellingPrice"), datas.getString("quantity")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        DefaultTableModel cashierTransactionModel = (DefaultTableModel) sellDetailsTables.getModel();
        String cashierTransact = (String) this.cashierIdField.getText();

        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet sellData = stmt.executeQuery("SELECT `CTransactionID`, `productName`, `Quantity`, `totalAmount`, `UserID`, `Date` FROM `ctransactions` WHERE `UserID` = '" + cashierTransact +"'");
                //                ResultSet newData = stmt.executeQuery("SELECT a.TransactionDate, a.UserID, b.ProductName, a.TypeOfTransaction, b.Quantity, a.Quantity AS \"Added Quantity\" FROM stransactions a, inventory b WHERE a.STransactionID=b.InventoryID;");
                while (cashierTransactionModel.getRowCount() > 0) {
                    cashierTransactionModel.removeRow(0);
                }

                while (sellData.next()) {
                    count = 0;
                    cashierTransactionModel.addRow(new Object[]{sellData.getString("CTransactionId"),sellData.getString("productName"),sellData.getString("quantity"),  "₱" + sellData.getString("totalAmount") + ".00", sellData.getString("userID"), sellData.getString("date")});

                }
            }

        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }//GEN-LAST:event_refreshSellDetailsBtnMouseClicked

    private void sellCashierBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellCashierBtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_sellCashierBtnMouseClicked

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
         jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_homeBtnMouseClicked

    private void logOutBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn1MouseClicked
        
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logOutBtn1MouseClicked

    private void sellDetailsTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellDetailsTablesMouseClicked

    }//GEN-LAST:event_sellDetailsTablesMouseClicked

    private void resetBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetBtnMouseClicked
        if (evt.getSource() == resetBtn) {
            this.proNameField.setText(null);
            this.totalAmountField.setText(null);
            this.productquantityfield.setText(null);
            this.priceField.setText(null);
            this.availQuantiField.setText(null);
        }
    }//GEN-LAST:event_resetBtnMouseClicked

    private void productquantityfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productquantityfieldKeyReleased
        if (this.productquantityfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input Quantity", "Alert", JOptionPane.ERROR_MESSAGE);
            this.totalAmountField.setText(null);

        } else {

            try {
                int inputQuantity = Integer.parseInt(this.productquantityfield.getText());
                int proPrice = Integer.parseInt(this.priceField.getText());

                int total = inputQuantity * proPrice;

                this.totalAmountField.setText(Integer.toString(total));

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_productquantityfieldKeyReleased

    private void productquantityfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productquantityfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productquantityfieldActionPerformed

    private void cashierSellBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierSellBtnMouseClicked

        //        DefaultTableModel cahiersTableModel = (DefaultTableModel) sellDetailsTables.getModel();
        if ((this.proNameField.getText().isEmpty()) || this.productquantityfield.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Choose a product...", "Alert", JOptionPane.ERROR_MESSAGE);

        } else if (Integer.parseInt(availQuantiField.getText()) <= 10) {
            JOptionPane.showMessageDialog(null, "Low Inventory. Not enough quantity ", "Alert", JOptionPane.ERROR_MESSAGE);

        } else {
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter orderDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy");

            String newOrderDate = myDateObj.format(orderDate);

            String productname = this.proNameField.getText();
            String amount = this.totalAmountField.getText();
            String quantity = this.productquantityfield.getText();
            String cashierAccountId = cashierIdField.getText();

            this.title.setText("Jul's Sari-sari Store");
            this.datesoldlabel.setText("Date: " + myDateObj.format(orderDate));
            this.productnamelabel.setText("Product Name: " + (String) this.proNameField.getText());
            this.productquantitylabel.setText("Quantity: " + Integer.parseInt(this.productquantityfield.getText()) + " pack/s");
            this.producttotallabel.setText("Total: ₱" + Integer.parseInt(this.totalAmountField.getText()) + ".00");
            //from here
            try {
                DefaultTableModel cahiersTableModel = (DefaultTableModel) sellDetailsTables.getModel();
                Class.forName("com.mysql.jdbc.Driver");
                String productName = this.proNameField.getText();
                try (Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                    Statement stmt = con.createStatement();
                    String query1 = "INSERT INTO `CTransactions`(`productName`, `Quantity`, `totalAmount`, `UserID`, Date) VALUES" + "('" + productname + "','" + quantity + "','" + amount + "','" + cashierAccountId + "','" + newOrderDate + "')";
                    stmt.executeUpdate(query1);

                    int count;
                    ResultSet data = stmt.executeQuery("SELECT * FROM `inventory` WHERE ProductName = '" + productName + "'");
                    if (data.next()) {
                        int qnty = Integer.parseInt(data.getString("Quantity")) - Integer.parseInt(this.productquantityfield.getText());
                        System.out.println(productName);
                        System.out.println(data.getString("Quantity"));
                        System.out.println(qnty);
                        String newQnty = Integer.toString(qnty);
                        String query2 = "UPDATE `inventory` SET `Quantity`='" + newQnty + "' WHERE ProductName= '" + productName + "'";
                        stmt.executeUpdate(query2);
                    }

                    ResultSet newData = stmt.executeQuery("SELECT * FROM `CTransactions`");
                    while (newData.next()) {
                        count = 0;
                        cahiersTableModel.removeRow(count);
                        cahiersTableModel.addRow(new Object[]{newData.getString("CTransactionID"), newData.getString("productName"), newData.getString("Quantity"),"₱" + newData.getString("totalAmount") + ".00", newData.getString("userID"), newData.getString("date")});
                    }
                    con.close();
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e);
            }
            this.proNameField.setText(null);
            this.totalAmountField.setText(null);
            this.productquantityfield.setText(null);
            this.priceField.setText(null);
            this.availQuantiField.setText(null);

        }
    }//GEN-LAST:event_cashierSellBtnMouseClicked

    private void logOutBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(CashierManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CashierManagement.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JTextField availQuantiField;
    public javax.swing.JTextField cashierIdField;
    public javax.swing.JTextField cashierNameField;
    private javax.swing.JButton cashierSellBtn;
    private javax.swing.JButton cashierTransactionBtn;
    private javax.swing.JLabel datesoldlabel;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton logOutBtn1;
    private javax.swing.JTextField priceField;
    private javax.swing.JTextField proNameField;
    private javax.swing.JTable productPriceTbl;
    private javax.swing.JLabel productnamelabel;
    private javax.swing.JTextField productquantityfield;
    private javax.swing.JLabel productquantitylabel;
    private javax.swing.JLabel producttotallabel;
    private javax.swing.JButton refreshSellDetailsBtn;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton sellCashierBtn;
    private javax.swing.JPanel sellCashierProBtn;
    private javax.swing.JTable sellDetailsTables;
    private javax.swing.JButton sellProBtn;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JTextField totalAmountField;
    // End of variables declaration//GEN-END:variables
}
