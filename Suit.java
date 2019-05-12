/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

/**
 *
 * @author 33020
 */
public enum Suit{
    SPADE(1),HEART(2),CLUB(3),DIAMOND(4);
    private int index;

    public int getIndex() {
        return index;
    }

    Suit(int index){
        this.index=index;
    }
}

