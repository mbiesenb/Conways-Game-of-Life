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

    public LL<Cell> getCellMatrix() {
        return cellMatrix;
    }
    public Manager() {
        this.cellMatrix = new LL<>();
        
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
    
}
