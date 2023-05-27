package com.lumtec.computo;

import java.text.DecimalFormat;

/**
 *
 * @author LuiZzi
 */
public abstract class FuncionesMatematicas {

    /*
    Regresa el IVA de una cantidad
     */
    public static double returnIva(double cantidad) {
        return cantidad * .16;

    }

    public static double recortarDecimales(double valor) {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.parseDouble(df.format(valor));
    }

}
