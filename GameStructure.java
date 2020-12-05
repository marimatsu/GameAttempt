import java.util.*;
import java.lang.Math;

/**There's 25 spaces overall, 11 of which are going to hold random mini-games/events and the rest will 
 * either be a chance to gain things or lose things. We can always change the numbers if needed. 
 * 
 * Variables: Food, Health, and Water (for now);
 */

public class GameStructure extends Character
{
    public HashMap<Integer, String> map = new HashMap<>();
    public int index;
    public Character player;

    GameStructure(Character player)
    {
        this.player = player;
        makeMap();
    }

    /**
     *      This method assigns minigames randomly on to the map of so it produces a random map. It
     * also assigns the "recharge" space to any index that remains null. 
     *      Will need to redesign it so that there's more of a variance (can randomize to have bulks
     * of either string variables at times).
     * 
     * @return  a map for the new game of Silicone Valley.
     */
    public HashMap<Integer, String> makeMap() 
    {
        for (int cnt = 0; cnt < 11; cnt++) 
        {
            index = (int) (Math.random() * 25);
            if (!map.containsKey(index))
                map.put(index, "minigame");
            else 
            {
                while (map.containsKey(index)) 
                {
                    if (index == 25)
                        index = 0;
                    index++;
                }
                map.put(index, "minigame");
            }
        }

        for (int cnt = 0; cnt < 9; cnt++) 
        {
            index = (int) (Math.random() * 25);
            if (!map.containsKey(index))
                map.put(index, "randEvent");
            else 
            {
                while (map.containsKey(index)) 
                {
                    if (index == 25)
                        index = 0;
                    index++;
                }
                map.put(index, "randEvent");
            }
        }

        // Putting remaining empty indexes to be where the player can recharge.
        for (int cnt = 0; cnt < 25; cnt++) 
        {
            if (!map.containsKey(cnt))
                map.put(cnt, "recharge");
        }

        return map;
    }

    /**
     *      This method reads the assigned String to the index of the map space and
     * directs to either a minigame or an oppurtunity to recharge. 
     *      Note: There's always an oppurtunity to recharge at the cost of a move/day. 
     */
    public void gameSpace(Character player)
    {
        if (map.get(index).equals("minigame")) 
            minigame();
        else
        {
            if (map.get(index).equals("recharge"))
                recharge();
            else
                randEvent();
        }     
    }

    public void minigame()
    {
        //There only exists food, water, and health variables for the game. 
        //This is the bit that determines if they lose or gain.
        //int mini = (int) (Math.random() * 2);
        
        //if (mini == 0)
        // {
        //     GraphicsAttempt.print("You've landed on an Eye Spy minigame!\n");
        //     EyeSpy game = new EyeSpy();
        //     String result = game.printEndMessage();
        //     //reset wins and losses to 0 in case you encounter another troll scenario
        //     game.wins = 0;
        //     game.losses = 0;

        //     int change = (int) (Math.random() *3);

        //     switch(change)
        //     {
        //         case 0:
        //             player.setFood(result);
        //             break;
        //         case 1:
        //             player.setFood(result);
        //             break;
        //         case 2: 
        //             player.setFood(result);
        //             break;
        //     }
        // }
        //else
        {
            int maze = (int) (Math.random() * 3);
            switch(maze)
            {
                case 0:
                    TextScen.foodChange();
                    break;
                case 1:
                    TextScen.healthChange();
                    break;
                case 2:
                    TextScen.waterChange();
                    break;
            }
        }
    }

