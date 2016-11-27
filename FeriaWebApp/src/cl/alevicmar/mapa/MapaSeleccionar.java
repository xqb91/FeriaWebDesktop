/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.mapa;

import cl.alevicmar.menuClientes.RegistrarCliente;
import cl.alevicmar.productores.RegistrarUbicacion;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
/**
 * The sample demonstrates how to create Browser instance, embed it, display and load
 * specified URL.
 */
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class MapaSeleccionar {
    public static final int MIN_ZOOM = 0;
    public static final int MAX_ZOOM = 21;
    public static Component com = null;
    private static int zoomValue = 13;
    private static JFrame frame = null;
    public MapaSeleccionar(Component com) {
        this.com = com;
        String[] args = {"", ""};
        this.main(args);
    }
   
   

    public static void main(String[] args) {
       final Browser browser = new Browser();
       BrowserView browserView = new BrowserView(browser);

       JButton zoomInButton = new JButton("Acercar");
       zoomInButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if (zoomValue < MAX_ZOOM) {
                   browser.executeJavaScript("map.setZoom(" + ++zoomValue + ")");
               }
           }
       });

       JButton zoomOutButton = new JButton("Alejar");
       zoomOutButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if (zoomValue > MIN_ZOOM) {
                   browser.executeJavaScript("map.setZoom(" + --zoomValue + ")");
               }
           }
       });
       
       JButton determinarUbicacion = new JButton("Seleccionar mi ubicación");
       determinarUbicacion.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               JSValue valor1 = browser.executeJavaScriptAndReturnValue("document.getElementById('datos').value;");
               if(com == null) {
                   JOptionPane.showMessageDialog(null, valor1.getStringValue().toString());
               }else{
                   if(com instanceof RegistrarCliente) {
                       ((RegistrarCliente)com).rellenarDatosLatitudLongitud(valor1.getStringValue().toString());
                       frame.dispose();
                   }else if(com instanceof RegistrarUbicacion) {
                       ((RegistrarUbicacion)com).rellenarDatosLatitudLongitud(valor1.getStringValue().toString());
                       frame.dispose();
                   }
               }
           }
       });

       JButton setMarkerButton = new JButton("Marcar");
       setMarkerButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               browser.executeJavaScript("var myLatlng = new google.maps.LatLng(-33.4554601,-70.6524906);\n" +
                       "var marker = new google.maps.Marker({\n" +
                       "    position: myLatlng,\n" +
                       "    draggable: true,\n" +
                       "    animation: google.maps.Animation.DROP,\n" +
                       "    map: map,\n" +
                       "    title: 'Mi Ubicación!'\n" +
                       "});");
           }
       });

       JPanel toolBar = new JPanel();
       toolBar.add(zoomInButton);
       toolBar.add(zoomOutButton);
       //toolBar.add(setMarkerButton);
       toolBar.add(determinarUbicacion);

       frame = new JFrame("Feria Web Desktop Client - Mapa");
       frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
       frame.add(toolBar, BorderLayout.SOUTH);
       frame.add(browserView, BorderLayout.CENTER);
       frame.setSize(900, 500);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);

       browser.loadURL("C://mapa.html");
       
   }
   
   
   
}