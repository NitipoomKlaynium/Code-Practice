import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class YellowButton extends Button {

    public YellowButton() {
        super();
        super.setStyle("-fx-background-color: rgb(255, 153, 0);");
        super.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        super.setMaxHeight(16);
    }

    public YellowButton(String text) {
        super(text);
        super.setStyle("-fx-background-color: rgb(255, 153, 0);");
        super.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        super.setMaxHeight(16);
    }
}