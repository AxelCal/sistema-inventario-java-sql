
package Datos;

import java.util.Date;


public class Dreci {
    int IDreci;
    int IDareas;
    Date fechasal;
    String persona1;
    String persona2;

    public Dreci() {
    }

    public Dreci(int IDreci, int IDareas, Date fechasal, String persona1, String persona2) {
        this.IDreci = IDreci;
        this.IDareas = IDareas;
        this.fechasal = fechasal;
        this.persona1 = persona1;
        this.persona2 = persona2;
    }

    public int getIDreci() {
        return IDreci;
    }

    public void setIDreci(int IDreci) {
        this.IDreci = IDreci;
    }

    public int getIDareas() {
        return IDareas;
    }

    public void setIDareas(int IDareas) {
        this.IDareas = IDareas;
    }

    public Date getFechasal() {
        return fechasal;
    }

    public void setFechasal(Date fechasal) {
        this.fechasal = fechasal;
    }

    public String getPersona1() {
        return persona1;
    }

    public void setPersona1(String persona1) {
        this.persona1 = persona1;
    }

    public String getPersona2() {
        return persona2;
    }

    public void setPersona2(String persona2) {
        this.persona2 = persona2;
    }
    
    
}
