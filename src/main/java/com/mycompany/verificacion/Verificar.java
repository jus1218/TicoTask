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
    public static boolean verificarRangoFecha(String[] data, Date inicioProj, Date finalProj) throws ParseException {

        if (verificarCongruenciaFechas(data[1], data[2])) {
            Date fechaIni = new SimpleDateFormat("dd/MM/yyyy").parse(data[1]);
            Date fechaFina = new SimpleDateFormat("dd/MM/yyyy").parse(data[2]);
            
            if (fechaIni.after(inicioProj) && fechaFina.before(finalProj)) return true; 
        }
        return false;
    }
}
