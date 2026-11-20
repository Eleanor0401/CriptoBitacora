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

public class RegistroJuego {
    private boolean[] arregloNiveles; 
    private ArrayList<Criptido> listaCriptidos; 
    private int puntosTotales, cantAciertos, cantErrores;
    public RegistroJuego() {
        arregloNiveles = new boolean[4]; listaCriptidos = new ArrayList<Criptido>();
        puntosTotales = 0; cantAciertos = 0; cantErrores = 0;
    }
    public void agregarPuntos(int p) { this.puntosTotales += p; }
    public void addAcierto() { cantAciertos++; agregarPuntos(20); }
    public void addError() { cantErrores++; agregarPuntos(-10); }
    public void addCriptidoAlRegistro(Criptido c) { listaCriptidos.add(c); agregarPuntos(c.getPuntos()); }
    public void setNivelCompletado(int index) { if (index >= 0 && index < arregloNiveles.length) { arregloNiveles[index] = true; } }
    public boolean getNivelDesbloqueado(int index) {
        if (index == 0) return true; 
        if (index == 1 && puntosTotales >= 100) return true;
        if (index == 2 && puntosTotales >= 240) return true;
        if (index == 3 && puntosTotales >= 400) return true;
        return false;
    }
    public int getPuntosTotales() { return puntosTotales; }
    public int getCantAciertos() { return cantAciertos; }
    public int getCantErrores() { return cantErrores; }
}