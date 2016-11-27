/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productores;

import cl.alevicmar.mapa.MapaSeleccionar;
import cl.alevicmar.services.comuna.Comuna;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.services.productor.Productor;
import cl.alevicmar.services.productor.WebServiceProductor;
import cl.alevicmar.services.ubicacionproductor.UbicacionProductor;
import cl.alevicmar.services.ubicacionproductor.WebServiceUbicacionProductor;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import java.awt.geom.Point2D;
import javax.swing.UIManager;
import maps.java.Geocoding;

/**
 *
 * @author Victor Manuel Araya
 */
public class RegistrarUbicacion extends javax.swing.JFrame {

    WebServiceProductor             srvProductor    = null;
    WebServiceUbicacionProductor    srvUbicacion    = null;
    WebServiceComuna                srvComuna       = null;
    
    Component                       componente      = null;
    Productor                       productor       = null;
    UbicacionProductor              ubicacion       = null;
    
    
    public RegistrarUbicacion() {
        initComponents();
        this.srvProductor   = new WebServiceProductor();
        this.srvUbicacion   = new WebServiceUbicacionProductor();
        this.srvComuna      = new WebServiceComuna();
        this.setLocationRelativeTo(componente);
        inicializar();
    }
    
    public RegistrarUbicacion(WebServiceProductor srvProductor, WebServiceUbicacionProductor srvUbicacion, WebServiceComuna srvComuna, Component componente) {
        initComponents();
        this.srvProductor   = srvProductor;
        this.srvUbicacion   = srvUbicacion;
        this.srvComuna      = srvComuna;
        this.setLocationRelativeTo(componente);
        inicializar();
    }
    
    public RegistrarUbicacion(WebServiceProductor srvProductor, WebServiceUbicacionProductor srvUbicacion, WebServiceComuna srvComuna, Component componente, Productor productor) {
        initComponents();
        this.srvProductor   = srvProductor;
        this.srvUbicacion   = srvUbicacion;
        this.srvComuna      = srvComuna;
        this.setLocationRelativeTo(componente);
        this.productor      = productor;
        inicializar();
        HR.insertarTexto(txtRun, productor.getUsuario());
        btnBuscarActionPerformed(null);
        btnSeleccionarActionPerformed(null);
    }

    public void inicializar() {
        HR.insertarTexto(lblNombres, "");
        HR.insertarTexto(lblApaterno, "");
        HR.insertarTexto(lblAmaterno, "");
        
        HR.desactivar(btnSeleccionar);
        HR.desactivar(btnBuscarOtro);
        
        HR.desactivar(txtNombres);
        HR.desactivar(txtDireccion);
        HR.desactivar(cmbComuna);
        HR.desactivar(txtReferencia);
        HR.desactivar(txtLatitud);
        HR.desactivar(txtLongitud);
        HR.desactivar(btnLocalizar);
        
        HR.desactivar(btnGuardar);
    }
    
    public void rellenarComunas() {
        cmbComuna.removeAllItems();
        HR.insertarTexto(cmbComuna, "Seleccione...");
        for(Object o : srvComuna.getWebServiceComunaSoap().retornaTodasLasComunas().getAnyType()) {
            Comuna c = ((Comuna)o);
            HR.insertarTexto(cmbComuna, c.getNombre());
        }
    }
    
