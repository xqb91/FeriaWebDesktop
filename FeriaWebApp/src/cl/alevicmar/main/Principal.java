package cl.alevicmar.main;

import cl.alevicmar.login.LockWindow;
import cl.alevicmar.login.Logon;
import cl.alevicmar.menuArchivo.CambiarPassword;
import cl.alevicmar.menuArchivo.Perfil;
import cl.alevicmar.menuAyuda.AcercaDe;
import cl.alevicmar.menuClientes.AdministrarClientes;
import cl.alevicmar.menuClientes.CambiarPasswordCliente;
import cl.alevicmar.menuClientes.RegistrarCliente;
import cl.alevicmar.productos.AdministrarProductos;
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
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import maps.java.Geocoding;

public class Principal extends javax.swing.JFrame {
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
    

    public Principal() {
        initComponents();
        //centrando ventana
        this.setLocationRelativeTo(null);
        //seteando el logotipo de la ventana de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cl/alevicmar/imagenes/icono.png"));
        setIconImage(icon);
        
        //inicializacion manual
        srvAdministrador        = new WebServiceAdministrador();
        srvAgrupacion           = new WebServiceAgrupacion();
        srvCategoria            = new WebServiceCategoria();
        srvCliente              = new WebServiceCliente();
        srvComuna               = new WebServiceComuna();
        srvEgreso               = new WebServiceEgreso();
        srvFamilia              = new WebServiceFamilia();
        srvMetodoPago           = new WebServiceMetodopago();
        srvOrdenVenta           = new WebServiceOrdendeventa();
        srvPais                 = new WebServicePais();
        srvProducto             = new WebServiceProducto();
        srvProductor            = new WebServiceProductor();
        srvProvincia            = new WebServiceProvincia();
        srvRegion               = new WebServiceRegion();
        srvStock                = new WebServiceStock();
        srvUbicacionProductor   = new WebServiceUbicacionProductor();
    
        //servicio de mapas
        mapa                    = new Geocoding();
        
        user                    = new Administrador();
        user.setUsuario("00.000.000-0");
        user.setNombres("Usuario");
        user.setApaterno("de");
        user.setAmaterno("prueba");
        
        this.setTitle("Feria Web Desktop Client - Conectado como: "+user.getUsuario()+"@feriaweb ("+user.getNombres()+" "+user.getApaterno()+" "+user.getAmaterno()+")");
    }
    
    public Principal(Component com, WebServiceAdministrador srvAdministrador, WebServiceAgrupacion srvAgrupacion, WebServiceCategoria srvCategoria, WebServiceCliente srvCliente, WebServiceComuna srvComuna, WebServiceEgreso srvEgreso, WebServiceFamilia srvFamilia, WebServiceMetodopago srvMetodoPago, WebServiceOrdendeventa srvOrdenVenta, WebServicePais srvPais, WebServiceProducto srvProducto, WebServiceProductor srvProductor, WebServiceProvincia srvProvincia, WebServiceRegion srvRegion, WebServiceStock srvStock, WebServiceUbicacionProductor srvUbicacionProductor, Geocoding mapa, Administrador user) {
        initComponents();
        //centrando ventana
        this.setLocationRelativeTo(null);
        //seteando el logotipo de la ventana de la aplicacion
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cl/alevicmar/imagenes/icono.png"));
        setIconImage(icon);
        
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
        
        this.setTitle("Feria Web Desktop Client - Conectado como: "+user.getUsuario()+"@feriaweb ("+user.getNombres()+" "+user.getApaterno()+" "+user.getAmaterno()+")");
    }

    public WebServiceAgrupacion getSrvAgrupacion() {
        return srvAgrupacion;
    }

    public void setSrvAgrupacion(WebServiceAgrupacion srvAgrupacion) {
        this.srvAgrupacion = srvAgrupacion;
    }

    public WebServiceCategoria getSrvCategoria() {
        return srvCategoria;
    }

    public void setSrvCategoria(WebServiceCategoria srvCategoria) {
        this.srvCategoria = srvCategoria;
    }

    public WebServiceCliente getSrvCliente() {
        return srvCliente;
    }

    public void setSrvCliente(WebServiceCliente srvCliente) {
        this.srvCliente = srvCliente;
    }

    public WebServiceComuna getSrvComuna() {
        return srvComuna;
    }

    public void setSrvComuna(WebServiceComuna srvComuna) {
        this.srvComuna = srvComuna;
    }

    public WebServiceEgreso getSrvEgreso() {
        return srvEgreso;
    }

    public void setSrvEgreso(WebServiceEgreso srvEgreso) {
        this.srvEgreso = srvEgreso;
    }

    public WebServiceFamilia getSrvFamilia() {
        return srvFamilia;
    }

