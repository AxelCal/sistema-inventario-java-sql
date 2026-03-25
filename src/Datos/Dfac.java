
package Datos;

import java.util.Date;


public class Dfac {
     int IDfac;
    int IDlinea;
    int IDprove;
    Date fechas;

    public Dfac() {
    }

    public Dfac(int IDfac, int IDlinea, int IDprove, Date fechas) {
        this.IDfac = IDfac;
        this.IDlinea = IDlinea;
        this.IDprove = IDprove;
        this.fechas = fechas;
    }
    

    public int getIDfac() {
        return IDfac;
    }

    public void setIDfac(int IDfac) {
        this.IDfac = IDfac;
    }

    public int getIDlinea() {
        return IDlinea;
    }

    public void setIDlinea(int IDlinea) {
        this.IDlinea = IDlinea;
    }

    public int getIDprove() {
        return IDprove;
    }

    public void setIDprove(int IDprove) {
        this.IDprove = IDprove;
    }

    public Date getFechas() {
        return fechas;
    }

    public void setFechas(Date fechas) {
        this.fechas = fechas;
    }
    
    

}
