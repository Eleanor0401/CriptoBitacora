/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.main.criptobitacora.Modelo;

/**
 *
 * @author Parallax
 */
import java.util.ArrayList;

public class GestorInvestigacion {
    private ArrayList<Criptido> catalogoCriptidos; // ArrayList requerido
    private int puntajeAcumulado;

    public GestorInvestigacion() {
        this.catalogoCriptidos = new ArrayList<>();
        this.puntajeAcumulado = 0;
    }

    public void registrarCriptido(Criptido criptido) {
        if (criptido != null) {
            this.catalogoCriptidos.add(criptido);
        }
    }

    public ArrayList<Criptido> getCatalogoCriptidos() {
        return catalogoCriptidos;
    }
}