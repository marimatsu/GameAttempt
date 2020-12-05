/**
 *      I made this to prepare cause the GameStructure will eventually require the stats of the character
 * for the minigame method or recharge method. 
 */

public class Character 
{
    int food, hp, water;

    public Character(int food, int hp, int water)
    {
        this.food = food;
        this.hp = hp;
        this.water = water;
    }

    public Character()
    {
        this(30, 100, 30);
    }

    public int getFood()
    {
        return food;
    }

    public void setFood(String outcome)
    {
        int change = (int) (3 + (Math.random() * 5));

        if (outcome == "lose")
            change = -change;
        if (outcome == "ehh")
            change = -(change-2);
        
        if (food + change >= 30)
        {
            this.food = 30;
            System.out.println("\nYour food supplies have been refilled to the max!");
        }
        else 
        {
            if (food + change < 0)
            {
                food = food + change;
                System.out.println("You've lost too many supplies during your journey and starved as a result.");
                System.out.println("Better luck next time, traveler.");
            }
            else
            {
                this.food = food + change;
                System.out.println("You have " + getFood() + " food supplies left.");
            }
        }
    }

    public int getHP()
    {
        return hp;
    }

    public void setHP(String outcome)
    {
        int change = (int) (Math.random() * (10-6) + 6);
        
        if (outcome == "lose")
            change = -change;
        if (outcome == "ehh")
            change = -(change-5);

        if (hp + change >= 100)
        {
            this.hp = 100;
            System.out.println("\nYour HP is maxed out!");
        }   
        else
        {
            if (hp + change < 0)
            {
                System.out.println("The journey has been perilous and you've suffered for a while.");
                System.out.println("Rest now, traveler, you've done well but better luck next time.");
            }
            else
            {
                this.hp = hp + change;
                System.out.println("You have " + getHP() + " HP left.");
            }
        }    
    }

    public int getWater()
    {
        return water;
    }

    public void setWater(String outcome)
    {
        int change = (int) (3 + (Math.random() * 5));
        if (outcome == "lose")
            change = -change;
        if (outcome == "ehh")
            change = -(change-2);

        if (water + change >= 30)
        {
            this.water = 30;
            System.out.println("\nYour water has been refilled to the max.");
        }
        else
        {
            if (water + change < 0)
            {
                water = water + change;
                System.out.println("Water's a very important part of survival that people tend to forget.");
                System.out.println("Please remember to stay hydrated and better luck next time, traveler.");
            }
            else
            {
                this.water = water + change;
                System.out.println("You have " + getWater() + " cups of water left.");
            }
        }
    }
}
