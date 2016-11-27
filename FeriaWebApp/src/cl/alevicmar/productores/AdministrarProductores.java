/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.agrupacion.AgrupacionAgricultores;
import cl.alevicmar.services.agrupacion.ArrayOfAnyType;
import cl.alevicmar.services.agrupacion.WebServiceAgrupacion;
import cl.alevicmar.services.cliente.Clientes;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.productor.Productor;
import cl.alevicmar.services.productor.WebServiceProductor;
import cl.alevicmar.services.ubicacionproductor.WebServiceUbicacionProductor;
import cl.alevicmar.tools.HR;
import cl.alevicmar.tools.HRut;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Victor
 */

public class AdministrarProductores extends javax.swing.JFrame {

    WebServiceProductor srvProductor                    = null;
    WebServiceUbicacionProductor srvUbicacionProductor  = null;
    WebServiceAgrupacion srvAgrupacion                  = null;
    Component componente                                = null; 
    
    List<Productor> listado                             = new ArrayList<Productor>();
    
    public AdministrarProductores() {
        initComponents();
        this.setLocationRelativeTo(componente);
        this.srvProductor = new WebServiceProductor();
        this.srvUbicacionProductor = new WebServiceUbicacionProductor();
        this.srvAgrupacion = new WebServiceAgrupacion();
        this.rellenarTabla();
    }
    
    public AdministrarProductores(WebServiceProductor srvProductor, WebServiceUbicacionProductor srvUbicacionProductor, WebServiceAgrupacion srvAgrupacion, Component componente) {
        initComponents();
        this.setLocationRelativeTo(componente);
        if(componente instanceof Principal) {
            this.setIconImage(((Principal)componente).getIconImage());
        }
        this.srvProductor = srvProductor;
        this.srvUbicacionProductor = srvUbicacionProductor;
        this.srvAgrupacion = srvAgrupacion;
        this.rellenarTabla();
    }

    
    public void rellenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Usuario", "Nombre", "Correo Electrónico", "Agrupación" });    

