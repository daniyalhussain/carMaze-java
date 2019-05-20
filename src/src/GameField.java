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

public class GameField extends JLabel {
    private GameObject objectOnField;
    private Image background;

    private int x;
    private int y;

    public GameField(int x, int y) {
        this.x = x;
        this.y = y;

        init();
    }
    
    public GameField(int x, int y, GameObject objectOnField) {
        this.x = x;
        this.y = y;
        
        setGameObject(objectOnField);
        init();
    }
    
    private void init() {
        setLayout(null);
        setOpaque(true);
        
        background = new ImageIcon(getClass().getResource("/images/road.png")).getImage();

        setBounds(x * Values.GAMEFIELDWIDTH, 
            y * Values.GAMEFIELDHEIGHT, 
            Values.GAMEFIELDWIDTH, 
            Values.GAMEFIELDHEIGHT
        );        
    }
    
    public void setGameObject(GameObject gameObject) {
        this.objectOnField = gameObject;
        
        add(objectOnField);
        revalidate();
        repaint();
    }
    
    public GameObject getGameObject() {
        return objectOnField;
    }
    
    public void removeGameObject() {
        remove(objectOnField);
        this.objectOnField = null;
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, this);
    }
}
