/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.menuClientes;

import cl.alevicmar.mapa.MapaSeleccionar;
import cl.alevicmar.services.cliente.Clientes;
import cl.alevicmar.services.cliente.WebServiceCliente;
import cl.alevicmar.services.comuna.Comuna;
import cl.alevicmar.services.comuna.WebServiceComuna;
import cl.alevicmar.tools.HCorreo;
import cl.alevicmar.tools.HR;
import cl.alevicmar.tools.HRut;
import java.awt.Component;
import java.awt.geom.Point2D;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.UIManager;
import maps.java.Geocoding;

/**
 *
 * @author Victor Manuel Araya
 */
public class RegistrarCliente extends javax.swing.JFrame {

    WebServiceCliente srvCliente = null;
    WebServiceComuna srvComuna = null;
    Clientes cliente;
    boolean preview = false;

    /**
     * Creates new form RegistrarCliente
     */
    public RegistrarCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.srvCliente = new WebServiceCliente();
        this.srvComuna = new WebServiceComuna();
        rellenarComunas();
    }

    public RegistrarCliente(Component com, WebServiceCliente srvCliente, WebServiceComuna srvComuna) {
        initComponents();
        this.setLocationRelativeTo(com);
        this.srvCliente = srvCliente;
        this.srvComuna = srvComuna;
        rellenarComunas();
        txtLongitud.setEditable(false);
        txtLatitud.setEditable(false);
        this.setIconImage(((JFrame) com).getIconImage());
    }

    public RegistrarCliente(Component com, WebServiceCliente srvCliente, WebServiceComuna srvComuna, Clientes cliente) {
        initComponents();
        this.setLocationRelativeTo(com);
        this.srvCliente = srvCliente;
        this.srvComuna = srvComuna;
        this.cliente = cliente;
        txtLongitud.setEditable(false);
        txtLatitud.setEditable(false);
        this.cargaInfoUsuario();
        this.setTitle("Actualizar Cliente");
        this.preview = true;
        this.setIconImage(((JFrame) com).getIconImage());
        HR.insertarTexto(btnGuardar, "Actualizar");
    }

    public void rellenarDatosLatitudLongitud(String datos) {
        HR.insertarTexto(txtLatitud, datos.split(",")[0].substring(0, 10));
        HR.insertarTexto(txtLongitud, datos.split(",")[1].substring(0, 10));
    }

    /**
     * Rellena el combobox con las comunas en la base de datos
     *
     * @return void (Rellena el combobox de la ventana con los datos retornados
     * desde el webservice)
     */
    public void rellenarComunas() {
        try {
            List<Object> array = srvComuna.getWebServiceComunaSoap().retornaTodasLasComunas().getAnyType();
            cmbComuna.removeAllItems();
            HR.insertarTexto(cmbComuna, "Seleccione...");
            for (Object o : array) {
                Comuna c = ((Comuna) o);
                HR.insertarTexto(cmbComuna, c.getNombre());
            }
        } catch (Exception e) {
            HR.mostrarError("Ocurrió un error cargar las comunas: " + e.getMessage());
        }
    }

    public void cargaInfoUsuario() {
        HR.insertarTexto(txtRun, cliente.getUsuario());
        HR.insertarTexto(txtNombres, cliente.getNombres());
        HR.insertarTexto(txtApaterno, cliente.getApaterno());
        HR.insertarTexto(txtAmaterno, cliente.getAmaterno());
        HR.insertarTexto(txtCorreo, cliente.getEmail());
        HR.insertarTexto(txtTelefono, cliente.getTelefono());
        HR.insertarTexto(txtCelular, cliente.getCelular());
        HR.insertarTexto(txtFax, cliente.getFax());
        HR.insertarTexto(txtDireccion, cliente.getDireccion());
        HR.insertarTexto(txtLatitud, cliente.getLatitud());
        HR.insertarTexto(txtLongitud, cliente.getLongitud());
        //recuperando comuna
        Comuna comu = srvComuna.getWebServiceComunaSoap().buscaComuna(cliente.getComuna());
        if (comu != null) {
            try {
                List<Object> array = srvComuna.getWebServiceComunaSoap().retornaTodasLasComunas().getAnyType();
                cmbComuna.removeAllItems();
                HR.insertarTexto(cmbComuna, comu.getNombre());
                for (Object o : array) {
                    Comuna c = ((Comuna) o);
                    HR.insertarTexto(cmbComuna, c.getNombre());
                }
            } catch (Exception e) {
                HR.mostrarError("Ocurrió un error cargar las comunas: " + e.getMessage());
            }
        }
    }

    public void vaciarCamposTexto() {
        HR.insertarTexto(txtNombres, "");
        HR.insertarTexto(txtApaterno, "");
        HR.insertarTexto(txtAmaterno, "");
        HR.insertarTexto(txtCorreo, "");
        HR.insertarTexto(txtTelefono, "");
        HR.insertarTexto(txtCelular, "");
        HR.insertarTexto(txtFax, "");
        HR.insertarTexto(txtDireccion, "");
        HR.insertarTexto(txtLatitud, "");
        HR.insertarTexto(txtLongitud, "");
        rellenarComunas();
        this.setTitle("Registrar Cliente");
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
        txtRun = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApaterno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAmaterno = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbComuna = new javax.swing.JComboBox<>();
        btnMapas = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtLatitud = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtLongitud = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Cliente");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Información Personal"));

        jLabel1.setText("RUN del Cliente");

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

        jLabel2.setText("Nombres");

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        jLabel3.setText("Apellido Paterno");

        txtApaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApaternoKeyTyped(evt);
            }
        });

        jLabel4.setText("Apellido Materno");

        txtAmaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAmaternoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txtRun)
                    .addComponent(jLabel2)
                    .addComponent(txtNombres)
                    .addComponent(jLabel3)
                    .addComponent(txtApaterno)
                    .addComponent(jLabel4)
                    .addComponent(txtAmaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtApaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Contacto"));

        jLabel5.setText("Correo Electrónico");

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        jLabel6.setText("Teléfono");

        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        jLabel7.setText("Celular");

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel8.setText("Fax");

        txtFax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFaxKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFax, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 142, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de Ubicación"));

        jLabel9.setText("Dirección");

        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel10.setText("Comuna");

        cmbComuna.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbComunaFocusLost(evt);
            }
        });

        btnMapas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map.png"))); // NOI18N
        btnMapas.setText("Comprobar con Google Maps");
        btnMapas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapasActionPerformed(evt);
            }
        });

        jLabel11.setText("Latitud");

        txtLatitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLatitudKeyTyped(evt);
            }
        });

        jLabel12.setText("Longitud");

        txtLongitud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLongitudKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cmbComuna, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMapas, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLatitud)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtLongitud))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbComuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMapas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRunKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRunKeyTyped
        HR.ingresaCaracteresRut(evt);
        HR.largoMaximo(txtRun, 14, evt);
    }//GEN-LAST:event_txtRunKeyTyped

    private void txtRunFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRunFocusLost
        if (!HR.contenido(txtRun).isEmpty()) {
            HR.insertarTexto(txtRun, HRut.formatear(HR.contenido(txtRun)));
            if (!HRut.validar(HR.contenido(txtRun))) {
                HR.mostrarError("Rut ingresado no es válido");
                HR.seleccionarTodo(txtRun);
                HR.focus(txtRun);
            } else if (preview != true) {
                if (srvCliente.getWebServiceClienteSoap().buscaClientePorRun(HR.contenido(txtRun)).getId() != 0) {
                    int valor = HR.preguntar("El cliente ya se encuentra registrado... ¿Desea actualizar sus datos?");
                    if (valor == 0) {
                        this.cliente = srvCliente.getWebServiceClienteSoap().buscaClientePorRun(HR.contenido(txtRun));
                        this.setTitle("Actualizar Cliente");
                        HR.insertarTexto(btnGuardar, "Actualizar");
                        cargaInfoUsuario();
                    }
                } else {
                    this.vaciarCamposTexto();
                }
            }
        }
    }//GEN-LAST:event_txtRunFocusLost

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        HR.largoMaximo(txtNombres, 125, evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApaternoKeyTyped
        HR.largoMaximo(txtApaterno, 75, evt);
    }//GEN-LAST:event_txtApaternoKeyTyped

    private void txtAmaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAmaternoKeyTyped
        HR.largoMaximo(txtAmaterno, 75, evt);
    }//GEN-LAST:event_txtAmaternoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        HR.largoMaximo(txtCorreo, 255, evt);
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if (!HR.contenido(txtCorreo).isEmpty()) {
            if (!HCorreo.validarEmail(HR.contenido(txtCorreo))) {
                HR.mostrarError("La dirección de correo electrónico no es vaálida");
                HR.seleccionarTodo(txtCorreo);
                HR.focus(txtCorreo);
            }
        }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        HR.ingresaSoloNumeros(evt);
        HR.largoMaximo(txtTelefono, 12, evt);
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
        HR.ingresaSoloNumeros(evt);
        HR.largoMaximo(txtCelular, 12, evt);
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtFaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFaxKeyTyped
        HR.ingresaSoloNumeros(evt);
        HR.largoMaximo(txtFax, 12, evt);
    }//GEN-LAST:event_txtFaxKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        HR.largoMaximo(txtDireccion, 255, evt);
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtLatitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLatitudKeyTyped
        HR.largoMaximo(txtLatitud, 12, evt);
        HR.ingresaCaracteresRut(evt);
    }//GEN-LAST:event_txtLatitudKeyTyped

    private void txtLongitudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLongitudKeyTyped
        HR.largoMaximo(txtLongitud, 12, evt);
        HR.ingresaCaracteresRut(evt);
    }//GEN-LAST:event_txtLongitudKeyTyped

    private void btnMapasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapasActionPerformed
        if (HR.contenido(txtDireccion).isEmpty()) {
            HR.mostrarError("Debe completar el campo de dirección para determinar la latitud y lóngitud");
            HR.focus(txtDireccion);
        } else if (HR.contenido(cmbComuna).compareToIgnoreCase("Seleccione...") == 0) {
            HR.mostrarError("Seleccione la comuna para poder determinar la latitud y longitud");
            HR.focus(cmbComuna);
        } else {
            //determinando
            String direccion = HR.contenido(txtDireccion);
            String comuna = HR.contenido(cmbComuna);
            Geocoding mapa = new Geocoding();
            try {
                Point2D.Double resultado = mapa.getCoordinates(direccion + ", " + comuna + ", Chile");
                HR.insertarTexto(txtLatitud, resultado.getX() + "");
                HR.insertarTexto(txtLongitud, resultado.getY() + "");
                if ((resultado.getX() == 0.0) && (resultado.getY() == 0.0)) {
                    HR.mostrarError("La dirección no pudo ser encontrada");
                    MapaSeleccionar mapaSel = new MapaSeleccionar(this);
                    /*HR.seleccionarTodo(txtDireccion);
                        HR.focus(txtDireccion);*/
                } else {
                    String url = "https://www.google.cl/maps/place/" + resultado.getX() + "," + resultado.getY() + "";
                    try {
                        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                    } catch (Exception err) {
                        HR.mostrarError("Error: " + err);
                    }
                }
            } catch (Exception e) {
                HR.mostrarError("Imposible determinar las coordenadas con la información proporcionada: " + direccion + ", " + comuna + ", Chile");
            }
            //
        }
    }//GEN-LAST:event_btnMapasActionPerformed

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        HR.focus(cmbComuna);
    }//GEN-LAST:event_txtDireccionFocusLost

    private void cmbComunaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbComunaFocusLost
        HR.focus(btnMapas);
    }//GEN-LAST:event_cmbComunaFocusLost

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (HR.contenido(txtRun).isEmpty()) {
            HR.mostrarError("El run del cliente no ha sido ingresado");
            HR.focus(txtRun);
        } else if (HR.contenido(txtNombres).isEmpty()) {
            HR.mostrarError("Los nombres del cliente no han sido ingresados");
            HR.focus(txtNombres);
        } else if (HR.contenido(txtApaterno).isEmpty()) {
            HR.mostrarError("El apellido paterno del cliente no ha sido ingresado");
            HR.focus(txtApaterno);
        } else if (HR.contenido(txtAmaterno).isEmpty()) {
            HR.mostrarError("El apellido materno del cliente no ha sido ingresado");
            HR.focus(txtAmaterno);
        } else if (HR.contenido(txtCorreo).isEmpty()) {
            HR.mostrarError("El correo electrónico del cliente no ha sido ingresado");
            HR.focus(txtCorreo);
        } else if (HR.contenido(txtTelefono).isEmpty()) {
            HR.mostrarError("El teléfono del cliente no ha sido ingresado");
            HR.focus(txtTelefono);
        } else if (HR.contenido(txtCelular).isEmpty()) {
            HR.mostrarError("El celular del cliente no ha sido ingresado");
            HR.focus(txtCelular);
        } else if (HR.contenido(txtFax).isEmpty()) {
            HR.mostrarError("El fax del cliente no ha sido ingresado");
            HR.focus(txtFax);
        } else if (HR.contenido(txtDireccion).isEmpty()) {
            HR.mostrarError("La dirección del cliente no ha sido ingresada");
            HR.focus(txtFax);
        } else if (HR.contenido(cmbComuna).compareToIgnoreCase("Seleccione...") == 0) {
            HR.mostrarError("Seleccione la comuna del cliente puesto que no ha sido ingresada");
            HR.focus(cmbComuna);
        } else if (HR.contenido(txtLatitud).isEmpty()) {
            HR.mostrarError("No se ha logrado obtener la dirección ingresada para el cliente");
            HR.focus(txtLatitud);
        } else if (HR.contenido(txtLongitud).isEmpty()) {
            HR.mostrarError("No se ha logrado obtener la dirección ingresada para el cliente");
            HR.focus(txtLongitud);
        } else {
            //guardar cliente
            String strRun = HR.contenido(txtRun);
            String strNombres = HR.contenido(txtNombres);
            String strApaterno = HR.contenido(txtApaterno);
            String strAmaterno = HR.contenido(txtAmaterno);
            String strCorreo = HR.contenido(txtCorreo);
            String strTelefono = HR.contenido(txtTelefono);
            String strCelular = HR.contenido(txtCelular);
            String strFax = HR.contenido(txtFax);
            String strDireccion = HR.contenido(txtDireccion);
            String strComuna = HR.contenido(cmbComuna);
            String strLatitud = HR.contenido(txtLatitud);
            String strLongitud = HR.contenido(txtLongitud);

            if (srvCliente.getWebServiceClienteSoap().buscaClientePorRun(strRun).getId() == 0) {
                Comuna cm = srvComuna.getWebServiceComunaSoap().buscaComunaPorNombre(strComuna);
                try {
                    Clientes ca = new Clientes();
                    ca.setId(0);
                    ca.setUsuario(strRun);
                    ca.setNombres(strNombres);
                    ca.setApaterno(strApaterno);
                    ca.setAmaterno(strAmaterno);
                    ca.setEmail(strCorreo);
                    ca.setTelefono(strTelefono);
                    ca.setCelular(strCelular);
                    ca.setFax(strFax);
                    ca.setDireccion(strDireccion);
                    ca.setComuna(cm.getId());
                    ca.setLatitud(strLatitud);
                    ca.setLongitud(strLongitud);

                    if (HR.contenido(btnGuardar).compareToIgnoreCase("guardar") == 0) {
                        int password = ((int) (Math.random() * 100000 + 0));
                        ca.setContrasena(password + "");
                        if (srvCliente.getWebServiceClienteSoap().guardarCliente(ca)) {
                            HR.mostrarMensaje("El cliente ha sido registrado.");
                            vaciarCamposTexto();
                            this.dispose();
                        } else {
                            HR.mostrarError("Ocurrió un problema al registrar al cliente");
                        }
                    }
                } catch (Exception e) {
                    HR.mostrarErrorException(e);
                }
            } else if (HR.contenido(btnGuardar).compareToIgnoreCase("Actualizar") == 0) {
                
                    Comuna cm = srvComuna.getWebServiceComunaSoap().buscaComunaPorNombre(strComuna);
                    cliente.setUsuario(strRun);
                    cliente.setNombres(strNombres);
                    cliente.setApaterno(strApaterno);
                    cliente.setAmaterno(strAmaterno);
                    cliente.setEmail(strCorreo);
                    cliente.setTelefono(strTelefono);
                    cliente.setCelular(strCelular);
                    cliente.setFax(strFax);
                    cliente.setDireccion(strDireccion);
                    cliente.setComuna(cm.getId());
                    cliente.setLatitud(strLatitud);
                    cliente.setLongitud(strLongitud);
                    
                if (srvCliente.getWebServiceClienteSoap().actualizaCliente(cliente)) {
                    HR.mostrarMensaje("El cliente ha sido actualizado");
                    vaciarCamposTexto();
                    this.dispose();
                } else {
                    HR.mostrarError("Ocurrió un problema al actualizar al cliente");
                }
            } else {
                HR.mostrarError("El cliente con RUN " + strRun + " ya está registrado!");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMapas;
    private javax.swing.JComboBox<String> cmbComuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtAmaterno;
    private javax.swing.JTextField txtApaterno;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtRun;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
