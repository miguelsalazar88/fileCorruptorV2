package controlador;

import modelo.Modelo;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Controlador implements ActionListener {

    private Ventana vista;
    private Modelo modelo;

    public Controlador(Ventana vista, Modelo modelo){
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setController(this);
        this.vista.getVentanaPasswordEncriptar().setControlador(this);
        this.vista.getVentanaPasswordDesencriptar().setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(this.vista.getBotonEncriptar())){

            if(!this.vista.getJTFArchivo().getText().equals("")){
                //Se abre la ventana que pide la clave para encriptar.
                this.vista.getVentanaPasswordEncriptar().setVisible(true);
            }

            else{
                JOptionPane.showMessageDialog(null,"No hay datos del Archivo");
            }
        }

        if(e.getSource().equals(this.vista.getBotonDesencriptar())){
            if(!this.vista.getJTFArchivo().getText().equals("")){
                //Se abre la ventana que pide la clave para encriptar.
                this.vista.getVentanaPasswordDesencriptar().setVisible(true);
            }

            else{
                JOptionPane.showMessageDialog(null,"No hay datos del Archivo");
            }
        }

        if(e.getSource().equals(this.vista.getVentanaPasswordEncriptar().getBotonContrasenia())){

            try {
                // Se encripta el archivo
                this.modelo.encriptarArchivo(this.vista.getJTFArchivo().getText(),this.vista.getVentanaPasswordEncriptar().getJTFContrasenia().getText());
                // Se cierra el programa
                System.exit(0);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource().equals(this.vista.getVentanaPasswordDesencriptar().getBotonContrasenia())){
            try {
                // Se desencripta el archivo
                this.modelo.desencriptarArchivo(this.vista.getJTFArchivo().getText(),this.vista.getVentanaPasswordDesencriptar().getJTFContrasenia().getText());
                //Se cierra el programa
                System.exit(0);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}

