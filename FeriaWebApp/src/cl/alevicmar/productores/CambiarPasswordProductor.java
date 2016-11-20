/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.services.productor.Productor;
import cl.alevicmar.services.productor.WebServiceProductor;
import cl.alevicmar.tools.HR;
import com.teamdev.jxbrowser.chromium.ca;
import java.awt.Component;


public class CambiarPasswordProductor extends javax.swing.JFrame {

    //definicion de atributos
    WebServiceProductor srvProductor           = null;
    Component componente                       = null;
    Productor productor                        = null;
    
    public CambiarPasswordProductor() {
        initComponents();
        this.srvProductor = new WebServiceProductor();
        this.setLocationRelativeTo(componente);
        desactivarCampos();
    }
    
    public CambiarPasswordProductor(WebServiceProductor srvProductor, Component componente) {
        initComponents();
        this.srvProductor = new WebServiceProductor();
        this.setLocationRelativeTo(componente);
        desactivarCampos();
    }
    
    public void desactivarCampos() {
        this.btnCambiar.setEnabled(false);
        this.txtContrasena1.setEnabled(false);
        this.txtPassword2.setEnabled(false);
        HR.insertarTexto(txtContrasena1, "");
        HR.insertarTexto(txtPassword2, "");
        HR.insertarTexto(lblNombres, "");
        HR.insertarTexto(lblApaterno, "");
        HR.insertarTexto(lblAmaterno, "");
    }
    
    public void activarCampos() {
        this.btnCambiar.setEnabled(true);
        this.txtContrasena1.setEnabled(true);
        this.txtPassword2.setEnabled(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtContrasena1 = new javax.swing.JPasswordField();
        txtPassword2 = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAmaterno = new javax.swing.JLabel();
        lblApaterno = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambiar Contraseña de Productor");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cambiar Contraseña"));

        jLabel1.setText("Contraseña");

        jLabel2.setText("Repita Contraseña");

        txtContrasena1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContrasena1KeyTyped(evt);
            }
        });

        txtPassword2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPassword2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContrasena1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(txtPassword2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtContrasena1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        btnCambiar.setText("Cambiar Contraseña");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Productor"));

        jLabel3.setText("RUN");

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

        jLabel4.setText("Nombres");

        jLabel5.setText("Apellido Paterno");

        jLabel6.setText("Apellido Materno");

        lblAmaterno.setText("Apellido");

        lblApaterno.setText("Apellido");

        lblNombres.setText("Nombres");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(txtRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lblAmaterno))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombres)
                                    .addComponent(lblApaterno))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblApaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblAmaterno))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(174, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiar)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnCambiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!HR.contenido(txtRun).isEmpty()) {
            productor = srvProductor.getWebServiceProductorSoap().buscaProductor(HR.contenido(txtRun));
            if(productor.getId() == 0) {
                HR.mostrarError("El productor con RUN "+HR.contenido(txtRun)+" no existe");
                HR.focus(txtRun);
                HR.seleccionarTodo(txtRun);
                desactivarCampos();
            }else{
                //completando informacion
                HR.insertarTexto(lblNombres, productor.getNombres());
                HR.insertarTexto(lblApaterno, productor.getApaterno());
                HR.insertarTexto(lblAmaterno, productor.getAmaterno());
                activarCampos();
                HR.focus(txtContrasena1);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtRunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRun, 12, evt);
    }//GEN-LAST:event_txtRunKeyTyped

    private void txtRunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunFocusLost
        if(HR.formatearYValidarRutCampo(txtRun)) {
            btnBuscarActionPerformed(null);
        }
    }//GEN-LAST:event_txtRunFocusLost

    private void btnBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnBuscarFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarFocusLost

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        try {
            if(HR.contenido(txtContrasena1).isEmpty()) {
                HR.mostrarError("Debe ingresar la contraseña nueva del productor");
                HR.focus(txtContrasena1);
            }else{
                if(HR.contenido(txtPassword2).isEmpty()) {
                    HR.mostrarError("Debe repetir la contraseña nueva del productor");
                    HR.focus(txtPassword2);
                }else{
                    if(HR.contenido(txtContrasena1).compareTo(HR.contenido(txtPassword2)) != 0) {
                        HR.mostrarError("Las contraseñas no coinciden");
                        HR.insertarTexto(txtContrasena1, "");
                        HR.insertarTexto(txtPassword2, "");
                        HR.focus(txtContrasena1);
                    }else{
                        productor.setContrasena(HR.contenido(txtContrasena1));
                        if(srvProductor.getWebServiceProductorSoap().actualizaProductor(productor)) {
                            HR.mostrarMensaje("Contraseña actualizada con éxito");
                            productor = null;
                            desactivarCampos();
                            HR.focus(txtRun);
                        }else{
                            HR.mostrarError("La contraseña no pudo ser cambiada. Intentelo mas tarde.");
                        }
                    }
                }
            }
        }catch(Exception e) {
            HR.mostrarErrorException(e);
        }
    }//GEN-LAST:event_btnCambiarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        System.gc();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtContrasena1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContrasena1KeyTyped
        if(HR.haPresionadoEnter(evt)) {
            btnCambiarActionPerformed(null);
        }
    }//GEN-LAST:event_txtContrasena1KeyTyped

    private void txtPassword2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassword2KeyTyped
       if(HR.haPresionadoEnter(evt)) {
            btnCambiarActionPerformed(null);
        }
    }//GEN-LAST:event_txtPassword2KeyTyped


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiarPasswordProductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAmaterno;
    private javax.swing.JLabel lblApaterno;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JPasswordField txtContrasena1;
    private javax.swing.JPasswordField txtPassword2;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
