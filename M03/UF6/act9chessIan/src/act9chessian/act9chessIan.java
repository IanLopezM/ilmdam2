/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package act9chessian;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alumne
 */
public class act9chessIan extends javax.swing.JFrame {
    
    int fila = -1, col = -1, filadest = -1, coldest = -1, checked = 0;
    Fitxa fitxa, fitxadest;
    boolean movimentValid;
    
    /**
     * Creates new form act9chessIan
     */
    public act9chessIan() {
        initComponents();
        omplirTaula();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonReiniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", ""},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {"", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", ""}
            },
            new String [] {
                "A", "B", "C", "D", "E", "F", "G", "H"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButtonReiniciar.setText("Reiniciar");
        jButtonReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReiniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonReiniciar)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonReiniciar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReiniciarActionPerformed
        omplirTaula();
    }//GEN-LAST:event_jButtonReiniciarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if ((fila == -1 && col == -1) || checked == 0) {
            fila = filaTabla();
            col = colTabla();
            checked = 1;
        } else {
            filadest = filaTabla();
            coldest = colTabla();
            checked = 0;
        }
        System.out.println(fila);
        System.out.println(col);
        System.out.println(filadest);
        System.out.println(coldest + "\n");
        if (checked == 0) {
            fitxa = new Fitxa(fila, col, jTable1, true);
            fitxadest = new Fitxa(filadest, coldest, jTable1, true);
            
            
            if (fitxa.movimientoValido(fitxadest, jTable1)){
                System.out.println("se esta moviendo");
                jTable1.setValueAt(jTable1.getValueAt(fila, col), filadest, coldest);
                jTable1.setValueAt('·', fila, col);
            } 
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(act9chessIan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(act9chessIan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(act9chessIan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(act9chessIan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new act9chessIan().setVisible(true);
            }
        });
    }
    
    public void omplirTaula() {
        DefaultTableModel model = new DefaultTableModel();
        char c = 65;
        Object fichasBlancas[] = {'T', 'C', 'A', 'Q', 'K', 'A', 'C', 'T'};
        Object peonesBlancos[] = {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'};
        Object filaVacia[] = {'·', '·', '·', '·', '·', '·', '·', '·'}; //x4
        Object fichasNegras[] = {'t', 'c', 'a', 'q', 'k', 'a', 'c', 't'};
        Object peonesNegros[] = {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'};
        
        for (int i = 0; i < 8; i++) {
            model.addColumn("     " + c);
            c++;
        }
        model.addRow(fichasNegras);
        model.addRow(peonesNegros);
        model.addRow(filaVacia);
        model.addRow(filaVacia);
        model.addRow(filaVacia);
        model.addRow(filaVacia);
        model.addRow(peonesBlancos);
        model.addRow(fichasBlancas);
        
        
        
        jTable1.setModel(model);
        jTable1.setDefaultEditor(Object.class, null);
        fila = -1;
        col = -1;
        filadest = -1;
        coldest = -1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReiniciar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private int filaTabla() {
        return jTable1.getSelectedRow();
    }

    private int colTabla() {
        return jTable1.getSelectedColumn();
    }
}
