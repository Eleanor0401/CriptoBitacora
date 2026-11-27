/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.criptidos.modelo;
/**
 *
 * @author Darrell
 */

/**
 * Clase MapaJuego que representa un componente del sistema de criptidos.
 */
public class MapaJuego {
    private String[][] matrizMapa;
    private String[][] matrizEstado;
    private int posX, posY, tamano;
    /**
     * Constructor de la clase.
     */
    public MapaJuego(int tamano, int nivelActual) {
        this.tamano = tamano; matrizMapa = new String[tamano][tamano]; matrizEstado = new String[tamano][tamano];
        posX = 0; posY = 0; cargarMapa(nivelActual);
    }
    private void cargarMapa(int nivelActual) {
        for (int f = 0; f < tamano; f++) {
            for (int c = 0; c < tamano; c++) {
                matrizMapa[f][c] = "Vacio"; matrizEstado[f][c] = "Oculto";
            }
        }
        if (nivelActual == 0) { 
            matrizMapa[1][4] = "Pista1"; matrizMapa[4][2] = "Pista2"; matrizMapa[5][5] = "Pista3";
            matrizMapa[3][5] = "Pregunta1"; matrizMapa[0][1] = "Pregunta2"; 
            matrizMapa[1][0] = "Pregunta3"; matrizMapa[4][0] = "Pregunta4"; matrizMapa[5][1] = "Criptido";
        } else if (nivelActual == 1) { 
            matrizMapa[0][5] = "Pista1"; matrizMapa[5][5] = "Pista2"; matrizMapa[2][3] = "Pista3";
            matrizMapa[2][0] = "Pregunta1"; matrizMapa[3][2] = "Pregunta2";
            matrizMapa[1][2] = "Pregunta3"; matrizMapa[4][1] = "Pregunta4"; matrizMapa[4][5] = "Criptido";
        } else if (nivelActual == 2) { 
            matrizMapa[1][1] = "Pista1"; matrizMapa[0][4] = "Pista2"; matrizMapa[4][5] = "Pista3"; matrizMapa[2][2] = "Pista4";
            matrizMapa[5][0] = "Pregunta1"; matrizMapa[1][5] = "Pregunta2"; 
            matrizMapa[3][0] = "Pregunta3"; matrizMapa[5][3] = "Pregunta4"; matrizMapa[3][4] = "Criptido";
        } else if (nivelActual == 3) { 
            matrizMapa[0][0] = "Pista1"; matrizMapa[2][5] = "Pista2"; matrizMapa[5][1] = "Pista3"; matrizMapa[4][4] = "Pista4";
            matrizMapa[0][3] = "Pregunta1"; matrizMapa[3][1] = "Pregunta2"; matrizMapa[5][5] = "Pregunta3"; matrizMapa[2][2] = "Criptido";
        }
    }
    /**

     * Metodo funcional de la clase.

     */
    public void mover(int movX, int movY) {
        int xTemp = posX + movX; int yTemp = posY + movY;
        if (xTemp >= 0 && xTemp < tamano && yTemp >= 0 && yTemp < tamano) { posX = xTemp; posY = yTemp; }
    }
    /**

     * Metodo funcional de la clase.

     */
    public String explorarCasilla(boolean sePuedeGanar) throws ExcepcionJuego {
        if (matrizEstado[posY][posX].equals("Explorado")) return "YaExplorado";
        String eventoEncontrado = matrizMapa[posY][posX];
        if (eventoEncontrado.equals("Criptido") && sePuedeGanar == false) {
            throw new ExcepcionJuego("Aun faltan pistas o preguntas por resolver en este nivel.");
        }
        matrizEstado[posY][posX] = "Explorado";
        return eventoEncontrado;
    }
    /**

     * Metodo funcional de la clase.

     */
    public boolean verificarExplorado(int f, int c) { return matrizEstado[f][c].equals("Explorado"); }
    /**

     * Metodo funcional de la clase.

     */
    public int getPosX() { return posX; }
    /**

     * Metodo funcional de la clase.

     */
    public int getPosY() { return posY; }
    /**

     * Metodo funcional de la clase.

     */
    public int getTamano() { return tamano; }
}