/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.agrupacion.AgrupacionAgricultores;
import cl.alevicmar.services.agrupacion.WebServiceAgrupacion;
import cl.alevicmar.services.comuna.Comuna;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import javax.swing.UIManager;

/**
 *
 * @author Victor
 */
public class VerAgrupacionAgricola extends javax.swing.JFrame {

    WebServiceAgrupacion srvAgrupacion  = null;
    WebServiceComuna srvComuna          = null;
    Component            componente     = null;
    AgrupacionAgricultores agrupacion   = null;
    
    public VerAgrupacionAgricola() {
        initComponents();
        this.srvAgrupacion = new WebServiceAgrupacion();
        this.srvAgrupacion = new WebServiceAgrupacion();
        this.srvComuna = new WebServiceComuna();
        for(Object o : srvAgrupacion.getWebServiceAgrupacionSoap().retornaTodasLasAgrupaciones().getAnyType()) {
            this.agrupacion = ((AgrupacionAgricultores)o);
            break;
        }
        
        HR.insertarTexto(lblRut,         agrupacion.getRut());
        HR.insertarTexto(lblRazonSocial, agrupacion.getRazonSocial());
        HR.insertarTexto(lblDireccion,   agrupacion.getDireccion());
        Comuna com = srvComuna.getWebServiceComunaSoap().buscaComuna(agrupacion.getComuna());
        HR.insertarTexto(lblComuna,      com.getNombre());
        HR.insertarTexto(lblTelefono,    agrupacion.getTelefono());
        this.setLocationRelativeTo(componente);
    }
    
    public VerAgrupacionAgricola(WebServiceAgrupacion srvAgrupacion, Component componente, AgrupacionAgricultores agrupacion, WebServiceComuna srvComuna) {
        initComponents();
        this.srvAgrupacion = srvAgrupacion;
        this.componente = componente;
        this.agrupacion = agrupacion;
        this.srvComuna = srvComuna;
        
        this.setLocationRelativeTo(componente);
        if(componente instanceof Principal) {
            this.setIconImage(((Principal)componente).getIconImage());
        }
        
        HR.insertarTexto(lblRut,         agrupacion.getRut());
        HR.insertarTexto(lblRazonSocial, agrupacion.getRazonSocial());
        HR.insertarTexto(lblDireccion,   agrupacion.getDireccion());
        Comuna com = srvComuna.getWebServiceComunaSoap().buscaComuna(agrupacion.getId());
        HR.insertarTexto(lblComuna,      com.getNombre());
        HR.insertarTexto(lblTelefono,    agrupacion.getTelefono());
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
        lblRut = new javax.swing.JLabel();
        lblRazonSocial = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblComuna = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de la Agrupación"));

        jLabel1.setText("RUT");

        jLabel2.setText("Razón Social");

        jLabel3.setText("Dirección");

        jLabel4.setText("Teléfono");

        jLabel5.setText("Comuna");

        lblRut.setText("00.000.000 - 0");

        lblRazonSocial.setText("Razón Social");

        lblDireccion.setText("Dirección");

        lblTelefono.setText("Teléfono");

        lblComuna.setText("Comuna");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblComuna)
                    .addComponent(lblDireccion)
                    .addComponent(lblRazonSocial)
                    .addComponent(lblRut)
                    .addComponent(lblTelefono))
                .addContainerGap(204, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblRut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblRazonSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblComuna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblTelefono))
                .addGap(0, 1, Short.MAX_VALUE))
        );

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnCerrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int opcion = HR.preguntar("¿Esta seguro que desea eliminar la agrupación "+agrupacion.getRazonSocial()+"?");
        if(opcion == 0) {
            if(srvAgrupacion.getWebServiceAgrupacionSoap().eliminaPais(agrupacion.getId())) {
                HR.mostrarMensaje("Agrupación Eliminada");
                btnCerrarActionPerformed(evt);
            }else{
                HR.mostrarError("Ocurrió un problema cuando se intentaba eliminar la agrupación. Intentelo más tarde.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        new RegistrarAgrupacionAgricola(srvAgrupacion, srvComuna, componente, agrupacion).setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
        System.gc();
    }//GEN-LAST:event_btnCerrarActionPerformed

    
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
            java.util.logging.Logger.getLogger(VerAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerAgrupacionAgricola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblComuna;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblRazonSocial;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
