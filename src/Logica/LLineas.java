
package Logica;

import Datos.Conexion;
import Datos.DLineas;
import Datos.Dusuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aspid
 */
public class LLineas {
    
    Connection con= Conexion.getConnection();
    
    
    
     public LLineas(Connection con) {
        this.con = con;
    }
    
    
    public DefaultTableModel mostrarLineas(DLineas miLineas){
        DefaultTableModel miModelo = null;
        String titulos []= {"Id", "Linea"};
       String dts []= new String[2];
       miModelo = new DefaultTableModel(null, titulos);
        try{
            CallableStatement cat=con.prepareCall("{call sp_mostrarbuscar_linea(?)}");
            cat.setString(1, miLineas.getLinea());
            ResultSet rs=cat.executeQuery();
            while(rs.next()){
             dts [0]= rs.getString("ID_LINEAS");
             dts [1]= rs.getString("NOMBRE");
             miModelo.addRow(dts);
                     
            }
        }catch(Exception ex){
            
        }
      return miModelo;  
    } 
    
     public String insertarlineas(DLineas miLineas){
       String msg=null;
       
        
       try{
            CallableStatement cat=con.prepareCall("{call sp_insertar_lineas(?)}");
            cat.setString(1, miLineas.getLinea());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
}

public String editarLineas(DLineas miLineas){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_editar_lineas(?,?)}");
            cat.setInt(1, miLineas.getId());
            cat.setString(2, miLineas.getLinea());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }

public String eliminarLineas(DLineas miLineas){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_eliminar_lineas(?)}");
            cat.setInt(1, miLineas.getId());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }
}
