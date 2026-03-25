
package Logica;

import Datos.Conexion;
import Datos.Dprove;
import Datos.Dreci;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aspid
 */
public class Lreci {
     Connection con= Conexion.getConnection();
    
    
    
     public Lreci(Connection con) {
        this.con = con;
    }
     
    public DefaultTableModel mostrarreci(Dreci mireci){
        DefaultTableModel miModelo = null;
        String titulos []= {"Id","Areas ID","Fecha salida","Persona recibe","Persona entrega"};
       String dts []= new String[5];
       miModelo = new DefaultTableModel(null, titulos);
        try{
            CallableStatement cat=con.prepareCall("{call sp_mostrarbuscar_recibo(?)}");
            cat.setString(1, mireci.getPersona1());
            ResultSet rs=cat.executeQuery();
            while(rs.next()){
             dts [0]= rs.getString("ID_RECIBOS");
             dts [1]= rs.getString("AREASID");
             dts [2]= rs.getString("FECHASALIDA");
             dts [3]= rs.getString("PERSONARECIBE");
             dts [4]= rs.getString("PERSONAENTREGA");
             miModelo.addRow(dts);
                     
            }
        }catch(Exception ex){
            
        }
      return miModelo;  
    } 
    
   public String insertarreci(Dreci mireci){
       String msg=null; 
       try{
            CallableStatement cat=con.prepareCall("{call sp_insertar_recibo(?,?,?,?)}");
            cat.setInt(1, mireci.getIDareas());
            java.util.Date fecha = mireci.getFechasal();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            cat.setDate(2, fechaSQL);
            cat.setString(3, mireci.getPersona1());
            cat.setString(4, mireci.getPersona2());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
}

public String editarreci(Dreci mireci){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_editar_recibo(?,?,?,?,?)}");
            cat.setInt(1, mireci.getIDreci());
            cat.setInt(2, mireci.getIDareas());
            java.util.Date fecha = mireci.getFechasal();
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            cat.setDate(3, fechaSQL);
            cat.setString(4, mireci.getPersona1());
            cat.setString(5, mireci.getPersona2());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }

public String eliminarrecbi(Dreci mireci){
       String msg=null;
       try{
            CallableStatement cat=con.prepareCall("{call sp_eliminar_recibo(?)}");
            cat.setInt(1, mireci.getIDreci());
            cat.executeUpdate();
            msg= "si";
       }catch(Exception ex){
           ex.printStackTrace();
           msg="no";
       }
       return msg;
   }
}

