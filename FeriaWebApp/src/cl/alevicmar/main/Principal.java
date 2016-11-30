package cl.alevicmar.main;

import cl.alevicmar.finanzas.Balances;
import cl.alevicmar.finanzas.EgresosHistoricos;
import cl.alevicmar.finanzas.IngresosHistoricos;
import cl.alevicmar.finanzas.OrdenesVentaConfirmadas;
import cl.alevicmar.login.LockWindow;
import cl.alevicmar.login.Logon;
import cl.alevicmar.menuArchivo.CambiarPassword;
import cl.alevicmar.menuArchivo.Perfil;
import cl.alevicmar.menuAyuda.AcercaDe;
import cl.alevicmar.menuClientes.AdministrarClientes;
import cl.alevicmar.menuClientes.CambiarPasswordCliente;
import cl.alevicmar.menuClientes.RegistrarCliente;
import cl.alevicmar.productores.AdministrarAgrupacionAgricola;
import cl.alevicmar.productores.AdministrarProductores;
import cl.alevicmar.productores.AdministrarUbicacion;
import cl.alevicmar.productores.AsociarProductorAgrupacion;
import cl.alevicmar.productores.AsociarUbicacionProduccion;
import cl.alevicmar.productores.CambiarPasswordProductor;
import cl.alevicmar.productores.DesvincularProductorAgrupacion;
import cl.alevicmar.productores.DesvincularUbicacionProduccion;
import cl.alevicmar.productores.RegistrarAgrupacionAgricola;
import cl.alevicmar.productores.RegistrarProductor;
import cl.alevicmar.productores.RegistrarUbicacion;
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
        productoresAdminProductores = new javax.swing.JMenuItem();
        productoresRegistrarProductor = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        productorCambiarPassword = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        productoresAdminAgrupacion = new javax.swing.JMenuItem();
        productoresRegistrarAgrupacion = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        productoresAdminUbicacion = new javax.swing.JMenuItem();
        productoresRegistrarUbicacion = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        productorVincularAgrupacion = new javax.swing.JMenuItem();
        productoresVincularUbicacion = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        productoresDesvincularAgrupacion = new javax.swing.JMenuItem();
        productoresDesvincularUbicacion = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        productosAdministrarProductos = new javax.swing.JMenuItem();
        productosRegistrarProducto = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        finanzasEgresos = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        finanzasIngresos = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        finanzasOrdenVenta = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        finanzasBalances = new javax.swing.JMenuItem();
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

        productoresAdminProductores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book.png"))); // NOI18N
        productoresAdminProductores.setText("Administrar Productores");
        productoresAdminProductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresAdminProductoresActionPerformed(evt);
            }
        });
        jMenu3.add(productoresAdminProductores);

        productoresRegistrarProductor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_add.png"))); // NOI18N
        productoresRegistrarProductor.setText("Registrar Productor");
        productoresRegistrarProductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresRegistrarProductorActionPerformed(evt);
            }
        });
        jMenu3.add(productoresRegistrarProductor);
        jMenu3.add(jSeparator4);

        productorCambiarPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_key.png"))); // NOI18N
        productorCambiarPassword.setText("Cambiar Contraseña de Productor");
        productorCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productorCambiarPasswordActionPerformed(evt);
            }
        });
        jMenu3.add(productorCambiarPassword);
        jMenu3.add(jSeparator6);

        productoresAdminAgrupacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_open.png"))); // NOI18N
        productoresAdminAgrupacion.setText("Administrar Agrupaciones Agrícolas");
        productoresAdminAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresAdminAgrupacionActionPerformed(evt);
            }
        });
        jMenu3.add(productoresAdminAgrupacion);

        productoresRegistrarAgrupacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_next.png"))); // NOI18N
        productoresRegistrarAgrupacion.setText("Registrar Agrupación Agrícola");
        productoresRegistrarAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresRegistrarAgrupacionActionPerformed(evt);
            }
        });
        jMenu3.add(productoresRegistrarAgrupacion);
        jMenu3.add(jSeparator8);

        productoresAdminUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map.png"))); // NOI18N
        productoresAdminUbicacion.setText("Administrar Ubicación de Producción");
        productoresAdminUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresAdminUbicacionActionPerformed(evt);
            }
        });
        jMenu3.add(productoresAdminUbicacion);

        productoresRegistrarUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_add.png"))); // NOI18N
        productoresRegistrarUbicacion.setText("Registrar Ubicación de Producción");
        productoresRegistrarUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresRegistrarUbicacionActionPerformed(evt);
            }
        });
        jMenu3.add(productoresRegistrarUbicacion);
        jMenu3.add(jSeparator9);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/link.png"))); // NOI18N
        jMenu9.setText("Vincular Productor");

        productorVincularAgrupacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_link.png"))); // NOI18N
        productorVincularAgrupacion.setText("a Agrupación Agrícola Existente");
        productorVincularAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productorVincularAgrupacionActionPerformed(evt);
            }
        });
        jMenu9.add(productorVincularAgrupacion);

        productoresVincularUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_go.png"))); // NOI18N
        productoresVincularUbicacion.setText("a Ubicación de Producción Existente");
        productoresVincularUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresVincularUbicacionActionPerformed(evt);
            }
        });
        jMenu9.add(productoresVincularUbicacion);

        jMenu3.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/link_break.png"))); // NOI18N
        jMenu10.setText("Desvincular Productor");

        productoresDesvincularAgrupacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/book_error.png"))); // NOI18N
        productoresDesvincularAgrupacion.setText("de Agrupación Agrícola");
        productoresDesvincularAgrupacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresDesvincularAgrupacionActionPerformed(evt);
            }
        });
        jMenu10.add(productoresDesvincularAgrupacion);

        productoresDesvincularUbicacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/map_delete.png"))); // NOI18N
        productoresDesvincularUbicacion.setText("de Ubicación de Producción");
        productoresDesvincularUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoresDesvincularUbicacionActionPerformed(evt);
            }
        });
        jMenu10.add(productoresDesvincularUbicacion);

        jMenu3.add(jMenu10);

        jMenuBar1.add(jMenu3);

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

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/coins.png"))); // NOI18N
        jMenuItem17.setText("Ordenes de Compra");
        jMenu6.add(jMenuItem17);

        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/package.png"))); // NOI18N
        jMenuItem18.setText("Stock de Productos");
        jMenu6.add(jMenuItem18);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Finanzas");

        finanzasEgresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/table.png"))); // NOI18N
        finanzasEgresos.setText("Egresos");
        finanzasEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finanzasEgresosActionPerformed(evt);
            }
        });
        jMenu7.add(finanzasEgresos);
        jMenu7.add(jSeparator5);

        finanzasIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/table_go.png"))); // NOI18N
        finanzasIngresos.setText("Ingresos");
        finanzasIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finanzasIngresosActionPerformed(evt);
            }
        });
        jMenu7.add(finanzasIngresos);
        jMenu7.add(jSeparator10);

        finanzasOrdenVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/coins_add.png"))); // NOI18N
        finanzasOrdenVenta.setText("Ordenes de Venta con/sin confirmar");
        finanzasOrdenVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finanzasOrdenVentaActionPerformed(evt);
            }
        });
        jMenu7.add(finanzasOrdenVenta);
        jMenu7.add(jSeparator11);

        finanzasBalances.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cl/alevicmar/icons/shape_align_left.png"))); // NOI18N
        finanzasBalances.setText("Balances");
        finanzasBalances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finanzasBalancesActionPerformed(evt);
            }
        });
        jMenu7.add(finanzasBalances);

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
        admProd.setVisible(true);
    }//GEN-LAST:event_productosAdministrarProductosActionPerformed

    private void productosRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productosRegistrarProductoActionPerformed
        RegistrarCliente regCli = new RegistrarCliente(this, srvCliente, srvComuna);
        regCli.setVisible(true);
    }//GEN-LAST:event_productosRegistrarProductoActionPerformed

    private void productoresAdminProductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresAdminProductoresActionPerformed
        new AdministrarProductores(srvProductor, srvUbicacionProductor, srvAgrupacion, this).setVisible(true);
    }//GEN-LAST:event_productoresAdminProductoresActionPerformed

    private void ayudaAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaAcercaDeActionPerformed
        new AcercaDe(this).setVisible(true);
    }//GEN-LAST:event_ayudaAcercaDeActionPerformed

    private void productoresVincularUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresVincularUbicacionActionPerformed
        new AsociarUbicacionProduccion(srvProductor, srvUbicacionProductor, srvComuna, this).setVisible(true);
    }//GEN-LAST:event_productoresVincularUbicacionActionPerformed

    private void productoresRegistrarProductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresRegistrarProductorActionPerformed
        new RegistrarProductor(srvProductor, this).setVisible(true);
    }//GEN-LAST:event_productoresRegistrarProductorActionPerformed

    private void productorCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productorCambiarPasswordActionPerformed
        new CambiarPasswordProductor(srvProductor, this).setVisible(true);
    }//GEN-LAST:event_productorCambiarPasswordActionPerformed

    private void productoresAdminAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresAdminAgrupacionActionPerformed
        new AdministrarAgrupacionAgricola(srvAgrupacion, srvComuna, this).setVisible(true);
    }//GEN-LAST:event_productoresAdminAgrupacionActionPerformed

    private void productoresRegistrarAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresRegistrarAgrupacionActionPerformed
        new RegistrarAgrupacionAgricola(srvAgrupacion, srvComuna, this).setVisible(true);
    }//GEN-LAST:event_productoresRegistrarAgrupacionActionPerformed

    private void productoresAdminUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresAdminUbicacionActionPerformed
        new AdministrarUbicacion().setVisible(true);
    }//GEN-LAST:event_productoresAdminUbicacionActionPerformed

    private void productoresRegistrarUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresRegistrarUbicacionActionPerformed
        new RegistrarUbicacion(srvProductor, srvUbicacionProductor, srvComuna, this).setVisible(true);
    }//GEN-LAST:event_productoresRegistrarUbicacionActionPerformed

    private void productorVincularAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productorVincularAgrupacionActionPerformed
        new AsociarProductorAgrupacion(srvProductor, srvAgrupacion, this, srvComuna).setVisible(true);
    }//GEN-LAST:event_productorVincularAgrupacionActionPerformed

    private void productoresDesvincularAgrupacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresDesvincularAgrupacionActionPerformed
        new DesvincularProductorAgrupacion().setVisible(true);
    }//GEN-LAST:event_productoresDesvincularAgrupacionActionPerformed

    private void productoresDesvincularUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoresDesvincularUbicacionActionPerformed
        new DesvincularUbicacionProduccion().setVisible(true);
    }//GEN-LAST:event_productoresDesvincularUbicacionActionPerformed

    private void finanzasOrdenVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finanzasOrdenVentaActionPerformed
        // TODO add your handling code here:
        OrdenesVentaConfirmadas ovc = new OrdenesVentaConfirmadas();
        ovc.setVisible(true);
    }//GEN-LAST:event_finanzasOrdenVentaActionPerformed

    private void finanzasBalancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finanzasBalancesActionPerformed
        // TODO add your handling code here:
        Balances bb = new Balances();
        bb.setVisible(true);
    }//GEN-LAST:event_finanzasBalancesActionPerformed

    private void finanzasEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finanzasEgresosActionPerformed
        // TODO add your handling code here:
        EgresosHistoricos eh = new EgresosHistoricos();
        eh.setVisible(true);
    }//GEN-LAST:event_finanzasEgresosActionPerformed

    private void finanzasIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finanzasIngresosActionPerformed
        // TODO add your handling code here:
        IngresosHistoricos ih = new IngresosHistoricos();
        ih.setVisible(true);
    }//GEN-LAST:event_finanzasIngresosActionPerformed

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
    private javax.swing.JMenuItem finanzasBalances;
    private javax.swing.JMenuItem finanzasEgresos;
    private javax.swing.JMenuItem finanzasIngresos;
    private javax.swing.JMenuItem finanzasOrdenVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
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
    private javax.swing.JMenuItem productorCambiarPassword;
    private javax.swing.JMenuItem productorVincularAgrupacion;
    private javax.swing.JMenuItem productoresAdminAgrupacion;
    private javax.swing.JMenuItem productoresAdminProductores;
    private javax.swing.JMenuItem productoresAdminUbicacion;
    private javax.swing.JMenuItem productoresDesvincularAgrupacion;
    private javax.swing.JMenuItem productoresDesvincularUbicacion;
    private javax.swing.JMenuItem productoresRegistrarAgrupacion;
    private javax.swing.JMenuItem productoresRegistrarProductor;
    private javax.swing.JMenuItem productoresRegistrarUbicacion;
    private javax.swing.JMenuItem productoresVincularUbicacion;
    private javax.swing.JMenuItem productosAdministrarProductos;
    private javax.swing.JMenuItem productosRegistrarProducto;
    // End of variables declaration//GEN-END:variables
}
