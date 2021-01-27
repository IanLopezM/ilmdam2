/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5damasian;

import javax.swing.JOptionPane;

/**
 *
 * @author ianlo
 */
public class Damas_nova_partida extends javax.swing.JFrame {

    boolean jugaX = true;
    boolean jugaO = false;
    int filaOrigen = -1;
    int columnaOrigen = -1;
    int filaDesti = -1;
    int columnaDesti = -1;

    
    
    /**
     * Creates new form Damas_nova_partida
     */
    public Damas_nova_partida() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSortir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablero = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSortir.setText("Sortir");
        btnSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortirActionPerformed(evt);
            }
        });

        tablero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"O", null, "O", null, "O", null, "O", null},
                {null, "O", null, "O", null, "O", null, "O"},
                {"O", null, "O", null, "O", null, "O", null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, "X", null, "X", null, "X", null, "X"},
                {"X", null, "X", "", "X", "", "X", null},
                {null, "X", null, "X", null, "X", null, "X"}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tablero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablero);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnSortir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btnSortir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSortirActionPerformed

    private void tableroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableroMouseClicked
        int fila = obtenirFilaClicada();
        int columna = obtenirColumnaClicada();
        
        if(noHiHaOrigen()) {
            
            if (jugaX && EsX(fila, columna)) {
                ActualitzaNouOrigen(fila, columna);
            } else if (jugaO && EsO(fila, columna)) { 
                ActualitzaNouOrigen(fila, columna);
            } else {
                mostraError();
            }
        } else {
            if (movimentValid(fila, columna)) {
                if (esBuit(fila, columna) || OcupatContrari(fila, columna)) {
                    mou(fila, columna);
                }  else if (OcupatPropi(fila, columna)) {
                    ActualitzaNouOrigen(fila, columna);
                } 
            } else {
                    mostraErrorMoviment();
            }
        }
    }//GEN-LAST:event_tableroMouseClicked
                                   

    public int obtenirFilaClicada(){
    
        return tablero.getSelectedRow();
    }
    
    public int obtenirColumnaClicada(){
    
        return tablero.getSelectedColumn();
    }
    
    public boolean noHiHaOrigen(){
        boolean noOrigen = false;
        if(filaOrigen == -1 || columnaOrigen == -1){
            noOrigen = true;
        }
    
        return noOrigen;
    }
    
    public boolean EsX(int fila, int columna) {
        boolean isx = false;
        if(tablero.getValueAt(fila, columna) == "X") {
            isx = true;
        }
        
        return isx;
    }
    
    public boolean EsO(int fila, int columna) {
        boolean iso = false;
        if(tablero.getValueAt(fila, columna) == "O") {
            iso = true;
        }
        
        return iso;
    }
    
    public void ActualitzaNouOrigen(int fila, int columna){
        filaOrigen = fila;
        columnaOrigen = columna;
    
    }
    
    public void mostraError(){
        JOptionPane.showMessageDialog(null, "Error", "Damas", 
                JOptionPane.ERROR_MESSAGE);
    }
    
    public boolean movimentValid(int fila, int columna) {
        boolean esMovimentValid = false;
        filaDesti = fila;
        columnaDesti = columna;
        int columnaCalcul = columnaDesti - columnaOrigen;
        int filaCalcul =  filaDesti - filaOrigen;
        
        if(jugaX && (columnaCalcul == 1) && 
                ((filaCalcul == 1) || (filaCalcul ==  -1))){
            esMovimentValid = true;
        } else if (jugaO && (columnaCalcul == -1) && 
                ((filaCalcul == 1) || (filaCalcul ==  -1))) {
            esMovimentValid = true;
        }
        
        return esMovimentValid;
    }
    
    public boolean esBuit(int fila, int columna) {
        boolean isBuit = false;
        if(tablero.getValueAt(fila, columna) == null){
            isBuit = true;
        }
        
        return isBuit;
    }
    
    public boolean OcupatContrari(int fila, int columna) {
        boolean isOcupatContrari = false;
        if((jugaX == true && EsO(fila, columna) == true)
                || (jugaO == true && EsX(fila, columna) == true)){
            isOcupatContrari = true;
        }
    
        return isOcupatContrari;
    }
    
    public void mou(int fila, int columna) {
    
        tablero.setValueAt("", filaOrigen, columnaOrigen);
        if (jugaX) {
            tablero.setValueAt("X", fila, columna);
        } else {
            tablero.setValueAt("O", fila, columna);
        }
        
    }
    
    public boolean OcupatPropi(int fila, int columna) {
        boolean isOcupatPropi = false;
        if((jugaX == true && EsX(fila, columna) == true)
                || (jugaO == true && EsO(fila, columna) == true)){
            isOcupatPropi  = true;
        }
        
        return isOcupatPropi;
    }
    
    public void mostraErrorMoviment() {
        JOptionPane.showMessageDialog(null, "Moviment erroni", "Damas", 
                JOptionPane.ERROR_MESSAGE);
    
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
            java.util.logging.Logger.getLogger(Damas_nova_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Damas_nova_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Damas_nova_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Damas_nova_partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Damas_nova_partida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSortir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablero;
    // End of variables declaration//GEN-END:variables
}
