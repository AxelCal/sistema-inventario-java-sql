
package Logica;

import Datos.Conexion;
import Datos.Dfac;
import Datos.Dprove;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class Lfac {
    
     Connection con= Conexion.getConnection();
    
    
    
     public Lfac(Connection con) {
        this.con = con;
    }
     
    public DefaultTableModel mostrarfac(Dfac mifac){
        DefaultTableModel miModelo = null;
        String titulos []= {"Id", "ID linea","ID Proveedores","Fecha"};
       String dts []= new String[4];
       miModelo = new DefaultTableModel(null, titulos);
        try{
            CallableStatement cat=con.prepareCall("{call sp_mostrarbuscar_facturas(?)}");
            cat.setInt(1, mifac.getIDlinea());
            ResultSet rs=cat.executeQuery();
            while(rs.next()){
             dts [0]= rs.getString("ID_FACTURA");
             dts [1]= rs.getString("LINEASID");
             dts [2]= rs.getString("PROVEEDORESID");
             dts [3]= rs.getString("FECHAENTRADA");
             miModelo.addRow(dts);
                     
            }
        }catch(Exception ex){
            
        }
      return miModelo;  
    } 
    
   public String insertarfac(Dfac mifac){
       String msg=null;
       
        
       try{
            CallableStatement cat=con.prepareCall("{call sp_insertar_facturas(?,?,?)}");
            cat.setInt(1, mifac.getIDlinea());
            cat.setInt(2, mifac.getIDprove());
            java.util.Date fecha = mifac.getFechas();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            cat.setDate(3, fechaSQL);
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
}

public String editarfac(Dfac mifac){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_editar_facturas(?,?,?,?)}");
            cat.setInt(1, mifac.getIDfac());
            cat.setInt(2, mifac.getIDlinea());
            cat.setInt(3, mifac.getIDprove());
            java.util.Date fecha = mifac.getFechas();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            cat.setDate(4, fechaSQL);
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }

public String eliminarfac(Dfac mifac){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_eliminar_facturas(?)}");
            cat.setInt(1, mifac.getIDfac());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }
}

    

