/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import ec.edu.ups.controladores.Controlador;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author erics
 */
public class Main {
    public static void main(String[]args) throws IOException{
        System.out.println("Las Palabras de los archivos son:");
        Controlador control = new Controlador();
        String ruta = "C:\\Users\\erics\\OneDrive\\Documentos\\NetBeansProjects\\ArchivosDeTexto\\src\\ec\\edu\\ups\\texto";  
        File archivo1 = new File(ruta);
        File[] archivo2 = archivo1.listFiles();
        for (File archi : archivo2) {
            if (!archi.getName().equals("ConteoPalabras.txt")) {   
                control.modelo(ruta + "\\" + archi.getName());     
            }
        }    
        control.escribir();
    }
}
