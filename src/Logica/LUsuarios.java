
package Logica;

import Datos.Conexion;
import Datos.Dusuarios;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aspidj
 */
public class LUsuarios {
    
    Connection con= Conexion.getConnection();
    
    
    
     public LUsuarios(Connection con) {
        this.con = con;
    }
     
    public DefaultTableModel mostrarUsuarios(Dusuarios misUsuarios){
        DefaultTableModel miModelo = null;
        String titulos []= {"Id", "Nombre","Usuarios","Clave","Perfil","Fecha de password"};
       String dts []= new String[6];
       miModelo = new DefaultTableModel(null, titulos);
        try{
            CallableStatement cat=con.prepareCall("{call sp_mostrarbuscar_usuarios(?)}");
            cat.setString(1, misUsuarios.getUsuario());
            ResultSet rs=cat.executeQuery();
            while(rs.next()){
             dts [0]= rs.getString("ID_USUARIO");
             dts [1]= rs.getString("NOMBRE");
             dts [2]= rs.getString("USUARIO");
             dts [3]= rs.getString("CLAVE");
             dts [4]= rs.getString("PERFIL");
             dts [5]= rs.getString("ULTIMA_MODIFICACION_PASSWORD");
             miModelo.addRow(dts);
                     
            }
        }catch(Exception ex){
            
        }
      return miModelo;  
    } 
    
   public String insertarUsuarios(Dusuarios misUsuarios){
       String msg=null;
       
        
       try{
            CallableStatement cat=con.prepareCall("{call sp_insertar_usuarios(?,?,?,?)}");
            cat.setString(1, misUsuarios.getNombre());
            cat.setString(2, misUsuarios.getUsuario());
            cat.setString(3, misUsuarios.getClave());
            cat.setString(4, misUsuarios.getPerfil());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
}

public String editarUsuarios(Dusuarios misUsuarios){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_editar_usuarios(?,?,?,?,?)}");
            cat.setInt(1, misUsuarios.getIDusuarios());
            cat.setString(2, misUsuarios.getNombre());
            cat.setString(3, misUsuarios.getUsuario());
            cat.setString(4, misUsuarios.getClave());
            cat.setString(5, misUsuarios.getPerfil());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }

public String eliminarUsuarios(Dusuarios misUsuarios){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_eliminar_usuarios(?)}");
            cat.setInt(1, misUsuarios.getIDusuarios());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }
}
