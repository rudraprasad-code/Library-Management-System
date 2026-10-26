package jFrame;


import java.util.logging.Level;
import java.util.logging.Logger;

public class loading_page extends javax.swing.JFrame {

    public loading_page() {
        initComponents();
        Thread obj=new Thread(new Runnable() {
            @Override
            public void run() {
              for(int i=0;i<=100;i++){
                  jProgressBar1.setValue(i);
                  try {
                      Thread.sleep(50);
                  } catch (InterruptedException ex) {
                      Logger.getLogger(loading_page.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  if(jProgressBar1.getString().equals("10%"))
                      jLabel2.setText("Loading Application...");
                  if(jProgressBar1.getString().equals("25%"))
                      jLabel2.setText("Loading Connecting...");
                  if(jProgressBar1.getString().equals("50%"))
                      jLabel2.setText("Loading Connection Database...");
                       if(jProgressBar1.getString().equals("90%"))
                      jLabel2.setText("Lunching Application...");
                        if(jProgressBar1.getString().equals("100%")){
                             new ShinUpPage().setVisible(true);
                             this.setVisible(false);
}
                 

              }
            }

            private void setVisible(boolean b) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        obj.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Travel Agency Management System");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/library-2.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 1080, 500));

        jProgressBar1.setForeground(new java.awt.Color(255, 255, 0));
        jProgressBar1.setStringPainted(true);
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 740, 1140, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setText("Loading....");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 700, 290, 40));

        jLabel4.setBackground(new java.awt.Color(102, 102, 255));
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(70, 70, 70, 70, new java.awt.Color(255, 51, 51)));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 1140, 640));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 910));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new loading_page().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
