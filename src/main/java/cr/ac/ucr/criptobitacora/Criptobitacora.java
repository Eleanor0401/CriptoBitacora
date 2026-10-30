/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cr.ac.ucr.main.criptobitacora;
import cr.ac.ucr.main.criptobitacora.Modelo.*;

/**
 *
 * @author Parallax
 */

public class Criptobitacora {
    public static void main(String[] args) {
        GestorInvestigacion gestor = new GestorInvestigacion();

        String[] pistasSasquatch = {"Huella 45cm", "Pelo"};
        Criptido sasquatch = new CriptidoTerrestre(
            "C-01", "Sasquatch", "Bosques", "Homínido gigante", "Oso negro",
            pistasSasquatch, "Plantar", 45.5
        );
        gestor.registrarCriptido(sasquatch);

        System.out.println("=== BITÁCORA INICIALIZADA ===");
        for (Criptido c : gestor.getCatalogoCriptidos()) {
            System.out.println("Criatura: " + c.getNombreComun());
            System.out.println(c.describirHabitadYMorfologia()); // Polimorfismo en acción
        }
    }
}