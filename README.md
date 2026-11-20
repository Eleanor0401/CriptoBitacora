# CriptoBitácora: Expedición al Límite de la Ciencia

Proyecto Programado - Etapa 1  
**Curso:** TM-2100 Fundamentos de Programación  
**Universidad de Costa Rica - Sede Regional del Pacífico**  

## Integrantes
Darrell Perez Guerrero C4I350


## Descripción
Libro interactivo educativo desarrollado en Java (Maven) bajo la arquitectura Modelo-Vista-Controlador (MVC), enfocado en la exploración del método científico a través del estudio de críptidos y leyendas biológicas.

## Estructura del Proyecto
* `ucr.ac.cr.criptidos.modelo`: Jerarquía de clases (`Criptido`, `CriptidoTerrestre`, `CriptidoVolador`, `CriptidoAcuatico`), interfaces (`Investigable`), excepciones personalizadas (`ExcepcionJuego`) y la lógica de datos (`MapaJuego`, `RegistroJuego`).
* `ucr.ac.cr.criptidos.vista`: Componentes de interfaz gráfica en Java Swing editables desde NetBeans (`FrmMain`, `FrmNivel`, `PanelBotones`).
* `ucr.ac.cr.criptidos.controlador`: Coordinación de eventos, acciones de teclado y lógica general mediante `ActionListener` y `KeyListener` (`ControllerMain`, `ControllerNivel`).
* `ucr.ac.cr.criptidos`: Punto de entrada principal de la aplicación (`Main`).
