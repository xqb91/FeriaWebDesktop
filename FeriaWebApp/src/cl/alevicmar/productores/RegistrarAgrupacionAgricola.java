/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.services.agrupacion.AgrupacionAgricultores;
import cl.alevicmar.services.agrupacion.WebServiceAgrupacion;
import cl.alevicmar.services.comuna.Comuna;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import java.util.List;
import javax.swing.UIManager;

/**
 *
 * @author Victor
 */
public class RegistrarAgrupacionAgricola extends javax.swing.JFrame {

    WebServiceAgrupacion    srvAgrupacion   = null;
    WebServiceComuna        srvComuna       = null;
    Component               componente      = null;
    
    AgrupacionAgricultores  agrupacion      = null;
    boolean                 bandera         = false;
    
    public RegistrarAgrupacionAgricola() {
        initComponents();
        this.srvAgrupacion = new WebServiceAgrupacion();
        this.srvComuna = new WebServiceComuna();
        this.setLocationRelativeTo(componente);
        
        rellenarComunas();
    }
    
    public RegistrarAgrupacionAgricola(WebServiceAgrupacion srvAgrupacion, WebServiceComuna srvComuna, Component componente) {
        initComponents();
        this.srvAgrupacion = srvAgrupacion;
        this.srvComuna = srvComuna;
        this.componente = componente;
        this.setLocationRelativeTo(componente);
        
        rellenarComunas();
    }
    
    public RegistrarAgrupacionAgricola(WebServiceAgrupacion srvAgrupacion, WebServiceComuna srvComuna, Component componente, AgrupacionAgricultores agrupacion) {
        initComponents();
        this.srvAgrupacion = srvAgrupacion;
        this.srvComuna = srvComuna;
        this.componente = componente;
        this.agrupacion = agrupacion;
        this.setLocationRelativeTo(componente);
        this.bandera = true;
        this.setTitle("Editar Agrupación Agrícola");
        
        //actualizando valores de campos
        HR.insertarTexto(txtRUT, agrupacion.getRut());
        HR.insertarTexto(txtRazonSocial, agrupacion.getRazonSocial());
        HR.insertarTexto(txtDireccion, agrupacion.getDireccion());
        HR.insertarTexto(txtTelefono, agrupacion.getTelefono());
        
        Comuna com = srvComuna.getWebServiceComunaSoap().buscaComuna(agrupacion.getComuna());
        rellenarComunas(com.getNombre());
    }
    
    public void rellenarComunas() {
        cmbComuna.removeAllItems();
        List<Object> listado = srvComuna.getWebServiceComunaSoap().retornaTodasLasComunas().getAnyType();
        HR.insertarTexto(cmbComuna, "Seleccione...");
        for(Object o : listado) {
            HR.insertarTexto(cmbComuna, ((Comuna)o).getNombre());
        }
    }
    
    public void rellenarComunas(String valorEspecial) {
        cmbComuna.removeAllItems();
        List<Object> listado = srvComuna.getWebServiceComunaSoap().retornaTodasLasComunas().getAnyType();
        HR.insertarTexto(cmbComuna, valorEspecial);
        for(Object o : listado) {
            HR.insertarTexto(cmbComuna, ((Comuna)o).getNombre());
        }
    }
    
