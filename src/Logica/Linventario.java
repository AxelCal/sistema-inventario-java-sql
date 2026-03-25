
package Logica;

import Datos.Conexion;
import Datos.Dinventario;
import Datos.Dusuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class Linventario {
    
    Connection con= Conexion.getConnection();
    
    
    
     public Linventario(Connection con) {
        this.con = con;
    }
     
    public DefaultTableModel mostrarinventario(Dinventario misinven){
        DefaultTableModel miModelo = null;
        String titulos []= {"Id", "ID Linea","Descripcion","Stock","UMedida","Precio Unitario"};
       String dts []= new String[6];
       miModelo = new DefaultTableModel(null, titulos);
        try{
            CallableStatement cat=con.prepareCall("{call sp_mostrarbuscar_inventario(?)}");
            cat.setString(1, misinven.getDescripcion());
            ResultSet rs=cat.executeQuery();
            while(rs.next()){
             dts [0]= rs.getString("ID_ALMACEN");
             dts [1]= rs.getString("LINEASID");
             dts [2]= rs.getString("DESCRIPCION");
             dts [3]= rs.getString("STOCK");
             dts [4]= rs.getString("UMEDIDA");
             dts [5]= rs.getString("PUNITARIO");
             miModelo.addRow(dts);
                     
            }
        }catch(Exception ex){
            
        }
      return miModelo;  
    } 
    
   public String insertarinventario(Dinventario misinven){
       String msg=null;
       
        
       try{
            CallableStatement cat=con.prepareCall("{call sp_insertar_inventario(?,?,?,?,?)}");
            cat.setInt(1, misinven.getIDlinea());
            cat.setString(2, misinven.getDescripcion());
            cat.setInt(3, misinven.getStock());
            cat.setString(4, misinven.getUmedida());
            cat.setInt(5, misinven.getPunitario());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
}

public String editarinventario(Dinventario misinven){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_editar_inventario(?,?,?,?,?,?)}");
            cat.setInt(1, misinven.getIDinven());
            cat.setInt(2, misinven.getIDlinea());
            cat.setString(3, misinven.getDescripcion());
            cat.setInt(4, misinven.getStock());
            cat.setString(5, misinven.getUmedida());
            cat.setInt(6, misinven.getPunitario());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }

public String eliminarinventario(Dinventario misinven){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_eliminar_usuarios(?)}");
            cat.setInt(1, misinven.getIDinven());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }
}

    

