/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.agrupacion.AgrupacionAgricultores;
import cl.alevicmar.services.agrupacion.WebServiceAgrupacion;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.productor.Productor;
import cl.alevicmar.services.productor.WebServiceProductor;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class AsociarProductorAgrupacion extends javax.swing.JFrame {

    WebServiceProductor     srvProductor        = null;
    WebServiceAgrupacion    srvAgrupacion       = null;
    WebServiceComuna        srvComuna           = null;
    
    Component               componente          = null;
    Productor               productor           = null;
    AgrupacionAgricultores  agrupacion          = null;
    
    boolean                 bandera             = false;
    
    List<AgrupacionAgricultores> listado        = new ArrayList<AgrupacionAgricultores>();
    
    public AsociarProductorAgrupacion() {
        initComponents();
        this.srvAgrupacion = new WebServiceAgrupacion();
        this.srvProductor  = new WebServiceProductor();
        this.srvComuna = new WebServiceComuna();
        this.setLocationRelativeTo(componente);
        desactivarCampos();
    }
    
    public AsociarProductorAgrupacion(WebServiceProductor srvProductor, WebServiceAgrupacion srvAgrupacion, Component componente, WebServiceComuna srvComuna) {
        initComponents();
        this.srvAgrupacion = srvAgrupacion;
        this.srvProductor  = srvProductor;
        this.srvComuna = srvComuna;
        this.setLocationRelativeTo(componente);
        if(componente instanceof Principal) {
            this.setIconImage(((Principal)componente).getIconImage());
        }
        desactivarCampos();
    }

    public WebServiceProductor getSrvProductor() {
        return srvProductor;
    }

    public void setSrvProductor(WebServiceProductor srvProductor) {
        this.srvProductor = srvProductor;
    }

    public WebServiceAgrupacion getSrvAgrupacion() {
        return srvAgrupacion;
    }

    public void setSrvAgrupacion(WebServiceAgrupacion srvAgrupacion) {
        this.srvAgrupacion = srvAgrupacion;
    }

    public Productor getProductor() {
        return productor;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

    public AgrupacionAgricultores getAgrupacion() {
        return agrupacion;
    }

    public void setAgrupacion(AgrupacionAgricultores agrupacion) {
        this.agrupacion = agrupacion;
    }

    public void desactivarCampos() {
        HR.desactivar(lblNombre);
        HR.insertarTexto(lblNombre, "");
        HR.desactivar(lblMaterno);
        HR.insertarTexto(lblMaterno, "");
        HR.desactivar(lblApaterno);
        HR.insertarTexto(lblApaterno, "");
        
        HR.desactivar(txtRutAgrupacion);
        HR.insertarTexto(txtRutAgrupacion, "");
        HR.desactivar(txtNombreAgrupacion);
        HR.insertarTexto(txtNombreAgrupacion, "");
        HR.desactivar(btnFiltra);
        tablaResultados.setEnabled(false);
        
        HR.desactivar(btnVincular);
    }
    
    public void activarCampos() {
        HR.activar(lblNombre);
        HR.activar(lblMaterno);
        HR.activar(lblApaterno);
        
        HR.activar(txtRutAgrupacion);
        HR.activar(txtNombreAgrupacion);
        HR.activar(btnFiltra);
        tablaResultados.setEnabled(true);
        
        HR.activar(btnVincular);
    }
    
    public void rellenarTabla() {
        try {
            if(!bandera) {
                bandera = true;
                DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "RUT", "Razón Social"});    

                List<Object> array = srvAgrupacion.getWebServiceAgrupacionSoap().retornaTodasLasAgrupaciones().getAnyType();
                if(array != null) {
                    for(Object o : array) {
                        AgrupacionAgricultores p = ((AgrupacionAgricultores)o);
                        listado.add(p);
                        Object[] obj = new Object[4];
                        obj[0] = p.getRut();
                        obj[1] = p.getRazonSocial();
                        modelo.addRow(obj);
                    } 
                }
                tablaResultados.setModel(modelo);
                tablaResultados.getColumnModel().getColumn(0).setResizable(false);
                tablaResultados.getColumnModel().getColumn(0).setMaxWidth(75);
                tablaResultados.getColumnModel().getColumn(0).setMinWidth(75);
                tablaResultados.getColumnModel().getColumn(0).setWidth(85);
                tablaResultados.getColumnModel().getColumn(1).setResizable(false);
                tablaResultados.getColumnModel().getColumn(1).setMaxWidth(275);
                tablaResultados.getColumnModel().getColumn(1).setMinWidth(275);
                tablaResultados.getColumnModel().getColumn(1).setWidth(275);
            }
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar los datos de los clientes: "+e.getMessage());
        }
    }
    
    public void rellenarTabla(List<AgrupacionAgricultores> array) {
        try {
            if(!bandera) {
                bandera = true;
                DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "RUT", "Razón Social", "Dirección", "Comuna" });    

                if(array != null) {
                    for(Object o : array) {
                        if(o != null) {
                            AgrupacionAgricultores p = ((AgrupacionAgricultores)o);
                            Object[] obj = new Object[4];
                            obj[0] = p.getRut();
                            obj[1] = p.getRazonSocial();
                            obj[2] = p.getDireccion();
                            obj[3] = srvComuna.getWebServiceComunaSoap().buscaComuna(p.getComuna()).getNombre();
                            modelo.addRow(obj);
                        }
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
            }
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar los datos de los clientes: "+e.getMessage());
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtRunProductor = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApaterno = new javax.swing.JLabel();
        lblMaterno = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtRutAgrupacion = new javax.swing.JTextField();
        btnFiltra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNombreAgrupacion = new javax.swing.JTextField();
        btnVincular = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asociar Productor a Agrupación");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Productor"));

        jLabel1.setText("RUN Productor");

        txtRunProductor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRunProductorFocusLost(evt);
            }
        });
        txtRunProductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRunProductorKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel4.setText("Apellido Paterno");

        jLabel3.setText("Apellido Materno");

        lblNombre.setText("Nombre");

        lblApaterno.setText("Apellido Paterno");

        lblMaterno.setText("Apellido Materno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtRunProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaterno)
                            .addComponent(lblNombre)
                            .addComponent(lblApaterno))))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtRunProductor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblApaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMaterno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Vincular a Agrupación"));

        jLabel8.setText("RUT");

        txtRutAgrupacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRutAgrupacionFocusLost(evt);
            }
        });
        txtRutAgrupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRutAgrupacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutAgrupacionKeyTyped(evt);
            }
        });

        btnFiltra.setText("Filtrar");
        btnFiltra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltraActionPerformed(evt);
            }
        });

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUT", "Razón Social"
            }
        ));
        jScrollPane1.setViewportView(tablaResultados);

        jLabel5.setText("Nombre");

        txtNombreAgrupacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreAgrupacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreAgrupacionKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRutAgrupacion)
                            .addComponent(txtNombreAgrupacion, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(btnFiltra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtRutAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNombreAgrupacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnFiltra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        btnVincular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_next.png"))); // NOI18N
        btnVincular.setText("Vincular");
        btnVincular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVincularActionPerformed(evt);
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
                .addComponent(btnVincular)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnVincular))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRunProductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunProductorKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRunProductor, 12, evt);
    }//GEN-LAST:event_txtRunProductorKeyTyped

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(!HR.contenido(txtRunProductor).isEmpty()) {
            //buscar objeto
            productor = srvProductor.getWebServiceProductorSoap().buscaProductor(HR.contenido(txtRunProductor));
            if(productor.getId() == 0) {
                HR.mostrarError("El rut del productor que ha ingresado no se encuentra registrado");
                HR.focus(txtRunProductor);
                HR.seleccionarTodo(txtRunProductor);
                desactivarCampos();
            }else{
                HR.insertarTexto(lblNombre, productor.getNombres());
                HR.insertarTexto(lblApaterno, productor.getApaterno());
                HR.insertarTexto(lblMaterno, productor.getAmaterno());
                HR.focus(txtRutAgrupacion);
                activarCampos();
                rellenarTabla();
                HR.focus(txtRutAgrupacion);                
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtRunProductorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunProductorFocusLost
        if(HR.formatearYValidarRutCampo(txtRunProductor)) {
            btnBuscarActionPerformed(null);
        }
    }//GEN-LAST:event_txtRunProductorFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        System.gc();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtRutAgrupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutAgrupacionKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRutAgrupacion, 12, evt);
    }//GEN-LAST:event_txtRutAgrupacionKeyTyped

    private void txtNombreAgrupacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAgrupacionKeyTyped
        HR.largoMaximo(txtRunProductor, 255, evt);
    }//GEN-LAST:event_txtNombreAgrupacionKeyTyped

    private void btnFiltraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltraActionPerformed
        //verificando rut
        if(!HR.contenido(txtRutAgrupacion).isEmpty()) {
            int valor = HR.buscarValorTabla(0, tablaResultados, HR.contenido(txtRutAgrupacion));
            if(valor != -1) {
                tablaResultados.getSelectionModel().setSelectionInterval(valor, valor);
            }else{
                tablaResultados.getSelectionModel().setSelectionInterval(-1, -1);
                HR.mostrarError("No se encontró el RUT de la agrupación de productores");
            }
        }
        
        //vericar por razon social
        if(!HR.contenido(txtNombreAgrupacion).isEmpty()) {
            int valor = HR.buscarValorTabla(1, tablaResultados, HR.contenido(txtNombreAgrupacion), false);
            if(valor != -1) {
                tablaResultados.getSelectionModel().setSelectionInterval(valor, valor);
            }else{
                tablaResultados.getSelectionModel().setSelectionInterval(-1, -1);
                HR.mostrarError("No se encontró el RUT de la agrupación de productores");
            }
        }
    }//GEN-LAST:event_btnFiltraActionPerformed

    private void txtRutAgrupacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRutAgrupacionFocusLost
        if(!HR.contenido(txtRutAgrupacion).isEmpty()) {
            if(HR.formatearYValidarRutCampo(txtRutAgrupacion)) {
                btnBuscarActionPerformed(null);
            }
        }
    }//GEN-LAST:event_txtRutAgrupacionFocusLost

    private void txtRutAgrupacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutAgrupacionKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnFiltraActionPerformed(null);
        }
    }//GEN-LAST:event_txtRutAgrupacionKeyPressed

    private void txtNombreAgrupacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAgrupacionKeyPressed
        if(HR.haPresionadoEnter(evt)) {
            btnFiltraActionPerformed(null);
        }
    }//GEN-LAST:event_txtNombreAgrupacionKeyPressed

    private void btnVincularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVincularActionPerformed
        String opcion = HR.retornaValorTabla(0, tablaResultados);
        if(opcion.compareToIgnoreCase("") != 0) {
            agrupacion = srvAgrupacion.getWebServiceAgrupacionSoap().buscaAgrupacionPorRut(opcion);
            if(agrupacion.getId() == 0) {
                HR.mostrarError("No se pudo encontrar la agrupación de agricultores. Intentelo mas tarde.");
            }else{
                int valor = HR.preguntar("¿Esta seguro de vincular al productor "+productor.getNombres()+" "+productor.getApaterno()+" "+productor.getAmaterno()+" a la agrupación "+agrupacion.getRazonSocial()+"?");
                if(valor == 0) {
                    productor.setAgrupacion(agrupacion.getId());
                    if(srvProductor.getWebServiceProductorSoap().actualizaProductor(productor)) {
                        HR.mostrarMensaje("Se ha vinculado al productor "+productor.getNombres()+" "+productor.getApaterno()+" "+productor.getAmaterno()+" a la agrupación "+agrupacion.getRazonSocial());
                    }else{
                        HR.mostrarError("No se ha podido vincular al productor. Intetelo mas tarde.");
                    }
                }
            }
        }else{
            HR.mostrarError("Debe seleccionar una agrupación para asociar al productor");
        }
    }//GEN-LAST:event_btnVincularActionPerformed

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
            java.util.logging.Logger.getLogger(AsociarProductorAgrupacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsociarProductorAgrupacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsociarProductorAgrupacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsociarProductorAgrupacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsociarProductorAgrupacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnFiltra;
    private javax.swing.JButton btnVincular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApaterno;
    private javax.swing.JLabel lblMaterno;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaResultados;
    private javax.swing.JTextField txtNombreAgrupacion;
    private javax.swing.JTextField txtRunProductor;
    private javax.swing.JTextField txtRutAgrupacion;
    // End of variables declaration//GEN-END:variables
}
