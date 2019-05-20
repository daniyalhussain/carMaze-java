/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.abstracts;

import gui.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import src.Values;

public abstract class GamePanel extends JPanel {
    public Game game;
    
    private Image background;
    
    public GamePanel(Game game) {
        this.game = game;
        
        init();
    }
    
    private void init() {
        background = new ImageIcon(getClass().getResource("/images/background.jpg")).getImage();

        setLayout(null);
        setBackground(Color.RED);
        setSize(Values.GAMEWIDTH, Values.GAMEHEIGHT);  
    }
    
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(background, 0, 0, this);
    }
}
