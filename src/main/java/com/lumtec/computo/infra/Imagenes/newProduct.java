
package com.lumtec.computo.infra.Imagenes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
