package com.mycompany.view;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    private static Console console = System.console();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String input(String msj) {
        boolean opc = false;
        String data = "";
        String answer;
        do {
            imprimir(msj);
            data = readline();//capta los valores. y / n
            imprimir("Confirmar entrada( y / n )");
            answer = readline();
            if (answer.startsWith("y")) {//si (answer = y) cambia a true y retorna
                opc = true;
            }

        } while (!opc);
        return data;
    }

    public static String[] input(String name, String[] msgs) {
        String[] data = new String[msgs.length];//le da tamano al arreglo
        imprimir("-------" + name + "-------");//imprime el titulo
        for (int i = 0; i < msgs.length; i++) {
            data[i] = input(msgs[i]);//muestra los mensajes con las confimaciones 
        }
        return data;
    }

    public static void imprimir(String msj) {//imprime el mensaje enviado
        System.out.println(msj);
    }

    private static String readline() {//verifica el dato ingresado por el usuario
        if (console != null) {
            return console.readLine();
        } else {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                imprimir("Error de lectura del sistema");
                return null;
            }
        }
    }

    public static int menu(String title, String[] options) {
        int opt = -1;
        // .toUpperCase => vuelve los caracteres en mayuscula.
        imprimir("===============" + title.toUpperCase() + "===============");
        imprimir("Seleccione una opcion del menu.\n");
        for (int i = 0; i < options.length; i++) {//opciones
            imprimir((i + 1) + "------------------" + options[i]);
        }
        do {
            opt = Integer.parseInt(readline().trim());//capta la opcion
            // verifica si la opc esta dentro de las opcion existentes     
            if (opt > options.length || opt <= 0) {//sino esta dentro de las existentes entra
                imprimir("Ingrese una opcion entre 1 y " + options.length);
                opt = -1;
            }

        } while (opt == -1);

        return opt - 1;
    }
}
