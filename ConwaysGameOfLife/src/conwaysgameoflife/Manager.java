/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

import LL.LL;
import javax.swing.Timer;

/**
 *
 * @author Marvin
 */
public class Manager implements Funtions {

    private final LL<Cell> cellMatrix;
    private static final int XFIELDS = 100;
    private static final int YFIELDS = 100;

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
        initTimer();

    }

    @Override
    public Cell getLeft(int index) {
        if (index % Manager.getXFIELDS() == 0) {
            return null;
        }
        return cellMatrix.get(index - 1);
    }

    @Override
    public Cell getRight(int index) {
        if ((index + 1) % Manager.getYFIELDS() == 0) {
            return null;
        }
        return cellMatrix.get(index + 1);
    }

    @Override
    public Cell getUpper(int index) {
        if (index - Manager.getXFIELDS() < 0) {
            return null;
        }
        return cellMatrix.get(index - Manager.getXFIELDS());
    }

    @Override
    public Cell getUnder(int index) {
        if (index - Manager.getXFIELDS() > (Manager.getXFIELDS() * Manager.getYFIELDS())) {
            return null;
        }
        return cellMatrix.get(index + Manager.getXFIELDS());
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
    }

    private void initWindow() {
        FieldWindow fieldWindow = new FieldWindow(this);
    }

    private void initTimer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initMouseListener() {

    }

    @Override
    public void changeState(int index) {
        cellMatrix.get(index).changeState();
    }

    @Override
    public int countNeighbours(int index) {
        Cell cupper = getUpper(index);
        Cell cunder = getUnder(index);
        Cell cleft = getLeft(index);
        Cell cright = getRight(index);

        int couter = 0;
        if (cupper != null) {
            couter += (cupper.isSet) ? 1 : 0;
        }
        if (cunder != null) {
            couter += (cunder.isSet) ? 1 : 0;
        }
        if (cleft != null) {
            couter += (cleft.isSet) ? 1 : 0;
        }
        if (cright != null) {
            couter += (cright.isSet) ? 1 : 0;
        }
        return couter;
    }

}
