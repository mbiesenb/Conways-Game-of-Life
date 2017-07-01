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
public interface Funtions {
    int countNeighbours(Cell cell, int index);
    /**
     * 
     * @param currentCell - Current Cell
     * @param index - Index of Current Cell
     * Rules:<br>
     * <br>
     * n = count Neighbours<br><br>
     * <u>Current Cell is set</u><br>
     * n &lt; 2 --> dead<br>
     * n = 2 or n = 3 --> alive<br>
     * n > 3 --> dead <br><br>
     * <u>Current Cell is not set</u><br>
     * n == 3 --> alive<br>
     * else --> dead
     * @return 
     */
    boolean getCellStateWithRules(Cell currentCell, int index);
    /**
     * 
     * @param index 
     * changes the State of an Cell<br>
     * set to unset<br>
     * unset to set <br>
     */
    void changeState(int index);
    /**
     * 
     * @param frequency 
     * set a Range from 0 - 10 and set the frequency how often setted Cells will Sporn<br>
     * 0 --> no cell is setted
     * 5 --> every second cell is setted
     * 10 --> every cell is setted
     */
    void setRandomFields(int frequency);
    
   /**
    * 
    */
    void turn();
}
