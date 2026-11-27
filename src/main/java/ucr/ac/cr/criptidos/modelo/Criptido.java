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

/**
 * Clase Criptido que representa un componente del sistema de criptidos.
 */
public abstract class Criptido implements Investigable {
    protected String nombre;
    protected String infoLibro;
    protected String[] arregloPistas;
    protected ImageIcon imagenCriptido;

    /**
     * Constructor de la clase.
     */
    public Criptido(String nombre, String infoLibro, String[] arregloPistas, ImageIcon imagenCriptido) {
        this.nombre = nombre; 
        this.infoLibro = infoLibro; 
        this.arregloPistas = arregloPistas;
        this.imagenCriptido = imagenCriptido;
    }
    /**

     * Metodo funcional de la clase.

     */
    public String getNombre() { return nombre; }
    /**

     * Metodo funcional de la clase.

     */
    public String getInfoLibro() { return infoLibro; }
    /**

     * Metodo funcional de la clase.

     */
    public ImageIcon getImagenCriptido() { return imagenCriptido; }
    
    @Override
    /**

     * Metodo funcional de la clase.

     */
    public String getPista(int indice) {
        if (indice >= 0 && indice < arregloPistas.length) return arregloPistas[indice];
        return "No hay rastro.";
    }
    public abstract String mensajeAparicion();
}