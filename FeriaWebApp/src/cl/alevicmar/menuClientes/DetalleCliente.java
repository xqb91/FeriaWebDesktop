/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.menuClientes;

import cl.alevicmar.services.cliente.Clientes;
import cl.alevicmar.services.cliente.WebServiceCliente;
import cl.alevicmar.services.comuna.Comuna;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.pais.Pais;
import cl.alevicmar.services.pais.WebServicePais;
import cl.alevicmar.services.provincia.Provincia;
import cl.alevicmar.services.provincia.WebServiceProvincia;
import cl.alevicmar.services.region.Region;
import cl.alevicmar.services.region.WebServiceRegion;
import cl.alevicmar.tools.HR;
import java.awt.Component;

/**
 *
 * @author Victor
 */
public class DetalleCliente extends javax.swing.JFrame {

    Clientes cli                    = null;
    WebServiceCliente srvCliente    = null;
    WebServiceComuna srvComuna      = null;
    
    /**
     * Contructor por defecto: ¡NO Utilizar salvo para ejecución local!
     * 
     * @return objeto tipo DetalleCliente
     */
    public DetalleCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.srvCliente = new WebServiceCliente();
        this.srvComuna = new WebServiceComuna();
        this.cli = new Clientes();
        cli.setUsuario("test");
        cli.setAmaterno("test");
        cli.setApaterno("test");
        cli.setNombres("test");
        this.setTitle("Feria Web Desktop Client - Cliente "+cli.getNombres()+" "+cli.getApaterno()+" "+cli.getAmaterno()+" ["+cli.getUsuario()+"]");
        
