
package com.lumtec.computo.Imagenes;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class newProduct extends Component {
    BufferedImage img;

    public newProduct() {

        try {
            img = ImageIO.read(new File("..\\img\\newProduct.png"));
        } catch (IOException ex) {
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, -5, null);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(img.getWidth(), img.getHeight());
    }
    
    
}
