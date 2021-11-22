import java.io.IOException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddImage extends BorderPane {
    Dashboard dashboard;
    Dashboard dashboard2;
    Dashboard dashboard3;
    public AddImage(Stage window, User user) {
        window.setTitle("Set Picture");
        super.getStylesheets().add("DarkTheme.css");
        super.setStyle("-fx-background-color: rgb(54, 57, 63, 1.0);");
        TextField getuser = new TextField();
        Label alertlogin = new Label("Image URL");
        

        Button enter = new Button("Enter");
        enter.setOnAction(e -> {
            if (getuser.getText().equals("") || getuser.getText().equals(null)) {
                AlertBoxError.display("Error", "Please Fillin Box");
            } else {
                user.setPicture(getuser.getText());
                try {
                    AboutUser.updateUser(user);
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    if (user.getTeacher()) {
                        TeacherDashboard td = new TeacherDashboard(window, user);
                        td.getStylesheets().add("DarkTheme.css");
                        window.setScene(new Scene(td, 1280, 720));
                    }
                    else {
                        dashboard = new Dashboard(window, user);
                        dashboard.getStylesheets().add("DarkTheme.css");
                        window.setScene(new Scene(dashboard, 1280, 720));
                    }
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Button exit = new Button("Back");
        exit.setOnAction(e -> {
            try {
                dashboard2 = new Dashboard(window, user);
                dashboard2.getStylesheets().add("DarkTheme.css");
                window.setScene(new Scene(dashboard2, 1280, 720));
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });
        
        window.setOnCloseRequest(e -> {
            try {
                dashboard3 = new Dashboard(window, user);
                dashboard3.getStylesheets().add("DarkTheme.css");
                window.setScene(new Scene(dashboard3, 1280, 720));
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });

        VBox layout = new VBox(12);
        layout.setPadding(new Insets(12, 12, 12, 12));
        HBox buttonBox = new HBox(12);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(enter, exit);
        layout.getChildren().addAll(getuser,alertlogin,buttonBox);
        layout.setAlignment(Pos.CENTER);

        setCenter(layout);
    }
}