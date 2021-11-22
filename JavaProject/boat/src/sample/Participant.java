package sample;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Participant extends BorderPane {

    Stage window;
    User user;
    Center center;
    // ---------------------------------------------------<< PANE LAYOUT
    // >>---------------------------------------------------------//

    VBox middleLayout_right = new VBox(50);
    VBox middleLayout_Left = new VBox(20);

    HBox middleLayout_Center = new HBox();
    HBox insideLayout_Center = new HBox(40);
    ScrollPane scrollPaneMiddleLayout_left = new ScrollPane(middleLayout_Left);

    HBox middleLayout_Bottom = new HBox(10);
    // ------------------------------------------------------<< BUTTON
    // >>------------------------------------------------------//

    Button addTopicButton = new Button("Add Topic");
    Button addSubjectButton = new Button("Add subject");
    Button deleteTopic = new Button("delete topic");
    Button deleteSubject = new Button("delete subject");
    Button goToDashBoard = new Button("Back");

    ArrayList<RadioButton> topicRadiobuttonArraylist = new ArrayList<>();
    ToggleGroup toggleGroup = new ToggleGroup();
    private ArrayList<Topic> allTopic;
    ArrayList<ImageView> imageViewArrayList = new ArrayList<>();
    ArrayList<Button> buttonArrayList = new ArrayList<>();

    // ------------------------------------------------------<< NOT ALREADY SET
    // >>------------------------------------------------------//
    ArrayList<VBox> layoutInsideCenter_vBoxArrayList = new ArrayList<>();
    ArrayList<EventHandler<ActionEvent>> actionEventArrayList = new ArrayList<>();
    ArrayList<ImageView> imageInside_Vbox_imageViewArrayList = new ArrayList<>();
    ArrayList<VBox> middleLayoutVbox_Center = new ArrayList<>();
    ArrayList<Label> labelArrayList = new ArrayList<>();
    ArrayList<HBox> rollHBoxArrayList = new ArrayList<>();
    ArrayList<SubjectDetail> subjectDetailArrayList = new ArrayList<>();
    ArrayList<Scene> sceneArrayList = new ArrayList<>();
    VBox[] columnVbox = new VBox[5];
    Label[] label = new Label[5];
    int numberOfvBox = 0;
    int columnNumber = 0;
    int rollNumber = 0;
    int count = 0;





    ScrollPane scrollPaneMiddleLayout_Center = new ScrollPane();


    public void setVbox(Image image, Button button, EventHandler<ActionEvent> eventEventHandler) {
        button.setOnAction(eventEventHandler);
        this.buttonArrayList.add(button);
        this.actionEventArrayList.add(eventEventHandler);

        try {
            this.imageInside_Vbox_imageViewArrayList.add(new ImageView(image));
        } catch (Exception e) {
            System.out.println("cannot");
        }

    }

    public void createHbox(VBox vBox) {
        this.middleLayoutVbox_Center.add(vBox);

    }

    // ----------------------------------------------------------------------------------------------//

    // --------------------------------------------<< READ FILE
    // >>--------------------------------------------------//

    // ----------------------------------------------------------------------------------------------//

    // << CONSTRUCTURE >>//
    public Participant(Stage window, User user) throws IOException, ClassNotFoundException {
        this.user = user;
        this.allTopic = new ArrayList<>();
        this.allTopic = Course.readoldtopic();
        System.out.println("TOPIC SIZE : " + this.allTopic.size());
        this.window = window;
        this.getStylesheets().add("sample/Gui.css");


        // ------------------------------------------------------<< NOT ALREADY SET
        // >>------------------------------------------------------//

        // I MAKE SOME TRY IN LINES 125-188 MAYBE YOUCAN READ CLASS Panescene 3 LINE [68
        // - 109] and [110-132] And IF YOU CAN COPY THAT
        // BY LOOK Main CLASS LINE [25,26] AND [87 - 134]
        // MAYBE IT WILLBE FAST

//        for (int i = 0; i < this.allTopic.size(); i++) {
//            if (topicRadiobuttonArraylist.get(i).isSelected()) {
//                center = new Center(window, user,allTopic.get(i));
//
//
//            }
//        }


        for (int i = 0; i < this.allTopic.size(); i++) {
            this.topicRadiobuttonArraylist.add(new RadioButton(this.allTopic.get(i).getTopicName()));
            this.topicRadiobuttonArraylist.get(i).setToggleGroup(toggleGroup);
            topicRadiobuttonArraylist.get(i).getStyleClass().addAll("topicRadiobuttonArraylist");
            middleLayout_Left.getChildren().addAll(this.topicRadiobuttonArraylist.get(i));
            createHbox(new VBox(30));

           // scrollPaneMiddleLayout_Center.add(new ScrollPane());


           // middleLayoutVbox_Center.get(i).setAlignment(Pos.TOP_CENTER);
           // middleLayoutVbox_Center.get(i).setStyle("-fx-border-width: 5px; -fx-border-color: green");
           // middleLayoutVbox_Center.get(i).setMinSize(1725,1025);

           // scrollPaneMiddleLayout_Center.get(i).setContent(middleLayoutVbox_Center.get(i));




            int finalI = i;
            int finalI1 = i;
            topicRadiobuttonArraylist.get(i).setOnAction(actionEvent -> {
                try {
                    center = new Center(window, user,allTopic.get(finalI));
                    center.getStylesheets().add("sample/Gui.css");
                    center.getStyleClass().addAll("middleLayoutCenter");
                    center.setMinSize(1750,1250);
                    center.resize(600,600);


                    scrollPaneMiddleLayout_Center.setContent(center);
                   // scrollPaneMiddleLayout_Center.setal
                    //scrollPaneMiddleLayout_Center.setStyle("-fx-background-color: lawngreen");
                    scrollPaneMiddleLayout_Center.getStylesheets().add("sample/Gui.css");
                    scrollPaneMiddleLayout_Center.getStyleClass().addAll("middleLayoutCenter");
                    middleLayout_Center.getStylesheets().add("sample/Gui.css");
                    middleLayout_Center.getStyleClass().addAll("middleLayoutCenter");
                    middleLayout_Center.setAlignment(Pos.TOP_CENTER);

                    setCenter(scrollPaneMiddleLayout_Center);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                System.out.println("topicRadiobutton Number :   [" + finalI + "]    is choosing now");

            });
        }


//        for (int j = 0; j < allTopic.size(); j++) {
//            System.out.println("loop J " + j + " -------------------------------------------------------------------");
//            labelArrayList.clear();
//            rollNumber = 0;
//            columnNumber = 0;
//            numberOfvBox = 0;
//            rollHBoxArrayList.clear();
//            // vvBoxArrayList.clear();
//
//            for (int i = 0; i < allTopic.get(j).getSubjectArrayList().size(); i++) {
//
//                System.out.println(
//                        "loop I " + i + " -------------------------------------------------------------------");
//
//                if (allTopic.get(j).getSubjectArrayList().get(i).getTopicName()
//                        .equals(allTopic.get(j).getTopicName())) {
//                    System.out.println("inside loop i " + i
//                            + " -------------------------------------------------------------------");
//
//                    System.out.println(allTopic.get(j).getSubjectArrayList().get(i).toString());
//
//                    subjectDetailArrayList.add(new SubjectDetail(window, user));
//                    subjectDetailArrayList.get(count).getStylesheets().add("sample/Gui.css");
//                    subjectDetailArrayList.get(count).setTopicText(("YoLo Topic"));
//                    subjectDetailArrayList.get(count).setTopicText(allTopic.get(j).getSubjectArrayList().get(i).getSubjectString());
//                    subjectDetailArrayList.get(count).setMainText(allTopic.get(j).getSubjectArrayList().get(i).getDetailSubjectString());
//                    sceneArrayList.add(new Scene(subjectDetailArrayList.get(count), 1280, 720));
//
//                    try {
//                        subjectDetailArrayList.get(count).setImageSubjectView(new Image(allTopic.get(j).getSubjectArrayList().get(i).getSubjectPicture()));
//                    } catch (IllegalArgumentException e) {
//                        AlertBoxError.display("Error", "Cannot find you directory file.\nI set other picture instead.");
//                        allTopic.get(j).getSubjectArrayList().get(i).setSubjectPicture("Image/error404.jpg");
//                        subjectDetailArrayList.get(count).setImageSubjectView(new Image(allTopic.get(j).getSubjectArrayList().get(i).getSubjectPicture()));
//                        Course.updateTopic(allTopic.get(j).getSubjectArrayList().get(i));
//                    }
//                    try {
//                        subjectDetailArrayList.get(count).setImageTeacherView(new Image(allTopic.get(j).getSubjectArrayList().get(i).getSubjectPicture()));
//                    } catch (IllegalArgumentException e) {
//                        AlertBoxError.display("Error", "Cannot find you directory file.\nI set other picture instead.");
//                        allTopic.get(j).getSubjectArrayList().get(i).setSubjectPicture("Image/error404.jpg");
//                        subjectDetailArrayList.get(count).setImageTeacherView(new Image(allTopic.get(j).getSubjectArrayList().get(i).getSubjectPicture()));
//                        Course.updateTopic(allTopic.get(j).getSubjectArrayList().get(i));
//                    }
//                    subjectDetailArrayList.get(count).setSubject(allTopic.get(j).getSubjectArrayList().get(i));
//                    System.out.println(allTopic.get(j).getSubjectArrayList().get(i).toString());
//
//                    int finalI = i;
//
//
//
//
//
//                    setVbox(new Image(allTopic.get(j).getSubjectArrayList().get(i).getSubjectPicture()),
//                            new Button(allTopic.get(j).getSubjectArrayList().get(i).getSubjectString()),
//                            actionEvent -> {
//                                window.setScene(sceneArrayList.get(count));
//                            });
//
//                    count++;
//
//                    imageInside_Vbox_imageViewArrayList.get(i).setFitWidth(300);
//                    imageInside_Vbox_imageViewArrayList.get(i).setFitHeight(300);
//
//
//
//                    if (columnNumber % 5 == 0) {
//                        columnNumber = 0;
//                    }
//                    if (columnNumber % 5 == 0) {
//                        rollHBoxArrayList.add(new HBox(30));
//                    }
//                    rollNumber = numberOfvBox / 5;
//
//                    // HAVE ENOUGH 4 COLUMNS IN 1 ROLLS
//                    columnVbox[columnNumber] = new VBox(20);
//                    columnVbox[columnNumber].getStylesheets().add("sample/Gui.css");
//                    columnVbox[columnNumber].getStyleClass().addAll("vbox-yellow");
//                    columnVbox[columnNumber].setAlignment(Pos.CENTER);
//                    columnVbox[columnNumber].setStyle("-fx-border-width: 2px; -fx-border-color: red");
//                    columnVbox[columnNumber].getChildren().addAll(imageInside_Vbox_imageViewArrayList.get(i), buttonArrayList.get(i));
//                    rollHBoxArrayList.get(rollNumber).getChildren().addAll(columnVbox[columnNumber]);
//
//                    if (columnNumber % 5 == 0) {
//                        middleLayoutVbox_Center.get(j).getChildren().addAll(rollHBoxArrayList.get(rollNumber));
//                    }
//                    columnNumber++;
//                    numberOfvBox++;
//
//                    System.out.println(rollHBoxArrayList.size());
//
//                    System.out.println("modnumber" + columnNumber);
//                    System.out.println("numberofVbox" + numberOfvBox);
//                    System.out.println("DEtailsubject size" + subjectDetailArrayList.size());
//
//                }
//
//            }
//
//        }

        // ---------------------------------------------IN LEFT OF
        // PANE-------------------------------------------------//

        middleLayout_Left.setPadding(new Insets(5, 20, 5, 5));
        middleLayout_Left.setMinSize(30,1020);
        middleLayout_Left.setStyle("-fx-border-width: 2px; -fx-border-color: green");
        middleLayout_Left.getStylesheets().add("sample/Gui.css");
        middleLayout_Left.getStyleClass().addAll("vbox-yellow");


        // ------------------------------------------------------------------------------------------------------------//



        addTopicButton.setRotate(-45);
        addSubjectButton.setRotate(-45);
        deleteTopic.setRotate(-45);
        deleteSubject.setRotate(-45);
        middleLayout_right.setAlignment(Pos.CENTER);
        middleLayout_right.getChildren().addAll(addTopicButton, addSubjectButton, deleteTopic, deleteSubject);
        middleLayout_right.setStyle("-fx-border-width: 2px; -fx-border-color: green");

        // GO TO ALERTBOX CLASS FOR ADD TOPIC
        addTopicButton.setOnAction(actionEvent -> {
            if (user.getTeacher() == true) {
                window.setScene(new Scene(new AlertBox(window, user), 700, 700));
            } else {
                AlertBoxError.display("Error", "You are not a teacher.");
            }
        });

        // CHECK TOPIC(RADIO BUTTON) IS CHOOSING
        addSubjectButton.setOnAction(actionEvent1 -> {
            if (user.getTeacher() == true) {
                boolean check = false;
                Topic editTopic = null;
                for (int i = 0; i < this.allTopic.size(); i++) {
                    if (topicRadiobuttonArraylist.get(i).isSelected()) {
                        check = true;
                        editTopic = this.allTopic.get(i);
                        break;
                    }
                }
                // IF YOU DID'T CHOOSE TOPIC(RADIO BUTTON) BEFORE. YOU WILL SEE PANE IN STATIC
                // METHOD IN Alertbox Class line[141 - 164]
                if (check == false) {
                    AlertBox.alertBoxAddCourse();
                }
                // IF YOU CHOOSE TOPIC(RADIO BUTTON) BEFORE. YOU WILL SEE PANE IN CONSTRUCTOR IN
                // Alertbox Class line [71-137]
                else {
                    System.out.println("Can Add Subject in Topic");
                    window.setScene(new Scene(new AddSubjectPane(window, editTopic, user), 700, 700));
                }
            } else {
                AlertBoxError.display("Error", "You are not a teacher.");
            }
        });

        deleteTopic.setOnAction(e -> {
            if (user.getTeacher() == true) {
                boolean check = false;
                Topic selected = null;
                for (int i = 0; i < this.allTopic.size(); i++) {
                    if (topicRadiobuttonArraylist.get(i).isSelected()) {
                        check = true;
                        selected = this.allTopic.get(i);
                        break;
                    }
                }
                if (check == false) {
                    AlertBox.alertBoxAddCourse();
                } else {
                    boolean ok = AlertBoxError.confirm("Please Read!", "Are you sure?");
                    if(ok == true){
                        try {
                            Course.deleteTopic(selected);
                            window.setScene(new Scene(new Participant(window, user)));
                        } catch (ClassNotFoundException | IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            } else {
                AlertBoxError.display("Error", "You are not a teacher.");
            }
        });

        // ------------------------------------------------------IN CENTER OF
        // Pane------------------------------------------------------//

        insideLayout_Center.setStyle("-fx-border-width: 2px; -fx-border-color: red");
        insideLayout_Center.setAlignment(Pos.CENTER);
        middleLayout_Center.setAlignment(Pos.CENTER);
        middleLayout_Center.getChildren().addAll(insideLayout_Center);
        middleLayout_Center.setStyle("-fx-border-width: 2px; -fx-border-color: yellow");
        middleLayout_Center.setMinSize(500, 500);
        middleLayout_Center.getStylesheets().add("sample/Gui.css");
        middleLayout_Center.getStyleClass().addAll("middleLayoutCenter");

        // -------------------------------------------------------IN BOTTOM
        // PANE-----------------------------------------------------//

        middleLayout_Bottom.setStyle("-fx-border-width: 2px; -fx-border-color: yellow");
        middleLayout_Bottom.setAlignment(Pos.CENTER_LEFT);
        middleLayout_Bottom.getChildren().addAll(goToDashBoard);

        goToDashBoard.setOnAction(actionEvent -> {
            try {
                window.setScene(new Scene(new Dashboard(window, user), 1280, 720));
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
        });
        //------------------------------------------------------------------------------------------------------------//


        //scrollPaneMiddleLayout_left.getStylesheets().add("sample/Gui.css");
       // scrollPaneMiddleLayout_left.getStyleClass().addAll("middleLayoutCenter");





        setBottom(middleLayout_Bottom);
        setLeft(scrollPaneMiddleLayout_left);
        setCenter(middleLayout_Center);




        setRight(middleLayout_right);


    }
}



