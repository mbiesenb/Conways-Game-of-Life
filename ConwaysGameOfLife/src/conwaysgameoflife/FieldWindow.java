/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Marvin
 */
public class FieldWindow extends JFrame{
    private final Manager manager;
    public FieldWindow(Manager manager) {
        this.manager = manager;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(500, 500));
        initPanel();
    }

    private void initPanel() {
        FieldPanel fieldpanel = new FieldPanel(manager);
        this.add(fieldpanel);
    }
 
}
