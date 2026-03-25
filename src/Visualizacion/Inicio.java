/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visualizacion;
import Datos.Conexion;
import Visualizacion.Graficasvs;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.Timer;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author aspid
 */
public class Inicio extends javax.swing.JFrame {

     Connection con= Conexion.getConnection();
     
     private JComboBox<String> comboBox;
     
     
      
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        setupComboBox(JcomboBox2);
        JcomboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inventarios", "Recibos", "Lineas" }));
         JcomboBox1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String selectedOption = (String) JcomboBox1.getSelectedItem();
            if (selectedOption != null) {
                switch (selectedOption) {
                    case "Inventarios":
                        Graficasvs graficasvs = new Graficasvs();
                        dpescritorio.add(graficasvs);
                        graficasvs.setVisible(true);
                        break;

                    case "Lineas":
                       GraficaLineas graficali = new GraficaLineas();
                        dpescritorio.add(graficali);
                        graficali.setVisible(true);
                        break;
                    case "Recibos":
                        Graficarecibos graficare = new Graficarecibos();
                        dpescritorio.add(graficare);
                        graficare.setVisible(true);
                        break;
                    default:
                        // Código para el caso por defecto (opción no reconocida)
                        break;
                }
            }
        }
    });
         
        
        ImageIcon icFacturas= new ImageIcon(getClass().getResource("/Imagenes/Facturas.png"));
        Icon iconoFact =new ImageIcon(icFacturas.getImage().getScaledInstance(80,50, Image.SCALE_DEFAULT));
        btnfacturas.setIcon(iconoFact);
        
         ImageIcon icConteos= new ImageIcon(getClass().getResource("/Imagenes/conteo.png"));
        Icon iconocon =new ImageIcon(icConteos.getImage().getScaledInstance(80,50, Image.SCALE_DEFAULT));
        btnconteo.setIcon(iconocon);
        
        ImageIcon icRecibo= new ImageIcon(getClass().getResource("/Imagenes/salidas.png"));
        Icon iconoRec =new ImageIcon(icRecibo.getImage().getScaledInstance(80,50, Image.SCALE_DEFAULT));
        btnrecibos.setIcon(iconoRec);
        
        ImageIcon icAlm= new ImageIcon(getClass().getResource("/Imagenes/Almacen.png"));
        Icon iconoAlm =new ImageIcon(icAlm.getImage().getScaledInstance(80,50, Image.SCALE_DEFAULT));
        btnalmacen.setIcon(iconoAlm);
        
        ImageIcon nConsul= new ImageIcon(getClass().getResource("/Imagenes/Busquedaicono.png"));
        Icon iconoCon =new ImageIcon(nConsul.getImage().getScaledInstance(32,30, Image.SCALE_DEFAULT));
        menuconsultas.setIcon(iconoCon);
        
         ImageIcon menuDB= new ImageIcon(getClass().getResource("/Imagenes/BD.png"));
        Icon iconomenuDB =new ImageIcon(menuDB.getImage().getScaledInstance(32,30, Image.SCALE_DEFAULT));
        MenuDB.setIcon(iconomenuDB);
        
         ImageIcon icHerra= new ImageIcon(getClass().getResource("/Imagenes/Opciones.png"));
        Icon iconoHerra =new ImageIcon(icHerra.getImage().getScaledInstance(32,30, Image.SCALE_DEFAULT));
        MenuHerra.setIcon(iconoHerra);
        
         ImageIcon itemUs= new ImageIcon(getClass().getResource("/Imagenes/Usuarios.png"));
        Icon iconoUs =new ImageIcon(itemUs.getImage().getScaledInstance(26,24, Image.SCALE_DEFAULT));
        Item_usuario.setIcon(iconoUs);
        
        ImageIcon itemDB= new ImageIcon(getClass().getResource("/Imagenes/BDR.png"));
        Icon iconoDB =new ImageIcon(itemDB.getImage().getScaledInstance(26,24, Image.SCALE_DEFAULT));
        Itembackup.setIcon(iconoDB);
        
        ImageIcon itemRepor= new ImageIcon(getClass().getResource("/Imagenes/Facturasicono.png"));
        Icon iconoRepor=new ImageIcon(itemRepor.getImage().getScaledInstance(26,24, Image.SCALE_DEFAULT));
        iproveedor.setIcon(iconoRepor);
        
        ImageIcon itemLi= new ImageIcon(getClass().getResource("/Imagenes/areas.png"));
        Icon iconolinea =new ImageIcon(itemLi.getImage().getScaledInstance(26,24, Image.SCALE_DEFAULT));
        ilineas.setIcon(iconolinea);
        
      
      timer.start();
    } 
     public void setupComboBox(JComboBox<String> comboBox) {
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inventarios", "Recibos", "Proveedores","Facturas" }));
        
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) comboBox.getSelectedItem();
                if (selectedOption != null) {
                    showReport(selectedOption);
                }
            }
        });
    }
    
    
