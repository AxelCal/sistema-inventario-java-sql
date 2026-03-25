
package Logica;

import Datos.Conexion;
import Datos.Dprove;
import Datos.Dusuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class LProvee {
    
      Connection con= Conexion.getConnection();
    
    
    
     public LProvee(Connection con) {
        this.con = con;
    }
     
    public DefaultTableModel mostrarProvee(Dprove miprove){
        DefaultTableModel miModelo = null;
        String titulos []= {"Id", "Nombre","Telefono","Direccion"};
       String dts []= new String[4];
       miModelo = new DefaultTableModel(null, titulos);
        try{
            CallableStatement cat=con.prepareCall("{call sp_mostrarbuscar_provedores(?)}");
            cat.setString(1, miprove.getNombre());
            ResultSet rs=cat.executeQuery();
            while(rs.next()){
             dts [0]= rs.getString("ID_PROVEEDOR");
             dts [1]= rs.getString("NOMBRE");
             dts [2]= rs.getString("TELEFONO");
             dts [3]= rs.getString("DIRECCION");
             miModelo.addRow(dts);
                     
            }
        }catch(Exception ex){
            
        }
      return miModelo;  
    } 
    
   public String insertarprovee(Dprove miprove){
       String msg=null;
       
        
       try{
            CallableStatement cat=con.prepareCall("{call sp_insertar_provee(?,?,?)}");
            cat.setString(1, miprove.getNombre());
            cat.setInt(2, miprove.getTelefono());
            cat.setString(3, miprove.getDireccion());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
}

public String editarprove(Dprove miprove){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_editar_provee(?,?,?,?)}");
            cat.setInt(1, miprove.getIDprove());
            cat.setString(2, miprove.getNombre());
            cat.setInt(3, miprove.getTelefono());
            cat.setString(4, miprove.getDireccion());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }

public String eliminarprovee(Dprove miprove){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_eliminar_provee(?)}");
            cat.setInt(1, miprove.getIDprove());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }
}

    

