/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jFrame;

import com.mysql.cj.protocol.Resultset;
import java.sql.*;
//import java.util.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author rudra
 */
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
//to fatch the book details from the database
    public void getBookDetails(){
        int bookId=Integer.parseInt(txt_bookId.getText());
         java.sql.PreparedStatement pst=null;
          ResultSet rs=null;
             try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="select * from book_details where book_id=?";
                 pst=conn.prepareStatement(sql);
                 
                
                 pst.setInt(1,bookId);
                
                 
                 rs= pst.executeQuery();
               if(rs.next()){
                   lbl_bookId.setText(rs.getString("book_id"));
                   lbl_bookName.setText(rs.getString("book_name"));
                   lbl_author.setText(rs.getString("author"));
                   lbl_quantity.setText(rs.getString("quantity"));
               }
               else{
                   lbl_bookError.setText("Invalid Book ID");
               }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
    }
    
    //to fatch the book details from the database
    public void getStudentDetails(){
        int studentId=Integer.parseInt(txt_studentId.getText());
         java.sql.PreparedStatement pst=null;
          ResultSet rs=null;
             try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="select * from student_details where student_id=?";
                 pst=conn.prepareStatement(sql);
                 
                
                 pst.setInt(1,studentId);
                
                 
                 rs= pst.executeQuery();
               if(rs.next()){
                   lbl_studentId.setText(rs.getString("student_id"));
                   lbl_studentName.setText(rs.getString("name"));
                   lbl_course.setText(rs.getString("course"));
                   lbl_branch.setText(rs.getString("branch"));
               }
               else{
                   lbl_studentError.setText("Invalid Student ID");
               }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
    }
    
    //insert issue book details to database
    public boolean issueBook(){
        boolean isIssued=false;
        int bookId=Integer.parseInt(txt_bookId.getText());
         int studentId=Integer.parseInt(txt_studentId.getText());
         String bookName=lbl_bookName.getText();
         String studentName=lbl_studentName.getText();
         
         java.util.Date uIssueDate=date_issueDate.getDatoFecha();
         java.util.Date uDueDate=date_dueDate.getDatoFecha();
         Long l1 =uIssueDate.getTime();
         long l2=uDueDate.getTime();
         
         java.sql.Date sIssueDate = new java.sql.Date(l1);
         java.sql.Date sDueDate = new java.sql.Date(l2);
         java.sql.PreparedStatement pst=null;
         try {
             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
            
             String sql="insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values (?,?,?,?,?,?,?)";
              pst=conn.prepareStatement(sql);
              pst.setInt(1,bookId);
              pst.setString(2,bookName);
              pst.setInt(3,studentId);
              pst.setString(4,studentName);
              pst.setDate(5,sIssueDate);
              pst.setDate(6,sDueDate);
              pst.setString(7, "pending");
                   
        int rowCount=pst.executeUpdate();
                 if(rowCount>0){
                     isIssued=true;
                    
                     
                 }
                 else{
                     isIssued=false;
                 }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
        return isIssued;
    }
    //updating book count
    public void updateBookCount(){
          int bookId=Integer.parseInt(txt_bookId.getText());
           java.sql.PreparedStatement pst=null;
        
          try {
               Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
               String sql="update book_details set quantity=quantity-1 where book_id=?";
               pst=conn.prepareStatement(sql);
               pst.setInt(1,bookId);
            int rowCount=pst.executeUpdate();
                 if(rowCount>0){
                    JOptionPane.showMessageDialog(this, "book count updated");
                    int initialCount=Integer.parseInt(lbl_quantity.getText());
                    lbl_quantity.setText(Integer.toString(initialCount-1));
                    
                     
                 }
                 else{
                      JOptionPane.showMessageDialog(this, "can't update book count");
                 }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
        
    }
    // checking whether book already allocated or not
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued=false;
        int bookId=Integer.parseInt(txt_bookId.getText());
         int studentId=Integer.parseInt(txt_studentId.getText());
          java.sql.PreparedStatement pst=null;
         try {
             Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
            
             String sql="select * from issue_book_details where book_id=? and student_id=? and status=?";
              pst=conn.prepareStatement(sql);
              pst.setInt(1,bookId);
              pst.setInt(2,studentId);
              pst.setString(3,"pending");
                          
            ResultSet rowCount=pst.executeQuery();
                 if(rowCount.next()){
                     isAlreadyIssued=true;
                    
                     
                 }
                 else{
                     isAlreadyIssued=false;
                 }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
        return isAlreadyIssued;
    }
        
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_branch = new javax.swing.JLabel();
        lbl_studentId = new javax.swing.JLabel();
        lbl_studentName = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_studentError = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookId = new javax.swing.JLabel();
        lbl_bookName = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Branch:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 120, 50));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student Id:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 50));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Student Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 140, 50));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Course:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, 50));

        lbl_branch.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_branch.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 240, 50));

        lbl_studentId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 240, 50));

        lbl_studentName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 240, 50));

        lbl_course.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_course.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 240, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel7.setText("Student Details");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 290, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 350, 5));

        lbl_studentError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_studentError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(lbl_studentError, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 430, 50));

        panel_main.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 450, 900));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel11.setText("Back");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 100, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel12.setText("Book Details");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 100, 290, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 330, 5));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Book Id:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 120, 50));

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Name:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 120, 50));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 120, 50));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 260, 50));

        lbl_bookId.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookId.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 260, 50));

        lbl_bookName.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 260, 50));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 260, 50));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Quantity:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 120, 50));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 0));
        jPanel4.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 420, 50));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 900));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel2.setText("    Issue Book");
        panel_main.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, 290, -1));

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panel_main.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 300, 5));

        jPanel8.setBackground(new java.awt.Color(255, 51, 51));
        jPanel8.setToolTipText("");
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 51, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("X");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 30, 40));

        panel_main.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 90, 40));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 290, 330, 50));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 51, 51));
        jLabel17.setText("Book Id :");
        panel_main.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 290, 100, 50));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 51, 51));
        jLabel18.setText("Issue Date :");
        panel_main.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 460, 120, 50));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 51, 51)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 370, 330, 50));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_issueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_issueDate.setFuente(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        date_issueDate.setPlaceholder("Select Issue Date");
        panel_main.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 470, 330, -1));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 51, 51));
        jLabel19.setText("Student Id :");
        panel_main.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 120, 50));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 51, 51));
        jLabel20.setText("Due Date :");
        panel_main.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, 120, 50));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_dueDate.setColorForeground(new java.awt.Color(255, 51, 51));
        date_dueDate.setFuente(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        date_dueDate.setPlaceholder("Select Due Date");
        panel_main.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 550, 330, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ISSUE BOOK");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panel_main.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 650, 330, 60));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 900));

        setSize(new java.awt.Dimension(1440, 900));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        new Homepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if(!txt_bookId.getText().equals("")){
                getBookDetails();}
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if(!txt_studentId.getText().equals("")){
                getStudentDetails();}
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(lbl_quantity.getText().equals("0")){
             JOptionPane.showMessageDialog(this, "Book are not available");
        }
        else{
        if(isAlreadyIssued()==false){
             if(issueBook() == true){
         JOptionPane.showMessageDialog(this, "Book issued successfully");
         updateBookCount();
    }
              else{
         JOptionPane.showMessageDialog(this, "can't issue the book");
    }
        }
        else{
            JOptionPane.showMessageDialog(this, "this student has already has this book");
        }
        
        }
       
   

    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookId;
    private javax.swing.JLabel lbl_bookName;
    private javax.swing.JLabel lbl_branch;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_studentError;
    private javax.swing.JLabel lbl_studentId;
    private javax.swing.JLabel lbl_studentName;
    private javax.swing.JPanel panel_main;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    // End of variables declaration//GEN-END:variables
}
