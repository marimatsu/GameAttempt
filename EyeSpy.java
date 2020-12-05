import java.util.*;
public class EyeSpy
{
  public static ArrayList<String> questions = new ArrayList<String>();
  public int wins = 0;
  public int losses = 0;
  public int attempts = 0;

  public EyeSpy()
  {
    Scanner scan = new Scanner(System.in);
    String response;
    printInstructions();
    runEyeSpy();
    questions.clear();
  }

  public static void printInstructions()
  {
    System.out.println("You've run into a troll in the middle of the forest! He looks hungry, which makes you very nervous.");
    System.out.println("As you near the troll, he begins to call out to you:\n");
    
    System.out.println("--Stranger! I'm in the mood for a game right now. If you can beat me more times than you lose to me, I'll let you pass by me.");
    System.out.println("--If I beat YOU more, though, I'll attack you! The game is going to be Eye Spy.");

    System.out.println("It looks like you don't have a choice to play or not. The troll explains the rules.\n");
    System.out.println("--I will be \"looking\" into the forest around us, at all the random objects here. Then I'll choose one of those objects.");
    System.out.println("--You will be given a list of potential things I could have chosen to guess from. You want to guess what I've picked.");
    System.out.println("--Oh, and you can make up to three guesses with the help of some questions you can ask along the way.");
  }

  public void runEyeSpy()
  {
    Scanner scan = new Scanner(System.in);
    String computerChoice = generateComputerChoice();

    printOptions();
    System.out.println("\n--I picked an item! See if you can guess it.");

    questions.add("1. What color is the item you see?");
    questions.add("2. What size is the item you see?");
    questions.add("3. Is the item moving or unmoving?");
    boolean correct = false;
    int count = 0;
    while(!correct && !questions.isEmpty() && count != 3)
    {
      questionOrGuess(computerChoice);
      correct = makeAGuess(computerChoice);
      count++;
      attempts++;
    }
    if (correct == true)
      wins++;
    else
      losses++;
  }

  public static String generateComputerChoice()
  {
    String[] options = {"tall green tree", "tiny green frog", "small green bush", "massive green crocodile", "big green turtle", "small patch of green grass", "wide blue sky", "small blue puddle", "bright blue butterfly", "singing blue bird", "large blue lake", "large blue lizard", "shining yellow sun", "cheerful yellow daisy", "prowling yellow cat", "large yellow lion", "tall yellow sunflower", "tiny yellow puppy"};
    
    Random makeChoice = new Random();
    int select = makeChoice.nextInt(options.length);
    String choice = options[select];

    return choice;
  }

  public static void printOptions()
  {
    System.out.println("\nHere are your options that the troll might've picked!");
    System.out.println("Scroll up to look at these again if you need them.\n");
    
    System.out.println("tall green tree, tiny green frog, small green bush, massive green crocodile, big green turtle, small patch of green grass, wide blue sky, small blue puddle, bright blue butterfly, singing blue bird, large blue lake, large blue lizard, shining yellow sun, cheerful yellow daisy, prowling yellow cat, large yellow lion, tall yellow sunflower, tiny yellow puppy");
  }

  public static boolean makeAGuess(String computerChoice)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("\n--What is your guess? (Please type the whole thing)");
    String guess = scan.nextLine();

    boolean correct = computerChoice.equalsIgnoreCase(guess);
    if(correct)
    {
      System.out.println("--That's correct! You win!");
      return correct;
    }
    else
    {
      System.out.println("--That's incorrect.");
      return correct;
    }
  }

  public static void questionOrGuess(String computerChoice)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("\nWould you like to ask a question? (Please type yes or no)");
    String response = scan.next();

    if(response.charAt(0) == 'y' || response.charAt(0) == 'Y')
    {
      System.out.println("Please select one from the available questions (type its number):");
      System.out.println(questions.toString());
      int questionNum = scan.nextInt();
      switch(questionNum)
      {
        case 1:
        {
          System.out.println(questions.get(0));
          questions.remove(questions.get(0));
          questions.add(0, " ");
          colorQuestion(computerChoice);
          break;
        }
        case 2:
        {
          System.out.println(questions.get(1));
          questions.remove(questions.get(1));
          questions.add(1, " ");
          sizeQuestion(computerChoice);
          break;
        }
        case 3:
        {
          System.out.println(questions.get(2));
          questions.remove(questions.get(2));
          questions.add(2, " ");
          moveQuestion(computerChoice);
          break;
        }
        default:
        {
          System.out.println("I'm sorry. That's not a valid answer.");
        }
      }//End switch statement
    }
    else
    {
      System.out.println();
    }
  }

  public static void colorQuestion(String computerChoice)
  {
    if(computerChoice.contains("green"))
      System.out.println("\n--It is green!");
    else if(computerChoice.contains("blue"))
      System.out.println("\n--It is blue!");
    else if(computerChoice.contains("yellow"))
      System.out.println("\n--It is yellow!");
  }

  public static void sizeQuestion(String computerChoice)
  {
    if(computerChoice.contains("big") || computerChoice.contains("tall") || computerChoice.contains("massive") || computerChoice.contains("wide") || computerChoice.contains("large") || computerChoice.contains("shining"))
      System.out.println("\n--It is big!");
    else
      System.out.println("\n--It is small!");
  }

  public static void moveQuestion(String computerChoice)
  {
    if(computerChoice.contains("tree") || computerChoice.contains("bush") || computerChoice.contains("grass") || computerChoice.contains("sky") || computerChoice.contains("puddle") || computerChoice.contains("lake") || computerChoice.contains("sun") || computerChoice.contains("daisy") || computerChoice.contains("flower"))
      System.out.println("\n--It is unmoving!");
    else
      System.out.println("\n--It is moving!");
  }

  public String printEndMessage()
  {
    String result = "";
    if(attempts == 1)
    {
      System.out.println("\nYou've safely passed by the troll! He scowls at you as you walk by, unharmed");
      System.out.println("You're encouraged by the victory, and for some magical reason, you receive a gift!");
      result = "gain";
    }
    else if(attempts == 2)
    {
      System.out.println("\nYou've entertained him enough to pass, but he still swipes at you as you walk by.");
      System.out.println("You kind of lose a bit of stuff.");
      result = "ehh";
    }
    else
    {
      System.out.println("\nUnfortunately, you lost too often to the troll. He attacks with a huge grin, claws flashing at you as you desperately try to escape.");
      System.out.println("You manage to get past and lose the troll, but in the process you've been materially hurt.");
      result = "lose";
    }
    return result;
  }
}//end class