    public void setSrvFamilia(WebServiceFamilia srvFamilia) {
        this.srvFamilia = srvFamilia;
    }

    public WebServiceMetodopago getSrvMetodoPago() {
        return srvMetodoPago;
    }

    public void setSrvMetodoPago(WebServiceMetodopago srvMetodoPago) {
        this.srvMetodoPago = srvMetodoPago;
    }

    public WebServiceOrdendeventa getSrvOrdenVenta() {
        return srvOrdenVenta;
    }

    public void setSrvOrdenVenta(WebServiceOrdendeventa srvOrdenVenta) {
        this.srvOrdenVenta = srvOrdenVenta;
    }

    public WebServicePais getSrvPais() {
        return srvPais;
    }

    public void setSrvPais(WebServicePais srvPais) {
        this.srvPais = srvPais;
    }

    public WebServiceProducto getSrvProducto() {
        return srvProducto;
    }

    public void setSrvProducto(WebServiceProducto srvProducto) {
        this.srvProducto = srvProducto;
    }

    public WebServiceProductor getSrvProductor() {
        return srvProductor;
    }

    public void setSrvProductor(WebServiceProductor srvProductor) {
        this.srvProductor = srvProductor;
    }

    public WebServiceProvincia getSrvProvincia() {
        return srvProvincia;
    }

    public void setSrvProvincia(WebServiceProvincia srvProvincia) {
        this.srvProvincia = srvProvincia;
    }

    public WebServiceRegion getSrvRegion() {
        return srvRegion;
    }

    public void setSrvRegion(WebServiceRegion srvRegion) {
        this.srvRegion = srvRegion;
    }

    public WebServiceStock getSrvStock() {
        return srvStock;
    }

    public void setSrvStock(WebServiceStock srvStock) {
        this.srvStock = srvStock;
    }

    public WebServiceUbicacionProductor getSrvUbicacionProductor() {
        return srvUbicacionProductor;
    }

    public void setSrvUbicacionProductor(WebServiceUbicacionProductor srvUbicacionProductor) {
        this.srvUbicacionProductor = srvUbicacionProductor;
    }

    public Geocoding getMapa() {
        return mapa;
    }

    public void setMapa(Geocoding mapa) {
        this.mapa = mapa;
    }

    public WebServiceAdministrador getSrvAdministrador() {
        return srvAdministrador;
    }

    public void setSrvAdministrador(WebServiceAdministrador srvAdministrador) {
        this.srvAdministrador = srvAdministrador;
    }

    public Administrador getUser() {
        return user;
    }

    public void setUser(Administrador user) {
        this.user = user;
    }
    
