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

public class CriptidoVolador extends Criptido {
    public CriptidoVolador(String nombre, String infoLibro, String[] arregloPistas, ImageIcon imagenCriptido) { super(nombre, infoLibro, arregloPistas, imagenCriptido); }
    @Override public String mensajeAparicion() { return "Una gran rafaga de viento desciende desde el cielo oscuro..."; }
    @Override public int getPuntos() { return 50; }
}