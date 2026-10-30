/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.main.criptobitacora.Modelo;

/**
 *
 * @author Parallax
 */
public class Capitulo {
    private int numero;
    private String titulo;
    private Criptido criptido;
    private String[][] mapaTerreno; // Arreglo bidimensional requerido

    public Capitulo(int numero, String titulo, Criptido criptido, int filas, int columnas) {
        this.numero = numero;
        this.titulo = titulo;
        this.criptido = criptido;
        this.mapaTerreno = new String[filas][columnas];
        inicializarMapa();
    }

    private void inicializarMapa() {
        for (int i = 0; i < mapaTerreno.length; i++) {
            for (int j = 0; j < mapaTerreno[i].length; j++) {
                mapaTerreno[i][j] = "Sin rastros";
            }
        }
        if (mapaTerreno.length > 1 && mapaTerreno[0].length > 1) {
            mapaTerreno[0][1] = "Muestra biológica hallada";
            mapaTerreno[1][0] = "Huella sospechosa";
        }
    }

    public String explorarCoordenada(int fila, int columna) {
        if (fila >= 0 && fila < mapaTerreno.length && columna >= 0 && columna < mapaTerreno[0].length) {
            return mapaTerreno[fila][columna];
        }
        return "Coordenada inválida.";
    }

}
