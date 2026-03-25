/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Datos.Conexion;
import java.sql.Connection;

/**
 *
 * @author aspid
 */
public class LInicio {
    
    public static void main(String [] args){
        Connection con=Conexion.getConnection();
    }
    
}
