/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.presentacion.splash;

import cl.alevicmar.login.Logon;
import cl.alevicmar.servicios.WebServicePais;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Victor Manuel Araya
 */
public class Splash extends javax.swing.JPanel {

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
                    lblEstado.setText("Iniciando servicios geográficos...");
                    WebServicePais srvPais = new WebServicePais();
                    error = "0x00000001: No se pudo conectar servicios geográficos";
                    //srvPais.getWebServicePaisSoap().esActivo();
                    i = 25;
                    barCarga.setValue(i);
                    Thread.sleep(800);
                    //productores
                    lblEstado.setText("Cargando información de productores...");
                    //ebServicePais srvPais = new WebServicePais();
                    i = 28;
                    barCarga.setValue(i);
                    Thread.sleep(800);
                    //plataforma de ventas
                    lblEstado.setText("Cargando información de ventas...");
                    //ebServicePais srvPais = new WebServicePais();
                    i = 39;
                    barCarga.setValue(i);
                    Thread.sleep(1200);
                    //productos
                    lblEstado.setText("Recopilando catalogo de productos...");
                    //ebServicePais srvPais = new WebServicePais();
                    i = 46;
                    barCarga.setValue(i);
                    Thread.sleep(1800);
                    i = 59;
                    barCarga.setValue(i);
                    //google maps
                    lblEstado.setText("Cargando librerias de google maps...");
                    //ebServicePais srvPais = new WebServicePais();
                    i = 68;
                    barCarga.setValue(i);
                    Thread.sleep(1330);
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
                Logon logon = new Logon();
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
