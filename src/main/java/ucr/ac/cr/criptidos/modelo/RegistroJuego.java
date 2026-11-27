/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.criptidos.modelo;
/**
 *
 * @author Darrell
 */

import java.util.ArrayList;

/**
 * Clase RegistroJuego que representa un componente del sistema de criptidos.
 */
public class RegistroJuego {
    private boolean[] arregloNiveles; 
    private ArrayList<Criptido> listaCriptidos; 
    private int puntosTotales, cantAciertos, cantErrores;
    /**
     * Constructor de la clase.
     */
    public RegistroJuego() {
        arregloNiveles = new boolean[4]; listaCriptidos = new ArrayList<Criptido>();
        puntosTotales = 0; cantAciertos = 0; cantErrores = 0;
    }
    /**

     * Metodo funcional de la clase.

     */
    public void agregarPuntos(int p) { this.puntosTotales += p; }
    /**

     * Metodo funcional de la clase.

     */
    public void addAcierto() { cantAciertos++; agregarPuntos(20); }
    /**

     * Metodo funcional de la clase.

     */
    public void addError() { cantErrores++; agregarPuntos(-10); }
    /**

     * Metodo funcional de la clase.

     */
    public void addCriptidoAlRegistro(Criptido c) { listaCriptidos.add(c); agregarPuntos(c.getPuntos()); }
    /**

     * Metodo funcional de la clase.

     */
    public void setNivelCompletado(int index) { if (index >= 0 && index < arregloNiveles.length) { arregloNiveles[index] = true; } }
    /**

     * Metodo funcional de la clase.

     */
    public boolean getNivelDesbloqueado(int index) {
        if (index == 0) return true; 
        if (index == 1 && puntosTotales >= 100) return true;
        if (index == 2 && puntosTotales >= 240) return true;
        if (index == 3 && puntosTotales >= 400) return true;
        return false;
    }
    /**

     * Metodo funcional de la clase.

     */
    public int getPuntosTotales() { return puntosTotales; }
    /**

     * Metodo funcional de la clase.

     */
    public int getCantAciertos() { return cantAciertos; }
    /**

     * Metodo funcional de la clase.

     */
    public int getCantErrores() { return cantErrores; }
}