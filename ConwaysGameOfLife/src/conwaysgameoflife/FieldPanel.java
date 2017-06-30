/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Marvin
 */
public class FieldPanel extends JPanel{
    private final Manager manager;
    public FieldPanel(Manager manager){
        this.manager = manager;
        this.setBackground(Color.black);
    }
    @Override
    public void paint(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        int xcounter = 0;
        int ycounter = 0;
        double cellWidth = Double.valueOf(getWidth())/Manager.getXFIELDS();
        double cellHeight = Double.valueOf(getHeight())/Manager.getYFIELDS();
        for(Cell cell: manager.getCellMatrix()){
            if(xcounter == Manager.getXFIELDS()){
                ycounter++;
                xcounter = 0;
            }
            g.setColor((cell.isSet)?Color.white:Color.black);
            g.fillRect((int)(xcounter * cellWidth), (int)(ycounter * cellHeight),(int) cellWidth, (int)cellHeight);
            xcounter++;
        }
    }
    
}
