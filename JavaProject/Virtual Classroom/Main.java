/**
 * Main
 */

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage window;

    Scene signin;
    @Override
    public void start(Stage primaryStage) throws Exception, FileNotFoundException, IOException, ClassNotFoundException {

        window = primaryStage;
        Loginpage login = new Loginpage(window);
        signin = new Scene(login, 600, 400);
        window.setScene(signin);
        window.setTitle("Virtual Classroom");
        window.getIcons().add(new Image("/Image/icon.png"));
        
        window.show();
    }
    
}   

