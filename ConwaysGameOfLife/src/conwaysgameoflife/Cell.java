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
    public Cell(){
        
    }
    public void changeState(){
        this.isSet = !isSet;
    }
    
}
