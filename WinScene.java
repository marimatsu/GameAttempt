import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

public class WinScene 
{
    public static Parent makeScene()
    {
        Group root = new Group();

        Canvas canvas = new Canvas(1000, 500);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image background = new Image("Images/castle.png", 1000, 500, false, false);

        gc.drawImage(background, 0, 0);
        gc.setFill(Color.PEACHPUFF);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        Font theFont = Font.font("Rog Fonts", FontWeight.BOLD, 48);
        gc.setFont(theFont);
        gc.fillText("CONGRATULATIONS", 270, 50);
        gc.strokeText("CONGRATULATIONS", 270, 50);

        return root;
    }
}
