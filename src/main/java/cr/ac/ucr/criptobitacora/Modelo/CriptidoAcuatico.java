/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.main.criptobitacora.Modelo;

/**
 *
 * @author Parallax
 */
public class CriptidoAcuatico extends Criptido {
    private double profundidadAvistamientoMts;
    private String ecosistemaAcuatico;

    public CriptidoAcuatico(String id, String nombreComun, String regionOrigen,
                            String descripcionLeyenda, String explicacionCientifica,
                            String[] pistasCampo, double profundidadAvistamientoMts, String ecosistemaAcuatico) {
        super(id, nombreComun, regionOrigen, descripcionLeyenda, explicacionCientifica, pistasCampo);
        this.profundidadAvistamientoMts = profundidadAvistamientoMts;
        this.ecosistemaAcuatico = ecosistemaAcuatico;
    }

    @Override
    public String describirHabitadYMorfologia() {
        return "Organismo acuático en " + ecosistemaAcuatico 
                + " con avistamientos a " + profundidadAvistamientoMts + " metros de profundidad.";
    }

    @Override
    public boolean evaluarHipotesis(int opcionSeleccionada) {
        return opcionSeleccionada == 2; // 2 = Hipótesis de fauna marina
    }

    public double getProfundidadAvistamientoMts() { return profundidadAvistamientoMts; }
    public String getEcosistemaAcuatico() { return ecosistemaAcuatico; }
}
