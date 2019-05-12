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
public class Card {
    private Rank rank;
    private Suit suit;
    public Card(Rank rank,Suit suit){
        this.rank=rank;
        this.suit=suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }


    @Override
    public String toString() {
        return suit.name()+" "+rank.getR();
    }

}

