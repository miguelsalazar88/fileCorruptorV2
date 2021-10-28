package vista;

import controlador.Controlador;

import javax.swing.*;

public class VentanaPassword extends JFrame {

    private Controlador controlador;
    private JTextField JTFContrasenia = new JTextField();
    private JLabel labelContrasenia = new JLabel("Contraseña:");
    private JButton botonContrasenia = new JButton();

    public VentanaPassword(){
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setLayout(null);
        this.setSize(500,200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.initComponents();
    }

    private void initComponents() {
        this.add(labelContrasenia);
        this.labelContrasenia.setBounds(10,50,100,30);
        this.add(JTFContrasenia);
        this.JTFContrasenia.setBounds(110,50,200,30);
        this.add(botonContrasenia);
        this.botonContrasenia.setBounds(310,50,150,30);
    }

    public void setControlador(Controlador controlador){
        this.controlador = controlador;
        this.botonContrasenia.addActionListener(this.controlador);
    }

    //Getters y Setters


    public JTextField getJTFContrasenia() {
        return JTFContrasenia;
    }

    public JButton getBotonContrasenia() {
        return botonContrasenia;
    }

}
