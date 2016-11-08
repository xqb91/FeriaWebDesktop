/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.presentacion.splash;

import cl.alevicmar.login.Logon;
import cl.alevicmar.services.administrador.WebServiceAdministrador;

//importando webservices
import cl.alevicmar.services.agrupacion.*;
import cl.alevicmar.services.categoria.*;
import cl.alevicmar.services.cliente.*;
import cl.alevicmar.services.comuna.*;
import cl.alevicmar.services.egreso.*;
import cl.alevicmar.services.familia.*;
import cl.alevicmar.services.metodopago.*;
import cl.alevicmar.services.ordenventa.*;
import cl.alevicmar.services.pais.*;
import cl.alevicmar.services.producto.*;
import cl.alevicmar.services.productor.*;
import cl.alevicmar.services.provincia.*;
import cl.alevicmar.services.region.*;
import cl.alevicmar.services.stock.*;
import cl.alevicmar.services.ubicacionproductor.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import maps.java.Geocoding;

/**
 *
 * @author Victor Manuel Araya
 */
public class Splash extends javax.swing.JPanel {

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
    
    ImageIcon imagen; // imagen para mostrar 
    BorderLayout esquema;
    String error;
    public Splash() {
        initComponents();
        //tipo de ventana
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
                javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        lblEstado.setForeground(Color.BLACK);   
        Random rnd = new Random();
        int numero = (int) (rnd.nextDouble() * 3 + 1);
        if(numero == 1) {
            imagen = new ImageIcon(getClass().getResource("/cl/alevicmar/imagenes/splash.png")); // se obtiene la imagen 
        }else if(numero == 2) {
            imagen = new ImageIcon(getClass().getResource("/cl/alevicmar/imagenes/splash.png")); // se obtiene la imagen 
        }else{
            imagen = new ImageIcon(getClass().getResource("/cl/alevicmar/imagenes/splash.png")); // se obtiene la imagen 
        }
        this.setSize(imagen.getIconWidth(), imagen.getIconHeight()); // se establece el tamaño del panel 
        // mediante la dimencion de la imagen ancho y alto
    }

        @Override
    public void paintComponent(Graphics g){ // metodo paintComponent para dibujar la imagen 
        super.paintComponent(g); // para que el panel se despligue sin errores 
        g.drawImage(imagen.getImage(), 0, 0, imagen.getIconWidth(), imagen.getIconHeight(), this); // se dibuja la imagen 
        this.setOpaque(false); // se establece el panel transparente para que se pueda ver la imagen 
    } 

