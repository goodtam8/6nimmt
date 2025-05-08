
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Table {
    /**
     * /**
     * Total number of player. Use this variable whenever possible
     */
    private static final int NUM_OF_PLAYERS = 4;
    /**
     * Total number of cards used in this game. Use this variable whenever possible
     */
    private static final int TOTAL_NUMBER_OF_CARD = 104;
    /**
     * The four stacks of cards on the table.
     */
    private Card[][] stacks = new Card[4][6];
    /**
     * This number of cards of each stack on the table. For example, if the variable
     * stacks stores
     * -------------------------
     * | 0 | 10 13 14 -- -- -- |
     * | 1 | 12 45 -- -- -- -- |
     * | 2 | 51 55 67 77 88 90 |
     * | 3 | 42 -- -- -- -- -- |
     * -------------------------
     * <p>
     * stacksCount should be {3, 2, 6, 1}.
     * <p>
     * You are responsible to maintain the data consistency.
     */
    private int[] stacksCount = new int[4];
    /**
     * The array of players
     */
    private Player[] players = new Player[NUM_OF_PLAYERS];

    /**
     * Default constructor
     * <p>
     * In the constructor, you should perform the following tasks:
     * <p>
     * 1. Initialize cards for play. You should construct enough number of cards
     * to play. These cards should be unique (i.e., no two cards share the same
     * number). The value of card must be between 1 to 104. The number of bullHead
     * printed on each card can be referred to the rule.
     * <p>
     * 2. Initialize four player. The first player should be a human player, call
     * "Kevin". The other player should be a computer player. These computer player
     * should have the name "Computer #1", "Computer #2", "Computer #3".
     * <p>
     * 3. Deal randomly 10 cards to each player. A card can only be dealt to one
     * player. That is, no two players can have the same card.
     * <p>
     * 4. Deal a card on each stack. The card dealt on the stack should not be dealt
     * to any player. Card dealt on each stack should also be unique (no two stack
     * have the same card).
     */
    public Table() {
        for (int i = 1; i < NUM_OF_PLAYERS; i++) {
            players[0] = new Player("Kevin");//assign player to different people
            players[i] = new Player();
        }
        Card[] deck = new Card[TOTAL_NUMBER_OF_CARD];//creat a deck
        for (int i = 1; i < deck.length + 1; i++) {
            Card ywc = new Card(i);
            deck[i - 1] = ywc;//assign d card number and bullhead to the deck
        }
        Card[] newdeck;


        //縮小個新array
        for (int i = 0; i < players.length; i++) {
            for (int j = 0; j < 10; j++) {
                newdeck = new Card[deck.length - 1];//create a new deck to let the orginal length縮小，唔會派重複card to other people
                int secret = ThreadLocalRandom.current().nextInt(0, deck.length);

                players[i].dealCard(deck[secret]);//random 派卡派10次to each player
                for (int v = 0; v < secret; v++) {
                    newdeck[v] = deck[v];

                }

                for (int v = secret; v < newdeck.length; v++) {
                    newdeck[v] = deck[v + 1];//don't know why deck[v+1] will show the indexout of bound error

                }
                deck = newdeck;

            }

        }
        Card[] stackdeck;//this is a stack deck for after assign 完d card copy 落去


        for (int j = 0; j < stacks.length; j++) {//deal card to the stack

            int secret = ThreadLocalRandom.current().nextInt(0, deck.length);
            stackdeck = new Card[deck.length - 1];
            stacks[j][0] = deck[secret];
            stacksCount[j] = 1;
            for (int v = 0; v < secret; v++) {
                stackdeck[v] = deck[v];

            }


            for (int v = secret; v < stackdeck.length; v++) {
                stackdeck[v] = deck[v + 1];//don't know why deck[v+1] will show the indexout of bound error

            }

            deck = stackdeck;

        }

    }


    /**
     * This method is to find the correct stack that a card should be added to
     * according to the rule. It should return the stack among which top-card of
     * that stack is the largest of those smaller than the card to be placed. (If
     * the rule sounds complicate to you, please refer to the game video.)
     * <p>
     * In case the card to be place is smaller than the top cards of all stacks,
     * return -1.
     *
     * @param card - the card to be placed
     * @return the index of stack (0,1,2,3) that the card should be place or -1 if
     * the card is smaller than all top cards
     */
    public int findStackToAdd(Card card) {
        int place = -1;
        int pp = card.getNumber();
        if (card.getNumber() < stacks[0][stacksCount[0] - 1].getNumber() && card.getNumber() < stacks[1][stacksCount[1] - 1].getNumber() &&
                card.getNumber() < stacks[2][stacksCount[2] - 1].getNumber()
                && card.getNumber() < stacks[3][stacksCount[3] - 1].getNumber()) {

            place = -1;
        }
        int index_value = 0;

        for (int i = 0; i < stacks.length; i++) {
            //return-1 if player 將card

            if (card.getNumber() > stacks[i][stacksCount[i] - 1].getNumber() && stacks[i][stacksCount[i] - 1].getNumber() > index_value) {
                index_value = stacks[i][stacksCount[i] - 1].getNumber();
                place = i;
            }
        }
        return place;
    }

    /**
     * To print the stacks on the table. Please refer to the demo program for the
     * format. Within each stack, the card should be printed in ascending order,
     * left to right. However, there is no requirement on the order of stack to
     * print.
     */
    public void print() {
        System.out.println("--------------Table---------");
        for (int r = 0; r < stacks.length; r++) {
            System.out.print("Stacks" + r + ":");
            for (int c = 0; c < stacks[r].length; c++) {
                if (stacks[r][c] != null) {
                    System.out.print(stacks[r][c]);
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------");


    }

    private void sortarraylist(Card[] tt) {
        Card[] newarray = tt;
        Card hello;
        Player y;
        int n = tt.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tt[j].getNumber() > tt[j + 1].getNumber()) {
                    // swap arr[j+1] and arr[j]
                    Card temparray = tt[j];
                    y = players[j];
                    tt[j] = tt[j + 1];
                    players[j] = players[j + 1];
                    tt[j + 1] = temparray;
                    players[j + 1] = y;
                }
            }


        }


    }

    /**
     * This method is the main logic of the game. You should create a loop for 10
     * times (running 10 rounds). In each round all players will need to play a
     * card. These cards will be placed to the stacks from small to large according
     * to the rule of the game.
     * <p>
     * In case a player plays a card smaller than all top cards, he will be
     * selecting one of the stack of cards and take them to his/her own score pile.
     * If the player is a human player, he will be promoted for selection. If the
     * player is a computer player, the computer player will select the "cheapest"
     * stack, i.e. the stack that has fewest bull heads. If there are more than
     * one stack having fewest bull heads, selecting any one of them.
     */
    public void runApp() {
        for (int turn = 0; turn < 10; turn++) {
            // print Table
            print();
            Card[] playerstore = new Card[4];
            Card[] orginalstore = new Card[4];
            int org_index = 0;
            int newindex = 0;
            int newindex2=0;
            int newindex3=0;
            playerstore[0] = players[0].playCard();

            System.out.println(players[0].getName() + "#  " + playerstore[0]);
            for (int i = 1; i < players.length; i++) {
                playerstore[i] = players[i].playCardRandomly();
                System.out.println(players[i].getName() + " " + playerstore[i]);
            }


                for (int j = 0; j < playerstore.length; j++) {
                orginalstore[j] = playerstore[j];

            }


            Player[] returnplayer = new Player[players.length];
            for (int i = 0; i < returnplayer.length; i++) {
                returnplayer[i] = players[i];
            }

            sortarraylist(playerstore);
            for (int i = 1; i < playerstore.length; i++) {

                for (int j = 0; j < playerstore.length; j++) {
                    if (orginalstore[1] == playerstore[j]) {
                        newindex = j;
                        org_index = i;

                    }
                }}
            for (int i = 1; i < playerstore.length; i++) {

                for (int j = 0; j < playerstore.length; j++) {
                    if (orginalstore[2] == playerstore[j]) {
                        newindex2 = j;
                        org_index = i;

                    }
                }}
            for (int i = 1; i < playerstore.length; i++) {

                for (int j = 0; j < playerstore.length; j++) {
                    if (orginalstore[3] == playerstore[j]) {
                        newindex3 = j;
                        org_index = i;

                    }
                }}

                System.out.println(org_index);
                System.out.println(newindex);
                for (int y = 0; y < playerstore.length; y++) {
                    //System.out.println(playerstore[y].getNumber() + "   ");
                }
                int[] bullheadarray = new int[stacks.length];
                int minium = 0;

                for (int i = 0; i < players.length; i++) {
                    int stackindextoadd = findStackToAdd(playerstore[i]);

                    if (stackindextoadd != -1) {

                        stacks[stackindextoadd][stacksCount[stackindextoadd]] = playerstore[i];
                        stacksCount[stackindextoadd] += 1;
                        System.out.println("Place the card" + playerstore[i] + "for" + players[i].getName());


                        if (stacks[stackindextoadd][5] != null) {
                            players[i].moveToPile(stacks[stackindextoadd], stacksCount[stackindextoadd]);
                            stacks[stackindextoadd][0] = playerstore[i];
                            stacksCount[stackindextoadd] = 1;
                        }
                    }
                    int countbullhead = 0;
                    int minValue = Integer.MAX_VALUE;
                    int bullheadindex = 0;

                    if (stackindextoadd == -1 &&(findStackToAdd(orginalstore[0])!=-1)
                            && orginalstore[1] == playerstore[newindex] && orginalstore[2] == playerstore[newindex2]&& orginalstore[3] == playerstore[newindex3]) {


                        for (int col = 0; col < stacks.length; col++) {
                            int tempSum = 0;
                            for (int row = 0; row < stacksCount[col]; row++) {
                                tempSum = tempSum + stacks[col][row].getBullHead();
                            }
                            if (tempSum < minValue) {
                                minValue = tempSum;
                                bullheadindex = col;
                            }
                        }
                        System.out.println(bullheadindex);
                        players[i].moveToPile(stacks[bullheadindex], stacksCount[bullheadindex]);
                        stacks[bullheadindex][0] = playerstore[i];
                        stacksCount[bullheadindex] = 1;


                    } else if (stackindextoadd == -1 && orginalstore[0] == playerstore[i]) {
                        System.out.print("kevin,please select a stack to collect");
                        Scanner out = new Scanner(System.in);
                        int style = out.nextInt();

                        players[0].moveToPile(stacks[style], stacksCount[style]);
                        stacks[style][0] = orginalstore[0];
                        stacksCount[style] = 1;//let player to choose move which card to the pile


                    }

                }
            players = returnplayer;
        }



        //////////////////////////////////////////
        for (Player p : players) {
            System.out.println(p.getName() + " has a score of " + p.getScore());
            p.printPile();
        }
    }

    /**
     * Programme main. You should not change this.
     *
     * @param args - no use.
     */
    public static void main(String[] args) {
        new Table().runApp();
    }}


