/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.criptidos.controlador;
/**
 *
 * @author Darrell
 */

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import ucr.ac.cr.criptidos.modelo.*;
import ucr.ac.cr.criptidos.vista.FrmNivel;

public class ControllerNivel implements ActionListener, KeyListener {
    
    private FrmNivel frmNivel;
    private MapaJuego mapa;
    private RegistroJuego registro;
    private ControllerMain controllerMain;
    private Criptido criptidoActual;
    
    private int nivel;
    private int pistasReq, pregsReq, pistasRecogidas, pregsListas;
    
    private ImageIcon iconJugador;
    private ImageIcon iconOculto; 
    private ImageIcon iconExplorado;

    public ControllerNivel(int idNivel, RegistroJuego registro, ControllerMain controllerMain) {
        this.registro = registro;
        this.controllerMain = controllerMain;
        this.nivel = idNivel;
        
        mapa = new MapaJuego(6, nivel);
        frmNivel = new FrmNivel(6);
        frmNivel.setControlador(this, this);
        
        pistasRecogidas = 0; pregsListas = 0;
        
        precargarImagenes(); 
        cargarDatosNivel();
        dibujarUI();
        
        frmNivel.setVisible(true);
        frmNivel.requestFocusInWindow();
    }
    
    private ImageIcon escalarImagen(String ruta, int ancho, int alto) {
        try {
            java.net.URL imgUrl = getClass().getResource(ruta);
            if (imgUrl != null) {
                ImageIcon icono = new ImageIcon(imgUrl);
                Image img = icono.getImage();
                Image imgEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                return new ImageIcon(imgEscalada);
            }
        } catch (Exception e) {
            System.err.println("No se encontro la imagen: " + ruta);
        }
        return null;
    }
    
    private void precargarImagenes() {
        int tamanoCasilla = 80; 
        
        iconJugador = escalarImagen("/assets/Jugador.jpg", tamanoCasilla, tamanoCasilla);
        iconExplorado = escalarImagen("/assets/Explorado.jpg", tamanoCasilla, tamanoCasilla);
        
        if (nivel == 3) {
            iconOculto = escalarImagen("/assets/AguaSinExplorar.jpg", tamanoCasilla, tamanoCasilla);
        } else {
            iconOculto = escalarImagen("/assets/SinExplorar.jpg", tamanoCasilla, tamanoCasilla);
        }
    }
    
    private void cargarDatosNivel() {
        ImageIcon imgCriptido = null;
        
        if (nivel == 0) {
            pistasReq = 3; pregsReq = 4;
            String textoLibro = "LORE DEL MOTHMAN:\n\n" +
                "A finales de 1966, varios testigos reportaron una figura alada del tamano de un hombre " +
                "con ojos rojos brillantes cerca de una antigua planta de municiones de la Segunda Guerra Mundial (Zona TNT).\n\n" +
                "Afirmaban que dejaba a su paso huellas de tres garras, polvo gris iridiscente, y causaba estatica en las radios. " +
                "Su aparicion presagiaba el colapso tragico del puente Silver Bridge.";
            String[] arr = {"Encuentras polvo gris iridiscente.", "Hallas huellas de tres garras en el barro.", "Sufres estatica fuerte en la radio."};
            
            imgCriptido = escalarImagen("/assets/mothman.jpg", 200, 200);
            criptidoActual = new CriptidoVolador("Mothman", textoLibro, arr, imgCriptido);
            
        } else if (nivel == 1) {
            pistasReq = 3; pregsReq = 4;
            String textoLibro = "LORE DEL CHUPACABRAS:\n\n" +
                "El mito nacio en 1995 en Canovanas, Puerto Rico. Granjeros reportaron " +
                "ganado drenado de sangre con extranas punciones.\n\n" +
                "Fue descrito como un reptil bipedo con ojos alienigenas, dejando un rastro con olor a azufre y mucosidad verde. " +
                "El concepto erroneo de 'perro sarnoso' llego despues en Texas.";
            String[] arr = {"Cabra muerta con dos punciones limpias en el cuello.", "Olor insoportable a azufre puro.", "Rastro de mucosidad verdosa."};
            
            imgCriptido = escalarImagen("/assets/chupacabras.jpg", 200, 200);
            criptidoActual = new CriptidoTerrestre("Chupacabras", textoLibro, arr, imgCriptido);
            
        } else if (nivel == 2) {
            pistasReq = 4; pregsReq = 4;
            String textoLibro = "LORE DE PIE GRANDE:\n\n" +
                "El Sasquatch es un hominido peludo de Norteamerica.\n\n" +
                "Se han recolectado moldes de huellas gigantes (de mas de 45 cm), mechones de pelo oscuro " +
                "y se hallan arboles jovenes rotos intencionalmente, ademas de aullidos guturales.\n\n" +
                "A pesar del video de Patterson-Gimlin, la ciencia oficial no lo acepta y culpa a los osos.";
            String[] arr = {"Huella gigante de mas de 45 cm.", "Mechon de pelo muy grueso.", "Arboles jovenes rotos por la mitad.", "Aullido largo y gutural a lo lejos."};
            
            imgCriptido = escalarImagen("/assets/piegrande.jpg", 200, 200);
            criptidoActual = new CriptidoTerrestre("Pie Grande", textoLibro, arr, imgCriptido);
            
        } else if (nivel == 3) {
            pistasReq = 4; pregsReq = 3;
            String textoLibro = "LORE DE NESSIE:\n\n" +
                "En el lago escoces, testigos ven asomarse un cuello largo.\n\n" +
                "Se cree que es un plesiosaurio prehistorico que sobrevivio en el agua dulce. " +
                "Se caracteriza por alterar el sonar de los barcos, agitar el oleaje sin viento y devorar peces enteros.\n\n" +
                "La foto mas famosa de Nessie es una polaroid borrosa.";
            String[] arr = {"Lectura masiva en el sonar.", "Oleaje muy fuerte sin viento aparente.", "Restos de peces devorados enteros.", "Foto polaroid borrosa en la orilla."};
            
            imgCriptido = escalarImagen("/assets/nessie.jpg", 200, 200);
            criptidoActual = new CriptidoAcuatico("Nessie", textoLibro, arr, imgCriptido);
        }
        
        frmNivel.setTextoConsola("Area: " + criptidoActual.getNombre() + " iniciada.");
        frmNivel.addSeparadorConsola();
    }
    
