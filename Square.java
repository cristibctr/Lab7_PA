/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab7_pa;

/**
 *
 * @author crist
 */
public class Square {
    private int pair1, pair2, value;

    public Square(int pair1, int pair2, int value) {
        this.pair1 = pair1;
        this.pair2 = pair2;
        this.value = value;
    }
    
    public int getPair1() {
        return pair1;
    }

    public int getPair2() {
        return pair2;
    }

    public int getValue() {
        return value;
    }

    public void setPair1(int pair1) {
        this.pair1 = pair1;
    }

    public void setPair2(int pair2) {
        this.pair2 = pair2;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
