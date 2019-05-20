/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import src.abstracts.GameObject;

public class Inventory extends JTextArea {
    private ArrayList<GameObject> gameObjects;
    
    public Inventory() {
        gameObjects = new ArrayList<GameObject>();

        init();
    }
    
    private void init() {
        setBounds(10, Values.GAMEAREAHEIGHT + 30, Values.GAMEWIDTH - 30, 100);
        String inventory = "";
                
        for(GameObject gameObject : gameObjects) {
            inventory +=  " | " + gameObject.toString();
        }
        
        setText(inventory);
        
        revalidate();
        repaint();
    }
    
    public boolean addItem(GameObject gameObject) {
        // check if its already in
        for(GameObject gameObjectIn : gameObjects) {
            if (gameObjectIn.toString().equals(gameObject.toString())) {
                System.out.println("Already have this item");
                return false;
            }
        }

        this.gameObjects.add(gameObject);
        init();
        
        return true;
    }
    
    public void removeItem(GameObject gameObject) {
        this.gameObjects.remove(gameObject);
        init();
    }
    
    public boolean gotKey() {
        for(GameObject gameObject : gameObjects) {
            if(gameObject instanceof Key) {
                return true;
            }
        }
        
        return false;
    }
}
