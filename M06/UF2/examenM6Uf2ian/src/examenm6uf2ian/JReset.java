/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenm6uf2ian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumne
 */
public class JReset extends javax.swing.JFrame {
    Connection cn;
    ExamenM6Uf2ian connexio = new ExamenM6Uf2ian();
    String nombre;
    /**
     * Creates new form JReset
     */
    public JReset() throws ClassNotFoundException, SQLException {
        this.cn = connexio.conexion();
        initComponents();
        jTextFieldPassword.setEnabled(false);
        jTextFieldRespuesta.setEnabled(false);
        btnCanviaPassword.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsuari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPassword = new javax.swing.JTextField();
        jLabelPregunta = new javax.swing.JLabel();
        jTextFieldRespuesta = new javax.swing.JTextField();
        btnUsuariaCanviar = new javax.swing.JButton();
        btnCanviaPassword = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuari");

        jLabel2.setText("Nova Password");

        jLabelPregunta.setText("Pregunta:");

        btnUsuariaCanviar.setText("Usuari a canviar");
        btnUsuariaCanviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariaCanviarActionPerformed(evt);
            }
        });

        btnCanviaPassword.setText("Canvia Password");
        btnCanviaPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanviaPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(91, 91, 91)
                                .addComponent(jLabelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPassword))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUsuariaCanviar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(btnCanviaPassword)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuariaCanviar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelPregunta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCanviaPassword)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariaCanviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariaCanviarActionPerformed
        ResultSet comparaStmt;
        Statement stmt = null;
        Statement stmtInsert = null; 
        
        if(!jTextFieldUsuari.getText().equals("")) {
            try {
                stmt = cn.createStatement();
                comparaStmt = stmt.executeQuery("SELECT usuari FROM usuaris WHERE usuari = '" + jTextFieldUsuari.getText() + "'");

                if(comparaStmt.next()){
                    jTextFieldPassword.setEnabled(true);
                    jTextFieldRespuesta.setEnabled(true);
                    btnCanviaPassword.setEnabled(true);
                    
                    carregaPregunta(jTextFieldUsuari.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "No existeix aquest usuari");
                }
                
            } catch (SQLException ex) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falten camps per omplir");
        }
        limpiar();
    }//GEN-LAST:event_btnUsuariaCanviarActionPerformed

    private void btnCanviaPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanviaPasswordActionPerformed
        ResultSet comparaStmt;
        Statement stmt = null;
        Statement stmtInsert = null; 
        
        if(!jTextFieldPassword.getText().equals("") &&
                !jTextFieldRespuesta.getText().equals("")) {
            try {
                stmt = cn.createStatement();
                comparaStmt = stmt.executeQuery("SELECT resposta FROM usuaris WHERE resposta = '" + jTextFieldRespuesta.getText() + "'");
                
                if(comparaStmt.next()){
                    PreparedStatement pps = cn.prepareStatement("UPDATE usuaris SET passwd = '"+ jTextFieldPassword.getText()+ "' WHERE usuari = '" + nombre + "'");
                pps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Dades actualitzades");
                } else {
                    JOptionPane.showMessageDialog(null, "No es correcte");
                }
                
            }catch (SQLException ex) {
            }
        }
        limpiar();
        volverMenu();
    }//GEN-LAST:event_btnCanviaPasswordActionPerformed

    public void limpiar() {
        jTextFieldUsuari.setText("");
        jTextFieldPassword.setText("");
        jTextFieldRespuesta.setText("");
    }
    
    public void volverMenu(){
        JMenu menu = new JMenu();
        menu.setVisible(true);
        dispose();
    }
    
    public void carregaPregunta(String usuari){
        nombre = usuari;
        ResultSet comparaStmt;
        Statement stmt = null;
        Statement stmtInsert = null;
        String pregunta = "hola";
        
        try {
                stmt = cn.createStatement();
                comparaStmt = stmt.executeQuery("SELECT pregunta FROM usuaris WHERE usuari = '" + usuari + "'");
                while (comparaStmt.next()) {
                    pregunta = comparaStmt.getString(1);
                }
                jLabelPregunta.setText(pregunta);
        } catch (SQLException ex) {
        }
    
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
            java.util.logging.Logger.getLogger(JReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JReset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new JReset().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JReset.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JReset.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanviaPassword;
    private javax.swing.JButton btnUsuariaCanviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPregunta;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldRespuesta;
    private javax.swing.JTextField jTextFieldUsuari;
    // End of variables declaration//GEN-END:variables
}
