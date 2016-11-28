/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.finanzas;

import cl.alevicmar.services.metodopago.MetodoPago;
import cl.alevicmar.services.metodopago.WebServiceMetodopago;
import javax.swing.UIManager;

/**
 *
 * @author Janno
 */
public class Balances extends javax.swing.JFrame {

    WebServiceMetodopago srvMetodopago = null;
    
    public Balances() {
        initComponents();
        txtFechaDesde.setVisible(false);
        txtFechaHasta.setVisible(false);
        lblA.setVisible(false);
        lblDesde.setVisible(false);
        cmbMetodoPago.setVisible(false);
        
        this.srvMetodopago = new WebServiceMetodopago();
    }

    
    public void rellenarMetodosPago() {
        cmbMetodoPago.removeAllItems();
        for(Object o : srvMetodopago.getWebServiceMetodopagoSoap().retornaTodosLosMetodosPago().getAnyType()) {
            MetodoPago mp = ((MetodoPago)o);
            cmbMetodoPago.addItem(mp.getNombre());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        chkTodo = new javax.swing.JCheckBox();
        chkPorFecha = new javax.swing.JCheckBox();
        chkMetodoPago = new javax.swing.JCheckBox();
        txtFechaDesde = new com.toedter.calendar.JDateChooser();
        txtFechaHasta = new com.toedter.calendar.JDateChooser();
        lblDesde = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        cmbMetodoPago = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Balances Financieros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Balances"));

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaResultados);

        btnSalir.setText("Salir");

        chkTodo.setSelected(true);
        chkTodo.setText("Todo");
        chkTodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkTodoMouseClicked(evt);
            }
        });

        chkPorFecha.setText("Por Fecha");
        chkPorFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkPorFechaMouseClicked(evt);
            }
        });

        chkMetodoPago.setText("Por Método de Pago");
        chkMetodoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkMetodoPagoMouseClicked(evt);
            }
        });
        chkMetodoPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                chkMetodoPagoKeyPressed(evt);
            }
        });

        txtFechaDesde.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaDesdeFocusLost(evt);
            }
        });

        txtFechaHasta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaHastaFocusLost(evt);
            }
        });

        lblDesde.setText("desde");

        lblA.setText("a");

        cmbMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 459, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(chkPorFecha)
                                .addGap(39, 39, 39)
                                .addComponent(lblDesde))
                            .addComponent(chkMetodoPago)
                            .addComponent(chkTodo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lblA, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(chkTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkPorFecha)
                        .addComponent(lblDesde))
                    .addComponent(txtFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblA)
                        .addComponent(txtFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkMetodoPago)
                    .addComponent(cmbMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkPorFechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkPorFechaMouseClicked
        if(chkPorFecha.isSelected()) {
            chkMetodoPago.setSelected(false);
            txtFechaDesde.setVisible(true);
            txtFechaHasta.setVisible(true);
            lblA.setVisible(true);
            lblDesde.setVisible(true);
            txtFechaDesde.requestFocus();
            chkTodo.setSelected(false);
            cmbMetodoPago.setVisible(false);
        }else{
            txtFechaDesde.setVisible(false);
            txtFechaHasta.setVisible(false);
            lblA.setVisible(false);
            lblDesde.setVisible(false);
            chkTodo.setSelected(true);
            cmbMetodoPago.setVisible(false);
        }
    }//GEN-LAST:event_chkPorFechaMouseClicked

    private void chkMetodoPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_chkMetodoPagoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMetodoPagoKeyPressed

    private void chkMetodoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkMetodoPagoMouseClicked
       if(chkMetodoPago.isSelected()) {
            chkPorFecha.setSelected(false);
            chkPorFechaMouseClicked(null);
            rellenarMetodosPago();
            cmbMetodoPago.setVisible(true);
            chkTodo.setSelected(false);
        }else{
            chkPorFecha.setSelected(false);
            chkPorFechaMouseClicked(null);
            cmbMetodoPago.setVisible(false);
            chkTodo.setSelected(true);
        }
    }//GEN-LAST:event_chkMetodoPagoMouseClicked

    private void txtFechaDesdeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaDesdeFocusLost
        txtFechaHasta.setMinSelectableDate(txtFechaDesde.getDate());
    }//GEN-LAST:event_txtFechaDesdeFocusLost

    private void txtFechaHastaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaHastaFocusLost
        txtFechaDesde.setMaxSelectableDate(txtFechaHasta.getDate());
    }//GEN-LAST:event_txtFechaHastaFocusLost

    private void chkTodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkTodoMouseClicked
        if(chkTodo.isSelected()) {
            chkMetodoPago.setSelected(false);
            chkPorFecha.setSelected(false);
            txtFechaDesde.setVisible(false);
            txtFechaHasta.setVisible(false);
            lblA.setVisible(false);
            lblDesde.setVisible(false);
            cmbMetodoPago.setVisible(false);
        }
    }//GEN-LAST:event_chkTodoMouseClicked

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
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Balances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Balances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Balances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Balances.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Balances().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkMetodoPago;
    private javax.swing.JCheckBox chkPorFecha;
    private javax.swing.JCheckBox chkTodo;
    private javax.swing.JComboBox<String> cmbMetodoPago;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblDesde;
    private javax.swing.JTable tablaResultados;
    private com.toedter.calendar.JDateChooser txtFechaDesde;
    private com.toedter.calendar.JDateChooser txtFechaHasta;
    // End of variables declaration//GEN-END:variables
}
