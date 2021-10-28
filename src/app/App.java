package app;

import controlador.Controlador;
import modelo.Modelo;
import vista.Ventana;

public class App {

    public static void main(String[] args) {
        Ventana v = new Ventana();
        Modelo m = new Modelo(v);
        Controlador c = new Controlador(v,m);
    }

}
