/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author OSCAR
 */
public class cliente {
    
    private int idCliete;
    private String identificacion;
    private String nombre;
    private String placa;
    private int tiempo;
    private double costo;

    public cliente(String identificacion, String nombre, String placa, int tiempo, double costo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.placa = placa;
        this.tiempo = tiempo;
        this.costo = costo;
    }

    public cliente() {
    }

    public int getIdCliete() {
        return idCliete;
    }

    public void setIdCliete(int idCliete) {
        this.idCliete = idCliete;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
}
