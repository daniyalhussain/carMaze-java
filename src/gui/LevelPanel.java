/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.abstracts.GamePanel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.GameArea;
import src.GameField;
import src.Inventory;
import src.LoadLevel;

public class LevelPanel extends GamePanel {
    private String currentLevel = "level1";
    private GameArea gameArea;
    private Inventory inventory;

    public LevelPanel(Game game) {
        super(game);
        
        init();
    }
    
    private void init() {
        setLevel();        
    }
    
    private void setLevel() {
        inventory = new Inventory();

        LoadLevel loadLevel = new LoadLevel();
        gameArea = new GameArea(loadLevel.getLevel(currentLevel), this, inventory);
        
        addKeyListener(gameArea);
        gameArea.requestFocus();
        gameArea.setFocusable(true);
        
        add(gameArea);
        add(inventory);
        
        revalidate();
        repaint();

        setVisible(true);
    }
    
    public void goNextLevel() {
        remove(gameArea);
        removeKeyListener(gameArea);
        
        if (currentLevel.equals("level1")) {
            currentLevel = "level2";
            setLevel();
        } else if(currentLevel.equals("level2")) {
            currentLevel = "level3";
            setLevel();
        } else if(currentLevel.equals("level3")) {
            game.switchPanel(new EndScreen(game));
        }
    }
}