    public void rellenarDatosLatitudLongitud(String datos) {
        HR.insertarTexto(txtLatitud, datos.split(",")[0].substring(0, 10));
        HR.insertarTexto(txtLongitud, datos.split(",")[1].substring(0, 10));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbComuna = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        btnLocalizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtRun = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApaterno = new javax.swing.JLabel();
        lblAmaterno = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        btnBuscarOtro = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Ubicación");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicación de Productor"));

        jLabel1.setText("Nombre");

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel2.setText("Dirección");

        jLabel3.setText("Comuna");

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel4.setText("Referencia");

        jLabel5.setText("Latitud");

        jLabel6.setText("Longitud");

        txtLatitud.setEnabled(false);

        txtLongitud.setEnabled(false);

        btnLocalizar.setText("Localizar");
        btnLocalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarActionPerformed(evt);
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombres)
                    .addComponent(txtDireccion)
                    .addComponent(cmbComuna, 0, 263, Short.MAX_VALUE)
                    .addComponent(txtReferencia)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLocalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(btnLocalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Seleccionar Productor")));

        jLabel7.setText("RUN");

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
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombres");

        jLabel9.setText("Apellido Paterno");

        jLabel10.setText("Apellido Materno");

        lblNombres.setText("Nombres");

        lblApaterno.setText("Apellido Paterno");

        lblAmaterno.setText("Apellido Materno");

        btnSeleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_next.png"))); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnBuscarOtro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_delete.png"))); // NOI18N
        btnBuscarOtro.setText("Cancelar");
        btnBuscarOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarOtroActionPerformed(evt);
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
                        .addComponent(jLabel7)
                        .addGap(46, 46, 46)
                        .addComponent(txtRun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(86, 86, 86)
                                .addComponent(lblNombres))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblApaterno)
                                    .addComponent(lblAmaterno))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 141, Short.MAX_VALUE)
                        .addComponent(btnBuscarOtro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSeleccionar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblNombres))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblApaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblAmaterno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(btnBuscarOtro))
                .addContainerGap())
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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                productor = srvProductor.getWebServiceProductorSoap().buscaProductor(HR.contenido(txtRun));
                if(productor.getId() == 0) {
                    HR.mostrarMensaje("El productor que ha especificado no existe en la base de datos!");
                    HR.insertarTexto(txtRun, "");
                    HR.focus(txtRun);
                    productor = null;
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

    private void txtRunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunFocusLost
        btnBuscarActionPerformed(null);
    }//GEN-LAST:event_txtRunFocusLost

    private void btnBuscarOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarOtroActionPerformed
        productor = null;
        HR.insertarTexto(lblNombres, "");
        HR.insertarTexto(lblApaterno, "");
        HR.insertarTexto(lblAmaterno, "");
        inicializar();
        HR.insertarTexto(txtRun, "");
        HR.focus(txtRun);
    }//GEN-LAST:event_btnBuscarOtroActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if(productor != null) {
            HR.activar(txtNombres);
            HR.activar(txtDireccion);
            HR.activar(cmbComuna);
            HR.activar(txtReferencia);
            HR.activar(btnLocalizar);
            
            HR.activar(btnGuardar);
            HR.focus(txtNombres);
            
            rellenarComunas();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnLocalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarActionPerformed
        if(!HR.contenido(txtDireccion).isEmpty()) {
            if(HR.contenido(cmbComuna).compareToIgnoreCase("Seleccione...") != 0) {
                Geocoding mapa = new Geocoding();
                try {
                    Point2D.Double resultado = mapa.getCoordinates(HR.contenido(txtDireccion)+", "+HR.contenido(cmbComuna)+", Chile");
                    HR.insertarTexto(txtLatitud, resultado.getX()+"");
                    HR.insertarTexto(txtLongitud, resultado.getY()+"");
                    if((resultado.getX() == 0.0) && (resultado.getY() == 0.0)) {
                        HR.mostrarError("La dirección no pudo ser encontrada");
                        MapaSeleccionar mapaSel = new MapaSeleccionar(this);
                        /*HR.seleccionarTodo(txtDireccion);
                        HR.focus(txtDireccion);*/
                    }else{
                        String url = "https://www.google.cl/maps/place/"+resultado.getX()+","+resultado.getY()+"";
                        try {
                            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                        }catch(Exception err)
                        {
                            HR.mostrarError("Error: "+err);
                        }
                    }
                }catch(Exception e) {
                    HR.mostrarError("Imposible determinar las coordenadas con la información proporcionada");
                }
            }else{
                HR.mostrarError("Debe seleccionar la comuna para poder localizar la ubicación!");
                HR.focus(txtDireccion);
            }
        }else{
            HR.mostrarError("Debe escribir la dirección para poder localizar la ubicación!");
            HR.focus(txtDireccion);
        }
    }//GEN-LAST:event_btnLocalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(productor == null) {
            HR.mostrarError("Debe seleccionar un productor!");
            inicializar();
            HR.focus(txtRun);
        }else{
            if(productor.getId() == 0) {
                HR.mostrarError("Debe seleccionar un productor!");
                inicializar();
                HR.focus(txtRun);
            }else{
                if(HR.contenido(txtNombres).isEmpty()) {
                    HR.mostrarError("El campo de nombre de la ubicación no ha sido completado. Por favor completelo");
                    HR.focus(txtNombres);
                }else{
                    if(HR.contenido(txtReferencia).isEmpty()) {
                        HR.mostrarError("El campo de referencia de como llegar a la ubicación no ha sido completado. Por favor completelo");
                        HR.focus(txtReferencia);
                    }else{
                        if(!HR.contenido(txtDireccion).isEmpty()) {
                            if(HR.contenido(cmbComuna).compareToIgnoreCase("Seleccione...") == 0) {
                                HR.mostrarError("Debe especificar la comuna de la ubicación");
                                HR.focus(cmbComuna);
                            }else{
                                if(HR.contenido(txtLongitud).isEmpty() || HR.contenido(txtLatitud).isEmpty()) {
                                    btnLocalizarActionPerformed(evt);
                                }else{
                                    //recuperar toda la información
                                    String nombre = HR.contenido(txtNombres);
                                    String direccion = HR.contenido(txtDireccion);
                                    String comuna = HR.contenido(cmbComuna);
                                    String referencia = HR.contenido(txtReferencia);
                                    String latitud = HR.contenido(txtLatitud);
                                    String longitud = HR.contenido(txtLongitud);
                                    
                                    //buscar comuna
                                    Comuna c = srvComuna.getWebServiceComunaSoap().buscaComunaPorNombre(comuna);
                                    if(c.getId() == 0) {
                                        HR.mostrarError("La comuna no pudo ser encontrada en el sistema!");
                                        this.dispose();
                                    }else{
                                        ubicacion = new UbicacionProductor();
                                        ubicacion.setNombre(nombre);
                                        ubicacion.setDireccion(direccion);
                                        ubicacion.setComuna(c.getId());
                                        ubicacion.setReferencia(referencia);
                                        ubicacion.setLatitud(latitud);
                                        ubicacion.setLongitud(longitud);
                                        
                                        if(srvUbicacion.getWebServiceUbicacionProductorSoap().guardarUbicacionProductor(ubicacion)) {
                                            HR.mostrarMensaje("La ubicación ha sido creada con éxito");
                                            this.dispose();
                                        }else{
                                            HR.mostrarError("La ubicación no se pudo crear!");
                                        }
                                    }
                                    
                                }
                            }
                        }else{
                            HR.mostrarError("Debe especificar la dirección de la ubicación");
                            HR.focus(txtDireccion);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        HR.largoMaximo(txtNombres, 75, evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        HR.largoMaximo(txtDireccion, 255, evt);
    }//GEN-LAST:event_txtDireccionKeyTyped

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
            java.util.logging.Logger.getLogger(RegistrarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUbicacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUbicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarOtro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLocalizar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cmbComuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAmaterno;
    private javax.swing.JLabel lblApaterno;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtReferencia;
    private javax.swing.JTextField txtRun;
    // End of variables declaration//GEN-END:variables
}
