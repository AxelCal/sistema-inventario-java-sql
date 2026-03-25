/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.util.Date;

/**
 *
 * @author aspid
 */
public class Dusuarios {
    int IDusuarios;
    String Nombre;
    String Usuario;
    String Clave;
    String Perfil;
    

    public Dusuarios(int IDusuarios, String Nombre, String Usuario, String Clave, String Perfil) {
        this.IDusuarios = IDusuarios;
        this.Nombre = Nombre;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Perfil = Perfil;
    }
    public Dusuarios(){
        
    }
 
    public int getIDusuarios() {
        return IDusuarios;
    }

    public void setIDusuarios(int IDusuarios) {
        this.IDusuarios = IDusuarios;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }
   
}
