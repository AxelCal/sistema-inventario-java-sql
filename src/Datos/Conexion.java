
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexion {
    
    static Connection con=null;
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdalmacen","root",""); 
        }catch(Exception ex){
           ex.printStackTrace(); 
        }
        return con;
    } 
}