    /**
     *      This method starts up the text maze for the game. It randomizes which option will succeed
     * so that should a scenario show up again, it will have a different result and thus a different 
     * experience.
     * 
     * @return      Whether the player suceeds, and thus changing the stats for the player.
     */
    public static String textMaze(String f1, String f1e, String f1c, String f2, String f2e, String f2c, String t1, String t1e, String t1c, String t2, String t2e, String t2c, String good, String bad)
    {
        String sequence = "";
        for (int cnt = 0; cnt < 2; cnt++)
        {
            char correct = (char)((Math.random() * 2) + '0');
            sequence += correct;
        }

        char check = mazeOption(f1, f2);
        if (check != sequence.charAt(0))
        {
            printMazeText(check, f1e, f2e);
            GraphicsAttempt.print(bad);
            return "lose";
        } 
        else
        {
            printMazeText(check, f1c, f2c);
            
            check = mazeOption(t1, t2);
            
            if (check != sequence.charAt(1))
            {
                printMazeText(check, t1e, t2e);
                GraphicsAttempt.print(bad);
                return "lose";
            }
            else
            {
                printMazeText(check, t1c, t2c);
                GraphicsAttempt.print(good);
                return "gain";
            }
        }
    }

    /**
     *      This method merely takes in the option that the player chooses.
     */
    public static char mazeOption(String choice1, String choice2)
    {
        Scanner in = new Scanner (System.in);
        GraphicsAttempt.print("\n\t1. " + choice1);
        GraphicsAttempt.print("\t2. " + choice2);
        int choose = in.nextInt() - 1;
        
        return (char) (choose + '0');
    }

    /**
     *      This method just prints out the appropriate text given what the player inputted.
     * @param check     What the player inputted.
     * @param op1       Text.
     * @param op2       Text.
     */
    public static void printMazeText(char check, String op1, String op2)
    {
        if (check == '0')
            GraphicsAttempt.print("\n" + op1);
        else
            GraphicsAttempt.print("\n" + op2);
    }

    /**
     *      This method randomizes the randomEvent that just occurs. There is no option of gaining or losing.
     * It's already set in stone in TextScen.
     */
    public void randEvent()
    {
        int event = (int) (Math.random() * 9);
        switch(event)
        {
            case 0:
                TextScen.rando1();
                break;
            case 1:
                TextScen.rando2();
                break;
            case 2:
                TextScen.rando3();
                break;
            case 3:
                TextScen.rando4();
                break;
            case 4:
                TextScen.rando5();
                break;
            case 5:
                TextScen.rando6();
                break;
            case 6:
                TextScen.rando7();
                break;
            case 7:
                TextScen.rando8();
                break;
            case 8:
                TextScen.rando9();
                break;
        }
    }

    public void recharge()
    {
        //remember this is just an option so make sure to give players a chance to move on or not.
        GraphicsAttempt.print("\nYou made the trek to the nearest town. It's cozy, homely, and with plenty of resources lining the street.");
        GraphicsAttempt.print("Releasing a sigh, you head in the direction you wanted to visit.");
        GraphicsAttempt.print("\nWhere are you heading?");
        GraphicsAttempt.print("\n1. Pharmacy");
        GraphicsAttempt.print("2. Convenience Store");
        GraphicsAttempt.print("3. Well");

        Scanner in = new Scanner (System.in);
        int thing = in.nextInt();

        switch(thing)
        {
            case 1:
                GraphicsAttempt.print("Stepping in to the pharmacy, you purchase a bottle of energy boost and a local antidote.");
                GraphicsAttempt.print("Downing it, you feel a little more energized.");
                player.setHP("gain");
                break;
            case 2:
                GraphicsAttempt.print("You enter the convenience store. After browsing the store, you purchase the food you desired.");
                GraphicsAttempt.print("The person at the counter checks you out and sees you out with a wave. Well, there's some food for a night.");
                player.setFood("gain");
                break;
            case 3:
                GraphicsAttempt.print("Arriving at the well, you pull at the rope to heave a bucket of fresh water up to the surface.");
                GraphicsAttempt.print("Once there, you dip your flask and refill it. Though once refilled, you take a much needed swig.");
                GraphicsAttempt.print("Smacking your lips, you refill it again then twist it close with a flick of your wrist.");
                player.setWater("gain");
                break;
        }
    }
}
