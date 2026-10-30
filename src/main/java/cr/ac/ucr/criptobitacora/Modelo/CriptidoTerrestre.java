/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.main.criptobitacora.Modelo;

/**
 *
 * @author Parallax
 */
public class CriptidoTerrestre extends Criptido {
    private String patronHuella;
    private double longitudPisadaCm;

    public CriptidoTerrestre(String id, String nombreComun, String regionOrigen,
                             String descripcionLeyenda, String explicacionCientifica,
                             String[] pistasCampo, String patronHuella, double longitudPisadaCm) {
        super(id, nombreComun, regionOrigen, descripcionLeyenda, explicacionCientifica, pistasCampo);
        this.patronHuella = patronHuella;
        this.longitudPisadaCm = longitudPisadaCm;
    }

    @Override
    public String describirHabitadYMorfologia() {
        return "Especie terrestre adaptada a bosques. Huella tipo '" 
                + patronHuella + "', longitud de " + longitudPisadaCm + " cm.";
    }

    @Override
    public boolean evaluarHipotesis(int opcionSeleccionada) {
        return opcionSeleccionada == 1; // 1 = Hipótesis biológica correcta
    }

    public String getPatronHuella() { return patronHuella; }
    public double getLongitudPisadaCm() { return longitudPisadaCm; }
}

