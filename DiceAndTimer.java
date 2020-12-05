public class DiceAndTimer
{
    public static int numberOfMoves = 0;
    /*
     * This method rolls a dice with the numbers 1-6 which represents the number of
     * spaces the avatar can move The numbers correlated with the dice roll are then
     * added onto a total numberOfMoves
     */
    public static int roll() {
        int roll = (int) ((Math.random() * 3) + 1);
            //need to add a 1 because there's a chance of getting a 0 
        numberOfMoves++;
        return roll;
    }

    /*
     * This method compares the total numberOfMoves the avatar made to the
     * limitOfMoves the avatar can make and continues or ends the game accordingly
     */
    public static boolean countMove() {
        int limitOfMoves = 30;

        if (limitOfMoves > numberOfMoves) {
            System.out.println("Current number of moves: " + numberOfMoves);
            System.out.println("Moves left: " + (limitOfMoves - numberOfMoves));
            return true;
            // Ending the game if the number of moves is reached
        } else {
            System.out.println("You have reached the maximum number of moves");
            System.out.println("GAME OVER !");
            System.out.println();
            return false;
        }
    }
}
