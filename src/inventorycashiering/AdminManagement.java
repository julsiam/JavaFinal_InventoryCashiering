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

/**
 *
 * @author 1styrGroupB
 */
public class AdminManagement extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public AdminManagement() {
        initComponents();
        this.setLocationRelativeTo(null);

        dispStaffTransaction();
        manageUserAccounts();
        dispCashierTransaction();
        staffTransactionDate();
        transactStaffName();
        transactionCashierDate();
        transactCashierName();
        thresholdLimit();
//        statusCombo();
//        displayUserAccounts();
    }

    public void manageUserAccounts() {
        DefaultTableModel admintable = (DefaultTableModel) manageUserTable.getModel();
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();

                ResultSet datas = stmt.executeQuery("SELECT * FROM `users` ORDER BY Role");
                while (datas.next()) {
                    count = 1;
                    admintable.addRow(new Object[]{datas.getString("UserID"), datas.getString("FirstName"), datas.getString("LastName"), datas.getString("Email"), datas.getString("Password"), datas.getString("Role"), datas.getString("Status")});

                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dispStaffTransaction() {
        DefaultTableModel staffTransactionModel = (DefaultTableModel) staffTransactionTable.getModel();
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet transactdata = stmt.executeQuery("SELECT * FROM `stransactions`");

//                ResultSet datas = stmt.executeQuery("SELECT a.TransactionDate, a.UserID, b.ProductName, a.TypeOfTransaction, b.Quantity, a.Quantity AS \"Added Quantity\" FROM stransactions a, inventory b WHERE a.STransactionID=b.InventoryID;");
                while (transactdata.next()) {
                    count = 0;
                    staffTransactionModel.addRow(new Object[]{transactdata.getString("STransactionId"), transactdata.getString("transactionDate"), transactdata.getString("userId"), transactdata.getString("InventoryId"), transactdata.getString("productName"), transactdata.getString("typeoftransaction")});

                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void dispCashierTransaction() {
        DefaultTableModel cashierTransactionModel = (DefaultTableModel) cashierTransTables.getModel();
        int count = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet transactdata = stmt.executeQuery("SELECT * FROM `ctransactions`");

//                ResultSet datas = stmt.executeQuery("SELECT a.TransactionDate, a.UserID, b.ProductName, a.TypeOfTransaction, b.Quantity, a.Quantity AS \"Added Quantity\" FROM stransactions a, inventory b WHERE a.STransactionID=b.InventoryID;");
                while (transactdata.next()) {
                    count = 0;
                    cashierTransactionModel.addRow(new Object[]{transactdata.getString("CTransactionId"), transactdata.getString("productName"), transactdata.getString("quantity"), transactdata.getString("totalAmount"), transactdata.getString("userID"), transactdata.getString("date")});

                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void staffTransactionDate() {
        DefaultTableModel transactDateModel = (DefaultTableModel) staffTransactDate.getModel();
        int dateCount;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet dateData = stmt.executeQuery("SELECT DISTINCT `TransactionDate` FROM `stransactions`");
                while (dateData.next()) {
                    dateCount = 1;
                    transactDateModel.addRow(new Object[]{dateData.getString("TransactionDate")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transactStaffName() {
        DefaultTableModel transactNameModel = (DefaultTableModel) staffNameId.getModel();
        int nameCount;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet staffData = stmt.executeQuery("SELECT DISTINCT users.UserID, users.FirstName FROM users JOIN stransactions ON users.UserID=stransactions.UserID");
                while (staffData.next()) {
                    nameCount = 1;
                    transactNameModel.addRow(new Object[]{staffData.getString("UserID"), staffData.getString("firstName")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public void transactionCashierDate() {
        DefaultTableModel transactDateModel = (DefaultTableModel) cashierTransactDate.getModel();
        int dateCount;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet dateData = stmt.executeQuery("SELECT DISTINCT `Date` FROM `ctransactions`");
                while (dateData.next()) {
                    dateCount = 1;
                    transactDateModel.addRow(new Object[]{dateData.getString("Date")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void transactCashierName() {
        DefaultTableModel transactNameModel = (DefaultTableModel) cashierNameId.getModel();
        int nameCount;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet staffData = stmt.executeQuery("SELECT DISTINCT users.UserID, users.FirstName FROM users JOIN ctransactions ON users.UserID=ctransactions.UserID");
                while (staffData.next()) {
                    nameCount = 1;
                    transactNameModel.addRow(new Object[]{staffData.getString("UserID"), staffData.getString("firstName")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    
     public void thresholdLimit() {
        DefaultTableModel transactNameModel = (DefaultTableModel) tresholdTbl.getModel();
        int nameCount;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt = con.createStatement();
                ResultSet thresholdData = stmt.executeQuery("SELECT `ProductName`, `Quantity`,`thresholdStatus` FROM `inventory` WHERE Quantity <=10");
                while (thresholdData.next()) {
                    nameCount = 1;
                    transactNameModel.addRow(new Object[]{thresholdData.getString("ProductName"), thresholdData.getString("quantity"), thresholdData.getString("thresholdstatus")});
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());

        }
    }
    
    
    
    

//    private void statusCombo() {
//        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
//            Class.forName("com.mysql.jdbc.Driver");
//            String sql = "SELECT * FROM `users` ";
//            pst = con.prepareStatement(sql);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//                String accountStatus = rs.getString("Status");
//                statusCombobox.addItem(accountStatus);
//            }
//
//        } catch (Exception e) {
//
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JButton();
        cashierTransactionBtn = new javax.swing.JButton();
        ManageUsersBtn = new javax.swing.JButton();
        staffTransactionBtn = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        manageUserTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        idfield = new javax.swing.JTextField();
        lNameField = new javax.swing.JTextField();
        fNameField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        passwordField = new javax.swing.JTextField();
        roleField = new javax.swing.JTextField();
        statusCombobox = new javax.swing.JComboBox<>();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        logOutBtn2 = new javax.swing.JButton();
        MUcashierTransactionBtn2 = new javax.swing.JButton();
        MUManageUsersBtn2 = new javax.swing.JButton();
        MUstaffTransactionBtn = new javax.swing.JButton();
        MUusersHomeBtn3 = new javax.swing.JButton();
        murResetBtn = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        logOutBtn4 = new javax.swing.JButton();
        CTcashierTrans = new javax.swing.JButton();
        CTmanageUsersBtn = new javax.swing.JButton();
        CTstaffTransactionBtn4 = new javax.swing.JButton();
        usersHomeBtn2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        staffTransactionTable = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        staffNameId = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        staffTransactDate = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        logOutBtn3 = new javax.swing.JButton();
        STcashiersTransbtn = new javax.swing.JButton();
        STmanageUserbtn = new javax.swing.JButton();
        STstaffTransactionBtn3 = new javax.swing.JButton();
        usersHomeBtn1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cashierTransTables = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        cashierTransactDate = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        totalSalesField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        totalQuantitySold = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        productSoldTbl = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        cashierNameId = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tresholdTbl = new javax.swing.JTable();
        jPanel24 = new javax.swing.JPanel();
        logOutBtn5 = new javax.swing.JButton();
        STcashiersTransbtn1 = new javax.swing.JButton();
        STmanageUserbtn1 = new javax.swing.JButton();
        STstaffTransactionBtn4 = new javax.swing.JButton();
        usersHomeBtn3 = new javax.swing.JButton();

        jPanel16.setBackground(new java.awt.Color(255, 204, 204));

        jLabel13.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 0, 0));
        jLabel13.setText("Your Transaction");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\1styrGroupB\\Downloads\\back6.PNG")); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 560));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 204));
        jLabel1.setText("Admin Management Section");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 450, 60));

        jPanel9.setBackground(new java.awt.Color(255, 153, 153));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn.setText("Log Out");
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
        });
        jPanel9.add(logOutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 170, -1));

        cashierTransactionBtn.setText("Cashier's Transaction");
        cashierTransactionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierTransactionBtnMouseClicked(evt);
            }
        });
        jPanel9.add(cashierTransactionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 170, -1));

        ManageUsersBtn.setText("Manage Users");
        ManageUsersBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageUsersBtnMouseClicked(evt);
            }
        });
        jPanel9.add(ManageUsersBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, -1));

        staffTransactionBtn.setText("Staff's Transaction");
        staffTransactionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffTransactionBtnMouseClicked(evt);
            }
        });
        jPanel9.add(staffTransactionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, -1));

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 240, 330));

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 530, 560));

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

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(255, 204, 204));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel4.setText("Manage System Users");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 60));

        manageUserTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User_ID", "First Name", "Last Name", "Email", "Password", "Role", "Status"
            }
        ));
        manageUserTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageUserTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(manageUserTable);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1060, 220));

        jLabel5.setText("Status:");
        jPanel12.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jLabel6.setText("User_ID:");
        jPanel12.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel7.setText("Last Name:");
        jPanel12.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel8.setText("First Name:");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, -1));

        jLabel9.setText("Email:");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, -1, -1));

        jLabel10.setText("Password:");
        jPanel12.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, -1, -1));

        jLabel11.setText("Role:");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));
        jPanel12.add(idfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 200, 30));
        jPanel12.add(lNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 200, 30));
        jPanel12.add(fNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 200, 30));

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        jPanel12.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 200, 30));
        jPanel12.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 200, 30));
        jPanel12.add(roleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 200, 30));

        statusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Change Status", "Active", "InActive" }));
        jPanel12.add(statusCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 200, 30));

        addBtn.setText("Add");
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
        });
        jPanel12.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, 70, -1));

        updateBtn.setText("Update");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBtnMouseClicked(evt);
            }
        });
        jPanel12.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, -1));

        deleteBtn.setText("Delete");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        jPanel12.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, -1, -1));

        jPanel17.setBackground(new java.awt.Color(255, 153, 153));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn2.setText("Log Out");
        logOutBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtn2MouseClicked(evt);
            }
        });
        jPanel17.add(logOutBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 170, -1));

        MUcashierTransactionBtn2.setText("Cashier's Transaction");
        MUcashierTransactionBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MUcashierTransactionBtn2MouseClicked(evt);
            }
        });
        jPanel17.add(MUcashierTransactionBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

        MUManageUsersBtn2.setText("Manage Users");
        MUManageUsersBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MUManageUsersBtn2MouseClicked(evt);
            }
        });
        jPanel17.add(MUManageUsersBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, -1));

        MUstaffTransactionBtn.setText("Staff's Transaction");
        MUstaffTransactionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MUstaffTransactionBtnMouseClicked(evt);
            }
        });
        jPanel17.add(MUstaffTransactionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 170, -1));

        MUusersHomeBtn3.setText("Home");
        MUusersHomeBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MUusersHomeBtn3MouseClicked(evt);
            }
        });
        jPanel17.add(MUusersHomeBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jPanel12.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 420, 170));

        murResetBtn.setText("Reset");
        murResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                murResetBtnActionPerformed(evt);
            }
        });
        jPanel12.add(murResetBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 500, 78, -1));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MUsers", jPanel6);

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
        jPanel20.add(CTcashierTrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

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
        jPanel20.add(CTstaffTransactionBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 170, -1));

        usersHomeBtn2.setText("Home");
        usersHomeBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersHomeBtn2MouseClicked(evt);
            }
        });
        jPanel20.add(usersHomeBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 420, 170));

        staffTransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction_ID", "Transaction Date", "UserID", "InventoryID", "Product Name", "Type of Transaction"
            }
        ));
        staffTransactionTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                staffTransactionTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(staffTransactionTable);

        jPanel18.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 760, 290));

        jPanel21.setBackground(new java.awt.Color(255, 204, 204));

        jLabel14.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 0, 0));
        jLabel14.setText("Staff's Transaction");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel18.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 50));

        staffNameId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StaffID", "Staff Name"
            }
        ));
        jScrollPane4.setViewportView(staffNameId);

        jPanel18.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 240, 130));

        staffTransactDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction Date"
            }
        ));
        jScrollPane5.setViewportView(staffTransactDate);

        jPanel18.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 240, 130));

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

        jTabbedPane1.addTab("STransactions", jPanel14);

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
        jPanel19.add(STcashiersTransbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

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
        jPanel19.add(STstaffTransactionBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 170, -1));

        usersHomeBtn1.setText("Home");
        usersHomeBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersHomeBtn1MouseClicked(evt);
            }
        });
        jPanel19.add(usersHomeBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jPanel15.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 420, 170));

        cashierTransTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TransactionID", "Product Name", "Quantity", "Total Amount", "UserID", "Date"
            }
        ));
        cashierTransTables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierTransTablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(cashierTransTables);

        jPanel15.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 630, 270));

        jPanel22.setBackground(new java.awt.Color(255, 204, 204));

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 0, 0));
        jLabel15.setText("Cashier's Transaction");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 310, 50));

        cashierTransactDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction Date"
            }
        ));
        cashierTransactDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashierTransactDateMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(cashierTransactDate);

        jPanel15.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 240, 130));

        jPanel5.setBackground(new java.awt.Color(255, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Total Sales/Day:");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 146, 120, -1));

        totalSalesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalSalesFieldActionPerformed(evt);
            }
        });
        jPanel5.add(totalSalesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 169, 115, 36));

        jLabel12.setText("Total Quantity Sold:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 36, 120, -1));

        totalQuantitySold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalQuantitySoldActionPerformed(evt);
            }
        });
        jPanel5.add(totalQuantitySold, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 59, 115, 36));

        jPanel15.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 210, 270));

        jPanel10.setBackground(new java.awt.Color(255, 102, 102));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productSoldTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product", "Sold"
            }
        ));
        jScrollPane6.setViewportView(productSoldTbl);

        jPanel10.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 250));

        jPanel15.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, 240, 270));

        cashierNameId.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StaffID", "Staff Name"
            }
        ));
        jScrollPane8.setViewportView(cashierNameId);

        jPanel15.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 240, 130));

        jTabbedPane1.addTab("CTransactions", jPanel15);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 204, 204));

        jLabel16.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 0, 0));
        jLabel16.setText("Product with Lower Quantity");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel11.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 450, 50));

        tresholdTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Poduct", "Quantity", "Status"
            }
        ));
        jScrollPane9.setViewportView(tresholdTbl);

        jPanel11.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 930, 280));

        jPanel24.setBackground(new java.awt.Color(255, 153, 153));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logOutBtn5.setText("Log Out");
        logOutBtn5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtn5MouseClicked(evt);
            }
        });
        jPanel24.add(logOutBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 170, -1));

        STcashiersTransbtn1.setText("Cashier's Transaction");
        STcashiersTransbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STcashiersTransbtn1MouseClicked(evt);
            }
        });
        jPanel24.add(STcashiersTransbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 170, -1));

        STmanageUserbtn1.setText("Manage Users");
        STmanageUserbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STmanageUserbtn1MouseClicked(evt);
            }
        });
        jPanel24.add(STmanageUserbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, -1));

        STstaffTransactionBtn4.setText("Staff's Transaction");
        STstaffTransactionBtn4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                STstaffTransactionBtn4MouseClicked(evt);
            }
        });
        jPanel24.add(STstaffTransactionBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 170, -1));

        usersHomeBtn3.setText("Home");
        usersHomeBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersHomeBtn3MouseClicked(evt);
            }
        });
        jPanel24.add(usersHomeBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, -1));

        jPanel11.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 420, 170));

        jTabbedPane1.addTab("Threshold", jPanel11);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void ManageUsersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageUsersBtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_ManageUsersBtnMouseClicked

    private void staffTransactionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTransactionBtnMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_staffTransactionBtnMouseClicked

    private void cashierTransactionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierTransactionBtnMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_cashierTransactionBtnMouseClicked

    private void MUcashierTransactionBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUcashierTransactionBtn2MouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_MUcashierTransactionBtn2MouseClicked

    private void MUManageUsersBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUManageUsersBtn2MouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_MUManageUsersBtn2MouseClicked

    private void MUstaffTransactionBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUstaffTransactionBtnMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_MUstaffTransactionBtnMouseClicked

    private void STcashiersTransbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STcashiersTransbtnMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_STcashiersTransbtnMouseClicked

    private void STmanageUserbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STmanageUserbtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_STmanageUserbtnMouseClicked

    private void STstaffTransactionBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STstaffTransactionBtn3MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_STstaffTransactionBtn3MouseClicked

    private void CTcashierTransMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTcashierTransMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_CTcashierTransMouseClicked

    private void CTmanageUsersBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTmanageUsersBtnMouseClicked
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_CTmanageUsersBtnMouseClicked

    private void CTstaffTransactionBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CTstaffTransactionBtn4MouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_CTstaffTransactionBtn4MouseClicked

    private void usersHomeBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersHomeBtn1MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_usersHomeBtn1MouseClicked

    private void usersHomeBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersHomeBtn2MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_usersHomeBtn2MouseClicked

    private void MUusersHomeBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUusersHomeBtn3MouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_MUusersHomeBtn3MouseClicked

    private void manageUserTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageUserTableMouseClicked
        DefaultTableModel manageUsertbl = (DefaultTableModel) manageUserTable.getModel();

        String tblid = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 0);
        String tblFname = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 1);
        String tblLname = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 2);
        String tblEmail = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 3);
        String tblpassword = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 4);
        String tblrole = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 5);
        String tblstatus = (String) manageUsertbl.getValueAt(manageUserTable.getSelectedRow(), 6);

        this.idfield.setText(tblid);
        this.idfield.setEditable(false);
        this.fNameField.setText(tblFname);
        this.lNameField.setText(tblLname);
        this.emailField.setText(tblEmail);
        this.passwordField.setText(tblpassword);
        this.roleField.setText(tblrole);
        this.statusCombobox.setSelectedIndex(0);


    }//GEN-LAST:event_manageUserTableMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        DefaultTableModel manageTable = (DefaultTableModel) manageUserTable.getModel();
        if (manageUserTable.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Unsuccessful!", "Alert", JOptionPane.ERROR_MESSAGE);
        } else {

            String ipid = (String) manageTable.getValueAt(manageUserTable.getSelectedRow(), 0);
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                    Statement stmt = con.createStatement();
                    String query = "DELETE FROM users WHERE UserID= " + ipid + "";

                    int a = JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (a == JOptionPane.YES_OPTION) {
                        stmt.execute(query);
                        con.close();
                        JOptionPane.showMessageDialog(null, "Successfully Deleted.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                        manageTable.removeRow(manageUserTable.getSelectedRow());
                    } else {
                        JOptionPane.getRootFrame().dispose();
                    }
                    this.idfield.setText(null);
                    this.fNameField.setText(null);
                    this.lNameField.setText(null);
                    this.emailField.setText(null);
                    this.passwordField.setText(null);
                    this.roleField.setText(null);
                    this.statusCombobox.setSelectedIndex(0);

                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Unsuccessful!", "Alert", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void updateBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseClicked
        DefaultTableModel manageuserstbl = (DefaultTableModel) manageUserTable.getModel();

        if ("".equals(idfield.getText())) {
            JOptionPane.showMessageDialog(null, "No Selected Account!", "Alert", JOptionPane.ERROR_MESSAGE);
        } else {
            String userid = (String) manageuserstbl.getValueAt(manageUserTable.getSelectedRow(), 0);

            int count;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                    Statement stmt = con.createStatement();
                    Statement stmt1 = con.createStatement();
                    String query = "UPDATE `users` SET `FirstName`='" + this.fNameField.getText() + "',`LastName`='" + this.lNameField.getText() + "',`Email`='" + this.emailField.getText() + "',`Password`='" + this.passwordField.getText() + "',`Role`='" + this.roleField.getText() + "',`Status`='" + this.statusCombobox.getSelectedItem() + "' WHERE  UserID = '" + userid + "'";
                    stmt.execute(query);
                    this.idfield.setText(null);
                    this.fNameField.setText(null);
                    this.lNameField.setText(null);
                    this.emailField.setText(null);
                    this.passwordField.setText(null);
                    this.roleField.setText(null);
                    this.statusCombobox.setSelectedIndex(0);

                    ResultSet datas = stmt1.executeQuery("SELECT * FROM `users`");
                    while (datas.next()) {
                        count = 0;
                        manageuserstbl.removeRow(count);
                        manageuserstbl.addRow(new Object[]{datas.getString("UserID"), datas.getString("FirstName"), datas.getString("LastName"), datas.getString("Email"), datas.getString("Password"), datas.getString("Role"), datas.getString("Status")});
                    }

                    con.close();
                    JOptionPane.showMessageDialog(null, "Successfully Updated.", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (HeadlessException | ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }//GEN-LAST:event_updateBtnMouseClicked

    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        DefaultTableModel adduserstbl = (DefaultTableModel) manageUserTable.getModel();
        int count;

        if ("Change Status".equals(this.statusCombobox.getSelectedItem())) {
            JOptionPane.showMessageDialog(null, "Choose status!", "Alert", JOptionPane.ERROR_MESSAGE);
            if ("".equals(this.idfield.getText()) || "".equals(this.fNameField.getText()) || "".equals(this.lNameField.getText()) || "".equals(this.emailField.getText()) || "".equals(this.passwordField.getText()) || "".equals(this.roleField.getText())) {
                JOptionPane.showMessageDialog(null, "Input all the given fields!", "Alert", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            try {
                String sql = "INSERT INTO `users`" + "(`UserID`, `FirstName`, `LastName`, `Email`, `Password` , `Role`, `Status`)" + " VALUES " + "(?, ?, ?, ?, ?, ?, ?)";

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "");
                pst = con.prepareStatement(sql);

                pst.setString(1, idfield.getText());
                pst.setString(2, fNameField.getText());
                pst.setString(3, lNameField.getText());
                pst.setString(4, emailField.getText());
                pst.setString(5, passwordField.getText());
                pst.setString(6, roleField.getText());
                pst.setString(7, statusCombobox.getSelectedItem().toString());
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully Added Data.", "Alert", JOptionPane.INFORMATION_MESSAGE);

                Statement stmt = con.createStatement();
                Statement stmt1 = con.createStatement();
                ResultSet datas = stmt1.executeQuery("SELECT * FROM `users`");
                while (datas.next()) {
                    count = 0;
                    adduserstbl.removeRow(count);
                    adduserstbl.addRow(new Object[]{datas.getString("UserID"), datas.getString("FirstName"), datas.getString("LastName"), datas.getString("Email"), datas.getString("Password"), datas.getString("Role"), datas.getString("Status")});
                }

                this.idfield.setText(null);
                this.fNameField.setText(null);
                this.lNameField.setText(null);
                this.emailField.setText(null);
                this.passwordField.setText(null);
                this.roleField.setText(null);
                this.statusCombobox.setSelectedIndex(0);

            } catch (SQLException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_addBtnMouseClicked

    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logOutBtnMouseClicked

    private void logOutBtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn2MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logOutBtn2MouseClicked

    private void logOutBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn4MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logOutBtn4MouseClicked

    private void logOutBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn3MouseClicked
        int a = JOptionPane.showConfirmDialog(null, "Are you sure to logout?", "Warning", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.getRootFrame().dispose();
        }
    }//GEN-LAST:event_logOutBtn3MouseClicked

    private void murResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_murResetBtnActionPerformed
        if (evt.getSource() == murResetBtn) {
            this.idfield.setText(null);
            this.idfield.setEditable(true);
            this.fNameField.setText(null);
            this.lNameField.setText(null);
            this.emailField.setText(null);
            this.passwordField.setText(null);
            this.roleField.setText(null);
            this.statusCombobox.setSelectedIndex(0);
        }
    }//GEN-LAST:event_murResetBtnActionPerformed

    private void staffTransactionTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_staffTransactionTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_staffTransactionTableMouseClicked

    private void cashierTransTablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierTransTablesMouseClicked

    }//GEN-LAST:event_cashierTransTablesMouseClicked

    private void totalSalesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalSalesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalSalesFieldActionPerformed

    private void cashierTransactDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashierTransactDateMouseClicked

        DefaultTableModel transactionDateTableModel = (DefaultTableModel) cashierTransactDate.getModel();
//        DefaultTableModel productSoldTableModel = (DefaultTableModel) productSoldTbl.getModel();

        String transactionDate = (String) transactionDateTableModel.getValueAt(cashierTransactDate.getSelectedRow(), 0);

        int orderCount;
        int totalQuantitySold = 0;
        int totalAmountPerDay = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management_system", "root", "")) {
                Statement stmt2 = con.createStatement();
                ResultSet orderData = stmt2.executeQuery("SELECT * FROM `ctransactions` WHERE `date` = '" + transactionDate + "'");
                while (orderData.next()) {
                    orderCount = 1;

                    totalQuantitySold += Integer.parseInt(orderData.getString("Quantity"));
                    totalAmountPerDay += Integer.parseInt(orderData.getString("totalAmount"));

                    this.totalQuantitySold.setText(Integer.toString(totalQuantitySold));
                    this.totalQuantitySold.setEditable(false);
                    this.totalSalesField.setText("Php " + (Integer.toString(totalAmountPerDay)) + ".00");
                    this.totalSalesField.setEditable(false);
                }

//                Statement stmt3 = con.createStatement();
//                ResultSet soldData = stmt3.executeQuery("SELECT DISTINCT `productName`, `Quantity` FROM `ctransactions`= '" + transactionDate + "'");
//
//                while (cashierTransactDate.getSelectedRow() == 0) {
//                    DefaultTableModel productSoldTableModel = (DefaultTableModel) productSoldTbl.getModel();
//
//                }
                DefaultTableModel productSoldTableModel = (DefaultTableModel) productSoldTbl.getModel();
                int dateCount;
                try {

                    Statement stmt = con.createStatement();
                    ResultSet proData = stmt.executeQuery("SELECT DISTINCT `productName`, `Quantity` FROM `ctransactions`WHERE Date = '" + transactionDate + "'");
                    while (proData.next()) {
                        productSoldTableModel.addRow(new Object[]{proData.getString("productName"), proData.getString("Quantity")});
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_cashierTransactDateMouseClicked

    private void totalQuantitySoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalQuantitySoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalQuantitySoldActionPerformed

    private void logOutBtn5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtn5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_logOutBtn5MouseClicked

    private void STcashiersTransbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STcashiersTransbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_STcashiersTransbtn1MouseClicked

    private void STmanageUserbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STmanageUserbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_STmanageUserbtn1MouseClicked

    private void STstaffTransactionBtn4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_STstaffTransactionBtn4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_STstaffTransactionBtn4MouseClicked

    private void usersHomeBtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersHomeBtn3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usersHomeBtn3MouseClicked

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
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CTcashierTrans;
    private javax.swing.JButton CTmanageUsersBtn;
    private javax.swing.JButton CTstaffTransactionBtn4;
    private javax.swing.JButton MUManageUsersBtn2;
    private javax.swing.JButton MUcashierTransactionBtn2;
    private javax.swing.JButton MUstaffTransactionBtn;
    private javax.swing.JButton MUusersHomeBtn3;
    private javax.swing.JButton ManageUsersBtn;
    private javax.swing.JButton STcashiersTransbtn;
    private javax.swing.JButton STcashiersTransbtn1;
    private javax.swing.JButton STmanageUserbtn;
    private javax.swing.JButton STmanageUserbtn1;
    private javax.swing.JButton STstaffTransactionBtn3;
    private javax.swing.JButton STstaffTransactionBtn4;
    private javax.swing.JButton addBtn;
    private javax.swing.JTable cashierNameId;
    private javax.swing.JTable cashierTransTables;
    private javax.swing.JTable cashierTransactDate;
    private javax.swing.JButton cashierTransactionBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fNameField;
    private javax.swing.JTextField idfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lNameField;
    private javax.swing.JButton logOutBtn;
    private javax.swing.JButton logOutBtn2;
    private javax.swing.JButton logOutBtn3;
    private javax.swing.JButton logOutBtn4;
    private javax.swing.JButton logOutBtn5;
    private javax.swing.JTable manageUserTable;
    private javax.swing.JButton murResetBtn;
    private javax.swing.JTextField passwordField;
    private javax.swing.JTable productSoldTbl;
    private javax.swing.JTextField roleField;
    private javax.swing.JTable staffNameId;
    private javax.swing.JTable staffTransactDate;
    private javax.swing.JButton staffTransactionBtn;
    private javax.swing.JTable staffTransactionTable;
    private javax.swing.JComboBox<String> statusCombobox;
    private javax.swing.JTextField totalQuantitySold;
    private javax.swing.JTextField totalSalesField;
    private javax.swing.JTable tresholdTbl;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton usersHomeBtn1;
    private javax.swing.JButton usersHomeBtn2;
    private javax.swing.JButton usersHomeBtn3;
    // End of variables declaration//GEN-END:variables
}
