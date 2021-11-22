import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.*;
import javafx.stage.Stage;


import java.util.ArrayList;


public class Test extends Application {
    Stage window;
    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        VBox vBox = new VBox();
        HBox hBox = new HBox();
        TextField tf = new TextField();
        Text text = new Text("1. Who's Thai Prime Minister?");
        Text text1 = new Text(" A. Prayuth");
        Text text2 = new Text(" B. Loong Tou");
        Text text3 = new Text(" C. Big Tou");
        BlockLine line1 = new BlockLine();
        text.setFill(Color.rgb(250, 250, 250));
        text1.setFill(Color.rgb(233, 233, 233));
        text2.setFill(Color.rgb(233, 233, 233));
        text3.setFill(Color.rgb(233, 233, 233));
        vBox.setStyle("-fx-background-color: #36393F;");
        vBox.setPadding(new Insets(12, 12, 12, 12));
        Button b = new Button("Button");
        ScrollPane sp = new ScrollPane();
        
        tf.getStylesheets().add("TextField-DarkTheme.css");
        
        b.getStylesheets().add("Button-DarkTheme.css");
        //Font font = Font.loadFont(getClass().getResourceAsStream("/RedRock.tff"), 20);
        RadioButton r = new RadioButton();
        r.setText("What ?");
        r.setStyle("-fx-text-fill:  #FFFFFF;");
        //tf.setFont(font);

        VBox box = new VBox();
        Button b1 = new Button("First");
        Button b2 = new Button("Second");
        box.getChildren().add(b1);
        b1.setOnAction(e -> {
            box.getChildren().clear();
            box.getChildren().add(b2);
            System.out.println("First");
        });
        b2.setOnAction(e -> {
                box.getChildren().clear();
                box.getChildren().add(b1);
                System.out.println("Second");
        });

        YellowButton yb = new YellowButton("Yes!!!");
        YellowButton pb = new YellowButton("+");

        vBox.getChildren().addAll(text, text1, text2, text3, line1, tf, b, r, box, yb, pb);

        ToggleGroup g = new ToggleGroup();
        
        Scene scene = new Scene(vBox, 800, 600);
        window.setScene(scene);
        window.show();
    }

}