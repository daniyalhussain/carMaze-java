/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.abstracts.GamePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextPane;
import src.Values;

public class EndScreen extends GamePanel implements ActionListener {
    private JButton backButton;
    
    public EndScreen(Game game) {
        super(game);
       init();
    }
    
    private void init() {
        JTextPane textArea = new JTextPane();
        textArea.setText("Good job, you have finished it");
        textArea.setBounds(90, 20, 200, 300);
        
        backButton = new JButton("Go back");
        backButton.setBounds(90, 400, 200, 50);
        backButton.addActionListener(this);
        
        add(textArea);
        add(backButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.switchPanel(new StartScreen(game));
    }
    
    
    
}
