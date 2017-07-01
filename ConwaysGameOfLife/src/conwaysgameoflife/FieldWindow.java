/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Marvin
 */
public class FieldWindow extends JFrame {

    private final Manager manager;
    FieldPanel fieldpanel;

    public FieldPanel getFieldpanel() {
        return fieldpanel;
    }

    public FieldWindow(Manager manager) {
        this.manager = manager;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(1000, 500));
        initPanel();
        initListener();
    }

    private void initPanel() {
        fieldpanel = new FieldPanel(manager);
        this.add(fieldpanel);
        fieldpanel.repaint();
    }

    private void initListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    manager.turn();
                }
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    manager.ssTimer();
                }
            }
        });
    }

}
