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
    public static boolean verificarRangoFecha(String inicioHijo,String finalHijo, Date inicioProj, Date finalProj) throws ParseException {

        if (verificarCongruenciaFechas(inicioHijo, finalHijo)) {
            Date fechaIni = new SimpleDateFormat("dd/MM/yyyy").parse(inicioHijo);
            Date fechaFina = new SimpleDateFormat("dd/MM/yyyy").parse(finalHijo);

            if (fechaIni.after(inicioProj) && fechaFina.before(finalProj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean verificarEstado(String pEstado) {
        if (pEstado.equals("Activo") || pEstado.equals("Inactivo") || pEstado.equals("activo") || pEstado.equals("inactivo")) {
            return true;
        }
        return false;
    }
}