    private void dibujarUI() {
        for (int i = 0; i < mapa.getTamano(); i++) {
            for (int j = 0; j < mapa.getTamano(); j++) {
                JLabel aux = frmNivel.getMatrizGrafica()[i][j];
                aux.setText("");
                
                if (i == mapa.getPosY() && j == mapa.getPosX()) {
                    if (iconJugador != null) aux.setIcon(iconJugador);
                    else { aux.setBackground(Color.YELLOW); aux.setText("P1"); }
                } else if (mapa.verificarExplorado(i, j)) {
                    if (iconExplorado != null) aux.setIcon(iconExplorado);
                    else { aux.setBackground(Color.DARK_GRAY); aux.setText("X"); }
                } else {
                    if (iconOculto != null) aux.setIcon(iconOculto);
                    else { 
                        if (nivel == 3) aux.setBackground(Color.BLUE);
                        else aux.setBackground(Color.LIGHT_GRAY); 
                    }
                }
            }
        }
        
        frmNivel.getPanelBotones().setStats(
            String.valueOf(registro.getPuntosTotales()), 
            String.valueOf(registro.getCantAciertos()), 
            "Progreso: [" + pistasRecogidas + "/" + pistasReq + "] [" + pregsListas + "/" + pregsReq + "]"
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("btnAtras")) {
            frmNivel.dispose();
            controllerMain.devolverAlMenu();
        } 
        else if (e.getActionCommand().equals("btnLibro")) {
            JTextArea areaTexto = new JTextArea(criptidoActual.getInfoLibro());
            areaTexto.setLineWrap(true); areaTexto.setWrapStyleWord(true);
            areaTexto.setEditable(false); areaTexto.setBackground(new Color(255, 255, 230)); 
            areaTexto.setColumns(40); areaTexto.setRows(12);
            areaTexto.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14));
            
