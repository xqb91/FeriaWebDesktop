/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.mapa;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The sample demonstrates how to create Browser instance, embed it, display and
 * load specified URL.
 */
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.JSValue;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class MapaMuestraUbicacion {

    public static final int MIN_ZOOM = 0;
    public static final int MAX_ZOOM = 21;
    public static double latitud = -33.6561255;
    public static double longitud = -70.9303373;
    private static int zoomValue = 13;
    private static Component componente = null;

    public MapaMuestraUbicacion() {
        this.latitud = -33.6561255;
        this.longitud = -70.9303373;
        this.zoomValue = 17;
    }

    public MapaMuestraUbicacion(double latitud, double longitud, int zoom, Component componente) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.zoomValue = zoom;
        this.componente = componente;

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
                browser.executeJavaScript("map.setCenter(new google.maps.LatLng(" + latitud + "," + longitud + "));");
            }
        });

        JButton setMarkerButton = new JButton("Marcar");
        setMarkerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browser.executeJavaScript("var myLatlng = new google.maps.LatLng(" + latitud + "," + longitud + ");\n"
                        + "var marker = new google.maps.Marker({\n"
                        + "    position: myLatlng,\n"
                        + "    draggable: true,\n"
                        + "    animation: google.maps.Animation.DROP,\n"
                        + "    map: map,\n"
                        + "    title: 'Mi Ubicación!'\n"
                        + "});");
            }
        });

        JPanel toolBar = new JPanel();
        toolBar.add(zoomInButton);
        toolBar.add(zoomOutButton);
        //toolBar.add(setMarkerButton);
        toolBar.add(determinarUbicacion);

        JFrame frame = new JFrame("Feria Web Desktop Client - Mi ubicación en Mapa");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(toolBar, BorderLayout.SOUTH);
        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(componente);
        frame.setVisible(true);

        browser.loadURL("C://mapaMuestra.html");
        browser.executeJavaScript("map.setCenter(new google.maps.LatLng(" + latitud + "," + longitud + "));");

    }

}
