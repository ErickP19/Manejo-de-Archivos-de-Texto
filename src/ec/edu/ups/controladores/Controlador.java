/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controladores;

import ec.edu.ups.modelo.Palabras;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author erics
 */
public class Controlador {
    
    private String palabra;
    private List<Palabras> lista;

    public Controlador() {
        lista = new ArrayList<>();
    }
    public void modelo(String ruta) throws IOException {
        palabra = "";
        try {
            FileReader archivo = new FileReader(ruta);
            BufferedReader leer = new BufferedReader(archivo);
            while (palabra != null) {
                palabra = leer.readLine();
                if (palabra != null) {
                    leer();
                }
            }

        } catch (FileNotFoundException errorArc) {

            System.out.println("No existe el archivo");
            System.out.println(errorArc.toString());

        } catch (IOException errorLeer) {

            System.out.println("Error de Escritura");
            System.out.println(errorLeer.toString());

        }

    }

    public void comprobar(String palabra) {

        int cont = 0;
        for (Palabras pala : lista) {

            if (pala.getNombre().equals(palabra)) {

                pala.setCantidad(pala.getCantidad() + 1);
                cont++;

                break;

            }
        }

        if (cont == 0) {

            Palabras pal = new Palabras();
            pal.setNombre(palabra);
            pal.setCantidad(1);
            lista.add(pal);

        }
    }

    public void leer() {

        String palabras[] = palabra.split(" ");
        for (int i = 0; i < palabras.length; i++) {

            comprobar(palabras[i].toLowerCase());
            System.out.println(palabras[i]);

        }

    }

    public void escribir() throws IOException {

        Collections.sort(lista, new Comparator<Palabras>() {

            public int compare(Palabras p1, Palabras p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }

        });

        try {

            String ruta = "Resultado.txt";
            FileWriter archivo = new FileWriter(ruta, false);
            BufferedWriter escribir = new BufferedWriter(archivo);

            System.out.println("RESPUESTA");
            for (Palabras p1 : lista) {

                escribir.append(p1.getNombre() + " " + p1.getCantidad());
                escribir.newLine();
                System.out.println(p1.getNombre() + " " + p1.getCantidad());

            }

            escribir.close();
            archivo.close();

        } catch (IndexOutOfBoundsException error) {

            System.out.println("No se pudo escribir");

        }
    }
}