    public void comprobacionInicial() throws InterruptedException{ 
        
        // motodo para controlar la barra 
        for(int i = 0; i<=100; i++){ 
            // establece el recorrido de la barra de progreso 
            Thread.sleep(40); 
            barCarga.setForeground(Color.RED); // color de la barra de progreso 
            barCarga.setValue(i); // se asigna el valor de la barra 
            if (i == 20) {
                lblEstado.setText("Estableciendo conexión al servidor...");
                Thread.sleep(500); 
                try {
                    
                    //instanciando servicios geográficos ------------------------------------------------
                    //seteando estado en splash!
                    lblEstado.setText("Iniciando servicios geográficos...");
                    
                    error = "0x00000001: No se pudo conectar servicios geográficos de pais";
                    srvPais              = new WebServicePais();
                    error = "0x00000002: No se pudo conectar servicios geográficos de región";
                    srvRegion          = new WebServiceRegion();
                    error = "0x00000003: No se pudo conectar servicios geográficos de provincia";
                    srvProvincia    = new WebServiceProvincia();
                    error = "0x00000004: No se pudo conectar servicios geográficos de comuna";
                    srvComuna          = new WebServiceComuna();
                    
                    //comprobando servicios geograficos ------------------------------------------------
                    error = "0x00000005: No se pudo verificar conectividad con servicio de paises";
                    srvPais.getWebServicePaisSoap().esActivo();
                    error = "0x00000006: No se pudo verificar conectividad con servicio de regiones";
                    srvRegion.getWebServiceRegionSoap().esActivo();
                    error = "0x00000007: No se pudo verificar conectividad con servicio de provincias";
                    srvProvincia.getWebServiceProvinciaSoap().esActivo();
                    error = "0x00000008: No se pudo verificar conectividad con servicio de comunas";
                    srvComuna.getWebServiceComunaSoap().esActivo();
                    i = 25;
                    barCarga.setValue(i);
                    Thread.sleep(800);
                    
                    
                    //instanciando servicios de productores ----------------------------------------------
                    //seteando estado en splash!
                    lblEstado.setText("Cargando información de productores...");
                    
                    error = "0x00000009: No se pudo conectar servicios de agrupación de productores";
                    srvAgrupacion                  = new WebServiceAgrupacion();
                    error = "0x0000000a: No se pudo conectar servicios de productores";
                    srvProductor                    = new WebServiceProductor();
                    error = "0x0000000b: No se pudo conectar servicios de ubicacion de productores";
                    srvUbicacionProductor  = new WebServiceUbicacionProductor();
                    //comprobando servicios de productores -----------------------------------------------
                    error = "0x0000000c: No se pudo verificar conectividad con servicio de agrupación de productores";
                    srvAgrupacion.getWebServiceAgrupacionSoap().esActivo();
                    error = "0x0000000d: No se pudo verificar conectividad con servicio de productores";
                    srvProductor.getWebServiceProductorSoap().esActivo();
                    error = "0x0000000e: No se pudo verificar conectividad con servicio de ubicación de productores";
                    srvUbicacionProductor.getWebServiceUbicacionProductorSoap().esActivo();
                    
                    i = 28;
                    barCarga.setValue(i);
                    Thread.sleep(800);
                    

                    //Instanciando plataforma de ventas --------------------------------------------------
                    //seteando estado en splash!
                    lblEstado.setText("Cargando información de ventas...");
                    
                    error = "0x0000000f: No se pudo conectar servicios de egresos de ventas";
                    srvEgreso              = new WebServiceEgreso();
                    error = "0x00000010: No se pudo conectar servicios de método de pagos de ventas";
                    srvMetodoPago      = new WebServiceMetodopago();
                    error = "0x00000011: No se pudo conectar servicios de orden de ventas";
                    srvOrdenVenta    = new WebServiceOrdendeventa();
                    error = "0x00000012: No se pudo conectar servicios de stock de ventas";
                    WebServiceStock srvStock                = new WebServiceStock();
                    //comprobando servicios de ventas ------------------------------------------------------
                    error = "0x00000013: No se pudo verificar conectividad con servicio de egresos de ventas";
                    srvEgreso.getWebServiceEgresoSoap().esActivo();
                    error = "0x00000014: No se pudo verificar conectividad con servicio de metodos de pago de ventas";
                    srvMetodoPago.getWebServiceMetodopagoSoap().esActivo();
                    error = "0x00000015: No se pudo verificar conectividad con servicio de ordenes de ventas";
                    srvOrdenVenta.getWebServiceOrdendeventaSoap().esActivo();
                    error = "0x00000016: No se pudo verificar conectividad con servicio de stock de ventas";
                    srvStock.getWebServiceStockSoap().esActivo();
                    
                    i = 39;
                    barCarga.setValue(i);
                    Thread.sleep(1200);
                    

                    //Instanciando plataforma de productos ---------------------------------------------------
                    //seteando estado en splash!
                    lblEstado.setText("Recopilando catalogo de productos...");
                    
                    error = "0x00000017: No se pudo conectar servicios de categoria de productos";
                    srvCategoria        = new WebServiceCategoria();
                    error = "0x00000018: No se pudo conectar servicios de familia de productos";
                    srvFamilia            = new WebServiceFamilia();
                    error = "0x00000019: No se pudo conectar servicios de listado de productos";
                    srvProducto          = new WebServiceProducto();
                    //comprobando servicios de productos -----------------------------------------------------
                    error = "0x0000001a: No se pudo verificar los servicios de categoria de productos";
                    srvCategoria.getWebServiceCategoriaSoap().esActivo();
                    error = "0x0000001b: No se pudo verificar los servicios de familia de productos";
                    srvFamilia.getWebServiceFamiliaSoap().esActivo();
                    error = "0x0000001c: No se pudo verificar los servicios de listado de productos";
                    srvProducto.getWebServiceProductoSoap().esActivo();
                    i = 46;
                    barCarga.setValue(i);
                    Thread.sleep(1800);
                    i = 59;
                    barCarga.setValue(i);
                    
                    //Instanciando plataforma de administracion de clientes -----------------------------------
                    //seteando estado en splash!
                    lblEstado.setText("Carga plataforma de administración...");
                    
                    error = "0x0000001d: No se pudo conectar los servicios de listado de clientes";
                    srvCliente            = new WebServiceCliente();
                    //comprobando servicios de administracion de clientes -------------------------------------
                    error = "0x0000001f: No se pudo verificar los servicios de listado de clientes";
                    srvCliente.getWebServiceClienteSoap().esActivo();
                    i = 62;
                    barCarga.setValue(i);
                    Thread.sleep(1800);
                    
                    //google maps -----------------------------------------------------------------------------
                    lblEstado.setText("Arrancando motor de Google™ Maps...");
                    error = "0x00000020: No se pudo arrancar el motor de Google™ Maps";
                    mapa = new Geocoding();
                    error = "0x00000021: Imposible establecer punto de referencia inicial de Google™ Maps";
                    Point2D.Double resultado = mapa.getCoordinates("Santiago, Plaza de Armas");
                    i = 68;
                    barCarga.setValue(i);
                    Thread.sleep(2000);
                    
                    //google maps -----------------------------------------------------------------------------
                    lblEstado.setText("Enlazando Desktop Client Admin...");
                    error = "0x00000022: No pudo conectarse al sistema de administración";
                    srvAdministrador = new WebServiceAdministrador();
                    error = "0x00000023: Se estableció conexión con el servidor pero el servicio de administradores no está activo";
                    srvAdministrador.getWebServiceAdministradorSoap().esActivo();
                    i = 75;
                    barCarga.setValue(i);
                    Thread.sleep(2000);
                    
                }catch(Exception e) {
                    String mensaje = "<html><body><div width='300px' align='justify'>Feria Web Desktop Client ha detectado un problema mientras intentaba inicarse: <br /><br /><em>"+e.getMessage()+"<br /><b>Error "+error+"</b></em><br /><br />Por favor verifique su conexión a internet o bien contacte a Alevicmar Software Chile para obtener soporte técnico.</div></body></html>";
                    JLabel mensajeLabel = new JLabel(mensaje);
                    JOptionPane.showMessageDialog(null, mensajeLabel, "Feria Web Desktop Client", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
                lblEstado.setText("Conexión establecida...");
            }
            if (i == 85) {
                lblEstado.setText("Preparando aplicación...");
                Thread.sleep(1330);
            }
            
            if(i == 95) {
                lblEstado.setText("Iniciando...");
            }
            if(i == 100) {
                //instanciando logon
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
            }
        } 
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barCarga = new javax.swing.JProgressBar();
        lblEstado = new javax.swing.JLabel();

        lblEstado.setText("Iniciando el Software");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(barCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(lblEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 274, Short.MAX_VALUE)
                .addComponent(barCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblEstado))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barCarga;
    private javax.swing.JLabel lblEstado;
    // End of variables declaration//GEN-END:variables
}
