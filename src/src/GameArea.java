/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import gui.LevelPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import src.abstracts.GameItem;

public class GameArea extends JPanel implements KeyListener {
    private GameField[][] gameFields;
    private Player player;
    private Inventory inventory;
    
    private LevelPanel levelPanel;
    
    public GameArea(GameField[][] gameFields, LevelPanel levelPanel, Inventory inventory) {
        this.gameFields = gameFields;
        this.levelPanel = levelPanel;
        this.inventory = inventory;

        init();
    }
    
    private void init() {  
        setLayout(null);

        setBounds(15, 10, Values.GAMEAREAWIDTH, Values.GAMEAREAHEIGHT);
        
        loadPlayer();    
        loadLevel();
        
        requestFocusInWindow();
        setFocusable(true);

        revalidate();
        repaint();
    }
    
    private void loadLevel() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {                
                add(gameFields[i][j]);
            }
        }
    }
    
    private void loadPlayer() {
        player = new Player(0, 0, inventory);

        add(player);
    }

    private boolean walkable(String movement) {
        int x = player.getXCord();
        int y = player.getYCord();
        
        switch(movement) {
            case "LEFT":
                if(x == 0) {
                   return false;
                }
                
                if(gameFields[y][x - 1].getGameObject() != null) {
                    if(!gameFields[y][x-1].getGameObject().IsWalkable()) {
                        if(gameFields[y][x-1].getGameObject() instanceof Door){
                            if(player.gotKey()) {
                                gameFields[y][x-1].removeGameObject();
                                return true;
                            }
                        }
                        
                        return false;
                    }
                }
                break;
            case "RIGHT":
                if(x == 6) {
                    return false;
                }
                
                if(gameFields[y][x+1].getGameObject() != null) {
                    if(!gameFields[y][x+1].getGameObject().IsWalkable()) {
                        if(gameFields[y][x+1].getGameObject() instanceof Door){
                            if(player.gotKey()) {
                                gameFields[y][x+1].removeGameObject();
                                return true;
                            }
                        }
                        
                        return false;
                    }
                }
                break;

            case "UP":
                if(y == 0) {
                    return false;
                }
                
                if(gameFields[y-1][x].getGameObject() != null) {
                    if(!gameFields[y-1][x].getGameObject().IsWalkable()) {
                        if(gameFields[y-1][x].getGameObject() instanceof Door){
                            if(player.gotKey()) {
                                gameFields[y-1][x].removeGameObject();
                                return true;
                            }
                        }
                        
                        return false;
                    }
                }
                break;

            case "DOWN":
                if(y == 9) {
                    return false;
                }

                if(gameFields[y+1][x].getGameObject() != null) {
                    if(!gameFields[y+1][x].getGameObject().IsWalkable()) {
                        if(gameFields[y+1][x].getGameObject() instanceof Door){
                            if(player.gotKey()) {
                                gameFields[y+1][x].removeGameObject();
                                return true;
                            }
                        }
                        
                        return false;
                    }
                }
                break;
        }
        
        return true;
    }
    
    private void pickUpItem() {
        int x = player.getXCord();
        int y = player.getYCord();
        
        if(gameFields[y][x].getGameObject() != null) {
            if(gameFields[y][x].getGameObject() instanceof GameItem) {
                
                if(player.addItem(gameFields[y][x].getGameObject())) {
                    gameFields[y][x].removeGameObject();    
                }
            }
        }
    }
    
    private void checkFinish() {
        int x = player.getXCord();
        int y = player.getYCord();
        
        if(gameFields[y][x].getGameObject() != null) {
            if(gameFields[y][x].getGameObject() instanceof Finish) {
                levelPanel.goNextLevel();
            }
        }
    }
    
    @Override
     public void keyPressed(KeyEvent ke) {
        int keyCode = ke.getKeyCode();
        
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
                if(walkable("RIGHT")) {
                    player.goRight();                
                }
                break;

            case KeyEvent.VK_LEFT:
                if(walkable("LEFT")) {
                    player.goLeft();
                }
                break;

            case KeyEvent.VK_UP:
                if(walkable("UP")) {
                    player.goUp();
                }
                break;

            case KeyEvent.VK_DOWN:
                if(walkable("DOWN")) {
                    player.goDown();
                }
                break;

            case KeyEvent.VK_P:
                levelPanel.goNextLevel();
                break;

            case KeyEvent.VK_SPACE:
                pickUpItem();
                break;
 
        }
        
        checkFinish();

    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
