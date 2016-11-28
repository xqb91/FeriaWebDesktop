/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productos;

import cl.alevicmar.services.categoria.Categoria;
import cl.alevicmar.services.categoria.WebServiceCategoria;
import cl.alevicmar.services.familia.Familia;
import cl.alevicmar.services.familia.WebServiceFamilia;
import cl.alevicmar.services.producto.Producto;
import cl.alevicmar.services.producto.WebServiceProducto;
import cl.alevicmar.tools.HR;
import java.awt.Component;

/**
 *
 * @author Janno
 */
public class DetalleProducto extends javax.swing.JFrame {

    WebServiceProducto      srvProducto     = null;
    WebServiceCategoria     srvCategoria    = null;
    WebServiceFamilia       srvFamilia      = null;
    Producto                pro             = null;
    Component               componente      = null;
    AdministrarProductos    ap              = null;
    
    public DetalleProducto() {
        initComponents();
        this.setLocationRelativeTo(componente);
        this.srvProducto = new WebServiceProducto();
        this.srvFamilia = new WebServiceFamilia();
        this.srvCategoria = new WebServiceCategoria();
    }
    
    public DetalleProducto(WebServiceProducto srvProducto,WebServiceCategoria srvCategoria, WebServiceFamilia srvFamilia, Component componente, Producto pro, AdministrarProductos ap) {
        initComponents();
        this.setLocationRelativeTo(componente);
        this.srvProducto = srvProducto;
        this.srvFamilia = srvFamilia;
        this.srvCategoria = srvCategoria;
        this.pro = pro;
        HR.insertarTexto(lblResultadoNombre, pro.getNombre());
        Familia fam = srvFamilia.getWebServiceFamiliaSoap().buscaFamilia(pro.getFamilia());
        HR.insertarTexto(lblResultadoFamilia, fam.getNombre());
        Categoria cat = srvCategoria.getWebServiceCategoriaSoap().buscaCategoria(pro.getCategoria());
        HR.insertarTexto(lblResultadoCategoria, cat.getNombre());
        HR.insertarTexto(lblResultadoPrecio, "$"+pro.getPrecio()+" ");
        HR.insertarTexto(lblResultadoDescripccion, "<html><body><div width='200px' align='justify'>"+pro.getDescripcion()+"</div></body></html>");
        this.ap = ap;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblResultadoNombre = new javax.swing.JLabel();
        lblResultadoFamilia = new javax.swing.JLabel();
        lblResultadoCategoria = new javax.swing.JLabel();
        lblResultadoPrecio = new javax.swing.JLabel();
        lblResultadoDescripccion = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Feria Web Desktop  ::  Detalle de Producto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Producto"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Familia:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Categoría:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Precio por Kg:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Descripción:");

        lblResultadoNombre.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblResultadoNombre.setText("...");

        lblResultadoFamilia.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblResultadoFamilia.setText("...");

        lblResultadoCategoria.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblResultadoCategoria.setText("...");

        lblResultadoPrecio.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblResultadoPrecio.setText("...");

        lblResultadoDescripccion.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        lblResultadoDescripccion.setText("...");

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/delete.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/pencil.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultadoDescripccion)
                            .addComponent(lblResultadoPrecio)
                            .addComponent(lblResultadoCategoria)
                            .addComponent(lblResultadoFamilia)
                            .addComponent(lblResultadoNombre))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 195, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblResultadoNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblResultadoFamilia))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblResultadoCategoria))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblResultadoPrecio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblResultadoDescripccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar))
                .addContainerGap())
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        new RegistrarProducto(srvProducto, srvFamilia, srvCategoria, componente, pro,ap).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if(pro != null) {
            int opcion = HR.preguntar("¿Esta seguro de eliminar este producto? La operación es irreversible!");
            if(opcion == 0) {
                if(srvProducto.getWebServiceProductoSoap().eliminaProducto(pro.getId())) {
                    HR.mostrarMensaje("Producto eliminado exitosamente.");
                    if(ap != null) {
                        if(ap instanceof AdministrarProductos) {
                            ((AdministrarProductos)ap).rellenarTabla();
                            this.dispose();
                        }
                    }
                }else{
                    HR.mostrarError("No se pudo eliminar el producto");
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblResultadoCategoria;
    private javax.swing.JLabel lblResultadoDescripccion;
    private javax.swing.JLabel lblResultadoFamilia;
    private javax.swing.JLabel lblResultadoNombre;
    private javax.swing.JLabel lblResultadoPrecio;
    // End of variables declaration//GEN-END:variables
}
