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
    private Manager manager;
    public FieldWindow(Manager manager) {
        this.manager = manager;
        this.setVisible(true);
        this.setPreferredSize(new Dimension(500, 500));
    }
 
}
