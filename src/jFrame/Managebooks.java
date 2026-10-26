
package jFrame;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Managebooks extends javax.swing.JFrame {

     String bookName,author;
        int bookId,quantity;
        DefaultTableModel model;
        
    public Managebooks() {
        initComponents();
       setBookDetailsToTable();
    }
        Statement st=null;
        ResultSet rs=null;
   
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
        //to add bok to book_details table
        public boolean addBook(){
            boolean isAdded=false;
            bookId=Integer.parseInt(txt_bookId.getText());
            bookName=txt_bookName.getText();
            author=txt_authorName.getText();
            quantity=Integer.parseInt(txt_quantity.getText());
            java.sql.PreparedStatement pst=null;
            ResultSet rs=null;
            try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="insert into book_details values(?,?,?,?)";
                // pst=conn.prepareStatement(sql);
                 pst=conn.prepareStatement(sql);
                 pst.setInt(1,bookId);
                 pst.setString(2, bookName);
                 pst.setString(3, author);
                 pst.setInt(4,quantity);
                 
                 int rowCount=pst.executeUpdate();
                 if(rowCount>0){
                     isAdded=true;
                    
                     
                 }
                 else{
                     isAdded=false;
                 }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
        return isAdded;
        }
        
        //method to clear table
        
        public void clearTable(){
            DefaultTableModel model=(DefaultTableModel)rSTableMetro2.getModel();
            model.setRowCount(0);
        }
        
        //to update book details
        public boolean updateBook(){
             boolean isUpdated=false;
            bookId=Integer.parseInt(txt_bookId.getText());
            bookName=txt_bookName.getText();
            author=txt_authorName.getText();
            quantity=Integer.parseInt(txt_quantity.getText());
            java.sql.PreparedStatement pst=null;
            
            
             try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="update book_details set book_name=?,author=?,quantity=? where book_id=?";
                 pst=conn.prepareStatement(sql);
                 
                 pst.setString(1, bookName);
                 pst.setString(2, author);
                 pst.setInt(3,quantity);
                 pst.setInt(4,bookId);
                
                 
                 int rowCount=pst.executeUpdate();
                 if(rowCount>0){
                     isUpdated=true;
                    
                     
                 }
                 else{
                     isUpdated=false;
                 }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
        return isUpdated;
        }
        
        //method to delete book detail
        public boolean deleteBook(){
             boolean isDeleted=false;
            bookId=Integer.parseInt(txt_bookId.getText());
            bookName=txt_bookName.getText();
            author=txt_authorName.getText();
            quantity=Integer.parseInt(txt_quantity.getText());
            java.sql.PreparedStatement pst=null;
            
            
             try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="delete from book_details where book_id=?";
                 pst=conn.prepareStatement(sql);
                 
                
                 pst.setInt(1,bookId);
                
                 
                 int rowCount=pst.executeUpdate();
                 if(rowCount>0){
                     isDeleted=true;
                    
                     
                 }
                 else{
                     isDeleted=false;
                 }
                
            
        }catch(Exception e){
                System.out.println(e);
        }
        return isDeleted;
        }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_bookName = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_authorName = new app.bolivia.swing.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro2 = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Book ID");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 270, 30));

        txt_bookId.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_bookId.setPlaceholder("Enter Book Id...");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 330, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 70, 60));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Enter Book Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 270, 30));

        txt_bookName.setBackground(new java.awt.Color(102, 102, 255));
        txt_bookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_bookName.setPlaceholder("Enter Book Name...");
        txt_bookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_bookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 330, 50));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 70, 60));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Author Name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 270, 30));

        txt_authorName.setBackground(new java.awt.Color(102, 102, 255));
        txt_authorName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_authorName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_authorName.setPlaceholder("Enter username...");
        txt_authorName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authorNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_authorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 330, 50));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 70, 60));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Quantity");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 270, 30));

        txt_quantity.setBackground(new java.awt.Color(102, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_quantity.setPlaceholder("Enter Quantity...");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 330, 50));

        jLabel19.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 70, 60));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, 170, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 170, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 650, 170, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 910));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setToolTipText("");
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(102, 102, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 110, 40));

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
        rSTableMetro2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSTableMetro2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(rSTableMetro2);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 700, 320));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("   Manage Books");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 310, 50));

        jPanel5.setBackground(new java.awt.Color(255, 51, 52));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 370, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 860, 910));

        setSize(new java.awt.Dimension(1440, 910));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Homepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost

    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookNameFocusLost

    }//GEN-LAST:event_txt_bookNameFocusLost

    private void txt_authorNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authorNameFocusLost

    }//GEN-LAST:event_txt_authorNameFocusLost

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost

    }//GEN-LAST:event_txt_quantityFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(deleteBook()== true){
         JOptionPane.showMessageDialog(this, "Record Deleted Successfull.");
         clearTable();
         setBookDetailsToTable();
    }
    else{
         JOptionPane.showMessageDialog(this, "Record Deleted Failed.");
    }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
    if(addBook() == true){
         JOptionPane.showMessageDialog(this, "Record Added Successfull.");
         clearTable();
         setBookDetailsToTable();
    }
    else{
         JOptionPane.showMessageDialog(this, "Record Added Failed.");
    }
        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
    if(updateBook()== true){
         JOptionPane.showMessageDialog(this, "Record Updated Successfull.");
         clearTable();
         setBookDetailsToTable();
    }
    else{
         JOptionPane.showMessageDialog(this, "Record Updated Failed.");
    }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jPanel4MouseClicked

    private void rSTableMetro2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSTableMetro2MouseClicked
        
        
        int rowNo = rSTableMetro2.getSelectedRow();
        TableModel model=rSTableMetro2.getModel();
        txt_bookId.setText(model.getValueAt(rowNo, 0).toString());
        txt_bookName.setText(model.getValueAt(rowNo, 1).toString());
        txt_authorName.setText(model.getValueAt(rowNo, 2).toString());
        txt_quantity.setText(model.getValueAt(rowNo, 3).toString());
        
        
        
        
        
        
        
    }//GEN-LAST:event_rSTableMetro2MouseClicked

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Managebooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro rSTableMetro2;
    private app.bolivia.swing.JCTextField txt_authorName;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_bookName;
    private app.bolivia.swing.JCTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
