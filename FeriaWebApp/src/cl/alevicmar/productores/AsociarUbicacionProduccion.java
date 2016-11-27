/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.productor.Productor;
import cl.alevicmar.services.productor.WebServiceProductor;
import cl.alevicmar.services.ubicacionproductor.UbicacionProductor;
import cl.alevicmar.services.ubicacionproductor.WebServiceUbicacionProductor;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Manuel Araya
 */
public class AsociarUbicacionProduccion extends javax.swing.JFrame {

    WebServiceProductor srvProductor            = null;
    WebServiceUbicacionProductor srvUbicacion   = null;
    WebServiceComuna srvComuna                  = null;
    
    Component componente                        = null;
    Productor productor                         = null;
    UbicacionProductor ubicacion                = null;
    
    public AsociarUbicacionProduccion() {
        initComponents();
        this.srvProductor = new WebServiceProductor();
        this.srvUbicacion = new WebServiceUbicacionProductor();
        this.srvComuna    = new WebServiceComuna();
        this.setLocationRelativeTo(componente);
        
        this.productor = srvProductor.getWebServiceProductorSoap().posicionProductor(1);
        this.ubicacion = srvUbicacion.getWebServiceUbicacionProductorSoap().posicionStock(1);
        this.inicializar();
    }
    
    public AsociarUbicacionProduccion(WebServiceProductor svrProductor, WebServiceUbicacionProductor srvUbicacion, WebServiceComuna srvComuna, Component componente) {
        initComponents();
        this.srvProductor = srvProductor;
        this.srvUbicacion = srvUbicacion;
        this.componente = componente;
        this.srvComuna = srvComuna;
        this.inicializar();
        if(componente instanceof Principal) {
            this.setIconImage(((Principal)componente).getIconImage());
        }
    }

