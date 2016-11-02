/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.menuClientes;

/**
 *
 * @author Victor Manuel Araya
 */
public class Prueba {
    public static void main(String[] args) {
    Browser browser = new Browser();
    BrowserView view = new BrowserView(browser);

    JFrame frame = new JFrame();
    frame.add(view, BorderLayout.CENTER);
    frame.setSize(700, 500);
    frame.setVisible(true);

    browser.loadURL("http://www.google.com");
}
}
