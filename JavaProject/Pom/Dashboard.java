
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Dashboard extends BorderPane {
    Participant participant;
    Dashboard dashboard;
    Loginpage loginpage;
    AddImage addImage;
    Profile profile;
    Reset   resetPane;
    HBox centerTable;

    ArrayList<Exam> oldExam;
    ExamCreationModule createExam;


    public Dashboard(Stage window, User user) throws ClassNotFoundException, IOException {

        super.getStylesheets().add("DarkTheme.css");
        super.setStyle("-fx-background-color: rgb(54, 57, 63, 1.0);");
        //this.getStyleClass().addAll("middleLayoutCenter");

        TableView<Subject> tablecourse;
        for (int i = 0; i < user.getUserSubject().size(); i++) {
            System.out.println(user.getUserSubject().get(i).toString());
        }
        Menu setting = new Menu("settings");


        MenuItem edit = new MenuItem("Edit Profile");
        edit.setOnAction(e -> {
            profile = new Profile(window, user);
            profile.getStylesheets().add("DarkTheme.css");
            profile.setStyle("-fx-background-color: rgb(54, 57, 63, 1.0);");
            window.setScene(new Scene(profile, 600, 600));
        });

        MenuItem reset = new MenuItem("Reset Password");
        reset.setOnAction(e ->{
            resetPane = new Reset(window,user,true);
            resetPane.getStylesheets().add("DarkTheme.css");
            resetPane.setStyle("-fx-background-color: rgb(54, 57, 63, 1.0);");
            window.setScene(new Scene(resetPane, 600, 600));
        });

        MenuItem logout = new MenuItem("Logout");
        logout.setOnAction(e -> {
            try {
                loginpage = new Loginpage(window);
                loginpage.getStylesheets().add("DarkTheme.css");
                loginpage.setStyle("-fx-background-color: rgb(54, 57, 63, 1.0);");
                window.setScene(new Scene(loginpage, 600, 400));
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> {
            boolean exor = AlertBoxError.confirm("Exit", "Are you sure?");
            if (exor)
                window.close();
        });

        setting.getItems().addAll(edit, reset, logout, exit);
        MenuBar rightBar = new MenuBar();
        rightBar.getMenus().addAll(setting);
        Region spacer = new Region();
        spacer.getStyleClass().add("menu-bar");
        HBox.setHgrow(spacer, Priority.SOMETIMES);
        HBox menubars = new HBox(spacer, rightBar);

        VBox info = new VBox(20);
        info.getStylesheets().add("DarkTheme.css");
        info.setStyle("-fx-background-color: rgb(32, 34, 37, 1.0);");

        info.setAlignment(Pos.TOP_CENTER);
        info.setPadding(new Insets(25, 25, 25, 25));
        ImageView pic;
        try {
            pic = new ImageView(new Image(user.getPicture()));
        } catch (IllegalArgumentException e) {
            AlertBoxError.display("Error", "Cannot find you directory file.\nI set other picture instead.");
            user.setPicture("Image/error404.jpg");
            AboutUser.updateUser(user);
            pic = new ImageView(new Image(user.getPicture()));
        }
        pic.setFitHeight(250);
        pic.setFitWidth(250);
        HBox forpic = new HBox(pic);
        forpic.setStyle("-fx-border-radius: 0;-fx-border-color: rgb(210, 136, 24, 1.0);-fx-border-width: 4;");
        forpic.setMaxSize(250, 250);
        Label id = new Label("ID : " + user.getUsername());
        id.setFont(Font.font("", FontWeight.BOLD, 18));
        Button change = new Button("Change Image");
        change.setOnAction(e -> {
            addImage = new AddImage(window,user);
            addImage.getStylesheets().add("DarkTheme.css");
            window.setScene(new Scene(addImage, 400, 400));
        });
        Label name = new Label("Name : " + user.getName());
        name.setFont(Font.font("", FontWeight.BOLD, 18));
        Label surname = new Label("Surname : " + user.getSurname());
        surname.setFont(Font.font("", FontWeight.BOLD, 18));
        Label address = new Label("Address : " + user.getAddress());
        address.setFont(Font.font("", FontWeight.BOLD, 18));
        Label email = new Label("Email : " + user.getEmail());
        email.setFont(Font.font("", FontWeight.BOLD, 18));
        Label tel = new Label("Tel-Number : " + user.getTel());
        tel.setFont(Font.font("", FontWeight.BOLD, 18));
        info.getChildren().addAll(id, forpic, change, name, surname, address, email, tel);
        info.setMaxWidth(300);
        info.setAlignment(Pos.CENTER);
        ScrollPane infoscroll = new ScrollPane(info);
        infoscroll.getStylesheets().add("BlackScrollPane.css");
        infoscroll.setStyle("-fx-background-color: transparent");
        setLeft(infoscroll);
        infoscroll.setMaxWidth(300);
        info.prefHeightProperty().bind(infoscroll.heightProperty());

        Button parti = new Button("Participant");
        parti.setOnAction(e -> {
            try {
                participant = new Participant(window,user);
                participant.getStylesheets().add("DarkTheme.css");

                window.setScene(new Scene(participant, 1280, 720));
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });
        
        HBox btn = new HBox(10);
        btn.getChildren().addAll(parti);
        btn.setAlignment(Pos.CENTER);
        btn.setPadding(new Insets(24, 24, 24, 24));
        VBox dash = new VBox(12);
        dash.getChildren().addAll(btn);
        dash.setAlignment(Pos.TOP_CENTER);

        // Topic Column
        TableColumn<Subject, String> topiccolumn = new TableColumn<>("Topic");
        topiccolumn.setMinWidth(300);
        topiccolumn.setCellValueFactory(new PropertyValueFactory<>("topicName"));

        // Topic Column
        TableColumn<Subject, String> subjectcolumn = new TableColumn<>("Subject");
        subjectcolumn.setMinWidth(300);
        subjectcolumn.setCellValueFactory(new PropertyValueFactory<>("subjectString"));

        
        tablecourse = new TableView<>();
        tablecourse.setItems(Tabledash.getSubject(user));
        tablecourse.getColumns().addAll(topiccolumn, subjectcolumn);

        Button delete = new Button("Delete");
        delete.setOnAction(e -> {
            try {

                ObservableList<Subject> subselect;
                subselect = tablecourse.getSelectionModel().getSelectedItems();
                tablecourse.getItems().remove(subselect);
                for (int i = 0; i < user.getUserSubject().size(); i++) {
                    if (tablecourse.getSelectionModel().getSelectedItem().getSubjectString()
                            .equals(user.getUserSubject().get(i).getSubjectString())) {
                        user.getUserSubject().remove(i);
                    }
                }
                try {
                    AboutUser.updateUser(user);
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    dashboard = new Dashboard(window, user);
                    dashboard.getStylesheets().add("DarkTheme.css");
                    window.setScene(new Scene(dashboard, 1280, 720));
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }

            } catch (NullPointerException c) {
                AlertBoxError.display("Error", "Please Select Subject");
            }
        });

        Button guidetable = new Button("Guide");
        guidetable.setOnAction(e ->{
            try {

                if (!tablecourse.getSelectionModel().getSelectedItem().getSubjectString().equals(null)) {
                    try {

                        window.setScene(new Scene(
                                new Guide(tablecourse.getSelectionModel().getSelectedItem().getSubjectString(), user,
                                        window),
                                1280, 720));
                    } catch (ClassNotFoundException | IOException e1) {
                        e1.printStackTrace();
                    }
                }

            } catch (NullPointerException c) {
                AlertBoxError.display("Error", "Please Select Subject");
            }
        });
        Button testtable = new Button("Test");
        testtable.setOnAction(e ->{
            try {
                oldExam = new ArrayList<>();
                try {
                    oldExam = Course.readExam();
                } catch (ClassNotFoundException | IOException e1) {
                    e1.printStackTrace();
                }
                if (!tablecourse.getSelectionModel().getSelectedItem().getSubjectString().equals(null)) {
                    boolean check = false;
                    ExamCreationModule createExam = new ExamCreationModule(window);
                    for (int i = 0; i < oldExam.size(); i++) {
                        if (oldExam.get(i).getSubjectname()
                                .equals(tablecourse.getSelectionModel().getSelectedItem().getSubjectString())) {
                            createExam.setExam(oldExam.get(i));
                            check = true;
                            break;
                        }
                    }
                    if (check == false) {
                        AlertBoxError.display("Cannot Do it !", "Teacher has not create Exam yet.");
                    } else {
                        ExaminationModule student = new ExaminationModule(window);
                        student.setExam(createExam.getExam());
                        window.setScene(new Scene(student));
                        student.setSubmitButtonEvent(b -> {
                            try {
                                if (user.getTeacher() == false) {
                                    Dashboard dashboard = new Dashboard(window, user);
                                    dashboard.getStylesheets().add("DarkTheme.css");
                                    window.setScene(new Scene(dashboard, 1280, 720));
                                } else {
                                    TeacherDashboard a = new TeacherDashboard(window, user);
                                    a.getStylesheets().add("DarkTheme.css");
                                    window.setScene(new Scene(a, 1280, 720));
                                }
                            } catch (ClassNotFoundException | IOException e1) {
                                e1.printStackTrace();
                            }
                            AlertBoxError.display("Score", "Your Score is " + student.getPercentage() + "%");
                            
                            user.setUserScore(tablecourse.getSelectionModel().getSelectedItem().getSubjectString(),
                                    Double.toString(student.getPercentage()));
                            try {
                                System.out.println(Double.toString(student.getPercentage()));
                                AboutUser.updateUser(user);
                               System.out.println(user.getUserScore(tablecourse.getSelectionModel().getSelectedItem().getSubjectString()));
                            } catch (ClassNotFoundException | IOException e1) {
                                e1.printStackTrace();
                            }
                    });
                }
                
            }
                } catch (NullPointerException c) {
                    AlertBoxError.display("Error", "Please Select Subject");
            } 
        });
        HBox tablebtn = new HBox();
        tablebtn.setPadding(new Insets(8, 8, 8, 8));
        tablebtn.setSpacing(10);
        tablebtn.getChildren().addAll(delete,guidetable,testtable);
        tablebtn.setAlignment(Pos.CENTER);
        centerTable = new HBox();

        centerTable.setAlignment(Pos.CENTER);
        centerTable.getChildren().addAll(tablecourse);
        dash.getChildren().addAll(centerTable,tablebtn);
        dash.setMinSize(900,500);
        dash.setAlignment(Pos.TOP_CENTER);
        setCenter(dash);
        setTop(menubars);
        
    }

}

