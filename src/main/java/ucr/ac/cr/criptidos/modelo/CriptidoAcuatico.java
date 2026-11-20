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

public class CriptidoAcuatico extends Criptido {
    public CriptidoAcuatico(String nombre, String infoLibro, String[] arregloPistas, ImageIcon imagenCriptido) { super(nombre, infoLibro, arregloPistas, imagenCriptido); }
    @Override public String mensajeAparicion() { return "El agua burbujea de forma violenta y una silueta enorme sale a la superficie..."; }
    @Override public int getPuntos() { return 50; }
}