/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;
import LL.LL;
/**
 *
 * @author Marvin
 */
public class Manager implements Funtions{
    private final LL <Cell> cellMatrix;
    private static final int XFIELDS = 100;

    public static int getXFIELDS() {
        return XFIELDS;
    }

    public static int getYFIELDS() {
        return YFIELDS;
    }
    private static final int YFIELDS = 100;
    
    public LL<Cell> getCellMatrix() {
        return cellMatrix;
    }
    public Manager() {
        this.cellMatrix = new LL<>();
        initCells();
        initWindow();
        
    }

    @Override
    public void getLeft(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getRight(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUpper(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUnder(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initCells() {
       this.cellMatrix.clear();
       int numOfCells = XFIELDS * YFIELDS;
       for(int i = 0; i < numOfCells; i++){
           Cell cell = new Cell();
           this.cellMatrix.add(cell);
       }
    }

    private void initWindow() {
       FieldWindow fieldWindow = new FieldWindow(this);
    }
    
}
