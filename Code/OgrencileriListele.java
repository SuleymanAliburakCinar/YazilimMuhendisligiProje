/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.plaf.basic.BasicInternalFrameUI;
import database.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suley
 */
public class OgrencileriListele extends javax.swing.JInternalFrame {

    ArrayList<Ogrenci> arr;
    String[] header = new String[]{"İsim","Soyisim","Kimlik Numarası","Telefon Numarası"};
    DefaultTableModel dtm;
    String tc;
    DefaultTableModel tm;
    DefaultTableModel tm1;
    
    public OgrencileriListele() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        arr = new ArrayList<Ogrenci>();
        dtm = new DefaultTableModel(header,0);
        jTable1.setModel(dtm);
        taksitKursPane.setVisible(false);
        jOptionPane2.setVisible(false);
    }
    
    public void kurslariGoruntule(String ID,DefaultTableModel tm){
        Database db = new Database("DilKursu","1234");
        
        ArrayList<Integer> alinanID = db.alinanKurslariGetir(ID);
        ArrayList<Integer> aktifID = db.aktifKurslariGetir(ID);
        
        tm.setRowCount(0);
        
        Object[][] objs = new Object[100][2];
        
        int i = 0;
        for(Integer tmp : alinanID){
            objs[i++][0] = tmp;
        }
        i = 0;
        for(Integer tmp : aktifID){
            objs[i++][1] = tmp;
        }
        
        i=0;
        while((objs[i][0] != null) || (objs[i][1] != null)){
            tm.addRow(objs[i++]);
        }
    }
    
    public void taksitleriGoruntule(String ID,DefaultTableModel tm){
        Database db = new Database("DilKursu","1234");
        ArrayList<OdemeBilgisi> ob = db.odeme_bilgisi_getir(ID);
        tm.setRowCount(0);
        int count = 1;
        for(OdemeBilgisi tmp : ob){
            for(int i = 0; i<(tmp.getTaksit_sayisi()- tmp.getOdenen_taksit_sayisi()) ;i++){
                Object[] obj = {count++,tmp.getBirimtaksitfiyat(),tmp.getOdemeId()};
                tm.addRow(obj);
            }
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jOptionPane2 = new javax.swing.JOptionPane();
        taksitKursPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taksitTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        kursTable = new javax.swing.JTable();
        odeButton = new javax.swing.JButton();
        kursButton = new javax.swing.JButton();
        geriButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Kimlik Numarası");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, -1, -1));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 11, 130, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 1050, 44));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Ayrıntılar");
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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Ara");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 90, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Güncelle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 85, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 1050, 41));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1050, 539));
        jPanel1.add(jOptionPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 670));

        taksitKursPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        taksitTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(taksitTable);

        taksitKursPane.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 280, 550));

        kursTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(kursTable);

        taksitKursPane.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 280, 550));

        odeButton.setText("Taksit Öde");
        odeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odeButtonActionPerformed(evt);
            }
        });
        taksitKursPane.add(odeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        kursButton.setText("Kurs Aktifleştir");
        kursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kursButtonActionPerformed(evt);
            }
        });
        taksitKursPane.add(kursButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 110, -1));

        geriButton.setText("Geri");
        geriButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriButtonActionPerformed(evt);
            }
        });
        taksitKursPane.add(geriButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, -1));
        taksitKursPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 100, 20));

        getContentPane().add(taksitKursPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Database db = new Database("DilKursu","1234");
        arr = db.tumOgrencileriGetir();
        dtm = new DefaultTableModel(header,0); 
        jTable1.setModel(dtm);
        dtm.setRowCount(0);
        for(Ogrenci tmp : arr){
            Object[] objs = {tmp.getIsim(),tmp.getSoyisim(),tmp.getTc(),tmp.getTelno()};
            dtm.addRow(objs);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void kursButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kursButtonActionPerformed
        int row,col,kursID;
        Database db = new Database("DilKursu","1234");
        row = kursTable.getSelectedRow();
        col = kursTable.getSelectedColumn();
        kursID = Integer. parseInt(kursTable.getValueAt(row, 0).toString());
        db.kurs_aktiflestir(kursID, tc);
        kurslariGoruntule(tc, tm1);
    }//GEN-LAST:event_kursButtonActionPerformed

    private void odeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odeButtonActionPerformed
        int row,col,kursID;
        Database db = new Database("DilKursu","1234");
        row = taksitTable.getSelectedRow();
        col = taksitTable.getSelectedColumn();
        
        db.taksitOde(Integer.parseInt(taksitTable.getValueAt(row, 2).toString()));
        taksitleriGoruntule(tc, tm);
    }//GEN-LAST:event_odeButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(!jTable1.getSelectionModel().isSelectionEmpty()){
            jPanel1.setVisible(false);
            taksitKursPane.setVisible(true);

            Database db = new Database("DilKursu","1234");

            int row,col;
            row = jTable1.getSelectedRow();
            col = jTable1.getSelectedColumn();
            tc = jTable1.getValueAt(row, 2).toString();

            String[] head = new String[] {"Taksit no", "Taksit Miktarı","ID"};
            tm = new DefaultTableModel(head,0);
            taksitTable.setModel(tm);

            String[] head1 = new String[] {"Alınan Kurslar", "Aktif Kurslar"};
            tm1 = new DefaultTableModel(head1,0);

            kursTable.setModel(tm1);

            kurslariGoruntule(tc, tm1);
            taksitleriGoruntule(tc, tm); 
        }       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void geriButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriButtonActionPerformed
        jPanel1.setVisible(true);
        taksitKursPane.setVisible(false);
    }//GEN-LAST:event_geriButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Database db = new Database("DilKursu","1234");
        System.out.println(jTextField2.getText());
        Ogrenci ogr = db.ogrenciGetir(jTextField2.getText());
        dtm.setRowCount(0);
        if(!jTextField2.getText().isEmpty()){
            if(ogr != null){
                Object[] obj = {ogr.getIsim(),ogr.getSoyisim(),ogr.getTc(),ogr.getTelno()};
                dtm.addRow(obj);
            }
            else{
                jOptionPane2.showMessageDialog(null, "Aradığınız Öğrenci Bulunamadı");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton geriButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JOptionPane jOptionPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton kursButton;
    private javax.swing.JTable kursTable;
    private javax.swing.JButton odeButton;
    private javax.swing.JPanel taksitKursPane;
    private javax.swing.JTable taksitTable;
    // End of variables declaration//GEN-END:variables
}