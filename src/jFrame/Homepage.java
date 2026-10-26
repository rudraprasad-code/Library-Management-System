/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author rudra
 */

public class Homepage extends javax.swing.JFrame {

    /**
     * Creates new form Homepage
     */
    Color mouseEnterColor= new Color(0,0,0);
    Color mouseExitColor= new Color(51,51,51);
    DefaultTableModel model;
    public Homepage() {
        initComponents();
        showPieChart();
        setStudentDetailsToTable();
        setBookDetailsToTable();
        setDataToCard();
    }
    Statement st=null;
        ResultSet rs=null;
    
    public void setStudentDetailsToTable(){
            try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                  st=conn.createStatement();
                 rs= st.executeQuery("select * from student_details");
                 while(rs.next()){
                     String studentid=rs.getString("student_id");
                     String course1=rs.getString("course");
                     String name=rs.getString("name");
                     String branch1=rs.getString("branch");
                     
                     Object [] obj={studentid,name,course1,branch1};
                     model =(DefaultTableModel) rSTableMetro1.getModel();
                     model.addRow(obj);
                     
                 }
            } catch (SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    
    public void setDataToCard(){
        Statement st=null;
        ResultSet rs=null;
        
        long l=System.currentTimeMillis();
        java.sql.Date todaysDate=new java.sql.Date(l);
        try {
             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
             st=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
              rs=  st.executeQuery("select * from book_details");
                rs.last();
                lbl_noOfBooks.setText(Integer.toString(rs.getRow()));
                
                rs=  st.executeQuery("select * from student_details");
                
                rs.last();
                lbl_noOfStudents.setText(Integer.toString(rs.getRow()));
                
                rs=  st.executeQuery("select * from issue_book_details where status='"+"pending"+"'");
                
                rs.last();
                lbl_noOfIssuedBooks.setText(Integer.toString(rs.getRow()));
                
                 rs=  st.executeQuery("select * from issue_book_details where due_date < '"+todaysDate+"' and status='"+"pending"+"'");
                
                rs.last();
                lbl_noOfDafaulterList.setText(Integer.toString(rs.getRow()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public void setBookDetailsToTable(){
            try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                  st=conn.createStatement();
                 rs= st.executeQuery("select * from book_details");
                 while(rs.next()){
                     String bookid=rs.getString("book_id");
                     String au=rs.getString("author");
                     String name=rs.getString("book_name");
                     int qu=rs.getInt("quantity");
                     
                     Object [] obj={bookid,name,au,qu};
                     model =(DefaultTableModel) rSTableMetro2.getModel();
                     model.addRow(obj);
                     
                 }
            } catch (SQLException ex) {
            Logger.getLogger(Managebooks.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
    
    public void showPieChart(){
        
        //create dataset
      DefaultPieDataset barDataset = new DefaultPieDataset( );
      
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="select book_name,count(*) as issue_count from library_ms.issue_book_details group by book_name";
                 Statement st=conn.createStatement();
                 ResultSet rs=st.executeQuery(sql);
                 while(rs.next()){
                   barDataset.setValue(rs.getString("book_name") , Double.valueOf(rs.getDouble("issue_count")));    
                 }
            
        } catch (Exception e) {
            System.out.println(e);
        }
      
      
      
      //create chart
       JFreeChart piechart = ChartFactory.createPieChart("Issue Book Details",barDataset, false,true,false);//explain
      
        PiePlot piePlot =(PiePlot) piechart.getPlot();
      
       //changing pie chart blocks colors
       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
      
       
        piePlot.setBackgroundPaint(Color.white);
        
        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        jPanel14.removeAll();
        jPanel14.add(barChartPanel, BorderLayout.CENTER);
        jPanel14.validate();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        lbl_noOfBooks = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lbl_noOfDafaulterList = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbl_noOfStudents = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        lbl_noOfIssuedBooks = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojeru_san.complementos.RSTableMetro();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojeru_san.complementos.RSTableMetro();
        jLabel27 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 50));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, -10, 90, 70));

        jLabel3.setFont(new java.awt.Font("Yu Gothic Light", 1, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Library Management System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 340, 60));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel4.setText("Welcome,Admin");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 220, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1550, 70));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel5.setText("   Logout");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 280, 60));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel6.setText("   Home Page");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 30));

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel16.setText("   Home Page");
        jPanel6.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 30));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 340, 60));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 280, 60));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel8.setText("   Manage Books");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        jPanel23.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 60));

        jPanel3.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 280, 60));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Features");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 190, 20));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setBackground(new java.awt.Color(153, 153, 153));
        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel28.setText("   LMS Dashboard");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });
        jPanel15.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 30));

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 280, 60));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel14.setText("   Defaulter List");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        jPanel17.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 30));

        jPanel3.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 280, 60));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, -1, 60));

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel9.setText("   Return Book");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        jPanel24.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setBackground(new java.awt.Color(153, 153, 153));
        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel29.setText("   Issue Book");
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });
        jPanel26.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel24.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 280, 60));

        jPanel3.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 280, 60));

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel10.setText("   Manage Student");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        jPanel25.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel3.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, 60));

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel11.setText("   Issue Book");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        jPanel27.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setBackground(new java.awt.Color(153, 153, 153));
        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel30.setText("   Issue Book");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });
        jPanel28.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel27.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 280, 60));

        jPanel3.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 280, 60));

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(153, 153, 153));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_View_Details_26px.png"))); // NOI18N
        jLabel18.setText("   View Records");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel29.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 190, 50));

        jPanel3.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 280, 60));

        jPanel21.setBackground(new java.awt.Color(51, 51, 51));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel13.setText("   View Issued Books");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        jPanel21.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 200, 30));

        jPanel3.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 280, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 280, 900));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Library_32px.png"))); // NOI18N
        jLabel17.setText("   LMS Dashboard");
        jPanel7.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 30));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 280, 60));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        lbl_noOfBooks.setText("10");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(lbl_noOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_noOfBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 260, 140));

        jLabel15.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Student Details");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        jPanel11.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfDafaulterList.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfDafaulterList.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfDafaulterList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        lbl_noOfDafaulterList.setText("10");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(lbl_noOfDafaulterList, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_noOfDafaulterList, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 260, 140));

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Dafaulter List");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 210, 30));

        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        lbl_noOfStudents.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfStudents.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfStudents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_People_50px.png"))); // NOI18N
        lbl_noOfStudents.setText("10");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(lbl_noOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_noOfStudents, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 260, 140));

        jLabel23.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("No of Students");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 210, 30));

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        lbl_noOfIssuedBooks.setFont(new java.awt.Font("Segoe UI Black", 0, 50)); // NOI18N
        lbl_noOfIssuedBooks.setForeground(new java.awt.Color(102, 102, 102));
        lbl_noOfIssuedBooks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        lbl_noOfIssuedBooks.setText("10");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(lbl_noOfIssuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbl_noOfIssuedBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel9.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 260, 140));

        jLabel25.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Issued Books");
        jPanel9.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 210, 30));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        rSTableMetro1.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        rSTableMetro1.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        rSTableMetro1.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro1.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        rSTableMetro1.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        rSTableMetro1.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        rSTableMetro1.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        rSTableMetro1.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        rSTableMetro1.setRowHeight(40);
        jScrollPane1.setViewportView(rSTableMetro1);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 650, 250));

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("No of Books");
        jPanel9.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 30));

        rSTableMetro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Author", "Quantity"
            }
        ));
        rSTableMetro2.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        rSTableMetro2.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        rSTableMetro2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        rSTableMetro2.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        rSTableMetro2.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        rSTableMetro2.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        rSTableMetro2.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        rSTableMetro2.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        rSTableMetro2.setRowHeight(40);
        jScrollPane2.setViewportView(rSTableMetro2);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 650, 250));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 0, 20)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Book Details");
        jPanel9.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 210, 30));

        jPanel14.setLayout(new java.awt.BorderLayout());
        jPanel9.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 450, 450));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 1160, 830));

        setSize(new java.awt.Dimension(1440, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       new Managebooks().setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        jPanel23.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        jPanel23.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jPanel24.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
       jPanel24.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        new ReturnBook().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        jPanel25.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        jPanel25.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        new ManageStudents().setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseExited

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        jPanel15.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        jPanel15.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel28MouseExited

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        new IssueBook().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
       jPanel27.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jPanel27.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        jPanel29.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
          jPanel29.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        jPanel21.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        jPanel21.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jPanel17.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jPanel17.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        new ViewAllRecord().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        new IssueBookDetail().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        new DefaulterList().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel14MouseClicked

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
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Homepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_noOfBooks;
    private javax.swing.JLabel lbl_noOfDafaulterList;
    private javax.swing.JLabel lbl_noOfIssuedBooks;
    private javax.swing.JLabel lbl_noOfStudents;
    private rojeru_san.complementos.RSTableMetro rSTableMetro1;
    private rojeru_san.complementos.RSTableMetro rSTableMetro2;
    // End of variables declaration//GEN-END:variables
}