    public void setModalVentana(Dialog.ModalExclusionType opcion) {
        this.setModalExclusionType(opcion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        archivoBloquearTerminal = new javax.swing.JMenuItem();
        archivoLogout = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        archivoPerfil = new javax.swing.JMenuItem();
        archivoCambiarContrasena = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        archivoSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        clientesAdminClientes = new javax.swing.JMenuItem();
        clienteRegistrar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        clienteCambiarPassword = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        productosAdministrarProductos = new javax.swing.JMenuItem();
        productosRegistrarProducto = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        ayudaAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Feria Web Desktop Client");
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/imagenes/fondo app escritorio.png"))); // NOI18N

        jMenu1.setText("Archivo");

        archivoBloquearTerminal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        archivoBloquearTerminal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/lock_go.png"))); // NOI18N
        archivoBloquearTerminal.setText("Bloquear Terminal");
        archivoBloquearTerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoBloquearTerminalActionPerformed(evt);
            }
        });
        jMenu1.add(archivoBloquearTerminal);

        archivoLogout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        archivoLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/door_out.png"))); // NOI18N
        archivoLogout.setText("Cerrar Sesión");
        archivoLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(archivoLogout);
        jMenu1.add(jSeparator1);

        archivoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/vcard.png"))); // NOI18N
        archivoPerfil.setText("Mi Perfil");
        archivoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(archivoPerfil);

        archivoCambiarContrasena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/key.png"))); // NOI18N
        archivoCambiarContrasena.setText("Cambiar mi contraseña");
        archivoCambiarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoCambiarContrasenaActionPerformed(evt);
            }
        });
        jMenu1.add(archivoCambiarContrasena);
        jMenu1.add(jSeparator2);

        archivoSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        archivoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/stop.png"))); // NOI18N
        archivoSalir.setText("Salir");
        archivoSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoSalirActionPerformed(evt);
            }
        });
        jMenu1.add(archivoSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Clientes");

        clientesAdminClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/group_link.png"))); // NOI18N
        clientesAdminClientes.setText("Administración de Clientes");
        clientesAdminClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesAdminClientesActionPerformed(evt);
            }
        });
        jMenu2.add(clientesAdminClientes);

        clienteRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/user_add.png"))); // NOI18N
        clienteRegistrar.setText("Registrar Cliente");
        clienteRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteRegistrarActionPerformed(evt);
            }
        });
        jMenu2.add(clienteRegistrar);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_magnify.png"))); // NOI18N
        jMenuItem2.setText("Administración de Ubicación de Clientes");
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator3);

        clienteCambiarPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/key.png"))); // NOI18N
        clienteCambiarPassword.setText("Cambiar Contraseña de Cliente");
        clienteCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteCambiarPasswordActionPerformed(evt);
            }
        });
        jMenu2.add(clienteCambiarPassword);
        jMenu2.add(jSeparator7);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/basket_put.png"))); // NOI18N
        jMenuItem10.setText("Compras del Cliente");
        jMenu2.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/basket.png"))); // NOI18N
        jMenuItem11.setText("Última Canasta");
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Productores");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book.png"))); // NOI18N
        jMenuItem1.setText("Administrar Productores");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_add.png"))); // NOI18N
        jMenuItem4.setText("Registrar Productor");
        jMenu3.add(jMenuItem4);
        jMenu3.add(jSeparator4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_key.png"))); // NOI18N
        jMenuItem3.setText("Cambiar Contraseña de Productor");
        jMenu3.add(jMenuItem3);
        jMenu3.add(jSeparator6);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_open.png"))); // NOI18N
        jMenuItem9.setText("Administrar Agrupaciones Agrícolas");
        jMenu3.add(jMenuItem9);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_next.png"))); // NOI18N
        jMenuItem6.setText("Registrar Agrupación Agrícola");
        jMenu3.add(jMenuItem6);
        jMenu3.add(jSeparator8);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map.png"))); // NOI18N
        jMenuItem12.setText("Administrar Ubicación de Producción");
        jMenu3.add(jMenuItem12);

        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_add.png"))); // NOI18N
        jMenuItem13.setText("Registrar Ubicación de Ubicación");
        jMenu3.add(jMenuItem13);
        jMenu3.add(jSeparator9);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/link.png"))); // NOI18N
        jMenu9.setText("Vincular Productor");

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_link.png"))); // NOI18N
        jMenuItem8.setText("a Agrupación Agrícola");
        jMenu9.add(jMenuItem8);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_go.png"))); // NOI18N
        jMenuItem14.setText("a Ubicación de Producción");
        jMenu9.add(jMenuItem14);

        jMenu3.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/link_break.png"))); // NOI18N
        jMenu10.setText("Desvincular Productor");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_error.png"))); // NOI18N
        jMenuItem7.setText("de Agrupación Agrícola");
        jMenu10.add(jMenuItem7);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_delete.png"))); // NOI18N
        jMenuItem15.setText("de Ubicación de Producción");
        jMenu10.add(jMenuItem15);

        jMenu3.add(jMenu10);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Datos Geográficos");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Productos");

        productosAdministrarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/wrench_orange.png"))); // NOI18N
        productosAdministrarProductos.setText("Administrar Productos");
        productosAdministrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosAdministrarProductosActionPerformed(evt);
            }
        });
        jMenu5.add(productosAdministrarProductos);

        productosRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/add.png"))); // NOI18N
        productosRegistrarProducto.setText("Registrar Producto");
        productosRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productosRegistrarProductoActionPerformed(evt);
            }
        });
        jMenu5.add(productosRegistrarProducto);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Transacciones");

        jMenuItem17.setText("Ordenes de Compra");
        jMenu6.add(jMenuItem17);

        jMenuItem18.setText("Stock de Productos");
        jMenu6.add(jMenuItem18);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Finanzas");

        jMenuItem19.setText("Egresos este mes");
        jMenu7.add(jMenuItem19);

        jMenuItem20.setText("Egresos por Productor");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem20);

        jMenuItem22.setText("Egresos Históricos");
        jMenu7.add(jMenuItem22);
        jMenu7.add(jSeparator5);

        jMenuItem5.setText("Ingresos este mes");
        jMenu7.add(jMenuItem5);

        jMenuItem16.setText("Ingresos por Productor");
        jMenu7.add(jMenuItem16);

        jMenuItem21.setText("Ingresos Históricos");
        jMenu7.add(jMenuItem21);
        jMenu7.add(jSeparator10);

        jMenuItem23.setText("Ordenes de Venta Confirmadas");
        jMenu7.add(jMenuItem23);

        jMenuItem24.setText("Ordenes de Venta No Confirmadas");
        jMenu7.add(jMenuItem24);
        jMenu7.add(jSeparator11);

        jMenuItem25.setText("Balance");
        jMenu7.add(jMenuItem25);

        jMenuItem26.setText("Balance por Fecha");
        jMenu7.add(jMenuItem26);

        jMenuItem27.setText("Balance por Método de Pago");
        jMenu7.add(jMenuItem27);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Ayuda");

        ayudaAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        ayudaAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/information.png"))); // NOI18N
        ayudaAcercaDe.setText("Acerca de");
        ayudaAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaAcercaDeActionPerformed(evt);
            }
        });
        jMenu8.add(ayudaAcercaDe);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoSalirActionPerformed
        int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro de salir de Feria Web Frutos Secos para escritorio? Al confirmar su sesión será cerrada y cualquier cambio no guardado se perderá.", "Feria Web Desktop Client", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(opcion == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_archivoSalirActionPerformed

    private void archivoBloquearTerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoBloquearTerminalActionPerformed
        new LockWindow(this, srvAdministrador, srvAgrupacion, srvCategoria, srvCliente, srvComuna, srvEgreso, srvFamilia, srvMetodoPago, srvOrdenVenta, srvPais, srvProducto, srvProductor, srvProvincia, srvRegion, srvStock, srvUbicacionProductor, mapa, user).setVisible(true);
        this.setModalVentana(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setEnabled(false);
    }//GEN-LAST:event_archivoBloquearTerminalActionPerformed

    private void clientesAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesAdminClientesActionPerformed
        AdministrarClientes admCli = new AdministrarClientes(srvCliente, srvComuna, this);
        admCli.setIconImage(this.getIconImage());
        admCli.setVisible(true);
    }//GEN-LAST:event_clientesAdminClientesActionPerformed

    private void archivoLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoLogoutActionPerformed
        user = null;
        Logon logon = new Logon();
        //entregando webservices
        logon.setSrvAdministrador(srvAdministrador);
        logon.setSrvAgrupacion(srvAgrupacion);
        logon.setSrvCategoria(srvCategoria);
        logon.setSrvCliente(srvCliente);
        logon.setSrvComuna(srvComuna);
        logon.setSrvEgreso(srvEgreso);
        logon.setSrvFamilia(srvFamilia);
        logon.setSrvMetodoPago(srvMetodoPago);
        logon.setSrvOrdenVenta(srvOrdenVenta);
        logon.setSrvPais(srvPais);
        logon.setSrvProducto(srvProducto);
        logon.setSrvProductor(srvProductor);
        logon.setSrvProvincia(srvProvincia);
        logon.setSrvRegion(srvRegion);
        logon.setSrvStock(srvStock);
        logon.setSrvUbicacionProductor(srvUbicacionProductor);

        logon.setMapa(mapa);

        logon.setVisible(true);
        this.dispose();
        System.gc();
    }//GEN-LAST:event_archivoLogoutActionPerformed

    private void archivoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoPerfilActionPerformed
        Perfil perfil = new Perfil(this, srvAdministrador, user);
        perfil.setIconImage(this.getIconImage());
        perfil.setVisible(true);
    }//GEN-LAST:event_archivoPerfilActionPerformed

    private void clienteRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteRegistrarActionPerformed
        RegistrarCliente regCli = new RegistrarCliente(this, srvCliente, srvComuna);
        regCli.setVisible(true);
    }//GEN-LAST:event_clienteRegistrarActionPerformed

    private void archivoCambiarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoCambiarContrasenaActionPerformed
        new CambiarPassword(this, srvAdministrador, user).setVisible(true);
    }//GEN-LAST:event_archivoCambiarContrasenaActionPerformed

    private void clienteCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteCambiarPasswordActionPerformed
        new CambiarPasswordCliente(srvCliente, this).setVisible(true);
    }//GEN-LAST:event_clienteCambiarPasswordActionPerformed

    private void productosAdministrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosAdministrarProductosActionPerformed
        AdministrarProductos admProd = new AdministrarProductos(srvProducto, srvCategoria, srvFamilia, this);
        admProd.setIconImage(this.getIconImage());
        admProd.setVisible(true);
    }//GEN-LAST:event_productosAdministrarProductosActionPerformed

    private void productosRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosRegistrarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productosRegistrarProductoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void ayudaAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaAcercaDeActionPerformed
        new AcercaDe(this).setVisible(true);
    }//GEN-LAST:event_ayudaAcercaDeActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem archivoBloquearTerminal;
    private javax.swing.JMenuItem archivoCambiarContrasena;
    private javax.swing.JMenuItem archivoLogout;
    private javax.swing.JMenuItem archivoPerfil;
    private javax.swing.JMenuItem archivoSalir;
    private javax.swing.JMenuItem ayudaAcercaDe;
    private javax.swing.JMenuItem clienteCambiarPassword;
    private javax.swing.JMenuItem clienteRegistrar;
    private javax.swing.JMenuItem clientesAdminClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem productosAdministrarProductos;
    private javax.swing.JMenuItem productosRegistrarProducto;
    // End of variables declaration//GEN-END:variables
}