public void showReport(String selectedOption) {
    String reportPath = "";

    switch (selectedOption) {
        case "Inventarios":
           reportPath = "C:/Users/aspid/OneDrive/Documentos/NetBeansProjects/ProyectSisInventario/src/Reportes/Inventario.jasper";
            break;
        case "Recibos":
           reportPath = "C:/Users/aspid/OneDrive/Documentos/NetBeansProjects/ProyectSisInventario/src/Reportes/Rb.jasper";
            break;
        case "Facturas":
           reportPath = "C:/Users/aspid/OneDrive/Documentos/NetBeansProjects/ProyectSisInventario/src/Reportes/Factu.jasper";
            break;
        case "Proveedores":
            reportPath = "C:/Users/aspid/OneDrive/Documentos/NetBeansProjects/ProyectSisInventario/src/Reportes/Proveed.jasper";
            break;
        default:
            break;
    }

    try {
         Connection con= Conexion.getConnection();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);
        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, con);
        JasperViewer view = new JasperViewer(print, false);
        view.setVisible(true);
    } catch (Exception e) {
        e.printStackTrace();
        
    }
}
    
    Timer timer = new Timer(1000, new ActionListener(){
    public void actionPerformed(ActionEvent e){
        Calendar cal = new GregorianCalendar();
           int hh, mm, ss, dia, mes, aa;
             hh=cal.get(Calendar.HOUR);
             mm=cal.get(Calendar.MINUTE);
             ss=cal.get(Calendar.SECOND);
             
             dia=cal.get(Calendar.DAY_OF_MONTH);
             mes=cal.get(Calendar.MONTH);
             aa=cal.get(Calendar.YEAR);
             
             LbFecha.setText(dia+ "/"+(mes+1)+"/"+aa);
             LBHora.setText(hh+ ":"+mm+":"+ss);
            }
});
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnfacturas = new javax.swing.JButton();
        btnrecibos = new javax.swing.JButton();
        btnalmacen = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LbFecha = new javax.swing.JLabel();
        LBHora = new javax.swing.JLabel();
        btnconteo = new javax.swing.JButton();
        JcomboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        JcomboBox2 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dpescritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuconsultas = new javax.swing.JMenu();
        iproveedor = new javax.swing.JMenuItem();
        MenuDB = new javax.swing.JMenu();
        Itembackup = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        MenuHerra = new javax.swing.JMenu();
        Item_usuario = new javax.swing.JMenuItem();
        ilineas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(50, 130, 181));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnfacturas.setText("Facturas");
        btnfacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfacturasActionPerformed(evt);
            }
        });

        btnrecibos.setText("Recibos");
        btnrecibos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecibosActionPerformed(evt);
            }
        });

        btnalmacen.setText("Inventario");
        btnalmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalmacenActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha ");

        jLabel3.setText("Hora");

        LbFecha.setText("jLabel5");

        LBHora.setText("jLabel6");

        btnconteo.setText("Conteos ");
        btnconteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconteoActionPerformed(evt);
            }
        });

        jLabel4.setText("Graficas");

        jLabel5.setText("Reportes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnalmacen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnfacturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnrecibos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnconteo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JcomboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JcomboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LBHora)
                                    .addComponent(LbFecha)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 49, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnfacturas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnrecibos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnalmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnconteo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcomboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JcomboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(LbFecha))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(LBHora))
                .addContainerGap())
        );

        javax.swing.GroupLayout dpescritorioLayout = new javax.swing.GroupLayout(dpescritorio);
        dpescritorio.setLayout(dpescritorioLayout);
        dpescritorioLayout.setHorizontalGroup(
            dpescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        dpescritorioLayout.setVerticalGroup(
            dpescritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menuconsultas.setText("Consultas");

        iproveedor.setText("Proveedores");
        iproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iproveedorActionPerformed(evt);
            }
        });
        menuconsultas.add(iproveedor);

        jMenuBar1.add(menuconsultas);

        MenuDB.setText("Base de datos");

        Itembackup.setText("Respladar");
        Itembackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItembackupActionPerformed(evt);
            }
        });
        MenuDB.add(Itembackup);

        jMenuItem1.setText("Backup");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuDB.add(jMenuItem1);

        jMenuBar1.add(MenuDB);

        MenuHerra.setText("Herramientas");

        Item_usuario.setText("Usuarios");
        Item_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_usuarioActionPerformed(evt);
            }
        });
        MenuHerra.add(Item_usuario);

        ilineas.setText("Lineas");
        ilineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ilineasActionPerformed(evt);
            }
        });
        MenuHerra.add(ilineas);

        jMenuBar1.add(MenuHerra);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dpescritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpescritorio))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnfacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfacturasActionPerformed
        Facturas mifac= new Facturas();
        dpescritorio.add(mifac);
        mifac.show();
    }//GEN-LAST:event_btnfacturasActionPerformed

    private void btnrecibosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecibosActionPerformed
        Recibos mireci= new Recibos();
        dpescritorio.add(mireci);
        mireci.show();
    }//GEN-LAST:event_btnrecibosActionPerformed

    private void btnalmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalmacenActionPerformed
        Inventario miinven = new Inventario();
        dpescritorio.add(miinven);
        miinven.show();
    }//GEN-LAST:event_btnalmacenActionPerformed

    private void iproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iproveedorActionPerformed
         Proveedores miprove = new Proveedores();
        dpescritorio.add(miprove);
        miprove.show();
    }//GEN-LAST:event_iproveedorActionPerformed

    private void Item_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_usuarioActionPerformed
        // TODO add your handling code here:
        Usuarios misusuarios = new Usuarios();
        dpescritorio.add(misusuarios);
        misusuarios.show();
    }//GEN-LAST:event_Item_usuarioActionPerformed

    private void ilineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ilineasActionPerformed
        Lineas milineas = new Lineas();
        dpescritorio.add(milineas);
        milineas.show();
    }//GEN-LAST:event_ilineasActionPerformed

    private void btnconteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconteoActionPerformed
        Conteoypuntos miconteo = new Conteoypuntos();
        dpescritorio.add(miconteo);
        miconteo.show();
    }//GEN-LAST:event_btnconteoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
          Respaldar mires = new Respaldar();
        dpescritorio.add(mires);
        mires.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void ItembackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItembackupActionPerformed
        Respaldar mires = new Respaldar();
        dpescritorio.add(mires);
        mires.show();
    }//GEN-LAST:event_ItembackupActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Item_usuario;
    private javax.swing.JMenu Itembackup;
    private javax.swing.JComboBox<String> JcomboBox1;
    private javax.swing.JComboBox<String> JcomboBox2;
    private javax.swing.JLabel LBHora;
    private javax.swing.JLabel LbFecha;
    private javax.swing.JMenu MenuDB;
    private javax.swing.JMenu MenuHerra;
    private javax.swing.JButton btnalmacen;
    private javax.swing.JButton btnconteo;
    private javax.swing.JButton btnfacturas;
    private javax.swing.JButton btnrecibos;
    private javax.swing.JDesktopPane dpescritorio;
    private javax.swing.JMenuItem ilineas;
    private javax.swing.JMenuItem iproveedor;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuconsultas;
    // End of variables declaration//GEN-END:variables
}
