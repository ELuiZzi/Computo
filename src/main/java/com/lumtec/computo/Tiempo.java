package com.lumtec.computo;

import java.util.Date;

public class Tiempo {

    private static String fechaLarga;
    private static String mes;
    private static int dia;
    private static String año;
    private static Date fecha;

    public static String getMes() {
        fecha = new Date();
        switch (fecha.getMonth()) {
            case 0:
                mes = "Enero";
                break;
            case 1:
                mes = "Febrero";
                break;
            case 2:
                mes = "Marzo";
                break;
            case 3:
                mes = "Abril";
                break;
            case 4:
                mes = "Mayo";
                break;
            case 5:
                mes = "Junio";
                break;
            case 6:
                mes = "Julio";
                break;
            case 7:
                mes = "Agosto";
                break;
            case 8:
                mes = "Septiembre";
                break;
            case 9:
                mes = "Octubre";
                break;
            case 10:
                mes = "Noviembre";
                break;
            case 11:
                mes = "Diciembre";
                break;
            default: {
                mes = "Nulo";
            }
        }

        return mes;
    }

    public static String getDia() {
        fecha = new Date();
        dia = fecha.getDate();

        return Integer.toString(dia);
    }

    public static String getAño() {
        fecha = new Date();
        int suma = fecha.getYear() + 1900;
        año = Integer.toString(suma);
        return año;
    }

    public static String getFecha() {
        return fechaLarga = getDia() + " / " + getMes() + " / " + getAño();
    }

    

}
