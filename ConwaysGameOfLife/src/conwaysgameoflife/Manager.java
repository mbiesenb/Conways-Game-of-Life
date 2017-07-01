/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

import LL.LL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import javax.swing.Timer;

/**
 *
 * @author Marvin
 */
public class Manager implements Funtions {

    private LL<Cell> cellMatrix;
    private static final int XFIELDS = 200;
    private static final int YFIELDS = 100;
    private int ssCounter = 5;
    private FieldWindow fieldWindow;
    private Timer runTimer;

    public static int getXFIELDS() {
        return XFIELDS;
    }

    public static int getYFIELDS() {
        return YFIELDS;
    }

    public LL<Cell> getCellMatrix() {
        return cellMatrix;
    }

    public Manager() {
        this.cellMatrix = new LL<>();
        initCells();
        setRandomFields(3);
        initWindow();
        initMouseListener();
        System.out.println("kommt an 5000");
        initTimer();

    }
    @Override
    public void setRandomFields(int frequency) {
        for (Cell cell : this.cellMatrix) {
            int random = (int) (Math.random() * 10);
            if (random < frequency) {
                cell.isSet = true;
            }
        }

    }

    private void initCells() {
        this.cellMatrix.clear();
        int numOfCells = XFIELDS * YFIELDS;

        for (int i = 0; i < numOfCells; i++) {
            Cell cell = new Cell();
            this.cellMatrix.add(cell);
        }
        int indexCounter = 0;
        for (Cell cell : cellMatrix) {
            if (indexCounter % Manager.XFIELDS != 0) {
                cell.left = cellMatrix.get(indexCounter - 1);
            } else {
                cell.left = null;
            }
            if ((indexCounter + 1) % Manager.XFIELDS != 0) {
                cell.right = cellMatrix.get(indexCounter + 1);
            } else {
                cell.right = null;
            }
            if (indexCounter - Manager.getXFIELDS() >= 0) {
                cell.up = cellMatrix.get(indexCounter - Manager.getXFIELDS());
            } else {
                cell.up = null;
            }
            if (indexCounter + Manager.getXFIELDS() <= (Manager.getXFIELDS() * Manager.getYFIELDS()) - 1) {
                cell.down = cellMatrix.get(indexCounter + Manager.getXFIELDS());
            } else {
                cell.down = null;
            }
            if (indexCounter % Manager.XFIELDS != 0 && indexCounter - Manager.XFIELDS - 1 > 0) {
                cell.upleft = cellMatrix.get(indexCounter - Manager.XFIELDS - 1);
            } else {
                cell.upleft = null;
            }
            if ((indexCounter % Manager.XFIELDS + 1) != 0 && indexCounter - Manager.XFIELDS + 1 > 0) {
                cell.upright = cellMatrix.get(indexCounter - Manager.XFIELDS + 1);
            } else {
                cell.upright = null;
            }
            if ((indexCounter % Manager.XFIELDS) != 0 && indexCounter + (Manager.XFIELDS - 1) <= (Manager.getXFIELDS() * Manager.getYFIELDS()) - 1) {
                cell.downleft = cellMatrix.get(indexCounter +  Manager.XFIELDS -1 );
            } else {
                cell.downleft = null;
            }
            if ((indexCounter % Manager.XFIELDS + 1) != 0 && indexCounter + (Manager.XFIELDS +1) <= (Manager.getXFIELDS() * Manager.getYFIELDS()) - 1) {
                cell.downright = cellMatrix.get(indexCounter +  Manager.XFIELDS + 1);
            } else {
                cell.downright = null;
            }
            //cell.up = cellMatrix.get(indexCounter - Manager.XFIELDS);
            //cell.down = cellMatrix.get(indexCounter + Manager.XFIELDS);
            indexCounter++;

        }
    }

    private void initWindow() {
        fieldWindow = new FieldWindow(this);
    }

    private void initTimer() {
        runTimer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turn();
            }
        });
    }

    private void initMouseListener() {
    }

    @Override
    public void changeState(int index) {
        cellMatrix.get(index).changeState();
        //System.out.println("Anzahl der Nachtbar: " + countNeighbours(index));
    }

    @Override
    public int countNeighbours(Cell cell, int index) {
        int counter = 0;
        if (cell.up != null && cell.up.isSet) {
            counter++;
        }
        if (cell.down != null && cell.down.isSet) {
            counter++;
        }
        if (cell.left != null && cell.left.isSet) {
            counter++;
        }
        if (cell.right != null && cell.right.isSet) {
            counter++;
        }
        if (cell.upleft != null && cell.upleft.isSet) {
            counter++;
        }
        if (cell.upright != null && cell.upright.isSet) {
            counter++;
        }
        if (cell.downleft != null && cell.downleft.isSet) {
            counter++;
        }
        if (cell.downright != null && cell.downright.isSet) {
            counter++;
        }
        return counter;
    }

    @Override
    public boolean getCellStateWithRules(Cell currentCell, int index) {
        int count = countNeighbours(currentCell, index);
        if (currentCell.isSet) {
            if (count < 2) {
                return false;
            }
            if (count == 2 || count == 3) {
                return true;
            }
            if (count > 3) {
                return false;
            }
        } else {
            if (count == 3) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void turn() {
        //System.err.println("-----------------"+cellMatrix.size());
        LL<Boolean> tempMatrix = new LL<>();
        int index = 0;
        for (Cell cell : this.cellMatrix) {
            int countNeighbour = countNeighbours(cell, index);
            boolean newState = getCellStateWithRules(cell, index);
            tempMatrix.add(newState);
            index++;
        }
        tempMatrix.add(false);

        Iterator<Boolean> it = tempMatrix.iterator();
        for (Cell cell : this.cellMatrix) {
            cell.isSet = it.next();
        }
        fieldWindow.getFieldpanel().update();

    }

    public void ssTimer() {
        if (ssCounter % 2 != 0) {
            runTimer.start();
        } else {
            runTimer.stop();
        }
        ssCounter++;
    }
}
