/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author Suley
 */
public class LoginScreen extends javax.swing.JFrame {

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        initComponents();
        jCheckBox2.setOpaque(false);
        isYonetici.setOpaque(false);
        jOptionPane1.setVisible(false);
    }
    
    public java.sql.Connection database_baglan() {
            try {
                String url = "jdbc:postgresql://localhost:5432/DilKursu";
                Properties props = new Properties();
                props.setProperty("user","fred");
                props.setProperty("password","secret");
                props.setProperty("ssl","true");
                java.sql.Connection conn = DriverManager.getConnection(url, "postgres","1234");

                return conn;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
                return null;
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
        jLabel2 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        pwField = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        isYonetici = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        background = new javax.swing.JLabel();
        jOptionPane1 = new javax.swing.JOptionPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Kullanıcı Adı:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 70, -1));

        jLabel2.setText("Şifre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 220, -1, -1));

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });
        jPanel1.add(idField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 150, -1));

        pwField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwFieldActionPerformed(evt);
            }
        });
        jPanel1.add(pwField, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 150, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Login");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 70, 25));

        isYonetici.setText("Yönetici Girişi");
        isYonetici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isYoneticiActionPerformed(evt);
            }
        });
        jPanel1.add(isYonetici, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 273, -1, 19));

        jCheckBox2.setText("Show");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 224, -1, 20));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background-400x600.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));
        jPanel1.add(jOptionPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 260, 100));

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

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    private void pwFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        
        try {
	    java.sql.Connection conn = database_baglan();
	
            if(isYonetici.isSelected()){
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM sistem_yoneticileri WHERE kullaniciismi = '"+idField.getText()+"'");
                if (rs.next() == false) {
                    jOptionPane1.showMessageDialog(this, "Hatali Giriş");
                }
                else{
                    String sifre = rs.getString(5);
                    String passText = new String(pwField.getPassword());
                    if(sifre.compareTo(passText) == 0){
                        YonetimMenu ym = new YonetimMenu();
                        ym.setVisible(true);
                        dispose();
                    }
                    else{
                        jOptionPane1.showMessageDialog(this, "Hatali Giriş");
                    }
                }
                rs.close();
                st.close();
		conn.close();
            }
            else{
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM kayit_elemanlari WHERE kullaniciismi = '"+idField.getText()+"'");
                
                if (rs.next() == false) {
                    jOptionPane1.showMessageDialog(this, "Hatali Giriş");
                }
                else{
                    String sifre = rs.getString(5);
                    String passText = new String(pwField.getPassword());
                    if(sifre.compareTo(passText) == 0){
                        MenuScreen ms = new MenuScreen();
                        ms.setVisible(true);
                        dispose();
                    }
                    else{
                        jOptionPane1.showMessageDialog(this, "Hatali Giriş");
                    }
                }
                rs.close();
                st.close();
		conn.close();
            }
        }
        catch(Exception ex) {
	    System.out.println(ex.getMessage());
	}
    }//GEN-LAST:event_jButton1MouseClicked

    private void isYoneticiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isYoneticiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isYoneticiActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        if(jCheckBox2.isSelected()){
            pwField.setEchoChar((char)0);
        }
        else{
            pwField.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JTextField idField;
    private javax.swing.JCheckBox isYonetici;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pwField;
    // End of variables declaration//GEN-END:variables
}
