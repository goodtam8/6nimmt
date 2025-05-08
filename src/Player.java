import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    /**
     * The cards held on a player hand
     */
    private Card[] hand;
    /**
     * The number of card held by the player. This variable should be maintained
     * to match array hand.
     */
    private int handCount=0;
    /**
     * A dynamic array that holds the score pile.
     */
    private Card[] pile;
    /**
     * The name of the player
     */
    private String name;
    /**
     * A static variable that tells how many player has been initialized
     */
    private static int count = 1;

    /**
     * Other constructor that specify the name of the player.
     *
     * You need to initialize your data member properly.
     */
    public Player(String name) {//according the player name and assign to the name of player
        this.pile=new Card[0];
        this.hand=new Card[10];
        this.name=name;
    }

    /**
     * Default constructor that set the name of the player as "Computer #1",
     * "Computer #2", "Computer #3"...
     * The number grows when there are more computer players being created.
     *
     * You need to initialize your data member properly.
     */
    public Player() {
        this.pile=new Card[0];
        this.hand=new Card[10];


//giving the variable name to the ai player
        this.name="Computer #"+count++;




    }

    /**
     * Getter of name
     *
     * @return - the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * This method is called when a player is required to take the card from a stack
     * to his score pile. The variable pile should be treated as a dynamic array so
     * that the array will auto-resize to hold enough number of cards. The length of
     * pile should properly record the total number of cards taken by a player.
     *
     * Important: at the end of this method, you should also help removing all cards
     * from the parameter array "cards".
     *
     *
     *
     * @param cards - an array of cards taken from a stack
     * @param count - number of cards taken from the stack
     */
    public void moveToPile(Card[] cards, int count) {

        //this is the last element of the stack array
        //enlarge an array
        //pile=new Card[count];
        int counter=0;
        Card []large=new Card[pile.length+count];
        for(int i=0;i<pile.length;i++){
            large[i]=pile[i];

        }
        for(int j=pile.length;j<large.length;j++){

            large[j] = cards[counter];
            counter++;

        }
        pile=large;
        for(int i=0;i<count;i++){
            cards[i]=null;}



    }

    /**
     * This method prompts a human player to play a card. It first print
     * all cards on his hand. Then the player will need to select a card
     * to play by entering the INDEX of the card.
     *
     * @return - the card to play
     */
    public Card playCard() {
        Card[]newhand=new Card[hand.length-1];//try to copy a new array after i enter some card
        Scanner in=new Scanner(System.in);
        int v=0;
        int out=0;
        for (int i = 0; i < this.hand.length; i++) {
            if (this.getHandCard(i) != null) {
                System.out.println(i + ":" + this.getHandCard(i));
            }
        }
        System.out.println("Kevin,please select a card to play");
        out=in.nextInt();
        while(out>hand.length-1){
            System.out.println("Kevin,please select a card to play");
            out=in.nextInt();
        }
        for(int i=0;i<hand.length;i++){
            if(out==i&&out<hand.length){
                v=i;
            }


        }
        Card myhand=this.hand[v];//try to return this card and move it to the stack

        for(int i=0;i<v;i++){
            newhand[i]=hand[i];
        }
        for(int i=v;i<newhand.length;i++){
            newhand[i]=hand[i+1];
        }
        this.hand=newhand;
        return myhand;
    }

    /**
     * This method let a computer player to play a card randomly. The computer
     * player will pick any available card to play in a random fashion.
     *
     * @return - card to play
     */
    public Card playCardRandomly() {
        Card[]newhand=new Card[hand.length-1];//same 道理as the previous playcard
        int secret = ThreadLocalRandom.current().nextInt(0, hand.length);
        Card myhand=this.hand[secret];
        for (int i =0;i<secret;i++){
            newhand[i]=this.hand[i];

        }
        for(int i=secret;i<newhand.length;i++){
            newhand[i]=this.hand[i+1];
        }
        this.hand=newhand;



        return myhand;
    }

    /**
     * Deal a card to a player. This should add a card to the variable hand and
     * update the variable handCount. During this method, you do not need to resize
     * the array. You can assume that a player will be dealt with at most 10 cards.
     * That is, the method will only be called 10 times on a player.
     *
     * After each call of this method, the hand should be sorted properly according
     * to the number of the card.
     *
     * @param card - a card to be dealt
     */
    public void dealCard(Card card) {


        this.hand[handCount]=card;//assign the card to the player hand array
        this.handCount++;

        int handsome=handCount;



        for (int i = 0; i < handsome - 1; i++) {
            for (int j = 0; j < handsome - i - 1; j++) {

                if (hand[j].getNumber() > hand[j + 1].getNumber()&&hand[j+1]!=null&&hand[j]!=null) {
                    // swap arr[j+1] and arr[j]
                    Card temparray = hand[j];
                    hand[j] = hand[j + 1];
                    hand[j + 1] = temparray;
                }
            }


        }





    }

    /**
     * Get the score of the player by counting the total number of Bull Head in the
     * score pile.
     *
     * @return - score, 0 or a positive integer
     */
    public int getScore() {
        int score=0;
        for(int i=0;i<pile.length;i++){
            score+=pile[i].getBullHead();
        }
        return score;
    }

    /**
     * To print the score pile. This method has completed for you.
     *
     * You don't need to modify it and you should not modify it.
     */
    public void printPile() {
        for (Card c : pile) {
            c.print();
        }
        System.out.println();
    }

    /**
     * This is a getter of hand's card. This method has been completed for you
     *
     * You don't need to modify it and you should not modify it.
     *
     * @param index - the index of card to take
     * @return - the card from the hand or null
     */
    public Card getHandCard(int index) {
        if (index < 0 || index >= handCount)
            return null;
        return hand[index];
    }
}