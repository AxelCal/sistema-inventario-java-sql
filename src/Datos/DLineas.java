/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author aspid
 */
public class DLineas {
    String Linea;
     int id;

    public DLineas() {
        
    }
    
    public DLineas(int id1, String Lineas) {
        this.id= id1;
        this.Linea=Lineas;
    }

    public String getLinea() {
        return Linea;
    }

    public void setLinea(String Linea) {
        this.Linea = Linea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
}
