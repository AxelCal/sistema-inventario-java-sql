
package Visualizacion;

import Datos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import java.sql.SQLException;
import javax.swing.JScrollPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;



public class Conteoypuntos extends javax.swing.JInternalFrame {

   Connection con= Conexion.getConnection();
   DefaultTableModel model;
    
    public Conteoypuntos() {
        initComponents();
        txtAlertas = new javax.swing.JTextArea();
        txtAlertas.setEditable(false); 
        JScrollPane jScrollPane2 = new JScrollPane(txtAlertas);
        jScrollPane2.setBounds(26, 370, 745, 196);
        jPanel2.add(jScrollPane2);
         String[] columnNames = {"Descripción", "Stock Actual", "Precio Unitario", "Conteo Físico"};
        model = new DefaultTableModel(null, columnNames);
        tconteos.setModel(model); 
        cargarDatosProductos();
        tconteos.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int fila = e.getFirstRow();
                int columna = e.getColumn();
                if (columna == 3) {
                    Object nuevoConteoFisico = model.getValueAt(fila, columna);
                }
            }
        });
     
    }
    
    private void cargarDatosProductos() {
        try {
            String query = "SELECT DESCRIPCION, STOCK, PUNITARIO FROM almacen";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            model.setRowCount(0);

            while (rs.next()) {
                String descripcion = rs.getString("DESCRIPCION");
                int stock = rs.getInt("STOCK");
                double precioUnitario = rs.getDouble("PUNITARIO");
                model.addRow(new Object[]{descripcion, stock, precioUnitario, ""});
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos de los productos.");
        }
    }

private void consultarPuntoReorden() {
        
        boolean todosSobrePuntoReorden = true;
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            int stockActual = (int) model.getValueAt(i, 1);
            int puntoReorden = 10; 
            if (stockActual < puntoReorden) {
                todosSobrePuntoReorden = false;
                txtAlertas.append("- " + model.getValueAt(i, 0) + " ha alcanzado el punto de reorden.\n");
            }
        }

        if (todosSobrePuntoReorden) {
            txtAlertas.append("Todo está bien. Consulte de nuevo más tarde.\n");
        } else {
            txtAlertas.append("Algunos stocks están por debajo del punto de reorden.\n");
            txtAlertas.append("Por favor, introduzca el valor del conteo físico en el campo correspondiente.\n");
        }
    }
//se encarga de calcular el conteo cíclico de los productos y actualizar el stock en la base de datos según el punto de reorden.
  private void calcularConteoCiclico() {
    int rowCount = model.getRowCount();
    for (int i = 0; i < rowCount; i++) {
        String descripcion = (String) model.getValueAt(i, 0);
        int stockActual = (int) model.getValueAt(i, 1);
        int puntoReorden = 10; 

        Object conteoFisicoObj = model.getValueAt(i, 3);
        int conteoFisico = 0;
        if (conteoFisicoObj != null && !conteoFisicoObj.toString().isEmpty()) {
            conteoFisico = Integer.parseInt(conteoFisicoObj.toString());
        }

        boolean bajoPuntoReorden = stockActual < puntoReorden;

        if (bajoPuntoReorden) {
            try {
                String updateQuery = "UPDATE almacen SET STOCK = ? WHERE DESCRIPCION = ?";
                PreparedStatement pstmt = con.prepareStatement(updateQuery);
                pstmt.setInt(1, conteoFisico); 
                pstmt.setString(2, descripcion);
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
                txtAlertas.append("Error al actualizar el stock para: " + descripcion + "\n");
            }
        }
    }

    txtAlertas.append("Se ha realizado el conteo cíclico y actualizado el stock según el punto de reorden.\n");
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tconteos = new javax.swing.JTable();
        btnconteo = new javax.swing.JButton();
        btnpuntos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlertas = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(50, 130, 181));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Conteos Cíclicos y  Puntos de Reorden");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel2)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(50, 130, 181));

        tconteos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tconteos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tconteosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tconteos);

        btnconteo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/check-square-solid-24.png"))); // NOI18N
        btnconteo.setText("Consultar punto reorden");
        btnconteo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconteoActionPerformed(evt);
            }
        });

        btnpuntos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/paloma.png"))); // NOI18N
        btnpuntos.setText("Calcular conteo ciclico");
        btnpuntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpuntosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Alertas y notificaciones");

        txtAlertas.setColumns(20);
        txtAlertas.setRows(5);
        jScrollPane3.setViewportView(txtAlertas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btnconteo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnpuntos)
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(301, 301, 301))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnconteo)
                    .addComponent(btnpuntos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconteoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconteoActionPerformed
      consultarPuntoReorden();
    }//GEN-LAST:event_btnconteoActionPerformed

    private void btnpuntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpuntosActionPerformed
     calcularConteoCiclico();
    }//GEN-LAST:event_btnpuntosActionPerformed

    private void tconteosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tconteosMouseClicked
        int filaSeleccionada = tconteos.getSelectedRow();
        String descripcionProducto = (String) tconteos.getValueAt(filaSeleccionada, 0);
    }//GEN-LAST:event_tconteosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconteo;
    private javax.swing.JButton btnpuntos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tconteos;
    private javax.swing.JTextArea txtAlertas;
    // End of variables declaration//GEN-END:variables
}
