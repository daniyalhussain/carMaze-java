/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.abstracts.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import src.Values;

public class Game extends JFrame {
    
    private GamePanel currentPanel;
    
    public Game() {
        init();
    }
    
    private void init() {
        setTitle(Values.GAMENAME);
        setLayout(null);
        
        addContent();

        setSize(Values.GAMEWIDTH, Values.GAMEHEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    private void addContent() {
        currentPanel = new StartScreen(this);
        add(currentPanel);
    }
    
    public void switchPanel(GamePanel newPanel) {
        remove(currentPanel);
        
        currentPanel = newPanel;
        add(currentPanel);
        
        currentPanel.requestFocus(true);
        currentPanel.setFocusable(true);

        revalidate();
        repaint();
    }
    
    public static void main(String[] args) {
        Game game = new Game();
    }
}