            JScrollPane scroll = new JScrollPane(areaTexto);
            JOptionPane.showMessageDialog(frmNivel, scroll, "Libro de Notas", JOptionPane.INFORMATION_MESSAGE);
            frmNivel.requestFocusInWindow();
        } 
        else if (e.getActionCommand().equals("btnInvestigar")) {
            frmNivel.getPanelBotones().setInvestigarEnabled(false);
            boolean sePuedeGanar = (pistasRecogidas >= pistasReq && pregsListas >= pregsReq);
            String casillaRevelada = "";
            
            try {
                casillaRevelada = mapa.explorarCasilla(sePuedeGanar);
                dibujarUI(); 
                
                if (casillaRevelada.equals("YaExplorado")) {
                    frmNivel.addTextoConsola("Ya revisaste aqui. Muevete a otra zona.");
                    frmNivel.getPanelBotones().setInvestigarEnabled(true);
                    frmNivel.requestFocusInWindow();
                    return;
                }
                
                frmNivel.addTextoConsola("Buscando en la zona...");
                final String resultadoFinal = casillaRevelada;
                
                Timer t = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        procesarResultadoConsola(resultadoFinal);
                        frmNivel.getPanelBotones().setInvestigarEnabled(true);
                        frmNivel.requestFocusInWindow();
                        ((Timer)evt.getSource()).stop();
                    }
                });
                t.setRepeats(false);
                t.start();
                
            } catch (ExcepcionJuego ex) {
                frmNivel.addTextoConsola(ex.getMessage());
                frmNivel.addSeparadorConsola(); 
                frmNivel.getPanelBotones().setInvestigarEnabled(true);
                frmNivel.requestFocusInWindow();
            }
        }
    }
    
    private void procesarResultadoConsola(String evento) {
        if (evento.equals("Vacio")) {
            frmNivel.addTextoConsola("No se encontro nada util.");
            frmNivel.addSeparadorConsola(); 
        } else if (evento.startsWith("Pista")) {
            int id = Integer.parseInt(evento.replace("Pista", "")) - 1;
            frmNivel.addTextoConsola("¡Pista! " + criptidoActual.getPista(id));
            registro.agregarPuntos(10);
            pistasRecogidas++;
            frmNivel.addSeparadorConsola(); 
        } else if (evento.startsWith("Pregunta")) {
            int id = Integer.parseInt(evento.replace("Pregunta", ""));
            frmNivel.addTextoConsola("Una anomalia genera una duda...");
            hacerPregunta(id);
            pregsListas++;
            frmNivel.addSeparadorConsola(); 
        } else if (evento.equals("Criptido")) {
            ganarPartida();
        }
        dibujarUI(); 
    }
    
    private void hacerPregunta(int numero) {
        String p = ""; boolean resCorrecta = true;
        if (nivel == 0) {
            if (numero == 1) p = "¿El primer avistamiento fue cerca de la antigua planta de municiones (Zona TNT)?"; resCorrecta = true;
            if (numero == 2) { p = "¿El mito dice que presagiaba el colapso del Golden Gate?"; resCorrecta = false; }
            if (numero == 3) { p = "¿El polvo del rastro es descrito como polvo de estrellas rojo?"; resCorrecta = false; }
            if (numero == 4) { p = "¿La criatura causa estatica en las radios de comunicacion?"; resCorrecta = true; }
        } else if (nivel == 1) {
            if (numero == 1) p = "¿El chupacabras fue originalmente reportado en 1995 en Canovanas, Puerto Rico?"; resCorrecta = true;
            if (numero == 2) { p = "¿Deja un olor muy fuerte parecido al azufre?"; resCorrecta = true; }
            if (numero == 3) { p = "¿Su primer avistamiento lo describe como un perro sarnoso de Texas?"; resCorrecta = false; }
            if (numero == 4) { p = "¿Las victimas son drenadas de sangre mediante extranas punciones?"; resCorrecta = true; }
        } else if (nivel == 2) {
            if (numero == 1) p = "¿Se le conoce tambien popularmente como Sasquatch?"; resCorrecta = true;
            if (numero == 2) { p = "¿El famoso video fue grabado por Patterson-Gimlin?"; resCorrecta = true; }
            if (numero == 3) { p = "¿La ciencia oficial acepta todas estas pruebas como irrefutables?"; resCorrecta = false; }
            if (numero == 4) { p = "¿Las huellas encontradas miden menos de 10 cm usualmente?"; resCorrecta = false; }
        } else if (nivel == 3) {
            if (numero == 1) p = "¿El criptido supuestamente habita en un lago escoces?"; resCorrecta = true;
            if (numero == 2) { p = "¿La leyenda dice que es un tipo de plesiosaurio prehistorico?"; resCorrecta = true; }
            if (numero == 3) { p = "¿Se sabe que ataca fisicamente a los barcos grandes con sus garras?"; resCorrecta = false; }
        }
        
        JTextArea areaPregunta = new JTextArea(p);
        areaPregunta.setLineWrap(true); areaPregunta.setWrapStyleWord(true);
        areaPregunta.setEditable(false); areaPregunta.setBackground(frmNivel.getBackground());
        areaPregunta.setColumns(30); areaPregunta.setRows(3);
        
        int res = JOptionPane.showConfirmDialog(frmNivel, areaPregunta, "Pregunta de Investigacion", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION == resCorrecta) {
            registro.addAcierto(); frmNivel.addTextoConsola("¡Analisis Correcto! (+20 pt)");
        } else {
            registro.addError(); frmNivel.addTextoConsola("Analisis Incorrecto. (-10 pt)");
        }
    }
    
    private void ganarPartida() {
        registro.addCriptidoAlRegistro(criptidoActual);
        registro.setNivelCompletado(nivel);
        String t = "¡HAS ENCONTRADO AL CRIPTIDO!\n" + criptidoActual.mensajeAparicion() +
                   "\n\nAciertos Generales: " + registro.getCantAciertos() +
                   "\nErrores Generales: " + registro.getCantErrores() +
                   "\nPuntos: " + registro.getPuntosTotales();
                   
        JOptionPane.showMessageDialog(frmNivel, t, "MISTERIO RESUELTO", JOptionPane.INFORMATION_MESSAGE, criptidoActual.getImagenCriptido());
        
        frmNivel.dispose();
        controllerMain.devolverAlMenu();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) mapa.mover(0, -1);
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) mapa.mover(0, 1);
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) mapa.mover(-1, 0);
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) mapa.mover(1, 0);
        dibujarUI();
    }
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
}