package com.lumtec.computo.infra;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

/**
 * @author LuiZzi
 */
public abstract class FuncionesMatematicas {

    /*
    Regresa el IVA de una cantidad
     */
    public static BigDecimal returnIva(BigDecimal cantidad) {
        return cantidad.multiply(new BigDecimal(".16"));

    }

    public static double recortarDecimales(double valor) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(valor));
    }

    public static BigDecimal cantidadAumentada(BigDecimal precio, BigDecimal porcentajeAumentado) {

        BigDecimal aumentoEnDecimal = porcentajeAumentado.divide(new BigDecimal(100), new MathContext(5));

        return precio.multiply(aumentoEnDecimal, new MathContext(4));

    }

}
