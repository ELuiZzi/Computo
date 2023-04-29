package com.lumtec.computo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Search {

    //Número de busquedaa, 0: significa PRIMER BUSQUEDA, 1: + UNA BUSQUEDA.
    int noB = 0;
    //Este modelo copia los datos ORGINALES de la tabla, y los manda a 'filas'
    DefaultTableModel model = null;
    //Este objeto contiene todas las FILAS ORIGINALES
    Object[] filas;
    //Este objecto contiene las FILAS FILTRADAS
    Object[] filFilt, filFilt2;
    //Este char sirve para almacenar el caracter anterior.
    static char past = '\0';
    
    private static final int columna = 0; //Indice de columna que se va a buscar

    public Search(JTable inve) {
        //Cuando la clase carga, selecciona la LISTA ORIGINAL de la tabla, para almacenarla
        if (model == null) {
            model = (DefaultTableModel) inve.getModel();
            System.out.println("Modelo de tabla cargado");
        }

        past = '\0';
        filas = new Object[model.getRowCount()];
        guardarFilas();
    }

    public void Prueba() {
        if (past == '\0') {
            System.out.println("Negativo");
            past = 'l';
        } else {
            System.out.println("Positivo");
            past = '\0';
        }
    }

    //Guardar Datos Originales
    private void guardarFilas() {
        //Contiene la fila que indique el ciclo for
        String[] fila;

        for (int i = 0; i < model.getRowCount(); i++) {
            fila = new String[5];
            for (int l = 0; l < fila.length; l++) {
                fila[l] = (String) model.getValueAt(i, l);
            }
            filas[i] = fila;
        }
    }

    //Vacía la tabla.
    private void vaciarTabla() {
        model.setRowCount(0);
    }

    //Filtra los datos que no contengan el carácter que necesitamos
    private void filtrarDatos(char C) {
        //Conteo de filas que cumplen con el CHAR
        int cont = 0; //Ceunta cuantas filas tenemos
        int posi = 0; //Sirve como indicador, en donde agregar la fila que cumpla el requisito.
        String[] filaTemp, filaTemp2; //Este texto almcenara la fila actual, según sea el turno determinado por el 'for'
        //Primera vez escribiendo
        if (noB == 0) {
            //Ciclo duración: El número ORIGINAL de filas
            for (int i = 0; i < filas.length; i++) {
                filaTemp = (String[]) filas[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toLowerCase(C) || texto.charAt(l) == Character.toUpperCase(C)) {
                        //Aumentar el número de productos que cumplen el parentezco
                        ++cont;
                        break;
                    }
                }
            }

            filFilt = new Object[cont];
            for (int i = 0; i < filas.length; i++) {
                filaTemp = (String[]) filas[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toLowerCase(C) || texto.charAt(l) == Character.toUpperCase(C)) {
                        //Agregar al filtro, la columna que cumplió el parentezco
                        filFilt[posi] = filas[i];
                        ++posi;
                        break;
                    }
                }
            }
            ++noB;

        } //Demás busquedas
        else {

            //Ciclo for, duracion: Número de filas filtradas previamente
            for (int i = 0; i < filFilt.length; i++) {
                filaTemp = (String[]) filFilt[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toUpperCase(past) || texto.charAt(l) == Character.toLowerCase(past)) {
                        ++l;
                        try {
                            if (texto.charAt(l) == Character.toUpperCase(C) || texto.charAt(l) == Character.toLowerCase(C)) {
                                ++cont;
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException ex) {
                        }
                    }
                }
            }

            //Se crea un nuevo filtro temporal, que alacenara las filas filtradas del 
            filFilt2 = new Object[cont];
            for (int i = 0; i < filFilt.length; i++) {
                filaTemp = (String[]) filFilt[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toUpperCase(past) || texto.charAt(l) == Character.toLowerCase(past)) {
                        ++l;
                        try {
                            if (texto.charAt(l) == Character.toUpperCase(C) || texto.charAt(l) == Character.toLowerCase(C)) {
                                filFilt2[posi] = filFilt[i];
                                ++posi;
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException ex) {

                        }
                    }
                }
            }
            filFilt = filFilt2;
        }

        //Finalemte, el caracter presionado, se asgina a past
        past = C;
    }

    //Filtro de busqueda, con 2 paramentros de busqueda en la cadena de texto.
    private void filtrarDesbus(char A, char B) {

        past = '\0'; //Past es el cáracter pasado de busqueda, sirve como primer parámetro para la BUSQUEDA, dependiendo de la repuesto LOGICA tendrá un valor
        int cont = 0; //Contador de filas que cumplen el parentezco
        int posi = 0; //Posición del index, para colocar las filas filtradas
        String[] filaTemp; //Almacena una fila temporalmente
        if (A == '\0' && B != '\0') {
            System.out.println("Ultima Letra");
            for (int i = 0; i < filas.length; i++) {
                filaTemp = (String[]) filas[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toUpperCase(B) || texto.charAt(l) == Character.toLowerCase(B)) {
                        past = B; //Último carácter, 'past' tomará su valor
                        ++cont;
                        break;
                    }
                }
            }

            //Se crea un nuevo filtro temporal, que alacenará las filas filtradas del 
            filFilt = new Object[cont];
            for (int i = 0; i < filas.length; i++) {
                filaTemp = (String[]) filas[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toUpperCase(B) || texto.charAt(l) == Character.toLowerCase(B)) {
                        filFilt[posi] = filas[i];
                        ++posi;
                        break;
                    }
                }
            }
        } else if (A == '\0' && B == '\0') {
            past = '\0'; //Ningún carácter. 'past' se reinicia
            System.out.println("Ninguna letra");
            noB = 0;
            filFilt = filas;
        } else {
            past = B; //Varios carácteres, 'past' tomá el último carácter de la cadena.
            for (int i = 0; i < filas.length; i++) {
                filaTemp = (String[]) filas[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toUpperCase(A) || texto.charAt(l) == Character.toLowerCase(A)) {
                        ++l;
                        try {
                            if (texto.charAt(l) == Character.toUpperCase(B) || texto.charAt(l) == Character.toLowerCase(B)) {
                                ++cont;
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException ex) {
                        }
                    }
                }
            }

            //Se crea un nuevo filtro temporal, que alacenara las filas filtradas del 
            filFilt = new Object[cont];
            for (int i = 0; i < filas.length; i++) {
                filaTemp = (String[]) filas[i];
                String texto = filaTemp[columna];
                for (int l = 0; l < texto.length(); l++) {
                    if (texto.charAt(l) == Character.toUpperCase(A) || texto.charAt(l) == Character.toLowerCase(A)) {
                        ++l;
                        try {
                            if (texto.charAt(l) == Character.toUpperCase(B) || texto.charAt(l) == Character.toLowerCase(B)) {
                                filFilt[posi] = filas[i];
                                ++posi;
                                break;
                            }
                        } catch (StringIndexOutOfBoundsException ex) {

                        }
                    }
                }
            }
        }
    }

    //Carga los datos del objeto filasFilt
    private void cargarDatos() {
        for (int i = 0; i < filFilt.length; i++) {
            model.addRow((Object[]) filFilt[i]);
        }

    }

    public void busque(char C) {
        vaciarTabla();
        filtrarDatos(C);
        cargarDatos();
    }

    public void desBusque(char A, char B) {
        vaciarTabla();
        filtrarDesbus(A, B);
        cargarDatos();
    }
}
