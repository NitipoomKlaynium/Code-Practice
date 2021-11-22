

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Student extends BorderPane {
    VBox layout = new VBox(15);
    ScrollPane tableview = new ScrollPane();
    TableView<User> userTable;
    TableView<Score> table;
    public Student(Stage window, User user, Subject subject) throws ClassNotFoundException, IOException {
        subject = Course.pullSubject(subject.getSubjectString());
        subject.addScore();
        System.out.println(subject.getScore());
        Text subjectname = new Text(subject.getSubjectString());

        TableColumn<User, String> topicID = new TableColumn<>("ID");
        topicID.setMinWidth(100);
        topicID.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn<User, String> topicname = new TableColumn<>("Name");
        topicname.setMinWidth(300);
        topicname.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<User, String> topicsurname = new TableColumn<>("Surname");
        topicsurname.setMinWidth(300);
        topicsurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        
       
        userTable = new TableView<>();
        userTable.setItems(Tabledash.getUser(subject));
        userTable.getColumns().addAll(topicID, topicname, topicsurname);
        
        TableColumn<Score, String> scColumn = new TableColumn<>("Score");
        scColumn.setMinWidth(50);
        scColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scColumn.setPrefWidth(50);
 
        table = new TableView<>();
        table.setItems(Tabledash.getScore(subject));   
        table.getColumns().add(scColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        Button back = new Button("Back");
        back.setOnAction(e -> {
            try {
                window.setScene(new Scene(new TeacherDashboard(window, user), 1280, 720));
            } catch (ClassNotFoundException | IOException e1) {
                e1.printStackTrace();
            }
        });

        HBox tablebox = new HBox();
        tablebox.getChildren().addAll(userTable,table);
        tablebox.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(subjectname,tablebox, back);
        layout.setAlignment(Pos.CENTER);

        setCenter(layout);
    }

}