package modelo;

import vista.Ventana;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Modelo {

    private Ventana vista;
    Random rnd = new Random();

    public Modelo(Ventana vista){
        this.vista = vista;
    }

    public boolean checkPassword(String password) throws NoSuchAlgorithmException {
        if(crearHash(password).equals(crearHash("anitalavalatina"))){
            return true;
        }
        else{
            return false;
        }
    }

    public String crearHash(String textToHash) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
        byte[] hashedByteArray = digest.digest(byteOfTextToHash);
        String encoded = Base64.getEncoder().encodeToString(hashedByteArray);
        return encoded;
    }

    public void encriptarArchivo(String archivo,String encoder) throws IOException {

        byte[] fileBytes = Files.readAllBytes(Paths.get(archivo)); //Se reciben los bytes del archivo en un arreglo estático de bytes
        byte[] bytesEncoder = encoder.getBytes();

        List<Byte> bytesArray = new ArrayList<>(); //Se crea un arraylist de bytes

        for (byte b : fileBytes) {
            bytesArray.add(b); // Se carga el arraylist de bytes con los datos del arreglo estático
        }

        int rand = rnd.nextInt(bytesArray.size()); //Se crea un indice random para ubicar el encoder

        for (int i = 0; i < bytesEncoder.length; i++) {  //Se inserta el encoder en la ubicacion random
            bytesArray.add((rand+i),(byte) encoder.charAt(i));
        }

        byte[] resultado = new byte[bytesArray.size()]; //Se crea un nuevo arreglo de bytes con el archivo corrupto
        for(int i = 0; i < bytesArray.size(); i++) {
            resultado[i] = bytesArray.get(i); //Se carga el arreglo con los datos del arraylist
        }

        try (FileOutputStream stream = new FileOutputStream(archivo)) {
            stream.write(resultado); //Se escribe el archivo corrupto
        }
        JOptionPane.showMessageDialog(null, "Archivo Exitosamente Encriptado");
    }

    public void desencriptarArchivo(String archivo, String encoder) throws IOException {

        //Se convierte el archivo seleccionado a un arreglo de bytes
        byte[] fileBytes = Files.readAllBytes(Paths.get(archivo));
        //Se crea un ArrayList<Byte> en el que se almacena el arreglo de bytes.
        List<Byte> bytesArray = new ArrayList<>();
        //Se convierte la clave en un arreglo de bytes.
        byte[] bytesEncoder = encoder.getBytes();


        for (byte b : fileBytes) {
            bytesArray.add(b);
        }


        for (int i = 0; i < bytesArray.size(); i++) {
            if(bytesArray.get(i) == (byte) encoder.charAt(0)
                    && bytesArray.get(i+1) == (byte) encoder.charAt(1)
                    && bytesArray.get(i+2) == (byte) encoder.charAt(2)
                    && bytesArray.get(i+3) == (byte) encoder.charAt(3)
            ){

                System.out.println("Eureka");

                for (int j = 0; j < bytesEncoder.length; j++) {
                    bytesArray.remove(i);
                }

                JOptionPane.showMessageDialog(null, "Archivo Exitosamente Desencriptado");
            }
        }

        byte[] resultado = new byte[bytesArray.size()];
        for(int i = 0; i < bytesArray.size(); i++) {
            resultado[i] = bytesArray.get(i);
        }

        try (FileOutputStream stream = new FileOutputStream(archivo)) {
            stream.write(resultado);
        }



    }

}
