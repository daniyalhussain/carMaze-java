/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import gui.LevelPanel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.abstracts.GameObject;

public class LoadLevel {
    private GameField[][] gameField = new GameField[10][7];
    
    public GameField[][] getLevel(String currentLevel) {        
        readFile(currentLevel);
 
        return gameField;        
    }
    
    private void readFile(String currentLevel) {
        File file = new File(getClass().getResource("/levels/" + currentLevel + ".txt").getFile()); 

        try {
            Scanner scanner = new Scanner(new FileReader(file));

            String line; 
            int lineNumber = 0;
            
            while ((line = scanner.nextLine()) != null) {
                String[] objects = line.split(" ");
                
                for (int i = 0; i < objects.length; i++) {                    
                    gameField[lineNumber][i] = getGameFieldFromLetter(objects[i], i, lineNumber);                 
                }
                
                lineNumber++;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private GameField getGameFieldFromLetter(String objectLetter, int x, int y) {
        if (objectLetter.equals("W")) {
            Wall wall = new Wall();
            
            return new GameField(x, y, wall);
        } else if (objectLetter.equals("E")) {
            Finish finish = new Finish();
            
            return new GameField(x, y, finish);
        } else if (objectLetter.equals("G")) {
            Gas gas = new Gas();
            
            return new GameField(x, y, gas);
        } else if (objectLetter.equals("K")) {
            Key key = new Key();
            
            return new GameField(x, y, key);
        } else if (objectLetter.equals("D")) {
            Door door = new Door();
            
            return new GameField(x, y, door);
        }
        
        
        return new GameField(x, y);
    }
}
