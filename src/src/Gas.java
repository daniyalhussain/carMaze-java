/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import src.abstracts.GameItem;

public class Gas extends GameItem {
    private Image image;
    
    public Gas() {
        image = new ImageIcon(getClass().getResource("/images/gas.jpg")).getImage();
        setSize(Values.GAMEFIELDWIDTH, Values.GAMEFIELDHEIGHT);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
    
    @Override
    public String toString() {
        return "Gas";
    }
}
