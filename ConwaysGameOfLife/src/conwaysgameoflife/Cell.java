/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conwaysgameoflife;

/**
 *
 * @author Marvin
 */
public class Cell {
    public boolean isSet = false;
    /**
     * A Cell is a specific small Field Square which has the state of <br>
     * isSet == true --> white<br>
     * isSet == false --> black
     */
    public Cell left;
    public Cell right;
    public Cell up;
    public Cell down;
    public Cell upleft;
    public Cell upright;
    public Cell downleft;
    public Cell downright;
    
    public Cell(){
        
    }
    public Cell(Cell left, Cell right){
        this.left = left;
        this.right = right;
    }
    public Cell(boolean state){
        this.isSet = state;
    }
    public void changeState(){
        this.isSet = !isSet;
    }
    
}
