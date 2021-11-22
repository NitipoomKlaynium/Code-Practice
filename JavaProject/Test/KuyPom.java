
import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

//
//public class Main extends Application {
//    Stage window;
//    @Override
//    public void start(Stage primaryStage) throws Exception{
//
//        Button b1 = new Button("tryCatch");
//        Label label = new Label("JavaFX");
//
//        b1.setOnAction(actionEvent -> System.out.println(label.getText()));
//        HBox    hBox =new HBox();
//        hBox.getChildren().addAll(b1);
//        Scene scene = new Scene(hBox,600,300);
//        window = primaryStage;
//        window.setTitle("Hello World");
//        window.setScene(scene);
//        window.show();
//    }
//
//
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}


/*
public class Main extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane to hold the texts
        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 5, 5, 5));
        Text text1 = new Text(20, 20, "Programming is fun");
        text1.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.ITALIC, 15));
        pane.getChildren().add(text1);

        Text text2 = new Text(60, 60, "Programming is fun\nDisplay text");
        pane.getChildren().add(text2);

        Text text3 = new Text(10, 100, "Programming is fun\nDisplay text");
        text3.setFill(Color.RED);
        text3.setUnderline(true); // Underline for text3
        text3.setStrikethrough(true); // Strikethrough for text3
        pane.getChildren().add(text3);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        scene.setFill(Color.rgb(100,200,100));
        primaryStage.setTitle("ShowText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }



    public static void main(String[] args) {
        launch(args);
    }
}*/


public class KuyPom extends Application {

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{


        Aboutcourse aboutcourse = new Aboutcourse();
       // aboutcourse.setTopicText("REF");
        aboutcourse.setText(new Text(20,20,"afgsdxhsd"));
        //System.out.println(aboutcourse.getTopicText());
        Scene scene = new Scene(aboutcourse,700,500);
        scene.setFill(Color.rgb(100,200,100));
        //scene.setFill(Color.BLACK);
        window = primaryStage;
        window.setTitle("Hello World");
        window.setScene(scene);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
class Aboutcourse extends BorderPane{
    //String topicText ="";
    Text text = new Text();

    public Text getText() {
        return this.text;
    }

    public void setText(Text text) {
        this.text = text;
    }
//
//    public String getTopicText() {
//        return topicText;
//    }
//
//    public void setTopicText(String topicText) {
//        this.topicText = topicText;
//    }

    public Aboutcourse() {
        //<--------------------------------------->> MiddleLayout//<--------------------------------------->>
        //<--------------------------------------->>

        Text topicText = text;
        topicText.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.ITALIC, 20));
        topicText.setFill(Color.rgb(238,191,32));
        topicText.setUnderline(true); // Underline for text3
        HBox layoutMiddle_Top = new HBox();
        layoutMiddle_Top.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        layoutMiddle_Top.setPadding(new Insets(20,10,25,70));
        layoutMiddle_Top.getChildren().addAll(text);
        //<--------------------------------------->>

        Image imageRadio1 = new Image("Image/Programing.png");
        Image imageRadio2 = new Image("Image/Programing.png");
        ImageView imageRadioView1 = new ImageView(imageRadio1);
        ImageView imageRadioView2 = new ImageView(imageRadio2);
        imageRadioView1.setFitHeight(200);
        imageRadioView1.setFitWidth(250);
        imageRadioView2.setFitHeight(200);
        imageRadioView2.setFitWidth(250);
        HBox layoutMiddle_CenterTop = new HBox(60);
        layoutMiddle_CenterTop.setStyle("-fx-border-width: 2px; -fx-border-color: red");
       // layoutMiddle_Middle.setAlignment(Pos.CENTER);
        layoutMiddle_CenterTop.setPadding(new Insets(0,0,25,70));
        layoutMiddle_CenterTop.getChildren().addAll(imageRadioView1,imageRadioView2);

        //<--------------------------------------->>
        Text text2 = new Text(20, 20, "What's Programming");
        text2.setFont(Font.font("Courier", FontWeight.THIN,
                FontPosture.ITALIC, 20));
        text2.setFill(Color.rgb(238,191,32));

        HBox layoutMiddle_CenterBottom = new HBox();
        layoutMiddle_CenterBottom.setStyle("-fx-border-width: 2px; -fx-border-color: blue");
        layoutMiddle_CenterBottom.setPadding(new Insets(0,0,0,70));
        layoutMiddle_CenterBottom.getChildren().addAll(text2);

        //<--------------------------------------->> OutsideLayout//<--------------------------------------->>

        Button goToOverView =new Button("Back");

       // goToOverView.setAlignment(Pos.CENTER);
        HBox layoutOutside_Left = new HBox();
       // layoutOutside_Left.setSpacing(20);
        layoutOutside_Left.setStyle("-fx-border-width: 5px; -fx-border-color: purple");
        layoutOutside_Left.setAlignment(Pos.BOTTOM_LEFT);
        layoutOutside_Left.getChildren().addAll(goToOverView);

        //<--------------------------------------->>
        Button addCourse =new Button("Add Course");

        HBox layoutOutside_Right = new HBox();
        layoutOutside_Right.setStyle("-fx-border-width: 5px; -fx-border-color: green");
        layoutOutside_Right.setAlignment(Pos.BOTTOM_RIGHT);
        layoutOutside_Right.getChildren().addAll(addCourse);

        //<--------------------------------------->>

        VBox layoutOutside = new VBox(5);
        layoutOutside.setStyle("-fx-border-width: 2px; -fx-border-color: yellow");
        //layoutOutside.setAlignment(Pos.CENTER_LEFT);
        layoutOutside.getChildren().addAll(layoutMiddle_Top,layoutMiddle_CenterTop,layoutMiddle_CenterBottom);
        setTop(layoutOutside);
        setLeft(layoutOutside_Left);
        setRight(layoutOutside_Right);
        //<--------------------------------------->>



    }
}

