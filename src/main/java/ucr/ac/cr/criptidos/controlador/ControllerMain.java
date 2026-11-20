/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.criptidos.controlador;

/**
 *
 * @author Darrell
 */
import ucr.ac.cr.criptidos.vista.FrmMain; 
import ucr.ac.cr.criptidos.modelo.RegistroJuego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerMain implements ActionListener {
    private FrmMain frmMain; private RegistroJuego registro;
    public ControllerMain() {
        frmMain = new FrmMain(); registro = new RegistroJuego();
        frmMain.setControlador(this); actualizarPantalla(); frmMain.setVisible(true);
    }
    public void actualizarPantalla() {
        frmMain.actualizarDatos(registro.getPuntosTotales(), registro.getNivelDesbloqueado(0), registro.getNivelDesbloqueado(1), registro.getNivelDesbloqueado(2), registro.getNivelDesbloqueado(3));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "btnNivel1": abrirNivel(0); break;
            case "btnNivel2": abrirNivel(1); break;
            case "btnNivel3": abrirNivel(2); break;
            case "btnNivel4": abrirNivel(3); break;
            case "btnSalir": System.exit(0); break;
        }
    }
    private void abrirNivel(int id) { frmMain.setVisible(false); ControllerNivel ctrlNivel = new ControllerNivel(id, registro, this); }
    public void devolverAlMenu() { actualizarPantalla(); frmMain.setVisible(true); }
}