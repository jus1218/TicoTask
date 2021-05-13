package com.mycompany.verificacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Verificar {

    public Verificar() {
    }

    public static boolean verificarCongruenciaFechas(String fInicio, String fFinal) throws ParseException {
        //Convierto FechaInicio y final en Date para despues verificar
        Date fechaIni = new SimpleDateFormat("dd/MM/yyyy").parse(fInicio);
        Date fechaFina = new SimpleDateFormat("dd/MM/yyyy").parse(fFinal);
        //retorna false si existe incongruencia en fechas
        return fechaIni.before(fechaFina);
    }

    //verificarRango
    public static boolean verificarRangoFechaSprint(String[] data) throws ParseException {

        if (verificarCongruenciaFechas(data[0], data[1])) {
            //se llama el contenedor para verificar con id
            //despues si exis
            //ProyectoContainer.
        }

        return false;
    }

    public static boolean verificarRangoFechaTask(String[] data) throws ParseException {

        if (verificarCongruenciaFechas(data[0], data[1])) {
            //se llama el contenedor para verificar con id
            //despues si exis
            //ProyectoContainer.
        }

        return false;
    }
}
