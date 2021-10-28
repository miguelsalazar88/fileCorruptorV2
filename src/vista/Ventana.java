package vista;

import controlador.Controlador;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private Panel panel = new Panel();
    private Controlador controlador;
    private JButton botonEncriptar = new JButton("Encriptar Archivo");
    private JButton botonDesencriptar = new JButton("Desencriptar Archivo");
    private JLabel labelArchivo = new JLabel("Archivo:");
    private JTextField JTFArchivo = new JTextField();
    private VentanaPassword ventanaPasswordEncriptar = new VentanaPassword();
    private VentanaPassword ventanaPasswordDesencriptar = new VentanaPassword();

    public Ventana(){
        this.setTitle("File Corruptor");
        this.setSize(500,400);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.lightGray);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.initComponents();
    }

    private void initComponents() {
        this.add(panel);
        this.add(botonEncriptar);
        this.botonEncriptar.setBounds(340,85+200,150,30);
        this.add(botonDesencriptar);
        this.botonDesencriptar.setBounds(340,115+200,150,30);
        this.add(labelArchivo);
        this.labelArchivo.setBounds(10,100+200,80,30);
        this.add(JTFArchivo);
        this.JTFArchivo.setBounds(90,100+200,250,30);
        this.ventanaPasswordEncriptar.setTitle("Encriptar");
        this.ventanaPasswordDesencriptar.setTitle("Desencriptar");
        this.ventanaPasswordEncriptar.getBotonContrasenia().setText("Encriptar");
        this.ventanaPasswordDesencriptar.getBotonContrasenia().setText("Desencriptar");

    }

    public void setController(Controlador cont) {
        this.controlador = cont;
        this.botonEncriptar.addActionListener(this.controlador);
        this.botonDesencriptar.addActionListener(this.controlador);
    }

    //Getters y Setters


    public JButton getBotonEncriptar() {
        return botonEncriptar;
    }

    public JTextField getJTFArchivo() {
        return JTFArchivo;
    }

    public JButton getBotonDesencriptar() {
        return botonDesencriptar;
    }

    public VentanaPassword getVentanaPasswordEncriptar() {
        return ventanaPasswordEncriptar;
    }

    public VentanaPassword getVentanaPasswordDesencriptar() {
        return ventanaPasswordDesencriptar;
    }
}
