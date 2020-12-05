import java.io.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GraphicsAttempt extends Application 
{
    public static TextArea gameText;
    public TextField userText;

    int roll;
    int numberOfMoves = 0;
    static Character player;
    static GameStructure gameMap;
    boolean movesLeft = true;
    boolean win = false;
    boolean dead = false;

    LinkedHashMap<String, Commands> commands = new LinkedHashMap<>();
    public static LinkedHashMap<String, ArrayList<String>> dialogue = new LinkedHashMap<>();

    public static void main(String[] args) {
        player = new Character();
        gameMap = new GameStructure(player);
        launch(GraphicsAttempt.class, args);
    }

    @Override
    public void start(Stage theStage) throws Exception {
        theStage.setTitle("Silicon Valley");
        Scene theScene = StartScene.makeScene();

        theStage.setScene(theScene);

            //replace with button
        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.SPACE)
                    theStage.setScene(new Scene(gameScene()));
            }
        });

        theStage.show();
    }

    public Parent gameScene() {
        Group game = new Group();

        Canvas canvas = new Canvas(1000, 500);
        game.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext gc2 = canvas.getGraphicsContext2D();

        Image backdrop = new Image("Images/forestThing.jpg", 1000, 370, false, false);
        Image dirt = new Image("Images/dirt.jpg", 1000, 365, false, false);
        gc.drawImage(backdrop, 0, 0);
        gc2.drawImage(dirt, 0, 365);

        gameText = new TextArea();
        gameText.setEditable(false);
        gameText.setPrefSize(1000, 100);
        gameText.setOpacity(0.75);

        userText = new TextField("Type here");
        userText.setFocusTraversable(true);
        userText.setPrefSize(1000, 0);
        userText.setOpacity(0.75);

        VBox box = new VBox(7, gameText, userText);
        box.setPrefSize(1000, 125);
        box.setPadding(new Insets(7));
        box.setLayoutY(372);
        
        //game.getChildren().add(userText);
        //game.getChildren().add(gameText);

        game.getChildren().add(box);

        initCommands();
        initGame();


        if(win)
            return WinScene.makeScene();

        userText.setOnAction(e ->
        {
            String input = userText.getText();
            userText.clear();

            onInput(input);
        });

        return game;
    }

    public void initGame() {

        gameMap.index = -1;
        print("Welcome to Silicon Valley!");
        print("You are going to be adventuring throughout an unknown world in this game. Your goal is to make it to the end of the world and survive!");
        print("You will have a set amount of hp, food supplies, and water supplies at the start of the journey. Keep track of them as you progress.");
        print("Various spaces you stop at may throw you into minigame scenarios, or may let you pause for a chance to recharge your character.");
        print("You only have 30 moves to make it to the end of the game, though, so be careful how many breaks you take!");
        print("If your health, food, or water reach 0, it's game over.");
        print("Can you survive the Silicon Valley?\n");
        print("Type 'roll' to roll or 'help' for more commands.");
    }

    public void initCommands()
    {
        commands.put("exit", new Commands("exit", "Close the game", Platform::exit));
        commands.put("roll", new Commands("roll", "Roll the dice", this::roll));
        commands.put("stats", new Commands("stats", "Display player stats", this::stats));
        commands.put("map", new Commands("map", "Tell player position", this::map));
    }

    public void onInput(String line)
    {
        if(commands.containsKey(line))
            commands.get(line).execute();
        else
            print("There is no such command.");
    }

    public static void print(String text) {
        gameText.appendText(text + "\n");
    }

    public void roll() {
        roll = DiceAndTimer.roll();
        numberOfMoves++;
        print("\nYou rolled across the map...");
        print("You rolled: " + roll);
        gameMap.index += roll;
        checkPosition();
    }

    public void stats() {
        print("Food left: " + player.getFood());
        print("HP left: " + player.getHP());
        print("Water left: " + player.getWater());
    }

    public void map() {
        print("You are at position " + (gameMap.index + 1) + " out of 25");
    }

    public void checkPosition()
    {
        if(gameMap.index >= 25)
        {
            print("\nCongratulations! You made it to the end of the Silicon Valley!!");
            print("Here's a reward for your win:");
            win = true;
        }
        else
        {
            print("beep boop");
            //gameMap.gameSpace(player);
            TextScen.food1();
        }
    }
}

