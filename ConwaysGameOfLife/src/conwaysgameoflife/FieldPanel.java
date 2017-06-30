/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.NoSuchElementException;
import javax.swing.JPanel;

/**
 *
 * @author Marvin
 */
public class FieldPanel extends JPanel {

    private final Manager manager;

    public FieldPanel(Manager manager) {
        this.manager = manager;
        this.setBackground(Color.black);
        initMouseListener();
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        int xcounter = 0;
        int ycounter = 0;
        double cellWidth = Double.valueOf(getWidth()) / Manager.getXFIELDS();
        double cellHeight = Double.valueOf(getHeight()) / Manager.getYFIELDS();
        for (Cell cell : manager.getCellMatrix()) {
            if (xcounter == Manager.getXFIELDS()) {
                ycounter++;
                xcounter = 0;
            }
            g.setColor((cell.isSet) ? Color.white : Color.black);
            g.fillRect((int) (xcounter * cellWidth), (int) (ycounter * cellHeight), (int) cellWidth, (int) cellHeight);
            xcounter++;
        }
    }

    private void initMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point p = e.getPoint();
                int clickedIndex = getIndexFromCoords(e.getPoint());
                if(clickedIndex == -1) throw new NoSuchElementException();
                manager.changeState(clickedIndex);
                repaint();
            }
        });
    }

    private int getIndexFromCoords(Point point) {
        int xcounter = 0;
        int ycounter = 0;
        double cellWidth = Double.valueOf(getWidth()) / Manager.getXFIELDS();
        double cellHeight = Double.valueOf(getHeight()) / Manager.getYFIELDS();
        for(int i = 0; i < manager.getCellMatrix().size(); i++){
            if (xcounter == Manager.getXFIELDS()) {
                ycounter++;
                xcounter = 0;
            }
            Rectangle rectangle = new Rectangle((int)(xcounter * cellWidth) , (int)(ycounter * cellHeight), (int)cellWidth, (int)cellHeight);
            if(rectangle.contains(point)){
                return (ycounter * Manager.getXFIELDS() + xcounter);
            }
            xcounter++;
        }
        return -1;
    }

}
