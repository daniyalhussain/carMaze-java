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

public class Player extends GameObject {
    private Image car;
    private Inventory inventory;
    
    private int x;
    private int y;
    
    public Player(int x, int y, Inventory inventory) {
        super(false);

        this.x = x;
        this.y = y;
        
        this.inventory = inventory;

        init();
    }
    
    private void init() {
        car = new ImageIcon(getClass().getResource("/images/car.jpg")).getImage();

        setLayout(null);
        setOpaque(true);        

        setBounds(x * Values.GAMEFIELDWIDTH, 
            y * Values.GAMEFIELDHEIGHT, 
            Values.GAMEFIELDWIDTH, 
            Values.GAMEFIELDHEIGHT
        );
    }
    
    public void goDown() {
        this.y += 1;
        move();   
    }
    
    public void goUp() {
        this.y -= 1;
        move();
    }
    
    public void goRight() {
        this.x += 1;
        move();
 
    }
    
    public void goLeft() {
        this.x -= 1; 
        move(); 
    }
    
    public int getXCord() {
        return this.x;
    }
    
    public int getYCord() {
        return this.y;
    }

    private void move() {
        
        setBounds(
            x * Values.GAMEFIELDWIDTH, 
            y * Values.GAMEFIELDHEIGHT, 
            Values.GAMEFIELDWIDTH, 
            Values.GAMEFIELDHEIGHT
        );
        
        revalidate();
        repaint();
    }
    
    public boolean addItem(GameObject gameObject) {
        return inventory.addItem(gameObject);
    }
    
    public boolean gotKey() {
        return inventory.gotKey();
    }
    
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(car, 0, 0, this);
    }
}
