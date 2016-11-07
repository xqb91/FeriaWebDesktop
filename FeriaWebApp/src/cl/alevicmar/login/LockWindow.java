/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.login;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.administrador.Administrador;
import cl.alevicmar.services.administrador.WebServiceAdministrador;
import cl.alevicmar.services.agrupacion.WebServiceAgrupacion;
import cl.alevicmar.services.categoria.WebServiceCategoria;
import cl.alevicmar.services.cliente.WebServiceCliente;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.egreso.WebServiceEgreso;
import cl.alevicmar.services.familia.WebServiceFamilia;
import cl.alevicmar.services.metodopago.WebServiceMetodopago;
import cl.alevicmar.services.ordenventa.WebServiceOrdendeventa;
import cl.alevicmar.services.pais.WebServicePais;
import cl.alevicmar.services.producto.WebServiceProducto;
import cl.alevicmar.services.productor.WebServiceProductor;
import cl.alevicmar.services.provincia.WebServiceProvincia;
import cl.alevicmar.services.region.WebServiceRegion;
import cl.alevicmar.services.stock.WebServiceStock;
import cl.alevicmar.services.ubicacionproductor.WebServiceUbicacionProductor;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.UIManager;
import maps.java.Geocoding;

/**
 *
 * @author cetecom
 */
public class LockWindow extends javax.swing.JFrame {

    //atributos de webservices
    WebServiceAdministrador         srvAdministrador        = null;
    WebServiceAgrupacion            srvAgrupacion           = null;
    WebServiceCategoria             srvCategoria            = null;
    WebServiceCliente               srvCliente              = null;
    WebServiceComuna                srvComuna               = null;
    WebServiceEgreso                srvEgreso               = null;
    WebServiceFamilia               srvFamilia              = null;
    WebServiceMetodopago            srvMetodoPago           = null;
    WebServiceOrdendeventa          srvOrdenVenta           = null;
    WebServicePais                  srvPais                 = null;
    WebServiceProducto              srvProducto             = null;
    WebServiceProductor             srvProductor            = null;
    WebServiceProvincia             srvProvincia            = null;
    WebServiceRegion                srvRegion               = null;
    WebServiceStock                 srvStock                = null;
    WebServiceUbicacionProductor    srvUbicacionProductor   = null;
    
    //servicio de mapas
    Geocoding                       mapa                    = null;
    
    //Usuario Logueado
    Administrador                   user                    = null;
    
    Component                       ventana                 = null;
    
    int                             contador                = 0;
    
    public LockWindow() {
        initComponents();
        //seteando el logotipo de la ventana de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cl/alevicmar/imagenes/icono.png"));
        setIconImage(icon);
        //seteando titulo de ventana
        this.setTitle("Terminal Bloqueado :: Feria Web Desktop Client");
        String mensaje = "<html><body><div width='200px' align='justify'><p style='font-size: 15px;'><b>Terminal Bloqueado</b></p><br />El terminal de Feria Web Desktop Client se encuentra bloqueado. Para poder desbloquear utilice las credenciales del usuario que ha iniciado sesión en el sistema. Los datos del usuario con sesión activa se proporcionan a continuación:<br /><br /><b>usuario (<em>nombre del usuario</em>)</b><br /><br />Desbloquee la terminal con la contraseña de dicho usuario.</div></body></html>";
        lblMensajeBloqueo.setText(mensaje);
    }
    
    public LockWindow(Component com, WebServiceAdministrador srvAdministrador, WebServiceAgrupacion srvAgrupacion, WebServiceCategoria srvCategoria, WebServiceCliente srvCliente, WebServiceComuna srvComuna, WebServiceEgreso srvEgreso, WebServiceFamilia srvFamilia, WebServiceMetodopago srvMetodoPago, WebServiceOrdendeventa srvOrdenVenta, WebServicePais srvPais, WebServiceProducto srvProducto, WebServiceProductor srvProductor, WebServiceProvincia srvProvincia, WebServiceRegion srvRegion, WebServiceStock srvStock, WebServiceUbicacionProductor srvUbicacionProductor, Geocoding mapa, Administrador user) {
        initComponents();
                //inicializacion manual
        this.srvAdministrador        = srvAdministrador;
        this.srvAgrupacion           = srvAgrupacion;
        this.srvCategoria            = srvCategoria;
        this.srvCliente              = srvCliente;
        this.srvComuna               = srvComuna;
        this.srvEgreso               = srvEgreso;
        this.srvFamilia              = srvFamilia;
        this.srvMetodoPago           = srvMetodoPago;
        this.srvOrdenVenta           = srvOrdenVenta;
        this.srvPais                 = srvPais;
        this.srvProducto             = srvProducto;
        this.srvProductor            = srvProductor;
        this.srvProvincia            = srvProvincia;
        this.srvRegion               = srvRegion;
        this.srvStock                = srvStock;
        this.srvUbicacionProductor   = srvUbicacionProductor;
    
        //servicio de mapas
        this.mapa                    =  mapa;
        
        this.user                    =  user;
        
        this.ventana                 = com;
        //seteando el logotipo de la ventana de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cl/alevicmar/imagenes/icono.png"));
        setIconImage(icon);
        //seteando titulo de ventana
        this.setLocationRelativeTo(com);
        this.setTitle("Terminal Bloqueado :: Feria Web Desktop Client");
        String mensaje = "<html><body><div width='200px' align='justify'><p style='font-size: 15px;'><b>Terminal Bloqueado</b></p><br />El terminal de Feria Web Desktop Client se encuentra bloqueado. Para poder desbloquear utilice las credenciales del usuario que ha iniciado sesión en el sistema. Los datos del usuario con sesión activa se proporcionan a continuación:<br /><br /><b>"+user.getUsuario()+" (<em>"+user.getNombres()+" "+user.getApaterno()+" "+user.getAmaterno()+"</em>)</b><br /><br />Desbloquee la terminal con la contraseña de dicho usuario.</div></body></html>";
        lblMensajeBloqueo.setText(mensaje);
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
        lblMensajeBloqueo = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnDesbloquear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Terminal Bloqueado")));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/imagenes/icono.png"))); // NOI18N

        lblMensajeBloqueo.setText("jLabel2");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        btnDesbloquear.setText("Desbloquear");
        btnDesbloquear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesbloquearActionPerformed(evt);
            }
        });
        btnDesbloquear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnDesbloquearKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensajeBloqueo)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDesbloquear)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblMensajeBloqueo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDesbloquear)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnDesbloquearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesbloquearActionPerformed
        if(HR.contenido(txtPassword).compareTo(user.getContrasena()) == 0) {
            this.ventana.setEnabled(true);
            ((Principal)this.ventana).setModalVentana(Dialog.ModalExclusionType.NO_EXCLUDE);
            this.dispose();
        }else{
            contador++;
            HR.mostrarError("Contraseña inválida... El terminal permanecerá bloqueado. Al tercer intento erróneo la aplicación será cerrada [Intento "+contador+" de 3]");
            if(contador == 3) {
                System.exit(0);
            }
        }
    }//GEN-LAST:event_btnDesbloquearActionPerformed

    private void btnDesbloquearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnDesbloquearKeyTyped
        HR.largoMaximo(txtPassword, 150, evt);
    }//GEN-LAST:event_btnDesbloquearKeyTyped

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnDesbloquearActionPerformed(null);
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

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
            java.util.logging.Logger.getLogger(LockWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LockWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LockWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LockWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LockWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDesbloquear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMensajeBloqueo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
