/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.menuClientes;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.cliente.WebServiceCliente;
import cl.alevicmar.services.egreso.WebServiceEgreso;
import cl.alevicmar.services.metodopago.WebServiceMetodopago;
import cl.alevicmar.services.ordenventa.WebServiceOrdendeventa;
import cl.alevicmar.services.producto.WebServiceProducto;
import cl.alevicmar.tools.HR;
import cl.alevicmar.tools.HRut;
import java.awt.Component;
import java.util.Locale;

/**
 *
 * @author cetecom
 */
public class ComprasCliente extends javax.swing.JFrame {

    /**
     * Creates new form ComprasCliente
     */
    WebServiceCliente srvCliente = null;
    WebServiceEgreso srvEgreso = null;
    WebServiceMetodopago srvMetodo = null;
    WebServiceOrdendeventa srvOrdenDeVenta = null;
    WebServiceProducto srvProducto = null;
    Component componente = null;
    
    public ComprasCliente(WebServiceCliente srvCliente, WebServiceEgreso srvEgreso, WebServiceMetodopago srvMetodo, WebServiceOrdendeventa srvOrdenDeVenta, WebServiceProducto srvProducto, Component componente)
    {
        initComponents();
        this.srvCliente = srvCliente;
        this.srvEgreso = srvEgreso;
        this.srvMetodo = srvMetodo;
        this.srvOrdenDeVenta = srvOrdenDeVenta;
        this.srvProducto = srvProducto;
        this.setLocationRelativeTo(componente);
        if(componente instanceof Principal)
        {
            this.setIconImage(((Principal)componente).getIconImage());
        }
    }
    
    public ComprasCliente() {
        initComponents();
        this.srvCliente = new WebServiceCliente();
        this.srvEgreso = new WebServiceEgreso();
        this.srvMetodo = new WebServiceMetodopago();
        this.srvOrdenDeVenta = new WebServiceOrdendeventa();
        this.srvProducto = new WebServiceProducto();
        this.setLocationRelativeTo(componente);
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
        txtRun = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCompraCliente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Feria Web Desktop Client  ::  Compras del Cliente");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Compras de Cliente"));

        txtRun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRunFocusLost(evt);
            }
        });
        txtRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRunActionPerformed(evt);
            }
        });
        txtRun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRunKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRunKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/find.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tableCompraCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Producto", "Cantidad", "Metodo de Pago", "SubTotal", "Total"
            }
        ));
        jScrollPane1.setViewportView(tableCompraCliente);

        jLabel1.setText("Run:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyTyped
        // TODO add your handling code here:
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRun, 12, evt);
    }//GEN-LAST:event_txtRunKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtRunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunFocusLost
        // TODO add your handling code here:
        if(!HR.contenido(txtRun).isEmpty())
        {
            HR.insertarTexto(txtRun, HRut.formatear(HR.contenido(txtRun)));
            if(!HRut.validar(HR.contenido(txtRun)))
            {
                HR.mostrarError("El Run ingresado no es válido");
                HR.seleccionarTodo(txtRun);
                HR.focus(txtRun);
            }
        }
    }//GEN-LAST:event_txtRunFocusLost

    private void txtRunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyPressed
        // TODO add your handling code here:
        /*if(HR.haPresionadoEnter(evt))
        {
            btnBuscarActionPerformed(evt);
                    
        }*/
    }//GEN-LAST:event_txtRunKeyPressed

    private void txtRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRunActionPerformed

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
            java.util.logging.Logger.getLogger(ComprasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComprasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComprasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComprasCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ComprasCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCompraCliente;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
