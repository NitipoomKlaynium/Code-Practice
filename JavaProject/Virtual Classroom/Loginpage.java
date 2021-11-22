import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class Loginpage extends BorderPane {
    private PasswordField passin;
    private String showpass;
    Dashboard dashboard;
    Registerpage registerpage;
    Reset reset;

    public Loginpage(Stage window) throws FileNotFoundException, IOException, ClassNotFoundException {
        super.getStylesheets().add("DarkTheme.css");
        super.setStyle("-fx-background-color: rgb(54, 57, 63, 1.0);");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));


        Image titleImage_ = new Image("/Image/LoginPageTitle.png");
        ImageView titleImage = new ImageView(titleImage_);
        HBox titleBox = new HBox();
        titleBox.prefWidthProperty().bind(window.widthProperty());
        titleBox.setAlignment(Pos.CENTER);
        titleBox.getChildren().addAll(titleImage);
        grid.add(titleImage, 0, 0, 2, 1);

        Label userlab = new Label("    Username :");
        userlab.setFont(Font.font("", FontWeight.BOLD, 14));
        grid.add(userlab, 0, 1);

        TextField userin = new TextField();
        userin.setText(null);
        userin.setPromptText("Username");
        grid.add(userin, 1, 1);

        Label passlab = new Label("    Password :");
        passlab.setFont(Font.font("", FontWeight.BOLD, 14));
        grid.add(passlab, 0, 2);

        passin = new PasswordField();
        passin.setText(null);
        passin.setPromptText("Password");
        grid.add(passin, 1, 2);

        Button loginbtn = new Button("Sign in");
        loginbtn.setOnAction(e -> {

            try {
                if (userin.getText() == null || passin.getText() == null) {
                    AlertBoxError.display("Error", "Please fillin Username or Password");
                } else {
                    if (AboutUser.login(userin.getText(), passin.getText()) == true) {
                        User user = null;
                        user = getUser(userin.getText(), passin.getText());
                        if(user.getTeacher() == false){
                            dashboard = new Dashboard(window,user);
                            dashboard.getStylesheets().add("DarkTheme.css");
                            window.setScene(new Scene(dashboard, 1280, 720));
                        }
                        else{
                            TeacherDashboard a = new TeacherDashboard(window,user);
                            a.getStylesheets().add("DarkTheme.css");
                            window.setScene(new Scene(a, 1280, 720));
                        }
                    } else {
                        AlertBoxError.display("Error", "Invalid Username or Password");
                    }
                }
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });

        Hyperlink click = new Hyperlink("Click here");
        click.setStyle("-fx-text-fill: rgb(22, 149, 200, 1.0);");
        Label flowText = new Label("Don't have an account? ");
        flowText.setStyle("-fx-text-fill: rgb(255, 255, 255, 1.0);");
        TextFlow flow = new TextFlow(flowText, click);
        click.setOnAction(e -> {
            try {
                registerpage = new Registerpage(window);
                registerpage.getStylesheets().add("DarkTheme.css");
                window.setScene(new Scene(registerpage, window.getScene().getWidth(), window.getScene().getHeight()));
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });
        click.setOnMousePressed(e -> {
            click.setStyle("-fx-text-fill: rgb(255, 153, 0, 1.0);");
        });
        click.setOnMouseReleased(e -> {
            click.setStyle("-fx-text-fill: rgb(22, 149, 200, 1.0);");
        });

        Hyperlink clickf = new Hyperlink("Click here");
        clickf.setStyle("-fx-text-fill: rgb(22, 149, 200, 1.0);");
        Label flowfText = new Label("Forgot a Password? ");
        flowfText.setStyle("-fx-text-fill: rgb(255, 255, 255, 1.0);");
        TextFlow flowf = new TextFlow(flowfText, clickf);
        flowf.getChildren().get(0).setStyle("-fx-text-fill: rgb(255, 255, 255, 1.0);");
        clickf.setOnAction(e -> {
            try {
               String name = AlertBoxError.getUsernameforgot();
               if(name.equals(null) || name.equals("") || !AlertBoxError.check(name)){

               }
               else{
                   reset = new Reset(window,AboutUser.forgotPassword(name),false);
                   reset.getStylesheets().add("DarkTheme.css");

                   window.setScene(new Scene(reset));
               }
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });
        clickf.setOnMousePressed(e -> {
            clickf.setStyle("-fx-text-fill: rgb(255, 153, 0, 1.0);");
        });
        clickf.setOnMouseReleased(e -> {
            clickf.setStyle("-fx-text-fill: rgb(22, 149, 200, 1.0);");
        });
        HBox forget = new HBox();
        forget.setPadding(new Insets(8, 0, 0, 0));
        forget.setAlignment(Pos.CENTER);
        forget.getChildren().addAll(flowf);
        grid.add(forget, 1, 5);

        Button exit = new Button("Close the program");
        exit.setOnAction(e -> {
            boolean exor = AlertBoxError.confirm("Exit", "Are you sure?");
            if (exor)
                window.close();
        });

        window.setOnCloseRequest(e -> {
            e.consume();
            boolean exor = AlertBoxError.confirm("Exit", "Are you sure?");
            if (exor)
                window.close();
        });

        Hyperlink showpasslink = new Hyperlink("Show password");
        showpasslink.setStyle("-fx-text-fill: rgb(22, 149, 200, 1.0);");
        showpasslink.addEventFilter(MouseEvent.MOUSE_PRESSED, e ->{
            showpasslink.setStyle("-fx-text-fill: rgb(255, 153, 0, 1.0);");
            showpass = passin.getText();
            passin.setText(null);
            passin.setPromptText(showpass);
        });

        showpasslink.addEventFilter(MouseEvent.MOUSE_RELEASED, e ->{
            showpasslink.setStyle("-fx-text-fill: rgb(22, 149, 200, 1.0);");
            passin.setText(showpass);
            passin.setPromptText("Password");
        });
        grid.add(showpasslink, 0, 4);

        
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.CENTER);
        hbBtn.getChildren().addAll(loginbtn, exit);
        grid.add(hbBtn, 1, 4);
        HBox regis = new HBox();
        regis.setAlignment(Pos.CENTER);
        regis.getChildren().addAll(flow);
        grid.add(regis, 1, 6);

        setCenter(grid);
    }

    private User getUser(String username, String password) throws IOException, ClassNotFoundException {
        File file = new File("userdata.dat");
        User a = null;
        if(file.exists()){
            FileInputStream fin = new FileInputStream("userdata.dat");
            ObjectInputStream in = new ObjectInputStream(fin); 
            while(fin.available() != 0){
                a = (User)in.readObject();
                if(username.equals(a.getUsername()) && password.equals(a.getPassword())){
                    break;
                }
            }
            in.close();
        }
        return a;
    }
}