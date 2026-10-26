
package jFrame;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ManageStudents extends javax.swing.JFrame {

     String studentName,course,branch;
        int studentId;
        DefaultTableModel model;
        
    public ManageStudents() {
        initComponents();
       setStudentDetailsToTable();
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
                     model =(DefaultTableModel) rSTableMetro2.getModel();
                     model.addRow(obj);
                     
                 }
            } catch (SQLException ex) {
            Logger.getLogger(ManageStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        //to add student to student_details table
        public boolean addStudent(){
            boolean isAdded=false;
            studentId=Integer.parseInt(txt_studentId.getText());
            studentName=txt_studentName.getText();
            course=combo_courseName.getSelectedItem().toString();
            branch=combo_branch.getSelectedItem().toString();
           
            java.sql.PreparedStatement pst=null;
            ResultSet rs=null;
            try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="insert into student_details values(?,?,?,?)";
                // pst=conn.prepareStatement(sql);
                 pst=conn.prepareStatement(sql);
                 pst.setInt(1,studentId);
                 pst.setString(2, studentName);
                 pst.setString(3, course);
                 pst.setString(4,branch);
                 
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
        
        //to update student details
        public boolean updateStudent(){
             boolean isUpdated=false;
           studentId=Integer.parseInt(txt_studentId.getText());
            studentName=txt_studentName.getText();
            course=combo_courseName.getSelectedItem().toString();
            branch=combo_branch.getSelectedItem().toString();
            
            java.sql.PreparedStatement pst=null;
            
            
             try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="update student_details set name=?,course=?,branch=? where student_id=?";
                 pst=conn.prepareStatement(sql);
                 
                 pst.setString(1, studentName);
                 pst.setString(2, course);
                 pst.setString(3,branch);
                 pst.setInt(4,studentId);
                
                 
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
        
        //method to delete student detail
        public boolean deleteStudent(){
             boolean isDeleted=false;
            studentId=Integer.parseInt(txt_studentId.getText());
            studentName=txt_studentName.getText();
            course=combo_courseName.getSelectedItem().toString();
            branch=combo_branch.getSelectedItem().toString();
            java.sql.PreparedStatement pst=null;
            
            
             try{
                 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","arjun");
                 String sql="delete from student_details where student_id=?";
                 pst=conn.prepareStatement(sql);
                 
                
                 pst.setInt(1,studentId);
                
                 
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
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_studentName = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_branch = new javax.swing.JComboBox<>();
        combo_courseName = new javax.swing.JComboBox<>();
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
        jLabel13.setText("Enter Student Id");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 270, 30));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 330, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 70, 60));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Enter Student Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 270, 30));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name...");
        txt_studentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentNameFocusLost(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 330, 50));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 70, 60));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Select Course ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 270, 30));

        jLabel17.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 70, 60));

        jLabel18.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Select Branch");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 270, 30));

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

        combo_branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "ELECTRONICS", "PLAIN" }));
        combo_branch.setToolTipText("");
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 340, 40));

        combo_courseName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_courseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MSC", "BSC", "PHD", "BCA", " " }));
        combo_courseName.setToolTipText("");
        jPanel1.add(combo_courseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 340, 40));

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
                "Student Id", "Name", "Course", "Branch"
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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("   Manage Students");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 370, 100));

        jPanel5.setBackground(new java.awt.Color(255, 51, 52));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 440, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 860, 910));

        setSize(new java.awt.Dimension(1440, 910));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new Homepage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost

    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentNameFocusLost

    }//GEN-LAST:event_txt_studentNameFocusLost

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
       if(deleteStudent()== true){
         JOptionPane.showMessageDialog(this, "Record Deleted Successfull.");
         clearTable();
         setStudentDetailsToTable();
    }
    else{
         JOptionPane.showMessageDialog(this, "Record Deleted Failed.");
    }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
    if(addStudent() == true){
         JOptionPane.showMessageDialog(this, "Record Added Successfull.");
         clearTable();
         setStudentDetailsToTable();
    }
    else{
         JOptionPane.showMessageDialog(this, "Record Added Failed.");
    }
        
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
    if(updateStudent()== true){
         JOptionPane.showMessageDialog(this, "Record Updated Successfull.");
         clearTable();
         setStudentDetailsToTable();
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
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_courseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());

    }//GEN-LAST:event_rSTableMetro2MouseClicked

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_courseName;
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
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}
