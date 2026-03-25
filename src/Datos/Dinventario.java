
package Datos;


public class Dinventario {
    
     int IDinven;
     int IDlinea;
    String Descripcion;
    int Stock;
    String Umedida;
    int Punitario;

    public Dinventario() {
    }

    public Dinventario(int IDinven, int IDlinea, String Descripcion, int Stock, String Umedida, int Punitario) {
        this.IDinven = IDinven;
        this.IDlinea = IDlinea;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
        this.Umedida = Umedida;
        this.Punitario = Punitario;
    }
    

    public int getIDinven() {
        return IDinven;
    }

    public void setIDinven(int IDinven) {
        this.IDinven = IDinven;
    }

    public int getIDlinea() {
        return IDlinea;
    }

    public void setIDlinea(int IDlinea) {
        this.IDlinea = IDlinea;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getUmedida() {
        return Umedida;
    }

    public void setUmedida(String Umedida) {
        this.Umedida = Umedida;
    }

    public int getPunitario() {
        return Punitario;
    }

    public void setPunitario(int Punitario) {
        this.Punitario = Punitario;
    }
    
    
    
}
