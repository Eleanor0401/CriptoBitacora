/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.criptidos.modelo;
/**
 *
 * @author Darrell
 */

import javax.swing.ImageIcon;

public abstract class Criptido implements Investigable {
    protected String nombre;
    protected String infoLibro;
    protected String[] arregloPistas;
    protected ImageIcon imagenCriptido;

    public Criptido(String nombre, String infoLibro, String[] arregloPistas, ImageIcon imagenCriptido) {
        this.nombre = nombre; 
        this.infoLibro = infoLibro; 
        this.arregloPistas = arregloPistas;
        this.imagenCriptido = imagenCriptido;
    }
    public String getNombre() { return nombre; }
    public String getInfoLibro() { return infoLibro; }
    public ImageIcon getImagenCriptido() { return imagenCriptido; }
    
    @Override
    public String getPista(int indice) {
        if (indice >= 0 && indice < arregloPistas.length) return arregloPistas[indice];
        return "No hay rastro.";
    }
    public abstract String mensajeAparicion();
}