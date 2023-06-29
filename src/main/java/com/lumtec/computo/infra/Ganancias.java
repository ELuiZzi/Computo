package com.lumtec.computo.infra;

import java.math.BigDecimal;

public class Ganancias {

    //Este método recibe el precio de compra de un producto y te devuelve el porcentaje que se le debe de aumentar
    public static Integer getGanancia(BigDecimal price) {
        //El valor default de ganancia es de 100, lo que quiere decir que en caso de algún error, devolverá el 100% de ganancia
        Integer ganancia = 100;

        if (price.compareTo(new BigDecimal(20)) < 0) {
            ganancia = 400;
        } else if (price.compareTo(new BigDecimal(30)) < 0) {
            ganancia = 200;
        } else if (price.compareTo(new BigDecimal(40)) < 0) {
            ganancia = 133;
        } else if (price.compareTo(new BigDecimal(50)) < 0) {
            ganancia = 100;
        } else if (price.compareTo(new BigDecimal(60)) < 0) {
            ganancia = 80;
        } else if (price.compareTo(new BigDecimal(70)) < 0) {
            ganancia = 67;
        } else if (price.compareTo(new BigDecimal(80)) < 0) {
            ganancia = 57;
        } else if (price.compareTo(new BigDecimal(90)) < 0) {
            ganancia = 50;
        } else if (price.compareTo(new BigDecimal(100)) < 0) {
            ganancia = 44;
        } else if (price.compareTo(new BigDecimal(120)) < 0) {
            ganancia = 50;
        } else if (price.compareTo(new BigDecimal(160)) < 0) {
            ganancia = 36;
        } else if (price.compareTo(new BigDecimal(200)) < 0) {
            ganancia = 33;
        } else if (price.compareTo(new BigDecimal(340)) < 0) {
            ganancia = 25;
        } else if (price.compareTo(new BigDecimal(480)) < 0) {
            ganancia = 20;
        } else if (price.compareTo(new BigDecimal(750)) < 0) {
            ganancia = 16;
        } else if (price.compareTo(new BigDecimal(1000)) < 0) {
            ganancia = 11;
        } else if (price.compareTo(new BigDecimal(1000)) > 0) {
            ganancia = 11;
        }

        return ganancia;
    }

}
