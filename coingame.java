import sun.jvm.hotspot.tools.SysPropsDumper;
/*
Coin Game
by:Isabella Rolfe 09/22/19
 */
public class coingame {
    public static int numBobwins = 0;
    public static int numAlicewins = 0;

    public static void CoinGame(int coinsRemaining, int player) {
        if (coinsRemaining == 0) {
            // the player whose turn it is loses
            if (player == 0) {
                numBobwins++; // it’s alice’s turn, so bob wins
            } else if (player == 1) {
                numAlicewins++; // it’s bob’s turn, so alice wins
            } else {
                System.out.println("Player is not 1 or 0. There is an error.");
            }
            return;
        } else if (coinsRemaining < 0) {
            // invalid game, no need to record anything
            return;
        } else {
            // this is the case where there are still coins remaining
            // recurse through each of three possible scenarios:
            // picking 1, 2, or 4 coins
            // changing whose turn it it
            // want to change turn of player, use mod to switch every recursive call
            // makes player equal to 0 or 1, corresponds to if statement above
            player = ((player + 1) % 2);
            //special case in which player is forced to make a losing choice
            if(coinsRemaining==3){
                if(player==1){
                    //need to add 2 because Alice can choose 2
                    numBobwins+=2;
                }
                else{
                    numAlicewins+=2;
                }
            }
            //account for when few coins left
            if (!(coinsRemaining - 1 == 1 || coinsRemaining - 1 == 2 || coinsRemaining - 1 == 4)) {
                CoinGame(coinsRemaining - 1, player);
                //only runs recursive call if it doesn't let other player win on next turn
            }

            if (!(coinsRemaining - 2 == 1 || coinsRemaining - 2 == 2 || coinsRemaining - 2 == 4)){
                CoinGame(coinsRemaining - 2, player);
            }

            if (!(coinsRemaining - 4 == 1 || coinsRemaining - 4 == 2 || coinsRemaining - 4 == 4)){
                CoinGame(coinsRemaining - 4, player);
            }
            return;
        }
    }

        public static void main (String[]args){
            System.out.println("game is about to start");
            CoinGame(25,0);
            System.out.println("recursive has been called");
            if (numAlicewins > numBobwins) {
                System.out.println("Alice: "+ numAlicewins);
            } else if (numBobwins > numAlicewins) {
                System.out.println("Bob: " + numBobwins);
            } else {
                System.out.print("It's a tie! Each player has " + numBobwins + " winning combinations!");
            }
        }
    }