            List<Object> array = srvProductor.getWebServiceProductorSoap().retornaTodosLosProductores().getAnyType();
            if(array != null) {
                for(Object o : array) {
                    Productor p = ((Productor)o);
                    listado.add(p);
                    Object[] obj = new Object[4];
                    obj[0] = p.getUsuario();
                    obj[1] = p.getApaterno()+" "+p.getAmaterno()+" "+p.getNombres();
                    obj[2] = p.getEmail();
                    if(p.getAgrupacion() == 0) {
                        obj[3] = "Independiente";
                    }else{
                        obj[3] = srvAgrupacion.getWebServiceAgrupacionSoap().buscaAgrupacion(p.getAgrupacion()).getRazonSocial();
                    }
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
    
    public void rellenarTablaConArray(List<Productor> array) {
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Usuario", "Nombre", "Correo Electrónico", "Agrupación" });    

            if(array != null) {
                for(Object o : array) {
                    Productor p = ((Productor)o);
                    Object[] obj = new Object[4];
                    obj[0] = p.getUsuario();
                    obj[1] = p.getApaterno()+" "+p.getAmaterno()+" "+p.getNombres();
                    obj[2] = p.getEmail();
                    if(p.getAgrupacion() == 0) {
                        obj[3] = "Independiente";
                    }else{
                        obj[3] = srvAgrupacion.getWebServiceAgrupacionSoap().buscaAgrupacion(p.getAgrupacion()).getRazonSocial();
                    }
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
    
    
    public List<Productor> eliminarElementosListaXRun(String run, List<Productor> listado) {
        if(listado != null) {
            for(int i = 0; i < listado.size(); i++) {
                Productor aux = listado.get(i);
                if(aux.getUsuario().compareToIgnoreCase(run) != 0) {
                    listado.remove(i);
                    i = 0;
                }
            }
        }
        return listado;
    }
    
    public List<Productor> eliminarElementosListaXCorreoElectrónico(String correo, List<Productor> listado) {
        if(listado != null) {
            for(int i = 0; i < listado.size(); i++) {
                Productor aux = listado.get(i);
                if(aux.getEmail().compareToIgnoreCase(correo) != 0) {
                    listado.remove(i);
                    i = 0;
                }
            }
            return listado;
        }else{
            return listado;
        }
    }
    
    public List<Productor> eliminarElementosListaPorAgrupacion(String agrupacion, List<Productor> listado) {
        if(listado != null) {
            AgrupacionAgricultores agr = srvAgrupacion.getWebServiceAgrupacionSoap().buscaAgrupacionPorRazonSocial(agrupacion);
            for(int i=0; i<listado.size(); i++) {
                if(listado.get(i).getAgrupacion() != agr.getId()) {
                    listado.remove(i);
                    i = 0;
                }
            }
            return listado;
        }else{
            return listado;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAgrupacion = new javax.swing.JTextField();
        btnCancelarFiltro = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Productores");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Productores registrados en el sistema"));

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuario", "Nombres", "Correo Electrónico", "Ubicación"
            }
        ));
        tablaResultados.setAutoscrolls(false);
        tablaResultados.setName("Administrador de Productores"); // NOI18N
        tablaResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Run del Productor");

        txtRun.setToolTipText("Escriba el RUN del productor a consultar");
        txtRun.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRunFocusLost(evt);
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

        jLabel2.setText("Nombres o Apellidos");

        txtNombres.setToolTipText("Escriba parte del nombre o el nombre completo del productor");
        txtNombres.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombresFocusLost(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel3.setText("Correo Electrónico");

        txtEmail.setToolTipText("");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
        });

        jLabel4.setText("Agrupación Agrícola");

        txtAgrupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgrupacionKeyTyped(evt);
            }
        });

        btnCancelarFiltro.setText("Eliminar Filtros");
        btnCancelarFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFiltroActionPerformed(evt);
            }
        });

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel2)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(btnCancelarFiltro))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltrar)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarFiltro)
                    .addComponent(btnFiltrar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFiltroActionPerformed
        listado = new ArrayList<>();
        rellenarTabla();
        HR.insertarTexto(txtRun, "");
        HR.insertarTexto(txtEmail, "");
        HR.insertarTexto(txtNombres, "");
        HR.insertarTexto(txtAgrupacion, "");
    }//GEN-LAST:event_btnCancelarFiltroActionPerformed
    
    private void txtRunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRun, 12, evt);
    }//GEN-LAST:event_txtRunKeyTyped

    private void txtRunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunFocusLost
        //Buscando productor por RUN
        if(!HR.contenido(txtRun).isEmpty()) {
            HR.insertarTexto(txtRun, HRut.formatear(HR.contenido(txtRun)));
            if(!HRut.validar(HR.contenido(txtRun))) {
               HR.mostrarError("El Rol Único Nacional del productor ingresado no es un RUN válido.");
               HR.seleccionarTodo(txtRun);
               HR.focus(txtRun);
            }else{
                btnFiltrarActionPerformed(null);
            }
        }else{
            btnCancelarFiltroActionPerformed(null);
        }
    }//GEN-LAST:event_txtRunFocusLost

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        HR.largoMaximo(txtRun, 277, evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        HR.largoMaximo(txtRun, 600, evt);
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtAgrupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgrupacionKeyTyped
        HR.largoMaximo(txtRun, 255, evt);
    }//GEN-LAST:event_txtAgrupacionKeyTyped

    private void txtRunKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnFiltrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtRunKeyPressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        //buscando por RUN
        if(!HR.contenido(txtRun).isEmpty()) {
            listado = eliminarElementosListaXRun(HR.contenido(txtRun), listado);
            rellenarTablaConArray(listado);
        }
        
        //buscar por nombres
        if(!HR.contenido(txtNombres).isEmpty()) {
            List<Object> aux = srvProductor.getWebServiceProductorSoap().buscarProductorPorNombre(HR.contenido(txtNombres)).getAnyType();
            List<Productor> prod1 = listado;
            List<Productor> respa = new ArrayList<Productor>();
            
            //listado recogiendo los valores necesarios
            for(int i = 0; i<aux.size(); i++) {
                Productor auxProd = ((Productor)aux.get(i));
                for(Productor auxProdRec : prod1) {
                    if(auxProdRec.getId() == auxProd.getId()) {
                        respa.add(auxProd);
                    }
                }
            }
            rellenarTablaConArray(respa);
            aux = null;
            prod1 = null;
            respa = null;
        }
        
        //buscarPorCorreoElectronico
        if(!HR.contenido(txtEmail).isEmpty()) {
            List<Object> aux = srvProductor.getWebServiceProductorSoap().buscarProductorPorEmail(HR.contenido(txtEmail)).getAnyType();
            List<Productor> prod1 = listado;
            List<Productor> respa = new ArrayList<Productor>();
            
            //listado recogiendo los valores necesarios
            for(int i = 0; i<aux.size(); i++) {
                Productor auxProd = ((Productor)aux.get(i));
                for(Productor auxProdRec : prod1) {
                    if(auxProdRec.getId() == auxProd.getId()) {
                        respa.add(auxProd);
                    }
                }
            }
            rellenarTablaConArray(respa);
            aux = null;
            prod1 = null;
            respa = null;
        }
        
        //buscarPorCorreoElectronico
        if(!HR.contenido(txtAgrupacion).isEmpty()) {
            AgrupacionAgricultores aux = srvAgrupacion.getWebServiceAgrupacionSoap().buscaAgrupacionPorRazonSocial(HR.contenido(txtAgrupacion));
            List<Productor> prod1 = listado;
            List<Productor> respa = new ArrayList<Productor>();
            
            //listado recogiendo los valores necesarios
            for(Productor auxProdRec : prod1) {
                if(auxProdRec.getAgrupacion() == aux.getId()) {
                    respa.add(auxProdRec);
                }
            }
            rellenarTablaConArray(respa);
            aux = null;
            prod1 = null;
            respa = null;
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnFiltrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnFiltrarActionPerformed(null);
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtNombresFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombresFocusLost
        if(!HR.contenido(txtNombres).trim().isEmpty()) {
            btnFiltrarActionPerformed(null);
        }else{
            btnCancelarFiltroActionPerformed(null);
        }
    }//GEN-LAST:event_txtNombresFocusLost

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if(!HR.contenido(txtEmail).isEmpty()) {
            btnFiltrarActionPerformed(null);
        }else{
            btnCancelarFiltroActionPerformed(null);
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void tablaResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaResultadosMouseClicked
        String identificador = HR.retornaValorTabla(0, tablaResultados);
        identificador = identificador.trim();
        Productor cli = srvProductor.getWebServiceProductorSoap().buscaProductor(identificador);
        if(cli.getId() == 0) {
            HR.mostrarError("No pudo encontrarse la agrupación de productores con RUT "+identificador);
        }else{
            VerProductor detcli =  new VerProductor(srvProductor, componente, cli);
            detcli.setIconImage(this.getIconImage());
            detcli.setVisible(true);
        }
    }//GEN-LAST:event_tablaResultadosMouseClicked

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
            java.util.logging.Logger.getLogger(AdministrarProductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarProductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarProductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarProductores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarProductores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarFiltro;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTextField txtAgrupacion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
