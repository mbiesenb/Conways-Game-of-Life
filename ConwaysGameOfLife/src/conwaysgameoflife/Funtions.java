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
    void getLeft(int index);
    void getRight(int index);
    void getUpper(int index);
    void getUnder(int index);
    /**
     * 
     * @param frequency 
     * set a Range from 0 - 10 and set the frequency how often setted Cells will Sporn<br>
     * 0 --> no cell is setted
     * 5 --> every second cell is setted
     * 10 --> every cell is setted
     */
    void setRandomFields(int frequency);
}
