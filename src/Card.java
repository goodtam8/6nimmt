public class Card {
    /**
     * The number of the card
     */
    private int number=1;
    /**
     * The number of bull head of the card
     */
    private int bullHead;

    /**
     * Other constructor
     *
     * @param number - the value of the card
     */
    public Card(int number) {
        for (int i = 0; i < number; i++) {
            this.number=number;
            if (i  == 55) {//if the card number is something assign different bullhead to the number
                bullHead = 7;
            } else if (i+1  == 11 || i+1 == 22 || i+1  == 33 || i +1== 44 || i +1== 66 || i +1 == 77 || i+1  == 88 || i+1  == 99) {
                bullHead = 5;
            } else if (i+1  == 5 || i+1  == 15 || i+1  == 25 || i+1  == 35 || i+1  == 45 || i +1 == 65 || i +1 == 75 || i+1  == 85 || i +1 == 95) {
                bullHead = 2;

            }else if (i+1  == 10 || i+1 == 20 || i+1  == 30 || i +1== 40|| i +1== 60 || i +1 == 70 || i+1  == 80 || i+1  == 90) {
                bullHead = 3;}
            else {
                bullHead = 1;
            }

        }
    }

    /**
     * The getter of number
     *
     * @return - the value of the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * The getter of bull head
     *
     * @return - the number of bull head
     */
    public int getBullHead() {
        return bullHead;

    }

    /**
     * To print a card. This method has been done for you.
     * <p>
     * You don't need to change it and you should not change it.
     */
    public void print() {
        System.out.printf("%d(%d)", number, bullHead);
    }

    /**
     * To return the string of a card. This method has been done for you
     * <p>
     * You don't need ot change it and you should not change it.
     */
    public String toString() {
        return number + "(" + bullHead + ")";
    }


}