    public void inicializar() {
        HR.insertarTexto(lblNombres, "");
        HR.insertarTexto(lblApaterno, "");
        HR.insertarTexto(lblAmaterno, "");
        tablaResultados.setEnabled(false);
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Nombre", "Dirección", "Comuna" });   
            tablaResultados.setModel(modelo);
            tablaResultados.getColumnModel().getColumn(0).setResizable(false);
            tablaResultados.getColumnModel().getColumn(0).setMaxWidth(75);
            tablaResultados.getColumnModel().getColumn(0).setMinWidth(75);
            tablaResultados.getColumnModel().getColumn(0).setWidth(85);
            tablaResultados.getColumnModel().getColumn(1).setResizable(false);
            tablaResultados.getColumnModel().getColumn(1).setMaxWidth(185);
            tablaResultados.getColumnModel().getColumn(1).setMinWidth(185);
            tablaResultados.getColumnModel().getColumn(1).setWidth(185);
            tablaResultados.getColumnModel().getColumn(2).setResizable(false);
            tablaResultados.getColumnModel().getColumn(2).setWidth(35);
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar al resetear los valores de la tabla: "+e.getMessage());
        }
        HR.desactivar(btnRegistrarNuevaUbicacion);
        HR.desactivar(btnSeleccionar);
        HR.desactivar(btnBuscarOtro);
        HR.desactivar(btnGuardar);
    }
    
    public void desbloquar() {
        tablaResultados.setEnabled(true);
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { " ", "Nombre", "Dirección", "Comuna" });   
            for(Object o : srvUbicacion.getWebServiceUbicacionProductorSoap().retornaTodasUbicacionProductores().getAnyType()) {
                ubicacion = ((UbicacionProductor)o);
                Object[] obj = new Object[4];
                obj[0] = ubicacion.getId();
                obj[1] = ubicacion.getNombre();
                obj[2] = ubicacion.getDireccion();
                obj[3] = ubicacion.getComuna();
                modelo.addRow(obj);
            }
            this.ubicacion = null;
            tablaResultados.setModel(modelo);
            tablaResultados.getColumnModel().getColumn(0).setResizable(false);
            tablaResultados.getColumnModel().getColumn(0).setMaxWidth(10);
            tablaResultados.getColumnModel().getColumn(0).setMinWidth(10);
            tablaResultados.getColumnModel().getColumn(0).setWidth(15);
            tablaResultados.getColumnModel().getColumn(1).setMaxWidth(185);
            tablaResultados.getColumnModel().getColumn(1).setMinWidth(185);
            tablaResultados.getColumnModel().getColumn(1).setWidth(185);
            tablaResultados.getColumnModel().getColumn(2).setMaxWidth(75);
            tablaResultados.getColumnModel().getColumn(2).setMinWidth(75);
            tablaResultados.getColumnModel().getColumn(2).setWidth(75);
            tablaResultados.getColumnModel().getColumn(3).setWidth(35);
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar al resetear los valores de la tabla: "+e.getMessage());
        }
        HR.activar(btnRegistrarNuevaUbicacion);
    }
    
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApaterno = new javax.swing.JLabel();
        lblAmaterno = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnBuscarOtro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        btnRegistrarNuevaUbicacion = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asociar Ubicación de Productor");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Productor"));

        jLabel1.setText("RUN");

        txtRun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRunFocusLost(evt);
            }
        });
        txtRun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRunKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/find.png"))); // NOI18N
        btnBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnBuscarFocusLost(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombres");

        jLabel3.setText("Apellido Paterno");

        jLabel4.setText("Apellido Materno");

        lblNombres.setText("Nombres");

        lblApaterno.setText("Apaterno");

        lblAmaterno.setText("Amaterno");

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_next.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnBuscarOtro.setText("Buscar Otro");
        btnBuscarOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOtroActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAmaterno)
                            .addComponent(lblApaterno)
                            .addComponent(lblNombres))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscarOtro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lblNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblApaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblAmaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnBuscarOtro))
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicaciones Disponibles"));

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaResultados);

        btnRegistrarNuevaUbicacion.setText("Registrar una nueva");
        btnRegistrarNuevaUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarNuevaUbicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarNuevaUbicacion)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrarNuevaUbicacion))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRun, 12, evt);
    }//GEN-LAST:event_txtRunKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!HR.contenido(txtRun).isEmpty()) {
            if(HR.formatearYValidarRutCampo(txtRun)) {
                this.productor = srvProductor.getWebServiceProductorSoap().buscaProductor(HR.contenido(txtRun));
                if(productor.getId() == 0) {
                    HR.mostrarError("El productor con el RUN especificado no pudo ser encontrado en la base de datos");
                    HR.insertarTexto(txtRun, "");
                    HR.focus(txtRun);
                }else{
                    HR.insertarTexto(lblNombres, productor.getNombres());
                    HR.insertarTexto(lblApaterno, productor.getApaterno());
                    HR.insertarTexto(lblAmaterno, productor.getAmaterno());
                    HR.activar(btnSeleccionar);
                    HR.activar(btnBuscarOtro);
                    HR.focus(btnSeleccionar);
                }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnBuscarFocusLost
        
    }//GEN-LAST:event_btnBuscarFocusLost

    private void txtRunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunFocusLost
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_txtRunFocusLost

    private void btnBuscarOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOtroActionPerformed
        inicializar();
        this.productor = null;
        HR.insertarTexto(txtRun, "");
        HR.focus(txtRun);
    }//GEN-LAST:event_btnBuscarOtroActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        desbloquar();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnRegistrarNuevaUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarNuevaUbicacionActionPerformed
        new RegistrarUbicacion(srvProductor, srvUbicacion, srvComuna, componente, productor).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarNuevaUbicacionActionPerformed

    private void tablaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadosMouseClicked
        try {
            String identificador = HR.retornaValorTabla(0, tablaResultados);
            identificador = identificador.trim();
            this.ubicacion = srvUbicacion.getWebServiceUbicacionProductorSoap().buscaUbicacionProductor(Integer.parseInt(identificador));
            if(ubicacion.getId() == 0) {
                HR.mostrarError("No pudo encontrarse la ubicación de productores con ID "+identificador);
                this.ubicacion = null;
                inicializar();
            }else{
                HR.activar(btnGuardar);
                HR.focus(btnGuardar);
            }
        }catch(Exception e) {
            HR.mostrarErrorException(e);
        }
    }//GEN-LAST:event_tablaResultadosMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.gc();
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(productor == null) {
            HR.mostrarError("No hay un productor seleccionado para la asignación");
        }else{
            if(ubicacion == null) {
                HR.mostrarError("No hay una ubicacion seleccionada para la asignación");
            }else{
                ubicacion.setProductor(productor.getId());
                if(srvUbicacion.getWebServiceUbicacionProductorSoap().actualizaUbicacionProductor(ubicacion)) {
                    HR.mostrarMensaje("Ubicación del productor actualizada");
                    btnCancelarActionPerformed(evt);
                }else{
                    HR.mostrarError("No se pudo actualizar la ubicación del productor");
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(AsociarUbicacionProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsociarUbicacionProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsociarUbicacionProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsociarUbicacionProduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsociarUbicacionProduccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarOtro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegistrarNuevaUbicacion;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAmaterno;
    private javax.swing.JLabel lblApaterno;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
