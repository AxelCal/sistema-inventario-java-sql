
package Datos;


public class Dprove {
    int IDprove;
    String Nombre;
    int telefono;
    String Direccion;

    public Dprove() {
    }

    
      public Dprove(int IDprove, String Nombre, int telefono, String Direccion) {
        this.IDprove = IDprove;
        this.Nombre = Nombre;
        this.telefono = telefono;
        this.Direccion = Direccion;
    }
    
      
    public int getIDprove() {
        return IDprove;
    }

    public void setIDprove(int IDprove) {
        this.IDprove = IDprove;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

  
    
    
}
