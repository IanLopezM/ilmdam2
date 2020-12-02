/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf2_act1_definitiva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumne
 */
public class menu extends javax.swing.JFrame {

    M6_uf2_act1_definitiva connexio = new M6_uf2_act1_definitiva();
    Connection cn;
    /**
     * Creates new form menu
     */
    public menu() throws ClassNotFoundException, SQLException {
        this.cn = connexio.conexion();
        initComponents();
        mostrarTabla();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelNom = new javax.swing.JLabel();
        jLabelDni = new javax.swing.JLabel();
        jLabelNaixement = new javax.swing.JLabel();
        jLabelAP = new javax.swing.JLabel();
        jLabelSexe = new javax.swing.JLabel();
        jLabelCP = new javax.swing.JLabel();
        jTextFieldNom = new javax.swing.JTextField();
        jTextFieldDni = new javax.swing.JTextField();
        jTextFieldNaixement = new javax.swing.JTextField();
        jTextFieldAP = new javax.swing.JTextField();
        jTextFieldSexe = new javax.swing.JTextField();
        jTextFieldCP = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jLabelNoExisteix = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jButtonCancelaar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonActualitzar = new javax.swing.JButton();
        jTextFieldBusca = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 600));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Registre"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelNom.setText("Nom");
        jPanel4.add(jLabelNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 30, 62, -1));

        jLabelDni.setText("Dni");
        jPanel4.add(jLabelDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 68, 62, -1));

        jLabelNaixement.setText("Naixement");
        jPanel4.add(jLabelNaixement, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 106, -1, -1));

        jLabelAP.setText("Adeça Postal");
        jPanel4.add(jLabelAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 144, -1, -1));

        jLabelSexe.setText("Sexe");
        jPanel4.add(jLabelSexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 182, 62, -1));

        jLabelCP.setText("Codi Postal");
        jPanel4.add(jLabelCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 223, 80, -1));

        jTextFieldNom.setBackground(new java.awt.Color(255, 204, 153));
        jPanel4.add(jTextFieldNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 27, 130, -1));

        jTextFieldDni.setBackground(new java.awt.Color(255, 204, 153));
        jTextFieldDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDniActionPerformed(evt);
            }
        });
        jPanel4.add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 65, 130, -1));

        jTextFieldNaixement.setBackground(new java.awt.Color(255, 204, 153));
        jPanel4.add(jTextFieldNaixement, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 103, 130, -1));

        jTextFieldAP.setBackground(new java.awt.Color(255, 204, 153));
        jTextFieldAP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAPActionPerformed(evt);
            }
        });
        jPanel4.add(jTextFieldAP, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 141, 130, -1));

        jTextFieldSexe.setBackground(new java.awt.Color(255, 204, 153));
        jPanel4.add(jTextFieldSexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 179, 130, -1));

        jTextFieldCP.setBackground(new java.awt.Color(255, 204, 153));
        jTextFieldCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCPActionPerformed(evt);
            }
        });
        jPanel4.add(jTextFieldCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 217, 130, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 250, 250));

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 100, -1));

        jLabelNoExisteix.setForeground(new java.awt.Color(255, 51, 51));
        jPanel2.add(jLabelNoExisteix, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 340, 20));

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAlumnos.setSelectionBackground(new java.awt.Color(255, 204, 103));
        jScrollPane1.setViewportView(jTableAlumnos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 670, 250));

        jButtonCancelaar.setText("Cancelar");
        jButtonCancelaar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelaarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonCancelaar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 100, -1));

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 100, -1));

        jButtonActualitzar.setText("Actualitzar");
        jButtonActualitzar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualitzarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonActualitzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 100, -1));
        jPanel2.add(jTextFieldBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(589, 260, 90, -1));

        jTabbedPane1.addTab("Alumnes", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Poblacions", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDniActionPerformed

    private void jTextFieldAPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAPActionPerformed

    private void jTextFieldCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCPActionPerformed

    public void mostrarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Dni");
        model.addColumn("Naixement");
        model.addColumn("Adreça Postal");
        model.addColumn("Sexe");
        model.addColumn("Codi Postal");
        
        jTableAlumnos.setModel(model);
        String datos[] = new String[6];
        String sql = "SELECT * FROM alumnes";
        Statement st;
        
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
            jTableAlumnos.setModel(model);
        } catch (Exception e) {
        
        } 
        
    
    }
    
    
    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        ResultSet comparaStmt;
        Statement stmt = null;
        Statement stmtInsert = null; 
        
        if(!jTextFieldNom.getText().equals("") && 
                !jTextFieldDni.getText().equals("") && 
                !jTextFieldNaixement.getText().equals("") && 
                !jTextFieldAP.getText().equals("") && 
                !jTextFieldSexe.getText().equals("") && 
                !jTextFieldCP.getText().equals("")) {
                
            try {
                
                stmt = cn.createStatement();
                comparaStmt = stmt.executeQuery("SELECT codipostal FROM poblacions WHERE codipostal = '" + jTextFieldCP.getText() + "'");

                if(comparaStmt.next()){
                    stmtInsert = cn.createStatement();
                    stmtInsert.execute("INSERT INTO alumnes VALUES ('" + jTextFieldNom.getText() + "','" + jTextFieldDni.getText() + "','" + jTextFieldNaixement.getText() + "','" 
                            + jTextFieldAP.getText() + "','" + jTextFieldSexe.getText() + "'," + jTextFieldCP.getText() + ")");
                    jLabelNoExisteix.setText("");
                } else {
                    jLabelNoExisteix.setText("Aquest codi postal no correspon a cap població");
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jLabelNoExisteix.setText("Falten camps per omplir");
        }
        vaciar();
        mostrarTabla();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonCancelaarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelaarActionPerformed
        // TODO add your handling code here:
        vaciar();
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButtonCancelaarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        int row = jTableAlumnos.getSelectedRow();
        
        if ( row >= 0){
            jTextFieldBusca.setText(jTableAlumnos.getValueAt(row, 1).toString());
            jTextFieldNom.setText(jTableAlumnos.getValueAt(row, 0).toString());
            jTextFieldDni.setText(jTableAlumnos.getValueAt(row, 1).toString());
            jTextFieldNaixement.setText(jTableAlumnos.getValueAt(row, 2).toString());
            jTextFieldAP.setText(jTableAlumnos.getValueAt(row, 3).toString());
            jTextFieldSexe.setText(jTableAlumnos.getValueAt(row, 4).toString());
            jTextFieldCP.setText(jTableAlumnos.getValueAt(row, 5).toString());
        } else {
            jLabelNoExisteix.setText("No has sel·leccionat cap fila");
        }
        
        jButtonGuardar.setEnabled(false);
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonActualitzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualitzarActionPerformed
        ResultSet comparaStmt;
        Statement stmt = null;
        try {
            // TODO add your handling code here:
            
            stmt = cn.createStatement();
            comparaStmt = stmt.executeQuery("SELECT codipostal FROM poblacions WHERE codipostal = '" + jTextFieldCP.getText() + "'");
            
            if (comparaStmt.next()) {
                PreparedStatement pps = cn.prepareStatement("UPDATE alumnes SET nom = '" + jTextFieldNom.getText() +
                    "' ,dni = '" + jTextFieldDni.getText() + "', datanaixament = '" + jTextFieldNaixement.getText()
                    + "', adrecapostal = '" + jTextFieldAP.getText() + "', sexe = '" + jTextFieldSexe.getText() +
                    "' ,codipostal  = '" + jTextFieldCP.getText() + "' WHERE dni = '" + jTextFieldBusca.getText() + "'");
                pps.executeUpdate();
                jLabelNoExisteix.setText("Dades actualitzades");
            } else {
                jLabelNoExisteix.setText("Aquest codi postal no correspon a cap població");
            }
            
            vaciar();
            mostrarTabla();
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButtonActualitzarActionPerformed

    public void vaciar(){
        jTextFieldNom.setText("");
        jTextFieldDni.setText("");
        jTextFieldNaixement.setText("");
        jTextFieldAP.setText("");
        jTextFieldSexe.setText("");
        jTextFieldCP.setText("");
        jTextFieldBusca.setText("");
    }
    
    
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new menu().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualitzar;
    private javax.swing.JButton jButtonCancelaar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabelAP;
    private javax.swing.JLabel jLabelCP;
    private javax.swing.JLabel jLabelDni;
    private javax.swing.JLabel jLabelNaixement;
    private javax.swing.JLabel jLabelNoExisteix;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelSexe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTextField jTextFieldAP;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldCP;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldNaixement;
    private javax.swing.JTextField jTextFieldNom;
    private javax.swing.JTextField jTextFieldSexe;
    // End of variables declaration//GEN-END:variables
}
