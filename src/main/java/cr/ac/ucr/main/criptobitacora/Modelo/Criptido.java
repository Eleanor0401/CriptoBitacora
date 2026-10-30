/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.main.criptobitacora.Modelo;

/**
 *
 * @author Parallax
 */
public abstract class Criptido implements Investigable {
    private String id;
    private String nombreComun;
    private String regionOrigen;
    private String descripcionLeyenda;
    private String explicacionCientifica;
    private String[] pistasCampo; // Arreglo unidimensional requerido

    public Criptido(String id, String nombreComun, String regionOrigen, 
                    String descripcionLeyenda, String explicacionCientifica, String[] pistasCampo) {
        this.id = id;
        this.nombreComun = nombreComun;
        this.regionOrigen = regionOrigen;
        this.descripcionLeyenda = descripcionLeyenda;
        this.explicacionCientifica = explicacionCientifica;
        this.pistasCampo = pistasCampo != null ? pistasCampo : new String[0];
    }

    public abstract String describirHabitadYMorfologia();

    public String getId() { return id; }
    public String getNombreComun() { return nombreComun; }
    public String getRegionOrigen() { return regionOrigen; }
    public String getDescripcionLeyenda() { return descripcionLeyenda; }
    public String getExplicacionCientifica() { return explicacionCientifica; }
    public String[] getPistasCampo() { return pistasCampo; }

    @Override
    public String obtenerDetalleCientifico() {
        return "Análisis Biológico de " + nombreComun + ": " + explicacionCientifica;
    }
}