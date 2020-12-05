import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class StartScene 
{
    public static Scene makeScene()
    {
        Group root = new Group();
        Scene theScene = new Scene(root);

        Canvas canvas = new Canvas(1000, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        GraphicsContext gc2 = canvas.getGraphicsContext2D();

        Image background = new Image("Images/wildwildwest.png", 1000, 500, true, false);

        gc.drawImage(background, 0, 0);
        gc.setFill(Color.WHEAT);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        Font theFont = Font.font("Rog Fonts", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("Welcome to Silicon Valley!", 200, 50);
        gc.strokeText("Welcome to Silicon Valley!", 200, 50);

        gc2.setFill(Color.WHEAT);
        gc2.setStroke(Color.BLACK);
        gc2.setLineWidth(2);
        Font smallerFont = Font.font("Rog Fonts", FontWeight.BOLD, 30);
        gc.setFont(smallerFont);
        gc2.fillText("[Press SPACE to continue]", 300, 450);
        gc2.strokeText("[Press SPACE to continue]", 300, 450);

        return theScene;
    }
}
