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
            this.vista.getVentanaPasswordEncriptar().setVisible(true);
        }

        if(e.getSource().equals(this.vista.getBotonDesencriptar())){
            this.vista.getVentanaPasswordDesencriptar().setVisible(true);
        }

        if(e.getSource().equals(this.vista.getVentanaPasswordEncriptar().getBotonContrasenia())){

            try {
                if(this.modelo.checkPassword(this.vista.getVentanaPasswordEncriptar().getJTFContrasenia().getText())==true){
                    this.modelo.encriptarArchivo(this.vista.getJTFArchivo().getText());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
                }
            } catch (NoSuchAlgorithmException | IOException ex) {
                ex.printStackTrace();
            }
        }

        if(e.getSource().equals(this.vista.getVentanaPasswordDesencriptar().getBotonContrasenia())){
            try {
                if(this.modelo.checkPassword(this.vista.getVentanaPasswordDesencriptar().getJTFContrasenia().getText())==true){
                    this.modelo.desencriptarArchivo(this.vista.getJTFArchivo().getText());
                }
                else{
                    JOptionPane.showMessageDialog(null,"Contraseña incorrecta");
                }
            } catch (NoSuchAlgorithmException | IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}