    public void vaciarCampos() {
        HR.insertarTexto(txtRUT, "");
        HR.insertarTexto(txtRazonSocial, "");
        HR.insertarTexto(txtDireccion, "");
        HR.insertarTexto(txtTelefono, "");
        this.rellenarComunas();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRUT = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbComuna = new javax.swing.JComboBox<String>();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Agrupación Agrícola");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de la Agrupación"));

        jLabel1.setText("RUT");

        jLabel2.setText("Razón Social");

        txtRUT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRUTFocusLost(evt);
            }
        });
        txtRUT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRUTKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRUTKeyTyped(evt);
            }
        });

        txtRazonSocial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonSocialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(txtRUT, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtRazonSocial)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRUT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dirección de Agrupación"));

        jLabel3.setText("Dirección");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel4.setText("Teléfono");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel5.setText("Comuna");

        cmbComuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbComunaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbComuna, 0, 202, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_add.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRUTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUTKeyTyped
        HR.largoMaximo(txtRUT, 12, evt);
        HR.ingresaCaracteresRut(evt);
    }//GEN-LAST:event_txtRUTKeyTyped

    private void txtRUTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUTFocusLost
        if(HR.formatearYValidarRutCampo(txtRUT)) {
            HR.focus(txtRazonSocial);
        }
    }//GEN-LAST:event_txtRUTFocusLost

    private void txtRazonSocialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyTyped
        HR.largoMaximo(txtRazonSocial, 255, evt);
    }//GEN-LAST:event_txtRazonSocialKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        HR.largoMaximo(txtDireccion, 255, evt);
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        HR.largoMaximo(txtTelefono, 12, evt);
        HR.ingresaSoloNumeros(evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            if(HR.contenido(txtRUT).isEmpty()) {
                HR.mostrarError("El campo de Rol Único Tributario no ha sido completado");
                HR.focus(txtRUT);
            }else{
                if(HR.contenido(txtRazonSocial).isEmpty()) {
                    HR.mostrarError("El campo de Razón Social no ha sido completado");
                    HR.focus(txtRazonSocial);
                }else{
                    if(HR.contenido(txtDireccion).isEmpty()) {
                        HR.mostrarError("El campo de dirección no ha sido completado");
                        HR.focus(txtDireccion);
                    }else{
                        if(HR.contenido(txtTelefono).isEmpty()) {
                            HR.mostrarError("El campo de teléfono no ha sido completado");
                            HR.focus(txtTelefono);
                        }else{
                            if(HR.contenido(cmbComuna).compareToIgnoreCase("Seleccione...") == 0) {
                                HR.mostrarError("Debe seleccionar una comuna para continuar");
                                HR.focus(cmbComuna);
                            }else{
                                //verificar si el registro ya existe
                                if(srvAgrupacion.getWebServiceAgrupacionSoap().buscaAgrupacionPorRut(HR.contenido(txtRUT).toLowerCase()).getId() != 0) {
                                    HR.mostrarError("Ya se encuentra registrada una agrupación bajo este Rol Único Tributario");
                                    HR.focus(txtRUT);
                                    txtRUT.selectAll();
                                }else{
                                    //se recuperan los campos
                                    String rut          = HR.contenido(txtRUT);
                                    String razonSocial  = HR.contenido(txtRazonSocial);
                                    String direccion    = HR.contenido(txtDireccion);
                                    String telefono     = HR.contenido(txtTelefono);
                                    String comuna       = HR.contenido(cmbComuna);

                                    //creando un objeto de tipo agrupación
                                    AgrupacionAgricultores ag = new AgrupacionAgricultores();
                                    ag.setRut(rut);
                                    ag.setRazonSocial(razonSocial);
                                    ag.setDireccion(direccion);
                                    ag.setTelefono(telefono);
                                    //buscando comuna previa insersión
                                    Comuna com = srvComuna.getWebServiceComunaSoap().buscaComunaPorNombre(comuna);
                                    if(com.getId() == 0) {
                                        HR.mostrarError("La comuna indicada por el usuario no ha podido ser encontrada. Contacte al equipo de ALEVICMAR para encontrar una solución al problema");
                                        btnCancelarActionPerformed(evt);
                                    }else{
                                        ag.setComuna(com.getId());
                                        
                                        if(bandera) {
                                            //enviando datos al webservice para actualizacion
                                            ag.setId(agrupacion.getId());
                                            if(srvAgrupacion.getWebServiceAgrupacionSoap().actualizaAgrupacion(agrupacion)) {
                                                HR.mostrarMensaje("Agrupación actualizada exitosamente");
                                                vaciarCampos();
                                            }else{
                                                HR.mostrarError("Se produjo un error que impidió actualizar la agrupación.");
                                            }
                                        }else{
                                            //enviando datos al webService para guardar
                                            if(srvAgrupacion.getWebServiceAgrupacionSoap().guardarAgrupacion(ag)) {
                                                HR.mostrarMensaje("Agrupación creada exitosamente");
                                                vaciarCampos();
                                            }else{
                                                HR.mostrarError("Se produjo un error que impidió guardar la agrupación.");
                                            }
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }catch(Exception e) {
            HR.mostrarErrorException(e);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtRUTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUTKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnRegistrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtRUTKeyPressed

    private void txtRazonSocialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonSocialKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnRegistrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtRazonSocialKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnRegistrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnRegistrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void cmbComunaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbComunaKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnRegistrarActionPerformed(null);
        }
    }//GEN-LAST:event_cmbComunaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        System.gc();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAgrupacionAgricola.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAgrupacionAgricola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbComuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtRUT;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
