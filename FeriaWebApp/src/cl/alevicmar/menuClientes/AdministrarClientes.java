
package cl.alevicmar.menuClientes;

import cl.alevicmar.services.cliente.ArrayOfAnyType;
import cl.alevicmar.services.cliente.Clientes;
import cl.alevicmar.services.cliente.WebServiceCliente;
import cl.alevicmar.services.comuna.Comuna;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.comuna.WebServiceComunaSoap;
import cl.alevicmar.tools.HCorreo;
import cl.alevicmar.tools.HR;
import cl.alevicmar.tools.HRut;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor Manuel Araya
 */
public class AdministrarClientes extends javax.swing.JFrame {
    
    WebServiceComuna                srvComuna               = null;
    WebServiceCliente               srvCliente              = null;
    boolean                         filtro                  = false;
    
    /**
     * Contructor por defecto: ¡NO Utilizar salvo para ejecución local!
     * 
     * @return objeto tipo AdministrarClientes
     */
    public AdministrarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        srvComuna = new WebServiceComuna();
        srvCliente = new WebServiceCliente();
        this.rellenar();
        this.rellenarComunas();
        HR.desactivar(btnCancelarFiltro);
    }
    
    /**
     * Utilizar este constructor para generar una instancia del administrador de clientes con los servicios instanciados desde splash
     * 
     * @param srvCliente
     *            WebService instanciado de clientes
     * @param srvComuna
     *            WebService instanciado de comuna
     * @param ventana
     *            Instancia de la ventana que invoca este form y se utiliza para centrarla a la ventana que la invoca
     * @return objeto tipo AdministrarClientes
     */
    public AdministrarClientes(WebServiceCliente srvCliente, WebServiceComuna srvComuna, Component ventana) {
        initComponents();
        this.setLocationRelativeTo(ventana);
        this.srvCliente = srvCliente;
        this.srvComuna = srvComuna;
        this.rellenar();
        this.rellenarComunas();
        HR.desactivar(btnCancelarFiltro);
    }

    /**
     * Rellena la tabla de la ventana con los datos retornados desde el webservice
     * 
     * @return void (Rellena la tabla de la ventana con los datos retornados desde el webservice)
     */
    public void rellenar(){
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Usuario", "Nombre", "Dirección", "Comuna" });    

            List<Object> array = srvCliente.getWebServiceClienteSoap().retornaTodosLosClientes().getAnyType();
            if(array != null) {
                for(Object o : array) {
                    Clientes p = ((Clientes)o);
                    Object[] obj = new Object[4];
                    obj[0] = p.getUsuario();
                    obj[1] = p.getApaterno()+" "+p.getAmaterno()+" "+p.getNombres();
                    obj[2] = p.getDireccion();
                    obj[3] = srvComuna.getWebServiceComunaSoap().buscaComuna(p.getComuna()).getNombre();
                    modelo.addRow(obj);
                } 
            }
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
            tablaResultados.getColumnModel().getColumn(3).setResizable(false);
            tablaResultados.getColumnModel().getColumn(3).setWidth(12);
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar los datos de los clientes: "+e.getMessage());
        }
     }
    
    /**
     * Rellena la tabla de la ventana con los datos retornados desde un arreglo proporcionado por el webservice
     * @param arreglo
     *      Objeto de tipo List<Object> que es proporcionado por el webservice
     * 
     * @return void (Rellena la tabla de la ventana con los datos retornados desde el webservice)
     */
    public void rellenarConArreglo(ArrayOfAnyType arreglo){
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Usuario", "Nombre", "Dirección", "Comuna" });    
            List<Object> array = arreglo.getAnyType();
            for(Object o : array) {
                Clientes p = ((Clientes)o);
                Object[] obj = new Object[4];
                obj[0] = p.getUsuario();
                obj[1] = p.getApaterno()+" "+p.getAmaterno()+" "+p.getNombres();
                obj[2] = p.getDireccion();
                obj[3] = srvComuna.getWebServiceComunaSoap().buscaComuna(p.getComuna()).getNombre();
                modelo.addRow(obj);
            } 
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
            tablaResultados.getColumnModel().getColumn(3).setResizable(false);
            tablaResultados.getColumnModel().getColumn(3).setWidth(12);
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar los datos de los clientes: "+e.getMessage());
        }
     }
    
    /**
     * Rellena la tabla de la ventana con los datos retornados desde un objeto proporcionado por el webservice
     * @param cli
     *      Objeto de tipo Clientes que es proporcionado por el webservice
     * 
     * @return void (Rellena la tabla de la ventana con los datos retornados desde el webservice)
     */
    public void rellenarConObjeto(Clientes cli){
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Usuario", "Nombre", "Dirección", "Comuna" });    
            Clientes p = cli;
            Object[] obj = new Object[4];
            obj[0] = p.getUsuario();
            obj[1] = p.getApaterno()+" "+p.getAmaterno()+" "+p.getNombres();
            obj[2] = p.getDireccion();
            obj[3] = srvComuna.getWebServiceComunaSoap().buscaComuna(p.getComuna()).getNombre();
            modelo.addRow(obj);
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
            tablaResultados.getColumnModel().getColumn(3).setResizable(false);
            tablaResultados.getColumnModel().getColumn(3).setWidth(12);
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar los datos de los clientes: "+e.getMessage());
        }
     }
    
    /**
     * Rellena el combobox con las comunas en la base de datos
     * 
     * @return void (Rellena el combobox de la ventana con los datos retornados desde el webservice)
     */
    public void rellenarComunas() {
        try {
            List<Object> array = srvComuna.getWebServiceComunaSoap().retornaTodasLasComunas().getAnyType();
            cmbComuna.removeAllItems();
            HR.insertarTexto(cmbComuna, "Seleccione...");
            for(Object o : array) {
                Comuna c = ((Comuna)o);
                HR.insertarTexto(cmbComuna, c.getNombre());
            }
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar las comunas: "+e.getMessage());
        }
    }
    
    public WebServiceComuna getSrvComuna() {
        return srvComuna;
    }

    public void setSrvComuna(WebServiceComuna srvComuna) {
        this.srvComuna = srvComuna;
    }

    public WebServiceCliente getSrvCliente() {
        return srvCliente;
    }

    public void setSrvCliente(WebServiceCliente srvCliente) {
        this.srvCliente = srvCliente;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbComuna = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();
        btnCancelarFiltro = new javax.swing.JButton();
        btnEliminarFiltros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrador de Clientes");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Clientes"));

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuarios", "Nombre", "Dirección", "Comuna"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaResultados);
        if (tablaResultados.getColumnModel().getColumnCount() > 0) {
            tablaResultados.getColumnModel().getColumn(0).setResizable(false);
            tablaResultados.getColumnModel().getColumn(0).setPreferredWidth(12);
            tablaResultados.getColumnModel().getColumn(1).setResizable(false);
            tablaResultados.getColumnModel().getColumn(1).setPreferredWidth(25);
            tablaResultados.getColumnModel().getColumn(2).setResizable(false);
            tablaResultados.getColumnModel().getColumn(2).setPreferredWidth(35);
            tablaResultados.getColumnModel().getColumn(3).setResizable(false);
            tablaResultados.getColumnModel().getColumn(3).setPreferredWidth(12);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtrar por"));

        jLabel1.setText("Rut del Usuario");

        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombres o Apellidos");

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel3.setText("Correo Electrónico");

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        jLabel4.setText("Comuna");

        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/find.png"))); // NOI18N
        btnFiltrar.setText("Buscar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnCancelarFiltro.setText("Mostrar Todo");
        btnCancelarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFiltroActionPerformed(evt);
            }
        });

        btnEliminarFiltros.setText("Eliminar Filtros");
        btnEliminarFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario)
                    .addComponent(txtNombres)
                    .addComponent(txtCorreo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(cmbComuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEliminarFiltros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelarFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFiltrar)
                    .addComponent(btnCancelarFiltro)
                    .addComponent(btnEliminarFiltros))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtUsuario, 12, evt);
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if(!HR.contenido(txtUsuario).isEmpty()) {
            HR.insertarTexto(txtUsuario, HRut.formatear(HR.contenido(txtUsuario)));
            if(!HRut.validar(HR.contenido(txtUsuario))) {
               HR.mostrarError("El Rol Único Nacional del usuario ingresado no es un RUN válido.");
               HR.seleccionarTodo(txtUsuario);
               HR.focus(txtUsuario);
            }
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        HR.largoMaximo(txtNombres, 275, evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        HR.largoMaximo(txtCorreo, 255, evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        try {
            if(HR.contenido(cmbComuna).compareToIgnoreCase("Seleccione...") != 0) {
                //filtrar por comuna
                this.rellenarConArreglo(srvCliente.getWebServiceClienteSoap().buscaClientePorComuna(HR.contenido(cmbComuna)));
                HR.activar(btnCancelarFiltro);
            }else if(!HR.contenido(txtUsuario).isEmpty()){ 
                //buscar por rut
                this.rellenarConObjeto(srvCliente.getWebServiceClienteSoap().buscaClientePorRun(HR.contenido(txtUsuario).trim()));
                HR.activar(btnCancelarFiltro);
            }else if(!HR.contenido(txtNombres).isEmpty()) {
                //buscar por nombres
                this.rellenarConArreglo(srvCliente.getWebServiceClienteSoap().buscaClientePorNombres(HR.contenido(txtNombres).trim()));
                HR.activar(btnCancelarFiltro);
            }else if(!HR.contenido(txtCorreo).isEmpty()) {
                //buscar por email
                this.rellenarConArreglo(srvCliente.getWebServiceClienteSoap().buscaClientePorEmail(HR.contenido(txtCorreo).trim()));
                HR.activar(btnCancelarFiltro);
            }else{
                this.rellenar();
                HR.desactivar(btnCancelarFiltro);
            }
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error al ejecutar la búsqueda: "+e.getMessage());
            this.rellenar();
            HR.desactivar(btnCancelarFiltro);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnCancelarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFiltroActionPerformed
        this.rellenar();
        HR.desactivar(btnCancelarFiltro);
    }//GEN-LAST:event_btnCancelarFiltroActionPerformed

    /**
     * Utilizar este método para obtener el elemento que el usuario ha cliqueado en la tabla y acceder al detalle
     * 
     * @param evt
     *            Evento rellenado por java cuando escucha el doble clic por parte del cliente
     * @return objeto tipo AdministrarClientes
     */
    private void tablaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadosMouseClicked
        String identificador = HR.retornaValorTabla(0, tablaResultados);
        identificador = identificador.trim();
        Clientes cli = srvCliente.getWebServiceClienteSoap().buscaClientePorRun(identificador);
        if(cli == null) {
            HR.mostrarError("No pudo encontrarse el cliente con RUN "+identificador);
        }else{
        DetalleCliente detcli =  new DetalleCliente(cli, this, srvCliente, srvComuna);
        detcli.setIconImage(this.getIconImage());
        detcli.setVisible(true);
        }
    }//GEN-LAST:event_tablaResultadosMouseClicked

    private void btnEliminarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFiltrosActionPerformed
        // TODO add your handling code here:
        rellenar();
        HR.insertarTexto(txtUsuario, "");
        HR.insertarTexto(txtCorreo, "");
        HR.insertarTexto(txtNombres, "");
        HR.insertarTexto(cmbComuna, "");
    }//GEN-LAST:event_btnEliminarFiltrosActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarFiltro;
    private javax.swing.JButton btnEliminarFiltros;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cmbComuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
