/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.alevicmar.productos;

import cl.alevicmar.main.Principal;
import cl.alevicmar.services.categoria.Categoria;
import cl.alevicmar.services.categoria.WebServiceCategoria;
import cl.alevicmar.services.familia.Familia;
import cl.alevicmar.services.familia.WebServiceFamilia;
import cl.alevicmar.services.producto.Producto;
import cl.alevicmar.services.producto.WebServiceProducto;
import cl.alevicmar.tools.HR;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Janno
 */
public class AdministrarProductos extends javax.swing.JFrame {

    WebServiceProducto      srvProducto     = null;
    WebServiceCategoria     srvCategoria    = null;
    WebServiceFamilia       srvFamilia      = null;
    Component               componente      = null;
    
    List<Producto> listado = new ArrayList<Producto>();
    
    public AdministrarProductos() {
        initComponents();
        this.setLocationRelativeTo(componente);
        this.srvProducto = new WebServiceProducto();
        this.srvFamilia = new WebServiceFamilia();
        this.srvCategoria = new WebServiceCategoria();
        this.rellenarTabla();
        this.rellenarCategoria();
        this.rellenarFamilia();
    }
    
    public AdministrarProductos(WebServiceProducto srvProducto,WebServiceCategoria srvCategoria, WebServiceFamilia srvFamilia, Component componente) {
        initComponents();
        this.setLocationRelativeTo(componente);
        if(componente instanceof Principal) {
            this.setIconImage(((Principal)componente).getIconImage());
        }
        this.srvProducto = new WebServiceProducto();
        this.srvFamilia = new WebServiceFamilia();
        this.srvCategoria = new WebServiceCategoria();
        this.rellenarTabla();
        this.rellenarCategoria();
        this.rellenarFamilia();
    }

    public void rellenarTabla() {
        try {
            DefaultTableModel modelo = new DefaultTableModel(new Object [][] { }, new String [] { "Nombre", "Descripcion", "Categoria", "Familia" });    

            List<Object> array = srvProducto.getWebServiceProductoSoap().retornaTodosLosProductos().getAnyType();
            if(array != null) {
                for(Object o : array) {
                    Producto p = ((Producto)o);
                    listado.add(p);
                    Object[] obj = new Object[4];
                    obj[0] = p.getNombre();
                    obj[1] = p.getDescripcion();
                    if(p.getCategoria()== 0) {
                        obj[2] = "Sin Categoria";
                    }else{
                        obj[2] = srvCategoria.getWebServiceCategoriaSoap().buscaCategoria(p.getCategoria()).getNombre();
                    }
                    if(p.getFamilia()== 0) {
                        obj[3] = "Sin Familia";
                    }else{
                        obj[3] = srvFamilia.getWebServiceFamiliaSoap().buscaFamilia(p.getFamilia()).getNombre();
                    }
                    modelo.addRow(obj);
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
        }catch(Exception e) {
            HR.mostrarError("Ocurrió un error cargar los datos de los clientes: "+e.getMessage());
        }
    }
    
    public void rellenarCategoria()
    {
        List<Object> cate = srvCategoria.getWebServiceCategoriaSoap().retornaTodasLasCategoria().getAnyType();
        if(cate.size() != 0)
        {
            HR.insertarTexto(cmbCategoria, "Seleccione...");
            for(Object o : cate)
            {
                HR.insertarTexto(cmbCategoria, ((Categoria)o).getNombre());
            }
        }
    }
    
    public void rellenarFamilia()
    {
        List<Object> fami = srvFamilia.getWebServiceFamiliaSoap().retornaTodasLasFamilias().getAnyType();
        if(fami.size() != 0)
        {
            HR.insertarTexto(cmbFamilia, "Seleccione...");
            for(Object o : fami)
            {
                HR.insertarTexto(cmbFamilia, ((Familia)o).getNombre());
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaResultados = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbFamilia = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FeriaWeb Desktop  ::  Administrar Productos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos registrados en el sistema"));

        tablaResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion", "Categoria", "Familia"
            }
        ));
        jScrollPane1.setViewportView(tablaResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        jLabel1.setText("Categoría");

        jLabel2.setText("Familia");

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbFamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnFiltrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnFiltrar)
                .addContainerGap(250, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        //Buscar por Categoria
        if(HR.contenido(cmbCategoria).compareToIgnoreCase("Seleccione...") != 0)
        {
            int valor = HR.buscarValorTabla(2, tablaResultados, HR.contenido(cmbCategoria), true);
            
            if(valor == -1)
            {
                HR.mostrarError("No se encontraron elementos con esta categoria");
            }else{
                tablaResultados.getSelectionModel().setSelectionInterval(valor, valor);
            }
        }
        //Buscar por Familia
        if(HR.contenido(cmbFamilia).compareToIgnoreCase("Seleccione...") != 0)
        {
            int valor = HR.buscarValorTabla(2, tablaResultados, HR.contenido(cmbFamilia), true);
            
            if(valor == -1)
            {
                HR.mostrarError("No se encontraron elementos con esta Familia");
            }else{
                tablaResultados.getSelectionModel().setSelectionInterval(valor, valor);
            }
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministrarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbFamilia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaResultados;
    // End of variables declaration//GEN-END:variables
}
