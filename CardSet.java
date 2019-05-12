/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texasholdem;

import java.util.Arrays;
import java.util.Comparator;

public class CardSet implements Comparable {
    private Card[] cards = new Card[5];

    public CardSet(Card[] cards) {
        this.cards = cards;
        Arrays.sort(cards, new cmp());
    }

	public int getHigh() {
        int max = 0;
        for (Card c : cards) {
            if (c.getRank().getR() > max)
                max = c.getRank().getR();
            if (c.getRank().getR() == 1)
                max = 14;
        }
        return max;
    }

    
    public int getPair() {
        int res = 0;
        for(int i=0;i<5;i++){
            for(int j=i+1;j<5;j++){
                if(cards[i].getRank()==cards[j].getRank())
                    res++;
            }
        }
        return res;
    }

    
    public boolean isThree() {
        return (getPair()==3);
    }

   
    public int isStraight() {
        int a = cards[4].getRank().getR() - cards[3].getRank().getR();
        int b = cards[3].getRank().getR() - cards[2].getRank().getR();
        int c = cards[2].getRank().getR() - cards[1].getRank().getR();
        int d = cards[1].getRank().getR() - cards[0].getRank().getR();
        if (a == b && b == c && c == d) {
            return 1;
        } else if (a == b && b == c && d == 9) {
            return 2;
        }
        return 0;
    }

    
    public boolean isFlush() {
        for (int i = 0; i < 4; i++) {
            if (cards[i].getSuit() != cards[i + 1].getSuit())
                return false;
        }
        return true;
    }

    
    public boolean isFullHouse() {
        return (getPair() == 4);
    }

    
    public boolean isFour() {
        return (getPair()==6);
    }

    public boolean isStraightFlush() {
        return (isStraight() == 1) && isFlush();
    }

    public boolean isRoyal() {
        return (isStraight() == 2) && isFlush();
    }
	
    public int getPoints() {
        if (isRoyal())
            return 100;
        else if (isStraightFlush())
            return 90;
        else if (isFour())
            return 80;
        else if (isFullHouse())
            return 70;
        else if (isFlush())
            return 60;
        else if (isStraight() != 0)
            return 50;
        else if (isThree())
            return 40;
        else if (getPair() == 2)
            return 30;
        else if (getPair() == 1)
            return 20;
        else
            return getHigh();

    }

    @Override
    public int compareTo(Object o) {
        if (this.getPoints() != ((CardSet) o).getPoints()) {
            if (this.getPoints() > ((CardSet) o).getPoints())
                return 1;
            else
                return -1;
        } else if (this.getHigh() > ((CardSet) o).getHigh()) 
                return 1;
        else if (this.getHigh() < ((CardSet) o).getHigh())
                return -1;
        else
         return 0;
    }
    
	
    class cmp implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            Card c1 = (Card) o1;
            Card c2 = (Card) o2;
            if (c1.getRank().getR() != c2.getRank().getR())
                return c1.getRank().getR() > c2.getRank().getR() ? 1 : -1;
            else
                return 0;
        }
    }
}
