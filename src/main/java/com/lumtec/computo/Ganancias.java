package com.lumtec.computo;

public class Ganancias {

    //Este método recibe el precio de compra de un producto y te devuelve el porcentaje que se le debe de aumentar
    public float setGanancia(float price) {
        //El valor default de ganancia es de 100, lo que quiere decir que en caso de algún error, devolverá el 100% de ganancia
        float ganancia = 100;

        if (price <= 10) {
            ganancia = 400;
        } else if (price < 20) {
            ganancia = 400;
        } else if (price < 30) {
            ganancia = 200;
        } else if (price < 40) {
            ganancia = 133;
        } else if (price < 50) {
            ganancia = 100;
        } else if (price < 60) {
            ganancia = 80;
        } else if (price < 70) {
            ganancia = 67;
        } else if (price < 80) {
            ganancia = 57;
        } else if (price < 90) {
            ganancia = 50;
        } else if (price < 100) {
            ganancia = 44;
        } else if (price < 120) {
            ganancia = 50;
        } else if (price < 140) {
            ganancia = 42;
        } else if (price < 160) {
            ganancia = 36;
        } else if (price < 180) {
            ganancia = 38;
        } else if (price < 200) {
            ganancia = 33;
        } else if (price < 220) {
            ganancia = 30;
        } else if (price < 240) {
            ganancia = 27;
        } else if (price < 260) {
            ganancia = 25;
        } else if (price < 280) {
            ganancia = 27;
        } else if (price < 300) {
            ganancia = 25;
        } else if (price < 320) {
            ganancia = 23;
        } else if (price < 340) {
            ganancia = 25;
        } else if (price < 360) {
            ganancia = 24;
        } else if (price < 380) {
            ganancia = 22;
        } else if (price < 400) {
            ganancia = 21;
        } else if (price < 420) {
            ganancia = 23;
        } else if (price < 440) {
            ganancia = 21;
        } else if (price < 460) {
            ganancia = 20;
        } else if (price < 480) {
            ganancia = 20;
        } else if (price < 500) {
            ganancia = 21;
        } else if (price < 550) {
            ganancia = 20;
        } else if (price < 600) {
            ganancia = 18;
        } else if (price < 650) {
            ganancia = 17;
        } else if (price < 700) {
            ganancia = 17;
        } else if (price < 750) {
            ganancia = 16;
        } else if (price < 800) {
            ganancia = 15;
        } else if (price < 850) {
            ganancia = 13;
        } else if (price < 900) {
            ganancia = 12;
        } else if (price < 950) {
            ganancia = 11;
        } else if (price < 1000) {
            ganancia = 11;
        }

        return ganancia;
    }

}
