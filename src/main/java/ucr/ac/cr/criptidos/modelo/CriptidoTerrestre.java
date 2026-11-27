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
 * Clase CriptidoTerrestre que representa un componente del sistema de criptidos.
 */
public class CriptidoTerrestre extends Criptido {
    /**
     * Constructor de la clase.
     */
    public CriptidoTerrestre(String nombre, String infoLibro, String[] arregloPistas, ImageIcon imagenCriptido) { super(nombre, infoLibro, arregloPistas, imagenCriptido); }
    @Override public String mensajeAparicion() { return "Se escuchan pasos pesados y ramas rompiendose en la tierra..."; }
    @Override public int getPuntos() { return 50; }
}