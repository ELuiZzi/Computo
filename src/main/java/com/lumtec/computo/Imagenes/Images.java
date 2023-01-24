package com.lumtec.computo.Imagenes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/*
Se inicializan las imagenes, y se cargan a un Label.
 */
public class Images {

    static BufferedImage logo;
    static BufferedImage ivaEnab;
    static BufferedImage ivaDisa;
    static BufferedImage miniImg;
    static BufferedImage menuImg;
    static BufferedImage carrito;

    static JLabel ivaEnable;
    static JLabel ivaDisable;
    static JLabel minimizeIcon;
    static JLabel menuIcon;
    public static JLabel carriIcon = new JLabel();

    public Images() {

        try {
            logo = ImageIO.read(new File("..\\img\\logo.png"));
            ivaEnab = ImageIO.read(new File("..\\img\\ivaMar.png"));
            ivaDisa = ImageIO.read(new File("..\\img\\ivaDes.png"));
            miniImg = ImageIO.read(new File("..\\img\\min.png"));
            menuImg = ImageIO.read(new File("..\\img\\menuIcon.png"));
            carrito = ImageIO.read(new File("..\\img\\carrito.png"));
        } catch (IOException ex) {
            try {
                logo = ImageIO.read(new File("img\\logo.png"));
                ivaEnab = ImageIO.read(new File("img\\ivaMar.png"));
                ivaDisa = ImageIO.read(new File("img\\ivaDes.png"));
                miniImg = ImageIO.read(new File("img\\min.png"));
                menuImg = ImageIO.read(new File("img\\menuIcon.png"));
                carrito = ImageIO.read(new File("img\\carrito.png"));
            } //En caso de que no se encuentren las imagenes en su ruta, las omitiremos.
            catch (IOException ex1) {

                logo = null;
                ivaEnab = null;
                ivaDisa = null;
                miniImg = null;
                menuImg = null;
                carrito = null;

            }
        }

        ivaEnable = new JLabel();

        ivaDisable = new JLabel();

        minimizeIcon = new JLabel();

        menuIcon = new JLabel();

        try {
            ivaEnable.setIcon(new ImageIcon(ivaEnab));
            ivaDisable.setIcon(new ImageIcon(ivaDisa));
            minimizeIcon.setIcon(new ImageIcon(miniImg));
            menuIcon.setIcon(new ImageIcon(menuImg));
            carriIcon.setIcon(new ImageIcon(carrito));
        } catch (NullPointerException exs) {
            System.out.println("Error al Cargar Imágenes");
        }
    }

    public BufferedImage getLogo() {
        return logo;
    }

    public static JLabel getIvaEnable() {
        return ivaEnable;
    }

    public static JLabel getIvaDisable() {
        return ivaDisable;
    }

    public static JLabel getMinimizeIcon() {
        return minimizeIcon;
    }

    public static JLabel getMenuIcon() {
        return menuIcon;
    }

}