        //seteando datos por defecto
        HR.insertarTexto(lblNombre, cli.getNombres()+" "+cli.getApaterno()+" "+cli.getAmaterno()+" (Usuario: "+cli.getUsuario()+")");
        HR.insertarTexto(lblCorreo, cli.getEmail());
        if(cli.getTelefono().compareToIgnoreCase("0") == 0) { HR.insertarTexto(lblTelefono, "No detallado"); }else{ HR.insertarTexto(lblTelefono, "+"+cli.getTelefono()); }
        if(cli.getCelular().compareToIgnoreCase("0") == 0) { HR.insertarTexto(lblCelular, "No detallado"); }else{ HR.insertarTexto(lblCelular, "+"+cli.getCelular()); }
        if(cli.getFax().compareToIgnoreCase("0") == 0) { HR.insertarTexto(lblFax, "No detallado"); }else{ HR.insertarTexto(lblTelefono, "+"+cli.getFax()); }
        HR.insertarTexto(lblDireccion, cli.getDireccion());
    }
    
    /**
     * Utilizar este constructor para generar una instancia de detalle del cliente con los servicios instanciados desde splash y enviados desde la ventana anterior
     * 
     * @param srvCliente
     *            WebService instanciado de clientes
     * @param srvComuna
     *            WebService instanciado de comuna
     * @param ventana
     *            Instancia de la ventana que invoca este form y se utiliza para centrarla a la ventana que la invoca
     * @return objeto tipo AdministrarClientes
     */
    public DetalleCliente(Clientes cli, Component com, WebServiceCliente srvCliente, WebServiceComuna srvComuna) {
        initComponents();
        this.setLocationRelativeTo(com);
        this.setTitle("Feria Web Desktop Client - Cliente "+cli.getNombres()+" "+cli.getApaterno()+" "+cli.getAmaterno()+" ["+cli.getUsuario()+"]");
        this.srvCliente = srvCliente;
        this.srvComuna = srvComuna;
        this.cli = cli;
        
        //seteando datos por defecto
        HR.insertarTexto(lblNombre, cli.getNombres()+" "+cli.getApaterno()+" "+cli.getAmaterno()+" (Usuario: "+cli.getUsuario()+")");
        HR.insertarTexto(lblCorreo, cli.getEmail());
        if(cli.getTelefono().compareToIgnoreCase("0") == 0) { HR.insertarTexto(lblTelefono, "No detallado"); }else{ HR.insertarTexto(lblTelefono, "+"+cli.getTelefono()); }
        if(cli.getCelular().compareToIgnoreCase("0") == 0) { HR.insertarTexto(lblCelular, "No detallado"); }else{ HR.insertarTexto(lblCelular, "+"+cli.getCelular()); }
        if(cli.getFax().compareToIgnoreCase("0") == 0) { HR.insertarTexto(lblFax, "No detallado"); }else{ HR.insertarTexto(lblFax, "+"+cli.getFax()); }
        HR.insertarTexto(lblDireccion, cli.getDireccion());
        
        //recuperando datos foráneos
        Comuna comu     = srvComuna.getWebServiceComunaSoap().buscaComuna(cli.getComuna());
        Provincia pro   = new WebServiceProvincia().getWebServiceProvinciaSoap().buscarProvincia(comu.getProvincia());
        Region reg      = new WebServiceRegion().getWebServiceRegionSoap().buscaRegion(pro.getRegion());
        Pais pai        = new WebServicePais().getWebServicePaisSoap().buscaPais(reg.getPais());
        
        HR.insertarTexto(lblComuna, comu.getNombre());
        HR.insertarTexto(lblRegion, reg.getNombre());
        HR.insertarTexto(lblPais, pai.getNombre());
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
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblFax = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblComuna = new javax.swing.JLabel();
        lblRegion = new javax.swing.JLabel();
        lblPais = new javax.swing.JLabel();
        btnMapa = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Personal"));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("Nombre");

        lblNombre.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblNombre.setText("Nombre del Cliente");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel3.setText("Correo Electrónico");

        lblCorreo.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblCorreo.setText("ejemplo@ejemplo.cl");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setText("Teléfono");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setText("Celular");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setText("Fax");

        lblTelefono.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblTelefono.setText("123456789012");

        lblCelular.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblCelular.setText("123456789012");

        lblFax.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblFax.setText("123456789012");

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
                            .addComponent(lblNombre)
                            .addComponent(jLabel3)
                            .addComponent(lblCorreo))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblTelefono))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblCelular))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(lblFax))
                        .addGap(99, 99, 99))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCorreo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefono)
                    .addComponent(lblCelular)
                    .addComponent(lblFax))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Ubicación"));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel11.setText("Dirección");

        lblDireccion.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblDireccion.setText("Dirección particular del cliente");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel13.setText("Comuna");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel14.setText("Región");

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel15.setText("País");

        lblComuna.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblComuna.setText("Nombre de Comuna");

        lblRegion.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblRegion.setText("Nombre de Región");

        lblPais.setFont(new java.awt.Font("Lucida Grande", 2, 13)); // NOI18N
        lblPais.setText("Nombre de País");

        btnMapa.setText("Ver en Mapa");
        btnMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(lblComuna))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRegion)
                            .addComponent(jLabel14))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(lblPais))
                        .addGap(35, 35, 35))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(lblDireccion)
                            .addComponent(btnMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComuna)
                    .addComponent(lblRegion)
                    .addComponent(lblPais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnMapa)
                .addContainerGap())
        );

        jToggleButton2.setText("Cerrar");

        jToggleButton3.setText("Editar");

        jToggleButton4.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jToggleButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3)
                    .addComponent(jToggleButton4))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapaActionPerformed
        String direccion = "https://www.google.cl/maps/place/"+cli.getLongitud()+","+cli.getLatitud()+"";
        try {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
        }catch(Exception err)
        {
            HR.mostrarError("Error: "+err);
        }
    }//GEN-LAST:event_btnMapaActionPerformed

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
            java.util.logging.Logger.getLogger(DetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalleCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalleCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMapa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblComuna;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblFax;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPais;
    private javax.swing.JLabel lblRegion;
    private javax.swing.JLabel lblTelefono;
    // End of variables declaration//GEN-END:variables
}
