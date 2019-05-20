/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import src.abstracts.GameObject;

public class Wall extends GameObject {
    private Image image;
    
    public Wall() {
        super(false);
        
        init();
    }
    
    private void init() {
        image =  new ImageIcon(getClass().getResource("/images/wall.jpg")).getImage();
        setSize(Values.GAMEFIELDWIDTH, Values.GAMEFIELDHEIGHT);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
