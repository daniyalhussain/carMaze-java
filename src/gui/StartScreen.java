/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.abstracts.GamePanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import javax.swing.JButton;
import javax.swing.JPanel;
import src.Values;

public class StartScreen extends GamePanel implements ActionListener {    
    private JButton start;
    private JButton instructions;
    
    public StartScreen(Game game) {
        super(game);
        init();
    }
    
    private void init() {
        start = new JButton("Start");
        start.setBounds(90, 270, 200, 50);
        start.addActionListener(this);

        instructions = new JButton("Instruction");
        instructions.setBounds(90, 330, 200, 50);
        instructions.addActionListener(this);
        
        add(start);
        add(instructions);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource() == start) {
            game.switchPanel(new LevelPanel(game));
        } else if (e.getSource() == instructions) {
            game.switchPanel(new InstructionsPanel(game));
        }        
    }
}
