/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.abstracts;

import javax.swing.JLabel;

/**
 *
 * @author Daniyal
 */
public abstract class GameObject extends JLabel {
    private boolean isWalkable;
    
    public GameObject(boolean walkable) {
        this.isWalkable = walkable;
        
        init();
    }

    private void init() {
        setLayout(null);
        setOpaque(true);
    }
    
    public boolean IsWalkable() {
        return isWalkable;
    }
    
}
